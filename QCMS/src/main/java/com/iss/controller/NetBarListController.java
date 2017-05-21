/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2017年2月13日
 * @version: 1.0
 */
package com.iss.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iss.entity.AreasBarEntity;
import com.iss.entity.ProvinceCityBarEntity;
import com.iss.entity.StatAreaEntity;
import com.iss.entity.StatNetBarEntity;
import com.iss.service.IAreasCodeService;
import com.iss.service.INetBarListService;
import com.iss.util.JsonUtil;
import com.iss.util.StringUtil;
import com.iss.vo.AjaxJson;
import com.iss.vo.DataParam;
import com.iss.vo.DataTables;

@Controller
@RequestMapping("/netbarList")
public class NetBarListController extends BaseController {
	@Autowired
	private INetBarListService iNetBarListService;
	@Autowired
	private IAreasCodeService iAreasCodeService;
	
	@RequestMapping("/list")
	public String list(Model model){
		String json = iAreasCodeService.getTreeAreas(null);
		model.addAttribute("areasTree", json);
		List<ProvinceCityBarEntity> statList = iNetBarListService.loadProvinceCityBar();
		model.addAttribute("statList", statList);
		return "wh/netbar_list";
	}
	
	@ResponseBody
	@RequestMapping(value="/loadAreaTree", produces="application/json;charset=UTF-8")
	public String loadAreaTree(DataParam param){
		String json = iAreasCodeService.getTreeAreas(param);
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value="/loadProvinceCityBar", produces="application/json;charset=UTF-8")
	public String loadProvinceCityBar(DataParam param){
		List<ProvinceCityBarEntity> data = iNetBarListService.loadProvinceCityBar(param);
		DataTables<ProvinceCityBarEntity> dt = new DataTables<ProvinceCityBarEntity>(param.getDraw(), data.size(), data.size(), data);
		return JsonUtil.toJson(dt);
	}

	@ResponseBody
	@RequestMapping(value="/loadAreasBar", produces="application/json;charset=UTF-8")
	public String loadAreasBar(DataParam param){
		List<AreasBarEntity> data = iNetBarListService.loadAreasBar(param);
		DataTables<AreasBarEntity> dt = new DataTables<AreasBarEntity>(param.getDraw(), data.size(), data.size(), data);
		return JsonUtil.toJson(dt);
	}
	
	
	@ResponseBody
	@RequestMapping("/getChart")
	public AjaxJson getChart(@RequestParam("id") String id,@RequestParam("parentId") String parentId){
		AjaxJson json = new AjaxJson();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, Object> map = new HashMap<String, Object>();
		if(StringUtil.isEmpty(parentId) || parentId.equals("0") || parentId.equals("410000")){
			List<StatAreaEntity> data = iNetBarListService.getStatAreas(id,parentId);
			if(data != null){
				String[] x = new String[data.size()];
				Long[] y1 = new Long[data.size()];
				Long[] y2 = new Long[data.size()];
				Long[] y3 = new Long[data.size()];
				for(int i = 0;i < data.size(); i++){
					x[i] = df.format(data.get(i).getStat_date());
					y1[i] = data.get(i).getOnline();
					y2[i] = data.get(i).getOffline();
					y3[i] = data.get(i).getLogin();
				}
				map.put("y1", y1);
				map.put("y2", y2);
				map.put("y3", y3);
				map.put("x", x);
				map.put("name", new String[]{"在线网吧数","离线网吧数","用户总数"});
			}
		}else{
			List<StatNetBarEntity> data = iNetBarListService.getStatNetBars(id);
			if(data != null){
				String[] x = new String[data.size()];
				Long[] y1 = new Long[data.size()];
				Long[] y2 = new Long[data.size()];
				Long[] y3 = new Long[data.size()];
				for(int i = 0;i < data.size(); i++){
					x[i] = df.format(data.get(i).getStat_date());
					y1[i] = data.get(i).getOnline();
					y2[i] = data.get(i).getOffline();
					y3[i] = data.get(i).getValid();
				}
				map.put("y1", y1);
				map.put("y2", y2);
				map.put("y3", y3);
				map.put("x", x);
				map.put("name", new String[]{"在线终端数","离线终端数","有效终端数"});
			}
		}
		if(map.size() > 0){
			json.setFlag(true);
			json.setObj(map);
		}
		return json;
	}
	
	/**
	 * 全量导出数据
	 * @author yjdai 
	 * @param model
	 * @return
	 */
	@RequestMapping("/export")
    public String export(Model model,@RequestParam("id") String id,@RequestParam("parentId") String parentId,@RequestParam("areaName") String areaName) {
		DataParam param = new DataParam();
		param.setDraw(0);
		param.setLength(-1);
		param.setStart(0);
		Map<String, String> search = new HashMap<String, String>();
		search.put("value", id);
		param.setSearch(search);
		
		String title = "网吧统计列表";
        model.addAttribute(NormalExcelConstants.FILE_NAME, title);
        model.addAttribute(NormalExcelConstants.PARAMS, new ExportParams(title, title));
        
        if(StringUtil.isEmpty(id) || StringUtil.isEmpty(parentId) 
        		|| parentId.equals("0") || parentId.equals("410000")){
        	List<ProvinceCityBarEntity> list = iNetBarListService.loadProvinceCityBar(param);
			model.addAttribute(NormalExcelConstants.CLASS, ProvinceCityBarEntity.class);
	        model.addAttribute(NormalExcelConstants.DATA_LIST, list);
	        return NormalExcelConstants.JEECG_EXCEL_VIEW;
		}else{
	        List<AreasBarEntity> list = iNetBarListService.loadAreasBar(param);
//	        StatAreaEntity entity = new StatAreaEntity();
//	        entity.setArea_code(areaName);
//	        entity.setOnline(0L);
//	        entity.setOffline(0L);
//	        entity.set
//	        for(StatAreaEntity stat : list){
//	        	
//	        }
	        
			model.addAttribute(NormalExcelConstants.CLASS, AreasBarEntity.class);
	        model.addAttribute(NormalExcelConstants.DATA_LIST, list);
	        return NormalExcelConstants.JEECG_EXCEL_VIEW;
		}
    }
}
