## 코드로 배우는 스프링 웹프로젝트 책의 코드 따라 치기 : 게시판

### 1. 목표
1. 스프링 부트를 이용한 CURD 게시판 작성  
2. 게시판의 페이징 처리   
3. 검색기능 처리  
4. 게시판 댓글 기능을 REST 와 AJAX 방식 이용   
5. 게시글 파일 관련 업로드 및 첨부파일의 CRUD처리   

### 2. DB테이블 생성
CREATE SEQUENCE	seq_board;

CREATE TABLE tbl_board(   
	bno number(10,0)  
	,title varchar2(200) NOT NULL  
	,content varchar2(2000) NOT NULL  
	,writer varchar2(50) NOT NULL  
	,regdate DATE DEFAULT sysdate  
	,updatedate DATE DEFAULT sysdate   
);

ALTER TABLE tbl_board ADD CONSTRAINT pk_board   
PRIMARY KEY(bno);

INSERT INTO tbl_board(bno, title, content, writer)    
values(seq_board.nextval, '테스트 제목', '테스트 내용', 'user05');

COMMIT;

SELECT * FROM tbl_board;


# 지켜야 할 사항 : 하루 커밋은 두번(오후 1시 / 오후 5시)
