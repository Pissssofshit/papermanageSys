/*
Navicat MySQL Data Transfer

Source Server         : mytest
Source Server Version : 50722
Source Host           : 192.168.139.130:3306
Source Database       : paper_manage

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-06-08 17:10:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_log_check_paper
-- ----------------------------
DROP TABLE IF EXISTS `tb_log_check_paper`;
CREATE TABLE `tb_log_check_paper` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `paperId` bigint(20) NOT NULL,
  `checkUserId` bigint(20) NOT NULL,
  `firstState` varchar(20) DEFAULT NULL,
  `updatedState` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tb_log_check_paper
-- ----------------------------

-- ----------------------------
-- Table structure for tb_paper
-- ----------------------------
DROP TABLE IF EXISTS `tb_paper`;
CREATE TABLE `tb_paper` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `createdtime` datetime DEFAULT NULL,
  `updatedtime` datetime DEFAULT NULL,
  `content` text,
  `userId` bigint(20) DEFAULT NULL,
  `read_num` int(11) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `typeid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_paper
-- ----------------------------
INSERT INTO `tb_paper` VALUES ('1', 'a', '2018-05-01 11:27:40', '2018-05-14 11:27:43', 'sa', '1', '38', 'true', '1');
INSERT INTO `tb_paper` VALUES ('2', 'b', '2018-05-08 14:41:56', '2018-06-27 14:42:00', 'sasadfwe', '233', '217', 'false', '2');
INSERT INTO `tb_paper` VALUES ('5', '??', '2018-06-04 14:57:55', null, '<h1>??</h1><p class=\"ql-align-justify\">????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????</p><p class=\"ql-align-justify\">????????????????1. MTBF (Mean Time Between Failure) ????????????2. MTTR (Mean Time To Recovery) ?????????????????????????????????????????“??9”?</p><h1><br></h1><h1><br></h1><h1><br></h1>', '1', '4', 'false', '1');
INSERT INTO `tb_paper` VALUES ('6', '??2', '2018-06-04 15:09:49', null, '<h1>??</h1><p class=\"ql-align-justify\">????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????</p><p class=\"ql-align-justify\">????????????????1. MTBF (Mean Time Between Failure) ????????????2. MTTR (Mean Time To Recovery) ?????????????????????????????????????????“??9”?</p><h1><br></h1>', '1', '3', 'false', '2');
INSERT INTO `tb_paper` VALUES ('7', '??2', '2018-06-04 15:12:17', null, '<h1>??</h1><p class=\"ql-align-justify\">????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????</p><p class=\"ql-align-justify\">????????????????1. MTBF (Mean Time Between Failure) ????????????2. MTTR (Mean Time To Recovery) ?????????????????????????????????????????“??9”?</p><h1><br></h1>', '1', '2', 'false', '1');
INSERT INTO `tb_paper` VALUES ('8', '引言', '2018-06-04 15:13:28', null, '<h1>Some initial content</h1>', '1', '1', 'false', '2');
INSERT INTO `tb_paper` VALUES ('9', 'mybatis连接mysql数据库插入中文乱码', '2018-06-04 15:17:10', null, '<h1>                                      mybatis连接mysql数据库插入中文乱码</h1><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">对于mysql数据库的乱码问题，有两中情况：</p><p class=\"ql-align-justify\"><span style=\"color: rgb(0, 102, 0);\">1. mysql数据库编码问题（建库时设定）。</span></p><p class=\"ql-align-justify\"><span style=\"color: rgb(0, 102, 0);\">2. 连接mysql数据库的url编码设置问题。</span></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">对于第一个问题，目前个人发现只能通过重新建库解决，建库的时候，选择UTF-8字符集。我试过修改现有数据库字符集为UFT</p><p class=\"ql-align-justify\">-8，但是根本不起作用，插入的中文仍然乱码（中文显示成：???）。重建库时选择字符集为UTF-8之后，中文正常显示了。</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">对于第二个问题，是这样的情况：我建库时设置了数据库默认字符集为UTF-8，通过mysql workbench直接插入中文显示完全正常。但是使用mybaits插入数据时，中文显示成了\"???\"这样的乱码。但从数据库获取的中文不会乱码。跟踪数据库操作，SQL语句中的中文还是显示正常的，但是插入到mysql数据库后就乱码了，于是判断可能是数据库连接的问题。后来在网上找了下资料，发现确实可以为mysql数据库的连接字符串设置编码方式，如下：</p><p class=\"ql-align-justify\"><span style=\"color: rgb(0, 0, 153);\">jdbc:mysql://127.0.0.1:3306/test?</span><span style=\"color: rgb(204, 0, 0);\">useUnicode=true&amp;characterEncoding=utf8</span></p><p>添加了<span style=\"color: rgb(102, 0, 204);\">useUnicode=true&amp;characterEncoding=utf8</span>参数之后，插入中文就正常了。</p><p><br></p><p>添加的作用是：指定字符的编码、解码格式。</p><p><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong>例如：假设mysql数据库用的是GBK编码（也可能是其它，例如Ubuntu下就是latin1），而项目数据库用的是utf-8编码。这时候如果添加了useUnicode=true&amp;characterEncoding=UTF-8 ，那么作用有如下两个方面：</p><p>1. 存数据时：</p><p>&nbsp;&nbsp;&nbsp;数据库在存放项目数据的时候会先用UTF-8格式将数据解码成字节码，然后再将解码后的字节码重新使用GBK编码存放到数据库中。</p><p>2.取数据时：</p><h1>&nbsp;&nbsp;&nbsp;在从数据库中取数据的时候，数据库会先将数据库中的数据按GBK格式解码成字节码，然后再将解码后的字节码重新按UTF-8格式编码数据，最后再将数据返回给客户端。</h1>', '1', '1', 'false', '1');
INSERT INTO `tb_paper` VALUES ('10', '程序员的工作总结（2017-12-04）', '2018-06-05 11:32:22', null, '<h1 class=\"ql-align-center\">程序员的工作总结（2017-12-04）</h1><p class=\"ql-align-justify\">在新的公司工作半年了时间飞逝，作为一名工程师，也要时刻对自己反省，这样才能够有所提升，在工作中我总结了一下几点，这个可能也是大家常见的一些问题，好记性不如烂笔头，今天就好好的来归纳总结一番。</p><p class=\"ql-align-justify\"><img src=\"https://img-blog.csdn.net/20171204141651893?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbHZiYW9saW4xMjM=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"这里写图片描述\"></p><p class=\"ql-align-justify\">1、在研发功能之前一定要弄清楚功能的需求，这个是必须要详细了解的一个前提，然后分析需求在业务上的可能性，需求是根基，业务分析前提。前面做到位了，在开发中定位会更加的准确，同时也会减少bug，减少了后期的工作量。</p><p class=\"ql-align-justify\">2、在研发的过程中日志的重要性，尤其的是在比较关键的程序中，这样为日后调试和排错会有很大的帮助。因为我有一次在程序中基本没有加什么日志，当时在测试的时候没有发现什么问题，因为在测试的情况中，很多种数据是非常难模拟出来的，只能测试常见的几种可能性，在这几种情况下没有发现问题，在线上出现了问题，由于当时在功能中没有加什么日志，导致非常难的去寻找问题的所在点，这个是我自己很疼苦的一次经历，所以在研发中一定不要忘记加上日志。</p><p class=\"ql-align-justify\">3、代码的规范也是同等的重要，这个能够很好的提高代码的阅读性和后期的维护，这个点不能忽视掉，规范其实有很多方面，我就说说我印象深刻的几个点，代码中可变参数的处理、常量、静态变量、注解等，这些在自己心里要养成一种潜意识的处理方式，如：接口中认证的秘钥key，这个需要写在管理后台，人员需要可配置的去修改。</p><p class=\"ql-align-justify\"><strong>以上三点是我在工作中深刻体会，总之好的工作方式和规范的习惯会大大的提高工作效率。有时候细节决定成败，认真细心地处理好每段代码才是一个合格的工程师，我觉得好的程序员都是一个可靠细心的人。</strong></p><p><br></p><p><br></p>', '1', '1', 'false', '2');
INSERT INTO `tb_paper` VALUES ('11', 'fewf', '2018-06-05 11:56:37', null, '<p class=\"ql-align-center\">废物</p>', '1', '1', 'false', '1');
INSERT INTO `tb_paper` VALUES ('12', '21', '2018-06-06 11:26:52', null, '<p>2343</p>', '1', '1', 'false', null);

-- ----------------------------
-- Table structure for tb_paper_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_paper_type`;
CREATE TABLE `tb_paper_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) CHARACTER SET utf8 NOT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tb_paper_type
-- ----------------------------
INSERT INTO `tb_paper_type` VALUES ('1', '数据库', '1');
INSERT INTO `tb_paper_type` VALUES ('2', 'Java', '1');
INSERT INTO `tb_paper_type` VALUES ('3', '网络安全', '1');
INSERT INTO `tb_paper_type` VALUES ('4', '爬虫', '1');
INSERT INTO `tb_paper_type` VALUES ('5', 'saa', null);
INSERT INTO `tb_paper_type` VALUES ('6', 'saa', null);
INSERT INTO `tb_paper_type` VALUES ('7', 'rwerwe', null);
INSERT INTO `tb_paper_type` VALUES ('8', 'fewfwe', null);
INSERT INTO `tb_paper_type` VALUES ('9', 'fewfwefewfwefwefwe', null);
INSERT INTO `tb_paper_type` VALUES ('10', 'rgeger', null);
INSERT INTO `tb_paper_type` VALUES ('11', '1234', null);
INSERT INTO `tb_paper_type` VALUES ('12', '12', null);
INSERT INTO `tb_paper_type` VALUES ('13', '12345', null);
INSERT INTO `tb_paper_type` VALUES ('14', '这个i有', null);
INSERT INTO `tb_paper_type` VALUES ('15', 'eqweq', '2');
INSERT INTO `tb_paper_type` VALUES ('16', '人生鸡汤', '0');
INSERT INTO `tb_paper_type` VALUES ('17', '人生鸡汤', '0');
INSERT INTO `tb_paper_type` VALUES ('18', '人生鸡汤', '1');
INSERT INTO `tb_paper_type` VALUES ('19', '恶趣味请问', '1');
INSERT INTO `tb_paper_type` VALUES ('21', 'fewfwe', '1');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `iphone` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'fwe', '1', '18072834696', '123456');
INSERT INTO `tb_user` VALUES ('2', 'zhou', '1', '13587396989', '123456');
