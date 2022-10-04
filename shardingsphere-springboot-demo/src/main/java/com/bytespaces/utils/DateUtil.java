package com.bytespaces.utils;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * @author shine
 * @description 日期时间工具类
 * @date 2019/12/18
 */
public class DateUtil {

    public static final DateTimeFormatter YMDHMS = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public static final DateTimeFormatter BEAUTY_YMDHMS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);

    private final static ThreadLocal<DateFormat> threadLocalCompactDateFormat = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMddHHmmss");
        }

        ;
    };

    private final static ThreadLocal<DateFormat> threadLocalCompactShortDateFormat = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd");
        }
    };

    private final static ThreadLocal<DateFormat> threadLocalCompactShort2DateFormat = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyyMM");
        }
    };

    private final static ThreadLocal<DateFormat> threadLocalBeautyShort3DateFormat = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM");
        }

        ;
    };

    private final static ThreadLocal<DateFormat> threadLocalBeautyDateFormat = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }

        ;
    };

    private final static ThreadLocal<DateFormat> threadLocalBeautyShortDateFormat = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }

        ;
    };


    public static final String FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String FORMAT_YYYYMMDDHHMMSSSSS = "yyyyMMddhhmmssSSS";
    public static final String FORMAT_YYYYMMDDHHMMSS = "yyyyMMddhhmmss";
    public static final String FORMAT_YYYYMMDD = "YYYYMMDD";


    public static DateFormat getCompactDateFormat() {
        return threadLocalCompactDateFormat.get();
    }

    public static DateFormat getCompactShortDateFormat() {
        return threadLocalCompactShortDateFormat.get();
    }

    public static DateFormat getCompactShort3DateFormat() {
        return threadLocalCompactShort2DateFormat.get();
    }

    public static DateFormat getCompactShort5DateFormat() {
        return threadLocalBeautyShort3DateFormat.get();
    }

    public static DateFormat getBeautyDateFormat() {
        return threadLocalBeautyDateFormat.get();
    }

    public static DateFormat getBeautyShortDateFormat() {
        return threadLocalBeautyShortDateFormat.get();
    }

    public static DateFormat getBeautyShort3DateFormat() {
        return threadLocalBeautyShort3DateFormat.get();
    }

    /**
     * 日期格式转换为 "yyyyMMddHHmmss"
     *
     * @param date
     * @return
     */
    public static String date2CompactDateStr(Date date) {
        if (null == date) {
            return null;
        }

        return getCompactDateFormat().format(date);
    }


    /**
     * 日期格式转换为 "yyyyMMdd"
     *
     * @param date
     * @return
     */
    public static String date2CompactShortDateStr(Date date) {
        if (null == date) {
            return null;
        }

        return getCompactShortDateFormat().format(date);
    }

    /**
     * 日期格式转换为 "yyyyMM"
     *
     * @param date
     * @return
     */
    public static String date2CompactShort3DateStr(Date date) {
        if (null == date) {
            return null;
        }
        return getCompactShort3DateFormat().format(date);
    }

    /**
     * 日期格式转换为 "yyyy-MM"
     *
     * @param date
     * @return
     */
    public static String date2CompactShort4DateStr(Date date) {
        if (null == date) {
            return null;
        }
        return getBeautyShort3DateFormat().format(date);
    }

    /**
     * 日期格式转换为 "yyyy-MM-dd HH:mm:ss"
     *
     * @param date
     * @return
     */
    public static String date2BeautyDateStr(Date date) {
        if (null == date) {
            return null;
        }

        return getBeautyDateFormat().format(date);
    }

    /**
     * 日期格式转换为 "yyyy-MM-dd"
     *
     * @param date
     * @return
     */
    public static String date2BeautyShortDateStr(Date date) {
        if (null == date) {
            return null;
        }

        return getBeautyShortDateFormat().format(date);
    }

    /**
     * 当前时间，格式为 "yyyyMMddHHmmssSSS"
     *
     * @return
     */
    public static String date2FullDateStr() {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YYYYMMDDHHMMSSSSS);
        return sdf.format(new Date());
    }


    /**
     * "yyyyMMddHHmmss" 转换为Date格式
     *
     * @param dateStr
     * @return
     */
    public static Date strCompact2Date(String dateStr) {
        try {
            return getCompactDateFormat().parse(dateStr);
        } catch (ParseException e) {
            LOGGER.error("Parse Date error {}", ExceptionUtils.getStackTrace(e));
            return null;
        }
    }

    /**
     * "yyyyMMdd" 转换为Date格式
     *
     * @param dateStr
     * @return
     */
    public static Date strCompactShort2Date(String dateStr) {
        try {
            return getCompactShortDateFormat().parse(dateStr);
        } catch (ParseException e) {
            LOGGER.error("Parse Date error {}", ExceptionUtils.getStackTrace(e));
            return null;
        }
    }

    /**
     * "yyyy-MM-dd HH:mm:ss" 转换为Date格式
     *
     * @param dateStr
     * @return
     */
    public static Date strBeauty2Date(String dateStr) {
        try {
            return getBeautyDateFormat().parse(dateStr);
        } catch (ParseException e) {
            LOGGER.error("Parse Date error {}", ExceptionUtils.getStackTrace(e));
            return null;
        }
    }

    /**
     * "yyyy-MM-dd"转换为Date格式
     *
     * @param dateStr
     * @return
     */
    public static Date strBeautyShort2Date(String dateStr) {
        try {
            return getBeautyShortDateFormat().parse(dateStr);
        } catch (ParseException e) {
            LOGGER.error("Parse Date error {}", ExceptionUtils.getStackTrace(e));
            return null;
        }
    }

    /**
     * "yyyyMM"转换为Date格式
     *
     * @param dateStr
     * @return
     */
    public static Date strBeautyShort3Date(String dateStr) {
        try {
            return getCompactShort3DateFormat().parse(dateStr);
        } catch (ParseException e) {
            LOGGER.error("Parse Date error {}", ExceptionUtils.getStackTrace(e));
            return null;
        }
    }

    /**
     * "yyyy-MM"转换为Date格式
     *
     * @param dateStr
     * @return
     */
    public static Date strBeautyShort5Date(String dateStr) {
        try {
            return getCompactShort5DateFormat().parse(dateStr);
        } catch (ParseException e) {
            LOGGER.error("Parse Date error {}", ExceptionUtils.getStackTrace(e));
            return null;
        }
    }

    /**
     * "yyyyMM"转换为Date格式
     *
     * @param dateStr
     * @return
     */
    public static Date strBeautyShort4Date(String dateStr) {
        try {
            return getCompactShort3DateFormat().parse(dateStr);
        } catch (ParseException e) {
            LOGGER.error("Parse Date error {}", ExceptionUtils.getStackTrace(e));
            return null;
        }
    }

    /**
     * 自定义格式化日期字符串
     *
     * @param date
     * @param fmt
     * @return
     */
    public static String dateFormatStr(Date date, String fmt) {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        return sdf.format(date);
    }

    /**
     * 设置日期范围转中文显示
     */
    public static String dateRangeStr(Date start, Date end) {
        return dateFormatStr(start, "yyyy年MM月dd日") + "-"
                + dateFormatStr(end, "yyyy年MM月dd日");
    }

    /**
     * @param operDay 运营日
     * @return 运营日时分秒范围
     */
    public static Date[] OperationDateRange(Date operDay) {
        Date[] dateRange = new Date[2];
        dateRange[0] = cn.hutool.core.date.DateUtil.date(operDay)
                .setField(DateField.HOUR_OF_DAY,4)
                .setField(DateField.MINUTE,0)
                .setField(DateField.SECOND,0)
                .toJdkDate();
        dateRange[1] = cn.hutool.core.date.DateUtil.date(operDay)
                .offset(DateField.DAY_OF_YEAR,1)
                .setField(DateField.HOUR_OF_DAY,3)
                .setField(DateField.MINUTE,59)
                .setField(DateField.SECOND,59)
                .toJdkDate();
        return dateRange;
    }

    /**
     * 设置周报时间范围展示
     * @param start
     * @param end
     * @return
     */
    public static String weeklyDataRangeStr(String start, String end){
        return dateFormatStr(strBeautyShort2Date(start), "MM月dd日") + "至"
                + dateFormatStr(strBeautyShort2Date(end), "MM月dd日");
    }

    /**
     * 获取当前日期
     *
     * @return
     */
    public static Date getCurDate() {
        return new Date();
    }

    /**
     * @description: 计算相差的天数
     * @param: begin 开始时间
     * @param: end 开始时间
     * @return:
     */
    public static float getDiffDay(Date begin, Date end) {
        if (begin.after(end)) {
            throw new RuntimeException("开始时间不能小于结束时间");
        }
        return (end.getTime() - begin.getTime()) / (float) (1000 * 3600 * 24);
    }

    /**
     * @description: 计算相差的天数
     * @param: begin 开始日期
     * @param: end 结束日期
     * @return:
     */
    public static int getDiffDay(String begin, String end) {
        Date beginDate = strBeautyShort2Date(begin);
        Date endDate = strBeautyShort2Date(end);
        return (int) ((endDate.getTime() - beginDate.getTime()) / (1000 * 3600 * 24));
    }

    //===============================================


    public static String getCurrentDate() {
        String formatPattern_Short = "yyyyMMddHHmmss";
        SimpleDateFormat format = new SimpleDateFormat(formatPattern_Short);
        return format.format(new Date());
    }

    public static String getCurrentShortDate() {
        String curDatestr = getBeautyShortDateFormat().format(new Date());
        return curDatestr;
    }

    public static String getSeqString() {
        SimpleDateFormat fm = new SimpleDateFormat("yyyyMMddHHmmss"); // "yyyyMMdd G
        return fm.format(new Date());
    }

    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 获取当前时间，格式为 yyyyMMddHHmmss
     *
     * @return
     */
    public static String getCurrentTimeStr(String format) {
        format = StringUtils.isBlank(format) ? FORMAT_YYYY_MM_DD_HH_MM_SS : format;
        Date now = new Date();
        return date2Str(now, format);
    }

    public static String date2Str(Date date) {
        return date2Str(date, FORMAT_YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 时间转换成 Date 类型
     *
     * @param date
     * @param format
     * @return
     */
    public static String date2Str(Date date, String format) {
        if ((format == null) || format.equals("")) {
            format = FORMAT_YYYY_MM_DD_HH_MM_SS;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (date != null) {
            return sdf.format(date);
        }
        return "";
    }

    /**
     * 获取批量付款预约时间
     *
     * @return
     */
    public static String getRevTime() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);
        String dateString = new SimpleDateFormat(DateUtil.FORMAT_YYYYMMDDHHMMSS).format(cal.getTime());
        System.out.println(dateString);
        return dateString;
    }

    /**
     * 时间比较
     *
     * @param date1
     * @param date2
     * @return DATE1>DATE2返回1，DATE1<DATE2返回-1,等于返回0
     */
    public static int compareDate(String date1, String date2, String format) {
        DateFormat df = new SimpleDateFormat(format);
        try {
            Date dt1 = df.parse(date1);
            Date dt2 = df.parse(date2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * @Description: LocalDateTime 转换Date
     * @Version 1.0 2020/09/01 by 唐青霜（tqshuang@grgbanking.com）创建
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Date转LocalDateTime
     *
     * @param date
     * @return
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return localDateTime;

    }

    /**
     * 计算当前日期90天前的日期
     *
     * @return
     */
    public static String beforeDate(int amount) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, -amount);
        Date d = c.getTime();
        String day = format.format(d);
        return day;
    }

    /**
     * 计算指定日期n天后的日期
     *
     * @return
     */
    public static String afterDate(Date start, int amount) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(start);
        c.add(Calendar.DATE, amount);
        Date d = c.getTime();
        String day = format.format(d);
        return day;
    }

    /**
     * 计算指定日期n天后的日期
     *
     * @return
     */
    public static String afterDateStr(String start, int amount) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String day = "";
        try {
            Date startDate = format.parse(start);
            Calendar c = Calendar.getInstance();
            c.setTime(startDate);
            c.add(Calendar.DATE, amount);
            Date d = c.getTime();
            day = format.format(d);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }

    /**
     * @param d:
     * @Description: "yyyy-MM-dd"增加一天
     * @Author: syyang1
     * @Date: 2021/8/10 11:06
     * @return: java.lang.String
     **/
    public static String addOneDay(String d) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        /**
         * 加一天
         */
        try {
            Date dd = df.parse(d);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dd);
            calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
            String addOneDay = df.format(calendar.getTime());
