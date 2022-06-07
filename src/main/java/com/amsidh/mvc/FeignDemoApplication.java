package com.amsidh.mvc;

import com.amsidh.mvc.client.FeignRestClient;
import com.amsidh.mvc.model.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@SpringBootApplication
@EnableFeignClients
@EnableScheduling
@Slf4j
public class FeignDemoApplication implements CommandLineRunner {

    private final FeignRestClient feignRestClient;

    public static void main(String[] args) {
        SpringApplication.run(FeignDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        callRemoteAPI();

    }

    @Scheduled(cron = "0 * * * * *")
    public void callRemoteAPI() {
        String syncurl = "http://localhost:8080/api/person/sync";
        String asyncurl = "http://localhost:8080/api/person/async";

        log.info("Calling {}", asyncurl);
        Person person = feignRestClient.getPerson(URI.create(asyncurl));
        log.info("Response Received {}", person);
    }
}
