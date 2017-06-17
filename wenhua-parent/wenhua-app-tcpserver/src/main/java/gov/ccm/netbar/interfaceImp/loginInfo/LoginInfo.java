/**
 * LoginInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.ccm.netbar.interfaceImp.loginInfo;

public interface LoginInfo extends java.rmi.Remote {
    public java.lang.String login(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String logout(java.lang.String key) throws java.rmi.RemoteException;
    public java.lang.String modifyPassword(java.lang.String key, java.lang.String password, java.lang.String newPassword) throws java.rmi.RemoteException;
}
