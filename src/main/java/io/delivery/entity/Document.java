package io.delivery.entity;

import javax.persistence.*;

@Entity
@Table(name = "documents")
public class Document {
    @Id
    @Column(name = "document_id")
    @TableGenerator(name = "TABLE_DOC", table = "SEQUENCE_TABLE", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "DOC_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_DOC")
    private long id;
    @Column(name = "document_name")
    private String name;
    @Transient
    private String specificInnefInfo;

    public Document() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
