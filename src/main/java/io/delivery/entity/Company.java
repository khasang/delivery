package io.delivery.entity;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;

@Entity
@Scope("prototype")
@Table(name = "companies")
public class Company {
    @Id
    @TableGenerator(name = "TABLE_COMP", table = "SEQUENCE_TABLE", pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_COUNT", pkColumnValue = "COMPANY_SEQ", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_COMP")
    private int id;
    private String name;
    private int size;

    public Company() {
    }

    public Company(int id, String name, int size) {
        this.id = id;
        this.name = name;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
