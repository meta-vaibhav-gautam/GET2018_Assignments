package com.metacube.EAD_Session;

public class AreaProxy implements com.metacube.EAD_Session.Area {
  private String _endpoint = null;
  private com.metacube.EAD_Session.Area area = null;
  
  public AreaProxy() {
    _initAreaProxy();
  }
  
  public AreaProxy(String endpoint) {
    _endpoint = endpoint;
    _initAreaProxy();
  }
  
  private void _initAreaProxy() {
    try {
      area = (new com.metacube.EAD_Session.AreaServiceLocator()).getArea();
      if (area != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)area)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)area)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (area != null)
      ((javax.xml.rpc.Stub)area)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.metacube.EAD_Session.Area getArea() {
    if (area == null)
      _initAreaProxy();
    return area;
  }
  
  public double getTriangleArea(int side1, int side2, int side3) throws java.rmi.RemoteException{
    if (area == null)
      _initAreaProxy();
    return area.getTriangleArea(side1, side2, side3);
  }
  
  
}