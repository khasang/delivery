package io.delivery.entity;

import javax.persistence.*;

@Entity(name = "BasketUnit")
@Table(name = "basket")
public class BasketUnit {
    @Id
    @Column(name = "unit_id")
    private Long id;
    @Column(name = "item_id")
    private Long itemId;
    @Column(name = "quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public BasketUnit() {
    }

    public Order getOrder() {
        return order;
    }

    public Long getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
