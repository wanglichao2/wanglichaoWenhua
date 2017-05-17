/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2017年2月13日
 * @version: 1.0
 */
package com.iss.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.result.ExcelImportResult;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.iss.entity.DefectEntity;
import com.iss.excel.hanlder.DefectVerifyHandler;
import com.iss.service.ICaseService;
import com.iss.service.IDefectService;
import com.iss.util.JsonUtil;
import com.iss.vo.AjaxJson;
import com.iss.vo.DataParam;
import com.iss.vo.DataTables;

/**
 * 缺陷管理
 */
@Controller
@RequestMapping("/defect")
public class DefectController extends BaseController {
	@Autowired
	private IDefectService iDefectService;
	@Autowired
	private ICaseService iCaseService;
	
	/**
	 * 缺陷列表页面
	 * @author yjdai 
	 * @param classify
	 * @param years
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model){
		model.addAttribute("caseSet", iCaseService.query());
		return "qc/defect";
	}
	
	/**
	 * 加载列表数据
	 * @author yjdai 
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/load", produces="application/json;charset=UTF-8")
	public String load(DataParam param){
		DataTables<DefectEntity> dt = iDefectService.load(param);
		return JsonUtil.toJson(dt);
	}
	
	/**
	 * 添加数据
	 * @author yjdai 
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public AjaxJson add(DefectEntity entity){
		AjaxJson json = new AjaxJson();
		DefectEntity fixed = iDefectService.save(entity);
		if(fixed != null){
			json.setFlag(true);
			json.setObj(fixed);
		}
		return json;
	}
	
	/**
	 * 更新数据
	 * @author yjdai 
	 * @param pk
	 * @param name
	 * @param value
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/edit")
	public AjaxJson edit(Long pk, String name, String value){
		AjaxJson json = new AjaxJson();
		boolean bool = iDefectService.update(pk, name, value, "defect");
		json.setFlag(bool);
		return json;
	}
	
	/**
	 * 批量删除数据
	 * @author yjdai 
	 * @param ids 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delBatch")
	public AjaxJson delBatch(@RequestParam("ids[]")Long[] ids){
		AjaxJson json = new AjaxJson();
		boolean bool = iDefectService.delBatch(ids);
		json.setFlag(bool);
		return json;
	}
	
	/**
	 * 全量导出数据
	 * @author yjdai 
	 * @param model
	 * @return
	 */
	@RequestMapping("/export")
    public String export(Model model) {
		List<DefectEntity> list = iDefectService.load();
		String title = "缺陷数据";
        model.addAttribute(NormalExcelConstants.FILE_NAME, title);
        model.addAttribute(NormalExcelConstants.CLASS, DefectEntity.class);
        model.addAttribute(NormalExcelConstants.PARAMS, new ExportParams(title, title));
        model.addAttribute(NormalExcelConstants.DATA_LIST, list);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
    }
	
	/**
	 * 导入数据
	 * @author yjdai 
	 * @param file
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("/importData")
	public AjaxJson importData(@RequestParam("file") MultipartFile file){
		AjaxJson json = new AjaxJson();
		if(!file.isEmpty()){
			ImportParams params = new ImportParams();
			//params.setTitleRows(1);
	        params.setHeadRows(1);
			params.setVerifyHanlder(new DefectVerifyHandler());
			try {
				ExcelImportResult<DefectEntity> result = ExcelImportUtil.importExcelVerify(
						file.getInputStream(), DefectEntity.class, params);
				List<DefectEntity> list = result.getList();
				if(result.isVerfiyFail()){
					int row = 2;
					StringBuilder builder = new StringBuilder();
					for (DefectEntity entity : list) {
						String msg = entity.getErrorMsg();
						if(StringUtils.isNotEmpty(msg))
							builder.append("第"+ row +"行：").append(msg).append("\n");
						row++;
					}
					json.setMsg(builder.toString());
					/*FileOutputStream fos = new FileOutputStream("c:/test.xls");
					result.getWorkbook().write(fos);
					fos.close();*/
				}else{
					List<DefectEntity> fixedSet = iDefectService.save(list);
					json.setFlag(fixedSet.size()>0);
				}
			}catch (Exception e) {
				e.printStackTrace();
				json.setMsg("数据导入失败，请刷新重试！");
			}
		}
		return json;
	}
	
	/**
	 * 读取图片
	 * @author yjdai 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/readImg/{id}")
	public AjaxJson readImg(@PathVariable Long id){
		AjaxJson json = new AjaxJson();
		String imgPath = request.getServletContext().getRealPath(File.separator)+ "upload" +
				File.separator+ "photos" +File.separator+ id;
		File file = new File(imgPath);
		if(file.exists()){
			File[] files = file.listFiles();
			List<String> fileSet = new ArrayList<String>();
			for (File f : files) {
				fileSet.add(f.getName());
			}
			json.setObj(fileSet);
		}
		return json;
	}
	
	/**
	 * 上传图片
	 * @author yjdai 
	 * @param id
	 * @param type
	 * @param name
	 * @param size
	 * @param file
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/uploadImg")
	public AjaxJson uploadImg(Long id, String type, String name, Long size,
			@RequestParam("file") MultipartFile file){
		boolean isUpload = true;
		AjaxJson json = new AjaxJson();
		String imgPath = request.getServletContext().getRealPath(File.separator)+ "upload" +
				File.separator+ "photos" +File.separator+ id;
		try {
			if(!file.isEmpty()){
				String fileName = file.getOriginalFilename();
		        //String suffix = fileName.substring(fileName.lastIndexOf("."));  
				File dir = new File(imgPath);
				if(!dir.exists()){//目录不存在就创建
					dir.mkdirs();
				}
				file.transferTo(new File(imgPath +File.separator+ fileName));
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			isUpload = false;
		}
		if(isUpload){
			File dir = new File(imgPath);
			if(dir.exists()){
				File[] files = dir.listFiles();
				List<String> fileSet = new ArrayList<String>();
				for (File f : files) {
					fileSet.add(f.getName());
				}
				json.setObj(fileSet);
			}
		}
		return json;
	}
}
