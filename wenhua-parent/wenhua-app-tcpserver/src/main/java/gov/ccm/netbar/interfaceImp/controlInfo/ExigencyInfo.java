/**
 * ExigencyInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.ccm.netbar.interfaceImp.controlInfo;

public class ExigencyInfo  implements java.io.Serializable {
    private java.lang.String exigencyNum;

    private java.lang.String netbar_code;

    private java.lang.String reportTime;

    public ExigencyInfo() {
    }

    public ExigencyInfo(
           java.lang.String exigencyNum,
           java.lang.String netbar_code,
           java.lang.String reportTime) {
           this.exigencyNum = exigencyNum;
           this.netbar_code = netbar_code;
           this.reportTime = reportTime;
    }


    /**
     * Gets the exigencyNum value for this ExigencyInfo.
     * 
     * @return exigencyNum
     */
    public java.lang.String getExigencyNum() {
        return exigencyNum;
    }


    /**
     * Sets the exigencyNum value for this ExigencyInfo.
     * 
     * @param exigencyNum
     */
    public void setExigencyNum(java.lang.String exigencyNum) {
        this.exigencyNum = exigencyNum;
    }


    /**
     * Gets the netbar_code value for this ExigencyInfo.
     * 
     * @return netbar_code
     */
    public java.lang.String getNetbar_code() {
        return netbar_code;
    }


    /**
     * Sets the netbar_code value for this ExigencyInfo.
     * 
     * @param netbar_code
     */
    public void setNetbar_code(java.lang.String netbar_code) {
        this.netbar_code = netbar_code;
    }


    /**
     * Gets the reportTime value for this ExigencyInfo.
     * 
     * @return reportTime
     */
    public java.lang.String getReportTime() {
        return reportTime;
    }


    /**
     * Sets the reportTime value for this ExigencyInfo.
     * 
     * @param reportTime
     */
    public void setReportTime(java.lang.String reportTime) {
        this.reportTime = reportTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExigencyInfo)) return false;
        ExigencyInfo other = (ExigencyInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.exigencyNum==null && other.getExigencyNum()==null) || 
             (this.exigencyNum!=null &&
              this.exigencyNum.equals(other.getExigencyNum()))) &&
            ((this.netbar_code==null && other.getNetbar_code()==null) || 
             (this.netbar_code!=null &&
              this.netbar_code.equals(other.getNetbar_code()))) &&
            ((this.reportTime==null && other.getReportTime()==null) || 
             (this.reportTime!=null &&
              this.reportTime.equals(other.getReportTime())));
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
        if (getExigencyNum() != null) {
            _hashCode += getExigencyNum().hashCode();
        }
        if (getNetbar_code() != null) {
            _hashCode += getNetbar_code().hashCode();
        }
        if (getReportTime() != null) {
            _hashCode += getReportTime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExigencyInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://controlInfo.interfaceImp.netbar.ccm.gov/", "exigencyInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exigencyNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "exigencyNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("netbar_code");
        elemField.setXmlName(new javax.xml.namespace.QName("", "netbar_code"));
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
