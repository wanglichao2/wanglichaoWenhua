package com.wenhua.util.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.base.Charsets;

import static org.springframework.util.StringUtils.hasText;

/**
 * Ajax 进行一些操作（通常是指添加、删除和修改）时，用于保存返回信息的POJO类。
 * 
 * <pre>
 * JSON 格式：
 * {"status":-1|0|1|2,"message":"消息说明","values":{}}
 * XML 格式：
 * &lt;ajax-result&gt;
 *     &lt;status&gt;-1|0|1|2&lt;/status&gt;
 *     &lt;message&gt;消息&lt;/message&gt;
 *     &lt;values&gt;&lt;![CDATA[
 *     返回的结果的值。
 *     ]]&gt;&lt;/values&gt;
 * &lt;/ajax-result&gt;
 * </pre>
 * 
 * @author fuchun
 * @since 1.0
 * @version $Id: AjaxResult.java 27644 2013-05-13 10:57:55Z C629 $
 */
public class AjaxResult implements Serializable {

    private static final long serialVersionUID = 2149411958552286712L;

    /** Ajax请求完成时返回结果字符串的键名。 */
    public static final String RESULT_KEY = "result";

    /** Ajax请求的JSON数据格式化名称。 */
    public static final String FORMAT_JSON = "json";

    /** Ajax请求的XML数据格式化名称。 */
    public static final String FORMAT_XML = "xml";

    /** Ajax请求的HTML数据格式化名称。 */
    public static final String FORMAT_HTML = "html";

    /** Ajax请求完成时返回的完成标识。 */
    public static final Integer STATUS_COMPLETE = 1;

    /** Ajax请求执行成功时返回的成功标识。 */
    public static final Integer STATUS_SUCCESS = 1;

    /** Ajax请求执行失败时返回的失败标识（通常为数据校验等错误）。 */
    public static final Integer STATUS_FAILURE = 0;

    /** Ajax请求执行发生错误时返回的错误标识（通常为权限校验、数据业务逻辑、数据溢出等错误）。 */
    public static final Integer STATUS_ERROR = -1;

    /** Ajax请求返回的特殊标识，可能会作特定的操作。 */
    public static final Integer STATUS_SPECIAL = -2;

    /** XML 格式的根节点名称。 */
    public static final String XML_ROOT_NODE = "ajax-result";
    /** XML 格式的 {@code status} 节点名称。 */
    public static final String XML_STATUS_NODE = "status";
    /** XML 格式的 {@code message} 节点名称。 */
    public static final String XML_MESSAGE_NODE = "message";
    /** XML 格式的 {@code values} 节点名称。 */
    public static final String XML_VALUES_NODE = "values";

    private static final String XML_DESCRIPTION_FORMAT = "<?xml version=\"1.0\" encoding=\"%s\"?>\n";
    private static final String XML_NOTE_BEGIN_FORMAT = "<%s>";
    private static final String XML_NOTE_END_FORMAT = "</%s>";

    /* Ajax操作返回的状态。 */
    private Integer status;

    /* Ajax操作返回的信息。 */
    private String message;

    /* Ajax操作返回的一组数据。 */
    private Map<String, Object> values;

    /* Ajax操作返回的后续动作名称。 */
    private String action;

    /* Ajax操作返回的需要跳转的视图名称。跳转方式由 action 属性指定。 */
    private String view;

    /**
     * 新构造一个默认的 {@code AjaxResult}。
     */
    public AjaxResult() {
        this(STATUS_ERROR, "", null);
    }

    /**
     * 用给定的属性值(status, message)构造一个新的 {@code AjaxResult}。
     * 
     * @param status 状态信息。参见{@link #STATUS_COMPLETE}、{@link #STATUS_FAILURE}等。
     * @param message 包含的信息。
     */
    protected AjaxResult(Integer status, String message) {
        this(status, message, null);
    }

    /**
     * 用给定的属性值(status, message, values)构造一个新的 {@code AjaxResult}。
     * 
     * @param status 状态信息。参见{@link #STATUS_COMPLETE}、{@link #STATUS_FAILURE}等。
     * @param message 包含的信息。
     * @param values 用于保存需要的值。
     */
    protected AjaxResult(Integer status, String message, Map<String, Object> values) {
        this.status = status;
        this.message = message;
        if (values != null) {
            this.values = new TreeMap<String, Object>(values);
        }
    }

