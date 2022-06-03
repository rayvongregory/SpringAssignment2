CREATE DATABASE  IF NOT EXISTS `breakfast_foods_table`;
USE `breakfast_foods_table`;
--
-- Table structure for table `employee`
--
DROP TABLE IF EXISTS `breakfast_foods`;
CREATE TABLE `breakfast_foods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100),
  `serving_size_in_grams` varchar(4),
  `calories` int(4),
  `carbs` int(4),
  `protein` int(4),
  PRIMARY KEY (`id`)
) engine=InnoDB auto_increment=1 default charset=latin1;
