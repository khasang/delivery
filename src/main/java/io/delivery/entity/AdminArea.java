package io.delivery.entity;

import javax.persistence.*;

@Entity
@Table(name = "adminArea")
public class AdminArea {
    @Id
    @Column(name = "adminArea_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "adminArea_userName")
    private String name;
    @Column(name = "adminArea_password")
    private String password;
    @Transient
    private String specificInnerInfo;

    public AdminArea() {
    }

    public String getSpecificInnerInfo() {
        return specificInnerInfo;
    }

    public void setSpecificInnerInfo(String specificInnerInfo) {
        this.specificInnerInfo = specificInnerInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
