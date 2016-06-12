/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : registration

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-06-10 13:52:39
*/

SET FOREIGN_KEY_CHECKS=0;


-- ----------------------------
-- Table structure for hospital
-- ----------------------------
DROP TABLE IF EXISTS `hospital`;
CREATE TABLE `hospital` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `description` text,
  `address_area` varchar(255) DEFAULT NULL,
  `address_city` varchar(255) DEFAULT NULL,
  `address_detail` varchar(255) DEFAULT NULL,
  `address_province` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hospital
-- ----------------------------
INSERT INTO `hospital` VALUES ('1', '人民医院', '人民的医院', null, null, null, null);
INSERT INTO `hospital` VALUES ('2', '中心医院', '三级甲等', null, null, null, null);
INSERT INTO `hospital` VALUES ('3', '三三一医院', '爱尔眼科', null, null, null, null);


-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `hospitalID` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKm86a0qnlx5lud7v2jrfww8jgf` (`hospitalID`),
  CONSTRAINT `FKm86a0qnlx5lud7v2jrfww8jgf` FOREIGN KEY (`hospitalID`) REFERENCES `hospital` (`ID`),
  CONSTRAINT `department_hospital_ID_fk` FOREIGN KEY (`hospitalID`) REFERENCES `hospital` (`ID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '外科', '1', '胸外科');
INSERT INTO `department` VALUES ('2', '妇科', '1', '哈哈哈哈');
INSERT INTO `department` VALUES ('4', '内科', '1', '人民医院的内科');

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `introduction` text,
  `departmentID` bigint(20) DEFAULT NULL,
  `title` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKcchj4ydbv6owpvhwc28f0jsmn` (`departmentID`),
  CONSTRAINT `FKcchj4ydbv6owpvhwc28f0jsmn` FOREIGN KEY (`departmentID`) REFERENCES `department` (`ID`),
  CONSTRAINT `doctor_department_ID_fk` FOREIGN KEY (`departmentID`) REFERENCES `department` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES ('1', '神奇医生', '包治百病', '1', '高级医生');
INSERT INTO `doctor` VALUES ('2', '赤脚医生', '百姓的福音', '1', '中级医生');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(20) NOT NULL,
  `password` varchar(64) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('jinyueyuan', '1736225443', '18889898989', null);
INSERT INTO `user` VALUES ('kil', '106190', '18889898987', null);
INSERT INTO `user` VALUES ('koche', '1449589344', '18559659866', null);
INSERT INTO `user` VALUES ('wangjiaxuan', '-416002423', '18889898980', null);

-- ----------------------------
-- Table structure for capacity
-- ----------------------------
DROP TABLE IF EXISTS `capacity`;
CREATE TABLE `capacity` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `doctorID` bigint(20) NOT NULL,
  `slot` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `total` int(11) NOT NULL DEFAULT '0',
  `surplus` int(11) DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `FKk0h5y6o32i4twckbxkn3u3do0` (`doctorID`),
  CONSTRAINT `FKk0h5y6o32i4twckbxkn3u3do0` FOREIGN KEY (`doctorID`) REFERENCES `doctor` (`ID`),
  CONSTRAINT `capacity_doctor_ID_fk` FOREIGN KEY (`doctorID`) REFERENCES `doctor` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Records of capacity
-- ----------------------------
INSERT INTO `capacity` VALUES ('0', '1', '2016-05-25 13:56:12', '5', '3');
INSERT INTO `capacity` VALUES ('1', '1', '2016-05-26 17:42:09', '8', '8');

-- ----------------------------
-- Table structure for contact
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `IDNo` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `phone` varchar(16) NOT NULL,
  `userID` varchar(255) NOT NULL,
  `id` bigint(20) NOT NULL,
  `default` tinyint(1) NOT NULL DEFAULT '0',
  KEY `FKsubw8e0ktm9gb89rwqgqx16rj` (`userID`),
  CONSTRAINT `FKsubw8e0ktm9gb89rwqgqx16rj` FOREIGN KEY (`userID`) REFERENCES `user` (`id`),
  CONSTRAINT `contact_user_id_fk` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES ('430225222222222222', 'Koche', '18888888888', 'koche', '0', '0');
INSERT INTO `contact` VALUES ('4355966966659665', 'Jonas', '18859888888', 'koche', '1', '0');




-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('5');
INSERT INTO `hibernate_sequence` VALUES ('5');
INSERT INTO `hibernate_sequence` VALUES ('5');
INSERT INTO `hibernate_sequence` VALUES ('5');
INSERT INTO `hibernate_sequence` VALUES ('5');
INSERT INTO `hibernate_sequence` VALUES ('5');



-- ----------------------------
-- Table structure for privilege
-- ----------------------------
DROP TABLE IF EXISTS `privilege`;
CREATE TABLE `privilege` (
  `userId` varchar(255) DEFAULT NULL,
  `hospitalId` int(64) DEFAULT NULL,
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `root` binary(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FKa1mm6lpmjmax81jj7hf4x0bqq` (`userId`),
  CONSTRAINT `FKa1mm6lpmjmax81jj7hf4x0bqq` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of privilege
-- ----------------------------
INSERT INTO `privilege` VALUES ('koche', '1', '1', 0x30);

-- ----------------------------
-- Table structure for registrations
-- ----------------------------
DROP TABLE IF EXISTS `registrations`;
CREATE TABLE `registrations` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `reserveDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `contactName` varchar(64) NOT NULL,
  `contactIDNo` varchar(32) NOT NULL,
  `contactPhone` varchar(32) NOT NULL,
  `orderStatus` int(11) DEFAULT '0',
  `userID` varchar(255) NOT NULL,
  `doctorID` bigint(20) NOT NULL,
  `departmentID` bigint(20) DEFAULT NULL,
  `hospitalID` bigint(20) DEFAULT NULL,
  `doctorName` varchar(255) NOT NULL,
  `departmentName` varchar(255) NOT NULL,
  `hospitalName` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKbw2c2qlj6pfb69iqh8y93q5lm` (`departmentID`),
  KEY `FKjbciw4mfn0ubhk9jyqrmf91f5` (`doctorID`),
  KEY `FK8o0oxw4ls6iy5esyyrdwtx4nf` (`hospitalID`),
  KEY `FKrcqd34f33hl10brjw1ju15qta` (`userID`),
  CONSTRAINT `FK8o0oxw4ls6iy5esyyrdwtx4nf` FOREIGN KEY (`hospitalID`) REFERENCES `hospital` (`ID`),
  CONSTRAINT `FKbw2c2qlj6pfb69iqh8y93q5lm` FOREIGN KEY (`departmentID`) REFERENCES `department` (`ID`),
  CONSTRAINT `FKjbciw4mfn0ubhk9jyqrmf91f5` FOREIGN KEY (`doctorID`) REFERENCES `doctor` (`ID`),
  CONSTRAINT `FKrcqd34f33hl10brjw1ju15qta` FOREIGN KEY (`userID`) REFERENCES `user` (`id`),
  CONSTRAINT `order_user_id_fk` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of registrations
-- ----------------------------
INSERT INTO `registrations` VALUES ('19', '2016-05-24 16:45:06', '2016-05-25 13:56:12', 'Jonas', '4355966966659665', '18859888888', '0', 'koche', '1', '1', '1', '神奇医生', '外科', '人民医院');
INSERT INTO `registrations` VALUES ('20', '2016-05-24 16:45:07', '2016-05-25 13:56:12', 'Jonas', '4355966966659665', '18859888888', '0', 'koche', '1', '1', '1', '神奇医生', '外科', '人民医院');


