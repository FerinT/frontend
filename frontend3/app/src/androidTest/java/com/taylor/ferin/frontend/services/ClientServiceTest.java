package com.taylor.ferin.frontend.services;

import android.content.Context;
import android.test.AndroidTestCase;

import com.taylor.ferin.frontend.domain.client.Client;
import com.taylor.ferin.frontend.repository.client.ClientRepository;
import com.taylor.ferin.frontend.repository.client.impl.ClientRepositoryImpl;
import com.taylor.ferin.frontend.services.client.impl.ClientServiceImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Ferin on 2016-08-31.
 */
public class ClientServiceTest extends AndroidTestCase {

    public void testInsert() throws Exception {

        ClientServiceImpl clientService = ClientServiceImpl.getInstance();
        Context context = getContext();
        ClientRepository clientRepository = new ClientRepositoryImpl(context);

        Client client = new Client.Builder()
                .membershipType("1")
                .name("1")
                .surname("1")
                .idNumber("1")
                .email("1")
                .build();

        clientService.addClient(this.mContext, client);

        Thread.sleep(5000);
        // READ ALL
        Set<Client> businessSet1 = clientRepository.findAll();
        Assert.assertTrue(businessSet1.size() > 0);
    }
}
