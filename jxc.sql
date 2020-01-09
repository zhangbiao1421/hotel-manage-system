/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : jxc

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2020-01-09 21:14:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hm_member
-- ----------------------------
DROP TABLE IF EXISTS `hm_member`;
CREATE TABLE `hm_member` (
  `objid` int(11) NOT NULL AUTO_INCREMENT,
  `memberName` varchar(30) DEFAULT NULL COMMENT '会员名称',
  `memberPhone` varchar(30) NOT NULL COMMENT '会员手机号',
  `memberScore` double DEFAULT NULL COMMENT '会员积分',
  `memberBirthday` varchar(10) DEFAULT NULL COMMENT '会员生日',
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`objid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='会员表';

-- ----------------------------
-- Records of hm_member
-- ----------------------------
INSERT INTO `hm_member` VALUES ('1', 'zhangbiao', '15201176702', '12', '2019-12-17', '2019-12-03 14:24:49', '2019-12-03 14:24:49');
INSERT INTO `hm_member` VALUES ('2', 'zhangli', '15536825205', '44', '2019-12-17', '2019-12-03 14:25:21', '2019-12-03 14:25:31');

-- ----------------------------
-- Table structure for hm_member_score_log
-- ----------------------------
DROP TABLE IF EXISTS `hm_member_score_log`;
CREATE TABLE `hm_member_score_log` (
  `objid` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(11) DEFAULT NULL COMMENT '会员手机号，关联hm_member的memberphone',
  `memberscore` double DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '积分增加/删除状态 1 增加 2 删除',
  `createtime` datetime DEFAULT NULL,
  `upaatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`objid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='会员积分记录表';

-- ----------------------------
-- Records of hm_member_score_log
-- ----------------------------
INSERT INTO `hm_member_score_log` VALUES ('1', '15201176702', '12', '1', '2019-12-03 14:24:49', '2019-12-03 14:24:49');
INSERT INTO `hm_member_score_log` VALUES ('2', '15536825205', '12', '1', '2019-12-03 14:25:21', '2019-12-03 14:25:21');
INSERT INTO `hm_member_score_log` VALUES ('3', '15536825205', '32', '1', '2019-12-03 14:25:31', '2019-12-03 14:25:31');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identify` varchar(255) DEFAULT NULL COMMENT '菜单标识',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(255) DEFAULT NULL COMMENT '菜单地址',
  `iconCls` varchar(255) DEFAULT NULL COMMENT '菜单标识',
  `parentid` int(11) DEFAULT NULL COMMENT '父分类id  如果是父分类，该值为空',
  `order` int(11) DEFAULT NULL COMMENT '菜单顺序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', 'hygl', '会员管理', null, 'fa fa-coffee', '1', null);
INSERT INTO `sys_menu` VALUES ('2', 'hyjfgl', '会员积分管理', null, 'fa fa-sitemap', '1', '1');

-- ----------------------------
-- Table structure for sys_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `sys_userinfo`;
CREATE TABLE `sys_userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `bitthday` varchar(8) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户登陆表';

-- ----------------------------
-- Records of sys_userinfo
-- ----------------------------
INSERT INTO `sys_userinfo` VALUES ('1', 'admin', '123456', null, null, null, null, null);
