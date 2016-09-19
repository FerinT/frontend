package com.taylor.ferin.frontend.services.login;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.taylor.ferin.frontend.domain.client.Client;
import com.taylor.ferin.frontend.repository.client.ClientRepository;
import com.taylor.ferin.frontend.repository.client.impl.ClientRepositoryImpl;
import com.taylor.ferin.frontend.services.client.impl.ClientServiceImpl;
import com.taylor.ferin.frontend.services.login.impl.ValidateUserImpl;

import junit.framework.Assert;

/**
 * Created by Ferin on 2016-08-31.
 */
public class ValidateUserTest extends AndroidTestCase {

    private ValidateUser validateUser;
    private boolean isBound;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), ValidateUserImpl.class);
        this.getContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);

    }

    public ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ValidateUserImpl.RetrieveAccountInfoLocalBinder binder
                    = (ValidateUserImpl.RetrieveAccountInfoLocalBinder) service;
            validateUser = binder.getService();

            isBound = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

            isBound = false;

        }
    };

    public void testName() throws Exception {
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

        boolean isValid = validateUser.isValidUser("1", "1");
        Assert.assertTrue(isValid);
    }
}
