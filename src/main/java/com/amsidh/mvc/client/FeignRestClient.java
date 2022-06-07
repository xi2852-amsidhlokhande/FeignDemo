package com.amsidh.mvc.client;

import com.amsidh.mvc.model.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

@FeignClient(name = "ms-service-call", url = "http://this-is-a-placeholder.com")
public interface FeignRestClient {

    @GetMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    Person getPerson(URI remoteUrl);


}
