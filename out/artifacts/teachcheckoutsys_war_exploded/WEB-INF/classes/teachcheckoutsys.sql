/*
Navicat MySQL Data Transfer

Source Server         : LBPBM
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : teachcheckoutsys

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-11-28 00:00:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admintable`
-- ----------------------------
DROP TABLE IF EXISTS `admintable`;
CREATE TABLE `admintable` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `adminid` varchar(9) NOT NULL COMMENT '管理员编号',
  `adminname` varchar(20) NOT NULL COMMENT '管理员姓名',
  `admintel` varchar(20) NOT NULL COMMENT '管理员电话',
  `adminemail` varchar(50) NOT NULL COMMENT '管理员邮箱',
  `adminusername` varchar(20) NOT NULL COMMENT '管理员用户名',
  `adminpwd` varchar(20) NOT NULL COMMENT '管理员密码',
  `adminposition` varchar(20) NOT NULL COMMENT '管理员职称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `adminid` (`adminid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of admintable
-- ----------------------------

-- ----------------------------
-- Table structure for `classtable`
-- ----------------------------
DROP TABLE IF EXISTS `classtable`;
CREATE TABLE `classtable` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `classid` varchar(20) DEFAULT NULL COMMENT '班级编号',
  `classname` varchar(100) DEFAULT NULL COMMENT '班级名称',
  `classspedt` varchar(30) DEFAULT NULL COMMENT '班级所属专业',
  `classnum` int(5) DEFAULT NULL COMMENT '班级人数',
  `classstu` varchar(255) DEFAULT NULL COMMENT '班级学生',
  `classtablename` varchar(20) DEFAULT NULL COMMENT '班级对应表格名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of classtable
-- ----------------------------
INSERT INTO `classtable` VALUES ('1', '00001', '14计科1班', '信息与计算科学', '37', '[\"20145570\",\"20145571\"]', 'classtable00001');

-- ----------------------------
-- Table structure for `courses`
-- ----------------------------
DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `coursesid` varchar(9) NOT NULL,
  `coursesname` varchar(50) NOT NULL,
  `coursesmajor` varchar(50) DEFAULT NULL COMMENT '课程分类',
  `coursesgrade` double DEFAULT NULL COMMENT '课程所占学分',
  `coursesteacher` varchar(50) NOT NULL COMMENT '教授这门课的老师是谁',
  `coursesstunum` int(10) NOT NULL COMMENT '需要修这门课的人数',
  `coursesplace` varchar(20) DEFAULT NULL COMMENT '上课地点',
  `coursestime` varchar(30) DEFAULT NULL COMMENT '上课时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `coursesid` (`coursesid`) USING BTREE,
  KEY `coursesname` (`coursesname`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of courses
-- ----------------------------
INSERT INTO `courses` VALUES ('1', '0001', 'C++程序设计', '[\"信息与计算科学\",\"计算机科学与技术\"]', '3.5', '[\"李昌安\",\"纪长博\",\"中华民\"]', '50', '7-101', null);
INSERT INTO `courses` VALUES ('3', '0003', '数据结构', '[\"信息与计算科学\",\"计算机科学与技术\"]', '4', '[\"李昌安\",\"纪长博\",\"中华民\"]', '50', '8-115', null);
INSERT INTO `courses` VALUES ('4', '0002', '操作系统', '[\"信息与计算科学\",\"计算机科学与技术\"]', '4.5', '[\"李昌安\",\"纪长博\",\"中华民\"]', '50', '3-301', null);
INSERT INTO `courses` VALUES ('6', '0004', '数据概论', '[\"信息与计算科学\",\"计算机科学与技术\"]', '4', '[\"李昌安\",\"纪长博\",\"中华民\"]', '50', '4-101', null);
INSERT INTO `courses` VALUES ('7', '0005', '高等数字', '[\"计算机科学与技术\",\"信息安全\"]', '4', '[\"李昌安\",\"纪长博\",\"中华民\"]', '50', '3-101', null);
INSERT INTO `courses` VALUES ('8', '0006', 'javaWeb程序设计', '[\"信息与计算科学\",\"计算机科学与技术\"]', '4', '[\"李昌安\",\"盖玉蝉\",\"纪长博\"]', '50', '5-101', null);
INSERT INTO `courses` VALUES ('9', '0007', '数学分析', '[\"信息与计算科学\",\"应用数学\"]', '4', '[\"李昌安\",\"盖玉蝉\",\"纪长博\"]', '50', '3-110', null);
INSERT INTO `courses` VALUES ('10', '0008', '数学分析I', '[\"信息与计算科学\",\"应用数学\"]', '6', '[\"李昌安\",\"盖玉蝉\",\"纪长博\"]', '50', '3-201', null);
INSERT INTO `courses` VALUES ('11', '0009', '数学分析II', '[\"信息与计算科学\",\"应用数学\"]', '6', '[\"李昌安\",\"盖玉蝉\",\"纪长博\"]', '50', '3-201', null);
INSERT INTO `courses` VALUES ('14', '00010', '高等代数II', '[\"信息与计算科学\",\"应用数学\"]', '6', '[\"李昌安\",\"盖玉蝉\",\"纪长博\"]', '50', '28-b201', null);
INSERT INTO `courses` VALUES ('15', '00011', '数字图像处理', '[\"信息与计算科学\", \"信息安全\"]', '6', '[\"李昌安\", \"盖玉蝉\"]', '50', '28-a101', null);
INSERT INTO `courses` VALUES ('16', '00012', '毛泽东思想概论', '[\"信息与计算科学\", \"信息安全\", \"信息与计算科学\"]', '5', '[\"李昌安\", \"盖玉蝉\"]', '50', '28-a101', null);

-- ----------------------------
-- Table structure for `filetable`
-- ----------------------------
DROP TABLE IF EXISTS `filetable`;
CREATE TABLE `filetable` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fileid` varchar(9) NOT NULL COMMENT '文件id',
  `filename` varchar(20) NOT NULL COMMENT '文件名',
  `fileauthor` varchar(20) DEFAULT 'admin' COMMENT '文件作者',
  `fileautorname` varchar(50) DEFAULT 'admin' COMMENT '文件作者名',
  `filesubject` varchar(20) DEFAULT 'all' COMMENT '文件所属科目',
  `filetype` int(10) DEFAULT NULL COMMENT '文件类型',
  `fileurl` varchar(20) DEFAULT NULL COMMENT '文件网上链接',
  `filepath` varchar(20) DEFAULT NULL COMMENT '文件本地路径',
  `fileperson` varchar(20) DEFAULT NULL COMMENT '文件私有性',
  `fileuptype` int(20) DEFAULT NULL COMMENT '文件上传类型',
  PRIMARY KEY (`id`),
  UNIQUE KEY `fileid` (`fileid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of filetable
-- ----------------------------

-- ----------------------------
-- Table structure for `sjtable`
-- ----------------------------
DROP TABLE IF EXISTS `sjtable`;
CREATE TABLE `sjtable` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sjid` varchar(9) NOT NULL COMMENT '试卷号',
  `sjname` varchar(50) NOT NULL COMMENT '试卷名',
  `sjauthor` varchar(50) DEFAULT NULL COMMENT '试卷作者',
  `sjtag` varchar(10) NOT NULL COMMENT '试卷标签',
  `sjdescribe` varchar(100) DEFAULT NULL COMMENT '试卷描述',
  `sjtinum` int(4) NOT NULL COMMENT '试卷题目数量',
  `sjchecksum` varchar(5) DEFAULT NULL COMMENT '试卷的校验码',
  `sjcourseid` varchar(9) DEFAULT NULL COMMENT '试卷所属课程名称',
  `sjcoursechp` varchar(20) DEFAULT NULL COMMENT '试卷所属课程章节内容',
  `sjreplynum` int(5) DEFAULT NULL COMMENT '试卷的答题人数',
  `sjright` double(20,0) DEFAULT NULL COMMENT '试卷的正确率',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sjid` (`sjid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sjtable
-- ----------------------------

-- ----------------------------
-- Table structure for `students`
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `stuid` varchar(9) NOT NULL COMMENT '学号',
  `stuname` varchar(50) NOT NULL COMMENT '学生姓名',
  `stuspedt` varchar(70) DEFAULT NULL COMMENT '学生所属专业',
  `stulevel` varchar(10) NOT NULL COMMENT '学生年级',
  `stuage` int(5) DEFAULT NULL COMMENT '学生年龄',
  `stusex` varchar(2) NOT NULL COMMENT '学生性别',
  `stuclassid` varchar(20) DEFAULT NULL COMMENT '学生所属班级id',
  `stucourses` varchar(255) DEFAULT '["无"]' COMMENT '学生所选课程',
  PRIMARY KEY (`id`),
  UNIQUE KEY `stuid` (`stuid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=466 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES ('291', '20145567', '安雄', '信息与计算科学', '2014', '22', '男', '1班', '[\"无\"]');
INSERT INTO `students` VALUES ('293', '20145569', '黄永盛', '信息与计算科学', '2014', '20', '男', '1班', '[\"无\"]');
INSERT INTO `students` VALUES ('463', '20145580', '唐英杰', '信息与计算科学', '2014', '21', '男', '1班', '[\"无\"]');
INSERT INTO `students` VALUES ('464', '20145581', '王文跃', '信息与计算科学', '2014', '21', '男', '1班', '[\"无\"]');
INSERT INTO `students` VALUES ('465', '20145582', '王熙辉', '信息与计算科学', '2014', '21', '男', '1班', '[\"无\"]');

-- ----------------------------
-- Table structure for `stuqiandao`
-- ----------------------------
DROP TABLE IF EXISTS `stuqiandao`;
CREATE TABLE `stuqiandao` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `stuid` varchar(9) NOT NULL COMMENT '学号',
  `stuname` varchar(9) DEFAULT NULL COMMENT '学生姓名',
  `courseid` varchar(9) DEFAULT NULL COMMENT '课程号',
  `ts` bigint(20) DEFAULT NULL COMMENT '时间',
  `qichecksum` varchar(9) DEFAULT NULL COMMENT '签到确认编码',
  `qidate` varchar(20) DEFAULT NULL COMMENT '签到日期',
  `qitime` varchar(20) DEFAULT NULL COMMENT '签到时间',
  `qistatu` int(4) DEFAULT NULL COMMENT '签到状态',
  `classnum` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `stuid` (`stuid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of stuqiandao
-- ----------------------------
INSERT INTO `stuqiandao` VALUES ('1', '', 'aaaa', '', '1506043224279', '11', '2017-09-22', '9:20:24', null, '2');
INSERT INTO `stuqiandao` VALUES ('2', '', 'aaaa', '', '1506043385070', '11', '2017-09-22', '9:23:5', null, '2');

-- ----------------------------
-- Table structure for `teachers`
-- ----------------------------
DROP TABLE IF EXISTS `teachers`;
CREATE TABLE `teachers` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `teacherid` varchar(50) NOT NULL,
  `teachername` varchar(50) DEFAULT NULL,
  `teacheremail` varchar(70) DEFAULT NULL,
  `teachertel` varchar(20) DEFAULT NULL,
  `teacherusername` varchar(50) NOT NULL,
  `teacherpwd` varchar(50) NOT NULL,
  `teacherlevel` varchar(20) DEFAULT NULL,
  `teacherstatu` int(2) DEFAULT NULL,
  `teachercourse` varchar(1000) DEFAULT '["无"]' COMMENT '教师教授的课程列表',
  `teacherclass` varchar(1000) DEFAULT '["无"]' COMMENT '教师教授的班级列表',
  `teachfilenumber` int(10) DEFAULT '0',
  `teachtinumber` int(10) DEFAULT '0',
  `longitude` double(20,0) DEFAULT NULL COMMENT '经度',
  `latitude` double(20,0) DEFAULT NULL COMMENT '纬度',
  PRIMARY KEY (`id`),
  UNIQUE KEY `teacherid` (`teacherid`) USING BTREE,
  KEY `teachername` (`teachername`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of teachers
-- ----------------------------
INSERT INTO `teachers` VALUES ('26', '95001', '李昌安', '65531@qq.com', '6666', '嘿嘿', '111111', '讲师', '3', '[\"C++程序设计\",\"数据结构\",\"javaweb\"]', '[\"00001\",\"00002\",\"00003\"]', '0', '0', '6', '7');
INSERT INTO `teachers` VALUES ('28', '123456', '盖玉蝉', '123@qq.com', '125487', 'gaigai', '123456', '教授', '3', '[\"无\"]', '[\"无\"]', '0', '0', null, null);
INSERT INTO `teachers` VALUES ('31', '154878', '惠比寿', '1245@qq.com', '12548', 'huibishou', '123456', '副教授', '3', '[\"无\"]', '[\"无\"]', '0', '0', null, null);
INSERT INTO `teachers` VALUES ('33', '123456789', '李东奎', '1212@qq.com', '123456', 'anin66', '123456', '高级讲师', '2', '[\"无\", \"数学分析\", \"数学分析I\", \"数学分析II\"]', '[\"无\"]', '0', '0', null, null);
INSERT INTO `teachers` VALUES ('34', '125487', '张纪牛', '1246@qq.com', '1234567', 'asnid5154', '123456', '教授', '2', '[\"数学分析I\", \"数学分析II\", \"数学分析\"]', '[\"无\"]', '0', '0', null, null);

-- ----------------------------
-- Table structure for `titable`
-- ----------------------------
DROP TABLE IF EXISTS `titable`;
CREATE TABLE `titable` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tiid` varchar(9) NOT NULL COMMENT '题目编号',
  `tino` int(5) DEFAULT NULL COMMENT '题目号',
  `titype` int(3) NOT NULL COMMENT '题目类型',
  `tititle` varchar(50) NOT NULL COMMENT '题目',
  `ticontent` varchar(255) DEFAULT NULL COMMENT '题目内容',
  `tianswer` varchar(255) NOT NULL COMMENT '题目答案',
  `timostanswer` varchar(255) NOT NULL COMMENT '大多数人的答案',
  `tiright` double(20,0) NOT NULL COMMENT '本题的正确率',
  `sjid` varchar(9) DEFAULT NULL COMMENT '题目的书卷号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tiid` (`tiid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of titable
-- ----------------------------
