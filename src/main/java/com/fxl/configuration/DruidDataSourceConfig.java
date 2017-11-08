package com.fxl.configuration;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 数据源配置
 * Created by cent on 2016/9/19.
 */
@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
public class DruidDataSourceConfig {
	
	@Autowired
    private DataSourceProperties dataSourceProperties;

    /**
     * 数据源
     * @return
     */
    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(dataSourceProperties.getUrl());
        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getPassword());
        dataSource.setInitialSize(dataSourceProperties.getInitialSize());
        dataSource.setMinIdle(dataSourceProperties.getMinIdle());
        dataSource.setMaxActive(dataSourceProperties.getMaxActive());
        dataSource.setMaxWait(dataSourceProperties.getMaxWait());
        dataSource.setTimeBetweenEvictionRunsMillis(dataSourceProperties.getTimeBetweenEvictionRunsMillis());
        try {
        	// 配置监控统计拦截的filters，去掉后监控界面sql无法统计
			dataSource.setFilters("stat,wall");
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return dataSource;
    }
}