package com.worldhosteling.go.configurations;

import com.worldhosteling.go.Filters.JwtRequestFilter;
import com.worldhosteling.go.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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

    private DataSource dataSource;

    // THIS IS THE USER DETAILS EXTENDED IN ACCOUNT SERVICE
    private AccountService accountService;

    private JwtRequestFilter jwtRequestFilter;

    private CustomSuccessHandler customSuccessHandler;

    public SecurityConfig(CustomSuccessHandler customSuccessHandler, AccountService accountService, JwtRequestFilter jwtRequestFilter, DataSource dataSource) {
        this.customSuccessHandler = customSuccessHandler;
        this.accountService = accountService;
        this.jwtRequestFilter = jwtRequestFilter;
        this.dataSource = dataSource;
    }
    //endregion

    //region BASIC CONFIG
    @Autowired
    public void configureGlobal( AuthenticationManagerBuilder auth) throws Exception {
        switch (authenticationMethod) {
            case "IN_MEMORY":
                auth.inMemoryAuthentication().withUser("michael@rolfe.com").password("{noop}Password01").roles("Account");
                auth.inMemoryAuthentication().withUser("geraldine@rolfe.com").password("{noop}Password01").roles("Account");
                break;
            case "LDAP":
                auth.authenticationProvider(activeDirectoryLdapAuthenticationProvider());
                break;
            case "DB_VERIFICATION":
                auth.userDetailsService(accountService).passwordEncoder(new BCryptPasswordEncoder());
                break;
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
        switch (authenticationMethod) {
            case "NONE":
                http
                        .authorizeRequests()
                        .antMatchers("/").permitAll()
                        .and()
                        .csrf().disable();
                break;
            case "LDAP":
            case "IN_MEMORY":
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
                break;
            case "DB_VERIFICATION":
                http.csrf().disable()
                        .authorizeRequests().antMatchers("/authenticate").permitAll()
                        .anyRequest().authenticated()
                        .and().sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

            http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
                break;
        }
    }
    //endregion

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
