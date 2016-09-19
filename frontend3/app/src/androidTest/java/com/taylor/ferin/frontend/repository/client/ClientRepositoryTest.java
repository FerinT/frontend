package com.taylor.ferin.frontend.repository.client;

import android.content.Context;
import android.test.AndroidTestCase;

import com.taylor.ferin.frontend.domain.client.Client;
import com.taylor.ferin.frontend.repository.client.impl.ClientRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Ferin on 2016-08-28.
 */
public class ClientRepositoryTest extends AndroidTestCase{
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        Context context = getContext();
        ClientRepository clientRepository = new ClientRepositoryImpl(context);

        // CREATE
        Client client = new Client.Builder()
                .name("ferin")
                .surname("Taylor")
                .email("123@gmail")
                .idNumber("456")
                .membershipType("client")
                .build();

        Client insertedEntity = clientRepository.save(client);
        id = insertedEntity.getId();
        Assert.assertNotNull(insertedEntity);

        // READ ALL
        Set<Client> businessSet = clientRepository.findAll();
        Assert.assertTrue(businessSet.size() > 0);


        // READ ENTITY
        Client entity = clientRepository.findById(id);
        Assert.assertNotNull(entity);

        // UPDATE ENTITY
        Client updateEntity = new Client.Builder()
                .copy(entity)
                .name("taylor")
                .build();
        clientRepository.update(updateEntity);
        Client newEntity = clientRepository.findById(id);
        Assert.assertEquals("taylor", newEntity.getName());

        // DELETE ENTITY
        clientRepository.delete(updateEntity);
        Client deletedEntity = clientRepository.findById(id);
        Assert.assertNull(deletedEntity);


        // DELETE ALL
        clientRepository.deleteAll();
        Set<Client> deletedUsers = clientRepository.findAll();
        Assert.assertTrue(deletedUsers.size() == 0);


    }
}
