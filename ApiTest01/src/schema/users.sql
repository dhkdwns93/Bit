select * from users;

create table users (
    user_id varchar2(10) primary key,
    pwd varchar2(10),
    name varchar2(10),
    gender varchar2(10)
);

insert into users values('jang', '1234', '장희정','F');
commit

delete from users where user_id = 'jang';