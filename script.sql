CREATE TABLE Hosttable(
id int primary key identity(1,1),
parentid int,
name varchar(20),
hostbaseline bit,
suppress_excluded_service bit,
inverse_suppression bit,
host_trap bit,
send_to_cta bit,
descriptions varchar(20)
);

Create table Ip_address_table(
id int primary key identity(1,1),
ip_address varchar(10),
hostgroup_id int FOREIGN KEY REFERENCES Host_table(id)
);

Create table Host_group_users(
id int primary key identity(1,1),
hostgroup_users varchar(10),
hostgroup_id int FOREIGN KEY REFERENCES Host_table(id)
);