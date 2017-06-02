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
  `userId` bigint(11) DEFAULT NULL,
  `areaCode` varchar(50) DEFAULT NULL,
  `districtCode` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_area
-- ----------------------------


SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_netbar_deploy`
-- ----------------------------
DROP TABLE IF EXISTS `t_netbar_deploy`;
CREATE TABLE `t_netbar_deploy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `netbarCode` varchar(50)  DEFAULT NULL,
  `detectNum` varchar(20) DEFAULT NULL,
  `installNum` varchar(20) DEFAULT NULL,
  `is_deploy` varchar(20) DEFAULT NULL,
  `onlineNum` varchar(20) DEFAULT NULL,
  `reportTime` varchar(20) DEFAULT NULL,
  `status` int DEFAULT NULL,
   `deployTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of t_netbar_deploy
-- ----------------------------