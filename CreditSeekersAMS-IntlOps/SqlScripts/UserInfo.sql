CREATE TABLE  "USER_INFO" 
   (	"USER_ID" NUMBER(5,0), 
	"ACCOUNT_NAME" VARCHAR2(100), 
	"STREET1" VARCHAR2(1000), 
	"STREET2" VARCHAR2(1000), 
	"STATE" VARCHAR2(20), 
	"CITY" VARCHAR2(20), 
	"ZIPCODE" NUMBER(8,0), 
	"CLIENT_ID" NUMBER(5,0), 
	 CONSTRAINT "USER_INFO_PK" PRIMARY KEY ("USER_ID") ENABLE
   ) ;


CREATE OR REPLACE TRIGGER  "BI_USER_INFO" 
  before insert on "USER_INFO"               
  for each row  
begin   
  if :NEW."USER_ID" is null then 
    select "USER_INFO_SEQ".nextval into :NEW."USER_ID" from dual; 
  end if; 
end; 

/
ALTER TRIGGER  "BI_USER_INFO" ENABLE;


