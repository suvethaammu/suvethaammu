create table T_XBBNHHV_CUSTOMER_DETAILS (cust_id varchar(20),cust_name varchar(20),cust_pwd varchar(20),cust_repwd varchar(20),cust_phno varchar2(10),cust_address varchar(20));
insert into T_XBBNHHV_CUSTOMER_DETAILS values ('1001','Suvetha','suve','suve','9944030533','Karur');
insert into T_XBBNHHV_CUSTOMER_DETAILS values ('1002','Abinaya','abi','abi','9182736450','Kangayam');
insert into T_XBBNHHV_CUSTOMER_DETAILS values ('1003','Shruthi','shru','sru','9235730410','Salem');
delete from T_XBBNHHV_CUSTOMER_DETAILS where cust_repwd='abi';
select * from T_XBBNHHV_CUSTOMER_DETAILS;
drop table T_XBBNHHV_CUSTOMER;

////////////////////////////////////////////////////////

create table T_XBBNHHV_ROOM(hotel_name varchar(20),R1 varchar(20),R2 varchar(2),R3 varchar(2),R4 varchar(2),R5 varchar(2),room_type varchar(20),room_price int);
insert into T_XBBNHHV_ROOM values('Ajanta','A','A','A','A','A','Single-cot-AC',3000);
insert into T_XBBNHHV_ROOM values('Thinnappa','A','A','A','A','A','Non-AC-room',2000);
insert into T_XBBNHHV_ROOM values('Hemala','A','A','A','A','A','Single-cot-room',1500);
insert into T_XBBNHHV_ROOM values('Taj','A','A','A','A','A','Double-cot-room',1000);
select * from T_XBBNHHV_ROOM;
drop table T_XBBNHHV_ROOM;
delete from T_XBBNHHV_ROOM where room_id='1';
update T_XBBNHHV_ROOM set room_avail='A' where room_id='101';
update T_XBBNHHV_ROOM set R1='A' where hotel_name='Taj';
alter table T_XBBNHHV_ROOM add R8 varchar(2) DEFAULT 'A' where hotel_name='ss' ;

update T_XBBNHHV_ROOM set room_price=500 where hotel_name='Ajanta';

//////////////////////////////////////////////////////////

create table T_XBBNHHV_HOTEL (hotel_id varchar(5),hotel_name varchar(20),location varchar(30));
insert into T_XBBNHHV_HOTEL values('101','Ajanta','GandhiNagar');
insert into T_XBBNHHV_HOTEL values('102','Thinnappa','Tiruvanmayur');
insert into T_XBBNHHV_HOTEL values('103','Hemala','Taramani');
insert into T_XBBNHHV_HOTEL values('104','Taj','Koyembedu');

select * from T_XBBNHHV_HOTEL;


////////////////////////////////////////////////////////////
create table T_XBBNHHV_BOOKING_DETAILS (cust_id varchar(10),hotel_name varchar(20),room_id varchar(20),check_in varchar(20),check_out varchar(20),days int);
insert into T_XBBNHHV_BOOK values('');
select * from T_XBBNHHV_BOOKING_DETAILS ;
delete from T_XBBNHHV_BOOKING_DETAILS where cust_id='1001';
drop table T_XBBNHHV_BOOKING_DETAILS;

////////////////////////////////////////////////////////////
drop table T_XBBNHHV_ADMIN;
create table T_XBBNHHV_ADMIN(admin_id varchar(10),admin_pwd varchar(10),hotel_id varchar(20));
insert into T_XBBNHHV_ADMIN values('A1','admin1','101');
insert into T_XBBNHHV_ADMIN values('A2','admin2','102');
insert into T_XBBNHHV_ADMIN values('A3','admin3','103');
insert into T_XBBNHHV_ADMIN values('A4','admin4','104');
select * from T_XBBNHHV_ADMIN;
delete from T_XBBNHHV_ADMIN where admin_pwd='adminn';


