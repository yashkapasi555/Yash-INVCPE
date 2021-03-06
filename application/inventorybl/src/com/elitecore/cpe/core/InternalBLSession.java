package com.elitecore.cpe.core;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.elitecore.cpe.bl.data.system.internal.SystemActionData;

/**
 * @author yash.kapasi
 *
 */
public class InternalBLSession implements IBLSession {

	private static final long serialVersionUID = 1L;

	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

	private String userId;
	private String name;
	private String username;
	private String password;
	private String userType;
	private String sessionId;
	private String ipAddress;
	private Date sessionCreateTime;
	private Date lastActivityTime;
	private Map<String, SystemActionData> permittedActions;
	private Set<Long> userWarehouseMappings = null;
	
	public InternalBLSession() {
	}

	/**
	 * Internal BL Session 
	 * @param userId
	 * @param name
	 * @param username
	 * @param password
	 * @param sessionId
	 * @param ipAddress
	 * @param userType
	 * @param permittedActions
	 * @param userWarehouseMappings
	 */
	public InternalBLSession(String userId, String name, String username,String password,String sessionId,String ipAddress, 
			String userType,Map<String, SystemActionData> permittedActions,Set<Long> userWarehouseMappings) {
		super();
		this.userId = userId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.sessionId = sessionId;
		this.ipAddress = ipAddress;
		sessionCreateTime = new Date();
		this.permittedActions=permittedActions;
		this.userWarehouseMappings = userWarehouseMappings;
	}

	@Override
	public String getSessionUserId() {
		return this.userId;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getUserType() {
		return userType;
	}

	public String getSessionId() {
		return sessionId;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public String getSessionCreateTime() {
		return sdf.format(sessionCreateTime);
	}	
	
	public boolean isPermittedAction(String actionAlias) {
		boolean ispermisible = false;
		if(this.permittedActions!=null && !permittedActions.isEmpty()){
			ispermisible = this.permittedActions.containsKey(actionAlias);
		}
		return ispermisible;
	}
	
	public SystemActionData getSystemAction(String actionAlias){
		if(this.permittedActions!=null){
			return this.permittedActions.get(actionAlias);
	}else{
			return null;
		}
	}
	
	public Date getLastActivityTime() {
		return this.lastActivityTime;
	}

	public void setLastActivityTime(Date lastActivityTime) {
		this.lastActivityTime = lastActivityTime;
	}

	public BLSessionContextImp prepareBLSessionContextImp(IBLSession blSessionImp, SessionAccessControl sessionAccessControlImp){
		return new BLSessionContextImp(blSessionImp,sessionAccessControlImp);
	}
	
	private  static class BLSessionContextImp implements IBDSessionContext {		
		private static final long serialVersionUID = 1L;
		private IBLSession blSession;
		private SessionAccessControl sessionAccessControl;			
		private BLSessionContextImp(IBLSession blSession, SessionAccessControl sessionAccessControlImp){
			this.blSession  = blSession;
			this.sessionAccessControl = sessionAccessControlImp ;
		}
			
		public IBLSession getBLSession(){
			return this.blSession;
		}

		public SessionAccessControl getSessionAccessControl() {
			return  sessionAccessControl;
		}
	}

	@Override
	public List<SystemActionData> getPermittedAction() {
		List<SystemActionData> actionDatas = new ArrayList<SystemActionData>();
		if(permittedActions!=null && !permittedActions.isEmpty()){
			actionDatas = new ArrayList<SystemActionData>(permittedActions.values());
		}
		return actionDatas;
	}

	@Override
	public Set<Long> getUserWarehouseMappings() {
		
		if(userWarehouseMappings!=null && !userWarehouseMappings.isEmpty()) {
			
			return userWarehouseMappings;
		} else {
			userWarehouseMappings = new HashSet<Long>();
		}
		
		return userWarehouseMappings;
	}

	

	
}
