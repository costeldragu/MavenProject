package com.mdc.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class ISBN implements Serializable {
    @Column(name="group_number") // because “group” is an invalid column name for SQL
            int group;
    int publisher;
    int title;
    int checkdigit;
    public ISBN() {
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ISBN)) return false;
        ISBN isbn = (ISBN) o;
        if (checkdigit != isbn.checkdigit) return false;
        if (group != isbn.group) return false;
        if (publisher != isbn.publisher) return false;
        if (title != isbn.title) return false;
        return true;
    }
    @Override
    public int hashCode() {
        int result = group;
        result = 31 * result + publisher;
        result = 31 * result + title;
        result = 31 * result + checkdigit;
        return result;
    }
}
