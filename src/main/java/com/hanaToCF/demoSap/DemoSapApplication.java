package com.hanaToCF.demoSap;

import io.pivotal.cfenv.core.CfCredentials;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import io.pivotal.cfenv.core.CfEnv;
import io.pivotal.cfenv.jdbc.CfJdbcEnv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import java.util.logging.Logger;

@SpringBootApplication
@Slf4j
public class DemoSapApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSapApplication.class, args);
	}

	@Bean
	public CfEnv cfEnv() {
		return new CfEnv();
	}

	@Bean
	@Primary
	@Profile("cloud")
	public DataSourceProperties dataSourceProperties() {
		CfJdbcEnv cfJdbcEnv = new CfJdbcEnv();
		DataSourceProperties properties = new DataSourceProperties();
		CfCredentials hanaCredentials = cfJdbcEnv.findCredentialsByTag("hana");
		log.info("Hana Credentials: {}", hanaCredentials);
		if (hanaCredentials != null) {
			String uri = hanaCredentials.getUri("hana");
			properties.setUrl(uri);
			log.info("Hana URL: {}", uri);
			properties.setUsername(hanaCredentials.getUsername());
			log.info("Hana User: {}", hanaCredentials.getUsername());
			properties.setPassword(hanaCredentials.getPassword());
			log.info("Hana Pwd: {}", hanaCredentials.getPassword());
			properties.setDriverClassName(hanaCredentials.getString("driver"));
			log.info("Hana driver: {}", hanaCredentials.getString("driver"));
		}
		return properties;
	}
}
