package com.elitecore.cpe.web.composer.inventory;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.elitecore.cpe.bl.data.common.ComboBoxData;
import com.elitecore.cpe.bl.delegates.inventorymgt.InventoryManagementBD;
import com.elitecore.cpe.bl.delegates.master.ItemBD;
import com.elitecore.cpe.bl.exception.CreateBLException;
import com.elitecore.cpe.bl.vo.inventorymgt.InventoryUploadVO;
import com.elitecore.cpe.bl.vo.master.AttributeVO;
import com.elitecore.cpe.core.IBDSessionContext;
import com.elitecore.cpe.util.CSVDataExporter;
import com.elitecore.cpe.util.logger.Logger;
import com.elitecore.cpe.web.base.ui.module.BaseModuleComposer;
import com.elitecore.cpe.web.constants.Pages;
import com.elitecore.cpe.web.core.exception.ModuleInitializationException;
import com.elitecore.cpe.web.utils.MessageUtility;

public class UploadInventoryComposer extends BaseModuleComposer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Window uploadInventory;
	private Textbox txtfileName;
	private Combobox cmbResourceName;
	private Media fileMedia;
	
	public void onClick$btnCancel(Event event){
		resetComponents(txtfileName,txtfileName,cmbResourceName);
	}
	public void onClick$btnCsvFormat(Event event){
		
		ItemBD  itemBD = new ItemBD(getBDSessionContext());
		List<AttributeVO> attributeVOs = null;
		try {
			if(cmbResourceName.getSelectedItem()!=null) {
				ComboBoxData comboData = cmbResourceName.getSelectedItem().getValue();
				attributeVOs =  itemBD.getAllAttributesfromResourceId(comboData.getId());
				System.out.println(attributeVOs);
			} /*commented today
			else {
				MessageUtility.failureInformation("ERROR", "Please select Resource name");
				return;
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			MessageUtility.failureInformation("ERROR", e.getMessage());
			return;
		}
		
		
		
		
		
		Map<String,Object> argMap = new HashMap<String, Object>();
		argMap.put(UploadInventoryCSVFormatComposer.ATTRIBUTEVO_DATA, attributeVOs);
		//argMap.put(UPLOAD_INVENTORY_COMPOSER_REF, auditWrapper);
		Window window = (Window)Executions.createComponents(Pages.VIEW_CSVFORMAT_EVENT, this.uploadInventory, argMap);
        window.doModal();
	}
	@Override
	public void afterCompose(Window comp) throws ModuleInitializationException {
		System.out.println("in UploadInventory composer afterCompose");
		this.uploadInventory = comp;
		
		ItemBD itemBD = new ItemBD(getBDSessionContext());
		List<ComboBoxData> comboDatas =  itemBD.getAllResourceData();
		if(comboDatas!=null && !comboDatas.isEmpty()) {
			cmbResourceName.setModel(new ListModelList<ComboBoxData>(comboDatas));
			cmbResourceName.setItemRenderer(new ComboBoxItemDataRenderer());
		}
	}
	
	public void onUpload$btnBrowse(UploadEvent event){
		System.out.println(" inside onUpload$btnBrowse function");
		
		fileMedia = event.getMedia();
        String strRead;
        String uploadId;
        String contentType;
        
        Logger.logTrace("Inventory","getName :"+fileMedia.getName());
        Logger.logTrace("Inventory","getFormat :"+fileMedia.getFormat());
        Logger.logTrace("Inventory","getContentType :"+fileMedia.getContentType());
        
        txtfileName.setValue(fileMedia.getName());
        /*if((fileMedia.getFormat().equalsIgnoreCase("txt") )
        		|| (fileMedia.getFormat().equalsIgnoreCase("csv") || (fileMedia.getFormat().equalsIgnoreCase("xls"))))
        {
	       
	        
        }else{
        	MessageUtility.failureInformation("ERROR", "Please Select CSV file");
        	fileMedia = null;
        }*/
	}
	
	public void onClick$btnUpload(Event event) {
		
		// validation
		if(txtfileName.getValue() == null || txtfileName.getValue().isEmpty() || fileMedia == null){
			MessageUtility.failureInformation("ERROR", "Please Select CSV file");
			return;
		}
		
		 //call to BD
		byte[] uploadbyteData = null;
		try {
			uploadbyteData =fileMedia.getByteData();
		}catch(IllegalStateException illegalStateException){
			uploadbyteData = fileMedia.getStringData().getBytes();
		}
		catch (Exception e) {}
		
        try {
        	IBDSessionContext ibdSessionContext = getBDSessionContext();
        	
			InventoryUploadVO uploadVO = new InventoryUploadVO();
			
			uploadVO.setUploadbyteData(uploadbyteData);
			uploadVO.setStaffId(ibdSessionContext.getBLSession().getSessionUserId());
			
        	InventoryManagementBD inventoryManagementBD = new InventoryManagementBD(ibdSessionContext);
        	InventoryUploadVO inventoryUploadVO2 = inventoryManagementBD.uploadInventory(uploadVO);
        	
        	MessageUtility.successInformation("Success", "Inventory Upload Successfully. \n Batch No : "+inventoryUploadVO2.getBatchNo()+"\n"+
        																				  " Valiad Entry :"+inventoryUploadVO2.getValidEntry()+"\n"+
        																				  " Invalid Entry :"+inventoryUploadVO2.getInvalidEntry());
        	
        	resetComponents(txtfileName, txtfileName,cmbResourceName);
        	fileMedia = null;
		} catch (CreateBLException e) {
			MessageUtility.failureInformation("ERROR", e.getMessage());
		}
		
	}
	
	public void onClick$btnDownload(Event event){
		try {
			
			String resourceNumber = "";
			
			ItemBD  itemBD = new ItemBD(getBDSessionContext());
			List<AttributeVO> attributeVOs = null;
			if(cmbResourceName.getSelectedItem()!=null) {
				ComboBoxData comboData = cmbResourceName.getSelectedItem().getValue();
				resourceNumber = comboData.getId();
				attributeVOs =  itemBD.getAllAttributesfromResourceId(comboData.getId());
			}/*else {
				MessageUtility.failureInformation("ERROR", "Please select Resource name");
				return;
			}
			
			 */
			File file = new File("Inventory.csv");
			CSVDataExporter exporter = new CSVDataExporter(file);
			String headers[] = {"Sr.No","External Batch No","Warehouse","Resource Number","Inventory Number","GuaranteeWarrantyMode","Warranty Date","Warranty Type"};
			List<String> headersList = new ArrayList<String>(Arrays.asList(headers));
			if(attributeVOs!=null && !attributeVOs.isEmpty()) {
				for(AttributeVO attributeVO : attributeVOs) {
					headersList.add(attributeVO.getName());
				}
			}
			exporter.append(headersList);
			
			for(int i=1;i<=5;i++) {
				
				List<String> valueList = new ArrayList<String>();
				valueList.add(i+"");
				valueList.add("BTC300008");
				valueList.add("Central");
				if(resourceNumber!=null && !resourceNumber.equals("")){
					valueList.add(resourceNumber);

				}
				else{
					valueList.add("RES000000006"+i);
				}
				valueList.add("INV00000"+i);
				if(i%2==0) {
					valueList.add("Warranty");
					valueList.add("21/01/2014");
					valueList.add("Supplier date");
				} else {
					valueList.add("Guarantee");
					valueList.add("");
					valueList.add("");
				}
				
				
				if(attributeVOs!=null) {
					for(int j=0;j<attributeVOs.size();j++) {
						valueList.add("TestValue"+i);
					}
				}
				exporter.append(valueList);
				
			}
			
			exporter.close();
			
			Filedownload.save(file, null);
		} catch (Exception e) {
			e.printStackTrace();
			MessageUtility.failureInformation("ERROR", e.getMessage());
		}
		
	}
	
}
