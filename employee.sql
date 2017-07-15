/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50067
Source Host           : localhost:3306
Source Database       : employee

Target Server Type    : MYSQL
Target Server Version : 50067
File Encoding         : 65001

Date: 2017-07-15 08:32:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ssh_customer`
-- ----------------------------
DROP TABLE IF EXISTS `ssh_customer`;
CREATE TABLE `ssh_customer` (
  `ID` int(11) NOT NULL auto_increment,
  `COMPANYNAME` varchar(255) default NULL,
  `CONTACT` varchar(255) default NULL,
  `PHONE` varchar(255) default NULL,
  `ADDRESS` varchar(255) default NULL,
  `BRIEFINTRODUCTION` mediumtext,
  `CREATETIME` datetime default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssh_customer
-- ----------------------------
INSERT INTO `ssh_customer` VALUES ('1', '深圳瑞宝公司', '张先森', '13814671234', '深圳市', '深圳瑞宝电脑技术服务有限公司，成立于2008年，我公司为各行各业提供专业的it技术服务，经过3年多的努力与发展，已具一定的规模及实力，现拥有一支技术精湛的it服务团队，以卓越的服务品质、专业安全的技术服务实力，为不同群体的用户提供更高更优质的it服务。', '2017-06-29 07:50:40');
INSERT INTO `ssh_customer` VALUES ('2', '上海新东方', '李先生', '13674574165', '上海市', '上海新东方，讲授英语', '2017-06-29 07:50:54');
INSERT INTO `ssh_customer` VALUES ('3', '浙江金华公司', '王先生', '13745956854', '浙江', '浙江金华公司为各行各业提供专业的it技术服务，经过3年多的努力与发展，已具一定的规模及实力，现拥有一支技术精湛的it服务团队，以卓越的服务品质、专业安全的技术服务实力，为不同群体的用户提供更高更优质的it服务', '2017-06-29 07:51:06');
INSERT INTO `ssh_customer` VALUES ('4', '哈尔滨动力', '郝先生', '13886864545', '哈尔滨', '哈尔滨动力有限公司，成立于2008年，我公司为各行各业提供专业的it技术服务，经过3年多的努力与发展，已具一定的规模及实力，现拥有一支技术精湛的it服务团队，以卓越的服务品质、专业安全的技术服务实力，为不同群体的用户提供更高更优质的it服务', '2017-06-29 07:51:17');
INSERT INTO `ssh_customer` VALUES ('5', '北京航天公司', '周先生', '13426264545', '北京', '北京航天公司，成立于2008年，我公司为各行各业提供专业的it技术服务，经过3年多的努力与发展，已具一定的规模及实力，现拥有一支技术精湛的it服务团队，以卓越的服务品质、专业安全的技术服务实力，为不同群体的用户提供更高更优质的it服务', '2017-06-30 14:58:46');
INSERT INTO `ssh_customer` VALUES ('6', '广州科技公司', '郑先生', '13945351245', '广州', '广州科技公司，更高更优质的it服务', '2017-07-02 17:04:16');
INSERT INTO `ssh_customer` VALUES ('7', '南京制鞋厂', '钱先生', '13746250125', '南京', '南京制鞋厂，成立于2008年，我公司为各行各业提供专业的it技术服务，经过3年多的努力与发展，已具一定的规模及实力，现拥有一支技术精湛的it服务团队，以卓越的服务品质、专业安全的技术服务实力，为不同群体的用户提供更高更优质的it服务', '2017-07-02 17:04:27');
INSERT INTO `ssh_customer` VALUES ('8', '广州豪迪公司', '孙先生', '13888888888', '广州', '广州豪迪公司，成立于2008年，我公司为各行各业提供专业的it技术服务，经过3年多的努力与发展，已具一定的规模及实力，现拥有一支技术精湛的it服务团队，以卓越的服务品质、专业安全的技术服务实力，为不同群体的用户提供更高更优质的it服务', '2017-07-02 18:51:16');
INSERT INTO `ssh_customer` VALUES ('9', '哈尔滨制药厂', '吴先生', '13845454545', '哈尔滨', '哈尔滨制药厂，成立于2008年，我公司为各行各业提供专业的it技术服务，经过3年多的努力与发展，已具一定的规模及实力，现拥有一支技术精湛的it服务团队，以卓越的服务品质、专业安全的技术服务实力，为不同群体的用户提供更高更优质的it服务', '2017-07-02 19:04:56');
INSERT INTO `ssh_customer` VALUES ('10', '哈西服装城', '魏先生', '13645454545', '哈尔滨', '哈西服装城，成立于2008年，我公司为各行各业提供专业的it技术服务，经过3年多的努力与发展，已具一定的规模及实力，现拥有一支技术精湛的it服务团队，以卓越的服务品质、专业安全的技术服务实力，为不同群体的用户提供更高更优质的it服务', '2017-07-02 19:07:10');

-- ----------------------------
-- Table structure for `ssh_dept`
-- ----------------------------
DROP TABLE IF EXISTS `ssh_dept`;
CREATE TABLE `ssh_dept` (
  `DEPTNO` int(11) NOT NULL auto_increment,
  `DNAME` varchar(255) default NULL,
  PRIMARY KEY  (`DEPTNO`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssh_dept
-- ----------------------------
INSERT INTO `ssh_dept` VALUES ('1', '研发部');
INSERT INTO `ssh_dept` VALUES ('2', '销售部');
INSERT INTO `ssh_dept` VALUES ('3', '人事部');
INSERT INTO `ssh_dept` VALUES ('4', '行政部');

-- ----------------------------
-- Table structure for `ssh_emp`
-- ----------------------------
DROP TABLE IF EXISTS `ssh_emp`;
CREATE TABLE `ssh_emp` (
  `EMPNO` int(11) NOT NULL auto_increment,
  `ENAME` varchar(255) default NULL,
  `JOB` varchar(255) default NULL,
  `HIREDATE` datetime default NULL,
  `CREATETIME` datetime default NULL,
  `DEPTNO` int(11) default NULL,
  PRIMARY KEY  (`EMPNO`),
  KEY `FK_nmektew2rk88hn8ms9lm95by6` (`DEPTNO`),
  CONSTRAINT `FK_nmektew2rk88hn8ms9lm95by6` FOREIGN KEY (`DEPTNO`) REFERENCES `ssh_dept` (`DEPTNO`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssh_emp
-- ----------------------------
INSERT INTO `ssh_emp` VALUES ('1', 'SMITH', '部长', '2017-06-26 00:00:00', '2017-06-26 17:46:28', '1');
INSERT INTO `ssh_emp` VALUES ('2', 'DDD', '部长', '2017-06-25 00:00:00', '2017-06-24 20:24:22', '2');
INSERT INTO `ssh_emp` VALUES ('3', 'CCC', '部长', '2018-01-31 00:00:00', '2017-06-24 20:23:33', '3');
INSERT INTO `ssh_emp` VALUES ('4', 'AAA', '职员', '2017-06-27 00:00:00', '2017-06-24 13:24:05', '3');
INSERT INTO `ssh_emp` VALUES ('5', 'JACK', '职员', '2017-06-11 00:00:00', '2017-06-24 13:22:51', '3');
INSERT INTO `ssh_emp` VALUES ('6', 'BBB', '职员', '2017-06-24 13:24:34', '2017-06-24 13:24:42', '3');
INSERT INTO `ssh_emp` VALUES ('7', '123', '职员', '1995-06-25 00:00:00', '2017-06-26 14:54:27', '1');
INSERT INTO `ssh_emp` VALUES ('8', '456', '职员', '1996-06-06 00:00:00', '2017-06-26 15:28:11', '1');
INSERT INTO `ssh_emp` VALUES ('9', '小王', '职员', '1995-06-25 00:00:00', '2017-06-26 15:34:18', '1');
INSERT INTO `ssh_emp` VALUES ('11', '1', '职员', '1995-12-12 00:00:00', '2017-06-26 15:50:25', '1');
INSERT INTO `ssh_emp` VALUES ('14', '23', '职员', '1995-09-09 00:00:00', '2017-06-26 16:25:06', '2');
INSERT INTO `ssh_emp` VALUES ('15', '789', '职员', '1995-06-25 00:00:00', '2017-06-26 20:44:11', '1');
INSERT INTO `ssh_emp` VALUES ('17', 'yyy', '职员', '2017-06-23 00:00:00', '2017-07-02 20:08:03', '1');
INSERT INTO `ssh_emp` VALUES ('19', 'qqq', '职员', '1996-09-09 00:00:00', '2017-07-06 11:08:21', '1');

-- ----------------------------
-- Table structure for `ssh_message`
-- ----------------------------
DROP TABLE IF EXISTS `ssh_message`;
CREATE TABLE `ssh_message` (
  `ID` int(11) NOT NULL auto_increment,
  `SENDER` varchar(255) default NULL,
  `RECEIVER` varchar(255) default NULL,
  `TITLE` varchar(255) default NULL,
  `CONTENT` mediumtext,
  `CREATETIME` datetime default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssh_message
-- ----------------------------
INSERT INTO `ssh_message` VALUES ('2', 'admin', 'test', 'jdbc:mysql:///emp', '中文 test /^${}$/', '2017-07-03 22:59:33');
INSERT INTO `ssh_message` VALUES ('4', 'admin', 'test', 'admin', 'adminadminadminadmin', '2017-07-03 23:04:17');
INSERT INTO `ssh_message` VALUES ('5', 'test', 'admin', '123', 'jfaisdjfiasjdfas', '2017-07-06 13:44:34');
INSERT INTO `ssh_message` VALUES ('6', 'admin', 'test', '123', '123123123213', '2017-07-06 14:39:01');

-- ----------------------------
-- Table structure for `ssh_salary`
-- ----------------------------
DROP TABLE IF EXISTS `ssh_salary`;
CREATE TABLE `ssh_salary` (
  `ID` int(11) NOT NULL auto_increment,
  `ENAME` varchar(255) default NULL,
  `YEAR` int(11) default NULL,
  `MONTH` int(11) default NULL,
  `BOUNS` int(11) default NULL,
  `FINE` int(11) default NULL,
  `SENDER` varchar(255) default NULL,
  `REALSALARY` int(11) default NULL,
  `BASICSALARY` int(11) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_8c08su7f3m27988h8hg07xddh` (`BASICSALARY`),
  CONSTRAINT `FK_8c08su7f3m27988h8hg07xddh` FOREIGN KEY (`BASICSALARY`) REFERENCES `ssh_salgrade` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssh_salary
