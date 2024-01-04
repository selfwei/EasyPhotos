package com.huantansheng.easyphotos.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 说明：日期工具类
 * <p>
 * 创建人：homecy
 * 创建时间：2021/9/15
 * <p>
 * 操作列表 编号 | 操作时间 | 操作人员 | 操作说明 （Create、Modify、Deprecated）
 * 操作列表 (1) | 2021/9/15 | homecy | Create
 */
public final class DateUtil
{
    public static final SimpleDateFormat y2sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat M2mFormat = new SimpleDateFormat("MM-dd HH:mm");
    public static final SimpleDateFormat y2dFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat H2sFormat = new SimpleDateFormat("HH:mm:ss");

    public static final SimpleDateFormat M2dFormat_cn = new SimpleDateFormat("MM月dd日");
    public static final SimpleDateFormat y2dFormat_cn = new SimpleDateFormat("yyyy年MM月dd日");
    public static final SimpleDateFormat y2sFormat_cn = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");

    private static final int[] DAY_OF_MONTH = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static final String DATE_FORMAT_NORMAL = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FORMAT_DAY = "yyyy/MM/dd";

    public static final String DATE_FORMAT_JOIN_DAY = "yyyy-MM-dd";

    public static final String DATE_FORMAT_FILE_NAME = "yyyyMMddHHmmssSSS";

    /**
     * 取得自1970.1.1以来的秒数
     *
     * @return long 自1970.1.1以来的秒数
     */
    public static long getNowTime()
    {
        return new Date().getTime() / 1000;
    }

    /**
     * 添加指定的月份
     *
     * @param date
     * @param monthAmount
     * @return
     */
    public static Date addMonth(Date date, int monthAmount)
    {
        if (date == null)
        {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, monthAmount);
        return calendar.getTime();
    }

    /**
     * 取得指定天数后的时间
     *
     * @param date      基准时间
     * @param dayAmount 指定天数，允许为负数
     * @return Date 指定天数后的时间
     */
    public static Date addDay(Date date, int dayAmount)
    {
        if (date == null)
        {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, dayAmount);
        return calendar.getTime();
    }

    /**
     * 取得指定小时数后的时间
     *
     * @param date       基准时间
     * @param hourAmount 指定小时数，允许为负数
     * @return Date 指定小时数后的时间
     */
    public static Date addHour(Date date, int hourAmount)
    {
        if (date == null)
        {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hourAmount);
        return calendar.getTime();
    }

    /**
     * 取得指定分钟数后的时间
     *
     * @param date         基准时间
     * @param minuteAmount 指定分钟数，允许为负数
     * @return Date 指定分钟数后的时间
     */
    public static Date addMinute(Date date, int minuteAmount)
    {
        if (date == null)
        {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minuteAmount);
        return calendar.getTime();
    }

    /**
     * 取得指定毫秒数后的时间
     *
     * @param date         基准时间
     * @param millisecondAmount 指定毫秒数，允许为负数
     * @return Date 指定毫秒数后的时间
     */
    public static Date addMillisecond(Date date, int millisecondAmount)
    {
        if (date == null)
        {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MILLISECOND, millisecondAmount);
        return calendar.getTime();
    }

    /**
     * 比较两日期对象中的小时和分钟部分的大小.
     *
     * @param date        日期对象1, 如果为 <code>null</code> 会以当前时间的日期对象代替
     * @param anotherDate 日期对象2, 如果为 <code>null</code> 会以当前时间的日期对象代替
     * @return int 如果日期对象1大于日期对象2, 则返回大于0的数; 反之返回小于0的数; 如果两日期对象相等, 则返回0.
     */
    public static int compareHourAndMinute(Date date, Date anotherDate)
    {
        if (date == null)
        {
            date = new Date();
        }

        if (anotherDate == null)
        {
            anotherDate = new Date();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hourOfDay1 = cal.get(Calendar.HOUR_OF_DAY);
        int minute1 = cal.get(Calendar.MINUTE);

        cal.setTime(anotherDate);
        int hourOfDay2 = cal.get(Calendar.HOUR_OF_DAY);
        int minute2 = cal.get(Calendar.MINUTE);

        if (hourOfDay1 > hourOfDay2)
        {
            return 1;
        }
        else if (hourOfDay1 == hourOfDay2)
        {
            // 小时相等就比较分钟
            return minute1 > minute2 ? 1 : (minute1 == minute2 ? 0 : -1);
        }
        else
        {
            return -1;
        }
    }

    /**
     * 比较两日期对象的大小, 忽略秒, 只精确到分钟.
     *
     * @param date        日期对象1, 如果为 <code>null</code> 会以当前时间的日期对象代替
     * @param anotherDate 日期对象2, 如果为 <code>null</code> 会以当前时间的日期对象代替
     * @return int 如果日期对象1大于日期对象2, 则返回大于0的数; 反之返回小于0的数; 如果两日期对象相等, 则返回0.
     */
    public static int compareIgnoreSecond(Date date, Date anotherDate)
    {
        if (date == null)
        {
            date = new Date();
        }

        if (anotherDate == null)
        {
            anotherDate = new Date();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        date = cal.getTime();

        cal.setTime(anotherDate);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        anotherDate = cal.getTime();

        return date.compareTo(anotherDate);
    }

    /**
     * 取得当前时间的字符串表示，格式为2006-01-10 20:56:30.756
     *
     * @return String 当前时间的字符串表示
     */
    public static String currentDate2String()
    {
        return date2String(new Date());
    }

    /**
     * 时间戳（秒）转化为日期
     *
     * @param seconds 时间戳
     * @return Date日期
     */
    public static Date long2Date(long seconds)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(seconds * 1000);
        return calendar.getTime();
    }

    /**
     * 时间戳（秒）格式化为2006-01-10 20:56:30.756
     *
     * @param seconds 时间戳
     * @return String 当前时间的字符串表示
     */
    public static String time2String(long seconds)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(seconds * 1000);
        return date2String(calendar.getTime());
    }