    /** Ajax操作返回的执行状态。 */
    public Integer getStatus() {
        return status;
    }

    /** 设置Ajax操作返回的执行状态。 */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /** Ajax操作返回的主要信息。 */
    public String getMessage() {
        return message;
    }

    /** 设置Ajax操作返回的主要信息。 */
    public void setMessage(String message) {
        this.message = message;
    }

    /** Ajax操作返回的一组数据。 */
    public Map<String, Object> getValues() {
        return values;
    }

    /** 设置Ajax操作返回的一组数据。 */
    public void setValues(Map<String, Object> values) {
        if (values != null) {
            if (this.values != null) {
                this.values.clear();
                this.values.putAll(values);
            } else {
                this.values = new TreeMap<String, Object>(values);
            }
        }
    }

    /**
     * 添加一组 {@code values}。
     * 
     * @param values 要添加的 {@code values}。
     */
    public void addValues(Map<String, Object> values) {
        if (values != null && !values.isEmpty()) {
            if (this.values == null) {
                this.values = new TreeMap<String, Object>(values);
            } else {
                this.values.putAll(values);
            }
        }
    }

    /**
     * 移除指定 {@code key} 的一组 {@code values}。
     * 
     * @param key 要移除的 {@code key}。
     */
    public void removeValue(String key) {
        if (!hasText(key))
            return;
        values.remove(key);
    }

    /**
     * 添加一组 {@code values}。
     * <p />
     * 如果满足 {@code key != null && value == null && values.contains(key)}，相当于调用
     * {@link #removeValue(String) removeValue(key)}。
     * 
     * @param key 添加的键。
     * @param value 添加的值。
     * @throws IllegalArgumentException 如果指定的 {@code key == null}。
     */
    public void addValue(String key, Object value) {
        if (key == null) {
            throw new IllegalArgumentException("The key must not be null or empty.");
        }
        if (values == null && value != null) {
            values = new TreeMap<String, Object>();
        }
        if (values != null && values.containsKey(key)) {
            if (value == null) {
                values.remove(key);
                return;
            }
        }
        values.put(key, value);
    }

    /** 返回Ajax操作返回的后续动作名称。 */
    public String getAction() {
        return action;
    }

    /** 设置Ajax操作返回的后续动作名称。 */
    public void setAction(String action) {
        this.action = action;
    }

    /** 返回Ajax操作返回的需要跳转的视图名称。 */
    public String getView() {
        return view;
    }

    /** 设置Ajax操作返回的需要跳转的视图名称。 */
    public void setView(String view) {
        this.view = view;
    }

    /**
     * 生成此对象的JSON字符串。
     * 
     * @param features 序列化配置。
     * @return 返回此对象的JSON字符串。
     */
    public String toJSONString(SerializerFeature... features) {
        return JSON.toJSONString(this, features);
    }

    /**
     * 生成此对象的JSON数据。
     * 
     * @param features 序列化配置。
     * @return 返回此对象的JSON数据
     */
    public byte[] toJSONBytes(SerializerFeature... features) {
        final List<SerializerFeature> fList = new ArrayList<SerializerFeature>();
        if (features == null || features.length == 0 || features[0] == null) {
            fList.add(SerializerFeature.WriteClassName);
        } else {
            fList.addAll(Arrays.asList(features));
        }
        return JSON.toJSONBytes(this, fList.toArray(new SerializerFeature[fList.size()]));
    }

    public String toXmlString(String... encoding) {
        String charEncoding = null;
        if (encoding == null || encoding.length == 0 || !hasText(encoding[0])) {
            charEncoding = Charsets.UTF_8.displayName();
        } else {
            charEncoding = encoding[0];
        }
        final String xmlDesc = String.format(XML_DESCRIPTION_FORMAT, charEncoding);
        final StringBuilder buf = new StringBuilder(xmlDesc);
        buf.append(String.format(XML_NOTE_BEGIN_FORMAT, XML_ROOT_NODE)).append("\n");
        doNode(buf, XML_STATUS_NODE, String.valueOf(status));
        doNode(buf, XML_MESSAGE_NODE, String.valueOf(message));

        buf.append(String.format(XML_NOTE_BEGIN_FORMAT, XML_VALUES_NODE)).append("\n");
        if (values != null) {
            for (Entry<String, Object> entry : values.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                doNode(buf, key, value);
            }
        }
        buf.append(String.format(XML_NOTE_END_FORMAT, XML_VALUES_NODE)).append("\n");
        buf.append(String.format(XML_NOTE_END_FORMAT, XML_ROOT_NODE));
        String result = buf.toString();
        return result;
    }

