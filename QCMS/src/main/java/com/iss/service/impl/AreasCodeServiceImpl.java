package com.iss.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iss.dao.IAreasCodeDao;
import com.iss.dao.IAreasCodeJPADao;
import com.iss.entity.AreasEntity;
import com.iss.service.IAreasCodeService;
import com.iss.vo.TreeNode;

@Service
public class AreasCodeServiceImpl implements IAreasCodeService {
	
	@Autowired
	private IAreasCodeDao iAreasCodeDao;
	@Autowired
	private IAreasCodeJPADao iAreasCodeJPADao;
	
	
	@Override
	public String getTreeAreas(){
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
				parentId.append(areasid.substring(0,4)).append("00");
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

	@Override
	public List<AreasEntity> getTwolevelAreas(String areasid) {
		return iAreasCodeJPADao.findByAreasId(areasid, "2");
	}

	@Override
	public List<AreasEntity> getThreelevelAreas(String areasid) {
		return iAreasCodeJPADao.findByAreasId(areasid, "3");
	}
}
