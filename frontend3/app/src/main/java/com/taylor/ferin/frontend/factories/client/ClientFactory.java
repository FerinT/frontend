package com.taylor.ferin.frontend.factories.client;

import com.taylor.ferin.frontend.domain.client.Client;

import java.util.Map;

/**
 * Created by Ferin on 2016-08-28.
 */
public interface ClientFactory {
    public Client createClient(Map<String, String> clientData);
}