    /**
     * 取得当前时间的字符串表示，格式为2006-01-10
     *
     * @return String 当前时间的字符串表示
     */
    public static String currentDate2StringByDay()
    {
        return date2StringByDay(new Date());
    }

    /**
     * 取得今天的最后一个时刻
     *
     * @return Date 今天的最后一个时刻
     */
    public static Date currentEndDate()
    {
        return getEndDate(new Date());
    }

    /**
     * 取得今天的第一个时刻
     *
     * @return Date 今天的第一个时刻
     */
    public static Date currentStartDate()
    {
        return getStartDate(new Date());
    }

    /**
     * 把时间转换成字符串，格式为2006-01-10 20:56:30.756
     *
     * @param date 时间
     * @return String 时间字符串
     */
    public static String date2String(Date date)
    {
        return date2String(date, "yyyy-MM-dd HH:mm:ss.SSS");
    }

    /**
     * 把时间转换成字符串，格式为20060110205630756
     *
     * @return String 时间字符串
     */
    public static String date2String()
    {
        return date2String(new Date(), "yyyyMMddHHmmssSSS");
    }

    /**
     * 按照指定格式把时间转换成字符串，格式的写法类似yyyy-MM-dd HH:mm:ss.SSS
     *
     * @param date    时间
     * @param pattern 格式
     * @return String 时间字符串
     */
    public static String date2String(Date date, String pattern)
    {
        if (date == null)
        {
            return null;
        }
        return (new SimpleDateFormat(pattern)).format(date);
    }

    /**
     * 时间转字符串
     *
     * @param format 时间格式
     * @param date   日期
     * @return String
     */
    public static String date2Str(SimpleDateFormat format, Date date)
    {
        return format.format(date);
    }

    /**
     * 把时间转换成字符串，格式为2006-01-10
     *
     * @param date 时间
     * @return String 时间字符串
     */
    public static String date2StringByDay(Date date)
    {
        return date2String(date, "yyyy-MM-dd");
    }

    /**
     * 把时间转换成字符串，格式为2006-01
     *
     * @param date 时间
     * @return String 时间字符串
     */
    public static String date2StringByMonth(Date date)
    {
        return date2String(date, "yyyy-MM");
    }

    /**
     * 把时间转换成字符串，格式为2006-01-10 20:56
     *
     * @param date 时间
     * @return String 时间字符串
     */
    public static String date2StringByMinute(Date date)
    {
        return date2String(date, "yyyy-MM-dd HH:mm");
    }

