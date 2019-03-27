/*
Navicat MySQL Data Transfer

Source Server         : renthouse
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : management_info

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-03-27 17:09:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `name` varchar(16) DEFAULT NULL COMMENT '名字',
  `url` varchar(128) DEFAULT NULL COMMENT '课程地址',
  `size` varchar(16) DEFAULT NULL COMMENT '课程大小',
  `oioioi` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `ioioio` varchar(255) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for enrollment_guide
-- ----------------------------
DROP TABLE IF EXISTS `enrollment_guide`;
CREATE TABLE `enrollment_guide` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `url` varchar(255) DEFAULT NULL COMMENT '文件路径',
  `createtime` timestamp NULL DEFAULT NULL,
  `updatetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `pooppoo` varchar(255) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enrollment_guide
-- ----------------------------
INSERT INTO `enrollment_guide` VALUES ('17', 'f:\\file\\eguide\\7464a0eb-0f9c-4453-9b62-cb48609e6a662.txt', '2019-03-25 09:49:31', null, null);
INSERT INTO `enrollment_guide` VALUES ('18', 'f:\\file\\eguide\\93e8f51c-bd4e-4499-9ec7-b7667ee2e9173.txt', '2019-03-25 09:50:47', '2019-03-25 09:50:59', null);

-- ----------------------------
-- Table structure for grade_mark
-- ----------------------------
DROP TABLE IF EXISTS `grade_mark`;
CREATE TABLE `grade_mark` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `sc_id` int(16) DEFAULT NULL COMMENT '学校id',
  `m_id` int(16) DEFAULT NULL COMMENT '专业id',
  `grade` int(16) DEFAULT NULL COMMENT '分数线',
  `year` varchar(16) DEFAULT NULL COMMENT '年份',
  `jljljl` varchar(16) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade_mark
-- ----------------------------
INSERT INTO `grade_mark` VALUES ('1', '2', '1', '100', '2018', null);
INSERT INTO `grade_mark` VALUES ('4', '2', '6', '11', '2017', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('1', '植物学', null, null);
INSERT INTO `major` VALUES ('2', '法学', null, null);
INSERT INTO `major` VALUES ('3', '销售', null, null);
INSERT INTO `major` VALUES ('4', '测试专业1', null, null);
INSERT INTO `major` VALUES ('5', '测试专业2', null, null);
INSERT INTO `major` VALUES ('6', '测试专业111', null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('42', '0', '系统管理', '', '', '1', '0', '&#xe716;', null, '2019-03-27 16:21:37');
INSERT INTO `permission` VALUES ('58', '0', '学校管理', '', '', null, '0', '&#xe62a;', null, '2019-03-21 22:59:38');
INSERT INTO `permission` VALUES ('59', '58', '学校管理', '/school/school', 'school:school', null, '1', '', null, '2019-03-21 22:59:37');
INSERT INTO `permission` VALUES ('60', '0', '分数线管理', '', '', null, '0', null, null, null);
INSERT INTO `permission` VALUES ('61', '60', '分数线管理', '/grademark/gradeMark', 'grademark:gradeMark:gradeMark', null, '1', null, null, '2019-03-27 16:44:39');
INSERT INTO `permission` VALUES ('62', '60', '增加', '', 'grademark:gradeMark:add', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('63', '60', '编辑', '', 'grademark:gradeMark:edit', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('64', '60', '删除', '', 'grademark:gradeMark:remove', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('67', '42', '用户管理', '/user/user', 'user:user', null, '1', null, null, '2019-03-27 16:44:49');
INSERT INTO `permission` VALUES ('68', '42', '角色管理', '/role/role', 'rolr:role', null, '1', null, null, null);
INSERT INTO `permission` VALUES ('69', '42', '权限管理', '/permission/permission', 'permission:permission', null, '1', null, null, null);
INSERT INTO `permission` VALUES ('70', '67', '增加', '', 'user:user:add', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('71', '67', '编辑', '', 'user:user:edit', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('72', '67', '删除', '', 'user:user:remove', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('73', '67', '批量删除', '', 'user:user:batchRemove', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('74', '68', '增加', '', 'rolr:role:add', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('75', '68', '编辑', '', 'rolr:role:edit', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('76', '68', '删除', '', 'role:role:remove', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('77', '68', '批量删除', '', 'role:role:batchRemove', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('78', '69', '增加', '', 'permission:permission:add', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('79', '69', '删除', '', 'permission:permission:remove', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('80', '69', '编辑', '', 'permission:permission:edit', null, '2', null, null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=326 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
INSERT INTO `role_per` VALUES ('303', '1', '64');
INSERT INTO `role_per` VALUES ('304', '1', '63');
INSERT INTO `role_per` VALUES ('305', '1', '62');
INSERT INTO `role_per` VALUES ('306', '1', '61');
INSERT INTO `role_per` VALUES ('307', '1', '59');
INSERT INTO `role_per` VALUES ('308', '1', '60');
INSERT INTO `role_per` VALUES ('309', '1', '58');
INSERT INTO `role_per` VALUES ('310', '1', '42');
INSERT INTO `role_per` VALUES ('311', '1', '80');
INSERT INTO `role_per` VALUES ('312', '1', '79');
INSERT INTO `role_per` VALUES ('313', '1', '78');
INSERT INTO `role_per` VALUES ('314', '1', '77');
INSERT INTO `role_per` VALUES ('315', '1', '76');
INSERT INTO `role_per` VALUES ('316', '1', '75');
INSERT INTO `role_per` VALUES ('317', '1', '74');
INSERT INTO `role_per` VALUES ('318', '1', '73');
INSERT INTO `role_per` VALUES ('319', '1', '72');
INSERT INTO `role_per` VALUES ('320', '1', '71');
INSERT INTO `role_per` VALUES ('321', '1', '70');
INSERT INTO `role_per` VALUES ('322', '1', '69');
INSERT INTO `role_per` VALUES ('323', '1', '68');
INSERT INTO `role_per` VALUES ('324', '1', '67');
INSERT INTO `role_per` VALUES ('325', '1', '-1');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES ('2', '复旦大学', '试试', '嘎嘎', '', '', '', '');
INSERT INTO `school` VALUES ('3', '安抚', '', '', '', '', '', '');

-- ----------------------------
-- Table structure for sc_course
-- ----------------------------
DROP TABLE IF EXISTS `sc_course`;
CREATE TABLE `sc_course` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sc_id` int(16) DEFAULT NULL COMMENT '学校id',
  `m_id` int(16) DEFAULT NULL COMMENT '专业id',
  `ghghgh` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `hghghg` varchar(255) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sc_course
-- ----------------------------

-- ----------------------------
-- Table structure for sc_e
-- ----------------------------
DROP TABLE IF EXISTS `sc_e`;
CREATE TABLE `sc_e` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '学校id',
  `sc_id` int(16) DEFAULT NULL,
  `e_id` int(16) DEFAULT NULL COMMENT '招生简章id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sc_e
-- ----------------------------
INSERT INTO `sc_e` VALUES ('16', '2', '17');
INSERT INTO `sc_e` VALUES ('17', '3', '18');

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
-- Table structure for sc_t
-- ----------------------------
DROP TABLE IF EXISTS `sc_t`;
CREATE TABLE `sc_t` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sc_id` int(16) DEFAULT NULL COMMENT '学校id',
  `t_id` int(16) DEFAULT NULL COMMENT '试题id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sc_t
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
-- Table structure for test_question
-- ----------------------------
DROP TABLE IF EXISTS `test_question`;
CREATE TABLE `test_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tname` varchar(255) DEFAULT NULL COMMENT '试题名字',
  `url` varchar(255) DEFAULT NULL COMMENT '本地地址',
  `size` varchar(64) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updatetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `sc_id` int(16) DEFAULT NULL COMMENT '学校id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_question
-- ----------------------------
INSERT INTO `test_question` VALUES ('1', '测试试题一', 'www.baidu.com', '22', null, null, null);
INSERT INTO `test_question` VALUES ('13', 'bootdo.zip', 'f:\\file\\testquestion\\3361f51a-8899-4aa1-a312-b48d07c30365.zip', '10.7M', '2019-03-25 18:22:10', null, '3');
INSERT INTO `test_question` VALUES ('14', 'bootdo (2).zip', 'f:\\file\\testquestion\\3e140156-c534-487a-9662-7cb5ac540d94.zip', '10.7M', '2019-03-25 18:22:10', null, '3');

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
