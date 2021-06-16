package NewSciense.FenYe;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 工具类
 *
 * @author SMILE
 */
public class MyUtil {
    /**
     * 生成随机单号
     *
     * @param prefix
     * @return
     */
    public static String genrateNo(String prefix) {
        //前缀+年月日+4位随机数
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        //获取当前系统时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        sb.append(sdf.format(new Date()));
        //4位随机数  1-999999
        Integer rnd = (int) (Math.random() * 10000);
        for (int i = 0; i < 4 - rnd + "".length(); i++) {
            sb.append("0");
        }
        sb.append(rnd + "");
        return sb.toString();
    }

    /**
     * 是否是整数
     *
     * @param s
     * @return
     */
    public static Boolean isInteger(String s) {
        try {
            Integer.valueOf(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 是否是浮点数
     *
     * @param s
     * @return
     */
    public static Boolean isNumber(String s) {
        try {
            Double.valueOf(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