    /**
     * 把时间转换成字符串，格式为2006-01-10 20:56:30
     *
     * @param date 时间
     * @return String 时间字符串
     */
    public static String date2StringBySecond(Date date)
    {
        return date2String(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 把时间转换成字符串，格式为20060110205630
     *
     * @param date 时间
     * @return String 时间字符串
     */
    public static String date2StringName(Date date)
    {
        return date2String(date, "yyyyMMddHHmmss");
    }

    /**
     * 根据某星期几的英文名称来获取该星期几的中文数. <br>
     * monday -> 一; sunday -> 日
     *
     * @param englishWeekName 星期的英文名称
     * @return String 星期的中文数
     */
    public static String getChineseWeekNumber(String englishWeekName)
    {
        if ("monday".equalsIgnoreCase(englishWeekName))
        {
            return "一";
        }

        if ("tuesday".equalsIgnoreCase(englishWeekName))
        {
            return "二";
        }

        if ("wednesday".equalsIgnoreCase(englishWeekName))
        {
            return "三";
        }

        if ("thursday".equalsIgnoreCase(englishWeekName))
        {
            return "四";
        }

        if ("friday".equalsIgnoreCase(englishWeekName))
        {
            return "五";
        }

        if ("saturday".equalsIgnoreCase(englishWeekName))
        {
            return "六";
        }

        if ("sunday".equalsIgnoreCase(englishWeekName))
        {
            return "日";
        }

        return null;
    }

    /**
     * 根据指定的年, 月, 日等参数获取日期对象.
     *
     * @param year  年
     * @param month 月
     * @param date  日
     * @return Date 对应的日期对象
     */
    public static Date getDate(int year, int month, int date)
    {
        return getDate(year, month, date, 0, 0);
    }

    /**
     * 根据指定的年, 月, 日, 时, 分等参数获取日期对象.
     *
     * @param year      年
     * @param month     月
     * @param date      日
     * @param hourOfDay 时(24小时制)
     * @param minute    分
     * @return Date 对应的日期对象
     */
    public static Date getDate(int year, int month, int date, int hourOfDay, int minute)
    {
        return getDate(year, month, date, hourOfDay, minute, 0);
    }

    /**
     * 根据指定的年, 月, 日, 时, 分, 秒等参数获取日期对象.
     *
     * @param year      年
     * @param month     月
     * @param date      日
     * @param hourOfDay 时(24小时制)
     * @param minute    分
     * @param second    秒
     * @return Date 对应的日期对象
     */
    public static Date getDate(int year, int month, int date, int hourOfDay, int minute, int second)
    {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, date, hourOfDay, minute, second);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    /**
     * 取得某个日期是星期几，星期日是1，依此类推
     *
     * @param date 日期
     * @return int 星期几
     */
    public static int getDayOfWeek(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取某天的结束时间, e.g. 2005-10-01 23:59:59.999
     *
     * @param date 日期对象
     * @return Date 该天的结束时间
     */
    public static Date getEndDate(Date date)
    {
        if (date == null)
        {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);

        return cal.getTime();
    }

    /**
     * 取得一个月最多的天数
     *
     * @param year  年份
     * @param month 月份，0表示1月，依此类推
     * @return int 最多的天数
     */
    public static int getMaxDayOfMonth(int year, int month)
    {
        if (month == 1 && isLeapYear(year))
        {
            return 29;
        }
        return DAY_OF_MONTH[month];
    }

    /**
     * 得到指定日期的下一天
     *
     * @param date 日期对象
     * @return Date 同一时间的下一天的日期对象
     */
    public static Date getNextDay(Date date)
    {
        return addDay(date, 1);
    }

    /**
     * 获取某天的起始时间, e.g. 2005-10-01 00:00:00.000
     *
     * @param date 日期对象
     * @return Date 该天的起始时间
     */
    public static Date getStartDate(Date date)
    {
        if (date == null)
        {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    /**
     * 获取本月第一天 e.g. 2019-10-01 00:00:00.000
     *
     * @param date 日期对象
     * @return Date 本月第一天起始时间
     */
    public static Date getMonthStartDate(Date date)
    {
        if (date == null)
        {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    /**
     * 获取本月最后一天 e.g. 2019-10-31 00:00:00.000
     *
     * @param date 日期对象
     * @return Date 本月最后一天起始时间
     */
    public static Date getMonthEndDate(Date date)
    {
        if (date == null)
        {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.DATE, getMaxDayOfMonth(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    /**
     * 根据日期对象来获取日期中的时间(HH:mm:ss).
     *
     * @param date 日期对象
     * @return String 时间字符串, 格式为: HH:mm:ss
     */
    public static String getTime(Date date)
    {
        if (date == null)
        {
            return null;
        }

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        return format.format(date);
    }

    /**
     * 根据日期对象来获取日期中的时间(HH:mm).
     *
     * @param date 日期对象
     * @return String 时间字符串, 格式为: HH:mm
     */
    public static String getTimeIgnoreSecond(Date date)
    {
        if (date == null)
        {
            return null;
        }

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(date);
    }

    /**
     * 判断是否是闰年
     *
     * @param year 年份
     * @return boolean 是true，否则false
     */
    public static boolean isLeapYear(int year)
    {
        Calendar calendar = Calendar.getInstance();
        return ((GregorianCalendar) calendar).isLeapYear(year);
    }

    /**
     * 把字符串转换成日期，格式为2006-01-10
     *
     * @param str 字符串
     * @return Date 日期
     */
    public static Date string2Date(String str)
    {
        return string2Date(str, "yyyy-MM-dd");
    }

    /**
     * 按照指定的格式把字符串转换成时间，格式的写法类似yyyy-MM-dd HH:mm:ss.SSS
     *
     * @param str     字符串
     * @param pattern 格式
     * @return Date 时间
     */
    public static Date string2Date(String str, String pattern)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try
        {
            date = dateFormat.parse(str);
        }
        catch (ParseException e)
        {
        }

        return date;
    }

    /**
     * 把字符串转换成日期，格式为2006-01-10 20:56:30
     *
     * @param str 字符串
     * @return Date 日期
     */
    public static Date string2DateTime(String str)
    {
        return string2Date(str, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 取得一年中的第几周。
     *
     * @param date 日期
     * @return int 第几周
     */
    public static int getWeekOfYear(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取上周的指定星期的日期。
     *
     * @param dayOfWeek 星期几，取值范围是 {@link Calendar#MONDAY} - {@link Calendar#SUNDAY}
     * @return Date 上周的指定星期的日期
     */
    public static Date getDateOfPreviousWeek(int dayOfWeek)
    {
        if (dayOfWeek > 7 || dayOfWeek < 1)
        {
            throw new IllegalArgumentException("参数必须是1-7之间的数字");
        }

        return getDateOfRange(dayOfWeek, -7);
    }

    /**
     * 获取本周的指定星期的日期。
     *
     * @param dayOfWeek 星期几，取值范围是 {@link Calendar#MONDAY} - {@link Calendar#SUNDAY}
     * @return Date 本周的指定星期的日期
     */
    public static Date getDateOfCurrentWeek(int dayOfWeek)
    {
        if (dayOfWeek > 7 || dayOfWeek < 1)
        {
            throw new IllegalArgumentException("参数必须是1-7之间的数字");
        }

        return getDateOfRange(dayOfWeek, 0);
    }

    /**
     * 获取下周的指定星期的日期。
     *
     * @param dayOfWeek 星期几，取值范围是 {@link Calendar#MONDAY} - {@link Calendar#SUNDAY}
     * @return Date 下周的指定星期的日期
     */
    public static Date getDateOfNextWeek(int dayOfWeek)
    {
        if (dayOfWeek > 7 || dayOfWeek < 1)
        {
            throw new IllegalArgumentException("参数必须是1-7之间的数字");
        }

        return getDateOfRange(dayOfWeek, 7);
    }

    /**
     * 获取指定星期的日期
     *
     * @param dayOfWeek  星期几，取值范围是 {@link Calendar#MONDAY} - {@link Calendar#SUNDAY}
     * @param dayOfRange -7,0,7
     * @return 指定星期的日期
     */
    private static Date getDateOfRange(int dayOfWeek, int dayOfRange)
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) + dayOfRange);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取年份
     *
     * @param date 日期
     * @return Integer
     */
    public static Integer getYear(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取月份
     *
     * @param date 日期
     * @return Integer
     */
    public static Integer getMonth(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取日
     *
     * @param date 日期
     * @return Integer
     */
    public static Integer getDate(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取星期几
     *
     * @return String
     */
    public static String getWeek()
    {
        Calendar cal = Calendar.getInstance();
        int i = cal.get(Calendar.DAY_OF_WEEK);
        switch (i)
        {
            case 1:
                return "星期日";
            case 2:
                return "星期一";
            case 3:
                return "星期二";
            case 4:
                return "星期三";
            case 5:
                return "星期四";
            case 6:
                return "星期五";
            case 7:
                return "星期六";
            default:
                return "";
        }
    }

    public static boolean isToday(String timeStr)
    {
        Date timeDate = string2Date(timeStr);
        Date currentDate = string2Date(date2StringByDay(new Date()));
        return timeDate.equals(currentDate);
    }

    /**
     * 把时间转换成字符串，格式为2006-01-10
     *
     * @param date 时间
     * @return String 时间字符串
     */
    public static Long day2Long(Date date)
    {
        return string2Date(date2String(date, "yyyy-MM-dd"), "yyyy-MM-dd").getTime();
    }

    /**
     * @return 日期字符串转换时间戳
     */
    public static Long dateStr2Long(String date, String format)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try
        {
            return sdf.parse(date).getTime();
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            return 0L;
        }
    }

    public static int differentDays(Date date1, Date date2)
    {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);

        int day1 = calendar1.get(Calendar.DAY_OF_YEAR);
        int day2 = calendar2.get(Calendar.DAY_OF_YEAR);
        int year1 = calendar1.get(Calendar.YEAR);
        int year2 = calendar2.get(Calendar.YEAR);

        if (year1 != year2)  //不同年
        {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++)
            {
                //闰年
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0)
                {
                    timeDistance += 366;
                }
                else
                {
                    // 不是闰年
                    timeDistance += 365;
                }
            }
            return timeDistance + (day2 - day1);
        }
        else
        {
            // 同年
            return day2 - day1;
        }

    }
}
