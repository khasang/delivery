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
    @Column(name = "id")
    @TableGenerator(
            name = "ORD_GEN",
            table = "SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_COUNT",
            pkColumnValue = "ORD_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ORD_GEN")
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
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<BasketItem> basketItemList = new ArrayList<>();

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

    public List<BasketItem> getBasketItemList() {
        return basketItemList;
    }

    public void setBasketItemList(List<BasketItem> basketItemList) {
        for (BasketItem basketItem : basketItemList) {
            basketItem.setOrder(this);
        }
        this.basketItemList = basketItemList;
    }

    public void addBasketItem(BasketItem basketItem) {
        basketItem.setOrder(this);
        basketItemList.add(basketItem);
    }

    public void removeBasketItem(BasketItem basketItem) {
        basketItem.setOrder(null);
        basketItemList.remove(basketItem);
    }

}
