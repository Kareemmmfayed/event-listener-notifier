package com.learning.sse.client;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learning.sse.sse.ClientBalanceSseEmitter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientBalanceSseEmitter emitter;

    public void changeBalance(ClientBalanceRequest request) {
        Optional<Client> clientOpt = clientRepository.findById(request.getId());

        if(clientOpt.isPresent()) {
            Client client = clientOpt.get();
            client.setBalance(request.getNewBalance());
            Client savedClient = clientRepository.save(client);

            if(savedClient.getBalance().compareTo(BigDecimal.ZERO) == 0) {
                emitter.sendBalanceZeroEvent(savedClient);
            }
        }
    }
}
