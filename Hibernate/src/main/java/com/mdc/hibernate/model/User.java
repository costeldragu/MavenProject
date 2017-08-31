package com.mdc.hibernate.model;

import java.util.HashSet;
import java.util.Set;

public class User {
    private Integer id;
    private String name;

    private ProteinData proteinData = new ProteinData();

    private Set<UserHistory> history = new HashSet<UserHistory>();

    public User() {}

    public Integer getId() {
        return id;
    }

    public Set<UserHistory> getHistory() {
        return history;
    }

    public void setHistory(Set<UserHistory> history) {
        this.history = history;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProteinData getProteinData() {
        return proteinData;
    }

    public void setProteinData(ProteinData proteinData) {
        this.proteinData = proteinData;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", proteinData=" + proteinData +
                ", history=" + history +
                '}';
    }
}
