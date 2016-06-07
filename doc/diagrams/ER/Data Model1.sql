SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `User`;
DROP TABLE IF EXISTS `Contact`;
DROP TABLE IF EXISTS `Privilege`;
DROP TABLE IF EXISTS `RegOrder`;
DROP TABLE IF EXISTS `Doctor`;
DROP TABLE IF EXISTS `Hospital`;
DROP TABLE IF EXISTS `Department`;
DROP TABLE IF EXISTS `Capacity`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `User` (
    `id` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `phone` VARCHAR(32) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `type` INTEGER(32) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `Contact` (
    `id` INTEGER(64) NOT NULL,
    `userID` VARCHAR(255) NOT NULL,
    `IDNo` VARCHAR(32) NOT NULL,
    `name` VARCHAR(32) NOT NULL,
    `phone` VARCHAR(16) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `Privilege` (
    `id` INTEGER(64) NOT NULL,
    `root` BOOLEAN NOT NULL,
    `hospital` BOOLEAN NOT NULL,
    `department` BOOLEAN NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `RegOrder` (
    `id` INTEGER(64) NOT NULL,
    `userID` VARCHAR(255) NOT NULL,
    `doctorID` INTEGER(64) NOT NULL,
    `departmentID` INTEGER(64) NOT NULL,
    `hospitalID` INTEGER(64) NOT NULL,
    `contactID` INTEGER(64) NOT NULL,
    `createDateTime` TIMESTAMP NOT NULL,
    `reserveDateTime` TIMESTAMP NOT NULL,
    `status` INTEGER(16) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `Doctor` (
    `id` INTEGER(64) NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `description` TEXT NOT NULL,
    `departmentID` INTEGER(64) NOT NULL,
    `title` VARCHAR(16) NOT NULL,
    `tag` VARCHAR(32) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `Hospital` (
    `id` INTEGER(64) NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `description` TEXT NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `Department` (
    `id` INTEGER(64) NOT NULL,
    `hospitalID` INTEGER(64) NOT NULL,
    `name` VARCHAR(64) NOT NULL,
    `description` TEXT NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `Capacity` (
    `id` INTEGER(64) NOT NULL,
    `doctorID` INTEGER(64) NOT NULL,
    `slot` TIMESTAMP NOT NULL,
    `total` INTEGER(16) NOT NULL,
    `left` INTEGER(16) NOT NULL,
    PRIMARY KEY (`id`)
);

ALTER TABLE `Contact` ADD FOREIGN KEY (`userID`) REFERENCES `po`(`User`);
ALTER TABLE `RegOrder` ADD FOREIGN KEY (`userID`) REFERENCES `Data Model1`(`User`);
ALTER TABLE `RegOrder` ADD FOREIGN KEY (`doctorID`) REFERENCES `Data Model1`(`Doctor`);
ALTER TABLE `RegOrder` ADD FOREIGN KEY (`departmentID`) REFERENCES `Data Model1`(`Department`);
ALTER TABLE `RegOrder` ADD FOREIGN KEY (`hospitalID`) REFERENCES `Data Model1`(`Hospital`);
ALTER TABLE `RegOrder` ADD FOREIGN KEY (`contactID`) REFERENCES `Data Model1`(`Contact`);
ALTER TABLE `Doctor` ADD FOREIGN KEY (`departmentID`) REFERENCES `Data Model1`(`Department`);
ALTER TABLE `Department` ADD FOREIGN KEY (`hospitalID`) REFERENCES `Data Model1`(`Hospital`);
ALTER TABLE `Capacity` ADD FOREIGN KEY (`doctorID`) REFERENCES `Data Model1`(`Doctor`);