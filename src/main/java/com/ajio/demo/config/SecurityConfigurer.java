

package com.ajio.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.sql.DataSource;

@Configuration
//@EnableWebSecurity
//@EnableWebMvc
public class SecurityConfigurer extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/SignUp").setViewName("SignUp");
        registry.addViewController("/Login").setViewName("Login");
    }

    @Autowired
    private DataSource dataSource;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/SignUp","/atm/register","/h2-console/**").permitAll().
//                anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/Login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//
////        http.csrf()
////                .ignoringAntMatchers("/h2-console/**");
////        http.headers()
////                .frameOptions()
////                .sameOrigin();
//
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder builder)
//            throws Exception {
//
//        builder.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery(
//                        "SELECT username, password , true "+
//                        "FROM User where username = ?"
//                )
//                .authoritiesByUsernameQuery(
//                        "SELECT username, 'ROLE_USER' "+
//                        "FROM User where username = ?"
//                );
//    }
}