-- ----------------------------
INSERT INTO `ssh_salary` VALUES ('1', 'CCC', '2016', '1', '100', '200', 'SMITH', '4900', '2');
INSERT INTO `ssh_salary` VALUES ('2', 'CCC', '2016', '2', '156', '123', 'SMITH', '5033', '2');
INSERT INTO `ssh_salary` VALUES ('3', 'CCC', '2016', '3', '123', '456', 'SMITH', '4667', '2');
INSERT INTO `ssh_salary` VALUES ('4', 'CCC', '2016', '4', '500', '400', 'SMITH', '5100', '2');
INSERT INTO `ssh_salary` VALUES ('5', 'CCC', '2016', '5', '123', '123', 'SMITH', '5000', '2');
INSERT INTO `ssh_salary` VALUES ('6', 'CCC', '2016', '6', '25', '123', 'SMITH', '4902', '2');
INSERT INTO `ssh_salary` VALUES ('7', 'CCC', '2016', '7', '12', '23', 'SMITH', '4989', '2');
INSERT INTO `ssh_salary` VALUES ('8', 'CCC', '2016', '8', '12', '123', 'SMITH', '4889', '2');
INSERT INTO `ssh_salary` VALUES ('9', 'CCC', '2016', '9', '45', '56', 'SMITH', '4989', '2');
INSERT INTO `ssh_salary` VALUES ('10', 'CCC', '2016', '10', '23', '15', 'SMITH', '5008', '2');
INSERT INTO `ssh_salary` VALUES ('11', 'AAA', '2016', '11', '456', '789', 'SMITH', '2667', '4');
INSERT INTO `ssh_salary` VALUES ('18', 'JACK', '2016', '1', '200', '100', 'SMITH', '3100', '4');

