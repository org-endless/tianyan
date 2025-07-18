package org.endless.fanli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * FanliCoreApplication
 * <p>
 * <p>
 * <p>
 * <p>
 * create 2023/12/30 20:14
 * <p>
 * update 2023/12/30 20:14
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
@EnableAsync
@SpringBootApplication
public class FanliCoreApplication {
    public static void main(String[] args) {

        SpringApplication.run(FanliCoreApplication.class, args);

    }

}
