package com.elitecore.cpe.web.composer.master.warehouse;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Image;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.elitecore.cpe.bl.delegates.master.WareHouseBD;
import com.elitecore.cpe.bl.vo.master.WarehouseTypeVO;
import com.elitecore.cpe.util.logger.Logger;
import com.elitecore.cpe.web.base.ui.core.BaseSearchComposer;
import com.elitecore.cpe.web.base.ui.module.BaseConstants;
import com.elitecore.cpe.web.constants.ActionAlias;
import com.elitecore.cpe.web.constants.Pages;
import com.elitecore.cpe.web.core.exception.ModuleInitializationException;

public class SearchWarehouseTypeComposer  extends BaseSearchComposer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	private Window searchWareHouseType;
	private Textbox txtName;
//	private Textbox txtLocation;
	private Tab searchTab;
	
	private Listbox searchResultGrid;
	
	private Tabbox searchWarehouseTypeTabbox;
	
	@Override
	public void afterCompose(Window comp) throws ModuleInitializationException {
		System.out.println("in SearchWareHouse composer afterComposer");
	//	this.searchWareHouseType = comp;
		
		searchResultGrid.setVisible(false);
		if(isPermittedAction(ActionAlias.CREATE_WAREHOUSETYPE)) {
			addViewTab("-100", "Create WarehouseType", searchWarehouseTypeTabbox, Pages.CREATE_WAREHOUSETYPE_EVENT,null,false);
		}
		searchTab.setSelected(true);
	}

	public void onClick$btnCancel(Event event){
		resetComponents(txtName,txtName);
	}

	@Override
	public void onDoubleClickedSearchItem(Event event) throws Exception {
		
		
	}
	
	public void onClick$btnSearch(Event event) {
		
		Logger.logTrace("WAREHOUSE", "Inside btnSearch ");
		searchResultGrid.setEmptyMessage(Labels.getLabel("gen.norecordfound"));
		searchResultGrid.setVisible(true);
		
		WarehouseTypeVO data = new WarehouseTypeVO();
		WareHouseBD  wareHouseBD = new WareHouseBD(getBDSessionContext());
		data.setName(txtName.getValue());
		Logger.logTrace("WAREHOUSE", "calling BD ");
		List<WarehouseTypeVO> listWarehouseData = wareHouseBD.searchWarehouseTypeData(data);
		Logger.logTrace("WAREHOUSE", "after call "+listWarehouseData);
		if(listWarehouseData != null && !listWarehouseData.isEmpty()){
			searchResultGrid.setModel(new ListModelList<WarehouseTypeVO>(listWarehouseData));
			
			searchResultGrid.setItemRenderer(new SearchListItemRenderer());
		}else{
			searchResultGrid.setModel(new ListModelList<WarehouseTypeVO>());
		}
	}
	
	public void clickEdit(){
		Logger.logTrace("WAREHOUSE", "in clickEdit function...");
		
		if(searchResultGrid.getSelectedItem()!=null){
			WarehouseTypeVO wrapperVO =(WarehouseTypeVO) searchResultGrid.getSelectedItem().getValue();
			Map<String,Object> argMap = new HashMap<String, Object>();
			
			argMap.put(SEARCH_COMPOSER_REF, this);
			addViewTab(wrapperVO.getWarehouseTypeId(), wrapperVO.getName(), searchWarehouseTypeTabbox, Pages.VIEW_WAREHOUSETYPE_EVENT,argMap);
		}
		
	}
	
	private class SearchListItemRenderer implements ListitemRenderer<WarehouseTypeVO>{

		private EventListener<Event> editItemListener,editHoverListner,editOutListener;
		SimpleDateFormat dateFormat = new SimpleDateFormat(getDateTimeFormat());
		public SearchListItemRenderer() {
			
			editItemListener = new EventListener<Event>() {
				@Override
				public void onEvent(Event event) throws Exception {
				//	Image img = (Image) event.getTarget();
					clickEdit();
				}

			};
			
			editHoverListner = new EventListener<Event>() {
				
				@Override
				public void onEvent(Event event) throws Exception {
					Image img = (Image) event.getTarget();
					img.setSrc(BaseConstants.EDIT_ITEM_HOVER_IMAGE);
				}
			};
			
			editOutListener = new EventListener<Event>() {
				
				@Override
				public void onEvent(Event event) throws Exception {
					Image img = (Image) event.getTarget();
					img.setSrc(BaseConstants.EDIT_ITEM_IMAGE);
				}
			};
		}
		
		@Override
		public void render(Listitem item, WarehouseTypeVO data, int index)throws Exception {
			
			int no = index+1;
			item.appendChild(new Listcell(String.valueOf(no)));
			item.appendChild(new Listcell(data.getName()));
			item.appendChild(new Listcell(data.getDescription()));
			item.appendChild(new Listcell(dateFormat.format(data.getCreateDate())));
			Listcell operationCell = new Listcell();
			Image edit = new Image(BaseConstants.EDIT_ITEM_IMAGE);
			
			edit.addEventListener(Events.ON_MOUSE_OVER, editHoverListner);
			edit.addEventListener(Events.ON_MOUSE_OUT, editOutListener);
			edit.addEventListener(Events.ON_CLICK, editItemListener);
			
			operationCell.appendChild(edit);
			item.appendChild(operationCell);
			item.setValue(data);
		}
		
	}
}
