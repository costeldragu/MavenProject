package com.mdc.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@IdClass(IdClassBook.EmbeddedISBN.class)
public class IdClassBook {
    @Id
    int group;
    @Id
    int publisher;
    @Id
    int title;
    @Id
    int checkdigit;
    String name;
    public IdClassBook() {
    }
    public int getGroup() {
        return group;
    }
    public void setGroup(int group) {
        this.group = group;
    }
    public int getPublisher() {
        return publisher;
    }
    public void setPublisher(int publisher) {
        this.publisher = publisher;
    }
    public int getTitle() {
        return title;
    }
    public void setTitle(int title) {
        this.title = title;
    }
    public int getCheckdigit() {
        return checkdigit;
    }
    public void setCheckdigit(int checkdigit) {
        this.checkdigit = checkdigit;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    static class EmbeddedISBN implements Serializable {
        // identical to EmbeddedISBN from Listing 6-8
    }
}