//			System.out.println("增加一天之后：" + df.format(calendar.getTime()));
            return addOneDay;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * @param d:
     * @Description: "yyyy-MM-dd"减一天
     * @Author: syyang1
     * @Date: 2021/8/10 11:12
     * @return: java.lang.String
     **/
    public static String subOneDay(String d) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        /**
         * 减一天
         */
        try {
            long dif = df.parse(d).getTime() - 86400 * 1000;//减一天
            Date date = new Date();
            date.setTime(dif);
            String subOneDay = df.format(date);
//			System.out.println("减少一天之后：" + df.format(date));
            return subOneDay;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }

    /**
     * 获取前n天的日期
     * @param date
     * @param day
     * @return
     */
    public static Date getDateBefore(String date,int day){
        Calendar now = Calendar.getInstance();
        now.setTime(strBeautyShort2Date(date));
        now.set(Calendar.DATE,now.get(Calendar.DATE)-day);
        return now.getTime();
    }

    /**
     * @Description: 当前时间往前几个小时
     * @Author: syyang1
     * @Date: 2021/9/7 11:15
     **/
    public static String getBeforeByHourTime(int hour) {
        String returnstr = "";
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - hour);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        returnstr = df.format(calendar.getTime());
        return returnstr;
    }

    /**
     * 根据指定周期获取周报收取结束日期
     *
     * @param collectCycle
     * @param startDate
     * @return
     */
    public static String getWeeklyCollectEndDate(int collectCycle, String startDate, String endDate) {
        Date begin = strBeautyShort2Date(startDate);
        Date end = strBeautyShort2Date(endDate);

        int diffDate = (int) getDiffDay(begin, end);
        //完整周期数
        int cycle = diffDate / collectCycle;
        int diff = cycle * collectCycle - 1;
        String endDateStr = afterDate(begin, diff);
        return endDateStr;

    }


    /**
     * 获取当前时间月份的第一天开始时间
     *
     * @param date
     * @return
     */
    public static Date getMonthFistDayTime(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 获取当前时间月份的最后一天结束时间
     *
     * @param date
     * @return
     */
    public static Date getMonthLastDayTime(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }


    /**
     * 判断两个日期是否在同一周
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameWeek(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
        //subYear==0,说明是同一年
        if (subYear == 0) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR)) {
                return true;
            }
        }
        //例子:cal1是"2005-1-1"，cal2是"2004-12-25"
        else if (subYear == 1 && cal2.get(Calendar.MONTH) == Calendar.DECEMBER) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR)) {
                return true;
            }
        }
        //例子:cal1是"2004-12-31"，cal2是"2005-1-1"
        else if (subYear == -1 && cal1.get(Calendar.MONTH) == Calendar.DECEMBER) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @Description: 指定时间往前几个小时
     * @Author: syyang1
     * @Date: 2021/9/7 11:15
     **/
    public static String getBeforeByHour(String dateStr, int hour) {
        String returnstr = "";
        Date date = strCompact2Date(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - hour);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        returnstr = df.format(calendar.getTime());
        return returnstr;
    }

    /**
     * @Author liangbeijia
     * @Description 指定时间往后几分钟 dateStr: yyyy-MM-dd HH:mm:ss
     * @Date 2022/1/21
     **/
    public static String getAfterByMinuteBeautyDateStr(String dateStr, int minute){
        String returnstr = "";
        Date date = strBeauty2Date(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        returnstr = df.format(calendar.getTime());
        return returnstr;
    }

    /**
     * @Author liangbeijia
     * @Description 指定时间往后几个小时 dateStr: yyyy-MM-dd HH:mm:ss
     * @Date 2022/1/21
     **/
    public static String getAfterByHourBeautyDateStr(String dateStr, int hour){
        String returnstr = "";
        Date date = strBeauty2Date(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hour);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        returnstr = df.format(calendar.getTime());
        return returnstr;
    }



    /**
     * @Author ganxingjian
     * @Description 根据“yyyy-MM” 获取当月的全部日期
     * @Date 21:52 2021/10/13
     **/
    public static List<String> getMonthFullDay(String yuarAndMonth) {
        String[] split = yuarAndMonth.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);

        SimpleDateFormat dateFormatYYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");
        List<String> fullDayList = new ArrayList<>(32);
        // 获得当前日期对象
        Calendar cal = Calendar.getInstance();
        cal.clear();// 清除信息
        cal.set(Calendar.YEAR, year);
        // 1月从0开始
        cal.set(Calendar.MONTH, month - 1);
        // 当月1号
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int count = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int j = 1; j <= count; j++) {
            fullDayList.add(dateFormatYYYYMMDD.format(cal.getTime()));
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }
        return fullDayList;
    }


    /**
     * 获取指定日期的开始时间
     *
     * @param date
     * @return
     */
    public static Date getStartDate(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(Calendar.HOUR_OF_DAY, 0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        return instance.getTime();
    }

    /**
     * 获取指定日期的结束时间
     *
     * @param date
     * @return
     */
    public static Date getEndDate(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(Calendar.HOUR_OF_DAY, 23);
        instance.set(Calendar.MINUTE, 59);
        instance.set(Calendar.SECOND, 59);
        return instance.getTime();
    }

    /**
     * @Description: 获取上月月份"yyyy-MM"
     * @Author: syyang1
     * @Date: 2021/10/23 11:02
     **/
    public static String getLastMonth() {
        LocalDate today = LocalDate.now();
        today = today.minusMonths(1);
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM");
        return formatters.format(today);
    }

    /**
     * @Description: 获取给定月份的前一月/前一年
     * @Author: syyang1
     * @Date: 2021/10/28 10:39
     **/
    public static String getLastMonth(String dateStr, int addYear, int addMonth, int addDate) throws Exception {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            Date sourceDate = sdf.parse(dateStr);
            Calendar cal = Calendar.getInstance();
            cal.setTime(sourceDate);
            cal.add(Calendar.YEAR, addYear);
            cal.add(Calendar.MONTH, addMonth);
            cal.add(Calendar.DATE, addDate);

            SimpleDateFormat returnSdf = new SimpleDateFormat("yyyy-MM");
            String dateTmp = returnSdf.format(cal.getTime());
            Date returnDate = returnSdf.parse(dateTmp);
            return dateTmp;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    /**
     * 获取到两个时间相差的年份,例如  2000-2020，返回回来的是一个2000（包含）-2020（包含）的所有年份
     *
     * @param begindate
     * @param enddate
     * @throws ParseException
     */
    private static List<String> getYears(String begindate, String enddate) {
        List<String> lists = new ArrayList<String>();
        String benginYear = begindate;
        String endYear = enddate;
        int a = Integer.valueOf(endYear) - Integer.valueOf(benginYear);
        for (int i = 0; i <= a; i++) {
            String date = String.valueOf(Integer.valueOf(benginYear) + i);
            lists.add(date);
        }
        return lists;
    }

    /**
     * 获取两个月份之间的所有月份(含跨年)
     *
     * @param minDate
     * @param maxDate
     * @return
     * @throws ParseException
     */
    public static List<String> getMonthBetween(String minDate, String maxDate) {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");// 格式化为年月
        try {
            Calendar min = Calendar.getInstance();
            Calendar max = Calendar.getInstance();

            min.setTime(sdf.parse(minDate));
            min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

            max.setTime(sdf.parse(maxDate));
            max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

            Calendar curr = min;
            while (curr.before(max)) {
                result.add(sdf.format(curr.getTime()));
                curr.add(Calendar.MONTH, 1);
            }

            // 实现排序方法
            Collections.sort(result, new Comparator<Object>() {
                @Override
                public int compare(Object o1, Object o2) {
                    String str1 = (String) o1;
                    String str2 = (String) o2;
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
                    Date date1 = null;
                    Date date2 = null;
                    try {
                        date1 = format.parse(str1);
                        date2 = format.parse(str2);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    if (date2.compareTo(date1) > 0) {
                        return -1;
                    }
                    return 1;
                }
            });
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 查找前几个月
     *
     * @param month
     * @return
     */
    public static String beforeOneMonth(String month, int before) {
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM");
        YearMonth yearMonth = YearMonth.parse(month);
        return yearMonth.minus(before, ChronoUnit.MONTHS).toString();
    }

    /**
     * 返回指定月份第一天
     *
     * @param month
     * @return
     */
    public static String getStartOfMonth(String month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(month.substring(0, 4)), Integer.parseInt(month.substring(5, 7)) - 1, 1);
        return new SimpleDateFormat("yyyy-MM-dd ").format(calendar.getTime());

    }

    /**
     * 返回指定月份最后一天
     *
     * @param month
     * @return
     */
    public static String getEndOfMonth(String month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(month.substring(0, 4)), Integer.parseInt(month.substring(5, 7)), 1);//这里先设置要获取月份的下月的第一天
        calendar.add(Calendar.DATE, -1);//这里将日期值减去一天，从而获取到要求的月份最后一天
        return new SimpleDateFormat("yyyy-MM-dd ").format(calendar.getTime());

    }

    /**
     * 获取给定月份的前一月的指定日期
     *
     * @param dateStr
     * @param addYear
     * @param addMonth
     * @param addDate
     * @return
     * @throws Exception
     */
    public static String getLastMonthDate(String dateStr, int addYear, int addMonth, int addDate) throws Exception {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            Date sourceDate = sdf.parse(dateStr);
            Calendar cal = Calendar.getInstance();
            cal.setTime(sourceDate);
            cal.add(Calendar.YEAR, addYear);
            cal.add(Calendar.MONTH, addMonth);
            cal.add(Calendar.DATE, addDate - 1);

            SimpleDateFormat returnSdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateTmp = returnSdf.format(cal.getTime());
            Date returnDate = returnSdf.parse(dateTmp);
            return dateTmp;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    /**
     * 判断时间是否早于当前时间
     *
     * @param dateTime
     * @return
     */
    public static boolean beforeCurrent(String dateTime) {
        Date startTime = getCurDate();
        Date endTime = strBeauty2Date(dateTime);
        assert endTime != null;
        //表示时间早于当前
        return endTime.before(startTime);
    }

    /**
     * 判断日期是否早于当前日期
     *
     * @param dateTime
     * @return
     */
    public static boolean beforeCurrentDate(String dateTime) {
        Date startTime = getCurDate();
        Date endTime = strBeautyShort2Date(dateTime);
        assert endTime != null;
        //表示时间早于当前
        return endTime.before(startTime);
    }

    /**
     * 判断日期是否在指定时间范围内
     *
     * @param start
     * @param end
     * @param dateTime
     * @return
     */
    public static boolean specialRangeDate(Date start, Date end, Date dateTime) {
        assert start != null;
        return (start.equals(dateTime) || start.before(dateTime)) && (end.equals(dateTime) || dateTime.before(end));
    }

    /**
     * 时间转换
     *
     * @param str
     * @return
     */
    public static Date getSimpleDateFormat(String str) {
        Date startTime = null;
        try {
            Date date = new SimpleDateFormat("yyyy年MM月dd日").parse(str);
            String now = new SimpleDateFormat("yyyy-MM-dd").format(date);
            startTime = new SimpleDateFormat("yyyy-MM-dd").parse(now);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return startTime;
    }

    /**
     * yyyyMM转yyyy-MM
     *
     * @param str
     * @return
     */
    public static String beautyMonthStr(String str) {
        try {
            Date dateFormat = getBeautyShort3DateFormat().parse(str);
            return getBeautyShort3DateFormat().format(dateFormat);
        } catch (ParseException e) {
            LOGGER.error("Parse Date error {}", ExceptionUtils.getStackTrace(e));
            return null;
        }
    }

    /**
     * @Description: 获取本月月份"yyyy-MM"
     * @Author: zengkun1
     * @Date: 2021-12-27 10:23
     **/
    public static String getCurrentMonth() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM");
        return formatters.format(today);
    }

    /**
     * @Description: 获取当前年份"yyyy"
     * @Author: zengkun1
     * @Date:2021-12-27 10:23
     **/
    public static String getCurrentYear() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy");
        return formatters.format(today);
    }

    /**
     * @Author liangbeijia
     * @Description 获取某一年的上一年
     * @Date 2022/1/28
     **/
    public static String getLastYear(String year) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String lastYear;
        try{
            Date sourceDate = sdf.parse(year);
            Calendar cal = Calendar.getInstance();
            cal.setTime(sourceDate);
            cal.add(Calendar.YEAR, -1);
            lastYear = sdf.format(cal.getTime());
        }catch (Exception e){
            lastYear = null;
        }

        return lastYear;
    }

    /**
     * @Author liangbeijia
     * @Description 获取某一年的所有月份
     * @Date 2022/1/28
     **/
    public static List<String> getMonthsInYear(String year){
        List<String> months = new ArrayList<>();
        try{
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
            String firstMonth = year + "-01";
            String endMonth = year + "-12";
            Date firstDate = format.parse(firstMonth);
            Date endDate = format.parse(endMonth);
            Calendar cal = Calendar.getInstance();
            cal.setTime(firstDate);
            while(cal.getTime().before(endDate)){
                String yearMonth = format.format(cal.getTime());
                months.add(yearMonth);
                cal.add(Calendar.MONTH, 1);
            }
            months.add(endMonth);
        }catch (Exception e){

        }
        return months;
    }


    /**
     * @param str，年份、月份、日期的字符串
     * @Description: 获取当年的1份月"yyyy-01"
     * @Author: zengkun1
     * @Date:2021-12-27 10:23
     **/
    public static String getFirstMonth(String str) {
        String year = str.substring(0, 4);
        return year + "-01";
    }

    /**
     * @param str，年份、月份、日期的字符串
     * @Description: 获取当年的1份月"yyyy-01"
     * @Author: zengkun1
     * @Date:2021-12-27 10:23
     **/
    public static String getLastMonth(String str) {
        String year = str.substring(0, 4);
        return year + "-12";
    }

    /**
     * @param str，年份、月份、日期的字符串
     * @Description: 将yyyy-MM转化成yyyy年MM月
     * @Author: zengkun1
     * @Date:2021-12-27 10:23
     **/
    public static String strtoChinese(String str) {
        if (StringUtils.isEmpty(str)) {
            return Strings.EMPTY;
        }
        return str.replace("-", "年") + "月";
    }

    /**
     * @param str，
     * @Description: 将yyyy年MM月转化成yyyy-MM
     * @Author: zengkun1
     * @Date:2021-12-27 10:23
     **/
    public static String ChineseToStr(String str) {
        if (StringUtils.isEmpty(str)) {
            return Strings.EMPTY;
        }
        return str.replace("年", "-").replace("月", "");
    }

    /**
     * @param str，
     * @Description: 从yyyy-MM/yyyy-MM-dd/yyyy-MM-dd :HH:mm:ss 中获取MM月份
     * @Author: zengkun1
     * @Date:2022-1-8 14:09
     **/
    public static String strToMonth(String str) {
        if (StringUtils.isEmpty(str)) {
            return Strings.EMPTY;
        }
        return str.substring(5, 7);
    }

    /**
     * @Description 根据开始日期和结束日期求中间所有日期集合
     * @Date 14:39 2021/12/29
     **/
    public static List<String> getTwoDaysDayDes(String startDate, String endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> dateList = new ArrayList<String>();
        try {

            Date dateOne = sdf.parse(startDate);
            Date dateTwo = sdf.parse(endDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateOne);
            dateList.add(startDate);
            while (dateTwo.after(calendar.getTime())) {
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                dateList.add(sdf.format(calendar.getTime()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateList;
    }

    /**
     * @Description 根据开始日期和结束日期求中间所有日期集合
     * @Date 14:39 2021/12/29
     **/
    public static List<Date> getTwoDaysDayDes(Date dateOne, Date dateTwo) {
        List<Date> dateList = new ArrayList<>();
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateOne);
            dateList.add(dateOne);
            while (dateTwo.after(calendar.getTime())) {
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                dateList.add(calendar.getTime());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateList;
    }

    /**
     * 获取yyyy-mm所属季度
     *
     * @return
     */
    public static int getMonthQuarter(String monthStr) {
        int season = 0;
        Date monthDate = strBeautyShort5Date(monthStr);
        Calendar c = Calendar.getInstance();
        c.setTime(monthDate);
        int month = c.get(Calendar.MONTH);
        switch (month) {
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
            case Calendar.MARCH:
                season = 1;
                break;
            case Calendar.APRIL:
            case Calendar.MAY:
            case Calendar.JUNE:
                season = 2;
                break;
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.SEPTEMBER:
                season = 3;
                break;
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
            case Calendar.DECEMBER:
                season = 4;
                break;
            default:
                break;

        }
        return season;
    }

    /**
     * 判断月份是否为季度最后一个月
     *
     * @param month
     * @return
     */
    public static boolean isLastMonthOfQuarter(String month) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date monthDate = sdf.parse(month);
        Calendar c = Calendar.getInstance();
        c.setTime(monthDate);
        int monthNum = c.get(Calendar.MONTH) + 1;
        return monthNum % 3 == 0;

    }

    /**
     * yyyy-mm获取年份
     *
     * @return
     */
    public static String getYear(String month) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return String.valueOf(sdf.parse(month));
    }

    /**
     * 获取某年第一天日期
     *
     * @param year 年份
     * @return Date
     */
    public static Date getYearFirstDay(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    /**
     * 获取某年最后一天日期
     *
     * @param year 年份
     * @return Date
     */
    public static Date getYearLastDay(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();
        return currYearLast;
    }

    /**
     * @param time 时间: 年月日时分秒
     * @return 返回时间所属的运营日
     */
    public static Date modifyTimeToOperationDay(Date time) {
        DateTime dateTime = cn.hutool.core.date.DateUtil.date(time);
        int hour = dateTime.hour(true);
        if (hour<4){
            dateTime = cn.hutool.core.date.DateUtil.offsetDay(time, -1);
        }
        return  dateTime.setField(DateField.HOUR, 0)
                .setField(DateField.MINUTE, 0)
                .setField(DateField.SECOND, 0).toJdkDate();
    }

    /**
     * 根据“yyyy-MM” 获取当月的天数
     *
     * @param yearAndMonth
     * @return
     */
    public static Integer getDaysByMonth(String yearAndMonth) {
        String[] split = yearAndMonth.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        // 获得当前日期对象
        Calendar cal = Calendar.getInstance();
        cal.clear();// 清除信息
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        // 当月1号
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 计算当前日期90天前的日期
     *
     * @return
     */
    public static String beforeDateFormat(Date start,int amount) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        c.setTime(start);
        c.add(Calendar.DATE, -amount);
        Date d = c.getTime();
        String day = format.format(d);
        return day;
    }

    /**
     * 计算当前日期90天前的日期（yyyymmdd）
     *
     * @return
     */
    public static String beforeDateFormat(int amount) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, -amount);
        Date d = c.getTime();
        String day = format.format(d);
        return day;
    }

    /***
     * @param strDate yyyyMMdd类型字符串
     * @return yyyy-MM-dd类型字符串
     */
    public static String toFormatDate(String strDate) {
        try {
            Date date = new SimpleDateFormat("yyyyMMdd").parse(strDate);
            return new SimpleDateFormat("yyyy-MM-dd").format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