-- ----------------------------
-- Table structure for `ssh_salgrade`
-- ----------------------------
DROP TABLE IF EXISTS `ssh_salgrade`;
CREATE TABLE `ssh_salgrade` (
  `ID` int(11) NOT NULL auto_increment,
  `JOB` varchar(255) default NULL,
  `BASICSALARY` int(11) default NULL,
  `CREATETIME` datetime default NULL,
  `EDITTIME` datetime default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssh_salgrade
-- ----------------------------
INSERT INTO `ssh_salgrade` VALUES ('2', '部长', '5000', '2017-06-29 11:08:44', '2017-06-29 11:08:48');
INSERT INTO `ssh_salgrade` VALUES ('4', '职员', '3000', '2017-06-29 17:27:32', '2017-06-29 18:05:06');

-- ----------------------------
-- Table structure for `ssh_task`
-- ----------------------------
DROP TABLE IF EXISTS `ssh_task`;
CREATE TABLE `ssh_task` (
  `ID` int(11) NOT NULL auto_increment,
  `SENDER` varchar(255) default NULL,
  `TITLE` varchar(255) default NULL,
  `CONTENT` mediumtext,
  `PRIORITY` varchar(255) default NULL,
  `CREATETIME` datetime default NULL,
  `STARTTIME` datetime default NULL,
  `ENDTIME` datetime default NULL,
  `DEPTNO` int(11) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_7fmmquwnm76kiubxfsr7bjtxg` (`DEPTNO`),
  CONSTRAINT `FK_7fmmquwnm76kiubxfsr7bjtxg` FOREIGN KEY (`DEPTNO`) REFERENCES `ssh_dept` (`DEPTNO`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssh_task
-- ----------------------------
INSERT INTO `ssh_task` VALUES ('1', 'SMITH', 'test', '今天天气不错啊!今天天气不错啊!今天天气不错啊!今天天气不错啊!今天天气不错啊!', '急', '2017-07-05 00:00:00', '2017-07-05 00:00:00', '2017-07-05 00:00:00', '1');
INSERT INTO `ssh_task` VALUES ('2', 'SMITH', 'test', '今天天气不错啊!今天天气不错啊!今天天气不错啊!今天天气不错啊!今天天气不错啊!', '急', '2017-07-05 00:00:00', '2017-07-05 00:00:00', '2017-07-05 00:00:00', '1');
INSERT INTO `ssh_task` VALUES ('4', 'SMITH', 'test', '务必完成任务！务必完成任务！务必完成任务！务必完成任务！务必完成任务！', '很急', '2017-07-05 00:00:00', '2017-07-05 00:00:00', '2017-07-05 00:00:00', '2');
INSERT INTO `ssh_task` VALUES ('5', 'SMITH', 'test', '今天天气不错啊!今天天气不错啊!今天天气不错啊!今天天气不错啊!今天天气不错啊!', '急', '2017-07-05 00:00:00', '2017-07-05 00:00:00', '2017-07-05 00:00:00', '1');
INSERT INTO `ssh_task` VALUES ('6', 'SMITH', 'test', '今天天气不错啊!今天天气不错啊!今天天气不错啊!今天天气不错啊!今天天气不错啊!', '急', '2017-07-05 00:00:00', '2017-07-05 00:00:00', '2017-07-05 00:00:00', '1');
INSERT INTO `ssh_task` VALUES ('7', 'SMITH', 'test', '今天天气不错啊!今天天气不错啊!今天天气不错啊!今天天气不错啊!今天天气不错啊!', '急', '2017-07-05 00:00:00', '2017-07-05 00:00:00', '2017-07-05 00:00:00', '1');
INSERT INTO `ssh_task` VALUES ('9', 'SMITH', 'test', '今天天气不错啊!今天天气不错啊!今天天气不错啊!今天天气不错啊!今天天气不错啊!', '急', '2017-07-05 00:00:00', '2017-07-05 00:00:00', '2017-07-05 00:00:00', '1');
INSERT INTO `ssh_task` VALUES ('10', 'SMITH', 'test', '今天天气不错啊!今天天气不错啊!今天天气不错啊!今天天气不错啊!今天天气不错啊!', '急', '2017-07-05 00:00:00', '2017-07-05 00:00:00', '2017-07-05 00:00:00', '1');
INSERT INTO `ssh_task` VALUES ('11', 'SMITH', '456456', '5', '急', '2017-07-06 00:00:00', '2017-07-06 00:00:00', '2017-07-06 00:00:00', '1');

-- ----------------------------
-- Table structure for `ssh_user`
-- ----------------------------
DROP TABLE IF EXISTS `ssh_user`;
CREATE TABLE `ssh_user` (
  `ID` int(11) NOT NULL auto_increment,
  `USERNAME` varchar(255) default NULL,
  `PASSWORD` varchar(255) default NULL,
  `REALNAME` varchar(255) default NULL,
  `SEX` varchar(255) default NULL,
  `AGE` int(11) default NULL,
  `EMAIL` varchar(255) default NULL,
  `PHONE` varchar(255) default NULL,
  `TYPE` int(11) default NULL,
  `EMPNO` int(11) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_3mwkpjrhd6hs2cfdjr90cttpo` (`EMPNO`),
  CONSTRAINT `FK_3mwkpjrhd6hs2cfdjr90cttpo` FOREIGN KEY (`EMPNO`) REFERENCES `ssh_emp` (`EMPNO`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssh_user
-- ----------------------------
INSERT INTO `ssh_user` VALUES ('1', 'admin', 'admin', 'SMITH', '男', '25', '1003250470@qq.com', '13886888689', '1', '1');
INSERT INTO `ssh_user` VALUES ('2', 'buzhang', 'buzhang', 'DDD', '男', '23', '456@126.com', '13333333333', '1', '2');
INSERT INTO `ssh_user` VALUES ('3', 'buzhang2', 'buzhang2', 'CCC', '女', '23', '1003250470@qq.com', '13444444444', '1', '3');
INSERT INTO `ssh_user` VALUES ('4', 'test', 'test', 'AAA', '男', '21', '456@163.com', '18846086709', '0', '4');
INSERT INTO `ssh_user` VALUES ('5', '123', '123', 'JACK', '男', '27', '1003250470@qq.com', '13345456565', '0', '5');
INSERT INTO `ssh_user` VALUES ('6', '456', '789', 'BBB', '男', '24', '1003250470@qq.com', '13745454545', '0', '6');
INSERT INTO `ssh_user` VALUES ('8', '777', '123', '456', '男', '123', '1003250470@qq.com', '13815151515', '0', '7');
INSERT INTO `ssh_user` VALUES ('10', '1', '1', '小王', '女', '26', '1003250470@qq.com', '13715151515', '0', '9');
INSERT INTO `ssh_user` VALUES ('11', 'test2', 'test2', '1', '女', '12', 'test2@163.com', '12345679', '0', '11');
INSERT INTO `ssh_user` VALUES ('13', '111', '111', '23', '女', '16', '1003250470@qq.com', '13756565656', '0', '14');
INSERT INTO `ssh_user` VALUES ('14', '789', '789', '789', '男', '23', '1003250470@qq.com', '13545454545', '0', '15');
INSERT INTO `ssh_user` VALUES ('16', 'buzhan', 'buzhang', 'DDD', '男', '22', '456@126.com', '13333333333', '0', '17');
INSERT INTO `ssh_user` VALUES ('34', 'qqq', '23', 'qqq', '男', '23', '23@163.com', '18845454545', '0', '19');
