/**
 * NetbarInfoService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.ccm.netbar.interfaceImp.placeInfo;

public interface NetbarInfoService extends javax.xml.rpc.Service {
    public java.lang.String getNetbarInfoPortAddress();

    public gov.ccm.netbar.interfaceImp.placeInfo.NetbarInfo getNetbarInfoPort() throws javax.xml.rpc.ServiceException;

    public gov.ccm.netbar.interfaceImp.placeInfo.NetbarInfo getNetbarInfoPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
