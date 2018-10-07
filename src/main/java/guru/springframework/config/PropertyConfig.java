package guru.springframework.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJmsBroker;

@Configuration
//@PropertySource({ "classpath:datasource.properties", "classpath:jms.properties" })
//@PropertySources({
//	@PropertySource("classpath:datasource.properties"),
//	@PropertySource("classpath:jms.properties")
//	
//})
public class PropertyConfig {
	@Autowired
	Environment env;

	@Value("${mySpring.username}")
	String user;

	@Value("${mySpring.password}")
	String password;

	@Value("${mySpring.dburl}")
	String url;

	@Value("${mySpring.jms.username}")
	String jmsUsername;

	@Value("${mySpring.jms.password}")
	String jmsPassoword;

	@Value("${mySpring.jms.url}")
	String jmsUrl;

	@Bean
	public FakeDataSource fakeDataSource() {
		FakeDataSource fakeDataSource = new FakeDataSource();
		System.out.println("ActiveProfiles:"+Arrays.asList(env.getActiveProfiles()));
//		fakeDataSource.setUser(env.getProperty("USERNAME"));
		fakeDataSource.setUser(user);
		fakeDataSource.setPassword(password);
		fakeDataSource.setUrl(url);
		return fakeDataSource;
	}

	@Bean
	public FakeJmsBroker fakeJmsBroker() {
		FakeJmsBroker jmsBroker = new FakeJmsBroker();
		jmsBroker.setUsername(jmsUsername);
		jmsBroker.setPassword(jmsPassoword);
		jmsBroker.setUrl(jmsUrl);
		return jmsBroker;
	}

}
