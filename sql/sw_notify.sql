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

 Date: 07/11/2024 12:28:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sw_notify
-- ----------------------------
DROP TABLE IF EXISTS `sw_notify`;
CREATE TABLE `sw_notify`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `start_time` datetime NULL DEFAULT NULL,
  `end_time` datetime NULL DEFAULT NULL,
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '删除标识',
  `create_time` datetime NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sw_notify
-- ----------------------------
INSERT INTO `sw_notify` VALUES (1, '暑期游泳课程开课，培养儿童游泳兴趣', '市游泳馆暑期儿童游泳培训班正式启动，专门为5-12岁儿童设置了初级、中级和高级课程，旨在让孩子们在专业教练的指导下学会游泳技能，增强体质并提升自救能力。据悉，培训班还特别设计了趣味水上游戏环节，提升孩子们的游泳兴趣和安全意识。', '2024-11-01 00:00:00', '2024-11-09 00:00:00', '0', '2024-11-06 17:35:49', NULL, NULL, NULL);
INSERT INTO `sw_notify` VALUES (2, '周末亲子游泳体验，家庭同乐共度时光', '本周末，市游泳馆推出亲子游泳体验活动，为家庭提供一个放松身心的好去处。活动内容丰富，包括亲子互动水上游戏、水上漂浮挑战等，旨在通过水中互动增进家庭成员之间的亲密度。据活动负责人介绍，所有参与家庭将享受专属教练指导，确保游泳过程安全有序。', '2024-11-13 00:00:00', '2024-11-23 00:00:00', '0', '2024-11-06 17:36:02', NULL, NULL, NULL);
INSERT INTO `sw_notify` VALUES (3, 'xxxxxxxxxxxx', 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx', '2024-11-01 00:00:00', '2024-11-22 00:00:00', '0', '2024-11-06 17:58:45', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
