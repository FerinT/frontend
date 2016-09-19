package com.taylor.ferin.frontend.factories.client.impl;

import com.taylor.ferin.frontend.domain.client.Client;
import com.taylor.ferin.frontend.factories.client.ClientFactory;

import java.util.Map;

/**
 * Created by Ferin on 2016-08-28.
 */
public class ClientFactoryImpl implements ClientFactory {

    public Client createClient(Map<String, String> clientData) {
        return new Client.Builder()
                .idNumber(clientData.get("idNumber"))
                .name(clientData.get("name"))
                .surname(clientData.get("surname"))
                .email(clientData.get("email"))
                .membershipType(clientData.get("membershipType"))
                .id(Long.parseLong(clientData.get("id")))
                .build();
    }
}
