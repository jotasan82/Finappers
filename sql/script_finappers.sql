-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema finappers
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `finappers` ;

-- -----------------------------------------------------
-- Schema finappers
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `finappers` DEFAULT CHARACTER SET utf8 ;
USE `finappers` ;

-- -----------------------------------------------------
-- Table `finappers`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finappers`.`usuario` (
  `correo` VARCHAR(45) NOT NULL,
  `contrasena` VARCHAR(10) NOT NULL,
  `nombreUsuario` VARCHAR(60) NOT NULL,
  `apellidoUsuario` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`correo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `finappers`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finappers`.`categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `nombreCategoria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB
COMMENT = '	';


-- -----------------------------------------------------
-- Table `finappers`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finappers`.`producto` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `nombreProducto` VARCHAR(45) NOT NULL,
  `descripcionProducto` VARCHAR(45) NULL,
  `usuario_correo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProducto`),
  INDEX `fk_producto_usuario_idx` (`usuario_correo` ASC) VISIBLE,
  CONSTRAINT `fk_producto_usuario`
    FOREIGN KEY (`usuario_correo`)
    REFERENCES `finappers`.`usuario` (`correo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `finappers`.`actividad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finappers`.`actividad` (
  `idActividad` INT NOT NULL AUTO_INCREMENT,
  `tipoActividad` VARCHAR(60) NOT NULL,
  `nombreActividad` VARCHAR(45) NOT NULL,
  `fechaActividad` DATE NOT NULL,
  `valorActividad` INT NOT NULL,
  `descripcionActividad` VARCHAR(150) NULL,
  `producto_idProducto` INT NOT NULL,
  `categoria_idCategoria` INT NOT NULL,
  PRIMARY KEY (`idActividad`),
  INDEX `fk_actividad_producto1_idx` (`producto_idProducto` ASC) VISIBLE,
  INDEX `fk_actividad_categoria1_idx` (`categoria_idCategoria` ASC) VISIBLE,
  CONSTRAINT `fk_actividad_producto1`
    FOREIGN KEY (`producto_idProducto`)
    REFERENCES `finappers`.`producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_actividad_categoria1`
    FOREIGN KEY (`categoria_idCategoria`)
    REFERENCES `finappers`.`categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
