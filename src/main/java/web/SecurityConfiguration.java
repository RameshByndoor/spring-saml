package web;

import static org.springframework.security.extensions.saml2.config.SAMLConfigurer.saml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Value("${security.saml2.metadata-url}")
    String metadataUrl;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        System.out.println("---------->"+metadataUrl);
        http
                .authorizeRequests()
                .antMatchers("/saml/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .apply(saml())
                .serviceProvider()
                .keyStore()
                .storeFilePath("saml/keystore.jks")
                .password("123456")
                .keyname("spring")
                .keyPassword("123456")
                .and()
                .protocol("https")
                .hostname("localhost:8443")
                .basePath("/")
                .and()
                .identityProvider()
                .metadataFilePath(metadataUrl)
                .and();
    }
}