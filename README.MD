# board 프로젝트
코드로 배우는 스프링 웹프로젝트 책의 코드 따라 치기 : 게시판

## DB테이블 생성
CREATE SEQUENCE seq_board;

CREATE TABLE tbl_board(. 
bno number(10,0). 
,title varchar2(200) NOT NULL. 
,content varchar2(2000) NOT NULL. 
,writer varchar2(50) NOT NULL. 
,regdate DATE DEFAULT sysdate. 
,updatedate DATE DEFAULT sysdate. 
);

ALTER TABLE tbl_board ADD CONSTRAINT pk_board PRIMARY KEY(bno);

## 목표
스프링 부트를 이용한 CURD 게시판 작성
게시판의 페이징 처리
검색기능 처리
게시판 댓글 기능을 REST 와 AJAX 방식 이용
게시글 파일 관련 업로드 및 첨부파일의 CRUD처리

## 실제 따라치며 구현해본 것
