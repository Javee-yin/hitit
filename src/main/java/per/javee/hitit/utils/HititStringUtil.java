package per.javee.hitit.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String Utils
 * @date: 2021年10月18日
 * @version: 1.0
 */
public class HititStringUtil {

	/**
	 * 是否为数字
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		if (isEmpty(str)) {
			return false;
		}

		str = str.trim();

		// 该正则表达式可以匹配所有的数字 包括负数
		Pattern pattern = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
		String bigStr;
		try {
			bigStr = new BigDecimal(str).toString();
		} catch (Exception e) {
			return false;//异常 说明包含非数字。
		}

		Matcher isNum = pattern.matcher(bigStr); // matcher是全匹配
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}


	/*
	 * 判断是否为整数
	 * @param str 传入的字符串
	 * @return 是整数返回true,否则返回false
	 */
	public static boolean isNumeric(String str) {
		if (isEmpty(str)) {
			return false;
		}

		str = str.trim();
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}


	/**
	 * 将 String 转为 List
	 * @return
	 */
	public static List<String> toList(String val){
		return toList(val,",");
	}


	/**
	 * 将 String 转为 List
	 * @param split
	 * @return
	 */
	public static List<String> toList(String val,String split){
		return new ArrayList<>(Arrays.asList(val.split(split)));
	}

	/**
	 * 判断数组中是否有空值
	 * @param args
	 * @return
	 */
	public static boolean hashEmpty(String ... args){
		if(args == null || args.length == 0){
			return true;
		}

		for(int i = 0;i<args.length ;i++){
			if(isEmpty(args[i])){
				return true;
			}
		}

		return false;
	}

	/**
	 * 获取字符串的长度
	 *
	 * @param str
	 * @return
	 */
	public static long size(String str) {
		if (str == null) {
			return 0L;
		}
		str = str.trim();
		return str.length();
	}


	/**
	 * 首字母大写
	 * eg:
	 * 1. arr -> Arr
	 * 2. Arr -> Arr
	 * 3. null -> null
	 * 4. "" -> ""
	 *
	 * @param str
	 * @return
	 */
	public static String toUpperCaseFirstOne(String str) {
		if (str == null || str.trim().length() == 0) {
			return str;
		}

		char[] arr = str.toCharArray();
		if (Character.isUpperCase(arr[0])) {
			return str;
		}

		arr[0] = (char) (arr[0] - 32);

		return new String(arr);

	}

	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0 || "null".equals(str);
	}

	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	public static String replaceBlank(String inputStr) {
		String dest = "";
		if (inputStr != null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(inputStr);
			dest = m.replaceAll("");
		}

		return dest;
	}

}
