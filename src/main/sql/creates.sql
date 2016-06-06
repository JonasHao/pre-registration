use registration;

CREATE TABLE `user` (
  `id` varchar(20) NOT NULL,
  `password` varchar(64) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `hospital` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

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


CREATE TABLE `doctor` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `introduction` text,
  `departmentID` bigint(20) DEFAULT NULL,
  `title` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKcchj4ydbv6owpvhwc28f0jsmn` (`departmentID`),
  CONSTRAINT `doctor_department_ID_fk` FOREIGN KEY (`departmentID`) REFERENCES `department` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;



