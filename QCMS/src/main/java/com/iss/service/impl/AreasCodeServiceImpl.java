package com.iss.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iss.dao.IAreasCodeDao;
import com.iss.dao.IAreasCodeJPADao;
import com.iss.dao.ISystemDao;
import com.iss.entity.AreasEntity;
import com.iss.service.IAreasCodeService;
import com.iss.util.CommonUtil;
import com.iss.vo.DataParam;
import com.iss.vo.TreeNode;

@Service
public class AreasCodeServiceImpl implements IAreasCodeService {
	
	@Autowired
	private IAreasCodeDao iAreasCodeDao;
	@Autowired
	private IAreasCodeJPADao iAreasCodeJPADao;
	@Autowired
	private ISystemDao iSystemDao;
	
	@Override
	public String getTreeAreas(DataParam param){
		List<AreasEntity> data = iAreasCodeDao.findAll();
		if(data == null || data.size() <= 0){
			return null;
		}
		data.remove(0);
		for(AreasEntity areas : data){
			if(areas.getRankno() == '2'){
				areas.setParentId("410000");
			}else{
				String areasid = areas.getAreasid();
				StringBuffer parentId = new StringBuffer();
				Integer head=Integer.valueOf(areasid.substring(0,4));
				if(head>=4189){
					parentId.append("418000");
				}else{
					parentId.append(areasid.substring(0,4)).append("00");
				}
				areas.setParentId(parentId.toString());
			}
		}
		List<TreeNode> treeNode = new ArrayList<TreeNode>();
		TreeNode node = new TreeNode(410000L, -1L, "河南", "河南", true);
		treeNode.add(node);
		for (AreasEntity e : data) {
			try {
//				System.out.println("======================"+("410000".equals(e.getAreasid())));
//				System.out.println(Long.valueOf(e.getAreasid()));
//				System.out.println(e.getParentId());
				treeNode.add(new TreeNode(Long.valueOf(e.getAreasid()), Long.valueOf(e.getParentId()), e.getAreasname(), e.getAreasname(), false));
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
		}
		Gson gson = new Gson();
		String json = gson.toJson(treeNode);
		treeNode = null;
		return json;
	}

	@Override
	public List<AreasEntity> getTwolevelAreas(String areasid) {
		return iAreasCodeJPADao.findByAreasId(areasid, "2");
	}

	@Override
	public List<AreasEntity> getThreelevelAreas(String areasid) {
		return iAreasCodeJPADao.findByAreasId(areasid, "3");
	}

	@Override
	public String getUserAreasTree(Long userId) {
		// TODO Auto-generated method stub
		List<AreasEntity> data= iSystemDao.queryUserAreaEntity(userId);
		if(CommonUtil.isEmpty(data))return null;
		for(AreasEntity areas : data){
			if(areas.getRankno() == '2'){
				areas.setParentId("410000");
			}else{
				/*String areasid = areas.getAreasid();
				StringBuffer parentId = new StringBuffer();
				parentId.append(areasid.substring(0,4)).append("00");
				areas.setParentId(parentId.toString());*/
				
				String areasid = areas.getAreasid();
				StringBuffer parentId = new StringBuffer();
				Integer head=Integer.valueOf(areasid.substring(0,4));
				if(head>=4189){
					parentId.append("418000");
				}else{
					parentId.append(areasid.substring(0,4)).append("00");
				}
				areas.setParentId(parentId.toString());
			}
		}
		List<TreeNode> treeNode = new ArrayList<TreeNode>();
		TreeNode node = new TreeNode(410000L, -1L, "河南", "河南", true);
		treeNode.add(node);
		for (AreasEntity e : data) {
			treeNode.add(new TreeNode(Long.parseLong(e.getAreasid()), Long.parseLong(e.getParentId()), e.getAreasname(), e.getAreasname(), false));
		}
		Gson gson = new Gson();
		String json = gson.toJson(treeNode);
		treeNode = null;
		return json;
	}
	
	
}
