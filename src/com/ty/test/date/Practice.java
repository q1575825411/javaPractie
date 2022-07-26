package com.ty.test.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.zone.ZoneRulesProvider;
import java.util.*;

/**
 * @author sm2886
 */
public class Practice {
    public static void main(String[] args) {
//        date();
        try {
            transform();
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        calender();
        String s = getTime();
        System.out.println(s);
        System.out.println(getTimeType().size());


        int a = Integer.parseInt("#FF44FF");
        System.out.println(a);


    }


    /**
     * @throws ParseException
     */
    public static void transform() throws ParseException {

        String timeStr = "2017-8-24 11:17:10";
        // 字面时间
        SimpleDateFormat bjSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        bjSdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        Date date = bjSdf.parse(timeStr);
        // 将字符串时间按北京时间解析成Date对象

        SimpleDateFormat tokyoSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 东京

        tokyoSdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
        // 设置东京时区

        System.out.println("北京时间: " + timeStr + "对应的东京时间为:" + tokyoSdf.format(date));

    }

    public static void date() {
        Date date = new Date();
        System.out.println(date);

        //格式化输出
        SimpleDateFormat sft = new SimpleDateFormat("z yyyy-MM-dd E hh:mm:ss");
        System.out.println(sft.format(date));

        //c的使用
        System.out.printf("全部日期和时间信息：%tc%n", date);
        //f的使用
        System.out.printf("年-月-日格式：%tF%n", date);
        //d的使用
        System.out.printf("月/日/年格式：%tD%n", date);
        //r的使用
        System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n", date);
        //t的使用
        System.out.printf("HH:MM:SS格式（24时制）：%tT%n", date);
        //R的使用
        System.out.printf("HH:MM格式（24时制）：%tR", date);
        //b的使用，月份简称
        String str = String.format(Locale.US, "英文月份简称：%tb", date);
        System.out.println(str);
        System.out.printf("本地月份简称：%tb%n", date);
        //B的使用，月份全称
        str = String.format(Locale.US, "英文月份全称：%tB", date);
        System.out.println(str);
        System.out.printf("本地月份全称：%tB%n", date);
        //a的使用，星期简称
        str = String.format(Locale.US, "英文星期的简称：%ta", date);
        System.out.println(str);
        //A的使用，星期全称
        System.out.printf("本地星期的简称：%tA%n", date);
        //C的使用，年前两位
        System.out.printf("年的前两位数字（不足两位前面补0）：%tC%n", date);
        //y的使用，年后两位
        System.out.printf("年的后两位数字（不足两位前面补0）：%ty%n", date);
        //j的使用，一年的天数
        System.out.printf("一年中的天数（即年的第几天）：%tj%n", date);
        //m的使用，月份
        System.out.printf("两位数字的月份（不足两位前面补0）：%tm%n", date);
        //d的使用，日（二位，不够补零）
        System.out.printf("两位数字的日（不足两位前面补0）：%td%n", date);
        //e的使用，日（一位不补零）
        System.out.printf("月份的日（前面不补0）：%te%n", date);

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);

    }

    public static void calender() {
        //日历类 获取当前时间
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTimeZone());

        //
        GregorianCalendar gc = new GregorianCalendar();
        System.out.println(gc);


        Calendar c1 = Calendar.getInstance();
        System.out.println(c1.get(Calendar.YEAR) + "-"
                + (c1.get(Calendar.MONTH) + 1) + "-" + c1.get(Calendar.DAY_OF_MONTH) + " "
                + c1.get(Calendar.HOUR_OF_DAY) + ":" + c1.get(Calendar.MINUTE) + ":"
                + c1.get(Calendar.SECOND));
    }

    public static String getTime() {
        //获取当前时间
        Date date = new Date();

        //使用Calender获取时间
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

        //格式化
        SimpleDateFormat sft = new SimpleDateFormat("z yyyy-MM-dd E hh:mm:ss");

        //生成格式化时间
        String d = sft.format(date);

        //设置对应时区
        SimpleDateFormat tokyoTimeFormat = new SimpleDateFormat("z yyyy-MM-dd E hh:mm:ss");
        tokyoTimeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        //转换
        String tokyoTime = tokyoTimeFormat.format(date);

        String time = tokyoTimeFormat.format(calendar.getTime());

        return time;
    }


    /**
     *
     * @return list 时区列表
     */
    public static List<String> getTimeType() {
        List<String> list = new ArrayList<>(ZoneRulesProvider.getAvailableZoneIds());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        /*
        for (String zone : list) {

            TimeZone timeZone = TimeZone.getTimeZone(ZoneId.of(zone));
            System.out.println("|"
                    + timeZone.toZoneId() + "|"
                    + timeZone.getDisplayName() + "|"
                    + timeZone.getRawOffset() / 3600000 + "|"
                    + (timeZone.useDaylightTime() ? "yes" : "no") + "|"
            );
        }
         */
        return list;
    }

}
