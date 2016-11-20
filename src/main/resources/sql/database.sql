-- MySQL Script generated by MySQL Workbench
-- Sun Nov 20 18:05:30 2016
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema parental_control
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `parental_control` ;

-- -----------------------------------------------------
-- Schema parental_control
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `parental_control` DEFAULT CHARACTER SET utf8 ;
USE `parental_control` ;

-- -----------------------------------------------------
-- Table `parental_control`.`parents`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `parental_control`.`parents` ;

CREATE TABLE IF NOT EXISTS `parental_control`.`parents` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL DEFAULT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `parental_control`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `parental_control`.`users` ;

CREATE TABLE IF NOT EXISTS `parental_control`.`users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `birthdate` DATE NOT NULL,
  `sex` VARCHAR(45) NOT NULL,
  `parent_id` INT(11) NOT NULL,
  `device_id` VARCHAR(120) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `users_parent_id_idx` (`parent_id` ASC),
  CONSTRAINT `users_parent_id`
  FOREIGN KEY (`parent_id`)
  REFERENCES `parental_control`.`parents` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `parental_control`.`app_total_time`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `parental_control`.`app_total_time` ;

CREATE TABLE IF NOT EXISTS `parental_control`.`app_total_time` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `app_name` VARCHAR(45) NOT NULL,
  `hours` INT(11) NOT NULL,
  `minutes` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id_idx` (`user_id` ASC),
  CONSTRAINT `app_total_time_user_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `parental_control`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `parental_control`.`app_usage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `parental_control`.`app_usage` ;

CREATE TABLE IF NOT EXISTS `parental_control`.`app_usage` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `app_name` VARCHAR(45) NOT NULL,
  `datetime_used` DATETIME NOT NULL,
  `user_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id_idx` (`user_id` ASC),
  CONSTRAINT `app_usage_user_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `parental_control`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  AUTO_INCREMENT = 141
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `parental_control`.`location_used`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `parental_control`.`location_used` ;

CREATE TABLE IF NOT EXISTS `parental_control`.`location_used` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `datetime_used` DATETIME NOT NULL,
  `latitude` DOUBLE NOT NULL,
  `longitude` DOUBLE NOT NULL,
  `user_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `location_used_user_id_idx` (`user_id` ASC),
  CONSTRAINT `location_used_user_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `parental_control`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
