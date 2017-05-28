/**
 * RelationshipNetbar.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.ccm.netbar.interfaceImp.placeInfo;

public class RelationshipNetbar  implements java.io.Serializable {
    private java.lang.String district_code;

    private java.lang.String legalname;

    private java.lang.String main_id;

    private java.lang.String netbar_code;

    private java.lang.String netbar_name;

    private java.lang.String reg_address_detail;

    private java.lang.String report_time;

    public RelationshipNetbar() {
    }

    public RelationshipNetbar(
           java.lang.String district_code,
           java.lang.String legalname,
           java.lang.String main_id,
           java.lang.String netbar_code,
           java.lang.String netbar_name,
           java.lang.String reg_address_detail,
           java.lang.String report_time) {
           this.district_code = district_code;
           this.legalname = legalname;
           this.main_id = main_id;
           this.netbar_code = netbar_code;
           this.netbar_name = netbar_name;
           this.reg_address_detail = reg_address_detail;
           this.report_time = report_time;
    }


    /**
     * Gets the district_code value for this RelationshipNetbar.
     * 
     * @return district_code
     */
    public java.lang.String getDistrict_code() {
        return district_code;
    }


    /**
     * Sets the district_code value for this RelationshipNetbar.
     * 
     * @param district_code
     */
    public void setDistrict_code(java.lang.String district_code) {
        this.district_code = district_code;
    }


    /**
     * Gets the legalname value for this RelationshipNetbar.
     * 
     * @return legalname
     */
    public java.lang.String getLegalname() {
        return legalname;
    }


    /**
     * Sets the legalname value for this RelationshipNetbar.
     * 
     * @param legalname
     */
    public void setLegalname(java.lang.String legalname) {
        this.legalname = legalname;
    }


    /**
     * Gets the main_id value for this RelationshipNetbar.
     * 
     * @return main_id
     */
    public java.lang.String getMain_id() {
        return main_id;
    }


    /**
     * Sets the main_id value for this RelationshipNetbar.
     * 
     * @param main_id
     */
    public void setMain_id(java.lang.String main_id) {
        this.main_id = main_id;
    }


    /**
     * Gets the netbar_code value for this RelationshipNetbar.
     * 
     * @return netbar_code
     */
    public java.lang.String getNetbar_code() {
        return netbar_code;
    }


    /**
     * Sets the netbar_code value for this RelationshipNetbar.
     * 
     * @param netbar_code
     */
    public void setNetbar_code(java.lang.String netbar_code) {
        this.netbar_code = netbar_code;
    }


    /**
     * Gets the netbar_name value for this RelationshipNetbar.
     * 
     * @return netbar_name
     */
    public java.lang.String getNetbar_name() {
        return netbar_name;
    }


    /**
     * Sets the netbar_name value for this RelationshipNetbar.
     * 
     * @param netbar_name
     */
    public void setNetbar_name(java.lang.String netbar_name) {
        this.netbar_name = netbar_name;
    }


    /**
     * Gets the reg_address_detail value for this RelationshipNetbar.
     * 
     * @return reg_address_detail
     */
    public java.lang.String getReg_address_detail() {
        return reg_address_detail;
    }


    /**
     * Sets the reg_address_detail value for this RelationshipNetbar.
     * 
     * @param reg_address_detail
     */
    public void setReg_address_detail(java.lang.String reg_address_detail) {
        this.reg_address_detail = reg_address_detail;
    }


    /**
     * Gets the report_time value for this RelationshipNetbar.
     * 
     * @return report_time
     */
    public java.lang.String getReport_time() {
        return report_time;
    }


    /**
     * Sets the report_time value for this RelationshipNetbar.
     * 
     * @param report_time
     */
    public void setReport_time(java.lang.String report_time) {
        this.report_time = report_time;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RelationshipNetbar)) return false;
        RelationshipNetbar other = (RelationshipNetbar) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.district_code==null && other.getDistrict_code()==null) || 
             (this.district_code!=null &&
              this.district_code.equals(other.getDistrict_code()))) &&
            ((this.legalname==null && other.getLegalname()==null) || 
             (this.legalname!=null &&
              this.legalname.equals(other.getLegalname()))) &&
            ((this.main_id==null && other.getMain_id()==null) || 
             (this.main_id!=null &&
              this.main_id.equals(other.getMain_id()))) &&
            ((this.netbar_code==null && other.getNetbar_code()==null) || 
             (this.netbar_code!=null &&
              this.netbar_code.equals(other.getNetbar_code()))) &&
            ((this.netbar_name==null && other.getNetbar_name()==null) || 
             (this.netbar_name!=null &&
              this.netbar_name.equals(other.getNetbar_name()))) &&
            ((this.reg_address_detail==null && other.getReg_address_detail()==null) || 
             (this.reg_address_detail!=null &&
              this.reg_address_detail.equals(other.getReg_address_detail()))) &&
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
        if (getDistrict_code() != null) {
            _hashCode += getDistrict_code().hashCode();
        }
        if (getLegalname() != null) {
            _hashCode += getLegalname().hashCode();
        }
        if (getMain_id() != null) {
            _hashCode += getMain_id().hashCode();
        }
        if (getNetbar_code() != null) {
            _hashCode += getNetbar_code().hashCode();
        }
        if (getNetbar_name() != null) {
            _hashCode += getNetbar_name().hashCode();
        }
        if (getReg_address_detail() != null) {
            _hashCode += getReg_address_detail().hashCode();
        }
        if (getReport_time() != null) {
            _hashCode += getReport_time().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RelationshipNetbar.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://placeInfo.interfaceImp.netbar.ccm.gov/", "relationshipNetbar"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("district_code");
        elemField.setXmlName(new javax.xml.namespace.QName("", "district_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("legalname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "legalname"));
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
        elemField.setFieldName("netbar_name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "netbar_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reg_address_detail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reg_address_detail"));
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
