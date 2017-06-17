package gov.ccm.netbar.interfaceImp.loginInfo;

public class LoginInfoProxy implements gov.ccm.netbar.interfaceImp.loginInfo.LoginInfo {
  private String _endpoint = null;
  private gov.ccm.netbar.interfaceImp.loginInfo.LoginInfo loginInfo = null;
  
  public LoginInfoProxy() {
    _initLoginInfoProxy();
  }
  
  public LoginInfoProxy(String endpoint) {
    _endpoint = endpoint;
    _initLoginInfoProxy();
  }
  
  private void _initLoginInfoProxy() {
    try {
      loginInfo = (new gov.ccm.netbar.interfaceImp.loginInfo.LoginInfoServiceLocator()).getLoginInfoPort();
      if (loginInfo != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)loginInfo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)loginInfo)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (loginInfo != null)
      ((javax.xml.rpc.Stub)loginInfo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public gov.ccm.netbar.interfaceImp.loginInfo.LoginInfo getLoginInfo() {
    if (loginInfo == null)
      _initLoginInfoProxy();
    return loginInfo;
  }
  
  public java.lang.String login(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException{
    if (loginInfo == null)
      _initLoginInfoProxy();
    return loginInfo.login(username, password);
  }
  
  public java.lang.String logout(java.lang.String key) throws java.rmi.RemoteException{
    if (loginInfo == null)
      _initLoginInfoProxy();
    return loginInfo.logout(key);
  }
  
  public java.lang.String modifyPassword(java.lang.String key, java.lang.String password, java.lang.String newPassword) throws java.rmi.RemoteException{
    if (loginInfo == null)
      _initLoginInfoProxy();
    return loginInfo.modifyPassword(key, password, newPassword);
  }
  
  
}