package com.taylor.ferin.frontend.services.client;

import android.content.Context;

import com.taylor.ferin.frontend.domain.client.Client;


public interface ClientService {
    void addClient(Context context,Client client);
    void updateClient(Context context,Client client);
    void deleteClient(Context context,Client client);
}
