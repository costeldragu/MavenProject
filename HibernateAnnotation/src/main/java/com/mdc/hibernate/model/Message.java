package com.mdc.hibernate.model;

import javax.persistence.*;

@Entity(name = "Message2")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long message_id;
    @Column
    String content;
    @OneToOne
    Email email;

    public Message() {}


    public Message(String content) {
        this.content = content;
    }

    public Long getMessageId() {
        return message_id;
    }

    public void setMessageId(Long message_id) {
        this.message_id = message_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message_id=" + message_id +
                ", content='" + content + '\'' +
                '}';
    }
}
