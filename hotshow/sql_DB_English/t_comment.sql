SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `type` varchar(100) DEFAULT NULL,
  `comment_sum` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES ('Childcare', '2362');
INSERT INTO `t_comment` VALUES ('International', '47195');
INSERT INTO `t_comment` VALUES ('Home', '1576');
INSERT INTO `t_comment` VALUES ('Military', '43821');
INSERT INTO `t_comment` VALUES ('Entertainment', '30400');
INSERT INTO `t_comment` VALUES ('Tour', '12604');
INSERT INTO `t_comment` VALUES ('Agriculture', '12680');
INSERT INTO `t_comment` VALUES ('Job&Workplace', '2891');
INSERT INTO `t_comment` VALUES ('pet', '1928');
INSERT INTO `t_comment` VALUES ('Education', '58434');
INSERT INTO `t_comment` VALUES ('Animal', '1075');
INSERT INTO `t_comment` VALUES ('Life', '8511');
INSERT INTO `t_comment` VALUES ('Sports', '88');
INSERT INTO `t_comment` VALUES ('Property', '9609');
INSERT INTO `t_comment` VALUES ('Cate ', '8157'); 

INSERT INTO `t_comment` VALUES ('Finance', '7714');
INSERT INTO `t_comment` VALUES ('Photography', '3268');
INSERT INTO `t_comment` VALUES ('Media', '994');
INSERT INTO `t_comment` VALUES ('IT Techniques', '19');
INSERT INTO `t_comment` VALUES ('Culture', '5046');
INSERT INTO `t_comment` VALUES ('Anime', '3905');
INSERT INTO `t_comment` VALUES ('Other', '31622');
INSERT INTO `t_comment` VALUES ('Technology', '14111');
INSERT INTO `t_comment` VALUES ('History', '40890');
INSERT INTO `t_comment` VALUES ('Emotion', '595');
INSERT INTO `t_comment` VALUES ('Health', '20567');
INSERT INTO `t_comment` VALUES ('Science', '5942');
INSERT INTO `t_comment` VALUES ('Design', '76');
INSERT INTO `t_comment` VALUES ('Politics', '41656');
INSERT INTO `t_comment` VALUES ('Auto', '11030');
INSERT INTO `t_comment` VALUES ('Fashion', '225');
INSERT INTO `t_comment` VALUES ('Essay', '3801');
INSERT INTO `t_comment` VALUES ('', '525');
INSERT INTO `t_comment` VALUES ('Game', '1235');
INSERT INTO `t_comment` VALUES ('story', '353');
INSERT INTO `t_comment` VALUES ('Society', '128797');
INSERT INTO `t_comment` VALUES ('Digital', '18071');
