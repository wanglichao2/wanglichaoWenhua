/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : qcms

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-05-22 11:25:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user_area`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_area`;
CREATE TABLE `t_user_area` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `areaCode` varchar(50) DEFAULT NULL,
  `districtCode` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_area
-- ----------------------------
