select * from review;

CREATE TABLE review (
    re_id NUMBER(4) primary key,
    m_id varchar2(10),
    re_pwd varchar2(30),
    user_id varchar2(10) REFERENCES users(user_id),
    re_title varchar2(30),
    re_star varchar2(10),
    re_content CLOB
);

drop table review;

insert into review values(seq_re_id, 'MovieCd', '1234', 'jang', '�����', '5', '��');

CREATE sequence seq_re_id start 
with 1 increment 
by 1 maxvalue 10000;

alter table review add(m_id varchar2(10));



