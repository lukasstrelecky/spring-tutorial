package com.example.impl.service;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Service
public class ApiService {

    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(300);

    private final WebClient remoteApiClient;

    @Autowired
    public ApiService(@Qualifier("remoteApiClient") WebClient remoteApiClient) {
        this.remoteApiClient = remoteApiClient;
    }

    public String getDataFromRemoteApi() {
        return this.remoteApiClient.get()
                .uri(builder -> {
                    builder = builder.path("/key/value/one/two");
                    return builder.build();
                }).headers(h -> h.setContentType(MediaType.APPLICATION_JSON))
                .retrieve()
                .bodyToMono(String.class)
                .block(REQUEST_TIMEOUT);
    }
}
