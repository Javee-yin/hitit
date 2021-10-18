package per.javee.hitit.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.format.DateTimeParseException;
import java.util.*;

/**
 * Date Utils
 * @date: 2021年10月18日
 * @version: 1.0
 */
@Slf4j
public class HititDateUtil {

	private HititDateUtil() {}

	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static final String DATE_FORMAT_M = "yyyy-MM-dd HH:mm:ss.SSS";

	public static final String DATE_FORMAT_VUE = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

	public static final String DATE_FORMAT_ISO = "yyyy-MM-dd'T'HH:mm:ss.SSS";

	public static final String DATE_FORMAT1 = "yyyy-MM-dd";

	private static final String DATE_FORMAT_FOR_FILENAME = "yyyyMMddHHmmss";

	public static final String DATE_FORMAT_FOR_MONTH = "yyyy-MM";

	public static final String DATE_FORMAT22 = "YYYY/MM/DD";

	private static final String DATE_FORMAT2 = "yyyy/MM/dd";

	private static final String DATE_FORMAT3 = "yyyyMMddhhmmss";

	private static final SimpleDateFormat format1 = new SimpleDateFormat(DATE_FORMAT1);

	private static final SimpleDateFormat format2 = new SimpleDateFormat(DATE_FORMAT2);

	private static final SimpleDateFormat format3 = new SimpleDateFormat(DATE_FORMAT3);

	private static final SimpleDateFormat format4 = new SimpleDateFormat(DATE_FORMAT_FOR_MONTH);

	private static Date date900 = null;
	private static Date date999 = null;

	static{
		try {
			date900 = format1.parse("1900-01-01");
			date999 = format1.parse("9999-01-01");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 判断 日期是否在中间
	 * @param start
	 * @param target
	 * @param end
	 * @return
	 */
	public static boolean between(Date start,Date target,Date end){

		if(start == null
				|| target == null
				|| end == null){
			return false;
		}

		if(start.after(end)){
			throw new RuntimeException("start mast befor end time");
		}

		if(start.after(target)){
			return false;
		}

		if(target.after(end)){
			return false;
		}

		return true;
	}

	/**
	 * 在时间的基础上加上多少秒
	 * @param add
	 * @param s
	 * @return
	 */
	public static Date addSecend(Date add,int s){
		Calendar c = Calendar.getInstance();  
		c.setTime(add);  
		c.add(Calendar.SECOND, s);
		return c.getTime();
	}

	public static String getDate999(String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date999);
	}

	public static String getDate00(String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date900);
	}

	/**
	 * 获取时间字符串
	 * @return
	 */
	public static String getDateString(){
		return format3.format(new Date());
	}

	/**
	 * 当前时间戳
	 * @return
	 */
	public static Long currentTimeMillis(){
		return System.currentTimeMillis();
	}

	/**
	 * 当前时间戳
	 * @return
	 */
	public static Date currentTime(){
		return new Date();
	}


