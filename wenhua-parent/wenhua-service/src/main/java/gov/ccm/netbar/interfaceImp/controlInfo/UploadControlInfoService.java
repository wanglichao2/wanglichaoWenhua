/**
 * UploadControlInfoService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.ccm.netbar.interfaceImp.controlInfo;

public interface UploadControlInfoService extends java.rmi.Remote {
    public java.lang.String sendCustomerOnlineInfo(java.lang.String key, gov.ccm.netbar.interfaceImp.controlInfo.CustomerOnlineInfo[] customerOnlineInfo) throws java.rmi.RemoteException;
    public java.lang.String sendExigencyInfo(java.lang.String key, gov.ccm.netbar.interfaceImp.controlInfo.ExigencyInfo[] exigencyInfo) throws java.rmi.RemoteException;
    public java.lang.String sendOnlineTimeInfo(java.lang.String key, gov.ccm.netbar.interfaceImp.controlInfo.OnlineTimeTipInfo[] onlineTimeInfo) throws java.rmi.RemoteException;
    public java.lang.String sendCustomerInfo(java.lang.String key, gov.ccm.netbar.interfaceImp.controlInfo.CustomerBaseInfo[] customerInfo) throws java.rmi.RemoteException;
}
