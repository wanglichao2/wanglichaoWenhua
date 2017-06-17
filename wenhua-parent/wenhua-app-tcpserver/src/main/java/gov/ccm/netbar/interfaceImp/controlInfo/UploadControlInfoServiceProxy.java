package gov.ccm.netbar.interfaceImp.controlInfo;

public class UploadControlInfoServiceProxy implements gov.ccm.netbar.interfaceImp.controlInfo.UploadControlInfoService {
  private String _endpoint = null;
  private gov.ccm.netbar.interfaceImp.controlInfo.UploadControlInfoService uploadControlInfoService = null;
  
  public UploadControlInfoServiceProxy() {
    _initUploadControlInfoServiceProxy();
  }
  
  public UploadControlInfoServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initUploadControlInfoServiceProxy();
  }
  
  private void _initUploadControlInfoServiceProxy() {
    try {
      uploadControlInfoService = (new gov.ccm.netbar.interfaceImp.controlInfo.UploadControlInfoServiceServiceLocator()).getUploadControlInfoServicePort();
      if (uploadControlInfoService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)uploadControlInfoService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)uploadControlInfoService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (uploadControlInfoService != null)
      ((javax.xml.rpc.Stub)uploadControlInfoService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public gov.ccm.netbar.interfaceImp.controlInfo.UploadControlInfoService getUploadControlInfoService() {
    if (uploadControlInfoService == null)
      _initUploadControlInfoServiceProxy();
    return uploadControlInfoService;
  }
  
  public java.lang.String sendCustomerOnlineInfo(java.lang.String key, gov.ccm.netbar.interfaceImp.controlInfo.CustomerOnlineInfo[] customerOnlineInfo) throws java.rmi.RemoteException{
    if (uploadControlInfoService == null)
      _initUploadControlInfoServiceProxy();
    return uploadControlInfoService.sendCustomerOnlineInfo(key, customerOnlineInfo);
  }
  
  public java.lang.String sendExigencyInfo(java.lang.String key, gov.ccm.netbar.interfaceImp.controlInfo.ExigencyInfo[] exigencyInfo) throws java.rmi.RemoteException{
    if (uploadControlInfoService == null)
      _initUploadControlInfoServiceProxy();
    return uploadControlInfoService.sendExigencyInfo(key, exigencyInfo);
  }
  
  public java.lang.String sendOnlineTimeInfo(java.lang.String key, gov.ccm.netbar.interfaceImp.controlInfo.OnlineTimeTipInfo[] onlineTimeInfo) throws java.rmi.RemoteException{
    if (uploadControlInfoService == null)
      _initUploadControlInfoServiceProxy();
    return uploadControlInfoService.sendOnlineTimeInfo(key, onlineTimeInfo);
  }
  
  public java.lang.String sendCustomerInfo(java.lang.String key, gov.ccm.netbar.interfaceImp.controlInfo.CustomerBaseInfo[] customerInfo) throws java.rmi.RemoteException{
    if (uploadControlInfoService == null)
      _initUploadControlInfoServiceProxy();
    return uploadControlInfoService.sendCustomerInfo(key, customerInfo);
  }
  
  
}