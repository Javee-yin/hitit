package per.javee.hitit.module.rce.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import per.javee.hitit.module.rce.service.RceService;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Author: yinjw-b
 * @Date: 2021/10/28 10:41
 * @Description:
 */
@Service
@Slf4j
public class RceServiceImpl implements RceService {
    @Override
    public String exec(String command) {
        String res = "";
        try {
            // 获取Runtime类对象
            Class runTimeClass1 = Class.forName("java.lang.Runtime");

            // 获取构造方法
            Constructor constructor = runTimeClass1.getDeclaredConstructor();
            constructor.setAccessible(true);

            // 创建Runtime类实例，等价于 Runtime rt = new Runtime();
            Object runtimeInstance = constructor.newInstance();

            // 获取Runtime的exec(String cmd)方法
            Method runtimeMethod = runTimeClass1.getMethod("exec", String.class);

            // 调用exec方法，等价于rt.exec(cmd);
            log.info("用户输入：{}", command);
            Process process = (Process) runtimeMethod.invoke(runtimeInstance, command);

            InputStream in = process.getInputStream();

            res = IOUtils.toString(in, "UTF-8");
            log.info("返回结果：{}", res);

        }catch (Exception e){
            e.printStackTrace();
        }

        return res;
    }
}
