/*
Navicat MySQL Data Transfer

Source Server         : 106.13.32.249-mysql
Source Server Version : 50714
Source Host           : 106.13.32.249:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2019-03-12 12:05:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type` (
  `type` varchar(100) DEFAULT NULL,
  `count` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_type
-- ----------------------------
INSERT INTO `t_type` VALUES ('Childcare', '11');
INSERT INTO `t_type` VALUES ('International', '236');
INSERT INTO `t_type` VALUES ('Home', '12');
INSERT INTO `t_type` VALUES ('Military', '181');
INSERT INTO `t_type` VALUES ('Entertainment', '51');
INSERT INTO `t_type` VALUES ('Tour', '25');
INSERT INTO `t_type` VALUES ('Agriculture', '14');
INSERT INTO `t_type` VALUES ('pet', '3');
INSERT INTO `t_type` VALUES ('Job&Workplace', '10');
INSERT INTO `t_type` VALUES ('Education', '20');
INSERT INTO `t_type` VALUES ('Animal', '2');
INSERT INTO `t_type` VALUES ('Life', '13');
INSERT INTO `t_type` VALUES ('Sports', '5');
INSERT INTO `t_type` VALUES ('Property', '19');
INSERT INTO `t_type` VALUES ('Cate', '26');
INSERT INTO `t_type` VALUES ('Finance', '26');
INSERT INTO `t_type` VALUES ('Photography', '19');
INSERT INTO `t_type` VALUES ('Media', '5');
INSERT INTO `t_type` VALUES ('Culture', '24');
INSERT INTO `t_type` VALUES ('IT Techniques', '1');
INSERT INTO `t_type` VALUES ('Anime', '4');
INSERT INTO `t_type` VALUES ('Other', '56');
INSERT INTO `t_type` VALUES ('Technology', '51');
INSERT INTO `t_type` VALUES ('History', '35');
INSERT INTO `t_type` VALUES ('Emotion', '2');
INSERT INTO `t_type` VALUES ('Health', '31');
INSERT INTO `t_type` VALUES ('Science', '41');
INSERT INTO `t_type` VALUES ('Design', '1');
INSERT INTO `t_type` VALUES ('Auto', '47');
INSERT INTO `t_type` VALUES ('Fashion', '1');
INSERT INTO `t_type` VALUES ('Politics', '156');
INSERT INTO `t_type` VALUES ('Game', '53');
INSERT INTO `t_type` VALUES ('Essay', '9');
INSERT INTO `t_type` VALUES ('story', '1');
INSERT INTO `t_type` VALUES ('Society', '221'); 
INSERT INTO `t_type` VALUES ('Digital', '60');
