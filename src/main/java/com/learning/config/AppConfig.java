package com.learning.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.net.URISyntaxException;

/**
 * Created by amits on 13/09/16.
 */
@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public HttpClientConnectionManager connectionManager() {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(200);
        cm.setDefaultMaxPerRoute(20);
        return cm;
    }

    @Bean
    public CloseableHttpClient client() {
        return HttpClients.custom()
                .setConnectionManager(connectionManager())
                .build();
    }

//    @Bean
//    public DataSource dataSource() throws URISyntaxException {
//        String dbUrl = System.getenv("JDBC_DATABASE_URL");
//        String username = System.getenv("JDBC_DATABASE_USERNAME");
//        String password = System.getenv("JDBC_DATABASE_PASSWORD");
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl(dbUrl);
//        config.setUsername(username);
//        config.setPassword(password);
//        config.addDataSourceProperty("cachePrepStmts", "true");
//        config.addDataSourceProperty("prepStmtCacheSize", "250");
//        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
//
//        return new HikariDataSource(config);
//    }
}
