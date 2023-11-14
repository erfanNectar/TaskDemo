package com.example.TaskDemo.config;

<<<<<<< HEAD
import com.example.TaskDemo.Auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
=======
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
>>>>>>> 3831ec33809aa84166b1a5d2636e98a4387f030d
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
<<<<<<< HEAD
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class securityConfiguration {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;


=======

@Configuration
@EnableWebSecurity
public class securityConfiguration {
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        UserDetails admin=User.withUsername("Krishna")
                .password(encoder.encode("pwd1"))
                .roles("ADMIN")
                .build();
        UserDetails user=User.withUsername("Deva")
                .password(encoder.encode("pwd2"))
                .roles("USER")
                .build();
        return  new InMemoryUserDetailsManager(admin,user);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
>>>>>>> 3831ec33809aa84166b1a5d2636e98a4387f030d


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
<<<<<<< HEAD
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                            .requestMatchers("/api/v1/auth/**").permitAll()
                                .anyRequest().permitAll()
                )

                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) ;
        return http.build();
    }



=======
        return http
                .csrf(csrf-> csrf.disable())
                .authorizeRequests(auth->auth
                        .anyRequest().authenticated()
    )
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(Customizer.withDefaults())
                .build();
    }
>>>>>>> 3831ec33809aa84166b1a5d2636e98a4387f030d
}
