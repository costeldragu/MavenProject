package com.mdc.hibernate.model;

import javax.persistence.*;

@Entity(name = "Email2")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long email_id;
    @Column
    String subject;
    @OneToOne//(mappedBy = "email");
    Message message;

    public Email() {

    }

    public Email(String subject) {
        this.subject = subject;
    }

    public long getEmailId() {
        return email_id;
    }

    public void setEmailId(long email_id) {
        this.email_id = email_id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Email{" +
                "email_id=" + email_id +
                ", subject='" + subject + '\'' +
                ", message=" + message +
                '}';
    }
}
