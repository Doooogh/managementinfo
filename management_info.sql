/*
Navicat MySQL Data Transfer

Source Server         : renthouse
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : management_info

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-03-20 18:47:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` int(16) DEFAULT '0' COMMENT '父id',
  `name` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '权限描述',
  `url` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `permission` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sort` int(16) DEFAULT NULL,
  `type` int(8) DEFAULT NULL COMMENT '类型',
  `img` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '图标',
  `createtime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updatetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(16) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色名称',
  `sign` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '权限所有',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('15', '管理员', '管理员', null, null);
INSERT INTO `role` VALUES ('16', '中介', '中介', null, null);
INSERT INTO `role` VALUES ('17', '管理员测试', '管理员', null, null);

-- ----------------------------
-- Table structure for role_per
-- ----------------------------
DROP TABLE IF EXISTS `role_per`;
CREATE TABLE `role_per` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `role_id` int(16) DEFAULT NULL,
  `per_id` int(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=263 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of role_per
-- ----------------------------
INSERT INTO `role_per` VALUES ('134', '17', '49');
INSERT INTO `role_per` VALUES ('135', '17', '48');
INSERT INTO `role_per` VALUES ('136', '17', '47');
INSERT INTO `role_per` VALUES ('137', '17', '44');
INSERT INTO `role_per` VALUES ('138', '17', '43');
INSERT INTO `role_per` VALUES ('139', '17', '42');
INSERT INTO `role_per` VALUES ('140', '17', '38');
INSERT INTO `role_per` VALUES ('141', '17', '37');
INSERT INTO `role_per` VALUES ('142', '17', '36');
INSERT INTO `role_per` VALUES ('143', '17', '34');
INSERT INTO `role_per` VALUES ('144', '17', '32');
INSERT INTO `role_per` VALUES ('145', '17', '31');
INSERT INTO `role_per` VALUES ('146', '17', '30');
INSERT INTO `role_per` VALUES ('147', '17', '29');
INSERT INTO `role_per` VALUES ('148', '17', '28');
INSERT INTO `role_per` VALUES ('149', '17', '27');
INSERT INTO `role_per` VALUES ('150', '17', '23');
INSERT INTO `role_per` VALUES ('151', '17', '22');
INSERT INTO `role_per` VALUES ('152', '17', '21');
INSERT INTO `role_per` VALUES ('153', '17', '20');
INSERT INTO `role_per` VALUES ('154', '17', '18');
INSERT INTO `role_per` VALUES ('155', '17', '45');
INSERT INTO `role_per` VALUES ('156', '17', '41');
INSERT INTO `role_per` VALUES ('157', '17', '35');
INSERT INTO `role_per` VALUES ('158', '17', '33');
INSERT INTO `role_per` VALUES ('159', '17', '26');
INSERT INTO `role_per` VALUES ('160', '17', '25');
INSERT INTO `role_per` VALUES ('161', '17', '24');
INSERT INTO `role_per` VALUES ('162', '17', '19');
INSERT INTO `role_per` VALUES ('163', '17', '17');
INSERT INTO `role_per` VALUES ('164', '17', '46');
INSERT INTO `role_per` VALUES ('165', '17', '52');
INSERT INTO `role_per` VALUES ('166', '17', '51');
INSERT INTO `role_per` VALUES ('167', '17', '50');
INSERT INTO `role_per` VALUES ('168', '17', '39');
INSERT INTO `role_per` VALUES ('169', '17', '-1');
INSERT INTO `role_per` VALUES ('206', '15', '52');
INSERT INTO `role_per` VALUES ('207', '15', '51');
INSERT INTO `role_per` VALUES ('208', '15', '50');
INSERT INTO `role_per` VALUES ('209', '15', '49');
INSERT INTO `role_per` VALUES ('210', '15', '48');
INSERT INTO `role_per` VALUES ('211', '15', '47');
INSERT INTO `role_per` VALUES ('212', '15', '44');
INSERT INTO `role_per` VALUES ('213', '15', '43');
INSERT INTO `role_per` VALUES ('214', '15', '42');
INSERT INTO `role_per` VALUES ('215', '15', '38');
INSERT INTO `role_per` VALUES ('216', '15', '37');
INSERT INTO `role_per` VALUES ('217', '15', '36');
INSERT INTO `role_per` VALUES ('218', '15', '34');
INSERT INTO `role_per` VALUES ('219', '15', '32');
INSERT INTO `role_per` VALUES ('220', '15', '31');
INSERT INTO `role_per` VALUES ('221', '15', '30');
INSERT INTO `role_per` VALUES ('222', '15', '29');
INSERT INTO `role_per` VALUES ('223', '15', '28');
INSERT INTO `role_per` VALUES ('224', '15', '27');
INSERT INTO `role_per` VALUES ('225', '15', '23');
INSERT INTO `role_per` VALUES ('226', '15', '22');
INSERT INTO `role_per` VALUES ('227', '15', '21');
INSERT INTO `role_per` VALUES ('228', '15', '20');
INSERT INTO `role_per` VALUES ('229', '15', '18');
INSERT INTO `role_per` VALUES ('230', '15', '46');
INSERT INTO `role_per` VALUES ('231', '15', '41');
INSERT INTO `role_per` VALUES ('232', '15', '35');
INSERT INTO `role_per` VALUES ('233', '15', '33');
INSERT INTO `role_per` VALUES ('234', '15', '26');
INSERT INTO `role_per` VALUES ('235', '15', '25');
INSERT INTO `role_per` VALUES ('236', '15', '24');
INSERT INTO `role_per` VALUES ('237', '15', '19');
INSERT INTO `role_per` VALUES ('238', '15', '17');
INSERT INTO `role_per` VALUES ('239', '15', '54');
INSERT INTO `role_per` VALUES ('240', '15', '45');
INSERT INTO `role_per` VALUES ('241', '15', '39');
INSERT INTO `role_per` VALUES ('242', '15', '-1');
INSERT INTO `role_per` VALUES ('260', '16', '18');
INSERT INTO `role_per` VALUES ('261', '16', '17');
INSERT INTO `role_per` VALUES ('262', '16', '-1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(16) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户昵称',
  `username` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '密码',
  `phone` char(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机号',
  `sex` char(2) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '性别',
  `age` int(8) DEFAULT NULL COMMENT '年龄',
  `status` int(4) DEFAULT NULL COMMENT '状态',
  `createtime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updatetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('28', '系统管理员', 'admin', 'admin', '13283354149', '男', '1122', '1', '2019-03-15 10:24:33', null);
INSERT INTO `user` VALUES ('29', '测试人员', 'testman', '123', '13283354149', '男', '22', '1', '2019-03-18 16:55:20', '2019-03-19 12:23:47');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `user_id` int(16) DEFAULT NULL,
  `role_id` int(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('24', '28', '15');
INSERT INTO `user_role` VALUES ('26', '29', '16');
