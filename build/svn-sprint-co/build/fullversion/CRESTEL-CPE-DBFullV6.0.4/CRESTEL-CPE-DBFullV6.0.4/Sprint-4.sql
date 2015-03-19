set define on;
set echo on;

DEFINE partnerDBUser="&&partner_db_user"
DEFINE partnerDBPassword="&&partner_db_password"


alter table TBLTTRANSFERORDERDETAIL add (previousstatus NUMBER(5,0));
alter table TBLTTRANSFERORDERDETAIL add (previoussubstatus NUMBER(5,0));


update tblisystemaction set isauditable='N' where actionalias in ('UPDATE_THRESHOLD','SEARCH_INVENTORY_BATCH','VIEW_WAREHOUSE','SEARCH_RESOURCE','SEARCH_ATTRIBUTE','SEARCH_AGENT_IN_QUEUE','VIEW_AGENT_HISTORY','THRESHOLD_MASTER','VIEW_AUDIT_ENTRY','SEARCH_WS_AUDIT','SEARCH_RESOURCETYPE','VIEW_RESOURCETYPE','SEARCH_RESOURCESUBTYPE','VIEW_RESOURCESUBTYPE','WAREHOUSE_SUMMARY','WAREHOUSE_TREEVIEW','SEARCH_DOCUMENT_TEMPLATE','SEARCH_PLACE_ORDER','VIEW_WAREHOUSE_HIERARCHY','');

