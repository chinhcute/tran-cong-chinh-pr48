package mvc.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productsId;
    private String proName;
    private double unitPrice;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails;

    public int getProductsId() {
        return productsId;
    }

    public void setProductsId(int productsId) {
        this.productsId = productsId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
