package com.learning.sse.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController("api/v1")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping("client")
    public void changeBalance(ClientBalanceRequest request) {
        clientService.changeBalance(request);
        ResponseEntity.ok();
    }

}
