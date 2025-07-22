package main;

public class Order {
    private Integer id;
    private String orderNumber;
    private Integer quantity;

    public Order(Integer id, String orderNumber, Integer quantity) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
