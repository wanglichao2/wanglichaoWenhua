package com.wenhua.util.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 国家代码管理。
 * 
 * @author fuchun
 * @version $Id: Country.java 27644 2013-05-13 10:57:55Z C629 $
 * @since 1.0
 */
public final class Country {

    /** 用于表示澳大利亚的有用常量。 */
    public static final String AUSTRALIA = "AU";

    /** 用于表示巴西的有用常量。 */
    public static final String BRAZIL = "BR";

    /** 用于表示加拿大的有用常量。 */
    public static final String CANADA = "CA";

    /** 用于表示中国的有用常量。 */
    public static final String CHINA = "CN";

    /** 用于表示德国的有用常量。 */
    public static final String GERMANY = "DE";

    /** 用于表示法国的有用常量。 */
    public static final String FRANCE = "FR";

    /** 用于表示香港的有用常量。 */
    public static final String HONGKONG = "HK";

    /** 用于表示印度的有用常量。 */
    public static final String INDIA = "IN";

    /** 用于表示日本的有用常量。 */
    public static final String JAPAN = "JP";

    /** 用于表示韩国的有用常量。 */
    public static final String KOREA = "KR";

    /** 用于表示澳门的有用常量。 */
    public static final String MACAO = "MO";

    /** 用于表示马来西亚的有用常量。 */
    public static final String MALAYSIA = "MY";

    /** 用于表示新西兰的有用常量。 */
    public static final String NEW_ZEALAND = "NZ";

    /** 用于表示朝鲜的有用常量。 */
    public static final String NORTH_KOREA = "KP";

    /** 用于表示新加坡的有用常量。 */
    public static final String SINGAPORE = "SG";

    /** 用于表示台湾的有用常量。 */
    public static final String TAIWAN = "TW";

    /** 用于表示英国的有用常量。 */
    public static final String UK = "GB";

    /** 用于表示美国的有用常量。 */
    public static final String US = "US";

    private static final Map<String, String> countries = new HashMap<String, String>(185);

