
DROP DATABASE IF EXISTS addressbook;

CREATE DATABASE addressbook;

USE addressbook;


DROP TABLE IF EXISTS person;

CREATE TABLE person(
  id        INT(11) AUTO_INCREMENT,
  username  VARCHAR(255) NOT NULL ,
  password  VARCHAR(255) NOT NULL ,
  PRIMARY KEY (id)
)CHARSET = UTF8;

select * from user;


DROP TABLE IF EXISTS addressbook;

CREATE TABLE addressbook(
  id          INT(11) AUTO_INCREMENT,
  username    VARCHAR(255) UNIQUE NOT NULL ,
  sex         varchar(3)          NOT NULL ,
  phone       VARCHAR(12)  UNIQUE NOT NULL ,
  home        VARCHAR(12)         DEFAULT NULL,
  address     VARCHAR(255)        DEFAULT NULL,
  birthday    varchar(255)                DEFAULT NULL,
  userGroup   VARCHAR(255)        DEFAULT NULL,
  email       VARCHAR(255) UNIQUE DEFAULT NULL,
  company     VARCHAR(255)        DEFAULT NULL,
  nickname    VARCHAR(255)        DEFAULT NULL,
  notes       VARCHAR(255)        DEFAULT NULL,
  primary key (id)
)CHARSET = UTF8;