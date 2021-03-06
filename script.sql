CREATE TABLE HOST_GROUP_TABLE(
ID INT PRIMARY KEY IDENTITY(1,1),
PARENTID INT,
NAME VARCHAR(20),
HOST_BASELINE BIT,
SUPPRESS_EXCLUDED_SERVICE BIT,
INVERSE_SUPPRESSION BIT,
HOST_TRAP BIT,
SEND_TO_CTA BIT,
DESCRIPTIONS VARCHAR(20)
);

CREATE TABLE IPADDRESS_TABLE(
ID INT PRIMARY KEY IDENTITY(1,1),
IP_ADDRESS VARCHAR(10),
IP_LOCATION VARCHAR(10),
IP_DESCRIPTION VARCHAR(10),
TYPE INT,
HOSTGROUP_ID INT FOREIGN KEY REFERENCES HOST_GROUP_TABLE(ID)
);

CREATE TABLE HOST_GROUP_USER(
ID INT PRIMARY KEY IDENTITY(1,1),
HOSTGROUP_USERS VARCHAR(10),
HOSTGROUP_ID INT FOREIGN KEY REFERENCES HOST_GROUP_TABLE(ID)
);