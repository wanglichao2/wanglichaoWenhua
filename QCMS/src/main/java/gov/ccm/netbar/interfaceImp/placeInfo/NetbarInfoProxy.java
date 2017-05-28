package gov.ccm.netbar.interfaceImp.placeInfo;

public class NetbarInfoProxy implements gov.ccm.netbar.interfaceImp.placeInfo.NetbarInfo {
  private String _endpoint = null;
  private gov.ccm.netbar.interfaceImp.placeInfo.NetbarInfo netbarInfo = null;
  
  public NetbarInfoProxy() {
    _initNetbarInfoProxy();
  }
  
  public NetbarInfoProxy(String endpoint) {
    _endpoint = endpoint;
    _initNetbarInfoProxy();
  }
  
  private void _initNetbarInfoProxy() {
    try {
      netbarInfo = (new gov.ccm.netbar.interfaceImp.placeInfo.NetbarInfoServiceLocator()).getNetbarInfoPort();
      if (netbarInfo != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)netbarInfo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)netbarInfo)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (netbarInfo != null)
      ((javax.xml.rpc.Stub)netbarInfo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public gov.ccm.netbar.interfaceImp.placeInfo.NetbarInfo getNetbarInfo() {
    if (netbarInfo == null)
      _initNetbarInfoProxy();
    return netbarInfo;
  }
  
  public java.lang.String uploadNetbarInfo(java.lang.String key, gov.ccm.netbar.interfaceImp.placeInfo.RelationshipNetbar[] relationship) throws java.rmi.RemoteException{
    if (netbarInfo == null)
      _initNetbarInfoProxy();
    return netbarInfo.uploadNetbarInfo(key, relationship);
  }
  
  public gov.ccm.netbar.interfaceImp.placeInfo.PunishiInfo[] downloadLawInfo(java.lang.String key, java.lang.String download_date) throws java.rmi.RemoteException{
    if (netbarInfo == null)
      _initNetbarInfoProxy();
    return netbarInfo.downloadLawInfo(key, download_date);
  }
  
  public gov.ccm.netbar.interfaceImp.placeInfo.NetbarBaseInfo[] downloadNetbarInfo(java.lang.String key, java.lang.String download_date) throws java.rmi.RemoteException{
    if (netbarInfo == null)
      _initNetbarInfoProxy();
    return netbarInfo.downloadNetbarInfo(key, download_date);
  }
  
  public java.lang.String uploadCloseInfo(java.lang.String key, gov.ccm.netbar.interfaceImp.placeInfo.CloseNetbarInfo[] closesinfos) throws java.rmi.RemoteException{
    if (netbarInfo == null)
      _initNetbarInfoProxy();
    return netbarInfo.uploadCloseInfo(key, closesinfos);
  }
  
  
}