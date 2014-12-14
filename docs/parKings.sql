SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `parkings` ;
CREATE SCHEMA IF NOT EXISTS `parkings` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `parkings` ;

-- -----------------------------------------------------
-- Table `parkings`.`Parquedero`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `parkings`.`Parquedero` ;

CREATE  TABLE IF NOT EXISTS `parkings`.`Parquedero` (
  `idParquedero` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NULL ,
  `direccion` VARCHAR(45) NULL ,
  `telefono` VARCHAR(45) NULL ,
  `email` VARCHAR(45) NULL ,
  PRIMARY KEY (`idParquedero`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `parkings`.`tipovehiculos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `parkings`.`tipovehiculos` ;

CREATE  TABLE IF NOT EXISTS `parkings`.`tipovehiculos` (
  `idtipovehiculos` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NULL ,
  `Parquedero_idParquedero` INT NOT NULL ,
  PRIMARY KEY (`idtipovehiculos`) ,
  INDEX `fk_tipovehiculos_Parquedero1_idx` (`Parquedero_idParquedero` ASC) ,
  CONSTRAINT `fk_tipovehiculos_Parquedero1`
    FOREIGN KEY (`Parquedero_idParquedero` )
    REFERENCES `parkings`.`Parquedero` (`idParquedero` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `parkings`.`servicio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `parkings`.`servicio` ;

CREATE  TABLE IF NOT EXISTS `parkings`.`servicio` (
  `idservicio` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NULL ,
  `costo` VARCHAR(45) NULL ,
  `tipovehiculos_idtipovehiculos` INT NOT NULL ,
  `Parquedero_idParquedero` INT NOT NULL ,
  PRIMARY KEY (`idservicio`) ,
  INDEX `fk_servicio_tipovehiculos1_idx` (`tipovehiculos_idtipovehiculos` ASC) ,
  INDEX `fk_servicio_Parquedero1_idx` (`Parquedero_idParquedero` ASC) ,
  CONSTRAINT `fk_servicio_tipovehiculos1`
    FOREIGN KEY (`tipovehiculos_idtipovehiculos` )
    REFERENCES `parkings`.`tipovehiculos` (`idtipovehiculos` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_servicio_Parquedero1`
    FOREIGN KEY (`Parquedero_idParquedero` )
    REFERENCES `parkings`.`Parquedero` (`idParquedero` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `parkings`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `parkings`.`usuario` ;

CREATE  TABLE IF NOT EXISTS `parkings`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NULL ,
  `apellido` VARCHAR(45) NULL ,
  `telefono` VARCHAR(45) NULL ,
  `role` VARCHAR(45) NULL ,
  `contraseña` VARCHAR(45) NULL ,
  `cedula` VARCHAR(45) NULL ,
  `Parquedero_idParquedero` INT NOT NULL ,
  PRIMARY KEY (`idusuario`) ,
  INDEX `fk_usuario_Parquedero1_idx` (`Parquedero_idParquedero` ASC) ,
  CONSTRAINT `fk_usuario_Parquedero1`
    FOREIGN KEY (`Parquedero_idParquedero` )
    REFERENCES `parkings`.`Parquedero` (`idParquedero` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `parkings`.`ticket`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `parkings`.`ticket` ;

CREATE  TABLE IF NOT EXISTS `parkings`.`ticket` (
  `idticket` INT NOT NULL AUTO_INCREMENT ,
  `fecha_entrada` DATETIME NULL ,
  `fecha_salida` DATETIME NULL ,
  `placa` VARCHAR(45) NULL ,
  `valor` FLOAT NULL ,
  `tipovehiculos_idtipovehiculos` INT NOT NULL ,
  `usuario_idusuario` INT NOT NULL ,
  `Parquedero_idParquedero` INT NOT NULL ,
  PRIMARY KEY (`idticket`) ,
  INDEX `fk_ticket_tipovehiculos1_idx` (`tipovehiculos_idtipovehiculos` ASC) ,
  INDEX `fk_ticket_usuario1_idx` (`usuario_idusuario` ASC) ,
  INDEX `fk_ticket_Parquedero1_idx` (`Parquedero_idParquedero` ASC) ,
  CONSTRAINT `fk_ticket_tipovehiculos1`
    FOREIGN KEY (`tipovehiculos_idtipovehiculos` )
    REFERENCES `parkings`.`tipovehiculos` (`idtipovehiculos` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_usuario1`
    FOREIGN KEY (`usuario_idusuario` )
    REFERENCES `parkings`.`usuario` (`idusuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_Parquedero1`
    FOREIGN KEY (`Parquedero_idParquedero` )
    REFERENCES `parkings`.`Parquedero` (`idParquedero` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `parkings` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
