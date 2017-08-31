package com.mdc.hibernate.model;

public class UserMail {
    private String email;

    UserMail() {}

    public UserMail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserMail{" +
                "email='" + email + '\'' +
                '}';
    }
}
