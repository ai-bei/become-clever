/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 127.0.0.1:3306
 Source Schema         : salve_one

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 07/10/2022 15:01:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dataone
-- ----------------------------
DROP TABLE IF EXISTS `dataone`;
CREATE TABLE `dataone`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `password` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `create_date` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_username_index_unique`(`id`, `username`, `password`) USING BTREE,
  INDEX `id_username_index`(`id`, `username`) USING BTREE,
  INDEX `username_password_index`(`username`, `password`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dataone
-- ----------------------------

-- ----------------------------
-- Table structure for dataone_202208
-- ----------------------------
DROP TABLE IF EXISTS `dataone_202208`;
CREATE TABLE `dataone_202208`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `password` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `create_date` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_username_index_unique`(`id`, `username`, `password`) USING BTREE,
  INDEX `id_username_index`(`id`, `username`) USING BTREE,
  INDEX `username_password_index`(`username`, `password`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dataone_202208
-- ----------------------------

-- ----------------------------
-- Table structure for dataone_202209
-- ----------------------------
DROP TABLE IF EXISTS `dataone_202209`;
CREATE TABLE `dataone_202209`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `password` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `create_date` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_username_index_unique`(`id`, `username`, `password`) USING BTREE,
  INDEX `id_username_index`(`id`, `username`) USING BTREE,
  INDEX `username_password_index`(`username`, `password`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dataone_202209
-- ----------------------------

-- ----------------------------
-- Table structure for dataone_202210
-- ----------------------------
DROP TABLE IF EXISTS `dataone_202210`;
CREATE TABLE `dataone_202210`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `password` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `create_date` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_username_index_unique`(`id`, `username`, `password`) USING BTREE,
  INDEX `id_username_index`(`id`, `username`) USING BTREE,
  INDEX `username_password_index`(`username`, `password`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dataone_202210
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'kevin', '123456');
INSERT INTO `user` VALUES (2, 'liu', '123456');

SET FOREIGN_KEY_CHECKS = 1;
