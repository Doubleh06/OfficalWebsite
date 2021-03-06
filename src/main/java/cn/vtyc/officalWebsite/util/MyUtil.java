package cn.vtyc.officalWebsite.util;

import com.google.common.base.Joiner;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyUtil {
    public static String JoinStrBySymbol(List<String> strList, String symbol) {
        return Joiner.on(symbol).join(strList);
    }

    //unicode 转中文
    public static String unicodeToString(String str) {

        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(str);
        char ch;
        while (matcher.find()) {
            //group 6728
            String group = matcher.group(2);
            //ch:'木' 26408
            ch = (char) Integer.parseInt(group, 16);
            //group1 \u6728
            String group1 = matcher.group(1);
            str = str.replace(group1, ch + "");
        }
        return str;
    }
}
