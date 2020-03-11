create table employee (
  id                            uuid not null,
  name                          varchar(255),
  cnic                          varchar(255),
  age                           integer not null,
  dob                           timestamptz,
  role                          varchar(255),
  constraint pk_employee primary key (id)
);

