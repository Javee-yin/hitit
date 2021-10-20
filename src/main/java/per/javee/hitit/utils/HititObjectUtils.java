package per.javee.hitit.utils;
import com.github.pagehelper.StringUtil;

import java.lang.reflect.Field;

/**
 * @Author: yinjw-b
 * @Date: 2021/10/20 11:16
 * @Description:
 */
public class HititObjectUtils {

    /**
     * 判断对象每个字段都为空，及为空
     * @param object
     * @return
     */
    public static boolean isEmpty(Object object) {
        if (null == object) {
            return true;
        }

        try {
            for (Field f : object.getClass().getDeclaredFields()) {
                f.setAccessible(true);

                if (f.get(object) != null && HititStringUtil.isNotEmpty(f.get(object).toString())) {
                    return false;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    /**
     * 判断对象每个字段都不为空
     * @param o
     * @return
     */
    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }
}
