/**
 * LoginInfoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.ccm.netbar.interfaceImp.loginInfo;

public class LoginInfoServiceLocator extends org.apache.axis.client.Service implements gov.ccm.netbar.interfaceImp.loginInfo.LoginInfoService {

    public LoginInfoServiceLocator() {
    }


    public LoginInfoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LoginInfoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for LoginInfoPort
    private java.lang.String LoginInfoPort_address = "http://192.168.70.39:8080/netbar/services/loginInfo";

    public java.lang.String getLoginInfoPortAddress() {
        return LoginInfoPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String LoginInfoPortWSDDServiceName = "LoginInfoPort";

    public java.lang.String getLoginInfoPortWSDDServiceName() {
        return LoginInfoPortWSDDServiceName;
    }

    public void setLoginInfoPortWSDDServiceName(java.lang.String name) {
        LoginInfoPortWSDDServiceName = name;
    }

    public gov.ccm.netbar.interfaceImp.loginInfo.LoginInfo getLoginInfoPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(LoginInfoPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLoginInfoPort(endpoint);
    }

    public gov.ccm.netbar.interfaceImp.loginInfo.LoginInfo getLoginInfoPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            gov.ccm.netbar.interfaceImp.loginInfo.LoginInfoServiceSoapBindingStub _stub = new gov.ccm.netbar.interfaceImp.loginInfo.LoginInfoServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getLoginInfoPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLoginInfoPortEndpointAddress(java.lang.String address) {
        LoginInfoPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (gov.ccm.netbar.interfaceImp.loginInfo.LoginInfo.class.isAssignableFrom(serviceEndpointInterface)) {
                gov.ccm.netbar.interfaceImp.loginInfo.LoginInfoServiceSoapBindingStub _stub = new gov.ccm.netbar.interfaceImp.loginInfo.LoginInfoServiceSoapBindingStub(new java.net.URL(LoginInfoPort_address), this);
                _stub.setPortName(getLoginInfoPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("LoginInfoPort".equals(inputPortName)) {
            return getLoginInfoPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://loginInfo.interfaceImp.netbar.ccm.gov/", "LoginInfoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://loginInfo.interfaceImp.netbar.ccm.gov/", "LoginInfoPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("LoginInfoPort".equals(portName)) {
            setLoginInfoPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
