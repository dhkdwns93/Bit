select * from users;
drop table users;
create table users (
    user_id varchar2(10) primary key,
    pwd varchar2(10),
    name varchar2(10),
    gender varchar2(10)
);

alter table users drop column pwd2;

commit