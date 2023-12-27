package com.thushalil.sampleopenapi.client.api;

import com.thushalil.sampleopenapi.api.ClientApi;
import com.thushalil.sampleopenapi.api.model.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ClientController implements ClientApi {

    @Override
    public ResponseEntity<Void> addClient(Client client) {
        return ClientApi.super.addClient(client);
    }

    @Override
    public ResponseEntity<Client> getClient(BigDecimal clientId) {
        return ClientApi.super.getClient(clientId);
    }

    @Override
    public ResponseEntity<List<Client>> getClients() {
        return ClientApi.super.getClients();
    }
}
