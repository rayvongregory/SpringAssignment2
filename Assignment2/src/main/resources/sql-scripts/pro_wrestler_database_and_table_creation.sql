CREATE DATABASE  IF NOT EXISTS `pro_wrestlers_table`;
USE `pro_wrestlers_table`;
--
-- Table structure for table `employee`
--
DROP TABLE IF EXISTS `pro_wrestlers`;
CREATE TABLE `pro_wrestlers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ring_name` varchar(45) DEFAULT NULL,
  `real_name` varchar(45) DEFAULT NULL,
  `finisher` varchar(45) DEFAULT NULL,
  `active` boolean DEFAULT true,
  PRIMARY KEY (`id`)
) engine=InnoDB auto_increment=1 default charset=latin1;
