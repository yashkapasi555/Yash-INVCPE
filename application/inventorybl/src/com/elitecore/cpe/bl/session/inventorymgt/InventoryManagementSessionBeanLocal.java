package com.elitecore.cpe.bl.session.inventorymgt;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import com.elitecore.cpe.bl.entity.inventory.inventorymgt.InventoryData;
import com.elitecore.cpe.bl.entity.inventory.inventorymgt.InventoryReserveData;
import com.elitecore.cpe.bl.entity.inventory.inventorymgt.InventoryReserveDetailData;
import com.elitecore.cpe.bl.entity.inventory.inventorymgt.InventoryStatusLogData;
import com.elitecore.cpe.bl.entity.inventory.inventorymgt.OrderData;
import com.elitecore.cpe.bl.entity.inventory.inventorymgt.TransferOrderData;
import com.elitecore.cpe.bl.entity.inventory.inventorymgt.TransferOrderDetailData;
import com.elitecore.cpe.bl.entity.inventory.inventorymgt.WarehouseInventoryStatusData;
import com.elitecore.cpe.bl.entity.inventory.master.WarehouseData;
import com.elitecore.cpe.bl.entity.inventory.system.systemparameter.SystemParameter;
import com.elitecore.cpe.bl.exception.CreateBLException;
import com.elitecore.cpe.bl.exception.SearchBLException;
import com.elitecore.cpe.bl.exception.UpdateBLException;
import com.elitecore.cpe.bl.vo.inventorymgt.InventoryDetailVO;
import com.elitecore.cpe.bl.vo.inventorymgt.InventoryUploadVO;
import com.elitecore.cpe.bl.vo.inventorymgt.InventoryWrapperVO;
import com.elitecore.cpe.bl.vo.inventorymgt.PlaceOrderVO;
import com.elitecore.cpe.bl.vo.inventorymgt.SearchInventoryVO;
import com.elitecore.cpe.bl.vo.inventorymgt.SearchTransferInventory;
import com.elitecore.cpe.bl.vo.inventorymgt.SearchWarehouseInventoryStatusVO;
import com.elitecore.cpe.bl.vo.inventorymgt.TransferInventorySummaryViewVO;
import com.elitecore.cpe.bl.vo.inventorytransfer.PartialAcceptRejectTransferOrderVO;
import com.elitecore.cpe.bl.vo.order.OrderDetailVo;
import com.elitecore.cpe.bl.ws.data.input.request.InventoryDetailsRequestData;
import com.elitecore.cpe.bl.ws.data.input.response.InventoryStatusResponseVO;
import com.elitecore.cpe.bl.ws.data.input.response.InventoryStatusVO;
import com.elitecore.cpe.bl.ws.data.input.vo.CPEInventoryVO;
import com.elitecore.cpe.bl.ws.data.input.vo.InventoryRequestVO;
import com.elitecore.cpe.bl.ws.data.input.vo.ReleaseInventoryVO;
import com.elitecore.cpe.core.IBLSession;
import com.sun.rowset.CachedRowSetImpl;



@Local
public interface InventoryManagementSessionBeanLocal {

	public InventoryUploadVO uploadInventory(List<InventoryWrapperVO> inventoryVOs,IBLSession iblSession) throws CreateBLException;
	public List<Object> searchInventoryDetailData(SearchInventoryVO inventoryDetailVO);
	public List<Object> searchInventoryBatchData(SearchInventoryVO inventoryDetailVO);
	public Long getTotalInvnetoriesByWarehouse(WarehouseData warehouseData) throws SearchBLException;
	public CachedRowSetImpl searchValidInventoryUploadData(String batchNumber,String attributeNames,Boolean status) ;
	public List getFilterDataBy(String entityName,Map<String,Object> fieldValueMap);
	
	public void saveWarehouseInventoryStatus(Collection<WarehouseInventoryStatusData> warehouseInventoryStatusDatas,IBLSession iblSession) throws CreateBLException;

	public void transferInventory(SearchWarehouseInventoryStatusVO searchWarehouseInventoryStatusVO,IBLSession iblSession) throws CreateBLException;
	public CachedRowSetImpl getInventoryDetails(InventoryDetailsRequestData requestData, String attributeNames,int noOfRecords) throws SearchBLException;
	
