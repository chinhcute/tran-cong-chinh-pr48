package mvc.repository;

import mvc.entity.OrderDetails;
import mvc.entity.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<OrderEntity , Integer> {
    List<OrderEntity> findByCustomerNameContaining (String ki_tu);
    List<OrderEntity> findByCustomerNameContainingIgnoreCase  (String ki_tu);
    @Query(value = "select* from chinhtc.orders o join chinhtc.orderdetais od on o.orderId = od.orderId\n" +
            "join chinhtc.products p on od.productId = p.productsId\n" +
            "\n" +
            "where o.customerName like %?1% or p.proName like %?2%", nativeQuery = true)
    List<OrderEntity> list_seach (String customerName, String proName);
}
