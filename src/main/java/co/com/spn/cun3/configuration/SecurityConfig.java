//package co.com.spn.cun3.configuration;
//
//import co.com.spn.cun3.security.JWTFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.http.HttpServletResponse;
//
////@Configuration
//public class SecurityConfig {
//    @Autowired
//    private JWTFilter filter;
//
//    @Autowired
//    private UserDetailsService uds;
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationManager authManager(HttpSecurity http)
//            throws Exception {
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//                .userDetailsService(uds)
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .and()
//                .build();
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        //TODO volver a activar la seguridad
//        // .antMatchers("/**").hasAuthority("AUTENTICADO")
//        http.csrf().disable()
//                .cors()
//                .and()
//                .authorizeHttpRequests()
//                .antMatchers("/login*").permitAll()
//                .antMatchers("/**").permitAll()
//                .and()
//                .userDetailsService(uds)
//                .exceptionHandling()
//                .authenticationEntryPoint(
//                        (request, response, authException) ->
//                                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "NO AUTORIZADO")
//                )
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }
//}
