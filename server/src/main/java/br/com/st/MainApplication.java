package br.com.st;

import br.com.st.domain.User;
import br.com.st.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;
import java.util.Date;


@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    ApplicationRunner init(UserRepository userRepository) {
        return args -> {

            User u1 = new User();
            u1.setEmail("spidey@email.com");
            u1.setName("Peter Parker");
            u1.setEnabled(true);
            u1.setPassword("webhead");
            u1.setPhone("555-11-22");
            u1.setRegisterDate(new Date());
            u1.setSurname("Parker");
            u1.setUsername("spidey");
            userRepository.save(u1);

            User u2 = new User();
            u2.setEmail("wolverine@email.com");
            u2.setName("Logan");
            u2.setEnabled(true);
            u2.setPassword("passwd");
            u2.setPhone("555-11-33");
            u2.setRegisterDate(new Date());
            u2.setSurname("Logan");
            u2.setUsername("mad_");
            userRepository.save(u2);

            User u3 = new User();
            u3.setEmail("batman@email.com");
            u3.setName("Bruce");
            u3.setEnabled(false);
            u3.setPassword("1234345");
            u3.setPhone("555-11-33");
            u3.setRegisterDate(new Date());
            u3.setSurname("Wayne");
            u3.setUsername("bat");
            userRepository.save(u3);


            User u4 = new User();
            u4.setEmail("hulk@email.com");
            u4.setName("Bruce");
            u4.setEnabled(true);
            u4.setPassword("passwd");
            u4.setPhone("555-11-33");
            u4.setRegisterDate(new Date());
            u4.setSurname("Benner");
            u4.setUsername("dr_benner");
            userRepository.save(u4);


            User u5 = new User();
            u5.setEmail("flash@email.com");
            u5.setName("Flash");
            u5.setEnabled(false);
            u5.setPassword("flashing");
            u5.setPhone("555-11-33");
            u5.setRegisterDate(new Date());
            u5.setSurname("Flash");
            u5.setUsername("flsh_");
            userRepository.save(u5);


            User u6 = new User();
            u6.setEmail("venom@email.com");
            u6.setName("Eddie");
            u6.setEnabled(true);
            u6.setPassword("whoisit?");
            u6.setPhone("555-11-33");
            u6.setRegisterDate(new Date());
            u6.setSurname("Brock");
            u6.setUsername("simb_");
            userRepository.save(u6);



        };
    }

    @Bean
    @SuppressWarnings("unchecked")
    public FilterRegistrationBean simpleCorsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Collections.singletonList("*"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludeClientInfo(true);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(true);
        return loggingFilter;
    }
}
