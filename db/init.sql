DROP DATABASE IF EXISTS mybatis;
CREATE DATABASE mybatis;
USE mybatis;

-- 게시물
CREATE TABLE article (
                         id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                         PRIMARY KEY(id),
                         createDate DATETIME NOT NULL,
                         modifyDate DATETIME NOT NULL,
                         `subject` CHAR(100) NOT NULL,
                         content LONGTEXT NOT NULL
);

INSERT INTO article
SET createDate = NOW(),
modifyDate = NOW(),
`subject` = '제목1',
content = '내용1';

INSERT INTO article
SET createDate = NOW(),
modifyDate = NOW(),
`subject` = '제목2',
content = '내용2';

-- 회원
CREATE TABLE `member` (
                          id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                          PRIMARY KEY (id),
                          createDate DATETIME NOT NULL,
                          modifyDate DATETIME NOT NULL,
                          username CHAR(100) NOT NULL UNIQUE,
                          `password` CHAR(100) NOT NULL,
                          `name` CHAR(100) NOT NULL,
                          email CHAR(100) NOT NULL,
                          roles CHAR(100) NOt NULL
);

-- 일반 회원
INSERT INTO `member`
SET createDate = NOW(),
    modifyDate = NOW(),
    username = 'user1',
    `password` = '{noop}1234',
    `name` = '유저1',
    email = 'user1@test.com',
    roles = 'MEMBER';

-- 관리자
INSERT INTO `member`
SET createDate = NOW(),
    modifyDate = NOW(),
    username = 'user2',
    `password` = '{noop}1234',
    `name` = '유저2',
    email = 'user2@test.com'
    roles = 'ADMIN,MEMBER';

SELECT *
FROM `member`;