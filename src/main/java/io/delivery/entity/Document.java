package io.delivery.entity;

import javax.persistence.*;
<<<<<<< HEAD

@Entity
@Table(name = "documents")
=======
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "document")
>>>>>>> origin/feedback
public class Document {
    @Id
    @Column(name = "document_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "document_name")
    private String name;
<<<<<<< HEAD
    private String specificInnerInfo;
=======
    @Transient
    private String specificInnerInfo;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<DocumentItem> documentItems = new ArrayList<>();
>>>>>>> origin/feedback

    public Document() {
    }

<<<<<<< HEAD
=======
    public List<DocumentItem> getDocumentItems() {
        return documentItems;
    }

    public void setDocumentItems(List<DocumentItem> documentItems) {
        this.documentItems = documentItems;
    }

>>>>>>> origin/feedback
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
<<<<<<< HEAD
}
=======
}
>>>>>>> origin/feedback
