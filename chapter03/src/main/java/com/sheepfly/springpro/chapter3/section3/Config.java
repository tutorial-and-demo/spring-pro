package com.sheepfly.springpro.chapter3.section3;

import com.sheepfly.springpro.chapter2.MessageProvider;
import com.sheepfly.springpro.chapter2.MessageProviderImpl;
import org.example.beans.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public User initUser() {
        User user = new User("app", 12, 1);
        return user;
    }

    @Bean("provider2")
    public MessageProvider provider() {
        MessageProvider provider = new MessageProviderImpl();
        return provider;
    }
}
