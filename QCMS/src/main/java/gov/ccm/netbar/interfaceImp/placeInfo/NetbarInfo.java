/**
 * NetbarInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.ccm.netbar.interfaceImp.placeInfo;

public interface NetbarInfo extends java.rmi.Remote {
    public java.lang.String uploadNetbarInfo(java.lang.String key, gov.ccm.netbar.interfaceImp.placeInfo.RelationshipNetbar[] relationship) throws java.rmi.RemoteException;
    public gov.ccm.netbar.interfaceImp.placeInfo.PunishiInfo[] downloadLawInfo(java.lang.String key, java.lang.String download_date) throws java.rmi.RemoteException;
    public gov.ccm.netbar.interfaceImp.placeInfo.NetbarBaseInfo[] downloadNetbarInfo(java.lang.String key, java.lang.String download_date) throws java.rmi.RemoteException;
    public java.lang.String uploadCloseInfo(java.lang.String key, gov.ccm.netbar.interfaceImp.placeInfo.CloseNetbarInfo[] closesinfos) throws java.rmi.RemoteException;
}
