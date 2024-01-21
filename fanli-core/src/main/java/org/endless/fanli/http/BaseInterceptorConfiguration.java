package org.endless.fanli.http;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * BaseInterceptorConfiguration
 *
 * @author Deng Haozhi
 * @date 2023/5/19 16:04
 * @since 0.0.3
 */
@Configuration
public class BaseInterceptorConfiguration implements WebMvcConfigurer {

    /**
     * addInterceptors
     *
     * @param registry InterceptorRegistry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(new SignInHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/game/eve/**",
                        "/",
                        "/index",
                        "/signin",
                        "/user/**",
                        "/error");
    }
}
