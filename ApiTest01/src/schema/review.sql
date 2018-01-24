select * from review;

CREATE TABLE review (
    re_id NUMBER(4) primary key,
    m_id varchar2(10),
    re_pwd varchar2(30),
    user_id varchar2(10) REFERENCES users(user_id),
    re_title varchar2(30),
    re_star number(2,1),
    re_content CLOB
);
drop table review;

insert into review values (seq_re_id.nextval, 'MovieCd2', '1234', (select user_id from users where user_id='jang'),'드럽게 재미있어요', 3.0, '하하하하하하하하하');
insert into review values (seq_re_id.nextval,'dd','1234', 'jang','22', 1, '34');

select seq_re_id.nextval from dual;


CREATE sequence seq_re_id start with 1 increment 
by 1 maxvalue 10000 cache 20;
drop sequence seq_re_id;




