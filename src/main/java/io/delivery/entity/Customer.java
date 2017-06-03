package io.delivery.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customers")
public class Customer implements Serializable{
    @Id
//    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
//    @Column
    private String name;
//    @Column
    private String address;
    @Column(unique = true, name = "phone_number")
    private String phoneNumber;
    @Column(unique = true, name = "e_mail")
    private String eMail;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String toString(){
        return getId() + " " + getName() + " " + getAddress() + " " + getPhoneNumber() + " " + geteMail();
    }
}


