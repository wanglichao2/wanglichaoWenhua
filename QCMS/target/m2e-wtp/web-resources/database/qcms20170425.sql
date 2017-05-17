/*
Navicat MySQL Data Transfer

Source Server         : wh
Source Server Version : 50634
Source Host           : localhost:3306
Source Database       : qcms

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2017-04-25 23:09:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_areas_code`
-- ----------------------------
DROP TABLE IF EXISTS `t_areas_code`;
CREATE TABLE `t_areas_code` (
  `areasid` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '',
  `areasname` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `rankno` char(1) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`areasid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_areas_code
-- ----------------------------
INSERT INTO `t_areas_code` VALUES ('410000', '河南省', '1');
INSERT INTO `t_areas_code` VALUES ('410100', '郑州市', '2');
INSERT INTO `t_areas_code` VALUES ('410101', '市辖区', '3');
INSERT INTO `t_areas_code` VALUES ('410102', '中原区', '3');
INSERT INTO `t_areas_code` VALUES ('410103', '二七区', '3');
INSERT INTO `t_areas_code` VALUES ('410104', '管城回族区', '3');
INSERT INTO `t_areas_code` VALUES ('410105', '金水区', '3');
INSERT INTO `t_areas_code` VALUES ('410106', '上街区', '3');
INSERT INTO `t_areas_code` VALUES ('410108', '惠济区', '3');
INSERT INTO `t_areas_code` VALUES ('410122', '中牟县', '3');
INSERT INTO `t_areas_code` VALUES ('410181', '巩义市', '3');
INSERT INTO `t_areas_code` VALUES ('410182', '荥阳市', '3');
INSERT INTO `t_areas_code` VALUES ('410183', '新密市', '3');
INSERT INTO `t_areas_code` VALUES ('410184', '新郑市', '3');
INSERT INTO `t_areas_code` VALUES ('410185', '登封市', '3');
INSERT INTO `t_areas_code` VALUES ('410200', '开封市', '2');
INSERT INTO `t_areas_code` VALUES ('410201', '市辖区', '3');
INSERT INTO `t_areas_code` VALUES ('410202', '龙亭区', '3');
INSERT INTO `t_areas_code` VALUES ('410203', '顺河回族区', '3');
INSERT INTO `t_areas_code` VALUES ('410204', '鼓楼区', '3');
INSERT INTO `t_areas_code` VALUES ('410205', '禹王台区', '3');
INSERT INTO `t_areas_code` VALUES ('410211', '金明区', '3');
INSERT INTO `t_areas_code` VALUES ('410221', '杞县', '3');
INSERT INTO `t_areas_code` VALUES ('410222', '通许县', '3');
INSERT INTO `t_areas_code` VALUES ('410223', '尉氏县', '3');
INSERT INTO `t_areas_code` VALUES ('410224', '开封县', '3');
INSERT INTO `t_areas_code` VALUES ('410225', '兰考县', '3');
INSERT INTO `t_areas_code` VALUES ('410300', '洛阳市', '2');
INSERT INTO `t_areas_code` VALUES ('410301', '市辖区', '3');
INSERT INTO `t_areas_code` VALUES ('410302', '老城区', '3');
INSERT INTO `t_areas_code` VALUES ('410303', '西工区', '3');
INSERT INTO `t_areas_code` VALUES ('410304', '瀍河回族区', '3');
INSERT INTO `t_areas_code` VALUES ('410305', '涧西区', '3');
INSERT INTO `t_areas_code` VALUES ('410306', '吉利区', '3');
INSERT INTO `t_areas_code` VALUES ('410311', '洛龙区', '3');
INSERT INTO `t_areas_code` VALUES ('410322', '孟津县', '3');
INSERT INTO `t_areas_code` VALUES ('410323', '新安县', '3');
INSERT INTO `t_areas_code` VALUES ('410324', '栾川县', '3');
INSERT INTO `t_areas_code` VALUES ('410325', '嵩县', '3');
INSERT INTO `t_areas_code` VALUES ('410326', '汝阳县', '3');
INSERT INTO `t_areas_code` VALUES ('410327', '宜阳县', '3');
INSERT INTO `t_areas_code` VALUES ('410328', '洛宁县', '3');
INSERT INTO `t_areas_code` VALUES ('410329', '伊川县', '3');
INSERT INTO `t_areas_code` VALUES ('410381', '偃师市', '3');
INSERT INTO `t_areas_code` VALUES ('410400', '平顶山市', '2');
INSERT INTO `t_areas_code` VALUES ('410401', '市辖区', '3');
INSERT INTO `t_areas_code` VALUES ('410402', '新华区', '3');
INSERT INTO `t_areas_code` VALUES ('410403', '卫东区', '3');
INSERT INTO `t_areas_code` VALUES ('410404', '石龙区', '3');
INSERT INTO `t_areas_code` VALUES ('410411', '湛河区', '3');
INSERT INTO `t_areas_code` VALUES ('410421', '宝丰县', '3');
INSERT INTO `t_areas_code` VALUES ('410422', '叶县', '3');
INSERT INTO `t_areas_code` VALUES ('410423', '鲁山县', '3');
INSERT INTO `t_areas_code` VALUES ('410425', '郏县', '3');
INSERT INTO `t_areas_code` VALUES ('410481', '舞钢市', '3');
INSERT INTO `t_areas_code` VALUES ('410482', '汝州市', '3');
INSERT INTO `t_areas_code` VALUES ('410500', '安阳市', '2');
INSERT INTO `t_areas_code` VALUES ('410501', '市辖区', '3');
INSERT INTO `t_areas_code` VALUES ('410502', '文峰区', '3');
INSERT INTO `t_areas_code` VALUES ('410503', '北关区', '3');
INSERT INTO `t_areas_code` VALUES ('410505', '殷都区', '3');
INSERT INTO `t_areas_code` VALUES ('410506', '龙安区', '3');
INSERT INTO `t_areas_code` VALUES ('410522', '安阳县', '3');
INSERT INTO `t_areas_code` VALUES ('410523', '汤阴县', '3');
INSERT INTO `t_areas_code` VALUES ('410526', '滑县', '3');
INSERT INTO `t_areas_code` VALUES ('410527', '内黄县', '3');
INSERT INTO `t_areas_code` VALUES ('410581', '林州市', '3');
INSERT INTO `t_areas_code` VALUES ('410600', '鹤壁市', '2');
INSERT INTO `t_areas_code` VALUES ('410601', '市辖区', '3');
INSERT INTO `t_areas_code` VALUES ('410602', '鹤山区', '3');
INSERT INTO `t_areas_code` VALUES ('410603', '山城区', '3');
INSERT INTO `t_areas_code` VALUES ('410611', '淇滨区', '3');
INSERT INTO `t_areas_code` VALUES ('410621', '浚县', '3');
INSERT INTO `t_areas_code` VALUES ('410622', '淇县', '3');
INSERT INTO `t_areas_code` VALUES ('410700', '新乡市', '2');
INSERT INTO `t_areas_code` VALUES ('410701', '市辖区', '3');
INSERT INTO `t_areas_code` VALUES ('410702', '红旗区', '3');
INSERT INTO `t_areas_code` VALUES ('410703', '卫滨区', '3');
INSERT INTO `t_areas_code` VALUES ('410704', '凤泉区', '3');
INSERT INTO `t_areas_code` VALUES ('410711', '牧野区', '3');
INSERT INTO `t_areas_code` VALUES ('410721', '新乡县', '3');
INSERT INTO `t_areas_code` VALUES ('410724', '获嘉县', '3');
INSERT INTO `t_areas_code` VALUES ('410725', '原阳县', '3');
INSERT INTO `t_areas_code` VALUES ('410726', '延津县', '3');
INSERT INTO `t_areas_code` VALUES ('410727', '封丘县', '3');
INSERT INTO `t_areas_code` VALUES ('410728', '长垣县', '3');
INSERT INTO `t_areas_code` VALUES ('410781', '卫辉市', '3');
INSERT INTO `t_areas_code` VALUES ('410782', '辉县市', '3');
INSERT INTO `t_areas_code` VALUES ('410800', '焦作市', '2');
INSERT INTO `t_areas_code` VALUES ('410801', '市辖区', '3');
INSERT INTO `t_areas_code` VALUES ('410802', '解放区', '3');
INSERT INTO `t_areas_code` VALUES ('410803', '中站区', '3');
INSERT INTO `t_areas_code` VALUES ('410804', '马村区', '3');
INSERT INTO `t_areas_code` VALUES ('410811', '山阳区', '3');
INSERT INTO `t_areas_code` VALUES ('410821', '修武县', '3');
INSERT INTO `t_areas_code` VALUES ('410822', '博爱县', '3');
INSERT INTO `t_areas_code` VALUES ('410823', '武陟县', '3');
INSERT INTO `t_areas_code` VALUES ('410825', '温县', '3');
INSERT INTO `t_areas_code` VALUES ('410882', '沁阳市', '3');
INSERT INTO `t_areas_code` VALUES ('410883', '孟州市', '3');
INSERT INTO `t_areas_code` VALUES ('410900', '濮阳市', '2');
INSERT INTO `t_areas_code` VALUES ('410901', '市辖区', '3');
INSERT INTO `t_areas_code` VALUES ('410902', '华龙区', '3');
INSERT INTO `t_areas_code` VALUES ('410922', '清丰县', '3');
INSERT INTO `t_areas_code` VALUES ('410923', '南乐县', '3');
INSERT INTO `t_areas_code` VALUES ('410926', '范县', '3');
INSERT INTO `t_areas_code` VALUES ('410927', '台前县', '3');
INSERT INTO `t_areas_code` VALUES ('410928', '濮阳县', '3');
INSERT INTO `t_areas_code` VALUES ('411000', '许昌市', '2');
INSERT INTO `t_areas_code` VALUES ('411001', '市辖区', '3');
INSERT INTO `t_areas_code` VALUES ('411002', '魏都区', '3');
INSERT INTO `t_areas_code` VALUES ('411023', '许昌县', '3');
INSERT INTO `t_areas_code` VALUES ('411024', '鄢陵县', '3');
INSERT INTO `t_areas_code` VALUES ('411025', '襄城县', '3');
INSERT INTO `t_areas_code` VALUES ('411081', '禹州市', '3');
INSERT INTO `t_areas_code` VALUES ('411082', '长葛市', '3');
INSERT INTO `t_areas_code` VALUES ('411100', '漯河市', '2');
INSERT INTO `t_areas_code` VALUES ('411101', '市辖区', '3');
INSERT INTO `t_areas_code` VALUES ('411102', '源汇区', '3');
INSERT INTO `t_areas_code` VALUES ('411103', '郾城区', '3');
INSERT INTO `t_areas_code` VALUES ('411104', '召陵区', '3');
INSERT INTO `t_areas_code` VALUES ('411121', '舞阳县', '3');
INSERT INTO `t_areas_code` VALUES ('411122', '临颍县', '3');
INSERT INTO `t_areas_code` VALUES ('411200', '三门峡市', '2');
INSERT INTO `t_areas_code` VALUES ('411201', '市辖区', '3');
INSERT INTO `t_areas_code` VALUES ('411202', '湖滨区', '3');
INSERT INTO `t_areas_code` VALUES ('411221', '渑池县', '3');
INSERT INTO `t_areas_code` VALUES ('411222', '陕县', '3');
INSERT INTO `t_areas_code` VALUES ('411224', '卢氏县', '3');
INSERT INTO `t_areas_code` VALUES ('411281', '义马市', '3');
INSERT INTO `t_areas_code` VALUES ('411282', '灵宝市', '3');
INSERT INTO `t_areas_code` VALUES ('411300', '南阳市', '2');
INSERT INTO `t_areas_code` VALUES ('411301', '市辖区', '3');
INSERT INTO `t_areas_code` VALUES ('411302', '宛城区', '3');
INSERT INTO `t_areas_code` VALUES ('411303', '卧龙区', '3');
INSERT INTO `t_areas_code` VALUES ('411321', '南召县', '3');
INSERT INTO `t_areas_code` VALUES ('411322', '方城县', '3');
INSERT INTO `t_areas_code` VALUES ('411323', '西峡县', '3');
INSERT INTO `t_areas_code` VALUES ('411324', '镇平县', '3');
INSERT INTO `t_areas_code` VALUES ('411325', '内乡县', '3');
INSERT INTO `t_areas_code` VALUES ('411326', '淅川县', '3');
INSERT INTO `t_areas_code` VALUES ('411327', '社旗县', '3');
INSERT INTO `t_areas_code` VALUES ('411328', '唐河县', '3');
INSERT INTO `t_areas_code` VALUES ('411329', '新野县', '3');
INSERT INTO `t_areas_code` VALUES ('411330', '桐柏县', '3');
INSERT INTO `t_areas_code` VALUES ('411381', '邓州市', '3');
INSERT INTO `t_areas_code` VALUES ('411400', '商丘市', '2');
INSERT INTO `t_areas_code` VALUES ('411401', '市辖区', '3');
INSERT INTO `t_areas_code` VALUES ('411402', '梁园区', '3');
INSERT INTO `t_areas_code` VALUES ('411403', '睢阳区', '3');
INSERT INTO `t_areas_code` VALUES ('411421', '民权县', '3');
INSERT INTO `t_areas_code` VALUES ('411422', '睢县', '3');
INSERT INTO `t_areas_code` VALUES ('411423', '宁陵县', '3');
INSERT INTO `t_areas_code` VALUES ('411424', '柘城县', '3');
INSERT INTO `t_areas_code` VALUES ('411425', '虞城县', '3');
INSERT INTO `t_areas_code` VALUES ('411426', '夏邑县', '3');
INSERT INTO `t_areas_code` VALUES ('411481', '永城市', '3');
INSERT INTO `t_areas_code` VALUES ('411500', '信阳市', '2');
INSERT INTO `t_areas_code` VALUES ('411501', '市辖区', '3');
INSERT INTO `t_areas_code` VALUES ('411502', '浉河区', '3');
INSERT INTO `t_areas_code` VALUES ('411503', '平桥区', '3');
INSERT INTO `t_areas_code` VALUES ('411521', '罗山县', '3');
INSERT INTO `t_areas_code` VALUES ('411522', '光山县', '3');
INSERT INTO `t_areas_code` VALUES ('411523', '新县', '3');
INSERT INTO `t_areas_code` VALUES ('411524', '商城县', '3');
INSERT INTO `t_areas_code` VALUES ('411525', '固始县', '3');
INSERT INTO `t_areas_code` VALUES ('411526', '潢川县', '3');
INSERT INTO `t_areas_code` VALUES ('411527', '淮滨县', '3');
INSERT INTO `t_areas_code` VALUES ('411528', '息县', '3');
INSERT INTO `t_areas_code` VALUES ('411600', '周口市', '2');
INSERT INTO `t_areas_code` VALUES ('411601', '市辖区', '3');
INSERT INTO `t_areas_code` VALUES ('411602', '川汇区', '3');
INSERT INTO `t_areas_code` VALUES ('411621', '扶沟县', '3');
INSERT INTO `t_areas_code` VALUES ('411622', '西华县', '3');
INSERT INTO `t_areas_code` VALUES ('411623', '商水县', '3');
INSERT INTO `t_areas_code` VALUES ('411624', '沈丘县', '3');
INSERT INTO `t_areas_code` VALUES ('411625', '郸城县', '3');
INSERT INTO `t_areas_code` VALUES ('411626', '淮阳县', '3');
INSERT INTO `t_areas_code` VALUES ('411627', '太康县', '3');
INSERT INTO `t_areas_code` VALUES ('411628', '鹿邑县', '3');
INSERT INTO `t_areas_code` VALUES ('411681', '项城市', '3');
INSERT INTO `t_areas_code` VALUES ('411700', '驻马店市', '2');
INSERT INTO `t_areas_code` VALUES ('411701', '市辖区', '3');
INSERT INTO `t_areas_code` VALUES ('411702', '驿城区', '3');
INSERT INTO `t_areas_code` VALUES ('411721', '西平县', '3');
INSERT INTO `t_areas_code` VALUES ('411722', '上蔡县', '3');
INSERT INTO `t_areas_code` VALUES ('411723', '平舆县', '3');
INSERT INTO `t_areas_code` VALUES ('411724', '正阳县', '3');
INSERT INTO `t_areas_code` VALUES ('411725', '确山县', '3');
INSERT INTO `t_areas_code` VALUES ('411726', '泌阳县', '3');
INSERT INTO `t_areas_code` VALUES ('411727', '汝南县', '3');
INSERT INTO `t_areas_code` VALUES ('411728', '遂平县', '3');
INSERT INTO `t_areas_code` VALUES ('411729', '新蔡县', '3');
INSERT INTO `t_areas_code` VALUES ('419000', '省直辖县级行政区划', '2');
INSERT INTO `t_areas_code` VALUES ('419001', '济源市', '3');

-- ----------------------------
-- Table structure for `t_net_bar`
-- ----------------------------
DROP TABLE IF EXISTS `t_net_bar`;
CREATE TABLE `t_net_bar` (
	`id` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '网吧注册号（barId）主键',
	`net_bar_name` VARCHAR(100) NULL DEFAULT NULL COMMENT '网吧名称',
	`business_reg_no` VARCHAR(10) NOT NULL COMMENT '工商注册号（唯一）',
	`city_code` VARCHAR(6) NULL DEFAULT NULL COMMENT '市代码',
	`area_code` VARCHAR(6) NULL DEFAULT NULL COMMENT '区代码',
	`server_version` VARCHAR(50) NULL DEFAULT NULL COMMENT '服务端版本',
	`client_version` VARCHAR(50) NULL DEFAULT NULL COMMENT '客户端版本',
	`address_name` VARCHAR(100) NULL DEFAULT NULL COMMENT '网吧地址名称',
	`contact_name` VARCHAR(50) NULL DEFAULT NULL COMMENT '联系人姓名',
	`contact_tel` VARCHAR(20) NULL DEFAULT NULL COMMENT '联系人手机号',
	`client_total` INT(10) NULL DEFAULT NULL COMMENT '客户机总数',
	`outside_network` VARCHAR(50) NULL DEFAULT NULL COMMENT '外网地址',
	`inside_network` VARCHAR(50) NULL DEFAULT NULL COMMENT '内网地址',
	`server_mac` VARCHAR(50) NULL DEFAULT NULL COMMENT '服务器mac地址',
	`creator` VARCHAR(20) NULL DEFAULT NULL,
	`create_time` TIMESTAMP NULL DEFAULT NULL,
	`status` INT(1) NOT NULL DEFAULT '1' COMMENT '1：有效；0：无效',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `business_reg_no` (`business_reg_no`) USING BTREE
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

-- ----------------------------
-- Records of t_net_bar
-- ----------------------------
INSERT INTO `t_net_bar` VALUES ('4101020001', '中原区网吧', '12345678', '410100 410102', '郑州市 中原区', '张三', '12345678911', '200', null, '127.0.0.1', '127.0.0.1', null, null, '1');
INSERT INTO `t_net_bar` VALUES ('4116220001', '开封市网吧', '123456', '411600 411622', '周口市  西华县', '张三', '12345678911', '200', null, '127.0.0.1', '127.0.0.1', '1', '2017-04-23 11:21:13', '1');
INSERT INTO `t_net_bar` VALUES ('4116220002', '西华县网吧', '1234561212', '411600 411622', '周口市  西华县', '张三', '12345678911', '200', null, '127.0.0.1', '127.0.0.1', null, null, '1');

-- ----------------------------
-- Table structure for `t_qc_case`
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
-- Records of t_qc_case
-- ----------------------------
INSERT INTO `t_qc_case` VALUES ('44', '---', null, '2016-10-24 00:00:00', '钱箱透支，不触发其他授权点钱箱透支', 'xujun1', null, 'Passed', '2016-11-02 10:33:04', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，不触发其他授权点', 'MANUAL', '---', null, '钱箱透支1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-16 15:50:59');
INSERT INTO `t_qc_case` VALUES ('45', '---', null, '2016-10-24 00:00:00', '钱箱透支，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:33:05', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，触发其他授权点', 'MANUAL', '---', null, '钱箱透支2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-16 15:50:59');
INSERT INTO `t_qc_case` VALUES ('46', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，不触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，不触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-16 15:50:59');
INSERT INTO `t_qc_case` VALUES ('47', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-16 15:50:59');
INSERT INTO `t_qc_case` VALUES ('48', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式正确', 'MANUAL', '---', null, '远程集中授权机构权限增加1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-16 15:50:59');
INSERT INTO `t_qc_case` VALUES ('49', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式不正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式不正确', 'MANUAL', '---', null, '远程集中授权机构权限增加2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '反用例', '1-高', '0', '2017-02-16 15:50:59');
INSERT INTO `t_qc_case` VALUES ('50', '---', null, '2016-10-24 00:00:00', '钱箱透支，不触发其他授权点钱箱透支', 'xujun1', null, 'Passed', '2016-11-02 10:33:04', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，不触发其他授权点', 'MANUAL', '---', null, '钱箱透支1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-16 16:29:15');
INSERT INTO `t_qc_case` VALUES ('51', '---', null, '2016-10-24 00:00:00', '钱箱透支，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:33:05', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，触发其他授权点', 'MANUAL', '---', null, '钱箱透支2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-16 16:29:15');
INSERT INTO `t_qc_case` VALUES ('52', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，不触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，不触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-16 16:29:15');
INSERT INTO `t_qc_case` VALUES ('53', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-16 16:29:15');
INSERT INTO `t_qc_case` VALUES ('54', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式正确', 'MANUAL', '---', null, '远程集中授权机构权限增加1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-16 16:29:15');
INSERT INTO `t_qc_case` VALUES ('55', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式不正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式不正确', 'MANUAL', '---', null, '远程集中授权机构权限增加2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '反用例', '1-高', '0', '2017-02-16 16:29:15');
INSERT INTO `t_qc_case` VALUES ('56', '---', null, '2016-10-24 00:00:00', '钱箱透支，不触发其他授权点钱箱透支', 'xujun1', null, 'Passed', '2016-11-02 10:33:04', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，不触发其他授权点', 'MANUAL', '---', null, '钱箱透支1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-16 16:30:01');
INSERT INTO `t_qc_case` VALUES ('57', '---', null, '2016-10-24 00:00:00', '钱箱透支，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:33:05', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，触发其他授权点', 'MANUAL', '---', null, '钱箱透支2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-16 16:30:01');
INSERT INTO `t_qc_case` VALUES ('58', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，不触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，不触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-16 16:30:01');
INSERT INTO `t_qc_case` VALUES ('59', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-16 16:30:01');
INSERT INTO `t_qc_case` VALUES ('60', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式正确', 'MANUAL', '---', null, '远程集中授权机构权限增加1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-16 16:30:01');
INSERT INTO `t_qc_case` VALUES ('61', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式不正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式不正确', 'MANUAL', '---', null, '远程集中授权机构权限增加2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '反用例', '1-高', '0', '2017-02-16 16:30:01');
INSERT INTO `t_qc_case` VALUES ('62', '---', null, '2016-10-24 00:00:00', '钱箱透支，不触发其他授权点钱箱透支', 'xujun1', null, 'Passed', '2016-11-02 10:33:04', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，不触发其他授权点', 'MANUAL', '---', null, '钱箱透支1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-16 16:31:37');
INSERT INTO `t_qc_case` VALUES ('63', '---', null, '2016-10-24 00:00:00', '钱箱透支，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:33:05', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，触发其他授权点', 'MANUAL', '---', null, '钱箱透支2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-16 16:31:37');
INSERT INTO `t_qc_case` VALUES ('64', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，不触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，不触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-16 16:31:37');
INSERT INTO `t_qc_case` VALUES ('65', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-16 16:31:37');
INSERT INTO `t_qc_case` VALUES ('66', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式正确', 'MANUAL', '---', null, '远程集中授权机构权限增加1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-16 16:31:37');
INSERT INTO `t_qc_case` VALUES ('67', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式不正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式不正确', 'MANUAL', '---', null, '远程集中授权机构权限增加2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '反用例', '1-高', '0', '2017-02-16 16:31:37');
INSERT INTO `t_qc_case` VALUES ('68', '', '', null, 'dddd', 'ddd', null, '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0', '2017-02-16 16:33:16');
INSERT INTO `t_qc_case` VALUES ('69', '', '', '2017-02-16 00:00:00', 'sdfsf', 'sdff', '2017-02-16 21:02:00', '', '2017-02-16 21:02:00', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0', '2017-02-16 21:50:33');
INSERT INTO `t_qc_case` VALUES ('70', '---', null, '2016-10-24 00:00:00', '钱箱透支，不触发其他授权点钱箱透支', 'xujun1', null, 'Passed', '2016-11-02 10:33:04', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，不触发其他授权点', 'MANUAL', '---', null, '钱箱透支1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-16 21:54:37');
INSERT INTO `t_qc_case` VALUES ('71', '---', null, '2016-10-24 00:00:00', '钱箱透支，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:33:05', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，触发其他授权点', 'MANUAL', '---', null, '钱箱透支2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-16 21:54:37');
INSERT INTO `t_qc_case` VALUES ('72', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，不触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，不触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-16 21:54:37');
INSERT INTO `t_qc_case` VALUES ('73', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-16 21:54:37');
INSERT INTO `t_qc_case` VALUES ('74', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式正确', 'MANUAL', '---', null, '远程集中授权机构权限增加1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-16 21:54:37');
INSERT INTO `t_qc_case` VALUES ('75', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式不正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式不正确', 'MANUAL', '---', null, '远程集中授权机构权限增加2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '反用例', '1-高', '0', '2017-02-16 21:54:37');
INSERT INTO `t_qc_case` VALUES ('76', '', '', '2017-02-16 00:00:00', 'gggg', 'hhhh', '2017-02-17 19:50:00', '', '2017-02-16 19:45:00', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0', '2017-02-16 22:02:36');
INSERT INTO `t_qc_case` VALUES ('77', '---', null, '2016-10-24 00:00:00', '钱箱透支，不触发其他授权点钱箱透支', 'xujun1', null, 'Passed', '2016-11-02 10:33:04', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，不触发其他授权点', 'MANUAL', '---', null, '钱箱透支1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-17 13:35:19');
INSERT INTO `t_qc_case` VALUES ('78', '---', null, '2016-10-24 00:00:00', '钱箱透支，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:33:05', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，触发其他授权点', 'MANUAL', '---', null, '钱箱透支2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-17 13:35:19');
INSERT INTO `t_qc_case` VALUES ('79', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，不触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，不触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-17 13:35:19');
INSERT INTO `t_qc_case` VALUES ('80', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-17 13:35:19');
INSERT INTO `t_qc_case` VALUES ('81', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式正确', 'MANUAL', '---', null, '远程集中授权机构权限增加1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-17 13:35:19');
INSERT INTO `t_qc_case` VALUES ('82', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式不正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式不正确', 'MANUAL', '---', null, '远程集中授权机构权限增加2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '反用例', '1-高', '0', '2017-02-17 13:35:19');
INSERT INTO `t_qc_case` VALUES ('83', '---', null, '2016-10-24 00:00:00', '钱箱透支，不触发其他授权点钱箱透支', 'xujun1', null, 'Passed', '2016-11-02 10:33:04', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，不触发其他授权点', 'MANUAL', '---', null, '钱箱透支1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-17 13:35:26');
INSERT INTO `t_qc_case` VALUES ('84', '---', null, '2016-10-24 00:00:00', '钱箱透支，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:33:05', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，触发其他授权点', 'MANUAL', '---', null, '钱箱透支2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-17 13:35:26');
INSERT INTO `t_qc_case` VALUES ('85', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，不触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，不触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-17 13:35:26');
INSERT INTO `t_qc_case` VALUES ('86', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-17 13:35:26');
INSERT INTO `t_qc_case` VALUES ('87', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式正确', 'MANUAL', '---', null, '远程集中授权机构权限增加1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-17 13:35:26');
INSERT INTO `t_qc_case` VALUES ('88', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式不正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式不正确', 'MANUAL', '---', null, '远程集中授权机构权限增加2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '反用例', '1-高', '0', '2017-02-17 13:35:26');
INSERT INTO `t_qc_case` VALUES ('89', '---', null, '2016-10-24 00:00:00', '钱箱透支，不触发其他授权点钱箱透支', 'xujun1', null, 'Passed', '2016-11-02 10:33:04', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，不触发其他授权点', 'MANUAL', '---', null, '钱箱透支1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-17 13:36:28');
INSERT INTO `t_qc_case` VALUES ('90', '---', null, '2016-10-24 00:00:00', '钱箱透支，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:33:05', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，触发其他授权点', 'MANUAL', '---', null, '钱箱透支2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-17 13:36:28');
INSERT INTO `t_qc_case` VALUES ('91', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，不触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，不触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-17 13:36:28');
INSERT INTO `t_qc_case` VALUES ('92', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-17 13:36:28');
INSERT INTO `t_qc_case` VALUES ('93', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式正确', 'MANUAL', '---', null, '远程集中授权机构权限增加1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-17 13:36:28');
INSERT INTO `t_qc_case` VALUES ('94', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式不正确', 'xujun1', '2017-02-17 13:36:00', 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式不正确', 'MANUAL', '---', null, '远程集中授权机构权限增加2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '反用例', '1-高', '0', '2017-02-17 13:36:28');
INSERT INTO `t_qc_case` VALUES ('95', '---', null, '2016-10-24 00:00:00', '钱箱透支，不触发其他授权点钱箱透支', 'xujun1', null, 'Passed', '2016-11-02 10:33:04', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，不触发其他授权点', 'MANUAL', '---', null, '钱箱透支1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-20 17:03:02');
INSERT INTO `t_qc_case` VALUES ('96', '---', null, '2016-10-24 00:00:00', '钱箱透支，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:33:05', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，触发其他授权点', 'MANUAL', '---', null, '钱箱透支2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-20 17:03:02');
INSERT INTO `t_qc_case` VALUES ('97', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，不触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，不触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-20 17:03:02');
INSERT INTO `t_qc_case` VALUES ('98', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-20 17:03:02');
INSERT INTO `t_qc_case` VALUES ('99', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式正确', 'MANUAL', '---', null, '远程集中授权机构权限增加1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-20 17:03:02');
INSERT INTO `t_qc_case` VALUES ('100', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式不正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式不正确', 'MANUAL', '---', null, '远程集中授权机构权限增加2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '反用例', '1-高', '0', '2017-02-20 17:03:02');
INSERT INTO `t_qc_case` VALUES ('101', '---', null, '2016-10-24 00:00:00', '钱箱透支，不触发其他授权点钱箱透支', 'xujun1', null, 'Passed', '2016-11-02 10:33:04', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，不触发其他授权点', 'MANUAL', '---', null, '钱箱透支1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-21 15:27:02');
INSERT INTO `t_qc_case` VALUES ('102', '---', null, '2016-10-24 00:00:00', '钱箱透支，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:33:05', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，触发其他授权点', 'MANUAL', '---', null, '钱箱透支2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-21 15:27:02');
INSERT INTO `t_qc_case` VALUES ('103', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，不触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，不触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-21 15:27:02');
INSERT INTO `t_qc_case` VALUES ('104', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-21 15:27:02');
INSERT INTO `t_qc_case` VALUES ('105', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式正确', 'MANUAL', '---', null, '远程集中授权机构权限增加1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-02-21 15:27:02');
INSERT INTO `t_qc_case` VALUES ('106', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式不正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式不正确', 'MANUAL', '---', null, '远程集中授权机构权限增加2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '反用例', '1-高', '0', '2017-02-21 15:27:02');
INSERT INTO `t_qc_case` VALUES ('107', '---', null, '2016-10-24 00:00:00', '钱箱透支，不触发其他授权点钱箱透支', 'xujun1', null, 'Passed', '2016-11-02 10:33:04', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，不触发其他授权点', 'MANUAL', '---', null, '钱箱透支1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-03-02 15:31:59');
INSERT INTO `t_qc_case` VALUES ('108', '---', null, '2016-10-24 00:00:00', '钱箱透支，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:33:05', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，触发其他授权点', 'MANUAL', '---', null, '钱箱透支2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-03-02 15:31:59');
INSERT INTO `t_qc_case` VALUES ('109', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，不触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，不触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-03-02 15:31:59');
INSERT INTO `t_qc_case` VALUES ('110', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-03-02 15:31:59');
INSERT INTO `t_qc_case` VALUES ('111', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式正确', 'MANUAL', '---', null, '远程集中授权机构权限增加1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-03-02 15:31:59');
INSERT INTO `t_qc_case` VALUES ('112', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式不正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式不正确', 'MANUAL', '---', null, '远程集中授权机构权限增加2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '反用例', '1-高', '0', '2017-03-02 15:31:59');
INSERT INTO `t_qc_case` VALUES ('113', '1', '', '2017-03-06 00:00:00', '1', '1', '2017-03-06 11:52:00', '', null, '', '', '1', '', '1', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '0', '2017-03-06 11:52:03');
INSERT INTO `t_qc_case` VALUES ('114', '---', null, '2016-10-24 00:00:00', '钱箱透支，不触发其他授权点钱箱透支', 'xujun1', null, 'Passed', '2016-11-02 10:33:04', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，不触发其他授权点', 'MANUAL', '---', null, '钱箱透支1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-03-07 09:49:41');
INSERT INTO `t_qc_case` VALUES ('115', '---', null, '2016-10-24 00:00:00', '钱箱透支，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:33:05', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，触发其他授权点', 'MANUAL', '---', null, '钱箱透支2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-03-07 09:49:41');
INSERT INTO `t_qc_case` VALUES ('116', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，不触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，不触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-03-07 09:49:41');
INSERT INTO `t_qc_case` VALUES ('117', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-03-07 09:49:41');
INSERT INTO `t_qc_case` VALUES ('118', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式正确', 'MANUAL', '---', null, '远程集中授权机构权限增加1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-03-07 09:49:41');
INSERT INTO `t_qc_case` VALUES ('119', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式不正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式不正确', 'MANUAL', '---', null, '远程集中授权机构权限增加2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '反用例', '1-高', '0', '2017-03-07 09:49:41');
INSERT INTO `t_qc_case` VALUES ('120', '---', null, '2016-10-24 00:00:00', '钱箱透支，不触发其他授权点钱箱透支', 'xujun1', null, 'Passed', '2016-11-02 10:33:04', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，不触发其他授权点', 'MANUAL', '---', null, '钱箱透支1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-03-07 09:50:31');
INSERT INTO `t_qc_case` VALUES ('121', '---', null, '2016-10-24 00:00:00', '钱箱透支，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:33:05', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，触发其他授权点', 'MANUAL', '---', null, '钱箱透支2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-03-07 09:50:31');
INSERT INTO `t_qc_case` VALUES ('122', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，不触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，不触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-03-07 09:50:31');
INSERT INTO `t_qc_case` VALUES ('123', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-03-07 09:50:31');
INSERT INTO `t_qc_case` VALUES ('124', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式正确', 'MANUAL', '---', null, '远程集中授权机构权限增加1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '0', '2017-03-07 09:50:31');
INSERT INTO `t_qc_case` VALUES ('125', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式不正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式不正确', 'MANUAL', '---', null, '远程集中授权机构权限增加2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '反用例', '1-高', '0', '2017-03-07 09:50:31');
INSERT INTO `t_qc_case` VALUES ('126', '---', null, '2016-10-24 00:00:00', '钱箱透支，不触发其他授权点钱箱透支', 'xujun1', null, 'Passed', '2016-11-02 10:33:04', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，不触发其他授权点', 'MANUAL', '---', null, '钱箱透支1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '1', '2017-03-07 14:43:02');
INSERT INTO `t_qc_case` VALUES ('127', '---', null, '2016-10-24 00:00:00', '钱箱透支，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:33:05', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '钱箱透支，触发其他授权点', 'MANUAL', '---', null, '钱箱透支2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '1', '2017-03-07 14:43:02');
INSERT INTO `t_qc_case` VALUES ('128', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，不触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，不触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '1', '2017-03-07 14:43:02');
INSERT INTO `t_qc_case` VALUES ('129', '---', null, '2016-10-24 00:00:00', '同一证件类型下号码重复，触发其他授权点', 'xujun1', null, 'Passed', '2016-11-02 10:32:42', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '同一证件类型下号码重复，触发其他授权点', 'MANUAL', '---', null, '同一证件类型下号码重复2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '1', '2017-03-07 14:43:02');
INSERT INTO `t_qc_case` VALUES ('130', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式正确', 'MANUAL', '---', null, '远程集中授权机构权限增加1', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '正用例', '1-高', '1', '2017-03-07 14:43:02');
INSERT INTO `t_qc_case` VALUES ('131', '---', null, '2016-10-24 00:00:00', '远程集中授权机构权限增加，文件格式不正确', 'xujun1', null, 'Passed', '2016-11-02 10:33:01', null, null, '关于远程授权涉及新柜面及前后台系统修改的优化需求', null, null, '远程集中授权机构权限增加，文件格式不正确', 'MANUAL', '---', null, '远程集中授权机构权限增加2', '新建', '---', '新柜面正常打开', null, null, null, '---', null, '反用例', '1-高', '1', '2017-03-07 14:43:02');

-- ----------------------------
-- Table structure for `t_qc_defect`
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
-- Records of t_qc_defect
-- ----------------------------
INSERT INTO `t_qc_defect` VALUES ('8', '', '1', '2', '3', '4', '2017-02-16 00:00:00', '4', '2017-02-16 21:02:00', null, '', '', null, '', '', '', '', '', '', '', '', '', '', '', null, '', null, '', '', '', null, '0', '2017-02-16 21:49:05');
INSERT INTO `t_qc_defect` VALUES ('9', null, '关于人民币存款新增NRA标识的需求', '修改字段值,6-NRA账户为6-NRA账户（人民币）', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', null, null, null, null, null, null, null, null, 'Y', '修改字段值,6-NRA账户为6-NRA账户（人民币）', null, null, null, null, '1-系统问题', 'Closed-已关闭', null, null, '2016-11-03 13:58:26', '3-低（较小的问题，改进的建议）', null, '新建', null, '0', '2017-02-16 21:51:48');
INSERT INTO `t_qc_defect` VALUES ('10', null, '关于人民币存款新增NRA标识的需求', '修改字段值,6-NRA账户为6-NRA账户（人民币）', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', null, null, null, null, null, null, null, null, 'Y', '修改字段值,6-NRA账户为6-NRA账户（人民币）', null, null, null, null, '1-系统问题', 'Closed-已关闭', null, null, '2016-11-03 13:58:26', '3-低（较小的问题，改进的建议）', null, '新建', null, '0', '2017-02-16 21:54:47');
INSERT INTO `t_qc_defect` VALUES ('11', null, '关于人民币存款新增NRA标识的需求', '修改字段值,6-NRA账户为6-NRA账户（人民币）', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', null, null, null, null, null, null, null, null, 'Y', '修改字段值,6-NRA账户为6-NRA账户（人民币）', null, null, null, null, '1-系统问题', 'Closed-已关闭', null, null, '2016-11-03 13:58:26', '3-低（较小的问题，改进的建议）', null, '新建', null, '0', '2017-02-16 21:56:27');
INSERT INTO `t_qc_defect` VALUES ('12', null, '关于人民币存款新增NRA标识的需求', '修改字段值,6-NRA账户为6-NRA账户（人民币）', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', null, null, null, null, null, null, null, null, 'Y', '修改字段值,6-NRA账户为6-NRA账户（人民币）', null, null, null, null, '1-系统问题', 'Closed-已关闭', null, null, '2016-11-03 13:58:26', '3-低（较小的问题，改进的建议）', null, '新建', null, '0', '2017-02-16 21:58:26');
INSERT INTO `t_qc_defect` VALUES ('13', null, '关于人民币存款新增NRA标识的需求', '修改字段值,6-NRA账户为6-NRA账户（人民币）', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', null, null, null, null, null, null, null, null, 'Y', '修改字段值,6-NRA账户为6-NRA账户（人民币）', null, null, null, null, '1-系统问题', 'Closed-已关闭', null, null, '2016-11-03 13:58:26', '3-低（较小的问题，改进的建议）', null, '新建', null, '0', '2017-02-16 21:59:37');
INSERT INTO `t_qc_defect` VALUES ('14', '1', '关于人民币存款新增NRA标识的需求', '修改字段值,6-NRA账户为6-NRA账户（人民币）', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', null, null, null, null, null, null, null, null, 'Y', '修改字段值,6-NRA账户为6-NRA账户（人民币）', null, null, null, null, '1-系统问题', 'Closed-已关闭', null, null, '2016-11-03 13:58:26', '3-低（较小的问题，改进的建议）', null, '新建', null, '0', '2017-02-16 22:01:00');
INSERT INTO `t_qc_defect` VALUES ('15', '2', '关于人民币存款新增NRA标识的需求', '110251-协议存款开户无新增字段', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', '2017-02-17 12:29:00', null, null, null, null, null, null, null, 'Y', '110251-协议存款开户无新增字段', null, null, null, null, '1-系统问题', 'Closed-已关闭', null, null, '2016-11-03 14:00:24', '2-中（一般的缺陷）', null, '新建', null, '0', '2017-02-16 22:01:00');
INSERT INTO `t_qc_defect` VALUES ('16', '3', '关于人民币存款新增NRA标识的需求', '110251-协议存款开户中，取消备注字段', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', '2017-02-18 10:55:00', null, null, null, '2017-02-16 22:02:00', null, null, null, 'Y', '110251-协议存款开户中，取消备注字段', null, null, null, null, '1-系统问题', 'Closed-已关闭', null, null, '2016-11-03 14:03:27', '2-中（一般的缺陷）', null, '新建', null, '0', '2017-02-16 22:01:00');
INSERT INTO `t_qc_defect` VALUES ('17', null, '关于人民币存款新增NRA标识的需求', '修改字段值,6-NRA账户为6-NRA账户（人民币）', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', null, null, null, null, null, null, null, null, 'Y', '修改字段值,6-NRA账户为6-NRA账户（人民币）', null, null, null, null, '1-系统问题', 'Closed-已关闭', null, null, '2016-11-03 13:58:26', '3-低（较小的问题，改进的建议）', null, '新建', null, '0', '2017-02-17 12:36:20');
INSERT INTO `t_qc_defect` VALUES ('18', null, '关于人民币存款新增NRA标识的需求', '110251-协议存款开户无新增字段', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', null, null, null, null, null, null, null, null, 'Y', '110251-协议存款开户无新增字段', null, null, null, null, '1-系统问题', 'Closed-已关闭', null, null, '2016-11-03 14:00:24', '2-中（一般的缺陷）', null, '新建', null, '0', '2017-02-17 12:36:20');
INSERT INTO `t_qc_defect` VALUES ('19', null, '关于人民币存款新增NRA标识的需求', '110251-协议存款开户中，取消备注字段', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', null, null, null, null, null, null, null, null, 'Y', '110251-协议存款开户中，取消备注字段', null, null, null, null, '1-系统问题', 'Closed-已关闭', null, null, '2016-11-03 14:03:27', '2-中（一般的缺陷）', null, '新建', null, '0', '2017-02-17 12:36:20');
INSERT INTO `t_qc_defect` VALUES ('20', '1', '关于人民币存款新增NRA标识的需求', '修改字段值,6-NRA账户为6-NRA账户（人民币）', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', null, null, null, null, null, null, null, null, 'Y', '修改字段值,6-NRA账户为6-NRA账户（人民币）', null, null, null, null, '1-系统问题', 'Closed-已关闭', null, null, '2016-11-03 13:58:26', '3-低（较小的问题，改进的建议）', null, '新建', null, '0', '2017-02-21 12:56:41');
INSERT INTO `t_qc_defect` VALUES ('21', '1', '关于人民币存款新增NRA标识的需求', '110251-协议存款开户无新增字段', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', null, null, null, null, null, null, null, null, 'Y', '110251-协议存款开户无新增字段', null, null, null, null, '1-系统问题', 'Closed-已关闭', null, null, '2016-11-03 14:00:24', '2-中（一般的缺陷）', null, '新建', null, '0', '2017-02-21 12:56:41');
INSERT INTO `t_qc_defect` VALUES ('22', '1', '关于人民币存款新增NRA标识的需求', '110251-协议存款开户中，取消备注字段', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', null, null, null, null, null, null, null, null, 'Y', '110251-协议存款开户中，取消备注字段', null, null, null, null, '1-系统问题', 'Closed-已关闭', null, null, '2016-11-03 14:03:27', '2-中（一般的缺陷）', null, '新建', null, '0', '2017-02-21 12:56:41');
INSERT INTO `t_qc_defect` VALUES ('23', '1', '11', '11', '1', '1', '2017-02-21 00:00:00', ' d', null, null, '', '', null, '', '', '', '', '', '', '', '', '', '', '', null, '', null, '', '', '', null, '0', '2017-02-21 12:59:53');
INSERT INTO `t_qc_defect` VALUES ('24', '1', '关于人民币存款新增NRA标识的需求', '修改字段值,6-NRA账户为6-NRA账户（人民币）', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', null, null, null, null, null, null, null, null, 'Y', '修改字段值,6-NRA账户为6-NRA账户（人民币）', null, null, null, null, '1-系统问题', 'Closed-已关闭', null, null, '2016-11-03 13:58:26', '3-低（较小的问题，改进的建议）', null, '新建', null, '0', '2017-03-02 10:13:06');
INSERT INTO `t_qc_defect` VALUES ('25', '1', '关于人民币存款新增NRA标识的需求', '110251-协议存款开户无新增字段', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', null, null, null, null, null, null, null, null, 'Y', '110251-协议存款开户无新增字段', null, null, null, null, '1-系统问题', 'Closed-已关闭', null, null, '2016-11-03 14:00:24', '2-中（一般的缺陷）', null, '新建', null, '0', '2017-03-02 10:13:06');
INSERT INTO `t_qc_defect` VALUES ('26', '1', '关于人民币存款新增NRA标识的需求', '110251-协议存款开户中，取消备注字段', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', null, null, null, null, null, null, null, null, 'Y', '110251-协议存款开户中，取消备注字段', null, null, null, null, '1-系统问题', 'Closed-已关闭', null, null, '2016-11-03 14:03:27', '2-中（一般的缺陷）', null, '新建', null, '0', '2017-03-02 10:13:06');
INSERT INTO `t_qc_defect` VALUES ('27', '1', '关于人民币存款新增NRA标识的需求', '修改字段值,6-NRA账户为6-NRA账户（人民币）', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', null, null, null, null, null, null, null, null, 'Y', '修改字段值,6-NRA账户为6-NRA账户（人民币）', null, null, null, null, '1-系统问题', 'Closed-已关闭', null, null, '2016-11-03 13:58:26', '3-低（较小的问题，改进的建议）', null, '新建', null, '0', '2017-03-02 15:31:15');
INSERT INTO `t_qc_defect` VALUES ('28', '1', '关于人民币存款新增NRA标识的需求', '110251-协议存款开户无新增字段', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', null, null, null, null, null, null, null, null, 'Y', '110251-协议存款开户无新增字段', null, null, null, null, '1-系统问题', 'Closed-已关闭', null, null, '2016-11-03 14:00:24', '2-中（一般的缺陷）', null, '新建', null, '0', '2017-03-02 15:31:15');
INSERT INTO `t_qc_defect` VALUES ('29', '1', '关于人民币存款新增NRA标识的需求', '110251-协议存款开户中，取消备注字段', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', null, null, null, null, null, null, null, null, 'Y', '110251-协议存款开户中，取消备注字段', null, null, null, null, '1-系统问题', 'Closed-已关闭', null, null, '2016-11-03 14:03:27', '2-中（一般的缺陷）', null, '新建', null, '0', '2017-03-02 15:31:15');
INSERT INTO `t_qc_defect` VALUES ('30', '', '21321', '`1', '321', '312', '2017-03-06 00:00:00', '312dsad', '2017-03-06 11:48:00', null, '', '', null, '', '', '', '', '', '', '', '', '1', '', '', null, '', null, '', '', '', null, '0', '2017-03-06 11:48:14');
INSERT INTO `t_qc_defect` VALUES ('31', '1', '关于人民币存款新增NRA标识的需求', '修改字段值,6-NRA账户为6-NRA账户（人民币）', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', null, null, null, null, null, null, null, null, 'Y', '修改字段值,6-NRA账户为6-NRA账户（人民币）', null, null, null, null, '1-系统问题', 'Closed-已关闭', null, null, '2016-11-03 13:58:26', '3-低（较小的问题，改进的建议）', null, '新建', null, '0', '2017-03-07 09:49:09');
INSERT INTO `t_qc_defect` VALUES ('32', '1', '关于人民币存款新增NRA标识的需求', '110251-协议存款开户无新增字段', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', null, null, null, null, null, null, null, null, 'Y', '110251-协议存款开户无新增字段', null, null, null, null, '1-系统问题', 'Closed-已关闭', null, null, '2016-11-03 14:00:24', '2-中（一般的缺陷）', null, '新建', null, '0', '2017-03-07 09:49:09');
INSERT INTO `t_qc_defect` VALUES ('33', '1', '关于人民币存款新增NRA标识的需求', '110251-协议存款开户中，取消备注字段', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', null, null, null, null, null, null, null, null, 'Y', '110251-协议存款开户中，取消备注字段', null, null, null, null, '1-系统问题', 'Closed-已关闭', null, null, '2016-11-03 14:03:27', '2-中（一般的缺陷）', null, '新建', null, '0', '2017-03-07 09:49:09');
INSERT INTO `t_qc_defect` VALUES ('34', '1', '关于人民币存款新增NRA标识的需求', '修改字段值,6-NRA账户为6-NRA账户（人民币）', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', null, null, '', '', null, '', '', '', 'Y', '修改字段值,6-NRA账户为6-NRA账户（人民币）', '', '', '', '', '1-系统问题', '新建', null, '', '2016-11-03 13:58:00', '3-低（较小的问题，改进的建议）', '', '新建', '126,128', '1', '2017-03-22 16:06:22');
INSERT INTO `t_qc_defect` VALUES ('35', '1', '关于人民币存款新增NRA标识的需求', '110251-协议存款开户无新增字段', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', null, null, '', '', null, '', '', '', 'Y', '110251-协议存款开户无新增字段', '', '', '', '', '1-系统问题', '打开', null, '', '2016-11-03 14:00:00', '2-中（一般的缺陷）', '', '新建', '128', '1', '2017-03-12 11:57:17');
INSERT INTO `t_qc_defect` VALUES ('36', '1', '关于人民币存款新增NRA标识的需求', '110251-协议存款开户中，取消备注字段', '系统集成测试', 'chenkaituo', '2016-11-03 00:00:00', 'zhou.shihao', null, null, '', '', null, '', '', '', 'Y', '110251-协议存款开户中，取消备注字段', '', '', '', '', '1-系统问题', '待验证', null, '', '2016-11-03 14:03:00', '2-中（一般的缺陷）', '', '新建', '128', '1', '2017-03-12 11:56:47');

-- ----------------------------
-- Table structure for `t_role_node`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_node`;
CREATE TABLE `t_role_node` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水编号',
  `roleId` bigint(20) NOT NULL COMMENT '角色编号',
  `nodeId` bigint(20) NOT NULL COMMENT '节点编号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_role_node` (`roleId`,`nodeId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='角色节点关联表';

-- ----------------------------
-- Records of t_role_node
-- ----------------------------
INSERT INTO `t_role_node` VALUES ('1', '1', '0');
INSERT INTO `t_role_node` VALUES ('2', '1', '1');
INSERT INTO `t_role_node` VALUES ('3', '1', '2');
INSERT INTO `t_role_node` VALUES ('6', '1', '3');
INSERT INTO `t_role_node` VALUES ('9', '1', '4');
INSERT INTO `t_role_node` VALUES ('10', '1', '5');
INSERT INTO `t_role_node` VALUES ('11', '1', '6');
INSERT INTO `t_role_node` VALUES ('13', '1', '7');
INSERT INTO `t_role_node` VALUES ('14', '1', '8');
INSERT INTO `t_role_node` VALUES ('12', '1', '9');
INSERT INTO `t_role_node` VALUES ('4', '1', '10');
INSERT INTO `t_role_node` VALUES ('5', '1', '11');
INSERT INTO `t_role_node` VALUES ('7', '1', '12');
INSERT INTO `t_role_node` VALUES ('8', '1', '13');
INSERT INTO `t_role_node` VALUES ('15', '3', '0');
INSERT INTO `t_role_node` VALUES ('16', '3', '1');
INSERT INTO `t_role_node` VALUES ('28', '3', '2');
INSERT INTO `t_role_node` VALUES ('20', '3', '3');
INSERT INTO `t_role_node` VALUES ('30', '3', '11');
INSERT INTO `t_role_node` VALUES ('22', '3', '13');

-- ----------------------------
-- Table structure for `t_role_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_user`;
CREATE TABLE `t_role_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水编号',
  `roleId` bigint(20) NOT NULL COMMENT '角色编号',
  `userId` bigint(20) NOT NULL COMMENT '用户编号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_role_user` (`roleId`,`userId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色用户关系表';

-- ----------------------------
-- Records of t_role_user
-- ----------------------------
INSERT INTO `t_role_user` VALUES ('1', '1', '1');
INSERT INTO `t_role_user` VALUES ('2', '3', '2');


-- ----------------------------
-- Table structure for `t_sys_code`
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
-- Records of t_sys_code
-- ----------------------------
INSERT INTO `t_sys_code` VALUES ('SP001', '节点类型', '1', '菜单', '1');
INSERT INTO `t_sys_code` VALUES ('SP001', '节点类型', '2', '选项卡', '1');
INSERT INTO `t_sys_code` VALUES ('SP001', '节点类型', '3', '按钮', '1');
INSERT INTO `t_sys_code` VALUES ('SP002', '缺陷状态', '1', '新建', '1');
INSERT INTO `t_sys_code` VALUES ('SP002', '缺陷状态', '2', '已取消', '1');
INSERT INTO `t_sys_code` VALUES ('SP002', '缺陷状态', '3', '已关闭', '1');
INSERT INTO `t_sys_code` VALUES ('SP002', '缺陷状态', '4', '待打包', '1');
INSERT INTO `t_sys_code` VALUES ('SP002', '缺陷状态', '5', '待验证', '1');
INSERT INTO `t_sys_code` VALUES ('SP002', '缺陷状态', '6', '已修复', '1');
INSERT INTO `t_sys_code` VALUES ('SP002', '缺陷状态', '7', '打开', '1');
INSERT INTO `t_sys_code` VALUES ('SP002', '缺陷状态', '8', '已拒绝', '1');
INSERT INTO `t_sys_code` VALUES ('SP002', '缺陷状态', '9', '重新打开', '1');
INSERT INTO `t_sys_code` VALUES ('SP002', '缺陷状态', '10', '存档', '1');

-- ----------------------------
-- Table structure for `t_sys_group`
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
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统部门表';

-- ----------------------------
-- Records of t_sys_group
-- ----------------------------
INSERT INTO `t_sys_group` VALUES ('1', '管理层', '管理层', '1', '0', '10', '1', '2017-02-13 09:58:47');
INSERT INTO `t_sys_group` VALUES ('2', 'IT部', 'IT部', '1', '0', '100', '1', '2017-02-13 09:58:47');

-- ----------------------------
-- Table structure for `t_sys_node`
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
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='系统节点表';

-- ----------------------------
-- Records of t_sys_node
-- ----------------------------
INSERT INTO `t_sys_node` VALUES ('4', '系统管理', '1', '0', '1', null, '系统管理', '100', '', 'gears', '0', '', '1', '2017-02-13 09:58:47');
INSERT INTO `t_sys_node` VALUES ('5', '部门管理', '2', '4', '1', null, '部门管理', '30', '/group/list', '', '0', null, '1', '2017-02-13 09:58:47');
INSERT INTO `t_sys_node` VALUES ('6', '用户管理', '2', '4', '1', null, '用户管理', '30', '/user/list', '', '0', null, '1', '2017-02-13 09:58:47');
INSERT INTO `t_sys_node` VALUES ('7', '节点管理', '2', '4', '1', null, '节点管理', '40', '/node/list', '', '0', null, '1', '2017-02-13 09:58:47');
INSERT INTO `t_sys_node` VALUES ('8', '权限管理', '2', '4', '1', null, '角色管理', '110', '/role/list', '', '0', null, '1', '2017-02-13 09:58:47');
INSERT INTO `t_sys_node` VALUES ('9', '添加用户', '3', '6', '3', 'user:add', '添加用户', '130', '', '', '0', null, '1', '2017-02-13 09:58:47');
INSERT INTO `t_sys_node` VALUES ('10', '添加缺陷', '3', '2', '3', 'defect:add', '添加缺陷', '10', '', '', '0', '', '1', '2017-02-14 16:22:34');
INSERT INTO `t_sys_node` VALUES ('11', '删除缺陷', '3', '2', '3', 'defect:del', '删除缺陷', '20', '', '', '0', '', '1', '2017-02-14 16:23:27');
INSERT INTO `t_sys_node` VALUES ('12', '添加案例', '3', '3', '3', 'case:add', '添加案例', '10', '', '', '0', '', '1', '2017-02-14 16:24:26');
INSERT INTO `t_sys_node` VALUES ('13', '删除案例', '3', '3', '3', 'case:del', '删除案例', '20', '', '', '0', '', '1', '2017-02-14 16:25:12');
INSERT INTO `t_sys_node` VALUES ('14', '网吧管理', '1', '0', '1', '', '网吧管理', '20', '/netbarList/list', 'file-text-o', '0', '', '1', '2017-04-23 20:03:53');
INSERT INTO `t_sys_node` VALUES ('15', '网吧注册', '2', '14', '1', '', '网吧注册', null, '/netbar/regList', '', '0', '', '1', '2017-04-23 20:04:48');

-- ----------------------------
-- Table structure for `t_sys_role`
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
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('1', '管理员', 'admin', '管理员', '1', '1', '2017-02-13 09:58:47');
INSERT INTO `t_sys_role` VALUES ('2', '经理', 'manage', '经理', '2', '1', '2017-02-13 09:58:47');
INSERT INTO `t_sys_role` VALUES ('3', 'IT', 'staff', 'IT', '2', '1', '2017-02-13 09:58:47');

-- ----------------------------
-- Table structure for `t_sys_user`
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
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('1', 'admin', null, 'admin', '21232f297a57a5a743894a0e4a801fc3', '0', null, null, null, null, '1', null, null, null, '1', '1', '2017-02-13 09:58:47');
INSERT INTO `t_sys_user` VALUES ('2', 'test', '', 'test', '098f6bcd4621d373cade4e832627b4f6', null, null, null, '', '', '2', '', '', null, '0', '1', '2017-02-17 13:54:19');








DROP TABLE IF EXISTS `t_server_info`;
CREATE TABLE `t_server_info` (
	`id` VARCHAR(50) NOT NULL COMMENT '服务器MAC地址',
	`bar_id` VARCHAR(50) NOT NULL COMMENT '网吧ID',
	`ip` VARCHAR(50) NOT NULL COMMENT '服务器IP地址',
	`pc_name` VARCHAR(50) NOT NULL COMMENT '服务器名称',
	`os_type` INT(11) NOT NULL COMMENT '服务器操作系统类型',
	`os_version` VARCHAR(50) NOT NULL COMMENT '服务器操作系统版本',
	`creator` VARCHAR(50) NOT NULL COMMENT '创建者',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
	PRIMARY KEY (`id`)
)
COMMENT='服务器信息表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

DROP TABLE IF EXISTS `t_pc_info`;
CREATE TABLE `t_pc_info` (
	`id` VARCHAR(50) NOT NULL COMMENT '客户机MAC地址',
	`bar_id` VARCHAR(50) NOT NULL COMMENT '网吧ID',
	`ip` VARCHAR(50) NOT NULL COMMENT '客户机IP地址',
	`pc_name` VARCHAR(50) NOT NULL COMMENT '客户机主机名',
	`os_type` INT(11) NOT NULL COMMENT '客户机操作系统类型',
	`os_version` VARCHAR(50) NOT NULL COMMENT '客户机操作系统版本',
	`creator` VARCHAR(50) NOT NULL COMMENT '创建者',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
	PRIMARY KEY (`id`)
)
COMMENT='网吧客户机基本信息'
COLLATE='utf8_general_ci'
ENGINE=InnoDB

DROP TABLE IF EXISTS `t_stat_net_bar`;
CREATE TABLE `t_stat_net_bar` (
	`bar_id` VARCHAR(10) NOT NULL COMMENT '网吧注册号',
	`stat_date` DATE NOT NULL COMMENT ' 统计日期',
	`online` INT(11) NOT NULL COMMENT '最大在线终端数',
	`offline` INT(11) NOT NULL COMMENT '最小离线终端数',
	`valid` INT(11) NOT NULL COMMENT '最大有效终端数',
	`login` INT(11) NOT NULL COMMENT '最大登录用户数',
	`area_code` VARCHAR(6) NOT NULL COMMENT '县代码',
	`city_code` VARCHAR(6) NOT NULL COMMENT '市代码',
	PRIMARY KEY (`bar_id`, `stat_date`)
)
COMMENT='网吧日统计信息'
COLLATE='utf8_general_ci'
ENGINE=InnoDB

DROP TABLE IF EXISTS `t_stat_area`;
CREATE TABLE `t_stat_area` (
	`area_code` VARCHAR(6) NOT NULL COMMENT '区域代码',
	`stat_date` DATE NOT NULL COMMENT '统计日期',
	`online` INT(11) NOT NULL COMMENT '最大网吧在线数量',
	`offline` INT(11) NOT NULL COMMENT '最大网吧离线数量',
	`login` INT(11) NOT NULL COMMENT '最大网吧用户数',
	`rankno` CHAR(1) NOT NULL COMMENT '地区类别 1省2市3区',
	PRIMARY KEY (`area_code`, `stat_date`)
)
COMMENT='区域统计历史信息'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
