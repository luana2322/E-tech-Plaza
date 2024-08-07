-- MySQL Script generated by MySQL Workbench
-- Fri Dec  8 21:39:19 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema e_techplaza
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema e_techplaza
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `e_techplaza` DEFAULT CHARACTER SET utf8mb4 ;
USE `e_techplaza` ;

-- -----------------------------------------------------
-- Table `e_techplaza`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `e_techplaza`.`admin` (
  `admin_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `image` VARCHAR(255) NULL DEFAULT NULL,
  `is_email_verified` BIT(1) NOT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `registration_date` DATETIME NULL DEFAULT NULL,
  `verification_code` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `e_techplaza`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `e_techplaza`.`role` (
  `role_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `created_At` DATETIME(6) NULL DEFAULT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `role_name` VARCHAR(255) NULL DEFAULT NULL,
  `updated_At` DATETIME(6) NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `e_techplaza`.`admin_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `e_techplaza`.`admin_role` (
  `admin_role_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `admin_id` BIGINT(20) NULL DEFAULT NULL,
  `role_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`admin_role_id`),
  INDEX `FKcxtbmnff43w12d3v2r8fwufaf` (`admin_id` ASC) VISIBLE,
  INDEX `FKox1vbfj0x7ta1nk14np291n9k` (`role_id` ASC) VISIBLE,
  CONSTRAINT `FKcxtbmnff43w12d3v2r8fwufaf`
    FOREIGN KEY (`admin_id`)
    REFERENCES `e_techplaza`.`admin` (`admin_id`),
  CONSTRAINT `FKox1vbfj0x7ta1nk14np291n9k`
    FOREIGN KEY (`role_id`)
    REFERENCES `e_techplaza`.`role` (`role_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `e_techplaza`.`bank`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `e_techplaza`.`bank` (
  `bank_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `bank_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`bank_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `e_techplaza`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `e_techplaza`.`country` (
  `country_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `country_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`country_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `e_techplaza`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `e_techplaza`.`customer` (
  `customer_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `customeremail` VARCHAR(255) NULL DEFAULT NULL,
  `customer_image` VARCHAR(255) NULL DEFAULT NULL,
  `customerpassword` VARCHAR(255) NULL DEFAULT NULL,
  `customer_phone` VARCHAR(255) NULL DEFAULT NULL,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `is_email_verified` BIT(1) NOT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `registration_date` VARCHAR(255) NULL DEFAULT NULL,
  `country_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  INDEX `FKmkr4ai7dyofddp8a83hp7yu1h` (`country_id` ASC) VISIBLE,
  CONSTRAINT `FKmkr4ai7dyofddp8a83hp7yu1h`
    FOREIGN KEY (`country_id`)
    REFERENCES `e_techplaza`.`country` (`country_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `e_techplaza`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `e_techplaza`.`cart` (
  `cart_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `created_At` DATETIME(6) NULL DEFAULT NULL,
  `total_amount` DOUBLE NOT NULL,
  `total_item` INT(11) NOT NULL,
  `updated_At` DATETIME(6) NULL DEFAULT NULL,
  `customer_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`cart_id`),
  INDEX `FKdebwvad6pp1ekiqy5jtixqbaj` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `FKdebwvad6pp1ekiqy5jtixqbaj`
    FOREIGN KEY (`customer_id`)
    REFERENCES `e_techplaza`.`customer` (`customer_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `e_techplaza`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `e_techplaza`.`product` (
  `product_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `camera` VARCHAR(255) NULL DEFAULT NULL,
  `cost_price` DOUBLE NOT NULL,
  `cpu` VARCHAR(255) NULL DEFAULT NULL,
  `current_quantity` INT(11) NOT NULL,
  `height` DOUBLE NOT NULL,
  `is_activated` BIT(1) NOT NULL,
  `is_deleted` BIT(1) NOT NULL,
  `pin` INT(11) NOT NULL,
  `product_name` VARCHAR(255) NULL DEFAULT NULL,
  `product_sku` VARCHAR(255) NULL DEFAULT NULL,
  `ram` INT(11) NOT NULL,
  `rom` INT(11) NOT NULL,
  `sale_price` DOUBLE NOT NULL,
  `thick` DOUBLE NOT NULL,
  `weight` DOUBLE NOT NULL,
  `width` DOUBLE NOT NULL,
  `description` LONGTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`product_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 40
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `e_techplaza`.`cart_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `e_techplaza`.`cart_item` (
  `cart_item_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `cart_item_sku` VARCHAR(255) NULL DEFAULT NULL,
  `product_price` DOUBLE NOT NULL,
  `quantity` INT(11) NOT NULL,
  `total_price` DOUBLE NOT NULL,
  `cart_id` BIGINT(20) NULL DEFAULT NULL,
  `product_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`cart_item_id`),
  INDEX `FK1uobyhgl1wvgt1jpccia8xxs3` (`cart_id` ASC) VISIBLE,
  INDEX `FKjcyd5wv4igqnw413rgxbfu4nv` (`product_id` ASC) VISIBLE,
  CONSTRAINT `FK1uobyhgl1wvgt1jpccia8xxs3`
    FOREIGN KEY (`cart_id`)
    REFERENCES `e_techplaza`.`cart` (`cart_id`),
  CONSTRAINT `FKjcyd5wv4igqnw413rgxbfu4nv`
    FOREIGN KEY (`product_id`)
    REFERENCES `e_techplaza`.`product` (`product_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 30
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `e_techplaza`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `e_techplaza`.`category` (
  `category_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `category_image_path` VARCHAR(255) NULL DEFAULT NULL,
  `category_name` VARCHAR(255) NULL DEFAULT NULL,
  `category_status` VARCHAR(255) NULL DEFAULT NULL,
  `created_At` DATETIME(6) NULL DEFAULT NULL,
  `deleted_At` DATETIME(6) NULL DEFAULT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `parent_id` INT(11) NOT NULL,
  `is_activated` BIT(1) NOT NULL,
  `is_deleted` BIT(1) NOT NULL,
  PRIMARY KEY (`category_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `e_techplaza`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `e_techplaza`.`city` (
  `city_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `city_name` VARCHAR(255) NULL DEFAULT NULL,
  `country_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`city_id`),
  INDEX `FKrpd7j1p7yxr784adkx4pyepba` (`country_id` ASC) VISIBLE,
  CONSTRAINT `FKrpd7j1p7yxr784adkx4pyepba`
    FOREIGN KEY (`country_id`)
    REFERENCES `e_techplaza`.`country` (`country_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 410
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `e_techplaza`.`color`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `e_techplaza`.`color` (
  `color_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `color_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`color_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `e_techplaza`.`contact`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `e_techplaza`.`contact` (
  `contact_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `message` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `subject` VARCHAR(255) NULL DEFAULT NULL,
  `customer_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`contact_id`),
  INDEX `FKckoarj5a5jmet3b3smgdhaopw` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `FKckoarj5a5jmet3b3smgdhaopw`
    FOREIGN KEY (`customer_id`)
    REFERENCES `e_techplaza`.`customer` (`customer_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `e_techplaza`.`customer_bank`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `e_techplaza`.`customer_bank` (
  `customer_bank_id` BIGINT(20) NOT NULL,
  `bank_account_number` VARCHAR(255) NULL DEFAULT NULL,
  `created_At` DATETIME(6) NULL DEFAULT NULL,
  `updated_At` DATETIME(6) NULL DEFAULT NULL,
  `bank_id` BIGINT(20) NULL DEFAULT NULL,
  `customer_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`customer_bank_id`),
  INDEX `FKialytgl3cx448uwmkusl2p7l4` (`bank_id` ASC) VISIBLE,
  INDEX `FK3qvskjh8nan5rlu1dadptn6lu` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `FK3qvskjh8nan5rlu1dadptn6lu`
    FOREIGN KEY (`customer_id`)
    REFERENCES `e_techplaza`.`customer` (`customer_id`),
  CONSTRAINT `FKialytgl3cx448uwmkusl2p7l4`
    FOREIGN KEY (`bank_id`)
    REFERENCES `e_techplaza`.`bank` (`bank_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `e_techplaza`.`customer_bank_seq`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `e_techplaza`.`customer_bank_seq` (
  `next_val` BIGINT(20) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `e_techplaza`.`customer_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `e_techplaza`.`customer_role` (
  `customer_role_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `customer_id` BIGINT(20) NULL DEFAULT NULL,
  `role_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`customer_role_id`),
  INDEX `FKipr3etk2mjwkv6ahb4x4vwqy3` (`customer_id` ASC) VISIBLE,
  INDEX `FKmwml8muyov9xhw4423lp88n2u` (`role_id` ASC) VISIBLE,
  CONSTRAINT `FKipr3etk2mjwkv6ahb4x4vwqy3`
    FOREIGN KEY (`customer_id`)
    REFERENCES `e_techplaza`.`customer` (`customer_id`),
  CONSTRAINT `FKmwml8muyov9xhw4423lp88n2u`
    FOREIGN KEY (`role_id`)
    REFERENCES `e_techplaza`.`role` (`role_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `e_techplaza`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `e_techplaza`.`orders` (
  `order_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `address_1` VARCHAR(255) NULL DEFAULT NULL,
  `address_2` VARCHAR(255) NULL DEFAULT NULL,
  `company_name` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `order_date` DATETIME(6) NULL DEFAULT NULL,
  `order_note` VARCHAR(255) NULL DEFAULT NULL,
  `order_status` VARCHAR(255) NULL DEFAULT NULL,
  `phone` VARCHAR(255) NULL DEFAULT NULL,
  `total_amount` DOUBLE NOT NULL,
  `zipcode` VARCHAR(255) NULL DEFAULT NULL,
  `city_id` BIGINT(20) NULL DEFAULT NULL,
  `customer_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `FKj1kdsxod2g3og10lca2wmpr99` (`city_id` ASC) VISIBLE,
  INDEX `FK624gtjin3po807j3vix093tlf` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `FK624gtjin3po807j3vix093tlf`
    FOREIGN KEY (`customer_id`)
    REFERENCES `e_techplaza`.`customer` (`customer_id`),
  CONSTRAINT `FKj1kdsxod2g3og10lca2wmpr99`
    FOREIGN KEY (`city_id`)
    REFERENCES `e_techplaza`.`city` (`city_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `e_techplaza`.`order_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `e_techplaza`.`order_detail` (
  `order_detail_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `product_price` DOUBLE NOT NULL,
  `quantity` INT(11) NOT NULL,
  `total_amount` DOUBLE NOT NULL,
  `order_id` BIGINT(20) NULL DEFAULT NULL,
  `product_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`order_detail_id`),
  INDEX `FKrws2q0si6oyd6il8gqe2aennc` (`order_id` ASC) VISIBLE,
  INDEX `FKb8bg2bkty0oksa3wiq5mp5qnc` (`product_id` ASC) VISIBLE,
  CONSTRAINT `FKb8bg2bkty0oksa3wiq5mp5qnc`
    FOREIGN KEY (`product_id`)
    REFERENCES `e_techplaza`.`product` (`product_id`),
  CONSTRAINT `FKrws2q0si6oyd6il8gqe2aennc`
    FOREIGN KEY (`order_id`)
    REFERENCES `e_techplaza`.`orders` (`order_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `e_techplaza`.`product_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `e_techplaza`.`product_category` (
  `product_category_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `category_id` BIGINT(20) NULL DEFAULT NULL,
  `product_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`product_category_id`),
  INDEX `FKkud35ls1d40wpjb5htpp14q4e` (`category_id` ASC) VISIBLE,
  INDEX `FK2k3smhbruedlcrvu6clued06x` (`product_id` ASC) VISIBLE,
  CONSTRAINT `FK2k3smhbruedlcrvu6clued06x`
    FOREIGN KEY (`product_id`)
    REFERENCES `e_techplaza`.`product` (`product_id`),
  CONSTRAINT `FKkud35ls1d40wpjb5htpp14q4e`
    FOREIGN KEY (`category_id`)
    REFERENCES `e_techplaza`.`category` (`category_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 52
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `e_techplaza`.`product_image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `e_techplaza`.`product_image` (
  `product_image_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `product_image_path` VARCHAR(255) NULL DEFAULT NULL,
  `sort_order` INT(11) NOT NULL,
  `color_id` BIGINT(20) NULL DEFAULT NULL,
  `product_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`product_image_id`),
  INDEX `FKqcabopu2ex77fymxr9rhxb5uj` (`color_id` ASC) VISIBLE,
  INDEX `FK6oo0cvcdtb6qmwsga468uuukk` (`product_id` ASC) VISIBLE,
  CONSTRAINT `FK6oo0cvcdtb6qmwsga468uuukk`
    FOREIGN KEY (`product_id`)
    REFERENCES `e_techplaza`.`product` (`product_id`),
  CONSTRAINT `FKqcabopu2ex77fymxr9rhxb5uj`
    FOREIGN KEY (`color_id`)
    REFERENCES `e_techplaza`.`color` (`color_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 114
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `e_techplaza`.`product_review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `e_techplaza`.`product_review` (
  `product_review_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `comment` VARCHAR(255) NULL DEFAULT NULL,
  `created_At` DATETIME(6) NULL DEFAULT NULL,
  `num_comment` INT(11) NOT NULL,
  `rating` INT(11) NOT NULL,
  `updated_At` DATETIME(6) NULL DEFAULT NULL,
  `customer_id` BIGINT(20) NULL DEFAULT NULL,
  `product_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`product_review_id`),
  INDEX `FKq4rtmlnndigdh17ycq1lc8c7u` (`customer_id` ASC) VISIBLE,
  INDEX `FKkaqmhakwt05p3n0px81b9pdya` (`product_id` ASC) VISIBLE,
  CONSTRAINT `FKkaqmhakwt05p3n0px81b9pdya`
    FOREIGN KEY (`product_id`)
    REFERENCES `e_techplaza`.`product` (`product_id`),
  CONSTRAINT `FKq4rtmlnndigdh17ycq1lc8c7u`
    FOREIGN KEY (`customer_id`)
    REFERENCES `e_techplaza`.`customer` (`customer_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `e_techplaza`.`wishlist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `e_techplaza`.`wishlist` (
  `wishlist_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `customer_id` BIGINT(20) NULL DEFAULT NULL,
  `product_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`wishlist_id`),
  INDEX `FKb6xak0rjui1rsok8ll7ln59cs` (`customer_id` ASC) VISIBLE,
  INDEX `FKqchevbfw5wq0f4uqacns02rp7` (`product_id` ASC) VISIBLE,
  CONSTRAINT `FKb6xak0rjui1rsok8ll7ln59cs`
    FOREIGN KEY (`customer_id`)
    REFERENCES `e_techplaza`.`customer` (`customer_id`),
  CONSTRAINT `FKqchevbfw5wq0f4uqacns02rp7`
    FOREIGN KEY (`product_id`)
    REFERENCES `e_techplaza`.`product` (`product_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
