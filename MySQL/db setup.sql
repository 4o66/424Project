-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema classregistration
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema classregistration
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `classregistration` DEFAULT CHARACTER SET utf8 ;
USE `classregistration` ;

-- -----------------------------------------------------
-- Table `classregistration`.`course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `classregistration`.`course` ;

CREATE TABLE IF NOT EXISTS `classregistration`.`course` (
  `id` VARCHAR(12) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(256) NOT NULL,
  `hours` FLOAT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `classregistration`.`person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `classregistration`.`person` ;

CREATE TABLE IF NOT EXISTS `classregistration`.`person` (
  `id` VARCHAR(16) NOT NULL,
  `firstname` VARCHAR(128) NOT NULL,
  `lastname` VARCHAR(128) NOT NULL,
  `digest` VARCHAR(128) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `classregistration`.`personcourse`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `classregistration`.`personcourse` ;

CREATE TABLE IF NOT EXISTS `classregistration`.`personcourse` (
  `personid` VARCHAR(16) NOT NULL,
  `courseid` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`courseid`, `personid`),
  INDEX `fkperson_idx` (`personid` ASC),
  CONSTRAINT `fkcourse`
    FOREIGN KEY (`courseid`)
    REFERENCES `classregistration`.`course` (`id`),
  CONSTRAINT `fkperson`
    FOREIGN KEY (`personid`)
    REFERENCES `classregistration`.`person` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
