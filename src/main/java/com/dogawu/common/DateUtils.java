package com.dogawu.common;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * 
 * @author bbk
 */
public class DateUtils
{
    public static String YYYY = "yyyy";

    public static String YYYY_MM = "yyyy-MM";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前Date型日期
     * 
     * @return Date() 当前日期
     */
    public static Date getNowDate()
    {
        return new Date();
    }

    /**
     * 获取当前日期, 默认格式为yyyy-MM-dd
     * 
     * @return String
     */
    public static String getDate()
    {
        return dateTimeNow(YYYY_MM_DD);
    }

    public static final String getTime()
    {
        return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
    }

    public static final String dateTimeNow()
    {
        return dateTimeNow(YYYYMMDDHHMMSS);
    }

    public static final String dateTimeNow(final String format)
    {
        return parseDateToStr(format, new Date());
    }

    public static final String dateTime(final Date date)
    {
        return parseDateToStr(YYYY_MM_DD, date);
    }

    public static final String parseDateToStr(final String format, final Date date)
    {
        if(date == null){
            return  null;
        }
        return new SimpleDateFormat(format).format(date);
    }

    public static final Date dateTime(final String format, final String ts)
    {
        try
        {
            return new SimpleDateFormat(format).parse(ts);
        }
        catch (ParseException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * 日期路径 即年/月/日 如2018/08/08
     */
    public static final String datePath()
    {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }

    /**
     * 日期路径 即年/月/日 如20180808
     */
    public static final String dateTime()
    {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyyMMdd");
    }

    /**
     * 功能：返回年
     *
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        Date localDate = date;
        if (localDate == null) {
            localDate = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(localDate);
        return c.get(Calendar.YEAR);

    }

    /**
     * 功能：返回月
     *
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        Date localDate = date;
        if (localDate == null) {
            localDate = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(localDate);
        return c.get(Calendar.MONTH) + 1;
    }

    /**
     * 功能：返回日
     *
     * @param date
     * @return
     */
    public static int getDay(Date date) {
        Date localDate = date;
        if (localDate == null) {
            localDate = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(localDate);
        return c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 功能：返回小时
     *
     * @param date
     * @return
     */
    public static int getHour(Date date) {
        Date localDate = date;
        if (localDate == null) {
            localDate = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(localDate);
        return c.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 功能：返回分
     *
     * @param date
     * @return
     */
    public static int getMinute(Date date) {
        Date localDate = date;
        if (localDate == null) {
            localDate = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(localDate);
        return c.get(Calendar.MINUTE);
    }

    /**
     * 功能：返回星期 1：星期一，2:星期二 ... 6:星期六 7:星期日
     *
     * @param date
     * @return
     */
    public static int getChinaWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (week == 0) {
            return 7;
        } else {
            return week;
        }
    }

    /**
     *
     * @Title: getWeekends
     * @Description: TODO(获取两个日期之间的周末天数)
     * @author Dingxiaoxiang
     * @date 2016年1月11日 下午3:58:58
     * @param @param d1 大的日期
     * @param @param d2 小的日期
     * @param @return 设定文件
     * @return int 返回类型
     * @throws
     */
    public static int getWeekends(Date d1, Date d2){
        if(d1 == null || d2 == null){
            return 0;
        }
        int count = 0;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        // 保证第二个时间一定大于第一个时间
        if (c1.after(c2)) {
            c2.setTime(d1);
            c1.setTime(d2);
        }
        // 当日期c2在日期c1之后退出循环
        while(c2.after(c1)){

            if(c1.get(Calendar.DAY_OF_WEEK) == 1 || c1.get(Calendar.DAY_OF_WEEK) == 7){
                System.out.println(c1.getTime());
                count++ ;
            }
            // 天数加1
            c1.set(Calendar.DAY_OF_YEAR, (c1.get(Calendar.DAY_OF_YEAR) + 1));
        }
        return count;
    }
    /**
     * 功能：返回秒
     *
     * @param date
     * @return
     */
    public static int getSecond(Date date) {
        Date localDate = date;
        if (localDate == null) {
            localDate = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(localDate);
        return c.get(Calendar.SECOND);
    }

    /**
     * 功能：返回毫秒
     *
     * @param date
     * @return
     */
    public static long getMillis(Date date) {
        Date localDate = date;
        if (localDate == null) {
            localDate = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(localDate);
        return c.getTimeInMillis();
    }

    /**
     * 功能：获取当前月的第一天日期
     *
     * @return
     */
    public static Date getMonFirstDay() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.set(getYear(date), getMonth(date) - 1, 1);
        return c.getTime();
    }

    /**
     * 功能：获取当前月的最后一天日期
     *
     * @return
     */
    public static Date getMonLastDay() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.set(getYear(date), getMonth(date), 1);

        c.setTimeInMillis(c.getTimeInMillis() - (24 * 3600 * 1000));
        return c.getTime();
    }

    /**
     * 功能：获取上n个月的第一天日期
     *@param n 上n个月
     * @return
     */
    public static Date getUpMonFirstDay(int n) {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        int month = getMonth(date);//当前月份
        c.set(getYear(date),month-(n+1), 1,0,0,0);
        return c.getTime();
    }


    /**
     * 功能：获取上n个月的最后一天日期
     * @param n 上n个月
     * @return
     */

    public static Date getUpMonLastDay(int n) {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        int month = getMonth(date);//当前月份
        c.set(getYear(date), month-n, 1,23,59,59);
        c.setTimeInMillis(c.getTimeInMillis() - (24 * 3600 * 1000));
        return c.getTime();
    }

    /**
     * @method addMonth
     * @desc ToDo 添加月份
     * @param date
     * @param month
     * @return java.util.Date
     * @author dingxx
     * @date 2018-10-11-14:26
     * @version 1.0
    **/
    public static Date addMonth(Date date, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, month);
        date = c.getTime();
        return date;
    }



    /**
     * 功能：指定日期加上指定天数
     *
     * @param date
     *            日期
     * @param day
     *            天数
     * @return 返回相加后的日期
     */
    public static Date addDate(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);
        return c.getTime();
    }

    /**
     * 功能：指定日期加上指定分钟
     *
     * @param date
     *            日期
     * @param minute
     *            分钟
     * @return 返回相加后的日期
     */
    public static Date addMinute(Date date, int minute) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(getMillis(date) + ((long) minute) * 60 * 1000);
        return c.getTime();
    }

    /**
     *
     * 功能：添加指定秒杀的时间
     *
     * @param date
     * @param second
     * @return
     */
    public static Date addSecond(Date date, int second) {
        long s = date.getTime();
        s = s + second * 1000;
        return new Date(s);
    }

    /**
     * 功能：指定日期减去指定天数
     *
     * @param date
     * @param day
     * @return
     */
    public static Date minusDate(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(getMillis(date) - ((long) day) * 24 * 3600 * 1000);
        return c.getTime();
    }

    /**
     *
     * 功能：分钟相差 minute的时间值
     *
     * @param date
     * @param minute
     * @return
     */
    public static Date getDateByMinuteAdd(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();
    }

    /**
     * 功能:两个日期相隔天数
     *
     * @param startDate
     *            开始日期
     * @param endDate
     *            结束日期
     * @return 返回相减后的日期
     */
    public static int diffDate(Date startDate, Date endDate) {
        long endMillis = endDate.getTime();
        long startMillis = startDate.getTime();
        long s = (endMillis - startMillis) / (24 * 3600 * 1000);
        return (int) s;
    }

    /***
     *
     * @Title: diffMinute
     * @author:     echao.wang
     * Create at:   2014年9月15日 下午2:40:51
     * @Description: 计算两个时间间隔的分钟数
     * @param @param startDate
     * @param @param endDate
     * @param @return
     * @return int
     */
    public static int diffMinute(Date startDate, Date endDate){
        long endMillis = endDate.getTime();
        long startMillis = startDate.getTime();
        long s = (endMillis - startMillis) / (60 * 1000);
        return (int) s;
    }

    /**
     * @method formatTime
     * @desc ToDo 格式化毫秒
     * @param
     * @return java.lang.String
     * @author dingxx
     * @date 2018-11-07-8:39
     * @version 1.0
    **/
    public static String formatTime(Long m){
        StringBuffer time = new StringBuffer();
        if(m==null || m <= 0){
            return null;
        }
        if(m < 1000){
            return m+"毫秒";
        }
        if(m < 1000*60){
            return String.valueOf(m/1000)+"秒";
        }
        if(m< 1000*60*60){
            time.append(String.valueOf(m/(1000*60)));
            time.append("分");
            time.append(String.valueOf(m%(1000*60)/1000));
            time.append("秒");
            return time.toString();
        }
        if(m< 1000*60*60*24){
            time.append(String.valueOf(m/(1000*60*60)));
            time.append("时");
            time.append(String.valueOf((m%(1000*60*60))/(1000*60)));
            time.append("分");
            time.append(String.valueOf(m%(1000*60*60)%(1000*60)/1000));
            time.append("秒");
            return time.toString();
        }
        time.append(String.valueOf(m/(1000*60*60*24)));
        time.append("天");
        time.append(String.valueOf(m%(1000*60*60*24)/(1000*60*60)));
        time.append("时");
        time.append(String.valueOf((m%(1000*60*60*24)%(1000*60*60))/(1000*60)));
        time.append("分");
        time.append(String.valueOf(m%(1000*60*60*24)%(1000*60*60)%(1000*60)/1000));
        time.append("秒");
        return time.toString();
    }

    public static void main(String[] args) {
        //System.out.printf(DateUtils.getUpMonFirstDay(1).toString());
        //System.out.printf(DateUtils.getUpMonLastDay(1).toString());
        System.out.printf(DateUtils.formatTime(2*24*1000*60*60L+ 23*1000*60*60L+59*1000*60L+59*1000L));
    }

}
