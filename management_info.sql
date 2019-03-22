/*
Navicat MySQL Data Transfer

Source Server         : renthouse
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : management_info

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-03-22 17:51:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for grade_mark
-- ----------------------------
DROP TABLE IF EXISTS `grade_mark`;
CREATE TABLE `grade_mark` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `sc_id` int(16) DEFAULT NULL COMMENT '学校id',
  `m_id` int(16) DEFAULT NULL COMMENT '专业id',
  `grade` int(16) DEFAULT NULL COMMENT '分数线',
  `klklkl` varchar(16) DEFAULT NULL COMMENT '备用字段',
  `jljljl` varchar(16) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade_mark
-- ----------------------------

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL COMMENT '专业名字',
  `cdcdcd` varchar(16) DEFAULT NULL COMMENT '备用字段',
  `dedede` varchar(16) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of major
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('5', '0', '系统管理', '', '', '1', '0', '&#xe716;', null, '2019-03-21 16:50:59');
INSERT INTO `permission` VALUES ('6', '5', '用户管理', '/user/user', 'user:user', '1', '1', null, null, null);
INSERT INTO `permission` VALUES ('7', '5', '角色管理', '/role/role', 'role:role', '1', '1', null, null, null);
INSERT INTO `permission` VALUES ('8', '5', '权限管理', '/permission/permission', 'permission:permission', null, '1', null, null, '2019-03-22 10:54:14');
INSERT INTO `permission` VALUES ('58', '0', '学校管理', '', '', null, '0', null, null, null);
INSERT INTO `permission` VALUES ('59', '58', '学校管理', '/school/school', 'school:school', null, '1', null, null, null);
INSERT INTO `permission` VALUES ('60', '58', '添加', '/school/school/add', 'school:school:add', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('61', '58', '编辑', '/school/school/edit', 'school:school:edit', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('62', '58', '删除', '/school/school/remove', 'school:school:remove', null, '2', null, null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', '管理员', null, '2019-03-21 09:33:59');

-- ----------------------------
-- Table structure for role_per
-- ----------------------------
DROP TABLE IF EXISTS `role_per`;
CREATE TABLE `role_per` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `role_id` int(16) DEFAULT NULL,
  `per_id` int(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=281 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of role_per
-- ----------------------------
INSERT INTO `role_per` VALUES ('2', '2', '1');
INSERT INTO `role_per` VALUES ('3', '2', '2');
INSERT INTO `role_per` VALUES ('4', '2', '3');
INSERT INTO `role_per` VALUES ('5', '2', '5');
INSERT INTO `role_per` VALUES ('6', '2', '6');
INSERT INTO `role_per` VALUES ('7', '2', '7');
INSERT INTO `role_per` VALUES ('8', '2', '8');
INSERT INTO `role_per` VALUES ('268', '18', '8');
INSERT INTO `role_per` VALUES ('269', '18', '7');
INSERT INTO `role_per` VALUES ('270', '18', '5');
INSERT INTO `role_per` VALUES ('271', '1', '-1');
INSERT INTO `role_per` VALUES ('272', '1', '62');
INSERT INTO `role_per` VALUES ('273', '1', '61');
INSERT INTO `role_per` VALUES ('274', '1', '60');
INSERT INTO `role_per` VALUES ('275', '1', '59');
INSERT INTO `role_per` VALUES ('276', '1', '8');
INSERT INTO `role_per` VALUES ('277', '1', '7');
INSERT INTO `role_per` VALUES ('278', '1', '6');
INSERT INTO `role_per` VALUES ('279', '1', '58');
INSERT INTO `role_per` VALUES ('280', '1', '5');

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(16) DEFAULT NULL COMMENT '学校名字',
  `enrollment_guide` varchar(255) DEFAULT NULL COMMENT '招生简章',
  `item_bank` varchar(255) DEFAULT NULL COMMENT '试题库',
  `aaaa` varchar(32) DEFAULT NULL COMMENT '备用字段1',
  `bbbb` varchar(255) DEFAULT NULL COMMENT '备用字段2',
  `cccc` varchar(255) DEFAULT NULL COMMENT '备用字段1',
  `dddd` varchar(255) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES ('1', '负担大学', 'sgs', 'sga', '', '', '', '');

-- ----------------------------
-- Table structure for sc_sub
-- ----------------------------
DROP TABLE IF EXISTS `sc_sub`;
CREATE TABLE `sc_sub` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sc_id` int(16) DEFAULT NULL COMMENT '学校id',
  `sub_id` int(16) DEFAULT NULL COMMENT '学科id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sc_sub
-- ----------------------------

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(16) DEFAULT NULL,
  `ababab` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `bcbcbc` varchar(255) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject
-- ----------------------------

-- ----------------------------
-- Table structure for sub_m
-- ----------------------------
DROP TABLE IF EXISTS `sub_m`;
CREATE TABLE `sub_m` (
  `id` int(16) NOT NULL,
  `sub_id` int(16) DEFAULT NULL COMMENT '学科id',
  `m_id` int(16) DEFAULT NULL COMMENT '专业id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sub_m
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '系统管理员', 'admin', 'admin', '13283354149', '男', '1122', '1', '2019-03-15 10:24:33', '2019-03-21 09:34:11');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `user_id` int(16) DEFAULT NULL,
  `role_id` int(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('27', '57', '1');
INSERT INTO `user_role` VALUES ('29', '1', '1');