    private static void doNode(final StringBuilder buffer, String nodeName, Object value) {
        value = value == null ? "" : value.toString(); // zhuzhaohua 修改
        buffer.append("<").append(nodeName).append(">").append(value).append("</").append(nodeName)
                .append(">\n");
    }

    /**
     * 返回指定消息表示执行错误的 {@code AjaxResult}。
     * 
     * @param message 消息。
     * @return Ajax执行发生错误时的 {@code AjaxResult}。
     */
    public static AjaxResult getError(@JSONField(name = "message") String message) {
        return new AjaxResult(STATUS_ERROR, message);
    }

    /**
     * 返回指定消息和返回数据表示执行错误的 {@code AjaxResult}。
     * 
     * @param message 消息。
     * @param values 需要返回的数据。
     * @return Ajax执行发生错误时的 {@code AjaxResult}。
     */
    public static AjaxResult getError(String message, Map<String, Object> values) {
        return new AjaxResult(STATUS_ERROR, message, values);
    }

    /**
     * 返回指定消息表示执行错误的 {@code AjaxResult} 的JSON字符串。
     * 
     * @param message 消息。
     * @return Ajax执行发生错误时的 {@code AjaxResult} 的JSON字符串。
     */
    public static String getErrorJson(String message) {
        return getErrorJson(message, null);
    }

    /**
     * 返回指定消息表示执行错误的 {@code AjaxResult} 的JSON字符串。
     * 
     * @param message 消息。
     * @param values 需要返回的数据。
     * @return Ajax执行发生错误时的 {@code AjaxResult} 的JSON字符串。
     */
    public static String getErrorJson(String message, Map<String, Object> values) {
        AjaxResult result = getError(message, values);
        return JSON.toJSONString(result);
    }

    /**
     * 返回指定消息表示执行错误的 {@code AjaxResult} 的JSON字符串。
     * 
     * @param message 消息。
     * @param values 需要返回的数据。
     * @param action 动作。
     * @param view 视图名称。
     * @return Ajax执行发生错误时的 {@code AjaxResult} 的JSON字符串。
     */
    public static String getErrorJson(String message, Map<String, Object> values, String action, String view) {
        AjaxResult result = getError(message, values);
        result.setAction(action);
        result.setView(view);
        return JSON.toJSONString(result);
    }

    /**
     * 返回指定消息表示执行失败的 {@code AjaxResult}。
     * 
     * @param message 消息。
     * @return Ajax执行失败时的 {@code AjaxResult}。
     */
    public static AjaxResult getFailure(String message) {
        return new AjaxResult(STATUS_FAILURE, message);
    }

    /**
     * 返回指定消息和返回数据表示执行失败的 {@code AjaxResult}。
     * 
     * @param message 消息。
     * @param values 需要返回的数据。
     * @return Ajax执行失败时的 {@code AjaxResult}。
     */
    public static AjaxResult getFailure(String message, Map<String, Object> values) {
        return new AjaxResult(STATUS_FAILURE, message, values);
    }

    /**
     * 返回指定消息表示执行失败的 {@code AjaxResult} 的JSON字符串。
     * 
     * @param message 消息。
     * @return Ajax执行失败时的 {@code AjaxResult} 的JSON字符串。
     */
    public static String getFailureJson(String message) {
        return getFailureJson(message, null);
    }

    /**
     * 返回指定消息表示执行失败的 {@code AjaxResult} 的JSON字符串。
     * 
     * @param message 消息。
     * @param values 需要返回的数据。
     * @return Ajax执行失败时的 {@code AjaxResult} 的JSON字符串。
     */
    public static String getFailureJson(String message, Map<String, Object> values) {
        AjaxResult result = getFailure(message, values);
        return JSON.toJSONString(result);
    }

