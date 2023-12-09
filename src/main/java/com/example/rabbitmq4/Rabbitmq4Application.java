package com.example.rabbitmq4.tut1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Rabbitmq4Application {

    //NEED TO WORK OUT WHY THE FUCK REQUESTS ARENT OUTPUTTING anything. I dont think the app is properly communicate with rabbitmq since we get the following output
    // when attempting to run jar: No active profile set, falling back to 1 default profile: "default"
    // likely that I need to fix something regarding the rabbitmq profile


    @Profile("usage_message")
    @Bean
    public CommandLineRunner usage(){
        return args -> {
            System.out.println("This app uses Spring Profiles to control its behavior. \n");
            System.out.println("Sample usage: java -jar rabbit-tutorials.jar --spring.profiles.active=hello-world,sender");
        };
    }

    @Profile("!usage_message")
    @Bean
    public CommandLineRunner tutorial(){
        return new RabbitAmqpTutorialsRunner();
    }


    public static void main(String[] args) throws Exception{
        SpringApplication.run(Rabbitmq4Application.class, args);
    }
}
