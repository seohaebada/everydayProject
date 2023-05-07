-- TAG 테이블
CREATE TABLE TAG (
                     TAG_ID SERIAL PRIMARY KEY,
                     TAG_NAME VARCHAR(200) UNIQUE NOT NULL
);

