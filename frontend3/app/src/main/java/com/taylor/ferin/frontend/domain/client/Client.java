package com.taylor.ferin.frontend.domain.client;

import java.io.Serializable;

/**
 * Created by Ferin on 2016-08-28.
 */
public class Client implements Serializable{
    private Long id;
    private String idNumber;
    private String name;
    private String surname;
    private String membershipType;
    private String email;

    private Client(){}

    private Client(Builder builder) {
        this.id = builder.id;
        this.idNumber = builder.idNumber;
        this.name = builder.name;
        this.surname = builder.surname;
        this.membershipType = builder.membershipType;
        this.email = builder.email;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public Long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public String getEmail() {
        return email;
    }

    public static class Builder {
        private Long id;
        private String idNumber;
        private String name;
        private String surname;
        private String membershipType;
        private String email;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder idNumber(String val) {
            this.idNumber = val;
            return this;
        }

        public Builder name(String val) {
            this.name = val;
            return this;
        }

        public Builder surname(String val) {
            this.surname = val;
            return this;
        }

        public Builder membershipType(String val) {
            this.membershipType = val;
            return this;
        }

        public Builder email(String val) {
            this.email = val;
            return this;
        }

        public Builder copy(Client client) {
            this.id = client.id;
            this.idNumber = client.idNumber;
            this.name = client.name;
            this.surname = client.name;
            this.membershipType = client.membershipType;
            this.email = client.email;

            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }

}
