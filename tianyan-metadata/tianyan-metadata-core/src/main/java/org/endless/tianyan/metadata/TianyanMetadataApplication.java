package org.endless.tianyan.metadata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableAspectJAutoProxy
@SpringBootApplication
@MapperScan("org.endless.**.mapper")
public class TianyanMetadataApplication {

    public static void main(String[] args) {
        SpringApplication.run(TianyanMetadataApplication.class, args);
    }

}
