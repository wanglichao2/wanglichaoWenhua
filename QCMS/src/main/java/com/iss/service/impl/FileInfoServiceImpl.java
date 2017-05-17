package com.iss.service.impl;

import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iss.dao.ICommonDao;
import com.iss.dao.IFileBarDao;
import com.iss.dao.IFileBarJPADao;
import com.iss.dao.IFileInfoDao;
import com.iss.dao.IFileInfoJPADao;
import com.iss.dao.INetBarDao;
import com.iss.entity.FileBarEntity;
import com.iss.entity.FileInfoEntity;
import com.iss.entity.NetBarEntity;
import com.iss.service.IFileInfoService;
import com.iss.util.StringUtil;
import com.iss.vo.DataParam;
import com.iss.vo.DataTables;

@Service
public class FileInfoServiceImpl implements IFileInfoService {
	@Autowired
	private IFileInfoDao iFileInfoDao;
	@Autowired
	private ICommonDao iCommonDao;
	@Autowired
	private IFileInfoJPADao iFileInfoJPADao;
	@Autowired
	private IFileBarDao iFileBarDao;
	@Autowired
	private IFileBarJPADao IFileBarJPADao;
	@Autowired
	private INetBarDao iNetBarDao;
	
	@Override
	public List<FileInfoEntity> load(){
		DataParam param = new DataParam();
		param.setLength(-1);
		param.setDraw(1);
		param.setStart(0);
		return iFileInfoJPADao.query(param).getData();
	}
	
	@Override
	public DataTables<FileInfoEntity> load(DataParam param){
		return iFileInfoJPADao.query(param);
	}
	
	@Override
	@Transactional
	public FileInfoEntity saveOrUpdate(FileInfoEntity entity){
		FileInfoEntity fileInfo = new FileInfoEntity();
		//判断是新增还是修改
		if(StringUtil.isNotEmpty(entity.getId())){
			try {
				fileInfo = iFileInfoDao.findOne(entity.getId());
				fileInfo.setVersion(entity.getVersion());
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				fileInfo.setLastModifyTime(df.parse(df.format(new Date())));
				fileInfo.setLastModifier(entity.getCreator());
				fileInfo.setFlag(entity.getFlag());
				fileInfo.setType(entity.getType());
				fileInfo.setAction(entity.getAction());
				fileInfo.setIsApply(entity.getIsApply());
				fileInfo = iFileInfoDao.saveAndFlush(fileInfo);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}else{
			//保存文件信息
			try {
				entity.setStatus(1);
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				entity.setCreateTime(df.parse(df.format(new Date())));
				//获取文件二进制数据的MD5字符串
				String md5 = getMd5(entity.getData());
				entity.setMd5(md5.toUpperCase());
			} catch (Exception e) {
				e.printStackTrace();
			}
			fileInfo = iFileInfoDao.saveAndFlush(entity);
		}
		//更新文件和网吧的关联关系
		if(StringUtil.isNotEmpty(fileInfo.getId())){
			//删除已经存在的该文件的网吧关联关系
			IFileBarJPADao.delByFileId(fileInfo.getId());
			//保存文件和网吧的关联关系
			List<FileBarEntity> fileBars = new ArrayList<FileBarEntity>();
			if(fileInfo.getIsApply() == '0'){
				String netbarIds = entity.getNetbarIds();
				String[] netbarId = netbarIds.split(",");
				if(netbarId.length > 0){
					for(String barid : netbarId){
						if(StringUtil.isNotEmpty(barid)){
							FileBarEntity fileBar = new FileBarEntity();
							fileBar.setFileId(fileInfo.getId());
							fileBar.setBarid(barid);
							fileBars.add(fileBar);
						}
					}
				}
			}else{
				List<NetBarEntity> netbars = iNetBarDao.findAll();
				for(NetBarEntity netbar : netbars){
					if(netbar.getStatus() == 1){
						FileBarEntity fileBar = new FileBarEntity();
						fileBar.setFileId(fileInfo.getId());
						fileBar.setBarid(netbar.getId());
						fileBars.add(fileBar);
					}
				}
			}
			iFileBarDao.save(fileBars);
		}
		return fileInfo;
	}
	
	private static final char[] HEX_CHAR = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
	'f' };
	
	/**
	 * 获取二进制数组的MD5字符串
	 * @param data
	 * @return
	 */
	private static String getMd5(byte[] data) {  
        String value = null;  
	    try {  
	        MessageDigest md = MessageDigest.getInstance("MD5"); 
			md.update(data);
			byte[] b = md.digest();
	        StringBuilder sb = new StringBuilder(b.length * 2);
			for (int i = 0; i < b.length; i++) {
				sb.append(HEX_CHAR[(b[i] & 0xf0) >>> 4]);
				sb.append(HEX_CHAR[b[i] & 0x0f]);
			}
			value = sb.toString();
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    } 
	    return value;  
    }  
	
	@Override
	@Transactional
	public boolean update(Long id, String field, String fieldValue) {
		//删除已经存在的该文件的网吧关联关系
		IFileBarJPADao.delByFileId(id);
		return iCommonDao.updateField(id, field, fieldValue, "t_file_info");
	}
	
	@Override
	@Transactional
	public boolean delBatch(Long[] ids) {
		return iCommonDao.delBatch("t_file_info", ids);
	}
	
	@Override
	@Transactional
	public List<FileInfoEntity> save(List<FileInfoEntity> list){
		return iFileInfoDao.save(list);
	}
	
	@Override
	@Transactional
	public List<FileBarEntity> saveFileBars(List<FileBarEntity> list){
		if(list != null && list.size() > 0){
			IFileBarJPADao.delByFileId(list.get(0).getFileId());
			return iFileBarDao.save(list);
		}
		return list;
	}
}