/**
 * CloseNetbarInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.ccm.netbar.interfaceImp.placeInfo;

public class CloseNetbarInfo  implements java.io.Serializable {
    private java.lang.String close_reason;

    private java.lang.String close_status;

    private java.lang.String end_time;

    private java.lang.String main_id;

    private java.lang.String netbar_code;

    private java.lang.String start_time;

    public CloseNetbarInfo() {
    }

    public CloseNetbarInfo(
           java.lang.String close_reason,
           java.lang.String close_status,
           java.lang.String end_time,
           java.lang.String main_id,
           java.lang.String netbar_code,
           java.lang.String start_time) {
           this.close_reason = close_reason;
           this.close_status = close_status;
           this.end_time = end_time;
           this.main_id = main_id;
           this.netbar_code = netbar_code;
           this.start_time = start_time;
    }


    /**
     * Gets the close_reason value for this CloseNetbarInfo.
     * 
     * @return close_reason
     */
    public java.lang.String getClose_reason() {
        return close_reason;
    }


    /**
     * Sets the close_reason value for this CloseNetbarInfo.
     * 
     * @param close_reason
     */
    public void setClose_reason(java.lang.String close_reason) {
        this.close_reason = close_reason;
    }


    /**
     * Gets the close_status value for this CloseNetbarInfo.
     * 
     * @return close_status
     */
    public java.lang.String getClose_status() {
        return close_status;
    }


    /**
     * Sets the close_status value for this CloseNetbarInfo.
     * 
     * @param close_status
     */
    public void setClose_status(java.lang.String close_status) {
        this.close_status = close_status;
    }


    /**
     * Gets the end_time value for this CloseNetbarInfo.
     * 
     * @return end_time
     */
    public java.lang.String getEnd_time() {
        return end_time;
    }


    /**
     * Sets the end_time value for this CloseNetbarInfo.
     * 
     * @param end_time
     */
    public void setEnd_time(java.lang.String end_time) {
        this.end_time = end_time;
    }


    /**
     * Gets the main_id value for this CloseNetbarInfo.
     * 
     * @return main_id
     */
    public java.lang.String getMain_id() {
        return main_id;
    }


    /**
     * Sets the main_id value for this CloseNetbarInfo.
     * 
     * @param main_id
     */
    public void setMain_id(java.lang.String main_id) {
        this.main_id = main_id;
    }


    /**
     * Gets the netbar_code value for this CloseNetbarInfo.
     * 
     * @return netbar_code
     */
    public java.lang.String getNetbar_code() {
        return netbar_code;
    }


    /**
     * Sets the netbar_code value for this CloseNetbarInfo.
     * 
     * @param netbar_code
     */
    public void setNetbar_code(java.lang.String netbar_code) {
        this.netbar_code = netbar_code;
    }


    /**
     * Gets the start_time value for this CloseNetbarInfo.
     * 
     * @return start_time
     */
    public java.lang.String getStart_time() {
        return start_time;
    }


    /**
     * Sets the start_time value for this CloseNetbarInfo.
     * 
     * @param start_time
     */
    public void setStart_time(java.lang.String start_time) {
        this.start_time = start_time;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CloseNetbarInfo)) return false;
        CloseNetbarInfo other = (CloseNetbarInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.close_reason==null && other.getClose_reason()==null) || 
             (this.close_reason!=null &&
              this.close_reason.equals(other.getClose_reason()))) &&
            ((this.close_status==null && other.getClose_status()==null) || 
             (this.close_status!=null &&
              this.close_status.equals(other.getClose_status()))) &&
            ((this.end_time==null && other.getEnd_time()==null) || 
             (this.end_time!=null &&
              this.end_time.equals(other.getEnd_time()))) &&
            ((this.main_id==null && other.getMain_id()==null) || 
             (this.main_id!=null &&
              this.main_id.equals(other.getMain_id()))) &&
            ((this.netbar_code==null && other.getNetbar_code()==null) || 
             (this.netbar_code!=null &&
              this.netbar_code.equals(other.getNetbar_code()))) &&
            ((this.start_time==null && other.getStart_time()==null) || 
             (this.start_time!=null &&
              this.start_time.equals(other.getStart_time())));
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
        if (getClose_reason() != null) {
            _hashCode += getClose_reason().hashCode();
        }
        if (getClose_status() != null) {
            _hashCode += getClose_status().hashCode();
        }
        if (getEnd_time() != null) {
            _hashCode += getEnd_time().hashCode();
        }
        if (getMain_id() != null) {
            _hashCode += getMain_id().hashCode();
        }
        if (getNetbar_code() != null) {
            _hashCode += getNetbar_code().hashCode();
        }
        if (getStart_time() != null) {
            _hashCode += getStart_time().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CloseNetbarInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://placeInfo.interfaceImp.netbar.ccm.gov/", "closeNetbarInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("close_reason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "close_reason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("close_status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "close_status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("end_time");
        elemField.setXmlName(new javax.xml.namespace.QName("", "end_time"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("main_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "main_id"));
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
        elemField.setFieldName("start_time");
        elemField.setXmlName(new javax.xml.namespace.QName("", "start_time"));
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
