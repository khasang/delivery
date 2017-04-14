package io.delivery.entity;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column
    private long id;
    @Column
    private String name;
    @Column
    private String address;
    @Column(name = "telephone_number")
    private String phoneNumber;
    @Column(name = "e-mail")
    private String eMail;
    @Column(name = "order_id")
    private long idOrder;


    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

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

    public String getTelephoneNumber() {
        return phoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.phoneNumber = telephoneNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}


