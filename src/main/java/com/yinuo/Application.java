package com.yinuo;

import java.time.LocalDate;
import java.time.LocalTime;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.yinuo.common.config.FebsProperties;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.yinuo.*.dao")
@EnableConfigurationProperties({FebsProperties.class})
@EnableCaching
@EnableAsync
public class Application extends SpringBootServletInitializer{

    private static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("《《《《《《 CreditSecuritySystem started up successfully at {} {} 》》》》》》", LocalDate.now(), LocalTime.now());
    }
    
    @Override
    protected SpringApplicationBuilder configure(
    		SpringApplicationBuilder builder) {
    	return builder.sources(this.getClass());
    }
}