/////////////////////////////////////////////////////////////////
create table T_XBBNHHV_CUST_BOOKING_DET(cust_id varchar(20),cust_name varchar(20),hotel_id varchar(5),room_id varchar(20),fare int,indate date,outdate date);





////////////////////////////////////////////////////////////////
create table T_XBBNHHV_EMPLOYEE(admin_id varchar(10),emp_id varchar(10),emp_name varchar(20),emp_pwd varchar(10),emp_designation varchar(20),salary int);
drop table T_XBBNHHV_EMPLOYEE;
insert into T_XBBNHHV_EMPLOYEE values ('A2','E1','Gautam','gm','Manager','20000');
delete from T_XBBNHHV_EMPLOYEE where admin_id='A2';
select * from T_XBBNHHV_EMPLOYEE;


/////////////////////////////////////////////////////////////////












/////////////////////////////////////////////////////////////////

create schema sample;
set schema sample;
create table T_XBBNHHV_CUSTOMER_DETAILS(cust_id varchar(20),cust_name varchar(20),cust_pwd varchar(20),cust_repwd varchar(20),cust_phno varchar(10),cust_address varchar(20));
insert into T_XBBNHHV_CUSTOMER_DETAILS values ('1001','Suvetha','suve','suve','9944030533','Karur');
insert into T_XBBNHHV_CUSTOMER_DETAILS values ('1002','Abinaya','abi','abi','9182736450','Kangayam');
insert into T_XBBNHHV_CUSTOMER_DETAILS values ('1003','Shruthi','shru','sru','9235730410','Salem');
select * from T_XBBNHHV_CUSTOMER_DETAILS;
delete from T_XBBNHHV_CUSTOMER_DETAILS where cust_id='';
update T_XBBNHHV_CUSTOMER_DETAILS set cust_address='sfgfd' where cust_name='Abinaya';
////////////////////////////////////////////////////////////////////////////


create table T_XBBNHHV_ROOM(hotel_name varchar(20),R1 varchar(20),R2 varchar(2),R3 varchar(2),R4 varchar(2),R5 varchar(2),room_type varchar(20),room_price int);
insert into T_XBBNHHV_ROOM values('Ajanta','A','A','A','A','A','Single-cot-AC',3000);
insert into T_XBBNHHV_ROOM values('Thinnappa','A','A','A','A','A','Non-AC-room',2000);
insert into T_XBBNHHV_ROOM values('Hemala','A','A','A','A','A','Single-cot-room',1500);
insert into T_XBBNHHV_ROOM values('Taj','A','A','A','A','A','Double-cot-room',1000);
drop table T_XBBNHHV_ROOM;
delete from T_XBBNHHV_ROOM where room_id='1';
select * from T_XBBNHHV_ROOM;
//////////////////////////////////////////////////////////////////////////////////////
create table T_XBBNHHV_HOTELL (hotel_id varchar(5),hotel_name varchar(20),location varchar(30),admin_id varchar(10));
insert into T_XBBNHHV_HOTELL values('101','Ajanta','GandhiNagar','A1');
insert into T_XBBNHHV_HOTELL values('102','Thinnappa','Tiruvanmayur','A2');
insert into T_XBBNHHV_HOTELL values('103','Hemala','Taramani','A3');
insert into T_XBBNHHV_HOTELL values('104','Taj','Koyembedu','A4');
update T_XBBNHHV_HOTELL set location='Gandhipuram' where hotel_name='Ajanta';
select * from T_XBBNHHV_HOTELL;
delete from T_XBBNHHV_HOTELL where hotel_id='101';
drop table T_XBBNHHV_HOTELL;


