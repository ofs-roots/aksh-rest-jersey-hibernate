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