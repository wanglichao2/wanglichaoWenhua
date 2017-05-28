/**
 * PunishiInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.ccm.netbar.interfaceImp.placeInfo;

public class PunishiInfo  implements java.io.Serializable {
    private java.lang.String id;

    private java.lang.String main_id;

    private java.lang.String punish_reason;

    private java.lang.String punish_result;

    private java.lang.String punish_time;

    private java.lang.String punish_way;

    private java.lang.String stop_begindate;

    private java.lang.String stop_enddate;

    private java.lang.String update_time;

    public PunishiInfo() {
    }

    public PunishiInfo(
           java.lang.String id,
           java.lang.String main_id,
           java.lang.String punish_reason,
           java.lang.String punish_result,
           java.lang.String punish_time,
           java.lang.String punish_way,
           java.lang.String stop_begindate,
           java.lang.String stop_enddate,
           java.lang.String update_time) {
           this.id = id;
           this.main_id = main_id;
           this.punish_reason = punish_reason;
           this.punish_result = punish_result;
           this.punish_time = punish_time;
           this.punish_way = punish_way;
           this.stop_begindate = stop_begindate;
           this.stop_enddate = stop_enddate;
           this.update_time = update_time;
    }


    /**
     * Gets the id value for this PunishiInfo.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this PunishiInfo.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the main_id value for this PunishiInfo.
     * 
     * @return main_id
     */
    public java.lang.String getMain_id() {
        return main_id;
    }


    /**
     * Sets the main_id value for this PunishiInfo.
     * 
     * @param main_id
     */
    public void setMain_id(java.lang.String main_id) {
        this.main_id = main_id;
    }


    /**
     * Gets the punish_reason value for this PunishiInfo.
     * 
     * @return punish_reason
     */
    public java.lang.String getPunish_reason() {
        return punish_reason;
    }


    /**
     * Sets the punish_reason value for this PunishiInfo.
     * 
     * @param punish_reason
     */
    public void setPunish_reason(java.lang.String punish_reason) {
        this.punish_reason = punish_reason;
    }


    /**
     * Gets the punish_result value for this PunishiInfo.
     * 
     * @return punish_result
     */
    public java.lang.String getPunish_result() {
        return punish_result;
    }


    /**
     * Sets the punish_result value for this PunishiInfo.
     * 
     * @param punish_result
     */
    public void setPunish_result(java.lang.String punish_result) {
        this.punish_result = punish_result;
    }


    /**
     * Gets the punish_time value for this PunishiInfo.
     * 
     * @return punish_time
     */
    public java.lang.String getPunish_time() {
        return punish_time;
    }


    /**
     * Sets the punish_time value for this PunishiInfo.
     * 
     * @param punish_time
     */
    public void setPunish_time(java.lang.String punish_time) {
        this.punish_time = punish_time;
    }


    /**
     * Gets the punish_way value for this PunishiInfo.
     * 
     * @return punish_way
     */
    public java.lang.String getPunish_way() {
        return punish_way;
    }


    /**
     * Sets the punish_way value for this PunishiInfo.
     * 
     * @param punish_way
     */
    public void setPunish_way(java.lang.String punish_way) {
        this.punish_way = punish_way;
    }


    /**
     * Gets the stop_begindate value for this PunishiInfo.
     * 
     * @return stop_begindate
     */
    public java.lang.String getStop_begindate() {
        return stop_begindate;
    }


    /**
     * Sets the stop_begindate value for this PunishiInfo.
     * 
     * @param stop_begindate
     */
    public void setStop_begindate(java.lang.String stop_begindate) {
        this.stop_begindate = stop_begindate;
    }


    /**
     * Gets the stop_enddate value for this PunishiInfo.
     * 
     * @return stop_enddate
     */
    public java.lang.String getStop_enddate() {
        return stop_enddate;
    }


    /**
     * Sets the stop_enddate value for this PunishiInfo.
     * 
     * @param stop_enddate
     */
    public void setStop_enddate(java.lang.String stop_enddate) {
        this.stop_enddate = stop_enddate;
    }


    /**
     * Gets the update_time value for this PunishiInfo.
     * 
     * @return update_time
     */
    public java.lang.String getUpdate_time() {
        return update_time;
    }


    /**
     * Sets the update_time value for this PunishiInfo.
     * 
     * @param update_time
     */
    public void setUpdate_time(java.lang.String update_time) {
        this.update_time = update_time;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PunishiInfo)) return false;
        PunishiInfo other = (PunishiInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.main_id==null && other.getMain_id()==null) || 
             (this.main_id!=null &&
              this.main_id.equals(other.getMain_id()))) &&
            ((this.punish_reason==null && other.getPunish_reason()==null) || 
             (this.punish_reason!=null &&
              this.punish_reason.equals(other.getPunish_reason()))) &&
            ((this.punish_result==null && other.getPunish_result()==null) || 
             (this.punish_result!=null &&
              this.punish_result.equals(other.getPunish_result()))) &&
            ((this.punish_time==null && other.getPunish_time()==null) || 
             (this.punish_time!=null &&
              this.punish_time.equals(other.getPunish_time()))) &&
            ((this.punish_way==null && other.getPunish_way()==null) || 
             (this.punish_way!=null &&
              this.punish_way.equals(other.getPunish_way()))) &&
            ((this.stop_begindate==null && other.getStop_begindate()==null) || 
             (this.stop_begindate!=null &&
              this.stop_begindate.equals(other.getStop_begindate()))) &&
            ((this.stop_enddate==null && other.getStop_enddate()==null) || 
             (this.stop_enddate!=null &&
              this.stop_enddate.equals(other.getStop_enddate()))) &&
            ((this.update_time==null && other.getUpdate_time()==null) || 
             (this.update_time!=null &&
              this.update_time.equals(other.getUpdate_time())));
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getMain_id() != null) {
            _hashCode += getMain_id().hashCode();
        }
        if (getPunish_reason() != null) {
            _hashCode += getPunish_reason().hashCode();
        }
        if (getPunish_result() != null) {
            _hashCode += getPunish_result().hashCode();
        }
        if (getPunish_time() != null) {
            _hashCode += getPunish_time().hashCode();
        }
        if (getPunish_way() != null) {
            _hashCode += getPunish_way().hashCode();
        }
        if (getStop_begindate() != null) {
            _hashCode += getStop_begindate().hashCode();
        }
        if (getStop_enddate() != null) {
            _hashCode += getStop_enddate().hashCode();
        }
        if (getUpdate_time() != null) {
            _hashCode += getUpdate_time().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PunishiInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://placeInfo.interfaceImp.netbar.ccm.gov/", "punishiInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
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
        elemField.setFieldName("punish_reason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "punish_reason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("punish_result");
        elemField.setXmlName(new javax.xml.namespace.QName("", "punish_result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("punish_time");
        elemField.setXmlName(new javax.xml.namespace.QName("", "punish_time"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("punish_way");
        elemField.setXmlName(new javax.xml.namespace.QName("", "punish_way"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stop_begindate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stop_begindate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stop_enddate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stop_enddate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("update_time");
        elemField.setXmlName(new javax.xml.namespace.QName("", "update_time"));
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
