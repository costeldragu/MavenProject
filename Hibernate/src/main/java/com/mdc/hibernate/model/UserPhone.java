package com.mdc.hibernate.model;

public class UserPhone {
    public Integer number;

    UserPhone() {}

    public UserPhone(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "UserPhone{" +
                "number=" + number +
                '}';
    }
}
