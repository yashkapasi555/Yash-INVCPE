package com.elitecore.cpe.bl.agents.customs;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.elitecore.cpe.bl.agents.base.BaseAgentRun;
import com.elitecore.cpe.bl.agents.base.BaseEnityEnvParameter;
import com.elitecore.cpe.bl.agents.base.BaseEntity;
import com.elitecore.cpe.bl.agents.base.BaseMasterEnityEnvParameter;
import com.elitecore.cpe.bl.agents.base.BaseMasterEntity;
import com.elitecore.cpe.bl.agents.base.BaseSchedule;
import com.elitecore.cpe.bl.constants.notification.NotificationConstants;
import com.elitecore.cpe.bl.data.notification.NotificationData;
import com.elitecore.cpe.bl.facade.inventorymgt.InventoryManagementFacadeRemote;
import com.elitecore.cpe.bl.facade.master.warehouse.WarehouseFacadeRemote;
import com.elitecore.cpe.bl.facade.notification.NotificationFacadeRemote;
import com.elitecore.cpe.bl.vo.inventorymgt.PlaceOrderVO;
import com.elitecore.cpe.bl.vo.order.OrderDetailVo;
import com.elitecore.cpe.bl.vo.order.TransferOrderVO;
import com.elitecore.cpe.util.logger.Logger;
import com.elitecore.utility.agentframework.entities.IAgentRunEntity;
import com.elitecore.utility.agentframework.entities.IAgentRunMasterEntity;

public class OrderNotificationAgent extends BaseAgentRun implements Serializable  {
	private static final long serialVersionUID = 1L;

	private static final String MODULE = "ORDERNOTIFICATION-AGENT";
	
	private static final String PLACE_ORDER_CHILDS = "_PlaceOrderExe";
	private static final String TRANSFER_ORDER_CHILDS = "_TransferOrderExe";
	private static final String WAREHOUSEID = "_WareHouseId";

	private static final String ORDER_TYPE = "_oRDERtYPE";
	private java.util.Date date= new java.util.Date();
	
	