//////////////////////////////////////////////////////////////////////////////////
create table T_XBBNHHV_HOTEL (hotel_id varchar(5),hotel_name varchar(20),location varchar(30),emp_id varchar(20),emp_pwd varchar(20));
insert into T_XBBNHHV_HOTEL values('101','Ajanta','GandhiNagar','E2','gaju');
insert into T_XBBNHHV_HOTEL values('102','Thinnappa','Tiruvanmayur','E1','gow');
insert into T_XBBNHHV_HOTEL values('103','Hemala','Taramani','E3','shore');
insert into T_XBBNHHV_HOTEL values('104','Taj','Koyembedu','E4','prem');
drop table T_XBBNHHV_HOTEL;
select * from T_XBBNHHV_HOTEL;
////////////////////////////////////////////////////////////////////////////////////////

create table T_XBBNHHV_BOOKING_DETAILS (cust_id varchar(10),hotel_name varchar(20),room_id varchar(20),check_in varchar(20),check_out varchar(20),persons int);
select * from T_XBBNHHV_BOOKING_DETAILS;
delete from T_XBBNHHV_BOOKING_DETAILS where cust_id is null;
drop table T_XBBNHHV_BOOKING_DETAILS;

SELECT b.cust_id,b.hotel_name,b.room_id,b.check_in,b.check_out,b.persons,h.room_price 
from T_XBBNHHV_BOOKING_DETAILS b,T_XBBNHHV_ROOM h where b.hotel_name='Thinnappa';

insert into T_XBBNHHV_BOOKING_DETAILS values('Suvetha','Hemala',(SELECT R4 FROM T_XBBNHHV_ROOM WHERE R4='A'),'04/04/2017','08/04/2017',4);
//////////////////////////////////////////////////////////////////////////////////////////////

create table T_XBBNHHV_ADMIN(admin_id varchar(10),admin_pwd varchar(10),hotel_id varchar(20));
insert into T_XBBNHHV_ADMIN values('A1','admin1','101');
insert into T_XBBNHHV_ADMIN values('A2','admin2','102');
insert into T_XBBNHHV_ADMIN values('A3','admin3','103');
insert into T_XBBNHHV_ADMIN values('A4','admin4','104');
select * from T_XBBNHHV_ADMIN;
delete from T_XBBNHHV_ADMIN where admin_pwd='adminn';

////////////////////////////////////////////////////////////////////////////////////
create table T_XBBNHHV_EMPLOYEE(admin_id varchar(10),emp_id varchar(10),emp_name varchar(20),emp_pwd varchar(10),emp_designation varchar(20),salary int);
insert into T_XBBNHHV_EMPLOYEE values ('A1','E2','gajennth','gaju','Manager',10000);
insert into T_XBBNHHV_EMPLOYEE values ('A2','E1','Gautam','gow','Manager',20000);
insert into T_XBBNHHV_EMPLOYEE values ('A3','E3','Kishore','shore','Manager',30000);
insert into T_XBBNHHV_EMPLOYEE values ('A4','E4','prem','prem','Manager',40000);
select * from T_XBBNHHV_EMPLOYEE;
delete from T_XBBNHHV_EMPLOYEE where emp_id='E354';
drop table T_XBBNHHV_EMPLOYEE;
/////////////////////////////////////////////////////////////////////////////////


create table T_XBBNHHV_EMPLOY(mgr_id varchar(10),emp_id varchar(10),emp_name varchar(20),emp_pwd varchar(10),emp_cpwd varchar(10),emp_designation varchar(20),salary int);
select * from T_XBBNHHV_EMPLOY;
delete from T_XBBNHHV_EMPLOY where emp_designation='ds';

drop table T_XBBNHHV_EMPLOY;
////////////////////////////////////////////////////////////////////////////////////

create table T_XBBNHHV_BILL(cust_id varchar(20),room_id varchar(20),amt int);
select * from T_XBBNHHV_BILL;
delete from T_XBBNHHV_BILL where cust_id='1001';
drop table T_XBBNHHV_BILL;
///////////////////////////////////////////////////////////////////////////////
create table T_XBBNHHV_PAYMENT(cust_id varchar(20),hotel_id varchar(20),room_id varchar(20),pay_type varchar(20),amount int);

delete from T_XBBNHHV_BOOKING_DETAILS where uname='Abinaya' and hname='Thinnappa' and rid='R1';
