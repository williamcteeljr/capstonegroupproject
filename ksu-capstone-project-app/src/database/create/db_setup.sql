DROP DATABASE IF EXISTS familydonations;

CREATE DATABASE familydonations;

DROP TABLE IF EXISTS `familydonations`.`FamilyMember`;
DROP TABLE IF EXISTS `familydonations`.`Family`;
DROP TABLE IF EXISTS `familydonations`.`RolePermissions`;
DROP TABLE IF EXISTS `familydonations`.`UserRole`;
DROP TABLE IF EXISTS `familydonations`.`RegisteredUser`;
DROP TABLE IF EXISTS `familydonations`.`WishListItem`;
DROP TABLE IF EXISTS `familydonations`.`WishList`;
DROP TABLE IF EXISTS `familydonations`.`TransactionHistory`;
DROP TABLE IF EXISTS `familydonations`.`WishListApprovalQueue`;
DROP TABLE IF EXISTS `familydonations`.`WishListStatus_LOV`;
DROP TABLE IF EXISTS `familydonations`.`WishListItemStatus_LOV`;

/* create tables */
CREATE TABLE IF NOT EXISTS `familydonations`.`Family` (
  `FamilyId` INT(11) NOT NULL COMMENT '',
  `FamilyName` VARCHAR(45) NULL DEFAULT NULL COMMENT 'A general name to identify the family.',
  `Address1` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `Address2` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `City` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `State` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `Zip` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `ContactPhone` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `Email` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `CreatedDate` DATE NOT NULL COMMENT '',
  PRIMARY KEY (`FamilyId`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `familydonations`.`FamilyMember` (
  `FamilyMemberId` INT(11) NOT NULL COMMENT '',
  `FamilyId` INT(11) NOT NULL COMMENT 'Foreign key to the Family table.',
  `FullName` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `Gender` VARCHAR(45) NULL COMMENT '',
  `DateOfBirth` DATE NULL COMMENT '',
  PRIMARY KEY (`FamilyMemberId`)  COMMENT '',
  INDEX `FK_Family_idx` (`FamilyId` ASC)  COMMENT '',
  CONSTRAINT `FK_Family`
    FOREIGN KEY (`FamilyId`)
    REFERENCES `familydonations`.`Family` (`FamilyId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `familydonations`.`RegisteredUser` (
  `RegisteredUserId` INT(11) NOT NULL COMMENT '',
  `LastName` VARCHAR(45) NOT NULL COMMENT '',
  `FirstName` VARCHAR(45) NOT NULL COMMENT '',
  `LoginUserId` VARCHAR(45) NOT NULL COMMENT '',
  `Password` VARCHAR(65) NOT NULL COMMENT 'PW is SHA-256 hash',
  `FamilyId` INT NULL COMMENT 'The ID of a row in the Family table that links this RegisteredUser as a member of the Family.',
  `CreatedDate` DATE NOT NULL COMMENT '',
  PRIMARY KEY (`RegisteredUserId`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `familydonations`.`UserRole` (
  `UserRoleId` INT NOT NULL COMMENT '',
  `Role` VARCHAR(45) NOT NULL COMMENT 'Name of the user role. A Role is a catagorization of users that share the same permissions.',
  PRIMARY KEY (`UserRoleId`)  COMMENT '')
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `familydonations`.`RolePermissions` (
  `RolePermissionsId` INT NOT NULL COMMENT '',
  `UserRoleId` INT NOT NULL COMMENT '',
  `Application` VARCHAR(45) NULL COMMENT 'Name of a web-app application (usually a tab that groups functionality).',
  `PermissionSetting` TINYINT(1) NULL COMMENT '1=HAS permission to access and use application;  0=Does NOT have permission to access and use application.',
  PRIMARY KEY (`RolePermissionsId`)  COMMENT '',
  INDEX `FK_UserRole_idx` (`UserRoleId` ASC)  COMMENT '',
  CONSTRAINT `FK_UserRole`
    FOREIGN KEY (`UserRoleId`)
    REFERENCES `familydonations`.`UserRole` (`UserRoleId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `familydonations`.`WishList` (
  `WishListId` INT(11) NOT NULL COMMENT '',
  `Description` VARCHAR(45) NULL COMMENT '',
  `CreatedDate` DATE NOT NULL COMMENT '',
  `FamilyId` INT NOT NULL COMMENT '',
  PRIMARY KEY (`WishListId`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `familydonations`.`WishListItem` (
  `WishListItemId` INT(11) NOT NULL COMMENT '',
  `WishListId` INT(11) NOT NULL COMMENT '',
  `Description` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `CurrentStatusId` INT(11) NOT NULL DEFAULT '-1' COMMENT '-1 = available for donation\n-2 = committed by doner',
  `CreatedDate` DATE NOT NULL COMMENT '',
  PRIMARY KEY (`WishListItemId`)  COMMENT '',
  INDEX `FK_WishList_idx` (`WishListId` ASC)  COMMENT '',
  CONSTRAINT `FK_WishList`
    FOREIGN KEY (`WishListId`)
    REFERENCES `familydonations`.`WishList` (`WishListId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `familydonations`.`WishListStatus_LOV` (
  `WishListStatusLovId` INT NOT NULL COMMENT '',
  `WishListStatusDesc` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`WishListStatusLovId`)  COMMENT '')
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `familydonations`.`WishListItemStatus_LOV` (
  `WishListItemStatusLovId` INT NOT NULL COMMENT '',
  `WishListItemStatusLovDesc` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`WishListItemStatusLovId`)  COMMENT '')
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `familydonations`.`WishListApprovalQueue` (
  `WishListApprovalQueueId` INT NOT NULL COMMENT '',
  `WishListId` VARCHAR(45) NOT NULL COMMENT 'The family wish list needing approval.',
  `RegisteredUserId` VARCHAR(45) NOT NULL COMMENT 'The registered user responsible for approving this wishlist.',
  `CreatedDate` DATE NOT NULL COMMENT '',
  PRIMARY KEY (`WishListApprovalQueueId`)  COMMENT '')
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `familydonations`.`PublishedWishList` (
  `PublishedWishListId` INT NOT NULL COMMENT '',
  `WishListId` INT NOT NULL COMMENT 'The wish list that has been approved.',
  `CreatedDate` DATE NOT NULL COMMENT '',
  `RegisteredUserId` INT NULL COMMENT 'The registered user that approved this wish list.',
  PRIMARY KEY (`PublishedWishListId`, `WishListId`)  COMMENT '')
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `familydonations`.`TransactionHistory` (
  `TransactionId` INT NOT NULL COMMENT '',
  `TransactionDesc` VARCHAR(45) NOT NULL COMMENT '',
  `TransactionDate` VARCHAR(45) NOT NULL COMMENT 'The date the transaction was completed.',
  `RegisteredUserId` VARCHAR(45) NOT NULL COMMENT 'Registered user this transaction belongs to.',
  PRIMARY KEY (`TransactionId`)  COMMENT '')
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `familydonations`.`RegisteredUserRoles` (
  `RegisteredUserId` INT NOT NULL COMMENT 'PKEY id of a registered user. First part of a composite PK.',
  `UserRoleId` INT NOT NULL COMMENT 'PKEY id of a user role the registered user belongs to (a registered user may be affiliated with more than one user role). Second part of a composite PK.',
  PRIMARY KEY (`RegisteredUserId`, `UserRoleId`)  COMMENT '',
  INDEX `FK_User_Role_idx` (`UserRoleId` ASC)  COMMENT '',
  CONSTRAINT `FK_Registered_User`
    FOREIGN KEY (`RegisteredUserId`)
    REFERENCES `familydonations`.`RegisteredUser` (`RegisteredUserId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_User_Role`
    FOREIGN KEY (`UserRoleId`)
    REFERENCES `familydonations`.`UserRole` (`UserRoleId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

/* load seed data */
INSERT INTO `familydonations`.`WishListStatus_LOV` VALUES (-1, 'Unpublished');
INSERT INTO `familydonations`.`WishListStatus_LOV` VALUES (-2, 'Awaiting Approval');
INSERT INTO `familydonations`.`WishListStatus_LOV` VALUES (-3, 'Approved');

INSERT INTO `familydonations`.`WishListItemStatus_LOV` VALUES (-1, 'Available');
INSERT INTO `familydonations`.`WishListItemStatus_LOV` VALUES (-2, 'Unavailable');

/* insert ADMIN user role with permissions to access 'Admin' application set to 'true' */
INSERT INTO `familydonations`.`UserRole` VALUES (1, 'ADMIN');
INSERT INTO `familydonations`.`RolePermissions` VALUES (1, 1, 'ADMIN', 1);

/* insert registered user 'admin' */
/* pw is a SHA-256 hash of the string 'admin' */
INSERT INTO `familydonations`.`RegisteredUser` VALUES (1, 'Admin', 'User', 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', NULL, CURDATE()); 

/* insert row in relational table to link user 'admin' with user role 'ADMIN' and permissions for role 'ADMIN' */
INSERT INTO `familydonations`.`RegisteredUserRoles` VALUES (1, 1);

