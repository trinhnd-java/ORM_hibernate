package main.java.vn.omi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Ominext on 26/02/2018.
 */
@Entity
@Table(name = "items")
public class Items implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id" ,nullable = false, unique = true)
    private int id;
    @Column(name="item_id" ,nullable = false, unique = true)
    private int item_id;
    @Column(name="item_total" ,nullable = false, unique = true)
    private int item_total;
    @Column(name="quantity" ,nullable = false, unique = true)
    private int quantity;


    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart Cart;


    public main.java.vn.omi.entity.Cart getCart() {
        return Cart;
    }

    public void setCart(main.java.vn.omi.entity.Cart cart) {
        Cart = cart;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getItem_total() {
        return item_total;
    }

    public void setItem_total(int item_total) {
        this.item_total = item_total;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
