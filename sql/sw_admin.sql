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

 Date: 07/11/2024 12:28:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sw_admin
-- ----------------------------
DROP TABLE IF EXISTS `sw_admin`;
CREATE TABLE `sw_admin`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '删除标识',
  `create_time` datetime NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '0男1女',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `study_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `role` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '角色0管理员1学生',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '管理员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sw_admin
-- ----------------------------
INSERT INTO `sw_admin` VALUES (6, 'stu1', '$2a$10$WwVIt81j2au91K0WVqbZ4OZxlajm5c3dUuZJV8lIXjN/Ye5rEiZnW', '学生1', NULL, '0', '2024-11-06 13:43:12', NULL, NULL, NULL, '0', '13300000000', '2024', 20, '1');
INSERT INTO `sw_admin` VALUES (7, 'admin', '$2a$10$lp7KxAomW6vlJDzIWURti.9FU6IYA8na.wdJXom0vKqy/JX06mEte', '管理员', NULL, '0', '2024-11-06 13:43:49', NULL, NULL, NULL, '0', '13300000001', '', 40, '0');
INSERT INTO `sw_admin` VALUES (8, 'stu2', '$2a$10$Phyl8eS.GZeSakkIWbJRNuOTsiSC.2NyTtpnYsb/Uuz7i8y23N322', '学生2', NULL, '0', '2024-11-06 18:25:36', NULL, NULL, NULL, '1', '13333333333', '123', 0, '1');

SET FOREIGN_KEY_CHECKS = 1;
