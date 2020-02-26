/*
Navicat MySQL Data Transfer

Source Server         : 106.13.32.249-mysql
Source Server Version : 50714
Source Host           : 106.13.32.249:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2019-03-12 12:05:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_publish
-- ----------------------------
DROP TABLE IF EXISTS `t_publish`;
CREATE TABLE `t_publish` (
  `time_hour` int(10) DEFAULT NULL,
  `publish_cnt` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_publish
-- ----------------------------
INSERT INTO `t_publish` VALUES ('0', '18');
INSERT INTO `t_publish` VALUES ('2', '10');
INSERT INTO `t_publish` VALUES ('3', '3');
INSERT INTO `t_publish` VALUES ('1', '5');
INSERT INTO `t_publish` VALUES ('5', '3');
INSERT INTO `t_publish` VALUES ('6', '19');
INSERT INTO `t_publish` VALUES ('7', '46');
INSERT INTO `t_publish` VALUES ('8', '61');
INSERT INTO `t_publish` VALUES ('9', '80');
INSERT INTO `t_publish` VALUES ('10', '115');
INSERT INTO `t_publish` VALUES ('11', '95');
INSERT INTO `t_publish` VALUES ('12', '86');
INSERT INTO `t_publish` VALUES ('13', '70');
INSERT INTO `t_publish` VALUES ('15', '72');
INSERT INTO `t_publish` VALUES ('14', '76');
INSERT INTO `t_publish` VALUES ('16', '91');
INSERT INTO `t_publish` VALUES ('17', '117');
INSERT INTO `t_publish` VALUES ('18', '96');
INSERT INTO `t_publish` VALUES ('19', '99');
INSERT INTO `t_publish` VALUES ('20', '77');
INSERT INTO `t_publish` VALUES ('21', '81');
INSERT INTO `t_publish` VALUES ('22', '88');
INSERT INTO `t_publish` VALUES ('23', '42');
