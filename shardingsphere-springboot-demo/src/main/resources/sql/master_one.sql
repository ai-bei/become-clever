/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 127.0.0.1:3306
 Source Schema         : master_one

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 07/10/2022 15:01:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for abnormal_feedback
-- ----------------------------
DROP TABLE IF EXISTS `abnormal_feedback`;
CREATE TABLE `abnormal_feedback`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `feedback_number` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '反馈单号',
  `treatment_type` varchar(1020) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '处理类型',
  `business` varchar(1020) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属业务',
  `feedback_type` varchar(1020) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '反馈类型',
  `content` varchar(1020) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `feedback_department` varchar(1020) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '反馈部门',
  `feedback_initiator` varchar(1020) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '反馈发起人',
  `feedback_initiation_time` datetime(0) NULL DEFAULT NULL COMMENT '反馈发起\r\n         时间',
  `feedback_time_limit` datetime(0) NULL DEFAULT NULL COMMENT '反馈时限',
  `reply_status` int(11) NULL DEFAULT NULL COMMENT '回复状态 0:待回复\r\n         1:已回复',
  `feedback_station_id` varchar(1020) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '反馈差异车站\r\n         明细对应id(插入多个id就用逗号隔开 例 1,2,3)',
  `feedback_order_id` varchar(1020) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '反馈差异订单\r\n         明细对应id(插入多个id就用逗号隔开 例 1,2,3)',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `reply_people` varchar(1020) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复人',
  `reply_time` datetime(0) NULL DEFAULT NULL COMMENT '回复时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE,
  UNIQUE INDEX `id_2`(`id`) USING BTREE,
  UNIQUE INDEX `id_3`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '结算对账系统异常反馈单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of abnormal_feedback
-- ----------------------------

