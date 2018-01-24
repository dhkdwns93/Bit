DROP TABLE MEMBERS;
-- ȸ�� ���̺�
CREATE TABLE members(
	user_id varchar2(10) primary key,
	pwd varchar2(10) ,
	name varchar2(10) ,
	gender varchar2(5)
	--constraint PK_members PRIMARY KEY(members)
);

select * from members;
--참조키 삭제
drop table members cascade constraint;

drop table reviews;
--REVIEW
CREATE TABLE reviews(
re_id NUMBER(4) primary key,
movie_id varchar2(10) ,
re_pwd varchar2(30) ,
user_id varchar2(10)  REFERENCES members(user_id),
re_title varchar2(30) ,
re_star varchar2(10) ,
re_content CLOB 
--constraint PK_RE_ID PRIMARY KEY(re_id)
);
select * from reviews;

create table users (
    user_id varchar2(10) primary key,
    pwd varchar2(10),
    name varchar2(10),
    gender varchar2(10)
);

alter table users drop column pwd2;


drop table users;
commit

select * from members;
insert into members values('wang', '1234',  '왕준', '남');
insert into members values('jang', '1234',  '장희정', '여');


select * from reviews;
insert into reviews values(seq_re_id.nextval, '1', '1234', 'wang', '졸잼', '10', 'ㅇㅇ');
insert into reviews values(seq_re_id.nextval, '2', '0000', 'jang', '핵잼', '8', 'ㄴㄴ');
insert into reviews values(seq_re_id.nextval, '3', '1200', 'jang', '꿀잼', '9', 'ㅅㅅ');
insert into reviews values(seq_re_id.nextval, '4', '0034', 'wang', '노잼', '7', 'ㄷㄷ');

drop table reviews cascade constraint;


CREATE TABLE reviews (
    re_id NUMBER(4) primary key,
    m_id varchar2(10),
    re_pwd varchar2(30),
    user_id varchar2(10) REFERENCES members(user_id),
    re_title varchar2(30),
    re_star number(2,1),
    re_content CLOB
);
drop table reviews;

insert into reviews values (seq_re_id.nextval, 'jang', '1234', (select user_id from members where user_id='jang'),'드럽게 재미있어요', 3.0, '하하하하하하하하하');

select seq_re_id.nextval from dual;

CREATE sequence seq_re_id start with 1 increment 
by 1 maxvalue 10000 cache 20;

drop sequence seq_re_id;
