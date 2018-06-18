package ru.ugd.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import static org.apache.commons.lang3.StringUtils.EMPTY;
import javax.sql.DataSource;
import java.util.Properties;



@Configuration
@EnableCaching
@EnableTransactionManagement
@EnableJpaRepositories(basePackages ={"ru.ugd"})
@ComponentScan({"ru.ugd"})
@PropertySource(value = {"classpath:database.properties"})
public class AppAdmConfig extends CachingConfigurerSupport {


    @Autowired
    private Environment env;

    @Override
    @Bean
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            final StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(method.getName());
            for (final Object obj : params) {
                sb.append(obj == null ? EMPTY : obj.toString());
            }
            return sb.toString();
        };
    }

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:db/dbChangelog.xml");
        liquibase.setDataSource(dataSourceLiquiBase());
        return liquibase;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("ru.ugd");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Primary
    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("database.driverClassName"));
        dataSource.setUrl(env.getRequiredProperty("database.url"));
        dataSource.setUsername(env.getRequiredProperty("database.username"));
        dataSource.setPassword(env.getRequiredProperty("database.password"));
        return dataSource;
    }

    @Bean
    public DataSource dataSourceLiquiBase() {
        final DriverManagerDataSource dataSourceLiquiBase = new DriverManagerDataSource();
        dataSourceLiquiBase.setDriverClassName(env.getRequiredProperty("database.driverClassName"));
        dataSourceLiquiBase.setUrl(env.getRequiredProperty("liquibase.url"));
        dataSourceLiquiBase.setUsername(env.getRequiredProperty("liquibase.username"));
        dataSourceLiquiBase.setPassword(env.getRequiredProperty("liquibase.password"));
        return dataSourceLiquiBase;
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        final JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName("10.77.1.34");
        factory.setPort(6379);
        factory.setUsePool(true);
        return factory;
    }

    @Bean
    RedisTemplate<String, Object> redisTemplate(final JedisConnectionFactory jedisConnectionFactory) {
        final RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new JdkSerializationRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new JdkSerializationRedisSerializer());
        return template;
    }


    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);


        // Number of seconds before expiration. Defaults to unlimited (0)
        cacheManager.setDefaultExpiration(300);
        return cacheManager;
    }

    private Properties hibernateProperties() {
        final Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.ddl-auto",env.getRequiredProperty("hibernate.ddl-auto"));
        return properties;
    }



}