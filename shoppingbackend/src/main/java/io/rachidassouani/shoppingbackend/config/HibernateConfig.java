package io.rachidassouani.shoppingbackend.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"io.rachidassouani.shoppingbackend"})
@EnableTransactionManagement
public class HibernateConfig {
	
	private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/onlineshopping?useSSL=false";
	private final static String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQL5Dialect";
	private final static String DATABASE_USERNAME = "rachid";
	private final static String DATABASE_PASSWORD = "password";

	// DataSource bean!
	@Bean
	public DataSource getDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(DATABASE_DRIVER);
		basicDataSource.setUrl(DATABASE_URL);
		basicDataSource.setUsername(DATABASE_USERNAME);
		basicDataSource.setPassword(DATABASE_PASSWORD);
		return basicDataSource;
	}
	
	// SessionFactory bean!
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("io.rachidassouani");
		return builder.buildSessionFactory();
	}
	
	// HibernateTransactionManager bean!
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(sessionFactory);
		return hibernateTransactionManager;
	}
	

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}
	
			

}
