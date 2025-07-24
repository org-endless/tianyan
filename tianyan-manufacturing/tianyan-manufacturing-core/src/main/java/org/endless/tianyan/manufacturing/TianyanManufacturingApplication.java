package org.endless.tianyan.manufacturing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * TianyanManufacturingApplication
 * <p>
 * create 2024/11/09 22:43
 * <p>
 * update 2024/11/09 22:43
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@EnableAsync
@EnableAspectJAutoProxy
@SpringBootApplication
@MapperScan("org.endless.**.mapper")
public class TianyanManufacturingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TianyanManufacturingApplication.class, args);
    }
}