	/**
	 * 校验date时间格式是否OK
	 * eg:
	 * 1. 2019-01-02 -> true
	 * 2. 2019/01/02 -> true
	 * 3. 20190102 -> false
	 * 4. null -> false
	 * 5. "" -> false
	 * 6. "123123" -> false
	 * @param date
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static boolean volidate(String date) {

		if(date == null || date.trim().length() == 0 ){
			return false;
		}

		try {
			return format1.parse(date) != null;
		} catch (Exception e) {}

		try {
			return format2.parse(date) != null;
		} catch (Exception e) {}

		try {
			return format4.parse(date) != null;
		} catch (Exception e) {}

		try {
			return new Date(date) != null;
		} catch (Exception e) {}

		return false;
	}

	/**
	 * 转换类型
	 * @param date
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static Date exchange(String date) {

		if(date == null || date.trim().length() == 0 ){
			return null;
		}

		try {
			return format1.parse(date) ;
		} catch (Exception e) {}

		try {
			return format2.parse(date) ;
		} catch (Exception e) {}

		try {
			return new Date(date);
		} catch (Exception e) {e.printStackTrace();}

		return null;
	}






	/**
	 * 将String转化为时间对象
	 *
	 * @param str String对象
	 * @param pattern yyyy-MM-dd HH:mm:ss
	 * @return 时间对象
	 */
	private static Date string2date(String str, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			log.error("date SimpleDateFormat error:", e);
		}
		return date;
	}

	/**
	 * 按照 标准格式 yyyy-MM-dd HH:mm:ss，string => date
	 *
	 * @param str String对象
	 * @return 时间对象
	 */
	public static Date str2date(String str) {
		if(str == null || str.length() ==0){
			return null;
		}
		return string2date(str, DATE_FORMAT);
	}

	public static Date str2date(String str, String pattern) {
		return string2date(str, pattern);
	}

	/**
	 * 格式化时间对象，输出String
	 *
	 * @param date 时间对象
	 * @param pattern yyyy-MM-dd HH:mm:ss
	 * @return String
	 */
	public static String date2string(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		if(date == null){
			return "";
		}
		return sdf.format(date);
	}

	/**
	 * 按照 标准格式 yyyy-MM-dd HH:mm:ss，date => string
	 *
	 * @param date 时间对象
	 * @return String
	 */
	public static String date2str(Date date) {
		if(date==null) return "";
		return date2string(date, DATE_FORMAT);
	}

	/**
	 * 获取当前时间，以String 格式输出，yyyy-MM-dd HH:mm:ss
	 *
	 * @return 当前时间
	 */
	public static String now() {
		Calendar cNow = Calendar.getInstance();
		Date dNow = cNow.getTime();
		return date2string(dNow, DATE_FORMAT);
	}

	/**
	 * 获取当前时间，以String 格式输出，yyyyMMddHHmmss
	 *
	 * @return String
	 */
	public static String getCurrentTime4FileName() {
		Calendar cNow = Calendar.getInstance();
		Date dNow = cNow.getTime();
		return date2string(dNow, DATE_FORMAT_FOR_FILENAME);
	}

	/**
	 * 将时间格式字符串转为毫秒值
	 *
	 * @param time String时间
	 * @return 毫秒值
	 */
	public static String stringToSeconds(String time) {
		Date date = string2date(time, DATE_FORMAT);
		if (null != date) {
			return String.valueOf(date.getTime());
		}
		return "";
	}

	/**
	 * 获取上月最后一天
	 *
	 * @return 上月最后一天
	 */
	public static String lastDayByMonth() {
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_FOR_MONTH);
		// 获取前月的最后一天
		Calendar cale = Calendar.getInstance();
		// 设置为1号,当前日期既为本月第一天
		cale.set(Calendar.DAY_OF_MONTH, 0);
		return format.format(cale.getTime());
	}

	/**
	 * 获取最近的Ｎ个月份集合
	 *
	 * @param number Ｎ个月份
	 * @return 最近的Ｎ个月份集合
	 */
	public static List<String> getNearlyMonths(int number) {
		if (number > 0) {
			SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_FOR_MONTH);
			List<String> nearlyMonths = new ArrayList<>();
			for (int i = 0; i < number; i++) {
				Calendar cale = Calendar.getInstance();
				cale.setTime(new Date());
				cale.add(Calendar.MONTH, -i);
				nearlyMonths.add(format.format(cale.getTime()));
			}
			return nearlyMonths;
		}
		return Collections.emptyList();
	}

	/**
	 * 获取参数月份的上一个月份
	 *
	 * @param month 参数月份
	 * @return 参数月份的上一个月份
	 */
	public static String getLastMonth(Date month) {
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_FOR_MONTH);
		Calendar cale = Calendar.getInstance();
		cale.setTime(month);
		cale.add(Calendar.MONTH, -1);
		return format.format(cale.getTime());
	}


	/**
	 * 获取当前时间后延m个月或m天后的时间
	 *
	 * @param curDate 当前时间
	 * @param m 参数月数或天数
	 * @return
	 */
	public static Date stepDate(Date curDate, int m, int type) {
		Calendar cale = Calendar.getInstance();
		cale.setTime(curDate);
		cale.add(type, m);

		return cale.getTime();
	}

	/**
	 * 检查参数 是否符合ISO 8061格式
	 * @param duration
	 * @return
	 */
	public static boolean checkDuration(String duration){
		if(HititStringUtil.isEmpty(duration)){
			return false;
		}
		try {
			Duration.parse(duration );
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}

	/**
	 * 解析 是否符合ISO 8061格式
	 * @param duration
	 * @return
	 */
	public static Duration parseDuration(String duration){
		try {
			return Duration.parse(duration );
		} catch (DateTimeParseException e) {
			return null;
		}
	}

	/**
	 * 时间添加 时间区间
	 * @param date
	 * @param duration
	 * @return
	 */
	public static Date addDuration(Date date,Duration duration){
		if(duration == null || date == null){
			return null;
		}
		
		Calendar cale = Calendar.getInstance();
		cale.setTime(date);
		cale.add(Calendar.SECOND, (int)duration.getSeconds());
		return cale.getTime();
	}
	
	
	/**
	 * 时间添加 时间区间
	 * @param date
	 * @param duration
	 * @return
	 */
	public static Date addDuration(Date date,String duration){
		return addDuration(date, parseDuration(duration));
	}


	/**
	 * 获取某年最后一天日期
	 *
	 * @param year
	 *            年份
	 * @return Date
	 */
	public static Date getYearLast(String year) {
		int y = Integer.parseInt(year);
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, y);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		calendar.set(Calendar.HOUR,23);
		calendar.set(Calendar.MINUTE,59);
		calendar.set(Calendar.SECOND,59);
		Date currYearLast = calendar.getTime();

		return currYearLast;
	}

	/**
	 * 获取日期中的年
	 * @param date
	 * @return
	 */
	public static int yearOfDate(Date date){
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		int year = ca.get(Calendar.YEAR);//年份数值
		return year;
	}
	/**
	 * 毫秒转换为HH:mm:ss
	 * @param ms
	 * @return HH:mm:ss
	 */
	public static String ms2Hms(Long ms) {
		if (ms == null) {
			return new String();
		}

		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");//初始化Formatter的转换格式。
		formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
		return formatter.format(ms);
	}

	/**
	 * 获取两个yyyy-MM中间的所有月份
	 * @param minDate
	 * @param maxDate
	 * @return
	 * @throws ParseException
	 */
	public static List<String> getMonthBetween(String minDate, String maxDate) {
		ArrayList<String> result = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat(HititDateUtil.DATE_FORMAT_FOR_MONTH);// 格式化为年月
		Calendar min = Calendar.getInstance();
		Calendar max = Calendar.getInstance();
		try {
			min.setTime(sdf.parse(minDate));
			min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

			max.setTime(sdf.parse(maxDate));
		}catch (Exception e){
			e.printStackTrace();
		}
		max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
		Calendar curr = min;
		while (curr.before(max)) {
			result.add(sdf.format(curr.getTime()));
			curr.add(Calendar.MONTH, 1);
		}

		return result;
	}

	/**
	 *
	 * 1获取日期所在季度季度
	 *
	 * @param date
	 * @return
	 */
	public static int getQuarterOfDate(Date date) {

		int season = 0;

		Calendar c = Calendar.getInstance();
		c.setTime(date);
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
	 * 日期中的月份
	 * @param date
	 * @return
	 */
	public static int monthOfDate(Date date){
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		return ca.get(Calendar.MONTH);
	}


	/**
	 * 后去两个季度之间相差多少个季度
	 * @param minQuarter
	 * @param currentQuarter
	 * @return
	 * @throws ParseException
	 */
	public static List<String> getQuarterBetween(String minQuarter, String currentQuarter) {
		checkQuarterTime(minQuarter);
		checkQuarterTime(currentQuarter);
		if(minQuarter.compareTo(currentQuarter)>0){
			throw new RuntimeException("开始时间应该小于结束时间");
		}
		ArrayList<String> result = new ArrayList<>();
		int minYear = Integer.parseInt(minQuarter.substring(0,4));
		int startQuarter = Integer.parseInt(minQuarter.substring(5));
		int currentYear = Integer.parseInt(currentQuarter.substring(0,4));

		int stopYear = minYear;
		int stopQuarter = startQuarter;
		result.add(stopYear+"-"+stopQuarter);
		if(minQuarter.equals(currentQuarter)){
			return result;
		}
		while(stopYear<=currentYear){
			while(stopQuarter<4){
				stopQuarter++;
				String stop = stopYear+"-"+stopQuarter;
				if(stop.equals(currentQuarter)) {
					result.add(stop);
					return result;
				}
				result.add(stop);
			}
			stopYear++;
			stopQuarter=0;
		}
		return result;
	}

	/**
	 * 校验季度是否合规 2021-1
	 * @param time
	 */
	private static  void checkQuarterTime(String time){
		if(HititStringUtil.isEmpty(time))
		{
			throw new RuntimeException("季度格式不正确");
		}

		if(time.length()!=6){
			throw new RuntimeException("季度格式不正确");
		}
		if(!time.contains("-")&&(time.indexOf("-")==time.lastIndexOf("-"))){
			throw new RuntimeException("季度格式不正确");
		}
		if(time.indexOf("-")!=4){
			throw new RuntimeException("季度格式不正确");
		}
		int quarer = Integer.parseInt(time.substring(5));
		if(quarer>4||quarer<1){
			throw new RuntimeException("季度格式不正确");
		}
	}

	/**
	 * 后去两个年之间相差多少个季度
	 * @param currentYear
	 * @return
	 * @throws ParseException
	 */
	public static List<String> getYearBetween(String minYear, String currentYear) {
		checkYearTime(minYear);
		checkYearTime(currentYear);
		if(minYear.compareTo(currentYear)>0){
			throw new RuntimeException("开始时间应该小于结束时间");
		}
		ArrayList<String> result = new ArrayList<>();

		int min = Integer.parseInt(minYear);
		int cur = Integer.parseInt(currentYear);

		for(int i=min;i<=cur;i++)
		{
			result.add(String.valueOf(i));
		}
		return result;
	}

	/**
	 * 校验年是否合规 2021
	 * @param time
	 */
	private static  void checkYearTime(String time){
		if(HititStringUtil.isEmpty(time))
		{
			throw new RuntimeException("年格式不正确");
		}

		if(time.length()!=4){
			throw new RuntimeException("年格式不正确");
		}

	}
}
