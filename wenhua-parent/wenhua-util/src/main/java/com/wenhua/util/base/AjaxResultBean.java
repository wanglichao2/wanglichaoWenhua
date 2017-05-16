package com.wenhua.util.base;

import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * {@code AjaxResult} 的子类。该类引入泛型类型，用于提供JSON返回数据的泛型支持。
 * 
 * @author fuchun
 * @version $Id: AjaxResultBean.java 27644 2013-05-13 10:57:55Z C629 $
 * @since 1.0
 */
public class AjaxResultBean<T> extends AjaxResult {

    private static final long serialVersionUID = 2338449945752228793L;

    private T bean;

    /**
     * 新构造一个默认的 {@code AjaxResultBean}。
     */
    public AjaxResultBean() {
        super();
    }

    /**
     * 用给定的属性构造一个新的 {@code AjaxResultBean}。
     * 
     * @param status 状态信息。参见{@link #STATUS_COMPLETE}、{@link #STATUS_FAILURE}等。
     * @param message 包含的信息。
     * @param bean 指定的泛型对象。
     */
    public AjaxResultBean(Integer status, String message, T bean) {
        super(status, message);
        this.bean = bean;
    }

    /**
     * 用给定的属性构造一个新的 {@code AjaxResultBean}。
     * 
     * @param status 状态信息。参见{@link #STATUS_COMPLETE}、{@link #STATUS_FAILURE}等。
     * @param message 包含的信息。
     * @param values 用于保存需要的值。
     * @param bean 指定的泛型对象。
     */
    public AjaxResultBean(Integer status, String message, Map<String, Object> values, T bean) {
        super(status, message, values);
        this.bean = bean;
    }

    /**
     * {@code status == AjaxResult#STATUS_SUCCESS} 的快捷调用帮助方法。相当于
     * 
     * <pre>
     * AjaxResultBean&lt;T&gt; result = new AjaxResultBean&lt;T&gt;(STATUS_SUCCESS, message, values, bean);
     * </pre>
     * 
     * @param <T> Ajax调用结果的类对象类型。
     * @param message 消息。
     * @param values 附加的值。
     * @param bean 附加的类对象。
     * @return AjaxResultBean instance.
     * @since 2.4
     */
    public static <T> AjaxResultBean<T> getSuccess(String message, Map<String, Object> values, T bean) {
        AjaxResultBean<T> result = new AjaxResultBean<T>(STATUS_SUCCESS, message, values, bean);
        return result;
    }

    /**
     * {@code status == AjaxResult#STATUS_SUCCESS} 的快捷调用帮助方法。相当于
     * 
     * <pre>
     * AjaxResultBean&lt;T&gt; result = new AjaxResultBean&lt;T&gt;(STATUS_SUCCESS, message, values, bean);
     * JSONUtils.toJson(result, new TypeToken(AjaxResultBean&lt;T&gt;&gt;() {}.getType());
     * </pre>
     * 
     * @param <T> Ajax调用结果的类对象类型。
     * @param message 消息。
     * @param values 附加的值。
     * @param bean 附加的类对象。
     * @return AjaxResultBean instance.
     * @since 2.4
     */
    public static <T> String getSuccessJson(String message, Map<String, Object> values, T bean) {
        AjaxResultBean<T> result = new AjaxResultBean<T>(STATUS_SUCCESS, message, values, bean);
        // return JSONUtils.toJson(result, new TypeToken<AjaxResultBean<T>>() {
        // }.getType());
        return JSON.toJSONString(result);
    }

    /**
     * {@code status == AjaxResult#STATUS_FAILURE} 的快捷调用帮助方法。相当于
     * 
     * <pre>
     * AjaxResultBean&lt;T&gt; result = new AjaxResultBean&lt;T&gt;(STATUS_FAILURE, message, values, bean);
     * </pre>
     * 
     * @param <T> Ajax调用结果的类对象类型。
     * @param message 消息。
     * @param values 附加的值。
     * @param bean 附加的类对象。
     * @return AjaxResultBean instance.
     * @since 2.4
     */
    public static <T> AjaxResultBean<T> getFailure(String message, Map<String, Object> values, T bean) {
        AjaxResultBean<T> result = new AjaxResultBean<T>(STATUS_FAILURE, message, values, bean);
        return result;
    }

    /**
     * {@code status == AjaxResult#STATUS_FAILURE} 的快捷调用帮助方法。相当于
     * 
     * <pre>
     * AjaxResultBean&lt;T&gt; result = new AjaxResultBean&lt;T&gt;(STATUS_FAILURE, message, values, bean);
     * JSONUtils.toJson(result, new TypeToken(AjaxResultBean&lt;T&gt;&gt;() {}.getType());
     * </pre>
     * 
     * @param <T> Ajax调用结果的类对象类型。
     * @param message 消息。
     * @param values 附加的值。
     * @param bean 附加的类对象。
     * @return AjaxResultBean instance.
     * @since 2.4
     */
    public static <T> String getFailureJson(String message, Map<String, Object> values, T bean) {
        AjaxResultBean<T> result = new AjaxResultBean<T>(STATUS_FAILURE, message, values, bean);
        // return JSONUtils.toJson(result, new TypeToken<AjaxResultBean<T>>() {
        // }.getType());
        return JSON.toJSONString(result);
    }

    /**
     * {@code status == AjaxResult#STATUS_ERROR} 的快捷调用帮助方法。相当于
     * 
     * <pre>
     * AjaxResultBean&lt;T&gt; result = new AjaxResultBean&lt;T&gt;(STATUS_ERROR, message, values, bean);
     * </pre>
     * 
     * @param <T> Ajax调用结果的类对象类型。
     * @param message 消息。
     * @param values 附加的值。
     * @param bean 附加的类对象。
     * @return AjaxResultBean instance.
     * @since 2.4
     */
    public static <T> AjaxResultBean<T> getError(String message, Map<String, Object> values, T bean) {
        AjaxResultBean<T> result = new AjaxResultBean<T>(STATUS_ERROR, message, values, bean);
        return result;
    }

    /**
     * {@code status == AjaxResult#STATUS_ERROR} 的快捷调用帮助方法。相当于
     * 
     * <pre>
     * AjaxResultBean&lt;T&gt; result = new AjaxResultBean&lt;T&gt;(STATUS_ERROR, message, values, bean);
     * JSONUtils.toJson(result, new TypeToken(AjaxResultBean&lt;T&gt;&gt;() {}.getType());
     * </pre>
     * 
     * @param <T> Ajax调用结果的类对象类型。
     * @param message 消息。
     * @param values 附加的值。
     * @param bean 附加的类对象。
     * @return AjaxResultBean instance.
     * @since 2.4
     */
    public static <T> String getErrorJson(String message, Map<String, Object> values, T bean) {
        AjaxResultBean<T> result = new AjaxResultBean<T>(STATUS_ERROR, message, values, bean);
        // return JSONUtils.toJson(result, new TypeToken<AjaxResultBean<T>>() {
        // }.getType());
        return JSON.toJSONString(result);
    }

    /** 返回指定泛型类型的类对象。 */
    public T getBean() {
        return bean;
    }

    /** 设置指定泛型类型的类对象。 */
    public void setBean(T bean) {
        this.bean = bean;
    }
}
