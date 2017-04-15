package io.delivery.entity;

import javax.persistence.*;

@Entity
@Table(name = "documents")
public class Document {
    @Id
    @Column(name = "document_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "document_name")
    private String name;
    private String specificInnerInfo;

    public Document() {
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
}