update tblisystemaction set parentactionid=(select parentactionid from tblisystemaction where actionalias='THRESHOLD_MASTER') where actionalias='CONFIGURE_THRESHOLD';

Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values ((select max(actionid) from tblisystemaction)+1,null,7,2,'Login-Logout Management','LOGIN_LOGOUT_MANAGEMENT','Login-Logout Management','Y','Y','N','UTY001',null,'N');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values ((select max(actionid) from tblisystemaction)+1,(select actionid from tblisystemaction where actionalias='LOGIN_LOGOUT_MANAGEMENT'),8,2,'Login Action','LOGIN_ACTION','Login Action','Y','Y','N','UTY001',null,'Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values ((select max(actionid) from tblisystemaction)+1,(select actionid from tblisystemaction where actionalias='LOGIN_LOGOUT_MANAGEMENT'),8,2,'Logout Action','LOGOUT_ACTION','Logout Action','Y','Y','N','UTY001',null,'Y');

insert into TBLMMESSAGETEMPLATE(TEMPLATEID,ACTIONID,TEMPLATE,SUPPORTEDTAGS) values ( TBLMMESSAGETEMPLATE_SEQ.nextval,(select actionid from tblisystemaction where actionalias = 'LOGIN_ACTION'  ),'User:${name} logged in to the system','${name}');
insert into TBLMMESSAGETEMPLATE(TEMPLATEID,ACTIONID,TEMPLATE,SUPPORTEDTAGS) values ( TBLMMESSAGETEMPLATE_SEQ.nextval,(select actionid from tblisystemaction where actionalias = 'LOGOUT_ACTION'  ),'User:${name} logged out to the system','${name}');


---Backing Up TBLMINVENTORY Table -------
create table TBLMINVENTORY_BKP as ( select * from TBLMINVENTORY); 

ALTER TABLE  TBLMINVENTORY ADD(SUBSTATUSID NUMBER(5,0));

ALTER TABLE TBLMINVENTORY DROP(ACCEPTED,REFURBISHED,STANDBY,NEW);

--- Query to backup Sub Status

DECLARE
  a1  VARCHAR2 (100);
  
BEGIN
  FOR r1 IN
  (
  	select inventoryid invid,accepted accept , refurbished refurbish, standby stand, new neww 
    from TBLMINVENTORY_BKP inv
  )
  LOOP
  CASE WHEN r1.accept='Y' THEN a1:=2 ;
   WHEN r1.refurbish='Y' THEN a1:=3 ; 
   WHEN r1.stand='Y' THEN a1:=4 ; 
   WHEN r1.neww='Y' THEN a1:=1 ; 
    ELSE a1:=1 ;
 END CASE;
   	update TBLMINVENTORY set SUBSTATUSID=a1 where inventoryid=r1.invid;
  END LOOP;
  commit;
END;
/


INSERT INTO TBLSINVENTORYSUBSTATUS(INVENTORYSUBSTATUSID, NAME, SYSTEMGENERATED, ALIAS, DESCRIPTION) VALUES ((SELECT MAX(INVENTORYSUBSTATUSID)+1 FROM TBLSINVENTORYSUBSTATUS), 'In-Transfer', 'N', 'IN-TRANSFER', 'In-Transfer');

INSERT INTO TBLSINVSUBSTATUSTRANSITION(SUBSTATUSTRANSITIONID,STATUSID, ALLOWEDSUBSTATUSID) VALUES ((TBLSINVSUBSTATUSTRANSITION_SEQ.nextval), '9', '6');
INSERT INTO TBLSINVSUBSTATUSTRANSITION(SUBSTATUSTRANSITIONID,STATUSID, ALLOWEDSUBSTATUSID) VALUES ((TBLSINVSUBSTATUSTRANSITION_SEQ.nextval), '6', '6');
INSERT INTO TBLSINVSUBSTATUSTRANSITION(SUBSTATUSTRANSITIONID,STATUSID, ALLOWEDSUBSTATUSID) VALUES ((TBLSINVSUBSTATUSTRANSITION_SEQ.nextval), '6', '5');
INSERT INTO TBLSINVSUBSTATUSTRANSITION(SUBSTATUSTRANSITIONID,STATUSID, ALLOWEDSUBSTATUSID) VALUES ((TBLSINVSUBSTATUSTRANSITION_SEQ.nextval), '7', '6');
INSERT INTO TBLSINVSUBSTATUSTRANSITION(SUBSTATUSTRANSITIONID,STATUSID, ALLOWEDSUBSTATUSID) VALUES ((TBLSINVSUBSTATUSTRANSITION_SEQ.nextval), '8', '3');
INSERT INTO TBLSINVSUBSTATUSTRANSITION(SUBSTATUSTRANSITIONID,STATUSID, ALLOWEDSUBSTATUSID) VALUES ((TBLSINVSUBSTATUSTRANSITION_SEQ.nextval), '8', '5');
INSERT INTO TBLSINVSUBSTATUSTRANSITION(SUBSTATUSTRANSITIONID,STATUSID, ALLOWEDSUBSTATUSID) VALUES ((TBLSINVSUBSTATUSTRANSITION_SEQ.nextval), '8', '6');
INSERT INTO TBLSINVSUBSTATUSTRANSITION(SUBSTATUSTRANSITIONID,STATUSID, ALLOWEDSUBSTATUSID) VALUES ((TBLSINVSUBSTATUSTRANSITION_SEQ.nextval), '10', '6');

UPDATE TBLMMESSAGETEMPLATE SET  TEMPLATE='Changed Inventory Sub-Status from:${oldStatus} to:${newStatus} Successfully' , SUPPORTEDTAGS='${oldStatus};${newStatus}' WHERE ACTIONID=(SELECT ACTIONID FROM TBLISYSTEMACTION WHERE ACTIONALIAS='CHANGE_INVENTORY_SUBSTATUS');

commit;

---------------------Partner Fire Query----------------------------
conn &&partnerDBUser/&&partnerDBPassword@//&&db_ip:&&db_port/&&db_sid

insert into tblmsystemuser values('STUWEB0001','AET01','Y','Y',0);
insert into tblmstaff values('STFWS1','Webservice','webservice',sysdate,'webservice',sysdate,sysdate,'ENT00','admin@admin.com','address1','address2','380007','CT00001','STT0001','CTR0001',505050,sysdate,null,sysdate,'CST01','STUWEB0001','STF0001','STF0001','N',null,null,null,'CST01',null,null);

commit;