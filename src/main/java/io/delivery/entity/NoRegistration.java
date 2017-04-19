package io.delivery.entity;

import javax.persistence.*;

@Entity
@Table(name = "no_regitration_customer")
public class NoRegistration {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column (name = "name")
    private String name;
    @Column (name = "phoneNumber")
    private String phoneNumber;
    @Column (name = "adress")
    private String adress;

    public NoRegistration() {
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
