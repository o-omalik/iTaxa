CREATE TABLE EMPLOYEE (
EMPLOYEEID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
NAME VARCHAR(40),
STREET VARCHAR(40),
CITY VARCHAR(20),
POST CHAR(10),
PHONE VARCHAR(20),
CPRNR VARCHAR(20),
LICNR VARCHAR(20),
PASSWORD VARCHAR(50) DEFAULT '1234',
ROLE VARCHAR(50),
PRIMARY KEY(EMPLOYEEID)
)

CREATE TABLE VOGN (
VOGNID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
BEVNR CHAR(10),
REGNR CHAR(20),
MODEL VARCHAR(40),
PYEAR CHAR(10),
PRIMARY KEY(VOGNID)
)

CREATE TABLE SKATTEKORT (
ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
FRADRAG DOUBLE NOT NULL,
PROCENT DOUBLE NOT NULL,
AKTIVEDATE DATE,
EXPIREDATE DATE,
EMPLOYEEID INTEGER REFERENCES EMPLOYEE(EMPLOYEEID),
PRIMARY KEY(ID)
)

CREATE TABLE TRAFIKBOOK (
BOGID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
DATE DATE NOT NULL,
HOURS DOUBLE,
ENHEDER DOUBLE,
TOURS DOUBLE,
KM DOUBLE,
CREDIT DOUBLE, 
CASH DOUBLE,
DIVERSE DOUBLE,
AKONTO DOUBLE,
EMPLOYEEID INTEGER REFERENCES EMPLOYEE(EMPLOYEEID),
VOGNID INTEGER REFERENCES VOGN(VOGNID),
PRIMARY KEY(BOGID)
)

CREATE TABLE PAYSLIP (
PID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
PERIOD INTEGER NOT NULL,
INDKOERT DOUBLE,
ATP DOUBLE,
AMBIDRAG DOUBLE,
ASKAT DOUBLE,
TOTALPAY DOUBLE,
PEID INTEGER REFERENCES EMPLOYEE(EMPLOYEEID),
PSKID INTEGER REFERENCES SKATTEKORT(ID),
PRIMARY KEY(PID) )