    static {
        countries.put("AO", "安哥拉");
        countries.put("AF", "阿富汗");
        countries.put("AL", "阿尔巴尼亚");
        countries.put("DZ", "阿尔及利亚");
        countries.put("AD", "安道尔共和国");
        countries.put("AI", "安圭拉岛");
        countries.put("AG", "安提瓜和巴布达");
        countries.put("AR", "阿根廷");
        countries.put("AM", "亚美尼亚");
        countries.put(AUSTRALIA, "澳大利亚");
        countries.put("AT", "奥地利");
        countries.put("AZ", "阿塞拜疆");
        countries.put("BS", "巴哈马");
        countries.put("BH", "巴林");
        countries.put("BD", "孟加拉国");
        countries.put("BB", "巴巴多斯");
        countries.put("BY", "白俄罗斯");
        countries.put("BE", "比利时");
        countries.put("BZ", "伯利兹");
        countries.put("BJ", "贝宁");
        countries.put("BM", "百慕大群岛");
        countries.put("BO", "玻利维亚");
        countries.put("BW", "博茨瓦纳");
        countries.put(BRAZIL, "巴西");
        countries.put("BN", "文莱");
        countries.put("BG", "保加利亚");
        countries.put("BF", "布基纳法索");
        countries.put("MM", "缅甸");
        countries.put("BI", "布隆迪");
        countries.put("CM", "喀麦隆");
        countries.put(CANADA, "加拿大");
        countries.put("CF", "中非共和国");
        countries.put("TD", "乍得");
        countries.put("CL", "智利");
        countries.put(CHINA, "中国");
        countries.put("CO", "哥伦比亚");
        countries.put("CG", "刚果");
        countries.put("CK", "库克群岛");
        countries.put("CR", "哥斯达黎加");
        countries.put("CU", "古巴");
        countries.put("CY", "塞浦路斯");
        countries.put("CZ", "捷克");
        countries.put("DK", "丹麦");
        countries.put("DJ", "吉布提");
        countries.put("DO", "多米尼加共和国");
        countries.put("EC", "厄瓜多尔");
        countries.put("EG", "埃及");
        countries.put("SV", "萨尔瓦多");
        countries.put("EE", "爱沙尼亚");
        countries.put("ET", "埃塞俄比亚");
        countries.put("FJ", "斐济");
        countries.put("FI", "芬兰");
        countries.put(FRANCE, "法国");
        countries.put("GF", "法属圭亚那");
        countries.put("GA", "加蓬");
        countries.put("GM", "冈比亚");
        countries.put("GE", "格鲁吉亚");
        countries.put(GERMANY, "德国");
        countries.put("GH", "加纳");
        countries.put("GI", "直布罗陀");
        countries.put("GR", "希腊");
        countries.put("GD", "格林纳达");
        countries.put("GU", "关岛");
        countries.put("GT", "危地马拉");
        countries.put("GN", "几内亚");
        countries.put("GY", "圭亚那");
        countries.put("HT", "海地");
        countries.put("HN", "洪都拉斯");
        countries.put(HONGKONG, "香港");
        countries.put("HU", "匈牙利");
        countries.put("IS", "冰岛");
        countries.put(INDIA, "印度");
        countries.put("ID", "印度尼西亚");
        countries.put("IR", "伊朗");
        countries.put("IQ", "伊拉克");
        countries.put("IE", "爱尔兰");
        countries.put("IL", "以色列");
        countries.put("IT", "意大利");
        countries.put("JM", "牙买加");
        countries.put(JAPAN, "日本");
        countries.put("JO", "约旦");
        countries.put("KH", "柬埔寨");
        countries.put("KZ", "哈萨克斯坦");
        countries.put("KE", "肯尼亚");
        countries.put(KOREA, "韩国");
        countries.put("KW", "科威特");
        countries.put("KG", "吉尔吉斯坦");
        countries.put("LA", "老挝");
        countries.put("LV", "拉脱维亚");
        countries.put("LB", "黎巴嫩");
        countries.put("LS", "莱索托");
        countries.put("LR", "利比里亚");
        countries.put("LY", "利比亚");
        countries.put("LI", "列支敦士登");
        countries.put("LT", "立陶宛");
        countries.put("LU", "卢森堡");
        countries.put(MACAO, "澳门");
        countries.put("MG", "马达加斯加");
        countries.put("MW", "马拉维");
        countries.put(MALAYSIA, "马来西亚");
        countries.put("MV", "马尔代夫");
        countries.put("ML", "马里");
        countries.put("MT", "马耳他");
        countries.put("MU", "毛里求斯");
        countries.put("MX", "墨西哥");
        countries.put("MD", "摩尔多瓦");
        countries.put("MC", "摩纳哥");
        countries.put("MN", "蒙古");
        countries.put("MS", "蒙特塞拉特岛");
        countries.put("MA", "摩洛哥");
        countries.put("MZ", "莫桑比克");
        countries.put("NA", "纳米比亚");
        countries.put("NR", "瑙鲁");
        countries.put("NP", "尼泊尔");
        countries.put("NL", "荷兰");
        countries.put(NEW_ZEALAND, "新西兰");
        countries.put("NI", "尼加拉瓜");
        countries.put("NE", "尼日尔");
        countries.put("NG", "尼日利亚");
        countries.put(NORTH_KOREA, "朝鲜");
        countries.put("NO", "挪威");
        countries.put("OM", "阿曼");
        countries.put("PK", "巴基斯坦");
        countries.put("PA", "巴拿马");
        countries.put("PG", "巴布亚新几内亚");
        countries.put("PY", "巴拉圭");
        countries.put("PE", "秘鲁");
        countries.put("PH", "菲律宾");
        countries.put("PL", "波兰");
        countries.put("PF", "法属玻利尼西亚");
        countries.put("PT", "葡萄牙");
        countries.put("PR", "波多黎各");
        countries.put("QA", "卡塔尔");
        countries.put("RO", "罗马尼亚");
        countries.put("RU", "俄罗斯");
        countries.put("LC", "圣卢西亚");
        countries.put("VC", "圣文森特岛");
        countries.put("SM", "圣马力诺");
        countries.put("ST", "圣多美和普林西比");
        countries.put("SA", "沙特阿拉伯");
        countries.put("SN", "塞内加尔");
        countries.put("SC", "塞舌尔");
        countries.put("SL", "塞拉利昂");
        countries.put("SG", "新加坡");
        countries.put("SK", "斯洛伐克");
        countries.put("SI", "斯洛文尼亚");
        countries.put("SB", "所罗门群岛");
        countries.put("SO", "索马里");
        countries.put("ZA", "南非");
        countries.put("ES", "西班牙");
        countries.put("LK", "斯里兰卡");
        countries.put("LC", "圣卢西亚");
        countries.put("VC", "圣文森特");
        countries.put("SD", "苏丹");
        countries.put("SR", "苏里南");
        countries.put("SZ", "斯威士兰");
        countries.put("SE", "瑞典");
        countries.put("CH", "瑞士");
        countries.put("SY", "叙利亚");
        countries.put(TAIWAN, "台湾省");
        countries.put("TJ", "塔吉克斯坦");
        countries.put("TZ", "坦桑尼亚");
        countries.put("TH", "泰国");
        countries.put("TG", "多哥");
        countries.put("TO", "汤加");
        countries.put("TT", "特立尼达和多巴哥");
        countries.put("TN", "突尼斯");
        countries.put("TR", "土耳其");
        countries.put("TM", "土库曼斯坦");
        countries.put("UG", "乌干达");
        countries.put("UA", "乌克兰");
        countries.put("AE", "阿拉伯联合酋长国");
        countries.put(UK, "英国");
        countries.put(US, "美国");
        countries.put("UY", "乌拉圭");
        countries.put("UZ", "乌兹别克斯坦");
        countries.put("VE", "委内瑞拉");
        countries.put("VN", "越南");
        countries.put("YE", "也门");
        countries.put("YU", "南斯拉夫");
        countries.put("ZW", "津巴布韦");
        countries.put("ZR", "扎伊尔");
        countries.put("ZM", "赞比亚");
    }

    /**
     * 返回指定国家代码的国家名称。如果给定的代码不存在，则返回 {@code null}。
     * 
     * <pre>
     * Country.getName(Countries.CN) = &quot;中国&quot;
     * </pre>
     * 
     * @param code 国家代码。
     * @return 对应的国家名称。
     */
    public static String getName(String code) {
        if (countries.containsKey(code)) {
            return countries.get(code);
        }
        return null;
    }
    
    /**
     * 返回所有国家代码的集合。
     * 
     * @return 所有国家代码的集合。
     */
    public static Map<String, String> getMaps() {
        return new HashMap<String, String>(countries);
    }
    
    /**
     * 返回所有的国家代码列表。
     * 
     * @return 所有的国家代码列表。
     */
    public static List<String> getCountriesCode() {
        return new ArrayList<String>(countries.keySet());
    }
}
