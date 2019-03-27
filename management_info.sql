/*
Navicat MySQL Data Transfer

Source Server         : renthouse
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : management_info

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-03-27 22:07:13
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
INSERT INTO `enrollment_guide` VALUES ('17', 'f:\\file\\eguide\\e9af04b8-42c5-4dc1-b36d-0e1e801240d82.txt', '2019-03-25 09:49:31', '2019-03-27 21:51:02', null);
INSERT INTO `enrollment_guide` VALUES ('18', 'f:\\file\\eguide\\7773cf2a-f550-4e1d-a1b2-4324372042fe3.txt', '2019-03-25 09:50:47', '2019-03-27 21:28:30', null);

-- ----------------------------
-- Table structure for grade_mark
-- ----------------------------
DROP TABLE IF EXISTS `grade_mark`;
CREATE TABLE `grade_mark` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `sc_id` int(16) DEFAULT NULL COMMENT '学校id',
  `m_id` int(16) DEFAULT NULL COMMENT '专业id',
  `grade` int(16) DEFAULT NULL COMMENT '分数线',
  `year` varchar(16) DEFAULT NULL COMMENT '备用字段',
  `jljljl` varchar(16) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade_mark
-- ----------------------------
INSERT INTO `grade_mark` VALUES ('1', '3', '1', '88', '2018', null);
INSERT INTO `grade_mark` VALUES ('2', '3', '2', '99', '2012', null);
INSERT INTO `grade_mark` VALUES ('3', '3', '3', '45', '2017', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('1', '植物学', null, null);
INSERT INTO `major` VALUES ('2', '自己看空间', null, null);
INSERT INTO `major` VALUES ('3', '测试专业1', null, null);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` int(16) DEFAULT '0' COMMENT '父id',
  `name` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '权限描述',
  `url` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `permission` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sort` int(16) DEFAULT NULL,
  `type` int(8) DEFAULT NULL COMMENT '类型',
  `img` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '图标',
  `createtime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updatetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('5', '0', '系统管理', '', '', '1', '0', '&#xe716;', null, '2019-03-21 16:50:59');
INSERT INTO `permission` VALUES ('6', '5', '用户管理', '/user/user', 'user:user:user', '1', '1', null, null, '2019-03-27 20:55:43');
INSERT INTO `permission` VALUES ('7', '5', '角色管理', '/role/role', 'role:role:role', '1', '1', null, null, '2019-03-27 21:04:35');
INSERT INTO `permission` VALUES ('8', '5', '权限管理', '/permission/permission', 'permission:permission:permission', null, '1', null, null, '2019-03-27 21:04:40');
INSERT INTO `permission` VALUES ('58', '0', '学校管理', '', '', null, '0', '&#xe62a;', null, '2019-03-21 22:59:38');
INSERT INTO `permission` VALUES ('59', '58', '学校管理', '/school/school', 'school:school:school', null, '1', '', null, '2019-03-27 20:43:59');
INSERT INTO `permission` VALUES ('60', '8', '增加', null, 'permission:permission:add', null, '2', null, null, '2019-03-27 20:48:20');
INSERT INTO `permission` VALUES ('61', '8', '编辑', '', 'permission:permission:edit', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('62', '8', '删除', '', 'permission:permission:remove', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('63', '6', '增加', '', 'user:user:add', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('64', '6', '编辑', '', 'user:user:edit', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('65', '6', '删除', '', 'user:user:remove', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('66', '7', '增加', '', 'role:role:add', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('67', '7', '编辑', '', 'role:role:edit', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('68', '7', '删除', '', 'role:role:remove', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('69', '0', '试题库', '', '', null, '2', null, null, '2019-03-27 21:47:17');
INSERT INTO `permission` VALUES ('70', '69', '试题库管理', '/testquestion/testQuestion', 'testquestion:testQuestion:testQuestion', null, '2', null, null, '2019-03-27 21:47:21');
INSERT INTO `permission` VALUES ('71', '70', '增加', '', 'testquestion:testQuestion:add', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('72', '70', '编辑', '', 'testquestion:testQuestion:edit', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('73', '70', '删除', '', 'testquestion:testQuestion:remove', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('75', '70', '批量删除', '', 'testquestion:testQuestion:batchRemove', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('76', '0', '视频库', '', '', null, '2', null, null, '2019-03-27 21:46:55');
INSERT INTO `permission` VALUES ('77', '76', '视频库管理', '/videodatabase/videoDatabase', 'videodatabase:videoDatabase:videoDatabase', null, '2', null, null, '2019-03-27 21:47:00');
INSERT INTO `permission` VALUES ('78', '77', '增加', '', 'videodatabase:videoDatabase:add', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('79', '77', '编辑', '', 'videodatabase:videoDatabase:edit', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('80', '77', '删除', '', 'videodatabase:videoDatabase:remove', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('81', '0', '分数线管理', '', '', null, '2', null, null, '2019-03-27 21:47:06');
INSERT INTO `permission` VALUES ('82', '81', '分数线管理', '/grademark/gradeMark', 'grademark:gradeMark:gradeMark', null, '2', null, null, '2019-03-27 21:47:11');
INSERT INTO `permission` VALUES ('83', '82', '增加', '', 'grademark:gradeMark:add', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('84', '82', '编辑', '', 'grademark:gradeMark:edit', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('85', '82', '删除', '', 'grademark:gradeMark:remove', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('86', '59', '增加', '', 'school:school:add', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('87', '59', '编辑', '', 'school:school:edit', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('88', '59', '删除', '', 'school:school:remove', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('89', '59', '批量删除', '', 'school:school:batchRemove', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('90', '82', '批量删除', '', 'grademark:gradeMark:batchRemove', null, '2', null, null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('2', '管理员', '顶级权限', null, '2019-03-27 21:43:18');

-- ----------------------------
-- Table structure for role_per
-- ----------------------------
DROP TABLE IF EXISTS `role_per`;
CREATE TABLE `role_per` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `role_id` int(16) DEFAULT NULL,
  `per_id` int(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=692 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of role_per
-- ----------------------------
INSERT INTO `role_per` VALUES ('268', '18', '8');
INSERT INTO `role_per` VALUES ('269', '18', '7');
INSERT INTO `role_per` VALUES ('270', '18', '5');
INSERT INTO `role_per` VALUES ('463', '1', '80');
INSERT INTO `role_per` VALUES ('464', '1', '79');
INSERT INTO `role_per` VALUES ('465', '1', '78');
INSERT INTO `role_per` VALUES ('466', '1', '75');
INSERT INTO `role_per` VALUES ('467', '1', '73');
INSERT INTO `role_per` VALUES ('468', '1', '72');
INSERT INTO `role_per` VALUES ('469', '1', '71');
INSERT INTO `role_per` VALUES ('470', '1', '59');
INSERT INTO `role_per` VALUES ('471', '1', '62');
INSERT INTO `role_per` VALUES ('472', '1', '61');
INSERT INTO `role_per` VALUES ('473', '1', '60');
INSERT INTO `role_per` VALUES ('474', '1', '68');
INSERT INTO `role_per` VALUES ('475', '1', '67');
INSERT INTO `role_per` VALUES ('476', '1', '66');
INSERT INTO `role_per` VALUES ('477', '1', '65');
INSERT INTO `role_per` VALUES ('478', '1', '64');
INSERT INTO `role_per` VALUES ('479', '1', '63');
INSERT INTO `role_per` VALUES ('480', '1', '77');
INSERT INTO `role_per` VALUES ('481', '1', '76');
INSERT INTO `role_per` VALUES ('482', '1', '70');
INSERT INTO `role_per` VALUES ('483', '1', '69');
INSERT INTO `role_per` VALUES ('484', '1', '58');
INSERT INTO `role_per` VALUES ('485', '1', '8');
INSERT INTO `role_per` VALUES ('486', '1', '7');
INSERT INTO `role_per` VALUES ('487', '1', '6');
INSERT INTO `role_per` VALUES ('488', '1', '5');
INSERT INTO `role_per` VALUES ('489', '1', '81');
INSERT INTO `role_per` VALUES ('490', '1', '85');
INSERT INTO `role_per` VALUES ('491', '1', '84');
INSERT INTO `role_per` VALUES ('492', '1', '83');
INSERT INTO `role_per` VALUES ('493', '1', '82');
INSERT INTO `role_per` VALUES ('494', '1', '-1');
INSERT INTO `role_per` VALUES ('655', '2', '85');
INSERT INTO `role_per` VALUES ('656', '2', '84');
INSERT INTO `role_per` VALUES ('657', '2', '83');
INSERT INTO `role_per` VALUES ('658', '2', '80');
INSERT INTO `role_per` VALUES ('659', '2', '79');
INSERT INTO `role_per` VALUES ('660', '2', '78');
INSERT INTO `role_per` VALUES ('661', '2', '75');
INSERT INTO `role_per` VALUES ('662', '2', '73');
INSERT INTO `role_per` VALUES ('663', '2', '72');
INSERT INTO `role_per` VALUES ('664', '2', '71');
INSERT INTO `role_per` VALUES ('665', '2', '89');
INSERT INTO `role_per` VALUES ('666', '2', '88');
INSERT INTO `role_per` VALUES ('667', '2', '87');
INSERT INTO `role_per` VALUES ('668', '2', '86');
INSERT INTO `role_per` VALUES ('669', '2', '62');
INSERT INTO `role_per` VALUES ('670', '2', '61');
INSERT INTO `role_per` VALUES ('671', '2', '60');
INSERT INTO `role_per` VALUES ('672', '2', '68');
INSERT INTO `role_per` VALUES ('673', '2', '67');
INSERT INTO `role_per` VALUES ('674', '2', '66');
INSERT INTO `role_per` VALUES ('675', '2', '65');
INSERT INTO `role_per` VALUES ('676', '2', '64');
INSERT INTO `role_per` VALUES ('677', '2', '63');
INSERT INTO `role_per` VALUES ('678', '2', '77');
INSERT INTO `role_per` VALUES ('679', '2', '76');
INSERT INTO `role_per` VALUES ('680', '2', '70');
INSERT INTO `role_per` VALUES ('681', '2', '69');
INSERT INTO `role_per` VALUES ('682', '2', '59');
INSERT INTO `role_per` VALUES ('683', '2', '58');
INSERT INTO `role_per` VALUES ('684', '2', '8');
INSERT INTO `role_per` VALUES ('685', '2', '7');
INSERT INTO `role_per` VALUES ('686', '2', '6');
INSERT INTO `role_per` VALUES ('687', '2', '5');
INSERT INTO `role_per` VALUES ('688', '2', '90');
INSERT INTO `role_per` VALUES ('689', '2', '82');
INSERT INTO `role_per` VALUES ('690', '2', '81');
INSERT INTO `role_per` VALUES ('691', '2', '-1');

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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_question
-- ----------------------------
INSERT INTO `test_question` VALUES ('1', '测试试题一', 'www.baidu.com', '22', null, null, null);
INSERT INTO `test_question` VALUES ('18', 'test.rar', 'f:\\file\\testquestion\\980ac1ff-f828-418d-b706-aa4364ca7527.rar', '2.4M', '2019-03-26 14:22:48', null, '2');
INSERT INTO `test_question` VALUES ('19', 'test.rar', 'f:\\file\\testquestion\\a68f23da-798a-457d-b0b8-9f84a6a7a402.rar', '2.4M', '2019-03-26 14:23:03', null, '2');
INSERT INTO `test_question` VALUES ('20', '手机QQ视频_20190326153207.mp4', 'f:\\file\\testquestion\\2f815c30-ef5d-4bf2-b941-e3bdb170206b.mp4', '843.7M', '2019-03-26 15:32:36', null, null);
INSERT INTO `test_question` VALUES ('21', '手机QQ视频_20190326153207.mp4', 'f:\\file\\testquestion\\751a5b52-af4f-4f89-89fd-6c77d039e332.mp4', '843.7M', '2019-03-26 15:34:15', null, null);
INSERT INTO `test_question` VALUES ('24', '82e1f56c-0cc1-4083-a0f0-fdc76a80995f.rar', 'f:\\file\\testquestion\\b910c4d3-22f6-455e-bdd6-1309ccff682a.rar', '2.4M', '2019-03-27 21:51:45', null, '3');
INSERT INTO `test_question` VALUES ('25', '6cbd5787-819c-478c-bd06-50ce1cf83245.rar', 'f:\\file\\testquestion\\20ba96e9-a4ba-46f6-b505-1bde52d62634.rar', '2.4M', '2019-03-27 21:51:45', null, '3');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('36', '1', '2');

-- ----------------------------
-- Table structure for video_database
-- ----------------------------
DROP TABLE IF EXISTS `video_database`;
CREATE TABLE `video_database` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `vname` varchar(255) DEFAULT NULL COMMENT '视频名称',
  `url` varchar(255) DEFAULT NULL COMMENT '本地地址',
  `size` varchar(16) DEFAULT NULL COMMENT '大小',
  `sc_id` int(16) DEFAULT NULL COMMENT '学校id',
  `createtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `hjhjhj` varchar(255) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video_database
-- ----------------------------
INSERT INTO `video_database` VALUES ('1', '手机QQ视频_20190326153207.mp4', 'f:\\file\\videodatabase\\1a6c4383-5d79-4084-a0f9-4629d587fa58.mp4', '843.7M', null, '2019-03-26 15:37:00', null, null);
INSERT INTO `video_database` VALUES ('3', '手机QQ视频_20190326153207.mp4', 'f:\\file\\videodatabase\\9065d6e9-069b-41d6-aba6-23c7194ffad3.mp4', '843.7M', '3', '2019-03-26 15:46:41', null, null);
INSERT INTO `video_database` VALUES ('4', 'testshipin.mp4', 'f:\\file\\videodatabase\\6d147f93-4f61-41e2-bb22-750df429d372.mp4', '843.7M', '3', '2019-03-26 16:27:03', null, null);
INSERT INTO `video_database` VALUES ('5', '2f815c30-ef5d-4bf2-b941-e3bdb170206b.mp4', 'f:\\file\\videodatabase\\393dafac-c001-4e51-b418-0ccc39bf8433.mp4', '843.7M', '3', '2019-03-27 21:29:24', null, null);
INSERT INTO `video_database` VALUES ('6', '2f815c30-ef5d-4bf2-b941-e3bdb170206b.mp4', 'f:\\file\\videodatabase\\bcf10593-ed4e-41d2-a727-0766ba61b5fc.mp4', '843.7M', '3', '2019-03-27 21:52:55', null, null);
INSERT INTO `video_database` VALUES ('7', '751a5b52-af4f-4f89-89fd-6c77d039e332.mp4', 'f:\\file\\videodatabase\\891369b9-5836-4378-9450-2ea99a3b6ec6.mp4', '843.7M', '3', '2019-03-27 21:52:55', null, null);
