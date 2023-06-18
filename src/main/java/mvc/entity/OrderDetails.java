package mvc.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderDetais")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderDetailsId;
    @ManyToOne
    @JoinColumn(name = "orderId")
    private OrderEntity order;
    @ManyToOne
    @JoinColumn(name = "productId")
    private ProductsEntity product;
    private int quantity;

    public int getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(int orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public ProductsEntity getProduct() {
        return product;
    }

    public void setProduct(ProductsEntity product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
