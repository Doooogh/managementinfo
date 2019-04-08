/*
Navicat MySQL Data Transfer

Source Server         : renthouse
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : management_info

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-04-08 18:33:54
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
-- Table structure for icon
-- ----------------------------
DROP TABLE IF EXISTS `icon`;
CREATE TABLE `icon` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(64) DEFAULT NULL COMMENT '名字',
  `code` varchar(64) DEFAULT NULL COMMENT 'unicode字符',
  `font_class` varchar(255) DEFAULT NULL COMMENT '类名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=578 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of icon
-- ----------------------------
INSERT INTO `icon` VALUES ('438', '半星', '&#xe6c9;', 'layui-icon-rate-half');
INSERT INTO `icon` VALUES ('439', '星星-空心', '&#xe67b;', 'layui-icon-rate');
INSERT INTO `icon` VALUES ('440', '星星-实心', '&#xe67a;', 'layui-icon-rate-solid');
INSERT INTO `icon` VALUES ('441', '手机', '&#xe678;', 'layui-icon-cellphone');
INSERT INTO `icon` VALUES ('442', '验证码', '&#xe679;', 'layui-icon-vercode');
INSERT INTO `icon` VALUES ('443', '微信', '&#xe677;', 'layui-icon-login-wechat');
INSERT INTO `icon` VALUES ('444', 'QQ', '&#xe676;', 'layui-icon-login-qq');
INSERT INTO `icon` VALUES ('445', '微博', '&#xe675;', 'layui-icon-login-weibo');
INSERT INTO `icon` VALUES ('446', '密码', '&#xe673;', 'layui-icon-password');
INSERT INTO `icon` VALUES ('447', '用户名', '&#xe66f;', 'layui-icon-username');
INSERT INTO `icon` VALUES ('448', '刷新-粗', '&#xe9aa;', 'layui-icon-refresh-3');
INSERT INTO `icon` VALUES ('449', '授权', '&#xe672;', 'layui-icon-auz');
INSERT INTO `icon` VALUES ('450', '左向右伸缩菜单', '&#xe66b;', 'layui-icon-spread-left');
INSERT INTO `icon` VALUES ('451', '右向左伸缩菜单', '&#xe668;', 'layui-icon-shrink-right');
INSERT INTO `icon` VALUES ('452', '雪花', '&#xe6b1;', 'layui-icon-snowflake');
INSERT INTO `icon` VALUES ('453', '提示说明', '&#xe702;', 'layui-icon-tips');
INSERT INTO `icon` VALUES ('454', '便签', '&#xe66e;', 'layui-icon-note');
INSERT INTO `icon` VALUES ('455', '主页', '&#xe68e;', 'layui-icon-home');
INSERT INTO `icon` VALUES ('456', '高级', '&#xe674;', 'layui-icon-senior');
INSERT INTO `icon` VALUES ('457', '刷新', '&#xe669;', 'layui-icon-refresh');
INSERT INTO `icon` VALUES ('458', '刷新', '&#xe666;', 'layui-icon-refresh-1');
INSERT INTO `icon` VALUES ('459', '旗帜', '&#xe66c;', 'layui-icon-flag');
INSERT INTO `icon` VALUES ('460', '主题', '&#xe66a;', 'layui-icon-theme');
INSERT INTO `icon` VALUES ('461', '消息-通知', '&#xe667;', 'layui-icon-notice');
INSERT INTO `icon` VALUES ('462', '网站', '&#xe7ae;', 'layui-icon-website');
INSERT INTO `icon` VALUES ('463', '控制台', '&#xe665;', 'layui-icon-console');
INSERT INTO `icon` VALUES ('464', '表情-惊讶', '&#xe664;', 'layui-icon-face-surprised');
INSERT INTO `icon` VALUES ('465', '设置-空心', '&#xe716;', 'layui-icon-set');
INSERT INTO `icon` VALUES ('466', '模板', '&#xe656;', 'layui-icon-template-1');
INSERT INTO `icon` VALUES ('467', '应用', '&#xe653;', 'layui-icon-app');
INSERT INTO `icon` VALUES ('468', '模板', '&#xe663;', 'layui-icon-template');
INSERT INTO `icon` VALUES ('469', '赞', '&#xe6c6;', 'layui-icon-praise');
INSERT INTO `icon` VALUES ('470', '踩', '&#xe6c5;', 'layui-icon-tread');
INSERT INTO `icon` VALUES ('471', '男', '&#xe662;', 'layui-icon-male');
INSERT INTO `icon` VALUES ('472', '女', '&#xe661;', 'layui-icon-female');
INSERT INTO `icon` VALUES ('473', '相机-空心', '&#xe660;', 'layui-icon-camera');
INSERT INTO `icon` VALUES ('474', '相机-实心', '&#xe65d;', 'layui-icon-camera-fill');
INSERT INTO `icon` VALUES ('475', '菜单-水平', '&#xe65f;', 'layui-icon-more');
INSERT INTO `icon` VALUES ('476', '菜单-垂直', '&#xe671;', 'layui-icon-more-vertical');
INSERT INTO `icon` VALUES ('477', '金额-人民币', '&#xe65e;', 'layui-icon-rmb');
INSERT INTO `icon` VALUES ('478', '金额-美元', '&#xe659;', 'layui-icon-dollar');
INSERT INTO `icon` VALUES ('479', '钻石-等级', '&#xe735;', 'layui-icon-diamond');
INSERT INTO `icon` VALUES ('480', '火', '&#xe756;', 'layui-icon-fire');
INSERT INTO `icon` VALUES ('481', '返回', '&#xe65c;', 'layui-icon-return');
INSERT INTO `icon` VALUES ('482', '位置-地图', '&#xe715;', 'layui-icon-location');
INSERT INTO `icon` VALUES ('483', '办公-阅读', '&#xe705;', 'layui-icon-read');
INSERT INTO `icon` VALUES ('484', '调查', '&#xe6b2;', 'layui-icon-survey');
INSERT INTO `icon` VALUES ('485', '表情-微笑', '&#xe6af;', 'layui-icon-face-smile');
INSERT INTO `icon` VALUES ('486', '表情-哭泣', '&#xe69c;', 'layui-icon-face-cry');
INSERT INTO `icon` VALUES ('487', '购物车', '&#xe698;', 'layui-icon-cart-simple');
INSERT INTO `icon` VALUES ('488', '购物车', '&#xe657;', 'layui-icon-cart');
INSERT INTO `icon` VALUES ('489', '下一页', '&#xe65b;', 'layui-icon-next');
INSERT INTO `icon` VALUES ('490', '上一页', '&#xe65a;', 'layui-icon-prev');
INSERT INTO `icon` VALUES ('491', '上传-空心-拖拽', '&#xe681;', 'layui-icon-upload-drag');
INSERT INTO `icon` VALUES ('492', '上传-实心', '&#xe67c;', 'layui-icon-upload');
INSERT INTO `icon` VALUES ('493', '下载-圆圈', '&#xe601;', 'layui-icon-download-circle');
INSERT INTO `icon` VALUES ('494', '组件', '&#xe857;', 'layui-icon-component');
INSERT INTO `icon` VALUES ('495', '文件-粗', '&#xe655;', 'layui-icon-file-b');
INSERT INTO `icon` VALUES ('496', '用户', '&#xe770;', 'layui-icon-user');
INSERT INTO `icon` VALUES ('497', '发现-实心', '&#xe670;', 'layui-icon-find-fill');
INSERT INTO `icon` VALUES ('498', 'loading', '&#xe63d;', 'layui-icon-loading');
INSERT INTO `icon` VALUES ('499', 'loading', '&#xe63e;', 'layui-icon-loading-1');
INSERT INTO `icon` VALUES ('500', '添加', '&#xe654;', 'layui-icon-add-1');
INSERT INTO `icon` VALUES ('501', '播放', '&#xe652;', 'layui-icon-play');
INSERT INTO `icon` VALUES ('502', '暂停', '&#xe651;', 'layui-icon-pause');
INSERT INTO `icon` VALUES ('503', '音频-耳机', '&#xe6fc;', 'layui-icon-headset');
INSERT INTO `icon` VALUES ('504', '视频', '&#xe6ed;', 'layui-icon-video');
INSERT INTO `icon` VALUES ('505', '语音-声音', '&#xe688;', 'layui-icon-voice');
INSERT INTO `icon` VALUES ('506', '消息-通知-喇叭', '&#xe645;', 'layui-icon-speaker');
INSERT INTO `icon` VALUES ('507', '删除线', '&#xe64f;', 'layui-icon-fonts-del');
INSERT INTO `icon` VALUES ('508', '代码', '&#xe64e;', 'layui-icon-fonts-code');
INSERT INTO `icon` VALUES ('509', 'HTML', '&#xe64b;', 'layui-icon-fonts-html');
INSERT INTO `icon` VALUES ('510', '字体加粗', '&#xe62b;', 'layui-icon-fonts-strong');
INSERT INTO `icon` VALUES ('511', '删除链接', '&#xe64d;', 'layui-icon-unlink');
INSERT INTO `icon` VALUES ('512', '图片', '&#xe64a;', 'layui-icon-picture');
INSERT INTO `icon` VALUES ('513', '链接', '&#xe64c;', 'layui-icon-link');
INSERT INTO `icon` VALUES ('514', '表情-笑-粗', '&#xe650;', 'layui-icon-face-smile-b');
INSERT INTO `icon` VALUES ('515', '左对齐', '&#xe649;', 'layui-icon-align-left');
INSERT INTO `icon` VALUES ('516', '右对齐', '&#xe648;', 'layui-icon-align-right');
INSERT INTO `icon` VALUES ('517', '居中对齐', '&#xe647;', 'layui-icon-align-center');
INSERT INTO `icon` VALUES ('518', '字体-下划线', '&#xe646;', 'layui-icon-fonts-u');
INSERT INTO `icon` VALUES ('519', '字体-斜体', '&#xe644;', 'layui-icon-fonts-i');
INSERT INTO `icon` VALUES ('520', 'Tabs 选项卡', '&#xe62a;', 'layui-icon-tabs');
INSERT INTO `icon` VALUES ('521', '单选框-选中', '&#xe643;', 'layui-icon-radio');
INSERT INTO `icon` VALUES ('522', '单选框-候选', '&#xe63f;', 'layui-icon-circle');
INSERT INTO `icon` VALUES ('523', '编辑', '&#xe642;', 'layui-icon-edit');
INSERT INTO `icon` VALUES ('524', '分享', '&#xe641;', 'layui-icon-share');
INSERT INTO `icon` VALUES ('525', '删除', '&#xe640;', 'layui-icon-delete');
INSERT INTO `icon` VALUES ('526', '表单', '&#xe63c;', 'layui-icon-form');
INSERT INTO `icon` VALUES ('527', '手机-细体', '&#xe63b;', 'layui-icon-cellphone-fine');
INSERT INTO `icon` VALUES ('528', '聊天 对话 沟通', '&#xe63a;', 'layui-icon-dialogue');
INSERT INTO `icon` VALUES ('529', '文字格式化', '&#xe639;', 'layui-icon-fonts-clear');
INSERT INTO `icon` VALUES ('530', '窗口', '&#xe638;', 'layui-icon-layer');
INSERT INTO `icon` VALUES ('531', '日期', '&#xe637;', 'layui-icon-date');
INSERT INTO `icon` VALUES ('532', '水 下雨', '&#xe636;', 'layui-icon-water');
INSERT INTO `icon` VALUES ('533', '代码-圆圈', '&#xe635;', 'layui-icon-code-circle');
INSERT INTO `icon` VALUES ('534', '轮播组图', '&#xe634;', 'layui-icon-carousel');
INSERT INTO `icon` VALUES ('535', '翻页', '&#xe633;', 'layui-icon-prev-circle');
INSERT INTO `icon` VALUES ('536', '布局', '&#xe632;', 'layui-icon-layouts');
INSERT INTO `icon` VALUES ('537', '工具', '&#xe631;', 'layui-icon-util');
INSERT INTO `icon` VALUES ('538', '选择模板', '&#xe630;', 'layui-icon-templeate-1');
INSERT INTO `icon` VALUES ('539', '上传-圆圈', '&#xe62f;', 'layui-icon-upload-circle');
INSERT INTO `icon` VALUES ('540', '树', '&#xe62e;', 'layui-icon-tree');
INSERT INTO `icon` VALUES ('541', '表格', '&#xe62d;', 'layui-icon-table');
INSERT INTO `icon` VALUES ('542', '图表', '&#xe62c;', 'layui-icon-chart');
INSERT INTO `icon` VALUES ('543', '图标 报表 屏幕', '&#xe629;', 'layui-icon-chart-screen');
INSERT INTO `icon` VALUES ('544', '引擎', '&#xe628;', 'layui-icon-engine');
INSERT INTO `icon` VALUES ('545', '下三角', '&#xe625;', 'layui-icon-triangle-d');
INSERT INTO `icon` VALUES ('546', '右三角', '&#xe623;', 'layui-icon-triangle-r');
INSERT INTO `icon` VALUES ('547', '文件', '&#xe621;', 'layui-icon-file');
INSERT INTO `icon` VALUES ('548', '设置-小型', '&#xe620;', 'layui-icon-set-sm');
INSERT INTO `icon` VALUES ('549', '添加-圆圈', '&#xe61f;', 'layui-icon-add-circle');
INSERT INTO `icon` VALUES ('550', '404', '&#xe61c;', 'layui-icon-404');
INSERT INTO `icon` VALUES ('551', '关于', '&#xe60b;', 'layui-icon-about');
INSERT INTO `icon` VALUES ('552', '箭头 向上', '&#xe619;', 'layui-icon-up');
INSERT INTO `icon` VALUES ('553', '箭头 向下', '&#xe61a;', 'layui-icon-down');
INSERT INTO `icon` VALUES ('554', '箭头 向左', '&#xe603;', 'layui-icon-left');
INSERT INTO `icon` VALUES ('555', '箭头 向右', '&#xe602;', 'layui-icon-right');
INSERT INTO `icon` VALUES ('556', '圆点', '&#xe617;', 'layui-icon-circle-dot');
INSERT INTO `icon` VALUES ('557', '搜索', '&#xe615;', 'layui-icon-search');
INSERT INTO `icon` VALUES ('558', '设置-实心', '&#xe614;', 'layui-icon-set-fill');
INSERT INTO `icon` VALUES ('559', '群组', '&#xe613;', 'layui-icon-group');
INSERT INTO `icon` VALUES ('560', '好友', '&#xe612;', 'layui-icon-friends');
INSERT INTO `icon` VALUES ('561', '回复 评论 实心', '&#xe611;', 'layui-icon-reply-fill');
INSERT INTO `icon` VALUES ('562', '菜单 隐身 实心', '&#xe60f;', 'layui-icon-menu-fill');
INSERT INTO `icon` VALUES ('563', '记录', '&#xe60e;', 'layui-icon-log');
INSERT INTO `icon` VALUES ('564', '图片-细体', '&#xe60d;', 'layui-icon-picture-fine');
INSERT INTO `icon` VALUES ('565', '表情-笑-细体', '&#xe60c;', 'layui-icon-face-smile-fine');
INSERT INTO `icon` VALUES ('566', '列表', '&#xe60a;', 'layui-icon-list');
INSERT INTO `icon` VALUES ('567', '发布 纸飞机', '&#xe609;', 'layui-icon-release');
INSERT INTO `icon` VALUES ('568', '对 OK', '&#xe605;', 'layui-icon-ok');
INSERT INTO `icon` VALUES ('569', '帮助', '&#xe607;', 'layui-icon-help');
INSERT INTO `icon` VALUES ('570', '客服', '&#xe606;', 'layui-icon-chat');
INSERT INTO `icon` VALUES ('571', 'top 置顶', '&#xe604;', 'layui-icon-top');
INSERT INTO `icon` VALUES ('572', '收藏-空心', '&#xe600;', 'layui-icon-star');
INSERT INTO `icon` VALUES ('573', '收藏-实心', '&#xe658;', 'layui-icon-star-fill');
INSERT INTO `icon` VALUES ('574', '关闭-实心', '&#x1007;', 'layui-icon-close-fill');
INSERT INTO `icon` VALUES ('575', '关闭-空心', '&#x1006;', 'layui-icon-close');
INSERT INTO `icon` VALUES ('576', '正确', '&#x1005;', 'layui-icon-ok-circle');
INSERT INTO `icon` VALUES ('577', '添加-圆圈-细体', '&#xe608;', 'layui-icon-add-circle-fine');

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
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('5', '0', '系统管理', '', '', '1', '0', 'layui-icon-picture-fine', null, '2019-03-29 12:14:36');
INSERT INTO `permission` VALUES ('6', '5', '用户管理', '/user/user', 'user:user:user', '1', '1', null, null, '2019-03-27 20:55:43');
INSERT INTO `permission` VALUES ('7', '5', '角色管理', '/role/role', 'role:role:role', '1', '1', null, null, '2019-03-27 21:04:35');
INSERT INTO `permission` VALUES ('8', '5', '权限管理', '/permission/permission', 'permission:permission:permission', null, '1', null, null, '2019-03-27 21:04:40');
INSERT INTO `permission` VALUES ('58', '0', '学校管理', '', '', null, '0', 'layui-icon-layer', null, '2019-04-08 18:32:42');
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
INSERT INTO `permission` VALUES ('69', '0', '试题库', '', '', null, '2', '', null, '2019-03-29 13:34:16');
INSERT INTO `permission` VALUES ('70', '69', '试题库管理', '/testquestion/testQuestion', 'testquestion:testQuestion:testQuestion', null, '2', null, null, '2019-03-27 21:47:21');
INSERT INTO `permission` VALUES ('71', '70', '增加', '', 'testquestion:testQuestion:add', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('72', '70', '编辑', '', 'testquestion:testQuestion:edit', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('73', '70', '删除', '', 'testquestion:testQuestion:remove', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('75', '70', '批量删除', '', 'testquestion:testQuestion:batchRemove', null, '2', null, null, null);
INSERT INTO `permission` VALUES ('76', '0', '视频库', '', '', null, '2', '', null, '2019-03-29 13:34:28');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('2', '管理员', '顶级权限', null, '2019-03-27 21:43:18');
INSERT INTO `role` VALUES ('3', '信息管理', '部分权限', null, null);

-- ----------------------------
-- Table structure for role_per
-- ----------------------------
DROP TABLE IF EXISTS `role_per`;
CREATE TABLE `role_per` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `role_id` int(16) DEFAULT NULL,
  `per_id` int(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=699 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
INSERT INTO `role_per` VALUES ('692', '3', '58');
INSERT INTO `role_per` VALUES ('693', '3', '89');
INSERT INTO `role_per` VALUES ('694', '3', '88');
INSERT INTO `role_per` VALUES ('695', '3', '87');
INSERT INTO `role_per` VALUES ('696', '3', '86');
INSERT INTO `role_per` VALUES ('697', '3', '59');
INSERT INTO `role_per` VALUES ('698', '3', '-1');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '系统管理员', 'admin', 'admin', '13283354149', '男', '1122', '1', '2019-03-15 10:24:33', '2019-03-21 09:34:11');
INSERT INTO `user` VALUES ('2', '学校管理者', 'test1', 'test1', '13283354149', '男', '11', '1', '2019-03-29 12:16:48', null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `user_id` int(16) DEFAULT NULL,
  `role_id` int(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('36', '1', '2');
INSERT INTO `user_role` VALUES ('37', '2', '3');

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
