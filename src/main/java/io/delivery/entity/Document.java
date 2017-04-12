package io.delivery.entity;

import javax.persistence.*;

@Entity
@Table(name = "documents")
public class Document {
    @Id
    @Column(name = "document_id")
    private long id;
    @Column(name = "document_name")
    private String name;

    private String specificInnetInfo;

    public String getSpecificInnetInfo() {
        return specificInnetInfo;
    }

    public void setSpecificInnetInfo(String specificInnetInfo) {
        this.specificInnetInfo = specificInnetInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Document() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
