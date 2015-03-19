--------------------------------SYSTEM ACTION ------------------------------------------------------


--------------------------New Actions----------------------------------------

Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (101,null,6,6,'Warehouse Master','WAREHOUSE_MASTER','Warehouse Master','Y','Y','N','UTY001','/WEB-INF/pages/core/master/warehouse/SearchWarehouse.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (102,null,4,5,'Resource Master','RESOURCE_MASTER','Resource  Master','Y','Y','N','UTY001','/WEB-INF/pages/core/master/item/SearchItem.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (103,null,1,2,'Attribute Management','ATTRIBUTE_MASTER','Attribute Master','Y','Y','N','UTY001','/WEB-INF/pages/core/master/attribute/SearchAttribute.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (105,null,1,1,'Upload Inventory','UPLOAD_INVENTORY_MGT','Upload Inventory','Y','Y','N','UTY001','/WEB-INF/pages/core/inventory/UploadInventory.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (106,null,2,1,'Search Inventory','SEARCH_INVENTORY','Search Inventory','Y','Y','N','UTY001','/WEB-INF/pages/core/inventory/search/SearchInventory.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (107,null,4,1,'Transfer Inventory','TRANSFER_INVENTORY_MGT','Transfer Inventory','Y','Y','N','UTY001','/WEB-INF/pages/core/inventory/transfer/TransferInventoryP.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (108,null,3,1,'Search Inventory Batch','SEARCH_INVENTORY_BATCH','Search Inventory Batch','Y','Y','N','UTY001','/WEB-INF/pages/core/inventory/search/SearchInventoryBatch.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (109,null,2,3,'Search Audit','SEARCH_AUDIT','Search Audit','Y','Y','N','UTY001','/WEB-INF/pages/core/audit/search-audit.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (110,null,1,3,'Configure Audit','CONFIGURE_AR_AUDIT','Configure Audit','Y','Y','N','UTY001','/WEB-INF/pages/core/audit/configure-audit.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (111,101,1,6,'Create Warehouse','CREATE_WAREHOUSE','Create Warehouse','Y','Y','N','UTY001','/WEB-INF/pages/core/master/warehouse/CreateWarehouse.zul','N');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (112,101,2,6,'Search Warehouse','VIEW_WAREHOUSE','View Warehouse','Y','Y','N','UTY001','/WEB-INF/pages/core/master/warehouse/SearchWarehouse.zul','N');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (113,101,3,6,'Update Warehouse','UPDATE_WAREHOUSE','Update Warehouse','Y','Y','N','UTY001','/WEB-INF/pages/core/master/warehouse/UpdateWarehouse.zul','N');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (114,101,4,6,'Delete Warehouse','DELETE_WAREHOUSE','Delete Warehouse','Y','Y','N','UTY001','/WEB-INF/pages/core/master/warehouse/DeleteWarehouse.zul','N');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (115,102,1,5,'Search Resource','SEARCH_RESOURCE','Search Resource','Y','Y','N','UTY001','/WEB-INF/pages/core/master/item/SearchItem.zul','N');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (116,102,2,5,'Create Resource','CREATE_RESOURCE','Create Resource','Y','Y','N','UTY001','/WEB-INF/pages/core/master/item/createItem.zul','N');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (117,102,3,5,'Update Resource','UPDATE_RESOURCE','Update Resource','Y','Y','N','UTY001','/WEB-INF/pages/core/master/item/UpdateItem.zul','N');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (118,103,1,2,'Search Attribute','SEARCH_ATTRIBUTE','Search Attribute','Y','Y','N','UTY001','/WEB-INF/pages/core/master/attribute/SearchAttribute.zul','N');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (119,103,2,2,'Create Attribute','CREATE_ATTRIBUTE','Create Attribute','Y','Y','N','UTY001','/WEB-INF/pages/core/master/attribute/CreateAttribute.zul','N');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (120,103,3,2,'Update Attribute','UPDATE_ATTRIBUTE','Update Attribute','Y','Y','N','UTY001','/WEB-INF/pages/core/master/attribute/UpdateAttribute.zul','N');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (121,null,3,4,'Search Agent in Queue','SEARCH_AGENT_IN_QUEUE','Search Agent In Queue.','Y','Y','N','UTY001','/WEB-INF/pages/core/system/agent/search-agent-runin-queue.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (122,null,2,4,'Agent Schedule','SEARCH_AGENT_SCHEDULE','Search Agent Schedule.','Y','Y','N','UTY001','/WEB-INF/pages/core/system/agent/search-agent-schedule.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (123,null,1,4,'Search Agent','SEARCH_AGENT','Search Agent.','Y','Y','N','UTY001','/WEB-INF/pages/core/system/agent/search-agent.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (124,122,3,4,'Remove Agent Schedule','REMOVE_AGENT_SCHEDULE','Remove Agent Schedule.','Y','Y','N','UTY001','/WEB-INF/pages/core/system/agent/delete-agent-schedule.zul','N');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (125,122,2,4,'Update Agent Schedule','UPDATE_AGENT_SCHEDULE','Update Agent Schedule.','Y','Y','N','UTY001','/WEB-INF/pages/core/system/agent/update-agent-schedule.zul','N');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (126,122,1,4,'Create Agent Schedule','CREATE_AGENT_SCHEDULE','Create Agent Schedule.','Y','Y','N','UTY001','/WEB-INF/pages/core/system/agent/create-agent-schedule.zul','N');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (127,122,4,4,'View Agent History','VIEW_AGENT_HISTORY','View Agent History.','Y','Y','N','UTY001','/WEB-INF/pages/core/system/agent/view-history.zul','N');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (128,123,1,4,'Update Agent Parameter','UPDATE_AGENT_PARAMETER','Update Agent Parameter.','Y','Y','N','UTY001','/WEB-INF/pages/core/system/agent/update-agent-parameter.zul','N');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (129,null,5,6,'WarehouseType Master','WAREHOUSETYPE_MASTER','WarehouseType Master','Y','Y','N','UTY001','/WEB-INF/pages/core/master/warehouse/SearchWarehouseType.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (130,129,1,6,'Create WarehouseType','CREATE_WAREHOUSETYPE','Create WarehouseType','Y','Y','N','UTY001','/WEB-INF/pages/core/master/warehouse/CreateWarehouseType.zul','N');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (131,129,2,6,'Update WarehouseType','UPDATE_WAREHOUSETYPE','Update WarehouseType','Y','Y','N','UTY001','/WEB-INF/pages/core/master/warehouse/UpdateWarehouseType.zul','N');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (132,109,3,3,'View Audit Entry','VIEW_AUDIT_ENTRY','View Audit Entry','Y','Y','N','UTY001','/WEB-INF/pages/core/audit/view-audit-entry.zul','N');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (133,null,0,2,'System Parameter','UPDATE_SYSTEM_PARAMETER','Update System Parameter','Y','Y','N','UTY001','/WEB-INF/pages/core/system/systemparameter/system-parameter.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (134,107,1,1,'Transfer Inventory','TRANSFER_INVENTORY','Transfer Inventory','Y','Y','N','UTY001','/WEB-INF/pages/core/inventory/transfer/TransferInventory.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (135,105,1,1,'Upload Inventory','UPLOAD_INVENTORY','Upload Inventory','Y','Y','N','UTY001','/WEB-INF/pages/core/inventory/UploadInventory.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (136,null,3,3,'Search Web Service Audit','SEARCH_WS_AUDIT','Search WsAudit','Y','Y','N','UTY001','/WEB-INF/pages/core/audit/search-wsaudit.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (137,101,5,6,'Threshold Master','THRESHOLD_MASTER','Threshold Master','Y','Y','N','UTY001',null,'N');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (138,137,1,6,'Configure Threshold','CONFIGURE_THRESHOLD','Configure Threshold','Y','Y','N','UTY001',null,'N');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (139,137,2,6,'UpdateThreshold','UPDATE_THRESHOLD','UpdateThreshold','Y','Y','N','UTY001',null,'N');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (140,137,3,2,'Delete Threshold','DELETE_THRESHOLD','Delete Threshold','Y','Y','N','UTY001',null,'N');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (141,null,2,5,'Resource Type Master','RESOURCE_TYPE_MASTER','Resource Type Master','Y','Y','N','UTY001','/WEB-INF/pages/core/master/item/search-resource-type.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (142,null,3,5,'Resource SubType Master','RESOURCE_SUBTYPE_MASTER','Resource SubType Master','Y','Y','N','UTY001','/WEB-INF/pages/core/master/item/search-resource-subtype.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (143,141,3,5,'Search Resource','SEARCH_RESOURCETYPE','Search ResourceType','Y','Y','N','UTY001','/WEB-INF/pages/core/master/item/search-resource-type.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (144,141,3,5,'View Resource','VIEW_RESOURCETYPE','View ResourceType','Y','Y','N','UTY001','/WEB-INF/pages/core/master/item/View-resource-type.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (145,141,3,5,'Update Resource Type','UPDATE_RESOURCETYPE','Update ResourceType','Y','Y','N','UTY001','/WEB-INF/pages/core/master/item/update-resource-type.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (146,142,3,5,'Search ResourceSubType','SEARCH_RESOURCESUBTYPE','Search ResourceSubType','Y','Y','N','UTY001','/WEB-INF/pages/core/master/item/search-resource-subtype.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (147,142,3,5,'View ResourceSubType','VIEW_RESOURCESUBTYPE','View ResourceSubType','Y','Y','N','UTY001','/WEB-INF/pages/core/master/item/View-resource-subtype.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (148,142,3,5,'Update ResourceSubType','UPDATE_RESOURCESUBTYPE','Update ResourceSubType','Y','Y','N','UTY001','/WEB-INF/pages/core/master/item/update-resource-subtype.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (149,null,5,1,'Transfer Inventory Batch','TRANSFER_INVENTORY_MGT1','Transfer Inventory Batch','Y','Y','N','UTY001','/WEB-INF/pages/core/inventory/transfer/TransferInventoryBatch.zul','N');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (150,149,5,1,'Transfer Inventory Batch','TRANSFER_INVENTORY_BATCH','Transfer Inventory Batch','Y','Y','N','UTY001','/WEB-INF/pages/core/inventory/transfer/TransferInventoryBatch.zul','Y');
Insert into TBLISYSTEMACTION (ACTIONID,PARENTACTIONID,SEQUENCENUMBER,MODULEID,NAME,ACTIONALIAS,DESCRIPTION,ISAUDITABLE,ENABLEAUDIT,ENABLENOTIFICATION,USERTYPEID,PAGEURL,ENABLEVISIBLE) values (151,101,5,6,'Transfer Inventory Detail','TRANSFER_INVENTORY_SUMMARY','Transfer Inventory Summary','Y','Y','N','UTY001','/WEB-INF/pages/core/master/warehouse/TransferInventorySummary.zul','N');


commit;