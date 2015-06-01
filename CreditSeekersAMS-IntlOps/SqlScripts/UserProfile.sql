
CREATE TABLE  "USER_PROFILE" 
   (	"ID" NUMBER(5,0) NOT NULL ENABLE, 
	"PROFILE_ID" NUMBER(5,0), 
	"ROLE" VARCHAR2(30), 
	 CONSTRAINT "USER_PROFILE_PK" PRIMARY KEY ("ID") ENABLE
   ) ;


CREATE OR REPLACE TRIGGER  "BI_USER_PROFILE" 
  before insert on "USER_PROFILE"               
  for each row  
begin   
  if :NEW."ID" is null then 
    select "USER_PROFILE_SEQ".nextval into :NEW."ID" from dual; 
  end if; 
end; 

/
ALTER TRIGGER  "BI_USER_PROFILE" ENABLE;


			
	
