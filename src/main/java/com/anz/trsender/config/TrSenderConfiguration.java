package com.anz.trsender.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class TrSenderConfiguration {
	
	@Value("${db.DBDriverClassName}")
	private String driverClassName;
	
	@Value("${db.DBUrl}")
	private String url;
	
	@Value("${db.DBUsername}")
	private String username;
	
	@Value("${db.DBPassword}")
	private String password;
	
	@Value("${db.hibernateDialect}")
	private String dialect;
	
	@Value("${db.hibernateSql}")
	private String showSql;
	
	
		/**
		 * factory manager.
		 *
		 * @param builder
		 *            EntityManagerFactoryBuilder
		 * @return LocalContainerEntityManagerFactoryBean
		 */
		@Bean(name = "EntityManagerFactory")
		public LocalContainerEntityManagerFactoryBean meEntityManagerFactory(EntityManagerFactoryBuilder builder) {
			LocalContainerEntityManagerFactoryBean em = builder.dataSource(getDataSource()).
					packages("com.anz").persistenceUnit("persistentObject").build();
			em.setJpaProperties(additionalJpaMyLearnDBProperties());
			return em;
		}

		/**
		 * datasource.
		 *
		 * @return DataSource
		 */

		@Bean
		public DataSource getDataSource() {

			try {
				return BasicDataSourceFactory.createDataSource(getSQLServerProperties());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;

		}

		public Properties getSQLServerProperties() throws Exception {

			Properties properties = new Properties();
			properties.setProperty("driverClassName",driverClassName);
			properties.setProperty("url",url);
			properties.setProperty("username",username);
			properties.setProperty("password",password);

			
			return properties;
		}

		Properties additionalJpaMyLearnDBProperties() {
			Properties properties = new Properties();

			properties.setProperty("hibernate.dialect",dialect);
			properties.setProperty("hibernate.show_sql",showSql);
			properties.setProperty("hibernate.hbm2ddl.auto","create");

			return properties;
		}
		
	


}
