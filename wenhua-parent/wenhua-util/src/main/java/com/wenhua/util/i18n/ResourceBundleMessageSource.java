package com.wenhua.util.i18n;
import java.util.Locale;

/**
 * @author Fuchun
 * @version $Id: ResourceBundleMessageSource.java 27644 2013-05-13 10:57:55Z C629 $
 * @since 1.0
 */
public class ResourceBundleMessageSource extends org.springframework.context.support.ResourceBundleMessageSource {

    public String getMessage(String key, Object... params) {
        return getMessage(key, params, (String) null);
    }

    public String getMessage(String key, Object[] params, String defaultMessage) {
        return getMessage(key, params, defaultMessage, Locale.getDefault());
    }

//    public Map<String, String> getMessageMap(Locale locale) {
//        PropertiesHolder propHolder = getMergedProperties(locale);
//        Properties props = propHolder.getProperties();
//        HashMap<String, String> map = Maps.newHashMapWithExpectedSize(props.size());
//        for (Map.Entry<Object, Object> entry : props.entrySet()) {
//            map.put((String) entry.getKey(), (String) entry.getValue());
//        }
//        return map;
//    }
}
