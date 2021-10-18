package per.javee.hitit.utils;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 对象克隆工具类
 * @date: 2021年10月18日
 * @version: 1.0
 */
public class ObjectCloneUtil<T, S> {

    /**
     * 拷贝示例代码 BCompany c = new BCompany(); c.setTenantId(1061869626002591744l); c.setCompanyCode("companyCode");
     * c.setCompanyName("name"); c.setEmail("EMAIL"); c.setPhone("PHONE"); CompanyVo v =
     * ObjectCloneUtils.clone(c, CompanyVo.class);
     *
     * System.out.println(c); System.out.println(v);
     *
     * List<BCompany> relist = new ArrayList<BCompany>(); relist.add(c);
     *
     * List<CompanyVo> list1 = ObjectCloneUtils.<CompanyVo,BCompany>cloneList(relist, CompanyVo.class);
     * System.out.println(JsonUtil.toJson(list1));;
     */

    /**
     * 克隆列表 copy BCompany list to CompanyVo list,example : List<BCompany> relist = new ArrayList<BCompany>();
     * List<CompanyVo> list1 = ObjectCloneUtils.<CompanyVo,BCompany>cloneList(relist, CompanyVo.class);
     *
     * @param sourcelist 原链表
     * @param targetClass 目标列表类
     * @return
     * @throws Exception
     */
    public static <T, S> List<T>  cloneList(List<S> sourcelist, Class<T> targetClass) {
        List<T> targetlist = new ArrayList<>();
        if (sourcelist != null) {
            for (S s : sourcelist) {
                targetlist.add(clone(s, targetClass));
            }
        }
        return targetlist;
    }

    /**
     * 克隆对象 为属性值得拷贝 BCompany c = new BCompany(); CompanyVo v = ObjectCloneUtils.clone(c, CompanyVo.class);
     *
     * @param s 源对象
     * @param targetClass 目标对象类
     * @return
     * @throws Exception
     */
    public static <T, S> T clone(S s, Class<T> targetClass) {
        T t;
        try {
            t = targetClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (s != null) {
            BeanUtils.copyProperties(s, t);
        }
        return t;
    }



    /**
     * 复制字段的值
     * @param source 源对象
     * @param target 目标对象
     */
    public static void copyFields(Object source, Object target){

        HashMap<String, Field> sourceFieldMap = getAllFields(source);
        HashMap<String, Field> targetFieldMap = getAllFields(target);

        sourceFieldMap.forEach((key, value) -> {
            value.setAccessible(true);
            try {
                if ( targetFieldMap.containsKey(key)){
                    targetFieldMap.get(key).setAccessible(true);
                    targetFieldMap.get(key).set(target, value.get(source));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 获取对象所有的字段 包括父类
     * @param obj 对象
     * @return 字段名与Field对象的映射map
     */
    private static HashMap<String, Field> getAllFields(Object obj){
        if (obj == null) {
            return new HashMap<>();
        }

        @SuppressWarnings("rawtypes")
		Class sourceClass = obj.getClass();
        //获取对象所有字段 包括父类
        ArrayList<Field> sourceFields = new ArrayList<>();
        while (sourceClass != null){
            sourceFields.addAll(Arrays.asList(sourceClass.getDeclaredFields()));
            sourceClass = sourceClass.getSuperclass();
        }
        //字段名去重
        HashMap<String, Field> sourceFieldMap = new HashMap<>(16);
        for (Field field : sourceFields){
            sourceFieldMap.put(field.getName(), field);
        }
        return sourceFieldMap;
    }

}
