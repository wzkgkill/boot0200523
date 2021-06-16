package com.student.demo.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**配置全局跨域
 * @author SMILE
 */
@Configuration
public class CorsConfig {
    private CorsConfiguration buildConfig() {
        System.out.println("进入全局配置");
        CorsConfiguration corsConfiguration = new  CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); // 1允许任何域名使用
        corsConfiguration.addAllowedHeader("*"); // 2允许任何头
        corsConfiguration.addAllowedMethod("*"); // 3允许任何方法（post、get等）
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        System.out.println("进入全局方法");
        UrlBasedCorsConfigurationSource source = new  UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());  // 4
        return new CorsFilter(source);
    }
}

