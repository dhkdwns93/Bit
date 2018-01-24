


create table users
(
	user_id			varchar2(10)	primary key,
	pwd				varchar2(10),
	name			varchar2(10)
)

select * from users;



insert into users values('jang', '1234', '장희정');
insert into users values('lee', '1234', '이가현');


commit