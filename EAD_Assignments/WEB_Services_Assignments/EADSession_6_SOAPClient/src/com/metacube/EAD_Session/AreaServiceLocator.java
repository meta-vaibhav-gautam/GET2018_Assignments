/**
 * AreaServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.metacube.EAD_Session;

public class AreaServiceLocator extends org.apache.axis.client.Service implements com.metacube.EAD_Session.AreaService {

    public AreaServiceLocator() {
    }


    public AreaServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AreaServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Area
    private java.lang.String Area_address = "http://localhost:8080/EADSession_6_SOAP/services/Area";

    public java.lang.String getAreaAddress() {
        return Area_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AreaWSDDServiceName = "Area";

    public java.lang.String getAreaWSDDServiceName() {
        return AreaWSDDServiceName;
    }

    public void setAreaWSDDServiceName(java.lang.String name) {
        AreaWSDDServiceName = name;
    }

    public com.metacube.EAD_Session.Area getArea() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Area_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getArea(endpoint);
    }

    public com.metacube.EAD_Session.Area getArea(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.metacube.EAD_Session.AreaSoapBindingStub _stub = new com.metacube.EAD_Session.AreaSoapBindingStub(portAddress, this);
            _stub.setPortName(getAreaWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAreaEndpointAddress(java.lang.String address) {
        Area_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.metacube.EAD_Session.Area.class.isAssignableFrom(serviceEndpointInterface)) {
                com.metacube.EAD_Session.AreaSoapBindingStub _stub = new com.metacube.EAD_Session.AreaSoapBindingStub(new java.net.URL(Area_address), this);
                _stub.setPortName(getAreaWSDDServiceName());
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
        if ("Area".equals(inputPortName)) {
            return getArea();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://EAD_Session.metacube.com", "AreaService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://EAD_Session.metacube.com", "Area"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Area".equals(portName)) {
            setAreaEndpointAddress(address);
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
