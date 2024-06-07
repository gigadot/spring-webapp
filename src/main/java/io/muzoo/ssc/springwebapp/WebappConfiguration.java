package io.muzoo.ssc.springwebapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebappConfiguration {

    @Value("${ssc.simple.service.url:https://example.com}")
    private String url;

    @Autowired
    private UserRepository userRepository;

    @Bean
    public SimpleService createSimpleService(UserRepository userRepository) {
        SimpleService simpleService = new SimpleService();
        simpleService.setUserRepository(userRepository);
        simpleService.setUrl(url);
        System.out.println("SimpleService is created. " + url   );
        return simpleService;
    }
}
