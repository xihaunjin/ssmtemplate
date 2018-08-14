/*
 Navicat Premium Data Transfer

 Source Server         : gce
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : 35.236.138.158:3306
 Source Schema         : ssm

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 02/08/2018 15:16:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for staff_info
-- ----------------------------
DROP TABLE IF EXISTS `staff_info`;
CREATE TABLE `staff_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `staff_id` int(11) unsigned DEFAULT NULL COMMENT '员工ID',
  `staff_name` varchar(20) NOT NULL COMMENT '员工姓名',
  `photo_url` varchar(255) DEFAULT NULL COMMENT '员工照片',
  `sex` int(1) NOT NULL COMMENT '员工性别',
  `office` varchar(64) NOT NULL COMMENT '部门',
  `arrival_time` date NOT NULL,
  `company` varchar(64) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `email` varchar(64) NOT NULL,
  `qq` varchar(64) DEFAULT NULL,
  `wechat` varchar(64) DEFAULT NULL,
  `address` varchar(255) NOT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `unique_staffId` (`staff_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
