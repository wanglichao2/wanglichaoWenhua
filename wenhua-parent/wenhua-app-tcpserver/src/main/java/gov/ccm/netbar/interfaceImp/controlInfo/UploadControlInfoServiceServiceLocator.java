/**
 * UploadControlInfoServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.ccm.netbar.interfaceImp.controlInfo;

public class UploadControlInfoServiceServiceLocator extends org.apache.axis.client.Service implements gov.ccm.netbar.interfaceImp.controlInfo.UploadControlInfoServiceService {

    public UploadControlInfoServiceServiceLocator() {
    }


    public UploadControlInfoServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public UploadControlInfoServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for UploadControlInfoServicePort
    private java.lang.String UploadControlInfoServicePort_address = "http://192.168.70.40:8080/netbar/services/ControlInfo";

    public java.lang.String getUploadControlInfoServicePortAddress() {
        return UploadControlInfoServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String UploadControlInfoServicePortWSDDServiceName = "UploadControlInfoServicePort";

    public java.lang.String getUploadControlInfoServicePortWSDDServiceName() {
        return UploadControlInfoServicePortWSDDServiceName;
    }

    public void setUploadControlInfoServicePortWSDDServiceName(java.lang.String name) {
        UploadControlInfoServicePortWSDDServiceName = name;
    }

    public gov.ccm.netbar.interfaceImp.controlInfo.UploadControlInfoService getUploadControlInfoServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(UploadControlInfoServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getUploadControlInfoServicePort(endpoint);
    }

    public gov.ccm.netbar.interfaceImp.controlInfo.UploadControlInfoService getUploadControlInfoServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            gov.ccm.netbar.interfaceImp.controlInfo.UploadControlInfoServiceServiceSoapBindingStub _stub = new gov.ccm.netbar.interfaceImp.controlInfo.UploadControlInfoServiceServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getUploadControlInfoServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setUploadControlInfoServicePortEndpointAddress(java.lang.String address) {
        UploadControlInfoServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (gov.ccm.netbar.interfaceImp.controlInfo.UploadControlInfoService.class.isAssignableFrom(serviceEndpointInterface)) {
                gov.ccm.netbar.interfaceImp.controlInfo.UploadControlInfoServiceServiceSoapBindingStub _stub = new gov.ccm.netbar.interfaceImp.controlInfo.UploadControlInfoServiceServiceSoapBindingStub(new java.net.URL(UploadControlInfoServicePort_address), this);
                _stub.setPortName(getUploadControlInfoServicePortWSDDServiceName());
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
        if ("UploadControlInfoServicePort".equals(inputPortName)) {
            return getUploadControlInfoServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://controlInfo.interfaceImp.netbar.ccm.gov/", "UploadControlInfoServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://controlInfo.interfaceImp.netbar.ccm.gov/", "UploadControlInfoServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("UploadControlInfoServicePort".equals(portName)) {
            setUploadControlInfoServicePortEndpointAddress(address);
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
