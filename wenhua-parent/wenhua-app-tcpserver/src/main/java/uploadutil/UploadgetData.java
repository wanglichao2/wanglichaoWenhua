package uploadutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gov.ccm.netbar.interfaceImp.controlInfo.CustomerOnlineInfo;
import gov.ccm.netbar.interfaceImp.controlInfo.ExigencyInfo;
import gov.ccm.netbar.interfaceImp.controlInfo.OnlineTimeTipInfo;


public class UploadgetData {
	private  Connection conn=null;
	private  ResultSet rs=null;
	private  PreparedStatement pstmt=null;
	public List<CustomerOnlineInfo> getAllNetbar_code(){
		List<CustomerOnlineInfo> t_up_cuonliinfolist=new ArrayList<CustomerOnlineInfo>();
	   	  CustomerOnlineInfo t=null;
	   	  try {
	   			conn=DBManager.getConnection();
	   			String sql="select netbar_code from t_up_customeronlineinfo";
	   			pstmt=conn.prepareStatement(sql);
	   			rs=pstmt.executeQuery();
	   			while(rs.next()){
	   				t =new CustomerOnlineInfo();
	   			
	   				t.setNetbar_code(rs.getString("netbar_code"));
	   				
	   				t_up_cuonliinfolist.add(t);
	   			}
	   		} catch (SQLException e) {
	   			// TODO Auto-generated catch block
	   			e.printStackTrace();
	   		}finally{
	   			DBManager.closeResource(rs, pstmt, conn);
	   		}
	   	  return t_up_cuonliinfolist;
	}
	public List<CustomerOnlineInfo> getAll(){
   	  List<CustomerOnlineInfo> t_up_cuonliinfolist=new ArrayList<CustomerOnlineInfo>();
   	  CustomerOnlineInfo t=null;
   	  try {
   			conn=DBManager.getConnection();
   			String sql="select * from t_up_customeronlineinfo";
   			pstmt=conn.prepareStatement(sql);
   			rs=pstmt.executeQuery();
   			while(rs.next()){
   				t =new CustomerOnlineInfo();
   				t.setCustomer_num(rs.getString("customer_num"));
   				t.setNetbar_code(rs.getString("netbar_code"));
   				t.setReport_time(rs.getString("report_time"));
   				t_up_cuonliinfolist.add(t);
   			}
   		} catch (SQLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}finally{
   			DBManager.closeResource(rs, pstmt, conn);
   		}
   	  return t_up_cuonliinfolist;
     }
	 public int delte(String netbar_code){
		    int result=0;
		    try {
				conn=DBManager.getConnection();
				String sql="delete from t_up_customeronlineinfo where netbar_code=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,netbar_code);
				result=pstmt.executeUpdate();
				if(result>0){
					System.out.println("删除成功");
				}else{
					System.out.println("删除失败！");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		 return result;
	 }
	 //上网时长提示信息上传
	 public List<OnlineTimeTipInfo> getAllOnlineTimeTipInfo(){
		 List<OnlineTimeTipInfo> onlintipinfolist=new ArrayList<OnlineTimeTipInfo>();
		 OnlineTimeTipInfo onlitimetipinfo=null;
		 try {
			 conn=DBManager.getConnection();
			 String sql="select * from t_up_onlinetimeinfo";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				onlitimetipinfo=new OnlineTimeTipInfo();
				onlitimetipinfo.setNetbarCode(rs.getString("netbarCode"));
				onlitimetipinfo.setReportTime(rs.getString("reportTime"));
				onlitimetipinfo.setWarnNum(rs.getString("warnNum"));
				onlitimetipinfo.setWarnType(rs.getString("warnType"));
				onlintipinfolist.add(onlitimetipinfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return onlintipinfolist;
	 }
	 //删除上网时长提示信息上传
	 public int delOnlineTimeTipInfoByNetbarCode(String netbarCode){
		 int result=0;
		
		 try {
			 conn=DBManager.getConnection();
			 String sql="delete from t_up_onlinetimeinfo where netbarCode=?";
			 pstmt=conn.prepareStatement(sql);
			 pstmt.setString(1,netbarCode);
			 result=pstmt.executeUpdate();
			 if(result>0){
				 System.out.println("删除成功");
			 }else{
				 System.out.println("删除失败");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return result;
	 }
	 //查询紧急状态信息上传
	 public List<ExigencyInfo> getAllExigencyInfo(){
		 List<ExigencyInfo> elist=new ArrayList<ExigencyInfo>();
		 ExigencyInfo exigencyInfo=new ExigencyInfo();
		 try {
			 conn=DBManager.getConnection();
			 String sql="select * from t_up_sendExigencyInfo";
			pstmt=conn.prepareStatement(sql);
		     rs=pstmt.executeQuery();
		    while(rs.next()){
		       exigencyInfo=new ExigencyInfo();
		    	exigencyInfo.setExigencyNum(rs.getString("ExigencyNum"));
		    	exigencyInfo.setNetbar_code(rs.getString("netbar_code"));
		    	exigencyInfo.setReportTime(rs.getString("reportTime"));
		    	elist.add(exigencyInfo);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elist;
	 }
	 //删除紧急状态信息上传
	 public int delExigencyInfoByNetbarcode(String netbar_code){
		 int result=0;
		 try {
			 conn=DBManager.getConnection();
			 String sql="delete from t_up_sendexigencyinfo where netbar_code=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, netbar_code);
			result=pstmt.executeUpdate();
			if(result>0)
				System.out.println("w删除成功");
			else
				System.out.println("w删除失败");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return result;
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
  
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int deleteCustomerOnlineInfoArray(String[] s) {
		 int result=0;
		 try {
			 conn=DBManager.getConnection();
			 conn.setAutoCommit(false);
			 
			 String sql="delete from t_up_customeronlineinfo where netbar_code in(0"; 
			 	 
			 		for(int i=0;i<s.length;i++) 
			 		
			 		{
			 			
			 		  sql+=","+s[i]; 
			 		} 
			 		sql+=")"; 
		
			result=pstmt.executeUpdate();
			if(result>0)
				System.out.println("批量删除成功");
			else
				System.out.println("批量删除失败");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return result;
	}


}
