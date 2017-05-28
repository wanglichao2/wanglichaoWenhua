package com.iss.test;

import gov.ccm.netbar.interfaceImp.loginInfo.LoginInfoProxy;
import gov.ccm.netbar.interfaceImp.placeInfo.NetbarInfoProxy;
import gov.ccm.netbar.interfaceImp.placeInfo.RelationshipNetbar;

public class WebServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String loginurl="http://192.168.70.39:8080/netbar/services/loginInfo?wsdl";
		String username="410000";
		String password="000000";
		String infourl="http://192.168.70.39:8080/netbar/services/NetbarInfo?wsdl";
		String depurl="http://192.168.70.39:8080/netbar/services/deployInfo?wsdl";
		try {
			LoginInfoProxy loginProxy=new LoginInfoProxy(loginurl);
			String key=loginProxy.login(username, password);
			System.out.println("=================>"+key);
			RelationshipNetbar bn=new RelationshipNetbar("410001", "长大但", "000000001", 
					"0000000001", "萨克反甲阿斯顿飞", "0000000", "2017-05-26");
			RelationshipNetbar[] relationship=new RelationshipNetbar[]{bn};
			NetbarInfoProxy infoProxy=new NetbarInfoProxy(infourl);
			String resp=infoProxy.uploadNetbarInfo(key, relationship);
			System.out.println("------------------>"+resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
