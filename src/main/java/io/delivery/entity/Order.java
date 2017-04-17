package io.delivery.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


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
    private Long userId;
    @Column(name = "address")
    private String deliveryAddress;
    @Column(name = "exec_id")
    private Long executorId;
    @Column(name = "comment")
    private String comment;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference

    private List<BasketUnit> basketUnitList = new ArrayList<>();

    public Order() {
    }

    public Long getId() {
        return id;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public String getDeliveryAddress() {
        return deliveryAddress;
    }


    public void setDeliveryAddress(String deliveryAdress) {
        this.deliveryAddress = deliveryAdress;
    }


    public Long getExecutorId() {
        return executorId;
    }


    public void setExecutorId(Long executorId) {
        this.executorId = executorId;
    }


    public String getComment() {
        return comment;
    }


    public void setComment(String comment) {
        this.comment = comment;
    }


    public List<BasketUnit> getBasketUnitList() {
        return basketUnitList;
    }


    public void setBasketUnitList(List<BasketUnit> basketUnitList) {
        for (BasketUnit basketUnit : basketUnitList) {
            basketUnit.setOrder(this);
        }
        this.basketUnitList = basketUnitList;
    }


    public void addBasketUnit(BasketUnit basketUnit) {
        basketUnit.setOrder(this);
        basketUnitList.add(basketUnit);
    }


    public void removeBasketUnit(BasketUnit basketUnit) {
        basketUnit.setOrder(null);
        basketUnitList.remove(basketUnit);
    }
}