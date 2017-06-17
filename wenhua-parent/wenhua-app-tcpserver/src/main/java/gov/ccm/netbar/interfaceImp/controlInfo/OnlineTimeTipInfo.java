/**
 * OnlineTimeTipInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.ccm.netbar.interfaceImp.controlInfo;

public class OnlineTimeTipInfo  implements java.io.Serializable {
    private java.lang.String netbarCode;

    private java.lang.String reportTime;

    private java.lang.String warnNum;

    private java.lang.String warnType;

    public OnlineTimeTipInfo() {
    }

    public OnlineTimeTipInfo(
           java.lang.String netbarCode,
           java.lang.String reportTime,
           java.lang.String warnNum,
           java.lang.String warnType) {
           this.netbarCode = netbarCode;
           this.reportTime = reportTime;
           this.warnNum = warnNum;
           this.warnType = warnType;
    }


    /**
     * Gets the netbarCode value for this OnlineTimeTipInfo.
     * 
     * @return netbarCode
     */
    public java.lang.String getNetbarCode() {
        return netbarCode;
    }


    /**
     * Sets the netbarCode value for this OnlineTimeTipInfo.
     * 
     * @param netbarCode
     */
    public void setNetbarCode(java.lang.String netbarCode) {
        this.netbarCode = netbarCode;
    }


    /**
     * Gets the reportTime value for this OnlineTimeTipInfo.
     * 
     * @return reportTime
     */
    public java.lang.String getReportTime() {
        return reportTime;
    }


    /**
     * Sets the reportTime value for this OnlineTimeTipInfo.
     * 
     * @param reportTime
     */
    public void setReportTime(java.lang.String reportTime) {
        this.reportTime = reportTime;
    }


    /**
     * Gets the warnNum value for this OnlineTimeTipInfo.
     * 
     * @return warnNum
     */
    public java.lang.String getWarnNum() {
        return warnNum;
    }


    /**
     * Sets the warnNum value for this OnlineTimeTipInfo.
     * 
     * @param warnNum
     */
    public void setWarnNum(java.lang.String warnNum) {
        this.warnNum = warnNum;
    }


    /**
     * Gets the warnType value for this OnlineTimeTipInfo.
     * 
     * @return warnType
     */
    public java.lang.String getWarnType() {
        return warnType;
    }


    /**
     * Sets the warnType value for this OnlineTimeTipInfo.
     * 
     * @param warnType
     */
    public void setWarnType(java.lang.String warnType) {
        this.warnType = warnType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OnlineTimeTipInfo)) return false;
        OnlineTimeTipInfo other = (OnlineTimeTipInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.netbarCode==null && other.getNetbarCode()==null) || 
             (this.netbarCode!=null &&
              this.netbarCode.equals(other.getNetbarCode()))) &&
            ((this.reportTime==null && other.getReportTime()==null) || 
             (this.reportTime!=null &&
              this.reportTime.equals(other.getReportTime()))) &&
            ((this.warnNum==null && other.getWarnNum()==null) || 
             (this.warnNum!=null &&
              this.warnNum.equals(other.getWarnNum()))) &&
            ((this.warnType==null && other.getWarnType()==null) || 
             (this.warnType!=null &&
              this.warnType.equals(other.getWarnType())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getNetbarCode() != null) {
            _hashCode += getNetbarCode().hashCode();
        }
        if (getReportTime() != null) {
            _hashCode += getReportTime().hashCode();
        }
        if (getWarnNum() != null) {
            _hashCode += getWarnNum().hashCode();
        }
        if (getWarnType() != null) {
            _hashCode += getWarnType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OnlineTimeTipInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://controlInfo.interfaceImp.netbar.ccm.gov/", "onlineTimeTipInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("netbarCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "netbarCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reportTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reportTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("warnNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "warnNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("warnType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "warnType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
