package org.launchcode.sneekr.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String description;
    private double price;

    @ManyToMany
    private List<CustomerOrder> customerOrder = new ArrayList<>();

    public Item(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Item() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<CustomerOrder> getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(List<CustomerOrder> customerOrder) {
        this.customerOrder = customerOrder;
    }

    @Override
    public String toString() {
        return "Item{id:" + id +
                ",name:" + name +
                ",description:" + description +
                ",price:" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != item.id) return false;
        if (Double.compare(item.price, price) != 0) return false;
        if (!name.equals(item.name)) return false;
        return description.equals(item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.description, this.price);
    }
}
