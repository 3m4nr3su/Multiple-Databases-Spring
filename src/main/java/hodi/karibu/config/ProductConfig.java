package hodi.karibu.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Configuration
@Setter
@EnableJpaRepositories(basePackages = "hodi.karibu.repository.product", entityManagerFactoryRef = "productEntityManager", transactionManagerRef = "productTransactionManager")
@ConfigurationProperties(prefix = "app.db.product")
@RequiredArgsConstructor
public class ProductConfig {
	private static final String[] ENTITY_PKGS = { "hodi.karibu.model.product" };

	String url;
	String user;
	String password;
	String driver;
	Database database;
	String databasePlatform;
	boolean showSql;

	@Bean
	@Qualifier("product")
	public DataSource productDataSource() {
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl(url);
		ds.setUsername(user);
		ds.setPassword(password);
		ds.setDriverClassName(driver);
		return ds;
	}
	
	@Bean
	@Qualifier("product")
	public LocalContainerEntityManagerFactoryBean productEntityManager(@Qualifier("product") DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(dataSource);
		entityManager.setPackagesToScan(ENTITY_PKGS);
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(database);
		vendorAdapter.setShowSql(showSql);
		vendorAdapter.setDatabasePlatform(databasePlatform);
		vendorAdapter.setGenerateDdl(false);
		
		entityManager.setJpaVendorAdapter(vendorAdapter);
		
		Properties properties = new Properties();
		properties.put("hibernate.dialect", databasePlatform);
		properties.put("hibernate.connection.datasource", dataSource);
		
		entityManager.setJpaProperties(properties);
		return entityManager;
	}
	
	@Bean
	@Qualifier("product")
	public PlatformTransactionManager productTransactionManager(@Qualifier("product") DataSource dataSource) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(productEntityManager(dataSource).getObject());
		return transactionManager;
	}

}
