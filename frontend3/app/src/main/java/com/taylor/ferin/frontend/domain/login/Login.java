package com.taylor.ferin.frontend.domain.login;

/**
 * Created by Ferin on 2016-09-01.
 */
public class Login {

    private Long id;
    private String username;
    private String user_password;

    private Login(){}

    public Login(Builder builder){
        this.user_password = builder.user_password;
        this.username = builder.username;
        this.id = builder.id;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getUser_password() {
        return user_password;
    }

    public static class Builder{
        private Long id;
        private String username;
        private String user_password;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder username(String username){
            this.username = username;
            return this;
        }

        public Builder password(String user_password){
            this.user_password = user_password;
            return this;
        }

        public Builder copy(Login login){
            this.user_password = login.user_password;
            this.username = login.username;
            this.id = login.id;
            return  this;
        }

        public Login build(){
            return new Login(this);
        }
    }
}