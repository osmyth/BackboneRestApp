--CREATE TABLE IMSI_MAPPING (
--  imsi_id          NUMBER(15)    NOT NULL ,
--  msisdn           VARCHAR2(128)  NOT NULL ,
--  subscriber_name  VARCHAR2(256) ,
--  category_id      NUMBER(10)   ,
--  last_updated     NUMBER(38)    NOT NULL ,
--  user_label       VARCHAR2(256) ,
--  can_be_dropped   NUMBER(1)     NOT NULL ,
--  deleted_flag     NUMBER(1)     DEFAULT 0 NOT NULL ,
--  creation_date    NUMBER(38)    NOT NULL ,
--  restricted_access NUMBER(1)    DEFAULT 0 NOT NULL
--)

Insert into IMSI_MAPPING (IMSI_ID,        MSISDN,  SUBSCRIBER_NAME,  CATEGORY_ID, LAST_UPDATED, USER_LABEL, RESTRICTED_ACCESS, DROP_ALLOWED, PROVISIONED)
values (                  100000000000001,'100000','Test',           0,           0,            'Test',     0,                 0,            0);