/*
Navicat MySQL Data Transfer

Source Server         : wenhua
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : qcms

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-03 16:55:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_areas_code
-- ----------------------------
DROP TABLE IF EXISTS `t_areas_code`;
CREATE TABLE `t_areas_code` (
  `areasid` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '',
  `areasname` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `rankno` char(1) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`areasid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for t_file_bar
-- ----------------------------
DROP TABLE IF EXISTS `t_file_bar`;
CREATE TABLE `t_file_bar` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `fileId` bigint(11) DEFAULT NULL COMMENT '文件id',
  `barid` varchar(255) DEFAULT NULL COMMENT '网吧id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87985 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_file_info
-- ----------------------------
DROP TABLE IF EXISTS `t_file_info`;
CREATE TABLE `t_file_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '文件id',
  `filename` varchar(100) DEFAULT NULL COMMENT '文件名称',
  `version` varchar(50) DEFAULT NULL COMMENT '版本号',
  `md5` varchar(100) DEFAULT NULL,
  `flag` char(1) DEFAULT NULL COMMENT '文件所在模块（1-服务端，2-客户端）',
  `type` char(1) DEFAULT NULL COMMENT '文件类型（0-忽略，1-dll，2-exe）',
  `action` char(1) DEFAULT NULL COMMENT '启用方式（0-忽略，1-加载dll，2-运行exe）',
  `is_apply` char(1) DEFAULT NULL COMMENT '是否应用到所有网吧1-是，0-否',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '状态(1:有效；0:无效)',
  `data` longblob COMMENT '文件二进制数组',
  `creator` bigint(11) DEFAULT NULL COMMENT '创建人',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `last_modifier` bigint(11) DEFAULT NULL COMMENT '最后修改人',
  `last_modify_time` date DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_netbar_deploy
-- ----------------------------
DROP TABLE IF EXISTS `t_netbar_deploy`;
CREATE TABLE `t_netbar_deploy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `netbarCode` varchar(50) DEFAULT NULL,
  `detectNum` varchar(20) DEFAULT NULL,
  `installNum` varchar(20) DEFAULT NULL,
  `is_deploy` varchar(20) DEFAULT NULL,
  `onlineNum` varchar(20) DEFAULT NULL,
  `reportTime` varchar(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `deployTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_net_bar
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

-- ----------------------------
-- Table structure for t_pc_info
-- ----------------------------
DROP TABLE IF EXISTS `t_pc_info`;
CREATE TABLE `t_pc_info` (
  `id` varchar(50) NOT NULL COMMENT '客户机MAC地址',
  `bar_id` varchar(50) NOT NULL COMMENT '网吧ID',
  `ip` varchar(50) NOT NULL COMMENT '客户机IP地址',
  `pc_name` varchar(50) NOT NULL COMMENT '客户机主机名',
  `os_type` int(11) NOT NULL COMMENT '客户机操作系统类型',
  `os_version` varchar(50) NOT NULL COMMENT '客户机操作系统版本',
  `wenhua_ver` varchar(50) NOT NULL COMMENT '文化客户端版本',
  `creator` varchar(50) NOT NULL COMMENT '创建者',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网吧客户机基本信息';

-- ----------------------------
-- Table structure for t_qc_case
-- ----------------------------
DROP TABLE IF EXISTS `t_qc_case`;
CREATE TABLE `t_qc_case` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水编号',
  `ggzt` varchar(100) DEFAULT NULL COMMENT '更改状态',
  `zs` varchar(1000) DEFAULT NULL COMMENT '注释',
  `cjrq` timestamp NULL DEFAULT NULL COMMENT '创建日期',
  `ylms` varchar(5000) DEFAULT NULL COMMENT '用例描述',
  `sjz` varchar(50) DEFAULT NULL COMMENT '设计者',
  `gjkfsj` timestamp NULL DEFAULT NULL COMMENT '估计开发时间',
  `zxzt` varchar(20) DEFAULT NULL COMMENT '执行状态',
  `xgsj` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `lj` varchar(1000) DEFAULT NULL COMMENT '路径',
  `sjzt` varchar(50) DEFAULT NULL COMMENT '数据状态',
  `zt` varchar(500) DEFAULT NULL COMMENT '主题',
  `mb` varchar(10) DEFAULT NULL COMMENT '模板',
  `csid` varchar(100) DEFAULT NULL COMMENT '测试ID',
  `csmc` varchar(500) DEFAULT NULL COMMENT '用例名称',
  `lx` varchar(50) DEFAULT NULL COMMENT '类型',
  `csms` varchar(100) DEFAULT NULL COMMENT '测试模式',
  `cssj` varchar(1000) DEFAULT NULL COMMENT '测试数据',
  `csylbh` varchar(500) DEFAULT NULL COMMENT '测试用例编号',
  `csylzt` varchar(50) DEFAULT NULL COMMENT '测试用例状态',
  `gzms` varchar(100) DEFAULT NULL COMMENT '工作模式',
  `qztj` varchar(500) DEFAULT NULL COMMENT '前置条件',
  `sjdglxt` varchar(100) DEFAULT NULL COMMENT '涉及的关联系统',
  `syzt` varchar(50) DEFAULT NULL COMMENT '审阅状态',
  `sszxt` varchar(100) DEFAULT NULL COMMENT '所属子系统',
  `xylx` varchar(50) DEFAULT NULL COMMENT '协议类型',
  `ylfyzt` varchar(50) DEFAULT NULL COMMENT '用例复用状态',
  `ylxz` varchar(20) DEFAULT NULL COMMENT '用例性质',
  `yxj` varchar(50) DEFAULT NULL COMMENT '优先级',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否显示 1：是；0：否',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8 COMMENT='用例管理表';

-- ----------------------------
-- Table structure for t_qc_defect
-- ----------------------------
DROP TABLE IF EXISTS `t_qc_defect`;
CREATE TABLE `t_qc_defect` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水编号',
  `zs` varchar(1000) DEFAULT NULL COMMENT '注释',
  `zt` varchar(500) DEFAULT NULL COMMENT '主题',
  `bt` varchar(500) DEFAULT NULL COMMENT '标题',
  `csjd` varchar(100) DEFAULT NULL COMMENT '测试阶段',
  `fxr` varchar(50) DEFAULT NULL COMMENT '发现人',
  `fxrq` timestamp NULL DEFAULT NULL COMMENT '发现日期',
  `fpg` varchar(100) DEFAULT NULL COMMENT '分配给',
  `gjxfsj` timestamp NULL DEFAULT NULL COMMENT '估计修复时间',
  `gbrq` timestamp NULL DEFAULT NULL COMMENT '关闭日期',
  `gbybb` varchar(50) DEFAULT NULL COMMENT '关闭于版本',
  `jhgbbb` varchar(50) DEFAULT NULL COMMENT '计划关闭版本',
  `jhxfrq` timestamp NULL DEFAULT NULL COMMENT '计划修复日期',
  `jcybb` varchar(50) DEFAULT NULL COMMENT '检测于版本',
  `jcyfb` varchar(50) DEFAULT NULL COMMENT '检测于发布',
  `jcyzq` varchar(50) DEFAULT NULL COMMENT '检测于周期',
  `kcx` varchar(10) DEFAULT NULL COMMENT '可重现',
  `ms` varchar(5000) DEFAULT NULL COMMENT '描述',
  `mbfb` varchar(50) DEFAULT NULL COMMENT '目标发布',
  `mbzq` varchar(50) DEFAULT NULL COMMENT '目标周期',
  `qxhjjly` varchar(2000) DEFAULT NULL COMMENT '取消或拒绝理由',
  `qxid` varchar(100) DEFAULT NULL COMMENT '缺陷ID',
  `qxlb` varchar(50) DEFAULT NULL COMMENT '缺陷类别',
  `qxzt` varchar(50) DEFAULT NULL COMMENT '缺陷状态',
  `sjxfsj` timestamp NULL DEFAULT NULL COMMENT '实际修复时间',
  `xm` varchar(50) DEFAULT NULL COMMENT '项目',
  `xgrq` timestamp NULL DEFAULT NULL COMMENT '修改日期',
  `yzd` varchar(100) DEFAULT NULL COMMENT '严重度',
  `yxj` varchar(50) DEFAULT NULL COMMENT '优先级',
  `sjzt` varchar(50) DEFAULT NULL COMMENT '数据状态',
  `ylid` varchar(50) DEFAULT NULL COMMENT '关联用例ID',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否显示 1：是；0：否',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='缺陷管理表';

-- ----------------------------
-- Table structure for t_role_node
-- ----------------------------
DROP TABLE IF EXISTS `t_role_node`;
CREATE TABLE `t_role_node` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水编号',
  `roleId` bigint(20) NOT NULL COMMENT '角色编号',
  `nodeId` bigint(20) NOT NULL COMMENT '节点编号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_role_node` (`roleId`,`nodeId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=408 DEFAULT CHARSET=utf8 COMMENT='角色节点关联表';

-- ----------------------------
-- Table structure for t_role_user
-- ----------------------------
DROP TABLE IF EXISTS `t_role_user`;
CREATE TABLE `t_role_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水编号',
  `roleId` bigint(20) NOT NULL COMMENT '角色编号',
  `userId` bigint(20) NOT NULL COMMENT '用户编号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_role_user` (`roleId`,`userId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COMMENT='角色用户关系表';

-- ----------------------------
-- Table structure for t_server_info
-- ----------------------------
DROP TABLE IF EXISTS `t_server_info`;
CREATE TABLE `t_server_info` (
  `id` varchar(50) NOT NULL COMMENT '服务器MAC地址',
  `bar_id` varchar(50) NOT NULL COMMENT '网吧ID',
  `ip` varchar(50) NOT NULL COMMENT '服务器IP地址',
  `pc_name` varchar(50) NOT NULL COMMENT '服务器名称',
  `os_type` int(11) NOT NULL COMMENT '服务器操作系统类型',
  `os_version` varchar(50) NOT NULL COMMENT '服务器操作系统版本',
  `wenhua_ver` varchar(50) NOT NULL COMMENT '文化客户端把那本',
  `creator` varchar(50) NOT NULL COMMENT '创建者',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='服务器信息表';

-- ----------------------------
-- Table structure for t_stat_area
-- ----------------------------
DROP TABLE IF EXISTS `t_stat_area`;
CREATE TABLE `t_stat_area` (
  `area_code` varchar(6) NOT NULL COMMENT '区域代码',
  `stat_date` date NOT NULL COMMENT '统计日期',
  `online` int(11) NOT NULL COMMENT '最大网吧在线数量',
  `offline` int(11) NOT NULL COMMENT '最大网吧离线数量',
  `login` int(11) NOT NULL COMMENT '最大网吧用户数',
  `rankno` char(1) NOT NULL COMMENT '地区类别 1省2市3区',
  PRIMARY KEY (`area_code`,`stat_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='区域统计历史信息';

-- ----------------------------
-- Table structure for t_stat_net_bar
-- ----------------------------
DROP TABLE IF EXISTS `t_stat_net_bar`;
CREATE TABLE `t_stat_net_bar` (
  `bar_id` varchar(10) NOT NULL COMMENT '网吧注册号',
  `stat_date` date NOT NULL COMMENT ' 统计日期',
  `online` int(11) NOT NULL COMMENT '最大在线终端数',
  `offline` int(11) NOT NULL COMMENT '最小离线终端数',
  `valid` int(11) NOT NULL COMMENT '最大有效终端数',
  `login` int(11) NOT NULL COMMENT '最大登录用户数',
  `area_code` varchar(6) NOT NULL COMMENT '县代码',
  `city_code` varchar(6) NOT NULL COMMENT '市代码',
  PRIMARY KEY (`bar_id`,`stat_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网吧日统计信息';

-- ----------------------------
-- Table structure for t_sys_code
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_code`;
CREATE TABLE `t_sys_code` (
  `classify_code` varchar(10) NOT NULL COMMENT '分类代码',
  `classify_name` varchar(50) DEFAULT NULL COMMENT '分类名称',
  `code` int(11) NOT NULL COMMENT '代码',
  `code_name` varchar(50) DEFAULT NULL COMMENT '代码名称',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '代码状态 1：启用；0：禁用',
  PRIMARY KEY (`classify_code`,`code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='通用代码表';

-- ----------------------------
-- Table structure for t_sys_group
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_group`;
CREATE TABLE `t_sys_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门编号',
  `name` varchar(100) NOT NULL COMMENT '部门名称',
  `alias` varchar(200) DEFAULT NULL COMMENT '部门别名',
  `level` int(11) NOT NULL DEFAULT '1' COMMENT '部门级别',
  `parentId` bigint(20) NOT NULL COMMENT '父级部门编号',
  `sort` int(11) DEFAULT '10' COMMENT '显示顺序',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '部门状态 1：启用；0：禁用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='系统部门表';

-- ----------------------------
-- Table structure for t_sys_node
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_node`;
CREATE TABLE `t_sys_node` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '节点编号',
  `name` varchar(100) NOT NULL COMMENT '节点名称',
  `level` int(11) NOT NULL DEFAULT '1' COMMENT '节点级别',
  `parentId` bigint(20) NOT NULL COMMENT '父级节点编号',
  `type` int(11) NOT NULL DEFAULT '1' COMMENT '类型 1：菜单；2：选项卡；3：按钮',
  `permission` varchar(50) DEFAULT NULL COMMENT '权限标识符',
  `alias` varchar(200) DEFAULT NULL COMMENT '节点别名',
  `sort` int(11) DEFAULT '10' COMMENT '显示顺序',
  `url` varchar(200) DEFAULT NULL COMMENT '节点链接Url',
  `icon` varchar(20) DEFAULT NULL COMMENT '一级节点图标样式',
  `wxNode` tinyint(1) NOT NULL DEFAULT '0' COMMENT '微信菜单标识 1：是；0：否',
  `wxUrl` varchar(200) DEFAULT NULL COMMENT '微信菜单URL',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '节点状态 1：启用；0：禁用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='系统节点表';

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `role` varchar(50) DEFAULT NULL COMMENT '角色标识符',
  `description` varchar(500) DEFAULT NULL COMMENT '角色描述',
  `groupId` bigint(20) DEFAULT NULL COMMENT '部门编号',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '角色状态 1：启用 0：禁用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(100) CHARACTER SET gbk NOT NULL COMMENT '用户名称',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `login` varchar(100) NOT NULL COMMENT '登录账号',
  `password` varchar(100) NOT NULL COMMENT '访问密码',
  `sex` int(1) DEFAULT '0' COMMENT '用户性别 1：男；2：女；0：未知',
  `photos` varchar(200) DEFAULT NULL COMMENT '用户头像',
  `birthday` varchar(10) DEFAULT NULL COMMENT '出生年月',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱地址',
  `openId` varchar(200) DEFAULT NULL COMMENT '微信openId',
  `groupId` bigint(20) DEFAULT NULL COMMENT '所属部门',
  `job` varchar(20) DEFAULT NULL COMMENT '职位',
  `duty` varchar(500) DEFAULT NULL COMMENT '主要职责',
  `salt` varchar(10) DEFAULT NULL COMMENT '盐值',
  `isAdmin` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否管理员',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '用户状态 1：启用；0：禁用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Table structure for t_user_area
-- ----------------------------
DROP TABLE IF EXISTS `t_user_area`;
CREATE TABLE `t_user_area` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `userId` bigint(11) DEFAULT NULL,
  `areaCode` varchar(50) DEFAULT NULL,
  `districtCode` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3992 DEFAULT CHARSET=utf8;