	@Override
	public void agentRunStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preAgentRunMasterEntity(BaseSchedule schedule,
			BaseMasterEntity runMasterEntity,
			BaseEnityEnvParameter agentRunEnvParamList) throws Exception {
		    Logger.logTrace(MODULE, "inside preAgentRunMasterEntity ");
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IAgentRunMasterEntity> getAgentRunMasterEntities(
			BaseSchedule schedule, BaseEnityEnvParameter agentRunEnvParamList) {
		List<IAgentRunMasterEntity> retList= new ArrayList<IAgentRunMasterEntity>();
		try{
			Logger.logTrace(MODULE,"MODULE inside getAgentRunMasterEntities ");
			InventoryManagementFacadeRemote inventory = (InventoryManagementFacadeRemote) lookup(InventoryManagementFacadeRemote.class);

			//To warehouseIds : PlaceOrder
			List<Long> placeOrderWarehouseIds = inventory.getPendingPlaceOrderMaster();
			
			Logger.logTrace(MODULE,"Total Master Size is :"+placeOrderWarehouseIds.size());
			if(placeOrderWarehouseIds!=null && !placeOrderWarehouseIds.isEmpty()) {
				
				for(Long id : placeOrderWarehouseIds) {
					BaseMasterEntity masterEntity = new BaseMasterEntity();
					masterEntity.setLongEntityId(id);
					masterEntity.addParameter(ORDER_TYPE, "PLACE_ORDER");
					retList.add(masterEntity);
				}
			}
			
			
			//To warehouseIds : TransferOrder
			List<Long> transferOrderWarehouseIds = inventory.getPendingTransferOrderMaster();
			
			Logger.logTrace(MODULE,"Total Master Size is :"+transferOrderWarehouseIds.size());
			if(transferOrderWarehouseIds!=null && !transferOrderWarehouseIds.isEmpty()) {
				
				for(Long id : transferOrderWarehouseIds) {
					BaseMasterEntity masterEntity = new BaseMasterEntity();
					masterEntity.setLongEntityId(id);
					masterEntity.addParameter(ORDER_TYPE, "TRANSFER_ORDER");
					retList.add(masterEntity);
				}
			}
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		Logger.logTrace(MODULE,"Prepared the master Data : "+ retList.size());
		
		return retList;
	}

	@Override
	public BaseMasterEnityEnvParameter getAgentRunMasterEntityData(
			BaseSchedule schedule, BaseMasterEntity runMasterEntity,
			BaseEnityEnvParameter agentRunEnvParamList) {
		
		Logger.logTrace(MODULE, "MODULE inside getAgentRunMasterEntityData");
		BaseMasterEnityEnvParameter masterEnityEnvParameter = new BaseMasterEnityEnvParameter();
		try{
			if(runMasterEntity!=null){
				InventoryManagementFacadeRemote inventory = (InventoryManagementFacadeRemote) lookup(InventoryManagementFacadeRemote.class);
				
				if(runMasterEntity.getParametersMap()!=null && runMasterEntity.getParametersMap().containsKey(ORDER_TYPE)) {
					
					if(runMasterEntity.getParametersMap().get(ORDER_TYPE).equals("PLACE_ORDER")) {
						
						List<PlaceOrderVO> placeOrderVO = inventory.getPendingPlaceOrderChild(runMasterEntity.getLongEntityId());
						masterEnityEnvParameter.setParameter(PLACE_ORDER_CHILDS,placeOrderVO);
						
					} else if(runMasterEntity.getParametersMap().get(ORDER_TYPE).equals("TRANSFER_ORDER")) {
						
						List<TransferOrderVO> transferOrderVo = inventory.getPendingTransferOrderChild(runMasterEntity.getLongEntityId());
						masterEnityEnvParameter.setParameter(TRANSFER_ORDER_CHILDS,transferOrderVo);
					}
					
				}
				
				
				masterEnityEnvParameter.setParameter(WAREHOUSEID,runMasterEntity.getLongEntityId());

				Logger.logTrace(MODULE,"-----------Got Agent Run Master Entity Data------------");
			}
			return masterEnityEnvParameter;
		}catch(Exception ex){
			Logger.logTrace(MODULE, ex);
			return null;
		}
	}

	@Override
	public void agentMasterEntityRunStarted(BaseMasterEntity runMasterEntity) {
		// TODO Auto-generated method stub
		Logger.logTrace(MODULE, "agentMasterEntityRunStarted : " );
		
	}

	@Override
	public void preAgentRunProcess(BaseSchedule schedule) throws Exception {
		// TODO Auto-generated method stub
		Logger.logTrace(MODULE, "preAgentRunProcess() : " );
		
	}

	@Override
	public List<IAgentRunEntity> getAgentRunEntities(BaseSchedule schedule,
			BaseMasterEntity runMasterEntity,
			BaseEnityEnvParameter enityEnvParameter,
			BaseMasterEnityEnvParameter masterEnityEnvParameter) {
		Logger.logTrace(MODULE, "getAgentRunEntities() : " );

		List<IAgentRunEntity> retList = new ArrayList<IAgentRunEntity>();
		if(masterEnityEnvParameter!=null){
			//ElapseCalculator calculator = new ElapseCalculator();
			//Logger.logTrace(MODULE, "Beginning process of transfering to child entities ");
			
			if(masterEnityEnvParameter.getParameter(PLACE_ORDER_CHILDS)!=null || masterEnityEnvParameter.getParameter(TRANSFER_ORDER_CHILDS)!=null) {
				List<PlaceOrderVO> executionData1 = (List) masterEnityEnvParameter.getParameter(PLACE_ORDER_CHILDS);
				List<TransferOrderVO> executionData2 = (List) masterEnityEnvParameter.getParameter(TRANSFER_ORDER_CHILDS);
				
				if(executionData1!=null && !executionData1.isEmpty()) {
					for(PlaceOrderVO placeOrderVO : executionData1) {
						BaseEntity baseEntity1 = new BaseEntity(String.valueOf(placeOrderVO.getOrderId()));
						baseEntity1.setObject(placeOrderVO);
						retList.add(baseEntity1);
					}
				}
					
				if(executionData2!=null && !executionData2.isEmpty()) {
					for(TransferOrderVO transferOrderVO : executionData2) {
						BaseEntity baseEntity1 = new BaseEntity(String.valueOf(transferOrderVO.getTransferOrderId()));
						baseEntity1.setObject(transferOrderVO);
						retList.add(baseEntity1);
					}
				}
				
			}
			
			//Logger.logTrace(MODULE, "Transformation Process finished. " + calculator.getElapseMessage());
		}
		Logger.logTrace(MODULE, "returning getAgentRunEntities " + retList.size() );
		return retList;
	}

	@Override
	public boolean runAgentTask(BaseSchedule schedule,
			BaseEntity agentRunEntity, BaseEnityEnvParameter enityEnvParameter,
			BaseMasterEnityEnvParameter masterEnityEnvParameter) {
		boolean retValue = true;
		Logger.logTrace(MODULE, "inside runAgentTask executed now");
		try {
			WarehouseFacadeRemote facadeRemote = (WarehouseFacadeRemote) lookup(WarehouseFacadeRemote.class);
			if(agentRunEntity!=null && masterEnityEnvParameter!=null &&  masterEnityEnvParameter.getParameter(WAREHOUSEID)!=null){
				
				Long wareHouseId =  (Long) masterEnityEnvParameter.getParameter(WAREHOUSEID);
				String placeOrderId = agentRunEntity.getEntityId();

				if(agentRunEntity.getObject()!=null  ) {
					
					OrderDetailVo orderDetailVo = new OrderDetailVo();
					orderDetailVo.setAgenetRunQueueId(schedule.getAgentRunQueueId());
					
					//Place Order and Transfer Order
					if(agentRunEntity.getObject() instanceof PlaceOrderVO) {
						PlaceOrderVO placeOrderVO = (PlaceOrderVO) agentRunEntity.getObject();
						
						orderDetailVo.setOrderId(placeOrderVO.getOrderId());
						orderDetailVo.setOrderNo(placeOrderVO.getOrderNo());
						orderDetailVo.setOrderType("PLACE_ORDER");
						orderDetailVo.setFromWarehouseId(placeOrderVO.getFromwarehouseId());
						orderDetailVo.setToWarehouseId(placeOrderVO.getTowarehouseId());
						orderDetailVo.setAgentRunDate(getCurrentTimestamp());
						orderDetailVo.setEmailSendDate(getCurrentTimestamp());
						orderDetailVo.setStatus("Success");
						
					} else if(agentRunEntity.getObject() instanceof TransferOrderVO) {
						TransferOrderVO transferOrderVO = (TransferOrderVO) agentRunEntity.getObject();
						orderDetailVo.setOrderId(transferOrderVO.getTransferOrderId());
						orderDetailVo.setOrderNo(transferOrderVO.getTransferOrderNo());
						orderDetailVo.setOrderType("TRANSFER_ORDER");
						orderDetailVo.setFromWarehouseId(transferOrderVO.getFromWarehouseId());
						orderDetailVo.setToWarehouseId(transferOrderVO.getToWarehouseId());
						orderDetailVo.setAgentRunDate(getCurrentTimestamp());
						orderDetailVo.setEmailSendDate(getCurrentTimestamp());
						orderDetailVo.setStatus("Success");
					}
					
					NotificationFacadeRemote notifyFacadeRemote = (NotificationFacadeRemote) lookup(NotificationFacadeRemote.class);
					if(notifyFacadeRemote.isEligiblePendingOrderNotification(orderDetailVo)) {
						NotificationData notificationData = prepareNotificationData(agentRunEntity.getObject());
						notifyFacadeRemote.sendNotificationService(notificationData);
						InventoryManagementFacadeRemote inventoryfacadeRemote = (InventoryManagementFacadeRemote) lookup(InventoryManagementFacadeRemote.class);
						inventoryfacadeRemote.saveOrderNotificationAgentHistory(orderDetailVo);
					}
					
					
					
					
				}
				
				
				 
				 
				 
				 
				 
				
				
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			retValue = false;
		}

		return retValue;
	}
	
	
	private NotificationData prepareNotificationData(Object data) {
		
		NotificationData notificationData = new NotificationData();
		
		Map<String, String> map = new HashMap<String, String>();
		
		
		if(data !=null) {
			
			if(data instanceof PlaceOrderVO) {
				PlaceOrderVO placeOrderVO = (PlaceOrderVO) data;
				
				List<String> toEmails = new ArrayList<String>();
				map.put(NotificationConstants.CPE_TO_WAREHOUSE, placeOrderVO.getTowarehouse());
				map.put(NotificationConstants.CPE_ORDER_NUMBER, placeOrderVO.getOrderNo());
				notificationData.setAlias(NotificationConstants.PENDING_ORDER_NOTIFICATION);
				notificationData.setValueMap(map);
				 if(placeOrderVO.getEmailId()!=null)
					 toEmails.add(placeOrderVO.getEmailId());

				 	if(placeOrderVO.getParentEmailId()!=null) {
						 toEmails.add(placeOrderVO.getParentEmailId());
					 }
				 	notificationData.setToEmails(toEmails);
			} else if(data instanceof TransferOrderVO) {
				TransferOrderVO transferOrderVO = (TransferOrderVO) data;
				
				List<String> toEmails = new ArrayList<String>();
				map.put(NotificationConstants.CPE_TO_WAREHOUSE, transferOrderVO.getToWarehouseId()+"");
				map.put(NotificationConstants.CPE_ORDER_NUMBER, transferOrderVO.getTransferOrderNo());
				notificationData.setAlias(NotificationConstants.PENDING_ORDER_NOTIFICATION);
				notificationData.setValueMap(map);
				 if(transferOrderVO.getEmailId()!=null)
					 toEmails.add(transferOrderVO.getEmailId());

				 	if(transferOrderVO.getParentEmailId()!=null) {
						 toEmails.add(transferOrderVO.getParentEmailId());
					 }
				 	notificationData.setToEmails(toEmails);
				
			}
				
		} 
			
			return notificationData;
		}
		
	
		

	@Override
	public void postAgentRunMasterEntity(BaseSchedule schedule,
			BaseMasterEntity agentProcessEntity, BaseEnityEnvParameter gParam,
			BaseMasterEnityEnvParameter aParam) throws Exception {
		// TODO Auto-generated method stub
		Logger.logTrace(MODULE, "inside postAgentRunMasterEntity jahanvi");
		
	}

	@Override
	public void postAgentRun(BaseSchedule schedule,
			BaseEnityEnvParameter agentRunEnvParamList) throws Exception {
		// TODO Auto-generated method stub
		Logger.logTrace(MODULE, "inside postAgentRun ");
		
	}
		

	@Override
	public void agentRunEnded() {
		// TODO Auto-generated method stub
		Logger.logTrace(MODULE, "inside postAgentRun ");
		
	}

	@Override
	public void agentMasterEntityRunEnded(BaseMasterEntity runMasterEntity) {
		// TODO Auto-generated method stub
		Logger.logTrace(MODULE, "inside agentMasterEntityRunEnded ");
		
	}

}