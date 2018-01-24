CREATE TABLE review (
    re_id NUMBER(4) primary key,
    m_id varchar2(10),
    re_pwd varchar2(30),
    user_id varchar2(10) REFERENCES users(user_id) ON DELETE CASCADE ,
    re_title varchar2(50),
    re_star number(2,1),
    re_content CLOB
);
drop table review;
insert into review values (seq_re_id.nextval, '20105976', '1234', (select user_id from users where user_id='jang'),'재미있어요', 3.0, '하하하하하하하하하');

select * from review order by re_id desc;


CREATE sequence seq_re_id start with 1 increment by 1 maxvalue 10000 cache 20;

select seq_re_id.nextval from dual;

drop sequence seq_re_id;

commit


