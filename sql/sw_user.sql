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

 Date: 07/11/2024 12:28:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sw_user
-- ----------------------------
DROP TABLE IF EXISTS `sw_user`;
CREATE TABLE `sw_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `study_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学号',
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '0男1女',
  `age` int NULL DEFAULT NULL,
  `card_no` int NULL DEFAULT NULL COMMENT '手牌号',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '删除标识',
  `create_time` datetime NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `avatar` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '人员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sw_user
-- ----------------------------
INSERT INTO `sw_user` VALUES (1, '张三', '001', '0', 20, 1, '2', '2024-10-28 19:15:40', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sw_user` VALUES (2, '李丽', '002', '1', 19, 1, '2', '2024-10-28 23:11:31', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sw_user` VALUES (3, '李四', '010', '0', 20, 9, '2', '2024-10-28 23:24:56', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sw_user` VALUES (4, 'yy', '23333', '1', 24, 9, '2', '2024-10-29 14:51:45', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sw_user` VALUES (5, '555', '666', '1', 55, 22, '2', '2024-10-29 14:52:40', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sw_user` VALUES (6, '97979', '46', '1', 46, 14, '2', '2024-10-29 15:01:26', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sw_user` VALUES (7, 'lili', '123', '1', 20, 1, '2', '2024-10-29 16:15:51', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sw_user` VALUES (8, '李丽', '123', '1', 20, 1, '2', '2024-10-29 16:16:20', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sw_user` VALUES (9, '张三', '121', '0', 16, 10, '2', '2024-10-29 16:16:42', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sw_user` VALUES (10, '李红', '111', '1', 20, 1, '2', '2024-10-29 16:44:53', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sw_user` VALUES (11, '丽丽', '123', '1', 20, 1, '2', '2024-10-30 10:35:42', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sw_user` VALUES (12, '张三', '111111', '0', 20, 18, '2', '2024-10-30 10:36:46', NULL, '2024-10-30 10:38:18', NULL, NULL, NULL);
INSERT INTO `sw_user` VALUES (13, '李四', '1', '1', 11, 2, '2', '2024-10-30 10:36:55', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sw_user` VALUES (14, '李四', '111', '1', 11, 3, '2', '2024-10-30 10:38:54', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sw_user` VALUES (15, '李四', '12', '1', 12, 8, '2', '2024-10-30 10:41:57', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sw_user` VALUES (16, '王', '12', '1', 12, 10, '2', '2024-10-30 10:42:05', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sw_user` VALUES (17, 'zhangsan', '1111', '0', 20, 15, '2', '2024-10-30 10:46:35', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sw_user` VALUES (18, '李四', '20', '0', 22, 10, '2', '2024-10-30 10:47:03', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sw_user` VALUES (19, '学生1', '2024', '0', 20, 1, '0', '2024-11-06 18:25:05', NULL, NULL, NULL, 'stu1', NULL);
INSERT INTO `sw_user` VALUES (20, '学生2', '123', '1', 0, 5, '2', '2024-11-06 18:25:55', NULL, NULL, NULL, 'stu2', NULL);
INSERT INTO `sw_user` VALUES (21, '学生2', '123', '1', 0, 1, '2', '2024-11-06 18:32:35', NULL, NULL, NULL, 'stu2', NULL);
INSERT INTO `sw_user` VALUES (22, '学生2', '123', '1', 0, 1, '0', '2024-11-06 18:42:38', NULL, NULL, NULL, 'stu2', NULL);

SET FOREIGN_KEY_CHECKS = 1;
