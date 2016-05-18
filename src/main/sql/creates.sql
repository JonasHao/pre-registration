CREATE DATABASE registration;
use registration;

CREATE TABLE capacity
(
  ID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  doctorID BIGINT(20) NOT NULL,
  reserveDateTime TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
  capacity INT(11) DEFAULT '0' NOT NULL,
  dateStart DATETIME NOT NULL,
  CONSTRAINT capacity_doctor_ID_fk FOREIGN KEY (doctorID) REFERENCES doctor (ID)
);
CREATE INDEX capacity_doctor_ID_fk ON capacity (doctorID);
CREATE TABLE contacts
(
  IDNo VARCHAR(32) NOT NULL,
  name VARCHAR(32) NOT NULL,
  phone VARCHAR(16) NOT NULL,
  userID VARCHAR(255) NOT NULL,
  CONSTRAINT `PRIMARY` PRIMARY KEY (IDNo, userID),
  CONSTRAINT contact_user_id_fk FOREIGN KEY (userID) REFERENCES user (id)
);
CREATE INDEX contact_user_id_fk ON contacts (userID);
CREATE TABLE department
(
  ID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(32) NOT NULL,
  hospitalID BIGINT(20),
  description VARCHAR(255),
  CONSTRAINT department_hospital_ID_fk FOREIGN KEY (hospitalID) REFERENCES hospital (ID),
  CONSTRAINT FKm86a0qnlx5lud7v2jrfww8jgf FOREIGN KEY (hospitalID) REFERENCES hospital (ID)
);
CREATE INDEX FKm86a0qnlx5lud7v2jrfww8jgf ON department (hospitalID);
CREATE TABLE doctor
(
  ID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(32) NOT NULL,
  introduction TEXT,
  departmentID BIGINT(20),
  title VARCHAR(32),
  CONSTRAINT doctor_department_ID_fk FOREIGN KEY (departmentID) REFERENCES department (ID),
  CONSTRAINT FKcchj4ydbv6owpvhwc28f0jsmn FOREIGN KEY (departmentID) REFERENCES department (ID)
);
CREATE INDEX FKcchj4ydbv6owpvhwc28f0jsmn ON doctor (departmentID);
CREATE TABLE hibernate_sequence
(
  next_val BIGINT(20)
);
CREATE TABLE hospital
(
  ID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(32),
  description TEXT
);
CREATE TABLE `order`
(
  ID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  createDateTime TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
  reserveDateTime TIMESTAMP DEFAULT '0000-00-00 00:00:00' NOT NULL,
  contactName VARCHAR(64) NOT NULL,
  contactIDNo VARCHAR(32) NOT NULL,
  contactPhone VARCHAR(32) NOT NULL,
  orderStatus INT(11) DEFAULT '0' NOT NULL,
  userID VARCHAR(255) NOT NULL,
  doctorID MEDIUMTEXT NOT NULL,
  departmentID MEDIUMTEXT,
  CONSTRAINT order_user_id_fk FOREIGN KEY (userID) REFERENCES user (id)
);
CREATE INDEX order_user_id_fk ON `order` (userID);
CREATE TABLE user
(
  id VARCHAR(20) PRIMARY KEY NOT NULL,
  password VARCHAR(64) NOT NULL,
  phone VARCHAR(20) NOT NULL,
  email VARCHAR(100)
);