	public int getStatusOfInventory(WarehouseData warehouseData,Long resourceId);
	public void transferInventory(List<InventoryDetailVO> inventoryDetailVOs,IBLSession iblSession) throws CreateBLException;
	public TransferOrderData saveTransferOrderData(TransferOrderData transferOrderData,IBLSession iblSession)throws CreateBLException;
	public void saveTransferOrderDetailData(List<TransferOrderDetailData> datas,IBLSession iblSession)throws CreateBLException;
	
	public Map<String,List<String>> getInventoryByBatch(Map<String, Integer> batchMap,SearchInventoryVO searchInventoryVO)throws CreateBLException;
	public List<TransferInventorySummaryViewVO> searchTransferInventorySummary(SearchTransferInventory searchTransferInventory);
	public CachedRowSetImpl getInventoryDetails(String attributeNames,SearchTransferInventory searchTransferInventory)throws SearchBLException;
	
	public void changeTransferInventoryStatus(PartialAcceptRejectTransferOrderVO searchTransferInventory,TransferOrderData transferOrderData,List<InventoryDetailVO> inventoryDetailList)throws CreateBLException;
	public List<InventoryData> checkCPEResource(String resourceId,String warehouseName,String warehouseCode, SystemParameter systemParameter) throws  SearchBLException;
	public List<InventoryStatusVO> changeInventoryStatus(List<InventoryRequestVO> requestVOs,IBLSession iblSession) throws UpdateBLException;
	public boolean isValidInventoryChangeStatus(String oldStatus,String newStatus) ;
	
	public InventoryReserveData reserveInventory(InventoryReserveData inventoryReserveData) throws CreateBLException;
	public void reserveInventoryDetail(List<InventoryReserveDetailData> inventoryReserveDetailDatas)throws CreateBLException;
	public int getTotalTransferInventoryByStatus(long warehouseId);
	public void updateInventory(InventoryData typeData) throws UpdateBLException;
	public void persistInventoryStatusLog(InventoryStatusLogData inventoryStatusLogData) throws CreateBLException;
	public boolean isChangeStatusAllowed(String inventoryNo,String serialNumber) ;
	
	 public CachedRowSetImpl searchInventory(SearchInventoryVO inventoryDetailVO);

	 public OrderData saveOrderData(OrderData data,IBLSession iblSession)throws CreateBLException;
	 public List<OrderData> searchPlaceOrderData(PlaceOrderVO placeOrderVO,IBLSession iblSession);

	public boolean isChangeStatusAllowedWithSerialNumber(String serialNumber);
	public List<InventoryStatusVO> changeInventoryStatusForAllocate(List<InventoryRequestVO> validRequestVO, IBLSession iblSession) throws UpdateBLException;
	public List<OrderData> searchPlaceOrderDetail(PlaceOrderVO placeOrderVO,IBLSession blSession) throws SearchBLException;
	public boolean isAvailable(Long warehouseId, Long itemId) ;
	public List<InventoryData> checkCPEInventory(String inventoryNumber,SystemParameter systemParameter) throws  SearchBLException;
	public List<InventoryStatusResponseVO> releaseCPEResource(List<ReleaseInventoryVO> inventoryVos ,IBLSession iblSession) throws UpdateBLException;
	public List<InventoryStatusResponseVO> markCPEAsFaultyWithOwnerChange(List<CPEInventoryVO> inventoryVOs,String warehouseCode,IBLSession blSession)throws UpdateBLException;
	public long  getTotaltransferrableInventory(Long warehouseId,Long resourceSubTypeId,Long resourceTypeId) throws SearchBLException;
	public boolean isEligiblePlaceOrder(Long warehouseId, Long resourceTypeId,Long resourceSubTypeId, Long itemId) throws SearchBLException;
	
	public Boolean saveOrderNotificationAgentHistory(OrderDetailVo orderDetailVo) throws CreateBLException;
	public List<Long> getPendingPlaceOrderMaster(String minDays) throws SearchBLException;
	public List<OrderData> getPendingPlaceOrderChild(String minDays,Long warehouseid) throws SearchBLException;
	public List<TransferOrderData> getPendingTransferOrderChild(String minDays,Long warehouseid) throws SearchBLException;
	public List<Long> getPendingTransferOrderMaster(String minPendingDays) throws SearchBLException;
	
}
