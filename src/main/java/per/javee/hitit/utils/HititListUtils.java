package per.javee.hitit.utils;

import java.util.*;

/**
 * List Utils
 * @date: 2021年10月18日
 * @version: 1.0
 */
public class HititListUtils {
	
	 /**
     * 判断一个List是否为空
     * @param list1
     * @return
     */
    public static String toString(final Collection<?> list1,final String delimiter){
    	
    	if(list1 == null || list1.size() ==0){
    		return "";
    	}
    	
    	StringJoiner sj = new StringJoiner(delimiter);
    	list1.forEach(item -> {
    		if(item != null){
    			sj.add(item.toString());
    		}
    	});
    	
        return sj.toString();
    }

    /**
     * 判断一个List是否为空
     * @param list1
     * @return
     */
    public static boolean isEmptyList(final Collection<?> list1){
        return list1 == null || list1.size() == 0 ;
    }
    
    /**
     * 判断一个List是否非空
     * @param list1
     * @return
     */
    public static boolean isNotEmptyList(final Collection<?> list1){
        return !isEmptyList(list1);
    }
    
    /**
     * 转换为一个List
     * @param strs
     * @return
     */
    public static List<String> newList(String ... strs){
    	if(strs == null || strs.length == 0){
    		return new ArrayList<String>(0);
    	}
    	
    	return Arrays.asList(strs);
    }

    /**
     * 将list按照一定规格拆成一定的大小
     * @param list limit
     * @return
     */
    public static <T> List<List<T>> splitList(List<T> list, Integer limit){
        List<List<T>> result = new ArrayList<>();
        int length = list.size();
        if (length < limit){
            result.add(list);
            return result;
        }

        // 计算可以分成多少组
        int num = (length + limit - 1) / limit;
        for(int i = 0; i < num; i++){

            // 开始位置
            int beginIndex = i * limit;
            // 结束位置
            int endIndex = (i + 1) * limit < length ? (i + 1) * limit : length;
            result.add(list.subList(beginIndex, endIndex));
        }

        return result;
    }
}
