package com.learning.sse.client;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public void changeBalance(ClientBalanceRequest request) {
        Optional<Client> clientOpt = clientRepository.findById(request.getId());

        if(clientOpt.isPresent()) {
            Client client = clientOpt.get();
            client.setBalance(request.getNewBalance());
            clientRepository.save(client);
        }
    }
}
