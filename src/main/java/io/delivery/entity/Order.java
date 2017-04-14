package io.delivery.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "order_id")
    @TableGenerator(
            name = "TABLE_GEN",
            table = "SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_COUNT",
            pkColumnValue = "ORD_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long id;
    @Column(name = "date")
    private Date deliveryDate;
    @Column(name = "time")
    private Time deliveryTime;
    @Column(name = "user_id")
    private Long user;
    @Column(name = "adress")
    private String deliveryAdress;
    @Column(name = "exec_id")
    private Long executor;
    @Column(name = "comment")
    private String comment;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Time getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Time deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public String getDeliveryAdress() {
        return deliveryAdress;
    }

    public void setDeliveryAdress(String deliveryAdress) {
        this.deliveryAdress = deliveryAdress;
    }

    public Long getExecutor() {
        return executor;
    }

    public void setExecutor(Long executor) {
        this.executor = executor;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
