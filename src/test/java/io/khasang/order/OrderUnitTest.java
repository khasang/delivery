package io.khasang.order;

import io.delivery.entity.BasketItem;
import io.delivery.entity.Order;
import org.junit.Test;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class OrderUnitTest {

    Order order = new Order();
    List<BasketItem> basketItems = new ArrayList<>();

    @Test
    public void testDeliveryDate() {
        Date date = new Date(42L);
        order.setDeliveryDate(date);
        assertEquals(date,order.getDeliveryDate());
    }

    @Test
    public void testDeliveryTime() {
        Time time = new Time(42L);
        order.setDeliveryTime(time);
        assertEquals(time,order.getDeliveryTime());
    }

    @Test
    public void testUserId() {
        long id = 42L;
        order.setUserId(id);
        assertEquals((long) id,(long) order.getUserId());
    }

    @Test
    public void testAddress() {
        String address = "Middle of Nowhere";
        order.setDeliveryAddress(address);
        assertEquals(address,order.getDeliveryAddress());
    }

    @Test
    public void testExecutor() {
        long id = 42L;
        order.setExecutorId(id);
        assertEquals((long) id,(long) order.getExecutorId());
    }

    @Test
    public void testComment() {
        String comment = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam congue, nisi nec ornare maximus, nulla erat mattis lectus, ac elementum sapien est nec arcu. Nullam turpis nisi, gravida ac bibendum in, blandit eget odio. Nunc eu arcu eu felis faucibus porta. Donec tincidunt leo at erat convallis gravida. Fusce a enim et ante cursus sagittis. Sed a condimentum lacus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum mattis sagittis tortor, et scelerisque sapien semper vitae. Phasellus massa orci, aliquet in venenatis sed, sagittis ut odio.";
        order.setComment(comment);
        assertEquals(comment,order.getComment());
    }

    @Test
    public void testBusket() {

        basketItems.add(new BasketItem(40L));
        basketItems.add(new BasketItem(41L));
        basketItems.add(new BasketItem(42L));

        BasketItem testBasketItem = new BasketItem(43L);

        //add test
        order.addBasketItem(testBasketItem);
        assertTrue(order.getBasketItemList().contains(testBasketItem));

        //delete test
        order.removeBasketItem(testBasketItem);
        assertFalse(order.getBasketItemList().contains(testBasketItem));

        order.setBasketItemList(basketItems);
        assertEquals(basketItems,order.getBasketItemList());

    }
}