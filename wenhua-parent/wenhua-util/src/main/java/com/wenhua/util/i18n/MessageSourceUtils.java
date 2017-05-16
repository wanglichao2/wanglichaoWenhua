package com.wenhua.util.i18n;

/**
 * 国际化资源信息实用工具类。
 *
 * @author Fuchun
 * @since 1.0
 * @version $Id: MessageSourceUtils.java 27644 2013-05-13 10:57:55Z C629 $
 * @see ResourceBundleMessageSource
 */
public final class MessageSourceUtils {
    private MessageSourceUtils() {
    }

    private static final MessageSourceUtils INSTANCE = new MessageSourceUtils();

    private ResourceBundleMessageSource messageSource;

    /**
     * 返回 {@link com.tonglukuaijian.common.i18n.MessageSourceUtils} 的唯一实例。
     */
    public static MessageSourceUtils getInstance() {
        return INSTANCE;
    }

    /**
     * 返回指定 {@code code} 对应的默认语言环境的国际化信息。如果信息没有找到，默认返回 {@code code}。
     *
     * @param code 指定的国际化信息的 {@code code}。
     * @param params 参数。
     * @return 返回指定 {@code code} 对应的默认语言环境的国际化信息。
     * @see ResourceBundleMessageSource#getMessage(String, Object...)
     */
    public static String getMessage(String code, Object... params) {
        return INSTANCE.messageSource.getMessage(code, params);
    }

    /**
     * 返回指定 {@code code} 对应的默认语言环境的国际化信息。如果信息没有找到，默认返回 {@code defaultMessage}。
     *
     * @param code 指定的国际化信息的 {@code code}。
     * @param params 参数。
     * @param defaultMessage 找不到 {@code code} 映射值时，返回的默认值。
     * @return 返回指定 {@code code} 对应的默认语言环境的国际化信息。
     * @see ResourceBundleMessageSource#getMessage(String, Object[], String)
     */
    public static String getMessage(String code, Object[] params, String defaultMessage) {
        return INSTANCE.messageSource.getMessage(code, params, defaultMessage);
    }
//
//    /**
//     * 返回指定 {@link java.util.Locale} 对象所有资源信息。
//     *
//     * @param locale 指定的 {@link java.util.Locale} 对象
//     * @return 国际化资源键值映射。
//     * @see ResourceBundleMessageSource#getMessageMap(java.util.Locale)
//     */
//    public static Map<String, String> getMessageMap(Locale locale) {
//        return INSTANCE.messageSource.getMessageMap(locale);
//    }

    /** Spring 中注入 {@code messageSource}。 */
    public void setMessageSource(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }
}