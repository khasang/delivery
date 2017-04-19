package io.delivery.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "basket")
public class BasketItem {
    @Id
    @TableGenerator(
            name = "BASKET_GEN",
            table = "SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_COUNT",
            pkColumnValue = "BASKET_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "BASKET_GEN")
    @Column(name = "id")
    private Long id;
    @Column(name = "item_id")
    private Long itemId;
    @Column(name = "quantity")
    private int quantity;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "order_id")
    private Order order;

    public BasketItem() {
    }

    public Long getId() {
        return id;
    }

    public BasketItem(Long itemId) {
        this.itemId = itemId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasketItem that = (BasketItem) o;

        return itemId.equals(that.itemId);
    }

    @Override
    public int hashCode() {
        return itemId.hashCode();
    }
}
