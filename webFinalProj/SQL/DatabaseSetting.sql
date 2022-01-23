--계정 생성
CREATE USER FP_USER IDENTIFIED BY Database1234;

--계정 삭제(스키마까지 삭제)
DROP USER "FP_USER" CASCADE;

--권한 부여
GRANT CONNECT, RESOURCE, INSERT ANY TABLE, 
UPDATE ANY TABLE, DELETE ANY TABLE, CREATE VIEW
TO FP_USER;

--테이블 스페이스 사용 권한 부여
ALTER USER "FP_USER" quota 50m ON USERS;

--오토커밋 해제
SET AUTOCOMMIT OFF;

--커밋
COMMIT;

--모든 테이블 조회
SELECT 'DROP TABLE "' || TABLE_NAME || '";' FROM user_tables;

--제약조건 조회
SELECT * FROM ALL_CONSTRAINTS;
ALTER TABLE ACCOUNT DROP CONSTRAINT SYS_C0018110;

--특정 테이블에 컬럼 추가
ALTER TABLE REPORT ADD REPORT_REASON NUMBER REFERENCES REPORT_REASON(REPORT_REASON_ID);

--특정 테이블에 컬럼 삭제
ALTER TABLE 테이블명 DROP COLUMN 컬럼명;

--특정 테이블에 컬럼 보이기/숨김 (순서 변경시 사용)
ALTER TABLE 테이블명 MODIFY 컬럼명 INVISIBLE;
ALTER TABLE 테이블명 MODIFY 컬럼명 VISIBLE;
---------------------------------------------
CREATE TABLE SOCIAL_ACCOUNT(
	  SOCIAL_ACCOUNT_ID NUMBER PRIMARY KEY
	, RAND_ID VARCHAR2(50) NOT NULL
	, ACCESS_TOKEN VARCHAR2(4000) NOT NULL
	, NAME VARCHAR2(50) NOT NULL
	, PHONE VARCHAR2(50) NOT NULL
	, EMAIL VARCHAR2(50) 
	, ADDRESS VARCHAR2(50) NOT NULL
	, NICKNAME VARCHAR2(50) NOT NULL
	, LOGIN_TYPE NUMBER CHECK (LOGIN_TYPE >= 1 AND LOGIN_TYPE <= 3)
	, JOINDATE DATE DEFAULT (SYSDATE)
);
CREATE SEQUENCE SOCIAL_ACCOUNT_SEQ NOCACHE;
---------------------------------------------
CREATE TABLE ACCOUNT(
	  ACCOUNT_ID VARCHAR2(50) PRIMARY KEY
	, PASSWORD VARCHAR2(50) NOT NULL
	, USER_TYPE NUMBER CHECK (USER_TYPE >= 0 AND USER_TYPE <= 2)
	, NAME VARCHAR2(50) NOT NULL
	, PHONE VARCHAR2(50) NOT NULL
	, EMAIL VARCHAR2(50)
	, ADDRESS VARCHAR2(50)
	, NICKNAME VARCHAR2(50)
	, JOINDATE DATE DEFAULT (SYSDATE)
);
---------------------------------------------
CREATE TABLE ITEM_CATEGORY(
	  ITEM_CATEGORY_ID NUMBER PRIMARY KEY
	, NAME VARCHAR2(50) NOT NULL
	, NAV_SHOW CHAR(1) CHECK (NAV_SHOW = 'T' OR NAV_SHOW = 'F')
);
CREATE SEQUENCE ITEM_CATEGORY_SEQ NOCACHE
---------------------------------------------
CREATE TABLE ITEM(
	  ITEM_ID NUMBER PRIMARY KEY
	, ITEM_CATEGORY_ID NUMBER REFERENCES ITEM_CATEGORY(ITEM_CATEGORY_ID)
	, NAME VARCHAR2(50) NOT NULL
	, CONTENT VARCHAR2(4000) NOT NULL
	, PRICE NUMBER NOT NULL
);
CREATE SEQUENCE ITEM_SEQ NOCACHE
---------------------------------------------
CREATE TABLE ITEM_OPTION(
	  ITEM_OPTION_ID NUMBER PRIMARY KEY
	, ITEM_ID NUMBER REFERENCES ITEM(ITEM_ID)
	, ITEM_SIZE VARCHAR2(30) NOT NULL
	, COLOR VARCHAR2(30) NOT NULL
	, AMOUNT NUMBER CHECK (AMOUNT >= 0)
);
CREATE SEQUENCE ITEM_OPTION_SEQ NOCACHE
---------------------------------------------
CREATE TABLE REVIEW(
	  REVIEW_ID NUMBER PRIMARY KEY
	, ITEM_ID NUMBER REFERENCES ITEM(ITEM_ID)
	, WRITER_ID VARCHAR2(50) REFERENCES ACCOUNT(ACCOUNT_ID)
	, POST_DATE DATE DEFAULT (SYSDATE)
	, CONTENT VARCHAR2(50) NOT NULL
	, SCORE NUMBER CHECK (SCORE >= 0 AND SCORE <= 5)
);
CREATE SEQUENCE REVIEW_SEQ NOCACHE
---------------------------------------------
CREATE TABLE QUESTION(
	  QUESTION_ID NUMBER PRIMARY KEY
	, ITEM_ID NUMBER REFERENCES ITEM(ITEM_ID)
	, WRITER_ID VARCHAR2(50) REFERENCES ACCOUNT(ACCOUNT_ID)
	, QUESTION_TITLE VARCHAR2(50) NOT NULL
	, QUESTION_CONTENT VARCHAR2(4000) NOT NULL
	, QUESTION_DATE DATE DEFAULT (SYSDATE)
	, RESULT NUMBER CHECK (RESULT = 0 AND RESULT = 1)
	, ANSWER_TITLE VARCHAR2(50)
	, ANSWER_CONTENT VARCHAR2(4000)
	, ANSWER_DATE DATE
);
CREATE SEQUENCE QUESTION_SEQ NOCACHE
---------------------------------------------
CREATE TABLE SOLD_HISTORY(
	  SOLD_HISTORY_ID NUMBER PRIMARY KEY
	, ACCOUNT_ID VARCHAR2(50) REFERENCES ACCOUNT(ACCOUNT_ID)
	, ADDRESS VARCHAR2(50) NOT NULL
	, RECEIVER_NAME VARCHAR2(50) NOT NULL
	, RECEIVER_PHONE VARCHAR2(50) NOT NULL
	, ORDER_DATE DATE NOT NULL
	, STATUS NUMBER CHECK (STATUS >=0 AND STATUS <=2)
);
CREATE SEQUENCE SOLD_HISTORY_SEQ NOCACHE
---------------------------------------------
CREATE TABLE SOLD_DETAIL(
	  SOLD_DETAIL_ID NUMBER PRIMARY KEY
	, ITEM_ID NUMBER REFERENCES ITEM(ITEM_ID)
	, SOLD_HISTORY_ID NUMBER REFERENCES SOLD_HISTORY(SOLD_HISTORY_ID)
	, AMOUNT NUMBER NOT NULL
	, ITEM_OPTION_ID NUMBER REFERENCES ITEM_OPTION(ITEM_OPTION_ID)
	, IS_REFUND NUMBER CHECK (IS_REFUND = 0 OR IS_REFUND = 1)
	, REFUND_ASK_DATE DATE DEFAULT (NULL)
	, REFUND_REASON VARCHAR2(4000) DEFAULT (NULL)
	, REFUND_STATUS NUMBER  CHECK (REFUND_STATUS >= 0 AND REFUND_STATUS <= 3)
	, REFUND_END_DATE DATE DEFAULT (NULL)
);
CREATE SEQUENCE SOLD_DETAIL_SEQ NOCACHE
---------------------------------------------
CREATE TABLE COUPON(
	  COUPON_ID NUMBER PRIMARY KEY
	, NAME VARCHAR2(50) NOT NULL
	, START_DATE DATE DEFAULT (SYSDATE)
	, END_DATE DATE NOT NULL
	, DISCOUNT NUMBER CHECK (DISCOUNT > 0 AND DISCOUNT < 100)
	, AMOUNT NUMBER
);
CREATE SEQUENCE COUPON_SEQ NOCACHE
---------------------------------------------
CREATE TABLE GIVE_COUPON(
	  GIVE_COUPON_ID NUMBER PRIMARY KEY
	, COUPON_ID NUMBER REFERENCES COUPON(COUPON_ID)
	, ACCOUNT_ID VARCHAR2(50) REFERENCES ACCOUNT(ACCOUNT_ID)
);
CREATE SEQUENCE GIVE_COUPON_SEQ NOCACHE
---------------------------------------------
CREATE TABLE SHOPPING_LIST(
	  SHOPPING_LIST_ID NUMBER PRIMARY KEY
	, ACCOUNT_ID VARCHAR2(50) REFERENCES ACCOUNT(ACCOUNT_ID)
	, ITEM_ID NUMBER REFERENCES ITEM(ITEM_ID)
	, AMOUNT NUMBER NOT NULL
	, ITEM_OPTION_ID NUMBER REFERENCES ITEM_OPTION(ITEM_OPTION_ID)
);
CREATE SEQUENCE SHOPPING_LIST_SEQ NOCACHE
---------------------------------------------
CREATE TABLE ZZIM_LIST(
	  ZZIM_LIST_ID NUMBER PRIMARY KEY
	, ACCOUNT_ID VARCHAR2(50) REFERENCES ACCOUNT(ACCOUNT_ID)
	, ITEM_ID NUMBER REFERENCES ITEM(ITEM_ID)
);
CREATE SEQUENCE ZZIM_LIST_SEQ NOCACHE
---------------------------------------------
CREATE TABLE BOARD(
	  BOARD_ID NUMBER PRIMARY KEY
	, NAME VARCHAR(50) NOT NULL
);
CREATE SEQUENCE BOARD_SEQ NOCACHE
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, '공지사항');
---------------------------------------------
CREATE TABLE POST(
	  POST_ID NUMBER PRIMARY KEY
	, WRITER_ID VARCHAR2(50) REFERENCES ACCOUNT(ACCOUNT_ID)
	, BOARD_ID NUMBER REFERENCES BOARD(BOARD_ID)
	, TITLE VARCHAR2(50) NOT NULL
	, CONTENT VARCHAR2(4000) NOT NULL
	, POST_VIEWS NUMBER DEFAULT (0)
	, GOOD_NUMBER NUMBER DEFAULT (0)
	, POSTING_DATE DATE DEFAULT (SYSDATE)
);
CREATE SEQUENCE POST_SEQ NOCACHE`
---------------------------------------------
CREATE TABLE GOOD(
	  ACCOUNT_ID VARCHAR2(50) REFERENCES ACCOUNT(ACCOUNT_ID)
	, POST_ID NUMBER REFERENCES POST(POST_ID)
);
---------------------------------------------
CREATE TABLE COMMENTS(
	  COMMENT_ID NUMBER PRIMARY KEY
	, POST_ID NUMBER REFERENCES POST(POST_ID)
	, WRITER_ID VARCHAR2(50) REFERENCES ACCOUNT(ACCOUNT_ID)
	, POSTING DATE DEFAULT (SYSDATE)
	, CONTENT VARCHAR2(4000) NOT NULL
);
CREATE SEQUENCE COMMENT_SEQ NOCACHE
---------------------------------------------
CREATE TABLE REPORT(
	  REPORT_ID NUMBER PRIMARY KEY
	, REPORTER_ID VARCHAR2(50) REFERENCES ACCOUNT(ACCOUNT_ID)
	, REPORTED_ACCOUNT_ID VARCHAR(50) REFERENCES ACCOUNT(ACCOUNT_ID)
	, REPORTED_POST_ID NUMBER REFERENCES POST(POST_ID)
	, REPORTED_DATE DATE DEFAULT (SYSDATE)
	, CONTENT VARCHAR(4000) NOT NULL
	, RESULT NUMBER CHECK (RESULT = 1 OR RESULT = 2 OR RESULT = 3)
	, CLOSED_DATE DATE
);
CREATE SEQUENCE REPORT_SEQ NOCACHE
---------------------------------------------
CREATE TABLE PUNISH(
	  REPORT_ID NUMBER REFERENCES REPORT(REPORT_ID)
	, REPORTED_ACCOUNT_ID VARCHAR2(50) REFERENCES ACCOUNT(ACCOUNT_ID)
	, START_DATE DATE DEFAULT (SYSDATE)
	, END_DATE DATE NOT NULL
);
---------------------------------------------
CREATE TABLE REPORT_REASON(
	  REPORT_REASON_ID NUMBER PRIMARY KEY
	, REPORT_ID NUMBER REFERENCES REPORT(REPORT_ID)
	, CONTENT VARCHAR2(30) NOT NULL
);
CREATE SEQUENCE REPORT_REASON_SEQ NOCACHE
---------------------------------------------
CREATE TABLE IMAGE(
	  IMAGE_ID NUMBER PRIMARY KEY
	, ITEM_ID NUMBER REFERENCES ITEM(ITEM_ID)
	, REVIEW_ID NUMBER REFERENCES REVIEW(REVIEW_ID)
	, QUESTION_ID NUMBER REFERENCES QUESTION(QUESTION_ID)
	, REPORT_ID NUMBER REFERENCES REPORT(REPORT_ID)
	, BOARD_ID NUMBER REFERENCES BOARD(BOARD_ID)
	, FILE_NAME VARCHAR2(4000)
	, FILE_URL VARCHAR2(4000)
);
CREATE SEQUENCE IMAGE_SEQ NOCACHE
---------------------------------------------