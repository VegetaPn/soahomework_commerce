/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50621
Source Host           : 127.0.0.1:3306
Source Database       : soaworktwo

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-05-15 21:21:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', 'asfd');

-- ----------------------------
-- Table structure for logistic_record
-- ----------------------------
DROP TABLE IF EXISTS `logistic_record`;
CREATE TABLE `logistic_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `progress` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `logistic_order` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logistic_record
-- ----------------------------
INSERT INTO `logistic_record` VALUES ('1', '6', '配送中', '0');

-- ----------------------------
-- Table structure for manufacture_record
-- ----------------------------
DROP TABLE IF EXISTS `manufacture_record`;
CREATE TABLE `manufacture_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `manufacture_order` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manufacture_record
-- ----------------------------
INSERT INTO `manufacture_record` VALUES ('1', '3', '0');
INSERT INTO `manufacture_record` VALUES ('2', '6', '0');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id_list` varchar(255) NOT NULL,
  `product_num_list` varchar(255) NOT NULL,
  `total_price` decimal(10,0) NOT NULL DEFAULT '0',
  `customer_id` int(11) DEFAULT NULL,
  `ship_address` varchar(255) NOT NULL,
  `process` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `order_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', 'asdf', 'f', '123', '1', 'asdf', null);
INSERT INTO `order` VALUES ('2', 'asdf', 'f', '123', '1', 'asdf', null);
INSERT INTO `order` VALUES ('3', '2,3', '1,2', '46', '1', 'sdf', null);
INSERT INTO `order` VALUES ('4', '2,3', '1,2', '46', '1', 'sdf', null);
INSERT INTO `order` VALUES ('5', '2,3', '1,2', '46', '1', 'sdf', null);
INSERT INTO `order` VALUES ('6', '2,3', '1,2', '46', '1', '北京海淀', '物流配送中');
INSERT INTO `order` VALUES ('7', '2,3', '1,2', '46', '1', '北京海淀', '顾客已下单');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` decimal(10,0) NOT NULL DEFAULT '0',
  `stock` int(11) NOT NULL DEFAULT '100',
  `status` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '2', '2', '23', '100', '1');
INSERT INTO `product` VALUES ('2', '3', '3', '3', '98', '1');
INSERT INTO `product` VALUES ('3', '33', '33', '0', '107', '1');
