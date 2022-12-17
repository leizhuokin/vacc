/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50739
 Source Host           : localhost:3306
 Source Schema         : vacc

 Target Server Type    : MySQL
 Target Server Version : 50739
 File Encoding         : 65001

 Date: 17/12/2022 15:02:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号码',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码：加密存储',
  `nickname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称：保证唯一',
  `real_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `gender` tinyint(1) UNSIGNED NULL DEFAULT 0 COMMENT '性别：默认为0保密,1为男，2为女',
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号：保证唯一',
  `age` tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '年龄',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `order_time` datetime NULL DEFAULT NULL COMMENT '预约时间',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1008 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1001, '411081', '123456', '安定11', '10', 0, '11111', 18, '2021-11-19', '2021-11-19 00:00:00', '2021-11-19 00:00:00', '2021-11-19 00:00:00');
INSERT INTO `user` VALUES (1002, '202020', '111111', '撒旦', '王五', 0, '123456', 20, '2021-02-11', '2021-12-06 09:46:40', '2021-12-06 09:46:45', '2021-12-03 09:46:50');
INSERT INTO `user` VALUES (1003, '411230', '888888', '阿萨', '李四', 0, '565656', 19, '2021-06-17', '2021-12-06 09:47:48', '2021-12-25 09:47:52', '2021-12-05 09:47:55');
INSERT INTO `user` VALUES (1005, '233747', '12345', '收到', '二', 0, '85745', 19, '2001-11-19', '2021-12-06 00:00:00', '2021-12-06 00:00:00', '2021-12-06 00:00:00');
INSERT INTO `user` VALUES (1006, '858875', '8757', '758', '57', 1, '125545', 19, '2021-11-19', '2021-12-06 00:00:00', '2021-11-19 00:00:00', '2021-12-06 00:00:00');
INSERT INTO `user` VALUES (1007, '411080', '45566', '泪灼', '张三', 0, '85745', 19, '2021-11-19', '2021-11-19 00:00:00', '2021-12-06 00:00:00', '2021-11-19 00:00:00');

-- ----------------------------
-- Table structure for user_vaccine
-- ----------------------------
DROP TABLE IF EXISTS `user_vaccine`;
CREATE TABLE `user_vaccine`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '关联id',
  `inoculation_time` datetime NULL DEFAULT NULL COMMENT '接种时间',
  `uid` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '接种人员ID',
  `vid` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '疫苗ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_vaccine
-- ----------------------------
INSERT INTO `user_vaccine` VALUES (1, '2021-12-07 10:02:39', 1001, 2001);
INSERT INTO `user_vaccine` VALUES (2, '2021-12-06 10:03:19', 1002, 2002);
INSERT INTO `user_vaccine` VALUES (3, '2021-12-10 10:03:26', 1003, 2003);
INSERT INTO `user_vaccine` VALUES (4, '2021-12-10 00:00:00', 1004, 2004);
INSERT INTO `user_vaccine` VALUES (5, '2021-12-10 00:00:00', 1005, 2005);
INSERT INTO `user_vaccine` VALUES (6, '2021-12-10 00:00:00', 1006, 2006);
INSERT INTO `user_vaccine` VALUES (7, '2021-12-10 00:00:00', 1007, 2007);

-- ----------------------------
-- Table structure for vaccine
-- ----------------------------
DROP TABLE IF EXISTS `vaccine`;
CREATE TABLE `vaccine`  (
  `vid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `vno` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '疫苗编号',
  `vname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '疫苗名称',
  `ssex` enum('免费','收费') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '免费' COMMENT '疫苗类别',
  `pro_time` datetime NULL DEFAULT NULL COMMENT '生产日期',
  `exp` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '有效期',
  PRIMARY KEY (`vid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47459 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of vaccine
-- ----------------------------
INSERT INTO `vaccine` VALUES (11, '11', '1156', '免费', '2021-09-01 00:00:00', '2年');
INSERT INTO `vaccine` VALUES (2001, '89565624', '北京生物', '免费', '2021-09-01 00:00:00', '2年');
INSERT INTO `vaccine` VALUES (2003, '262185945', '北京生物', '免费', '2021-09-01 00:00:00', '3年');
INSERT INTO `vaccine` VALUES (2004, '15525', '454', '收费', '2021-09-01 00:00:00', '2年');
INSERT INTO `vaccine` VALUES (2005, '12356', '14478', '收费', '2021-09-01 00:00:00', '2年');
INSERT INTO `vaccine` VALUES (2006, '455', '457', '收费', '2021-09-01 00:00:00', '2年');
INSERT INTO `vaccine` VALUES (47458, '78567', '7', '收费', '2021-09-01 00:00:00', '2年');

SET FOREIGN_KEY_CHECKS = 1;
