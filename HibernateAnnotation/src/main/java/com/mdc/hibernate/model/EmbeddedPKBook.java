package com.mdc.hibernate.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class EmbeddedPKBook {
    @EmbeddedId
    EmbeddedISBN id;
    @Column
    String name;
    static class EmbeddedISBN implements Serializable {
        // looks fundamentally the same as the ISBN class from Listing 6-7
    }
}