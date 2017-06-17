/**
 * CustomerOnlineInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.ccm.netbar.interfaceImp.controlInfo;

public class CustomerOnlineInfo  implements java.io.Serializable {
    private java.lang.String customer_num;

    private java.lang.String netbar_code;

    private java.lang.String report_time;

    public CustomerOnlineInfo() {
    }

    public CustomerOnlineInfo(
           java.lang.String customer_num,
           java.lang.String netbar_code,
           java.lang.String report_time) {
           this.customer_num = customer_num;
           this.netbar_code = netbar_code;
           this.report_time = report_time;
    }


    /**
     * Gets the customer_num value for this CustomerOnlineInfo.
     * 
     * @return customer_num
     */
    public java.lang.String getCustomer_num() {
        return customer_num;
    }


    /**
     * Sets the customer_num value for this CustomerOnlineInfo.
     * 
     * @param customer_num
     */
    public void setCustomer_num(java.lang.String customer_num) {
        this.customer_num = customer_num;
    }


    /**
     * Gets the netbar_code value for this CustomerOnlineInfo.
     * 
     * @return netbar_code
     */
    public java.lang.String getNetbar_code() {
        return netbar_code;
    }


    /**
     * Sets the netbar_code value for this CustomerOnlineInfo.
     * 
     * @param netbar_code
     */
    public void setNetbar_code(java.lang.String netbar_code) {
        this.netbar_code = netbar_code;
    }


    /**
     * Gets the report_time value for this CustomerOnlineInfo.
     * 
     * @return report_time
     */
    public java.lang.String getReport_time() {
        return report_time;
    }


    /**
     * Sets the report_time value for this CustomerOnlineInfo.
     * 
     * @param report_time
     */
    public void setReport_time(java.lang.String report_time) {
        this.report_time = report_time;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CustomerOnlineInfo)) return false;
        CustomerOnlineInfo other = (CustomerOnlineInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.customer_num==null && other.getCustomer_num()==null) || 
             (this.customer_num!=null &&
              this.customer_num.equals(other.getCustomer_num()))) &&
            ((this.netbar_code==null && other.getNetbar_code()==null) || 
             (this.netbar_code!=null &&
              this.netbar_code.equals(other.getNetbar_code()))) &&
            ((this.report_time==null && other.getReport_time()==null) || 
             (this.report_time!=null &&
              this.report_time.equals(other.getReport_time())));
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
        if (getCustomer_num() != null) {
            _hashCode += getCustomer_num().hashCode();
        }
        if (getNetbar_code() != null) {
            _hashCode += getNetbar_code().hashCode();
        }
        if (getReport_time() != null) {
            _hashCode += getReport_time().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomerOnlineInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://controlInfo.interfaceImp.netbar.ccm.gov/", "customerOnlineInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_num");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customer_num"));
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
        elemField.setFieldName("report_time");
        elemField.setXmlName(new javax.xml.namespace.QName("", "report_time"));
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
