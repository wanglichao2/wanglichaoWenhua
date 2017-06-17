/**
 * LoginInfoService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.ccm.netbar.interfaceImp.loginInfo;

public interface LoginInfoService extends javax.xml.rpc.Service {
    public java.lang.String getLoginInfoPortAddress();

    public gov.ccm.netbar.interfaceImp.loginInfo.LoginInfo getLoginInfoPort() throws javax.xml.rpc.ServiceException;

    public gov.ccm.netbar.interfaceImp.loginInfo.LoginInfo getLoginInfoPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
