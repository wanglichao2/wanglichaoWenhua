package gov.ccm.netbar.interfaceImp.deployInfo;

public class UploadDeployInfoServiceProxy implements gov.ccm.netbar.interfaceImp.deployInfo.UploadDeployInfoService {
  private String _endpoint = null;
  private gov.ccm.netbar.interfaceImp.deployInfo.UploadDeployInfoService uploadDeployInfoService = null;
  
  public UploadDeployInfoServiceProxy() {
    _initUploadDeployInfoServiceProxy();
  }
  
  public UploadDeployInfoServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initUploadDeployInfoServiceProxy();
  }
  
  private void _initUploadDeployInfoServiceProxy() {
    try {
      uploadDeployInfoService = (new gov.ccm.netbar.interfaceImp.deployInfo.UploadDeployInfoServiceServiceLocator()).getUploadDeployInfoServicePort();
      if (uploadDeployInfoService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)uploadDeployInfoService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)uploadDeployInfoService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (uploadDeployInfoService != null)
      ((javax.xml.rpc.Stub)uploadDeployInfoService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public gov.ccm.netbar.interfaceImp.deployInfo.UploadDeployInfoService getUploadDeployInfoService() {
    if (uploadDeployInfoService == null)
      _initUploadDeployInfoServiceProxy();
    return uploadDeployInfoService;
  }
  
  public java.lang.String setDeployInfo(java.lang.String key, gov.ccm.netbar.interfaceImp.deployInfo.NetbarDeployInfo[] deployInfo) throws java.rmi.RemoteException{
    if (uploadDeployInfoService == null)
      _initUploadDeployInfoServiceProxy();
    return uploadDeployInfoService.setDeployInfo(key, deployInfo);
  }
  
  
}