-- ----------------------------
-- Table structure for dataone
-- ----------------------------
DROP TABLE IF EXISTS `dataone`;
CREATE TABLE `dataone`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `password` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `create_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_username_index_unique`(`id`, `username`, `password`) USING BTREE,
  INDEX `id_username_index`(`id`, `username`) USING BTREE,
  INDEX `username_password_index`(`username`, `password`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dataone
-- ----------------------------
INSERT INTO `dataone` VALUES (54, 'liu', '123', '2022-07-15');

-- ----------------------------
-- Table structure for dataone_202208
-- ----------------------------
DROP TABLE IF EXISTS `dataone_202208`;
CREATE TABLE `dataone_202208`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `password` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `create_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_username_index_unique`(`id`, `username`, `password`) USING BTREE,
  INDEX `id_username_index`(`id`, `username`) USING BTREE,
  INDEX `username_password_index`(`username`, `password`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dataone_202208
-- ----------------------------
INSERT INTO `dataone_202208` VALUES (1, 'kevin', '12313', '2022-08-01');
INSERT INTO `dataone_202208` VALUES (2, 'liu_08', '12313', '2022-08-02');

-- ----------------------------
-- Table structure for dataone_202209
-- ----------------------------
DROP TABLE IF EXISTS `dataone_202209`;
CREATE TABLE `dataone_202209`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `password` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `create_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_username_index_unique`(`id`, `username`, `password`) USING BTREE,
  INDEX `id_username_index`(`id`, `username`) USING BTREE,
  INDEX `username_password_index`(`username`, `password`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dataone_202209
-- ----------------------------
INSERT INTO `dataone_202209` VALUES (1, 'liu_09', '12313', '2022-09-08');

-- ----------------------------
-- Table structure for dataone_202210
-- ----------------------------
DROP TABLE IF EXISTS `dataone_202210`;
CREATE TABLE `dataone_202210`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `password` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `create_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_username_index_unique`(`id`, `username`, `password`) USING BTREE,
  INDEX `id_username_index`(`id`, `username`) USING BTREE,
  INDEX `username_password_index`(`username`, `password`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dataone_202210
-- ----------------------------
INSERT INTO `dataone_202210` VALUES (1, 'kevin', '123123', '2022-10-04');

-- ----------------------------
-- Table structure for operator_cash_income
-- ----------------------------
DROP TABLE IF EXISTS `operator_cash_income`;
CREATE TABLE `operator_cash_income`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id，自动递增',
  `line_id` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '线路编号',
  `line_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '线路名称',
  `station_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '站点编号',
  `station_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '站点名称',
  `statistics_time` date NULL DEFAULT NULL COMMENT '统计时间',
  `pre_discharged_money` int(11) NULL DEFAULT 0 COMMENT '车站票款现金解行合计金额',
  `cash_szt_amount` int(11) NULL DEFAULT 0 COMMENT '深圳通卡现金充值金额',
  `cash_sellcard_amount` int(11) NULL DEFAULT 0 COMMENT '深圳通卡现金工本费',
  `notcash_szt_amount` int(11) NULL DEFAULT 0 COMMENT '深圳通卡第三方充值金额',
  `notcash_sellcard_amount` int(11) NULL DEFAULT 0 COMMENT '深圳通卡第三方工本费',
  `wechat_pay` int(11) NULL DEFAULT 0 COMMENT '微信支付',
  `alipay` int(11) NULL DEFAULT 0 COMMENT '支付宝支付',
  `szt_carcode_pay` int(11) NULL DEFAULT 0 COMMENT '深圳通乘车码支付',
  `financial_card_pay` int(11) NULL DEFAULT 0 COMMENT '金融IC卡支付',
  `notcash_pay_total` int(11) NULL DEFAULT 0 COMMENT '第三方支付收入合计金额',
  `notcash_pay_receipt` int(11) NULL DEFAULT 0 COMMENT '第三方支付收款',
  `cash_discharged_receipt` int(11) NULL DEFAULT 0 COMMENT '现金解行收款',
  `remark` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '月份备注',
  `date_remark` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '日期备注',
  `line_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '线路备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '运营现金收入汇总表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of operator_cash_income
-- ----------------------------

-- ----------------------------
-- Table structure for order_bill_compared
-- ----------------------------
DROP TABLE IF EXISTS `order_bill_compared`;
CREATE TABLE `order_bill_compared`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `merc_id` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运营商户号',
  `line_id` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收益归属线路',
  `station_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收益归属站点',
  `statistics_time` date NULL DEFAULT NULL COMMENT '统计时间',
  `channel_id` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '渠道标识',
  `channel_merc_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '渠道商户号',
  `order_amount_before` int(11) NULL DEFAULT NULL COMMENT '订单应收（\r\n         编辑前）单位：分',
  `order_amount_after` int(11) NULL DEFAULT NULL COMMENT '订单应收（\r\n         编辑后）单位：分',
  `bill_amount_before` int(11) NULL DEFAULT NULL COMMENT '账单应收（\r\n         编辑前）单位：分',
  `bill_amount_after` int(11) NULL DEFAULT NULL COMMENT '账单应收（编\r\n         辑后）单位：分',
  `trans_fee_before` int(11) NULL DEFAULT NULL COMMENT '账单手续费（\r\n         编辑前）单位：分',
  `trans_fee_after` int(11) NULL DEFAULT NULL COMMENT '账单手续费（\r\n         编辑后）单位：分',
  `bill_amount_actual_before` int(11) NULL DEFAULT NULL COMMENT '账单转\r\n         账实收（编辑前）单位：分',
  `bill_amount_actual_after` int(11) NULL DEFAULT NULL COMMENT '账单转\r\n         账实收（编辑后）单位：分',
  `amount_difference_before` int(11) NULL DEFAULT NULL COMMENT '应收差\r\n         异（编辑前）单位：分',
  `amount_difference_after` int(11) NULL DEFAULT NULL COMMENT '应收差异\r\n         （编辑后）单位：分',
  `difference_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '差异类型',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `feedback_status` int(11) NULL DEFAULT NULL COMMENT '反馈状态0:无状\r\n         态 1:待回复 2:已回复',
  `feedback_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '反馈差异原因\r\n         ，设备系统反馈',
  `merc_order_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户订单号',
  `order_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单类型',
  `order_debit_time` datetime(0) NULL DEFAULT NULL COMMENT '订单扣款时间',
  `order_debit_status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单扣款状\r\n         态',
  `bill_debit_time` datetime(0) NULL DEFAULT NULL COMMENT '账单扣款时间',
  `bill_debit_status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账单扣款状态\r\n         ',
  `audit_type` int(11) NULL DEFAULT NULL COMMENT '与账单对账数据是\r\n         否一样（0：一样；1：不一样）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `difference_amount_before` int(11) NULL DEFAULT NULL COMMENT '差异金额(修改前)',
  `difference_amount_after` int(11) NULL DEFAULT NULL COMMENT '差异金额（修改后）',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE,
  UNIQUE INDEX `id_2`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单账单比对明细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_bill_compared
-- ----------------------------

-- ----------------------------
-- Table structure for pay_request_fail_audit
-- ----------------------------
DROP TABLE IF EXISTS `pay_request_fail_audit`;
CREATE TABLE `pay_request_fail_audit`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `line_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '线路编号',
  `line_name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '线路名称',
  `station_id` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '站点编号',
  `station_name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '站点名称',
  `order_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `order_type` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单类型',
  `merchant` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户号',
  `payment_type` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付类型（1-微信-乘车码，2-深圳通-乘车码，3-金融IC卡-闸机，4-深圳通-展会票）',
  `order_amt` int(11) NULL DEFAULT NULL COMMENT '订单金额 单位：分',
  `order_pay_request_time` datetime(0) NULL DEFAULT NULL COMMENT '订单请款时间',
  `order_pay_request_status` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单请款状态 （请款失败/请款成功）',
  `mr_pay_request_time` datetime(0) NULL DEFAULT NULL COMMENT '沐融请款时间',
  `mr_pay_request_status` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '沐融请款状态（请款失败/请款成功）',
  `is_pay` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否赔付',
  `responsible_party` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '责任方',
  `feedback_status` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '反馈状态（1-未反馈，2-待回复 ，3-已回复）',
  `audit_opinion` varchar(1020) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核意见',
  `audit_status` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核状态（1-待审核，2-已审核）',
  `feedback_number` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '反馈单号',
  `diff_type` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '差异类型',
  `diff_reason` varchar(1020) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '差异原因',
  `enclosure` varchar(1020) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件',
  `card_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银联卡号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `order_status` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单状态（1-正常请款失败订单，2-补缴成功的订单）',
  `opt_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE,
  UNIQUE INDEX `id_2`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '请款失败统计表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pay_request_fail_audit
-- ----------------------------

-- ----------------------------
-- Table structure for pay_request_fail_summary
-- ----------------------------
DROP TABLE IF EXISTS `pay_request_fail_summary`;
CREATE TABLE `pay_request_fail_summary`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `begin_time` date NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` date NULL DEFAULT NULL COMMENT '结束时间',
  `date_str` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间范围字符串(唯一)',
  `responsible_party` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '责任方',
  `total` int(20) NULL DEFAULT NULL COMMENT '请款失败订单笔数',
  `unpay` int(20) NULL DEFAULT NULL COMMENT '待赔付金额(分)',
  `pay` int(20) NULL DEFAULT NULL COMMENT '实际赔付金额(分)',
  `pay_date` datetime(0) NULL DEFAULT NULL COMMENT '时间赔付日期',
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '实际赔付与预计不一致原因',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `crete_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '请款失败汇总表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pay_request_fail_summary
-- ----------------------------

-- ----------------------------
-- Table structure for payment_order_ali
-- ----------------------------
DROP TABLE IF EXISTS `payment_order_ali`;
CREATE TABLE `payment_order_ali`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `serial_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '设备端流水号',
  `sys_channel` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '系统渠道/SYS-内部系统，EXT-外部系统',
  `busi_channel` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '业务渠道/EQP-设备端，WHD-自主发码代扣，FAC-人脸',
  `merc_id` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '运营商户号',
  `user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '用户号',
  `merc_order_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '商户订单号',
  `orig_order_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '原订单号',
  `busi_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '业务类型/01-支付，02-退款',
  `channel_trans_type` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '交易类型',
  `order_time` datetime(0) NULL DEFAULT NULL COMMENT '订单创建时间',
  `income_station_id` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '收益归属站点',
  `income_line_id` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '收益归属线路',
  `trans_order_status` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '交易状态',
  `channel_id` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '渠道标识',
  `carrier_type` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '载体类型',
  `sys_busi_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '系统业务名称',
  `check_status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '对账状态/1-未对账,2-对账相符,3-我方有对方无,4-我方无对方有,5-金额差错,6-存疑',
  `check_time` datetime(0) NULL DEFAULT NULL COMMENT '对账时间',
  `channel_order_no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '渠道订单号',
  `channel_return_code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '渠道返回码',
  `channel_return_msg` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '渠道返回信息',
  `channel_result_code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '渠道响应的结果码',
  `channel_error_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '渠道响应的错误码',
  `channel_error_desc` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '渠道响应的错误信息描述',
  `trans_amount` int(11) NULL DEFAULT NULL COMMENT '交易金额',
  `trans_fee` int(11) NULL DEFAULT NULL COMMENT '手续费',
  `trans_time` datetime(0) NULL DEFAULT NULL COMMENT '交易时间',
  `opt_date` datetime(0) NULL DEFAULT NULL COMMENT '运营日',
  `ip_addr` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '请求ip',
  `channel_user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '渠道用户号',
  `channel_merc_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '渠道商户号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `device_type` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '设备类型',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE,
  UNIQUE INDEX `id_2`(`id`) USING BTREE,
  UNIQUE INDEX `id_3`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci COMMENT = '支付宝订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment_order_ali
-- ----------------------------

-- ----------------------------
-- Table structure for payment_order_union
-- ----------------------------
DROP TABLE IF EXISTS `payment_order_union`;
CREATE TABLE `payment_order_union`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `serial_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '设备端流水号',
  `sys_channel` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '系统渠道/SYS-内部系统，EXT-外部系统',
  `busi_channel` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '业务渠道/EQP-设备端，WHD-自主发码代扣，FAC-人脸',
  `merc_id` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '运营商户号',
  `user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '用户号',
  `merc_order_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '商户订单号',
  `orig_order_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '原订单号',
  `busi_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '业务类型/01-支付，02-退款',
  `channel_trans_type` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '交易类型',
  `order_time` datetime(0) NULL DEFAULT NULL COMMENT '订单创建时间',
  `income_station_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '收益归属站点',
  `income_line_id` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '收益归属线路',
  `trans_order_status` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '交易状态',
  `channel_id` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '渠道标识',
  `carrier_type` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '载体类型',
  `sys_busi_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '系统业务名称',
  `check_status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '对账状态/1-未对账,2-对账相符,3-我方有对方无,4-我方无对方有,5-金额差错,6-存疑',
  `check_time` datetime(0) NULL DEFAULT NULL COMMENT '对账时间',
  `channel_order_no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '渠道订单号',
  `channel_return_code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '渠道返回码',
  `channel_return_msg` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '渠道返回信息',
  `channel_result_code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '渠道响应的结果码',
  `channel_error_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '渠道响应的错误码',
  `channel_error_desc` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '渠道响应的错误信息描述',
  `trans_amount` int(11) NULL DEFAULT NULL COMMENT '交易金额',
  `trans_fee` int(11) NULL DEFAULT NULL COMMENT '手续费',
  `trans_time` datetime(0) NULL DEFAULT NULL COMMENT '交易时间',
  `opt_date` date NULL DEFAULT NULL COMMENT '运营日',
  `ip_addr` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '请求ip',
  `channel_user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '渠道用户号',
  `channel_merc_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '渠道商户号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `device_type` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '设备类型',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE,
  UNIQUE INDEX `id_2`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci COMMENT = '银联订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment_order_union
-- ----------------------------

-- ----------------------------
-- Table structure for payment_order_upic
-- ----------------------------
DROP TABLE IF EXISTS `payment_order_upic`;
CREATE TABLE `payment_order_upic`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `serial_time` datetime(0) NULL DEFAULT NULL,
  `sys_channel` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `busi_channel` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `merc_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `merc_order_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `orig_order_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `card_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `busi_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `channel_trans_type` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `trans_time` datetime(0) NULL DEFAULT NULL,
  `trans_amount` int(11) NULL DEFAULT NULL,
  `trans_fee` int(11) NULL DEFAULT NULL,
  `trans_order_status` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `channel_id` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `carrier_type` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `sys_busi_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `check_status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `check_time` datetime(0) NULL DEFAULT NULL,
  `channel_order_no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `channel_return_code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `channel_return_msg` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `opt_date` date NULL DEFAULT NULL,
  `up_trans_type` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `channel_user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `channel_merc_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `authorization_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `batch_no` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `up_liquida_date` datetime(0) NULL DEFAULT NULL,
  `local_datetime_tran` datetime(0) NULL DEFAULT NULL,
  `card_seq` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `global_credit_code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `trade_type` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `device_id` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `oda_sys_date` datetime(0) NULL DEFAULT NULL,
  `tra_key_type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `sys_serial_no` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `add_resp_data` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `org_no` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `in_record_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `out_record_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment_order_upic
-- ----------------------------

-- ----------------------------
-- Table structure for payment_order_wechat
-- ----------------------------
DROP TABLE IF EXISTS `payment_order_wechat`;
CREATE TABLE `payment_order_wechat`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `sys_channel` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `busi_channel` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `merc_id` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `merc_order_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `orig_order_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `busi_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `channel_trans_type` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `order_time` datetime(0) NULL DEFAULT NULL,
  `income_station_id` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `income_line_id` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `trans_order_status` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `channel_id` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `carrier_type` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `sys_busi_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `check_status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `check_time` datetime(0) NULL DEFAULT NULL,
  `channel_order_no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `channel_return_code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `channel_return_msg` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `channel_result_code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `channel_error_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `channel_error_desc` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `trans_amount` int(11) NULL DEFAULT NULL,
  `trans_fee` int(11) NULL DEFAULT NULL,
  `trans_time` datetime(0) NULL DEFAULT NULL,
  `opt_date` date NULL DEFAULT NULL,
  `ip_addr` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `channel_user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `channel_merc_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `device_type` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment_order_wechat
-- ----------------------------

-- ----------------------------
-- Table structure for payment_postpaid_check
-- ----------------------------
DROP TABLE IF EXISTS `payment_postpaid_check`;
CREATE TABLE `payment_postpaid_check`  (
  `id` bigint(20) NOT NULL COMMENT '自增id',
  `opt_date` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '运营日期',
  `merc_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '运营主体编号',
  `income_station_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '收益归属站点',
  `income_station_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '收益归属站点名称',
  `income_line_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '收益归主线路',
  `income_line_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '收益归属线路名称',
  `t1_pay_amount` int(11) NULL DEFAULT NULL COMMENT 't1支付金额',
  `t2_pay_amount` int(11) NULL DEFAULT NULL COMMENT 't2支付金额',
  `t1_refund_amount` int(11) NULL DEFAULT NULL COMMENT 't1退款金额',
  `t2_refund_amount` int(11) NULL DEFAULT NULL COMMENT 't2退款金额',
  `t1_pay_fee` int(11) NULL DEFAULT NULL COMMENT 't1支付手续费',
  `t2_pay_fee` int(11) NULL DEFAULT NULL COMMENT 't2支付手续费',
  `t1_refund_fee` int(11) NULL DEFAULT NULL COMMENT 't1退款手续费',
  `t2_refund_fee` int(11) NULL DEFAULT NULL COMMENT 't2退款手续费',
  `actual_income_amount` int(11) NULL DEFAULT NULL COMMENT '实收金额',
  `channel_id` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '渠道',
  `busi_channel` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '业务',
  `device_type` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '设备类型',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `order_pay_num` int(11) NULL DEFAULT NULL COMMENT '支付订单笔数',
  `channel_merc_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '渠道商户号',
  `order_refund_num` int(11) NULL DEFAULT NULL COMMENT '退款订单笔数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci COMMENT = '后付费实收汇总' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment_postpaid_check
-- ----------------------------

-- ----------------------------
-- Table structure for payment_postpaid_order
-- ----------------------------
DROP TABLE IF EXISTS `payment_postpaid_order`;
CREATE TABLE `payment_postpaid_order`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `opt_date` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '运营日期',
  `merc_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '运营主体编号',
  `channel_merc_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '渠道商户号',
  `channel_id` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '渠道',
  `busi_channel` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '业务',
  `device_type` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '设备类型',
  `income_line_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '收益归属线路',
  `income_line_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '收益归属线路名称',
  `income_station_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '收益归属站点',
  `income_station_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '收益归属站点名称',
  `date_type` int(11) NULL DEFAULT NULL COMMENT '统计日期类型（1自然日，2运营日，3银联结算日）',
  `t1_pay_amount` int(11) NULL DEFAULT NULL COMMENT 't1支付金额',
  `t2_pay_amount` int(11) NULL DEFAULT NULL COMMENT 't2支付金额',
  `t1_fail_amount` int(11) NULL DEFAULT NULL COMMENT 't1支付失败金额',
  `t2_fail_amount` int(11) NULL DEFAULT NULL COMMENT 't2支付失败金额',
  `t1_refund_amount` int(11) NULL DEFAULT NULL COMMENT 't1退款金额',
  `t2_refund_amount` int(11) NULL DEFAULT NULL COMMENT 't2退款金额',
  `t1_pay_fee` int(11) NULL DEFAULT NULL COMMENT 't1支付手续费',
  `t2_pay_fee` int(11) NULL DEFAULT NULL COMMENT 't2支付手续费',
  `t1_refund_fee` int(11) NULL DEFAULT NULL COMMENT 't1退款手续费',
  `t2_refund_fee` int(11) NULL DEFAULT NULL COMMENT 't2退款手续费',
  `actual_income_amount` int(11) NULL DEFAULT NULL COMMENT '实收金额',
  `order_pay_num` int(11) NULL DEFAULT NULL COMMENT '支付笔数',
  `order_refund_num` int(11) NULL DEFAULT NULL COMMENT '退款笔数',
  `order_fail_num` int(11) NULL DEFAULT NULL COMMENT '请款失败笔数',
  `order_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '订单类型/参考企标',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE,
  UNIQUE INDEX `id_2`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci COMMENT = '后付费应收汇总' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment_postpaid_order
-- ----------------------------

-- ----------------------------
-- Table structure for payment_ticket_order
-- ----------------------------
DROP TABLE IF EXISTS `payment_ticket_order`;
CREATE TABLE `payment_ticket_order`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `serial_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '外部流水号',
  `serial_time` datetime(0) NULL DEFAULT NULL COMMENT '外部请求时间',
  `sys_channel` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '系统渠道/SYS-内部系统，EXT-外部系统',
  `busi_channel` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '业务渠道/EQP-设备端，WHD-自主发码代扣，FAC-人脸',
  `merc_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '收益商户号',
  `merc_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '收益商户名称',
  `merc_order_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '商户订单号',
  `order_time` datetime(0) NULL DEFAULT NULL COMMENT '订单生成时间',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `order_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '订单类型/01-互联网购票，02-互联网充值，03-互联网消费，04-互联网退款，05-互联网撤销',
  `order_capital_type` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '订单资金类型/1-现金，2-充值卡，3-积分',
  `order_amount` int(11) NULL DEFAULT NULL COMMENT '订单金额',
  `total_refund_amount` int(11) NULL DEFAULT NULL COMMENT '已退款总金额',
  `channel_id` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '渠道编号',
  `order_status` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '交易状态/unpay-未支付，pay-已支付，refund-已退款，cancle-已撤销',
  `in_device_id` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '进站设备编号',
  `in_station_id` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '进站站点编号',
  `in_station_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '进站站点名称',
  `out_device_id` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '出站设备编号',
  `out_station_id` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '出站站点编号',
  `out_station_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '出站站点名称',
  `opt_device_id` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '运营设备编号',
  `opt_station_id` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '运营站点编号',
  `opt_station_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '运营站点名称',
  `income_station_id` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '收益归属站点',
  `income_line_id` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '收益归属线路',
  `ticket_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '票务状态/TS-出票成功，TF-出票失败，TM-部分出票',
  `opt_date` datetime(0) NULL DEFAULT NULL,
  `pay_model` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `carrier_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `szmc_trans_type` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `device_type` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE,
  UNIQUE INDEX `id_2`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci COMMENT = '云购票/第三方票务订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment_ticket_order
-- ----------------------------

-- ----------------------------
-- Table structure for payment_ticket_subwhd
-- ----------------------------
DROP TABLE IF EXISTS `payment_ticket_subwhd`;
CREATE TABLE `payment_ticket_subwhd`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `merc_order_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '商户订单号',
  `in_opt_date` datetime(0) NULL DEFAULT NULL COMMENT '补进站操作时间',
  `in_opt_device_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '补进站设备编号',
  `in_opt_device_type` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '补进站设备类型',
  `in_opt_station_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '补进站站点编号',
  `in_opt_station_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '补进站站点名称',
  `in_opt_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '补进站操作员编号',
  `out_opt_date` datetime(0) NULL DEFAULT NULL COMMENT '补出站操作时间',
  `out_opt_device_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '补出站设备编号',
  `out_opt_device_type` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '补出站设备类型',
  `out_opt_station_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '补出站站点编号',
  `out_opt_station_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '补出站站点名称',
  `out_opt_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '补出站操作员编号',
  `biz_record_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '核准交易流水号',
  `biz_trans_date` datetime(0) NULL DEFAULT NULL COMMENT '核准交易时间',
  `biz_trans_type` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '核准交易类型',
  `biz_device_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '核准设备编号',
  `biz_device_type` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '核准设备类型',
  `biz_station_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '核准站点编号',
  `biz_station_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '核准站点名称',
  `biz_opt_date` datetime(0) NULL DEFAULT NULL COMMENT '补核准操作时间',
  `biz_opt_device_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '补核准设备编号',
  `biz_opt_device_type` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '补核准设备类型',
  `biz_opt_station_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '补核准站点编号',
  `biz_opt_station_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '补核准站点名称',
  `biz_opt_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '补核准操作员编号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE,
  UNIQUE INDEX `id_2`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci COMMENT = '代扣交易订单子表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment_ticket_subwhd
-- ----------------------------

-- ----------------------------
-- Table structure for payment_ticket_up
-- ----------------------------
DROP TABLE IF EXISTS `payment_ticket_up`;
CREATE TABLE `payment_ticket_up`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `serial_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '设备流水号',
  `serial_time` datetime(0) NULL DEFAULT NULL COMMENT '外部请求时间',
  `sys_channel` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '系统渠道/SYS-内部系统，EXT-外部系统',
  `busi_channel` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '业务渠道/EQP-设备端，WHD-自主发码代扣，FAC-人脸，UPC-银联卡',
  `search_ref_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '检索号',
  `merc_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '收益商户号',
  `merc_order_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '商户订单号',
  `orig_order_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '原关联订单号',
  `card_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '银联卡号',
  `order_time` datetime(0) NULL DEFAULT NULL COMMENT '订单生成时间',
  `trans_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `order_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '参考企标',
  `auth_id` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '授权号',
  `card_serial_no` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '卡序列号',
  `order_amount` int(11) NULL DEFAULT NULL COMMENT '订单金额',
  `total_refund_amount` int(11) NULL DEFAULT NULL COMMENT '已退款总金额',
  `channel_id` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '渠道编号',
  `busi_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '业务类型',
  `channel_trans_type` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '渠道交易类型',
  `up_org_id` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '银联机构号',
  `up_order_status` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '交易状态/PAI-预授权初始化，PAS-预授权成功，PAF-预授权失败，PAU-预授权未知，PACS-预授权撤销成功，PACF-预授权撤销失败，PAFS-预授权完成成功，PAFF-预授权完成失败，PAFU-预授权完成未知，PAFRS-',
  `in_device_id` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '进站设备编号',
  `in_station_id` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '进站站点编号',
  `in_station_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '进站站点名称',
  `out_device_id` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '出站设备编号',
  `out_station_id` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '出站站点编号',
  `out_station_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '出站站点名称',
  `opt_device_id` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '运营设备编号',
  `opt_station_id` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '运营站点编号',
  `opt_station_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '运营站点名称',
  `income_station_id` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '收益归属站点',
  `income_line_id` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '收益归属线路',
  `track_2` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '2磁道数据',
  `opt_date` date NULL DEFAULT NULL COMMENT '运营日期',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `in_station_time` datetime(0) NULL DEFAULT NULL COMMENT '进站时间',
  `out_station_time` datetime(0) NULL DEFAULT NULL COMMENT '出站时间',
  `in_device_type` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '进站设备类型',
  `in_record_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '进站交易记录Id',
  `out_record_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '出站交易记录ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE,
  UNIQUE INDEX `id_2`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci COMMENT = '银联IC卡交易流水表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment_ticket_up
-- ----------------------------

-- ----------------------------
-- Table structure for payment_ticket_withhold
-- ----------------------------
DROP TABLE IF EXISTS `payment_ticket_withhold`;
CREATE TABLE `payment_ticket_withhold`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `sys_channel` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '系统渠道/SYS-内部系统，EXT-外部系统',
  `busi_channel` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '业务渠道/EQP-设备端，WHD-自主发码代扣，FAC-人脸',
  `merc_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '商户号',
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '用户号',
  `thd_app_id` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '第三方应用',
  `thd_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '第三方应用用户号',
  `merc_order_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '商户订单号',
  `pay_channel` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '代扣渠道/01-支付宝，02-微信，03-银联',
  `card_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '票卡类型/01-虚拟票，02-实体票',
  `ticket_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '车票类型/10-普通单程票，11-商务单程票，12-老人单程票，13-儿童往返票，14-二维码代扣车票，40-往返票',
  `order_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '订单类型/参考企标',
  `big_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '订单大类/参考企标',
  `small_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '订单小类/参考企标',
  `order_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '订单状态',
  `order_amount` int(11) NULL DEFAULT NULL COMMENT '订单金额',
  `pay_amount` int(11) NULL DEFAULT NULL COMMENT '支付金额',
  `refund_amount` int(11) NULL DEFAULT NULL COMMENT '退款金额',
  `trans_fee` int(11) NULL DEFAULT NULL COMMENT '手续费',
  `order_date` datetime(0) NULL DEFAULT NULL COMMENT '订单生成时间',
  `pay_date` datetime(0) NULL DEFAULT NULL COMMENT '付款时间',
  `refund_date` datetime(0) NULL DEFAULT NULL COMMENT '退款时间',
  `in_record_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '进站流水号',
  `in_trans_date` datetime(0) NULL DEFAULT NULL COMMENT '进站时间',
  `in_trans_type` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '进站交易类型',
  `in_device_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '进站设备编号',
  `in_device_type` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '进站设备类型',
  `in_station_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '进站站点编号',
  `in_station_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '进站站点名称',
  `out_record_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '出站流水号',
  `out_trans_date` datetime(0) NULL DEFAULT NULL COMMENT '出站时间',
  `out_trans_type` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '出站交易类型',
  `out_device_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '出站设备编号',
  `out_device_type` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '出站设备类型',
  `out_station_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '出站站点编号',
  `out_station_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '出站站点名称',
  `income_device_id` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '收益归属设备',
  `income_station_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '收益归属站点',
  `income_line_id` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '收益归属线路',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `user_type` int(11) NULL DEFAULT NULL COMMENT '用户类型： 1-付费用户 2-免费用户',
  `virtual_card_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '卡号',
  `appeal_status` int(11) NULL DEFAULT NULL COMMENT '订单详细的申述状态 0-未申述 1-申诉中 2-审核拒绝3-审核通过 4-退款成功',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE,
  UNIQUE INDEX `id_2`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci COMMENT = '代扣交易主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment_ticket_withhold
-- ----------------------------

-- ----------------------------
-- Table structure for payment_ticket_withhold_fail
-- ----------------------------
DROP TABLE IF EXISTS `payment_ticket_withhold_fail`;
CREATE TABLE `payment_ticket_withhold_fail`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `sys_channel` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统渠道',
  `busi_channel` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务渠道',
  `merc_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运营主体',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户号',
  `thd_app_id` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '第三方拉码应用id',
  `thd_user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '第三方拉码用户id',
  `merc_order_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `pay_channel` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '扣款渠道',
  `card_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡类型',
  `ticket_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车票类型',
  `order_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单类型',
  `big_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易大类',
  `small_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易小类',
  `order_status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单状态',
  `order_amount` int(11) NULL DEFAULT NULL COMMENT '订单金额',
  `pay_amount` int(11) NULL DEFAULT NULL COMMENT '付款金额',
  `refund_amount` int(11) NULL DEFAULT NULL COMMENT '退款金额',
  `trans_fee` int(11) NULL DEFAULT NULL COMMENT '手续费',
  `order_date` datetime(0) NULL DEFAULT NULL COMMENT '订单时间',
  `pay_date` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `refund_date` datetime(0) NULL DEFAULT NULL COMMENT '退款时间',
  `in_record_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '进站交易编号',
  `in_trans_date` datetime(0) NULL DEFAULT NULL COMMENT '进站交易时间',
  `in_trans_type` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '进站交易类型',
  `in_device_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '进站设备编号',
  `in_device_type` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '进站设备类型',
  `in_station_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '进站站点编号',
  `in_station_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '进站站点名称',
  `out_record_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出站交易编号',
  `out_trans_date` datetime(0) NULL DEFAULT NULL COMMENT '出站交易时间',
  `out_trans_type` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出站交易类型',
  `out_device_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出站设备编号',
  `out_device_type` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出站设备类型',
  `out_station_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出站站点编号',
  `out_station_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出站站点名称',
  `income_device_id` varchar(9) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收益设备编号',
  `income_station_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收益站点编号',
  `income_line_id` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收益线路编号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `user_type` int(11) NULL DEFAULT NULL COMMENT '用户类型（付费、免费）',
  `virtual_card_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '虚拟卡号',
  `appeal_status` int(11) NULL DEFAULT NULL COMMENT '申述状态',
  `retry_time` int(11) NULL DEFAULT NULL COMMENT '失败重试次数',
  UNIQUE INDEX `id`(`id`) USING BTREE,
  UNIQUE INDEX `id_2`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '代扣失败表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment_ticket_withhold_fail
-- ----------------------------

-- ----------------------------
-- Table structure for payment_ticket_withhold_slt
-- ----------------------------
DROP TABLE IF EXISTS `payment_ticket_withhold_slt`;
CREATE TABLE `payment_ticket_withhold_slt`  (
  `id` bigint(20) NOT NULL COMMENT '自增主键',
  `sys_channel` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '系统渠道',
  `busi_channel` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '业务渠道',
  `merc_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '运营主体',
  `thd_app_id` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '第三方拉码应用id',
  `thd_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '第三方拉码用户id',
  `merc_order_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '订单号',
  `orig_order_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `pay_channel` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '扣款渠道',
  `order_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `order_amount` int(11) NULL DEFAULT NULL,
  `pay_amount` int(11) NULL DEFAULT NULL,
  `refund_amount` int(11) NULL DEFAULT NULL,
  `trans_fee` int(11) NULL DEFAULT NULL,
  `order_date` datetime(0) NULL DEFAULT NULL,
  `pay_date` datetime(0) NULL DEFAULT NULL,
  `refund_date` datetime(0) NULL DEFAULT NULL,
  `in_record_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `in_trans_date` datetime(0) NULL DEFAULT NULL,
  `in_trans_type` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `in_device_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `in_device_type` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `in_station_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `in_station_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `out_record_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `out_trans_date` datetime(0) NULL DEFAULT NULL,
  `out_trans_type` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `out_device_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `out_device_type` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `out_station_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `out_station_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `income_device_id` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `income_station_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `income_line_id` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '用户号',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci COMMENT = '补缴流水表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment_ticket_withhold_slt
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
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'kevin11', '12345611');
INSERT INTO `user` VALUES (2, 'liu', '123456');
INSERT INTO `user` VALUES (3, 'user', '123');
INSERT INTO `user` VALUES (4, 'user', '123');
INSERT INTO `user` VALUES (5, 'user', '123');
INSERT INTO `user` VALUES (6, 'user', '123');
INSERT INTO `user` VALUES (7, '73k0', '250');
INSERT INTO `user` VALUES (8, 'g5ds', 'wd8b');

SET FOREIGN_KEY_CHECKS = 1;
