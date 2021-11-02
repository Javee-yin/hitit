DROP TABLE IF EXISTS `h_user`;

CREATE TABLE `h_user` (
  `id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '主键，不允许自增',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '登录用户名',
  `phone` varchar(20) DEFAULT NULL COMMENT '用户手机号',
  `pwd` varchar(100) NOT NULL DEFAULT '' COMMENT '密码',
  `sex` varchar(10) NOT NULL DEFAULT '' COMMENT '性别',
  `address` varchar(200) NOT NULL DEFAULT '' COMMENT '住址',
  `email` varchar(100) NOT NULL DEFAULT '' COMMENT '邮箱',
  `create_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `update_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `updated_by` varchar(255) DEFAULT NULL COMMENT '更新人',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否已经删除，0未删除(默认)，1已删除',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='登录用户表';

CREATE TABLE `h_msg` (
  `id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '主键，不允许自增',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '留言用户名',
  `msg` varchar(1000) DEFAULT NULL COMMENT '留言信息',
  `create_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `update_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `updated_by` varchar(255) DEFAULT NULL COMMENT '更新人',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否已经删除，0未删除(默认)，1已删除',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='用户留言信息表';

delete from h_user where id in (1,2,3,4);
INSERT INTO h_user
(id, name, phone, pwd, sex, address, email, create_time, created_by, update_time, updated_by, is_deleted, remark)
VALUES(1, 'jemmy', '15100000000', '$2a$10$gfPWvjP/SGVViqJumH010.XZsRqkq/m4CQHpHy68yTz.ElzqZmpHi', 'female', 'beijing', 'jemmy@hitit.com', '2021-10-19 10:41:19.0', 'Javee', '2021-10-19 10:41:19.0', '', 0, '内置用户');
INSERT INTO h_user
(id, name, phone, pwd, sex, address, email, create_time, created_by, update_time, updated_by, is_deleted, remark)
VALUES(2, 'jack', '15111111111', '$2a$10$EyrqSpdUpGcLbKu0SsR/wuMWZd80FR5Zb3fxYzHHrvozXEokqdRFC', 'male', 'shanghai', 'jack@hitit.com', '2021-10-19 10:41:19.0', 'Javee', '2021-10-19 10:41:19.0', '', 0, '内置用户');
INSERT INTO h_user
(id, name, phone, pwd, sex, address, email, create_time, created_by, update_time, updated_by, is_deleted, remark)
VALUES(3, 'lucy', '15122222222', '$2a$10$fA73fhiYHNPtMiTX2VXAEuDnt.k5EbJHVAMJApGP3U0uxclv9ASxO', 'female', 'nanjing', 'lucy@hitit.com', '2021-10-19 10:41:19.0', 'Javee', '2021-10-19 10:41:19.0', '', 0, '内置用户');
INSERT INTO h_user
(id, name, phone, pwd, sex, address, email, create_time, created_by, update_time, updated_by, is_deleted, remark)
VALUES(4, 'alice', '15133333333', '$2a$10$Wo2fSncjE96U5T60RDn7s.JMbSdCVapSaRQzP2IYLplMJ41Tmn5dK', 'female', 'xi·an', 'alice@hitit.com', '2021-10-19 10:41:19.0', 'Javee', '2021-10-19 10:41:19.0', '', 0, '内置用户');
