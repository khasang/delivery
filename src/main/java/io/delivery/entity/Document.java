package io.delivery.entity;

import javax.persistence.*;

@Entity
@Table(name = "documents")
public class Document {
    @Id
    @Column(name = "document_id")
    private long id;
//    @Column(name = "document_name")
    private String name;

    @Transient
    private String specificInnerInfo;

    public Document() {
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
