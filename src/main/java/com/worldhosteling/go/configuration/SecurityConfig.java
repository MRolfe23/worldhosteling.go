package com.worldhosteling.go.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //region    FIELDS / PROPERTIES
    @Value("${spring.security.authentication.method}")
    private String authenticationMethod;

    @Value("${spring.datasource.url}")
    private String dataSourceAuthentication;

    @Value("${spring.datasource.username}")
    private String datasourceUser;

    @Value("${spring.datasource.password}")
    private String datasourcePass;

    @Value("${spring.security.ldap.domain}")
    private String ldapDomain;

    @Value("${spring.security.ldap.url}")
    private String ldapUrl;

//    @Autowired
//    private DataSource dataSource;

//    auth.jdbcAuthentication()
//            .dataSource(dataSource)
//                    .withDefaultSchema()
//                    .withUser(User.withUsername(datasourceUser)
//                        .password(datasourcePass)
//                    .roles("Account"));

    private CustomSuccessHandler customSuccessHandler;

    public SecurityConfig(CustomSuccessHandler customSuccessHandler) {
        this.customSuccessHandler = customSuccessHandler;
    }
    //endregion

    //region BASIC CONFIG
    @Autowired
    public void configureGlobal( AuthenticationManagerBuilder auth) throws Exception {
        if (authenticationMethod.equals("IN_MEMORY")) {
            auth.inMemoryAuthentication().withUser("michael@rolfe.com").password("{noop}Password01").roles("Account");
            auth.inMemoryAuthentication().withUser("geraldine@rolfe.com").password("{noop}Password01").roles("Account");
        } else if (authenticationMethod.equals("LDAP")) {
            auth.authenticationProvider(activeDirectoryLdapAuthenticationProvider());
        } else if (authenticationMethod.equals("DB_VERIFICATION")) {

        }
    }

    @Bean
    public ActiveDirectoryLdapAuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
        ActiveDirectoryLdapAuthenticationProvider authenticationProvider =
                new ActiveDirectoryLdapAuthenticationProvider(ldapDomain, ldapUrl);

        authenticationProvider.setConvertSubErrorCodesToExceptions(true);
        authenticationProvider.setUseAuthenticationRequestCredentials(true);

        return authenticationProvider;
    }
    //endregion

    //region ACCESS CONTROL
    protected void configure(HttpSecurity http) throws Exception {
        if (authenticationMethod.equals("NONE")) {
            http
                    .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .and()
                    .csrf().disable();
        }  else if (authenticationMethod.equals("LDAP") || authenticationMethod.equals("IN_MEMORY")) {
            http
                    .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .successHandler(customSuccessHandler)
                    .permitAll()
                    .and()
                    .logout().logoutUrl("/")
                    .and()
                    .csrf().disable();
        }
    }
    //endregion

}
