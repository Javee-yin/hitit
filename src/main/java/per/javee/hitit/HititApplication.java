package per.javee.hitit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan({"per.javee.hitit.**.dao","per.javee.hitit.dbsupportor.dao"})
@ComponentScan({"per.javee.hitit.*"})
@EnableAsync
@EnableTransactionManagement
public class HititApplication {

    public static void main(String[] args) {
        SpringApplication.run(HititApplication.class, args);
    }

}
