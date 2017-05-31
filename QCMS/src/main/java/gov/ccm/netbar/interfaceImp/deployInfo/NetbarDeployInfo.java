/**
 * NetbarDeployInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.ccm.netbar.interfaceImp.deployInfo;

public class NetbarDeployInfo  implements java.io.Serializable {
    private java.lang.String detectNum;

    private java.lang.String installNum;

    private java.lang.String is_deploy;

    private java.lang.String netbarCode;

    private java.lang.String onlineNum;

    private java.lang.String reportTime;

    public NetbarDeployInfo() {
    }

    public NetbarDeployInfo(
           java.lang.String detectNum,
           java.lang.String installNum,
           java.lang.String is_deploy,
           java.lang.String netbarCode,
           java.lang.String onlineNum,
           java.lang.String reportTime) {
           this.detectNum = detectNum;
           this.installNum = installNum;
           this.is_deploy = is_deploy;
           this.netbarCode = netbarCode;
           this.onlineNum = onlineNum;
           this.reportTime = reportTime;
    }


    /**
     * Gets the detectNum value for this NetbarDeployInfo.
     * 
     * @return detectNum
     */
    public java.lang.String getDetectNum() {
        return detectNum;
    }


    /**
     * Sets the detectNum value for this NetbarDeployInfo.
     * 
     * @param detectNum
     */
    public void setDetectNum(java.lang.String detectNum) {
        this.detectNum = detectNum;
    }


    /**
     * Gets the installNum value for this NetbarDeployInfo.
     * 
     * @return installNum
     */
    public java.lang.String getInstallNum() {
        return installNum;
    }


    /**
     * Sets the installNum value for this NetbarDeployInfo.
     * 
     * @param installNum
     */
    public void setInstallNum(java.lang.String installNum) {
        this.installNum = installNum;
    }


    /**
     * Gets the is_deploy value for this NetbarDeployInfo.
     * 
     * @return is_deploy
     */
    public java.lang.String getIs_deploy() {
        return is_deploy;
    }


    /**
     * Sets the is_deploy value for this NetbarDeployInfo.
     * 
     * @param is_deploy
     */
    public void setIs_deploy(java.lang.String is_deploy) {
        this.is_deploy = is_deploy;
    }


    /**
     * Gets the netbarCode value for this NetbarDeployInfo.
     * 
     * @return netbarCode
     */
    public java.lang.String getNetbarCode() {
        return netbarCode;
    }


    /**
     * Sets the netbarCode value for this NetbarDeployInfo.
     * 
     * @param netbarCode
     */
    public void setNetbarCode(java.lang.String netbarCode) {
        this.netbarCode = netbarCode;
    }


    /**
     * Gets the onlineNum value for this NetbarDeployInfo.
     * 
     * @return onlineNum
     */
    public java.lang.String getOnlineNum() {
        return onlineNum;
    }


    /**
     * Sets the onlineNum value for this NetbarDeployInfo.
     * 
     * @param onlineNum
     */
    public void setOnlineNum(java.lang.String onlineNum) {
        this.onlineNum = onlineNum;
    }


    /**
     * Gets the reportTime value for this NetbarDeployInfo.
     * 
     * @return reportTime
     */
    public java.lang.String getReportTime() {
        return reportTime;
    }


    /**
     * Sets the reportTime value for this NetbarDeployInfo.
     * 
     * @param reportTime
     */
    public void setReportTime(java.lang.String reportTime) {
        this.reportTime = reportTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NetbarDeployInfo)) return false;
        NetbarDeployInfo other = (NetbarDeployInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.detectNum==null && other.getDetectNum()==null) || 
             (this.detectNum!=null &&
              this.detectNum.equals(other.getDetectNum()))) &&
            ((this.installNum==null && other.getInstallNum()==null) || 
             (this.installNum!=null &&
              this.installNum.equals(other.getInstallNum()))) &&
            ((this.is_deploy==null && other.getIs_deploy()==null) || 
             (this.is_deploy!=null &&
              this.is_deploy.equals(other.getIs_deploy()))) &&
            ((this.netbarCode==null && other.getNetbarCode()==null) || 
             (this.netbarCode!=null &&
              this.netbarCode.equals(other.getNetbarCode()))) &&
            ((this.onlineNum==null && other.getOnlineNum()==null) || 
             (this.onlineNum!=null &&
              this.onlineNum.equals(other.getOnlineNum()))) &&
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
        if (getDetectNum() != null) {
            _hashCode += getDetectNum().hashCode();
        }
        if (getInstallNum() != null) {
            _hashCode += getInstallNum().hashCode();
        }
        if (getIs_deploy() != null) {
            _hashCode += getIs_deploy().hashCode();
        }
        if (getNetbarCode() != null) {
            _hashCode += getNetbarCode().hashCode();
        }
        if (getOnlineNum() != null) {
            _hashCode += getOnlineNum().hashCode();
        }
        if (getReportTime() != null) {
            _hashCode += getReportTime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NetbarDeployInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://deployInfo.interfaceImp.netbar.ccm.gov/", "netbarDeployInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("detectNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "detectNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("installNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "installNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("is_deploy");
        elemField.setXmlName(new javax.xml.namespace.QName("", "is_deploy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("netbarCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "netbarCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("onlineNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "onlineNum"));
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
