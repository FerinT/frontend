package com.taylor.ferin.frontend.services.login.impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.taylor.ferin.frontend.repository.client.ClientRepository;
import com.taylor.ferin.frontend.repository.client.impl.ClientRepositoryImpl;
import com.taylor.ferin.frontend.services.login.ValidateUser;

public class ValidateUserImpl extends Service implements ValidateUser{

    private IBinder localBinder = new RetrieveAccountInfoLocalBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }


    public class RetrieveAccountInfoLocalBinder extends Binder {
        public ValidateUserImpl getService()
        {
            return  ValidateUserImpl.this;
        }
    }
    public ValidateUserImpl() {
    }

    @Override
    public boolean isValidUser(String email, String idNumber) {
        ClientRepository clientRepository = new ClientRepositoryImpl(getBaseContext());
        return clientRepository.validateUser(email, idNumber);
    }


}
