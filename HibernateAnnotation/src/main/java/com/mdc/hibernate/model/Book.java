package com.mdc.hibernate.model;

import javax.persistence.*;

@Entity
public class Book {
    //Declare is primary id
    @Id
    //Generating Primary Key Values
    @SequenceGenerator(name = "sbbq1",sequenceName = "HIB_SEQ")
    //How the primary id ia created in our case auto
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String title;
    int pages;

    Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
