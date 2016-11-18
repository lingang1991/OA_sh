/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50045
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50045
File Encoding         : 65001

Date: 2016-10-19 09:27:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for employeeout
-- ----------------------------
DROP TABLE IF EXISTS `employeeout`;
CREATE TABLE `employeeout` (
  `eid` varchar(8) NOT NULL,
  `enumb` varchar(255) default NULL,
  `ename` varchar(255) default NULL,
  `eoutcity` varchar(255) default NULL,
  `eoutdays` varchar(255) default NULL,
  `echecked` varchar(255) default NULL,
  `eoutcontent` varchar(255) default NULL,
  `eoutbt` date default NULL,
  `eoutot` date default NULL,
  PRIMARY KEY  (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employeeout
-- ----------------------------

-- ----------------------------
-- Table structure for employeerest
-- ----------------------------
DROP TABLE IF EXISTS `employeerest`;
CREATE TABLE `employeerest` (
  `eid` varchar(8) NOT NULL,
  `enumb` varchar(255) default NULL,
  `ename` varchar(255) default NULL,
  `erestremained` varchar(255) default NULL,
  `erestreason` varchar(255) default NULL,
  `eresthours` varchar(255) default NULL,
  `erestday` date default NULL,
  `eresttime` varchar(255) default NULL,
  PRIMARY KEY  (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employeerest
-- ----------------------------

-- ----------------------------
-- Table structure for employeesupply
-- ----------------------------
DROP TABLE IF EXISTS `employeesupply`;
CREATE TABLE `employeesupply` (
  `sid` varchar(8) NOT NULL,
  `sreimburse` int(11) default NULL,
  `snumbs` int(11) default NULL,
  `stimes` int(11) default NULL,
  `scooperate` varchar(255) default NULL,
  `senum` varchar(255) default NULL,
  `sename` varchar(255) default NULL,
  `sday` date default NULL,
  `sholiday` varchar(255) default NULL,
  `sreason` varchar(255) default NULL,
  PRIMARY KEY  (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employeesupply
-- ----------------------------

-- ----------------------------
-- Table structure for employeetaxi
-- ----------------------------
DROP TABLE IF EXISTS `employeetaxi`;
CREATE TABLE `employeetaxi` (
  `eid` varchar(8) NOT NULL,
  `enumb` varchar(255) default NULL,
  `ename` varchar(255) default NULL,
  `etaxiday` date default NULL,
  `etaxigo` varchar(255) default NULL,
  `etaxicost` varchar(255) default NULL,
  PRIMARY KEY  (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employeetaxi
-- ----------------------------

-- ----------------------------
-- Table structure for employeetaxisupply
-- ----------------------------
DROP TABLE IF EXISTS `employeetaxisupply`;
CREATE TABLE `employeetaxisupply` (
  `eid` varchar(8) NOT NULL,
  `enumb` varchar(255) default NULL,
  `ename` varchar(255) default NULL,
  `eallcost` varchar(255) default NULL,
  PRIMARY KEY  (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employeetaxisupply
-- ----------------------------

-- ----------------------------
-- Table structure for employeework
-- ----------------------------
DROP TABLE IF EXISTS `employeework`;
CREATE TABLE `employeework` (
  `eid` varchar(8) NOT NULL,
  `enumb` varchar(255) default NULL,
  `ename` varchar(255) default NULL,
  `eworktime` varchar(255) default NULL,
  `eworkhours` varchar(255) default NULL,
  `eworkcity` varchar(255) default NULL,
  `eworkday` date default NULL,
  `eworklocation` varchar(255) default NULL,
  `eworkcontent` varchar(255) default NULL,
  PRIMARY KEY  (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employeework
-- ----------------------------
INSERT INTO `employeework` VALUES ('1', '68663', '张靖南', '18:30-21:00', '2.5', '南京', '0016-09-06', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('10', '69019', '门秀丽', '18:30-21:00', '2.5', '南京', '0016-09-13', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('11', '69019', '门秀丽', '18:30-21:00', '2.5', '南京', '0016-09-20', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('12', '69019', '门秀丽', '18:30-21:00', '2.5', '南京', '0016-09-22', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('13', '69019', '门秀丽', '18:30-21:00', '2.5', '南京', '0016-09-29', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('14', '69449', '胡维达', '18:30-21:00', '2.5', '南京', '0016-09-01', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('15', '69449', '胡维达', '18:30-21:00', '2.5', '南京', '0016-09-06', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('16', '69449', '胡维达', '18:30-21:00', '2.5', '南京', '0016-09-08', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('17', '70990', '张存存', '18:30-21:00', '2.5', '南京', '0016-09-01', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('18', '70990', '张存存', '18:30-21:00', '2.5', '南京', '0016-09-06', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('19', '70990', '张存存', '18:30-21:00', '2.5', '南京', '0016-09-08', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('2', '68663', '张靖南', '18:30-21:00', '2.5', '南京', '0016-09-20', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('20', '70990', '张存存', '18:30-21:00', '2.5', '南京', '0016-09-13', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('21', '70990', '张存存', '18:30-21:00', '2.5', '南京', '0016-09-20', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('22', '70990', '张存存', '18:30-21:00', '2.5', '南京', '0016-09-22', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('23', '70990', '张存存', '18:30-21:00', '2.5', '南京', '0016-09-29', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('24', '71707', '马国强', '18:30-21:00', '2.5', '南京', '0016-09-01', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('25', '71707', '马国强', '18:30-21:00', '2.5', '南京', '0016-09-06', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('26', '71707', '马国强', '18:30-21:00', '2.5', '南京', '0016-09-08', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('27', '71707', '马国强', '18:30-21:00', '2.5', '南京', '0016-09-13', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('28', '71707', '马国强', '18:30-21:00', '2.5', '南京', '0016-09-16', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('29', '71707', '马国强', '18:30-21:00', '2.5', '南京', '0016-09-20', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('3', '68663', '张靖南', '18:30-21:00', '2.5', '南京', '0016-09-22', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('30', '71707', '马国强', '18:30-21:00', '2.5', '南京', '0016-09-22', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('31', '71707', '马国强', '18:30-21:00', '2.5', '南京', '0016-09-29', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('32', '73360', '朱新飞', '18:30-21:00', '2.5', '南京', '0016-09-01', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('33', '73360', '朱新飞', '18:30-21:00', '2.5', '南京', '0016-09-08', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('34', '73360', '朱新飞', '18:30-21:00', '2.5', '南京', '0016-09-12', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('35', '73360', '朱新飞', '18:30-21:00', '2.5', '南京', '0016-09-20', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('36', '73360', '朱新飞', '18:30-21:00', '2.5', '南京', '0016-09-22', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('37', '73360', '朱新飞', '18:30-21:00', '2.5', '南京', '0016-09-29', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('38', '73876', '王乐', '18:30-21:00', '2.5', '南京', '0016-09-01', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('39', '73876', '王乐', '18:30-21:00', '2.5', '南京', '0016-09-06', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('4', '68663', '张靖南', '18:30-21:00', '2.5', '南京', '0016-09-29', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('40', '73876', '王乐', '18:30-21:00', '2.5', '南京', '0016-09-08', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('41', '73876', '王乐', '18:30-21:00', '2.5', '南京', '0016-09-20', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('42', '73876', '王乐', '18:30-21:00', '2.5', '南京', '0016-09-22', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('43', '73876', '王乐', '18:30-21:00', '2.5', '南京', '0016-09-29', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('44', '75264', '林钢', '18:30-21:00', '2.5', '南京', '0016-09-22', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('45', '75413', '徐业鑫', '18:30-21:00', '2.5', '南京', '0016-09-06', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('46', '75413', '徐业鑫', '18:30-21:00', '2.5', '南京', '0016-09-08', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('47', '75413', '徐业鑫', '18:30-21:00', '2.5', '南京', '0016-09-13', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('48', '75413', '徐业鑫', '18:30-21:00', '2.5', '南京', '0016-09-20', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('49', '75413', '徐业鑫', '18:30-21:00', '2.5', '南京', '0016-09-22', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('5', '68664', '张靖南', '18:30-21:00', '2.5', '南京', '0016-09-01', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('50', '75413', '徐业鑫', '18:30-21:00', '2.5', '南京', '0016-09-29', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('51', '75489', '张成', '18:30-21:00', '2.5', '南京', '0016-09-13', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('52', '75489', '张成', '18:30-21:00', '2.5', '南京', '0016-09-20', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('53', '75489', '张成', '18:30-21:00', '2.5', '南京', '0016-09-22', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('54', '75489', '张成', '18:30-21:00', '2.5', '南京', '0016-09-29', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('55', '75507', '邵家松', '18:30-21:00', '9', '南京', '0016-09-01', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('56', '75507', '邵家松', '18:30-21:00', '9', '南京', '0016-09-06', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('57', '75507', '邵家松', '18:30-21:00', '9', '南京', '0016-09-08', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('58', '75507', '邵家松', '18:30-21:00', '2.5', '南京', '0016-09-20', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('59', '75507', '邵家松', '18:30-21:00', '2.5', '南京', '0016-09-22', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('6', '68664', '张靖南', '18:30-21:00', '2.5', '南京', '0016-09-08', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('60', '75599', '高雅', '18:30-21:00', '2.5', '南京', '0016-09-01', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('61', '75599', '高雅', '18:30-21:00', '2.5', '南京', '0016-09-06', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('62', '75599', '高雅', '18:30-21:00', '2.5', '南京', '0016-09-08', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('63', '75599', '高雅', '18:30-21:00', '2.5', '南京', '0016-09-20', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('64', '75599', '高雅', '18:30-21:00', '2.5', '南京', '0016-09-22', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('65', '71082', '张亚', '18:30-21:00', '2.5', '南京', '0016-09-13', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('66', '71082', '张亚', '18:30-21:00', '2.5', '南京', '0016-09-20', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('67', '71082', '张亚', '18:30-21:00', '2.5', '南京', '0016-09-22', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('68', '72829', '王书同', '18:30-21:00', '2.5', '南京', '0016-09-06', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('69', '72829', '王书同', '18:30-21:00', '2.5', '南京', '0016-09-09', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('7', '69019', '门秀丽', '18:30-21:00', '2.5', '南京', '0016-09-01', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('70', '72829', '王书同', '18:30-21:00', '2.5', '南京', '0016-09-20', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('71', '72829', '王书同', '18:30-21:00', '2.5', '南京', '0016-09-22', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('72', '73263', '李韧', '18:30-21:00', '2.5', '南京', '0016-09-01', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('73', '73263', '李韧', '18:30-21:00', '2.5', '南京', '0016-09-06', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('74', '73263', '李韧', '18:30-21:00', '2.5', '南京', '0016-09-20', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('75', '73263', '李韧', '18:30-21:00', '2.5', '南京', '0016-09-22', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('76', '75513', '张婷', '18:30-21:00', '2.5', '南京', '0016-09-20', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('77', '75513', '张婷', '18:30-21:00', '2.5', '南京', '0016-09-22', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('78', '64715', '朱健', '18:30-21:00', '2.5', '南京', '0016-09-01', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('79', '64715', '朱健', '18:30-21:00', '2.5', '南京', '0016-09-06', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('8', '69019', '门秀丽', '18:30-21:00', '2.5', '南京', '0016-09-06', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('80', '64715', '朱健', '18:30-21:00', '2.5', '南京', '0016-09-08', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('81', '64715', '朱健', '18:30-21:00', '2.5', '南京', '0016-09-13', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('82', '64715', '朱健', '18:30-21:00', '2.5', '南京', '0016-09-20', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('83', '64715', '朱健', '18:30-21:00', '2.5', '南京', '0016-09-22', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('84', '64715', '朱健', '18:30-21:00', '2.5', '南京', '0016-09-29', '公司', '平台开发');
INSERT INTO `employeework` VALUES ('9', '69019', '门秀丽', '18:30-21:00', '2.5', '南京', '0016-09-08', '公司', '平台开发');

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `sid` varchar(8) NOT NULL,
  `sname` varchar(255) default NULL,
  `gender` varchar(255) default NULL,
  `birthday` date default NULL,
  `address` varchar(255) default NULL,
  PRIMARY KEY  (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of students
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `uid` int(11) NOT NULL auto_increment,
  `username` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  PRIMARY KEY  (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '林钢', '12345678');
