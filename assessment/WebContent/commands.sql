create table topic_xbbnhhc(topic_id int primary key,topic_desc varchar(20));
drop table topic_xbbnhhc;
create table topic_xbbnhhc(topic_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY 
(START WITH 1, INCREMENT BY 1) primary key, topic_desc varchar(100));
select * from topic_xbbnhhc;

drop table

create table comment_xbbnhhc(
comment_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY 
(START WITH 1, INCREMENT BY 1) primary key,
comment_desc varchar(40),
comment_date date,
topic_id int references topic_xbbnhhc(topic_id));
select * from comment_xbbnhhc;
create table samp(id1 int);