    /**
     * 返回指定消息表示执行失败的 {@code AjaxResult} 的JSON字符串。
     * 
     * @param message 消息。
     * @param values 需要返回的数据。
     * @param action 动作。
     * @param view 视图名称。
     * @return Ajax执行失败时的 {@code AjaxResult} 的JSON字符串。
     */
    public static String getFailureJson(String message, Map<String, Object> values, String action, String view) {
        AjaxResult result = getFailure(message, values);
        result.setAction(action);
        result.setView(view);
        return JSON.toJSONString(result);
    }

    /**
     * 返回指定消息表示执行成功的 {@code AjaxResult}。
     * 
     * @param message 消息。
     * @return Ajax执行成功时的 {@code AjaxResult}。
     */
    public static AjaxResult getSuccess(String message) {
        return new AjaxResult(STATUS_SUCCESS, message);
    }

    /**
     * 返回指定消息和返回数据表示执行成功的 {@code AjaxResult}。
     * 
     * @param message 消息。
     * @param values 需要返回的数据。
     * @return Ajax执行成功时的 {@code AjaxResult}。
     */
    public static AjaxResult getSuccess(String message, Map<String, Object> values) {
        return new AjaxResult(STATUS_SUCCESS, message, values);
    }

    /**
     * 返回指定消息表示执行成功的 {@code AjaxResult} 的JSON字符串。
     * 
     * @param message 消息。
     * @return Ajax执行成功时的 {@code AjaxResult} 的JSON字符串。
     */
    public static String getSuccessJson(String message) {
        return getSuccessJson(message, null);
    }

    /**
     * 返回指定消息表示执行成功的 {@code AjaxResult} 的JSON字符串。
     * 
     * @param message 消息。
     * @param values 需要返回的数据。
     * @return Ajax执行成功时的 {@code AjaxResult} 的JSON字符串。
     */
    public static String getSuccessJson(String message, Map<String, Object> values) {
        AjaxResult result = getSuccess(message, values);
        return JSON.toJSONString(result);
    }

    /**
     * 返回指定消息表示执行成功的 {@code AjaxResult} 的JSON字符串。
     * 
     * @param message 消息。
     * @param values 需要返回的数据。
     * @param action 动作。
     * @param view 视图名称。
     * @return Ajax执行成功时的 {@code AjaxResult} 的JSON字符串。
     */
    public static String getSuccessJson(String message, Map<String, Object> values, String action, String view) {
        AjaxResult result = getSuccess(message, values);
        result.setAction(action);
        result.setView(view);
        return JSON.toJSONString(result);
    }

    /**
     * 从JSON字符反向解析 {@code AjaxResult}。
     * <p />
     * 如果指定的JSON字符串 {@code ajaxResultJson == null || ajaxResultJson.trim().length() == 0}
     * ，则返回 {@code null}。如果转换失败，该方法不会抛出任何异常，返回 {@code null}。
     * 
     * @param ajaxResultJson 要转换的字符串。
     * @return {@code ajaxResultJson} 字符串表示的 {@code AjaxResult}。
     */
    public static AjaxResult fromJson(String ajaxResultJson) {
        if (!hasText(ajaxResultJson))
            return null;
        try {
            return JSON.parseObject(ajaxResultJson, AjaxResult.class);
        } catch (Exception ex) {
            // ignore ex message
            return null;
        }
    }

    /**
     * @see #STATUS_COMPLETE
     */
    @JSONField(serialize = false)
    public Integer getStatusComplete() {
        return AjaxResult.STATUS_COMPLETE;
    }

    /**
     * @see #STATUS_SUCCESS
     */
    @JSONField(serialize = false)
    public Integer getStatusSuccess() {
        return AjaxResult.STATUS_SUCCESS;
    }

    /**
     * @see #STATUS_FAILURE
     */
    @JSONField(serialize = false)
    public Integer getStatusFailure() {
        return AjaxResult.STATUS_FAILURE;
    }

    /**
     * @see #STATUS_ERROR
     */
    @JSONField(serialize = false)
    public Integer getStatusError() {
        return AjaxResult.STATUS_ERROR;
    }

    /**
     * @see #STATUS_SPECIAL
     */
    @JSONField(serialize = false)
    public Integer getStatusSpecial() {
        return AjaxResult.STATUS_SPECIAL;
    }

    /**
     * @see #RESULT_KEY
     */
    @JSONField(serialize = false)
    public String getResultKey() {
        return AjaxResult.RESULT_KEY;
    }
}
