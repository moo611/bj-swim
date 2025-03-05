/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : ry-vue

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 07/11/2024 12:28:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sw_record
-- ----------------------------
DROP TABLE IF EXISTS `sw_record`;
CREATE TABLE `sw_record`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `day` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `items` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '删除标识',
  `create_time` datetime NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sw_record
-- ----------------------------
INSERT INTO `sw_record` VALUES (1, '6', '[3]', '0', '2024-11-07 10:59:29', NULL, '2024-11-07 11:42:29', NULL);
INSERT INTO `sw_record` VALUES (2, '1', '[0,1,2,3]', '0', '2024-11-07 10:59:29', NULL, '2024-11-07 11:42:29', NULL);
INSERT INTO `sw_record` VALUES (3, '5', '[3]', '0', '2024-11-07 10:59:29', NULL, '2024-11-07 11:42:29', NULL);
INSERT INTO `sw_record` VALUES (4, '3', '[3]', '0', '2024-11-07 10:59:29', NULL, '2024-11-07 11:42:29', NULL);
INSERT INTO `sw_record` VALUES (5, '2', '[0,3]', '0', '2024-11-07 10:59:29', NULL, '2024-11-07 11:42:29', NULL);
INSERT INTO `sw_record` VALUES (6, '4', '[3]', '0', '2024-11-07 10:59:29', NULL, '2024-11-07 11:42:29', NULL);
INSERT INTO `sw_record` VALUES (7, '7', '[3]', '0', '2024-11-07 10:59:29', NULL, '2024-11-07 11:42:29', NULL);

SET FOREIGN_KEY_CHECKS = 1;
