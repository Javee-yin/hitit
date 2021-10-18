CREATE TABLE `h_user` (
  `id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '主键，不允许自增',
  `login_name` varchar(100) NOT NULL DEFAULT '' COMMENT '登录用户名',
  `phone` varchar(20) DEFAULT NULL COMMENT '用户手机号',
  `login_pwd` varchar(100) NOT NULL DEFAULT '' COMMENT '密码',
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