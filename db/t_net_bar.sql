
-- ----------------------------
-- Table structure for `t_net_bar`
-- ----------------------------
DROP TABLE IF EXISTS `t_net_bar`;
CREATE TABLE `t_net_bar` (
  `id` varchar(50) NOT NULL DEFAULT '' COMMENT '网吧注册号（barId）主键',
  `main_id` varchar(50) DEFAULT NULL COMMENT '部中心网吧ID',
  `netbar_name` varchar(50) DEFAULT NULL COMMENT '网吧名称',
  `netbar_state` varchar(10) DEFAULT NULL COMMENT '网吧状态',
  `district_code` varchar(10) DEFAULT NULL COMMENT '区划编码',
  `reg_address` varchar(50) DEFAULT NULL COMMENT '区划地址',
  `reg_address_detail` varchar(100) DEFAULT NULL COMMENT '详细地址',
  `reg_fund` varchar(10) DEFAULT NULL COMMENT '注册资本',
  `economic_type` varchar(10) DEFAULT NULL COMMENT '经济类型',
  `approval_num` varchar(50) DEFAULT NULL COMMENT '许可证号',
  `approval_dept` varchar(50) DEFAULT NULL COMMENT '批准机关名称',
  `approval_date` varchar(50) DEFAULT NULL COMMENT '批准日期',
  `legal_name` varchar(50) DEFAULT NULL COMMENT '法人姓名',
  `busi_area` varchar(10) DEFAULT NULL COMMENT '经营面积',
  `computer_num` int(10) unsigned DEFAULT '0' COMMENT '核定终端台数',
  `ip` varchar(500) DEFAULT NULL,
  `isdeleted` int(255) DEFAULT '0' COMMENT '是否删除\r\n        \r\n0：新增或更新；\r\n1：删除',
  `update_time` varchar(50) DEFAULT NULL COMMENT '网吧信息在部中心的更新时间',
  `contact_name` varchar(50) DEFAULT NULL COMMENT '联系人姓名',
  `contact_tel` varchar(20) DEFAULT NULL COMMENT '联系人手机号',
  `city_code` varchar(50) DEFAULT NULL COMMENT '市代码',
  `isdeployed` int(255) DEFAULT '0' COMMENT '是否已施工完成',
  `create_time` varchar(50) DEFAULT NULL,
  `sync_time` varchar(50) DEFAULT NULL,
  `client_version` varchar(50) DEFAULT NULL,
  `server_version` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;