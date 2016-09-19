package com.taylor.ferin.frontend.repository.client;

import com.taylor.ferin.frontend.domain.client.Client;
import com.taylor.ferin.frontend.repository.Repository;

/**
 * Created by Ferin on 2016-08-28.
 */
public interface ClientRepository extends Repository<Client, Long>{
    public boolean validateUser(String email, String idnumber);
}
