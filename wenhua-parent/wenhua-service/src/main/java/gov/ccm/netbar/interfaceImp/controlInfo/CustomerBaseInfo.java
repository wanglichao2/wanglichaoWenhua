/**
 * CustomerBaseInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.ccm.netbar.interfaceImp.controlInfo;

public class CustomerBaseInfo  implements java.io.Serializable {
    private java.lang.String card;

    private java.lang.String cardType;

    private java.lang.String content;

    private java.lang.String customerName;

    private java.lang.String end_time;

    private java.lang.String ip;

    private java.lang.String netbarCode;

    private java.lang.String start_time;

    public CustomerBaseInfo() {
    }

    public CustomerBaseInfo(
           java.lang.String card,
           java.lang.String cardType,
           java.lang.String content,
           java.lang.String customerName,
           java.lang.String end_time,
           java.lang.String ip,
           java.lang.String netbarCode,
           java.lang.String start_time) {
           this.card = card;
           this.cardType = cardType;
           this.content = content;
           this.customerName = customerName;
           this.end_time = end_time;
           this.ip = ip;
           this.netbarCode = netbarCode;
           this.start_time = start_time;
    }


    /**
     * Gets the card value for this CustomerBaseInfo.
     * 
     * @return card
     */
    public java.lang.String getCard() {
        return card;
    }


    /**
     * Sets the card value for this CustomerBaseInfo.
     * 
     * @param card
     */
    public void setCard(java.lang.String card) {
        this.card = card;
    }


    /**
     * Gets the cardType value for this CustomerBaseInfo.
     * 
     * @return cardType
     */
    public java.lang.String getCardType() {
        return cardType;
    }


    /**
     * Sets the cardType value for this CustomerBaseInfo.
     * 
     * @param cardType
     */
    public void setCardType(java.lang.String cardType) {
        this.cardType = cardType;
    }


    /**
     * Gets the content value for this CustomerBaseInfo.
     * 
     * @return content
     */
    public java.lang.String getContent() {
        return content;
    }


    /**
     * Sets the content value for this CustomerBaseInfo.
     * 
     * @param content
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }


    /**
     * Gets the customerName value for this CustomerBaseInfo.
     * 
     * @return customerName
     */
    public java.lang.String getCustomerName() {
        return customerName;
    }


    /**
     * Sets the customerName value for this CustomerBaseInfo.
     * 
     * @param customerName
     */
    public void setCustomerName(java.lang.String customerName) {
        this.customerName = customerName;
    }


    /**
     * Gets the end_time value for this CustomerBaseInfo.
     * 
     * @return end_time
     */
    public java.lang.String getEnd_time() {
        return end_time;
    }


    /**
     * Sets the end_time value for this CustomerBaseInfo.
     * 
     * @param end_time
     */
    public void setEnd_time(java.lang.String end_time) {
        this.end_time = end_time;
    }


    /**
     * Gets the ip value for this CustomerBaseInfo.
     * 
     * @return ip
     */
    public java.lang.String getIp() {
        return ip;
    }


    /**
     * Sets the ip value for this CustomerBaseInfo.
     * 
     * @param ip
     */
    public void setIp(java.lang.String ip) {
        this.ip = ip;
    }


    /**
     * Gets the netbarCode value for this CustomerBaseInfo.
     * 
     * @return netbarCode
     */
    public java.lang.String getNetbarCode() {
        return netbarCode;
    }


    /**
     * Sets the netbarCode value for this CustomerBaseInfo.
     * 
     * @param netbarCode
     */
    public void setNetbarCode(java.lang.String netbarCode) {
        this.netbarCode = netbarCode;
    }


    /**
     * Gets the start_time value for this CustomerBaseInfo.
     * 
     * @return start_time
     */
    public java.lang.String getStart_time() {
        return start_time;
    }


    /**
     * Sets the start_time value for this CustomerBaseInfo.
     * 
     * @param start_time
     */
    public void setStart_time(java.lang.String start_time) {
        this.start_time = start_time;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CustomerBaseInfo)) return false;
        CustomerBaseInfo other = (CustomerBaseInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.card==null && other.getCard()==null) || 
             (this.card!=null &&
              this.card.equals(other.getCard()))) &&
            ((this.cardType==null && other.getCardType()==null) || 
             (this.cardType!=null &&
              this.cardType.equals(other.getCardType()))) &&
            ((this.content==null && other.getContent()==null) || 
             (this.content!=null &&
              this.content.equals(other.getContent()))) &&
            ((this.customerName==null && other.getCustomerName()==null) || 
             (this.customerName!=null &&
              this.customerName.equals(other.getCustomerName()))) &&
            ((this.end_time==null && other.getEnd_time()==null) || 
             (this.end_time!=null &&
              this.end_time.equals(other.getEnd_time()))) &&
            ((this.ip==null && other.getIp()==null) || 
             (this.ip!=null &&
              this.ip.equals(other.getIp()))) &&
            ((this.netbarCode==null && other.getNetbarCode()==null) || 
             (this.netbarCode!=null &&
              this.netbarCode.equals(other.getNetbarCode()))) &&
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
        if (getCard() != null) {
            _hashCode += getCard().hashCode();
        }
        if (getCardType() != null) {
            _hashCode += getCardType().hashCode();
        }
        if (getContent() != null) {
            _hashCode += getContent().hashCode();
        }
        if (getCustomerName() != null) {
            _hashCode += getCustomerName().hashCode();
        }
        if (getEnd_time() != null) {
            _hashCode += getEnd_time().hashCode();
        }
        if (getIp() != null) {
            _hashCode += getIp().hashCode();
        }
        if (getNetbarCode() != null) {
            _hashCode += getNetbarCode().hashCode();
        }
        if (getStart_time() != null) {
            _hashCode += getStart_time().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomerBaseInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://controlInfo.interfaceImp.netbar.ccm.gov/", "customerBaseInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("card");
        elemField.setXmlName(new javax.xml.namespace.QName("", "card"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cardType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("content");
        elemField.setXmlName(new javax.xml.namespace.QName("", "content"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customerName"));
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
        elemField.setFieldName("ip");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ip"));
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
