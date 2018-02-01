-----------------------------------------------------------------------------------------
-- 회원
create table users(
    email      	varchar2(40) primary key,                 --아이디(email)
    password   	varchar2(20) not null,                    --패스워드
    name       	varchar2(15) not null,                    --이름
    phone      	varchar2(20) not null,                    --전화번호
    joinDate 	date 		 default now() not null		  --가입날짜
);

-----------------------------------------------------------------------------------------
-- Q&A
create table qna(
    qnaNo     number primary key,                		 --게시판 번호
    email 	  varchar2(40) not null fk, 				 --작성자
    content   varchar2(5000) not null,      			 --글 내용
    writeDate date			 default now() not null,     --작성날짜
    								 --답글
);

create sequence qna_seq start with 1 increment by 1;	 --게시판 번호로 사용할 sequence


-----------------------------------------------------------------------------------------
-- 숙소
create table house(
   no 			NUMBER 			primary key,            	--숙소 글 번호
   title 		varchar2(100) 	not null,        			--글 제목      
   email 		varchar2(40) 	not null,         			--작성자
   content 		varchar2(1000) 	not null,       			--글 내용
   writeDate 	date 		  	default now()  not null,    --작성일
   filePath 	varchar2(1000),								--사진	
   status 		number not null,							--상태
   
);

CREATE sequence house_seq start with 1 increment by 1;	 --게시판 번호로 사용할 sequence
-----------------------------------------------------------------------------------------
create table reply(
	replyNo		NUMBER			primary key,				--댓글 번호		
	no 			NUMBER 			fk,							--숙소 글 번호
	email		varchar2(40)	not null,					--아이디(email)
	rContent	varchar2(100) 	not null,					--댓글 내용
	rWriteDate 	date			default now() not null		--댓글 작성날짜
) 
CREATE sequence reply_seq start with 1 increment by 1;	--댓글 번호 sequence
-----------------------------------------------------------------------------------------
-- 파일업다운로드 게시판
create table Board(
   board_num NUMBER(4) primary key,    					--글 번호
   board_name varchar2(20) not null,  					--글 이름
   writeday date  not null,        						--작성일
   fname varchar2(50),             					    --파일이름
   readnum int,                 						--조회수
   content varchar2(255),          						--글 내용
   fsize int, 											--파일용량
   writer varchar(50)
);

CREATE sequence seq_board_num start with 1 increment by 1; --게시판 번호로 사용할 sequence

-----------------------------------------------------------------------------------------