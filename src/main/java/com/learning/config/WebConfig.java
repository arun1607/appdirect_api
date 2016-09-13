package com.learning.config;

import com.learning.filter.RequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * Created by amits on 13/09/16.
 */
@Configuration
public class WebConfig {

    @Bean
    public Filter interceptor() {
        return new RequestFilter();
    }
}
