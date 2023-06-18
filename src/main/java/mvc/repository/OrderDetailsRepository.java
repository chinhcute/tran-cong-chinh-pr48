package mvc.repository;

import mvc.entity.OrderDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Integer> {
//    @Query(value = "SELECT od.orderDetailsId, o.orderId, o.orderDate, p.proName, od.quantity FROM " +
//            "chinhtc.orderentity o join chinhtc.orderdetails od on o.orderId = od.orderId"
//            +
//            "where o.orderId = ?1", nativeQuery = true)
//    List<OrderDetails> list(int id);
@Query(value = "select od.orderDetailsId, o.orderId, o.orderDate, p.proName, od.quantity from chinhtc.orders o join chinhtc.orderdetais od on o.orderId = od.orderId\n" +
        "join chinhtc.products p on od.productId = p.productsId \n" +
        "where o.orderId = ?1", nativeQuery = true)
List<Object[]> list(int orderId);

@Query("SELECT od.orderDetailsId, o.orderId, o.orderDate, p.proName, od.quantity " +
        "FROM OrderDetails od " +
        "JOIN od.order o " +
        "JOIN od.product p " +
        "WHERE o.orderId = :orderId")
List<Object[]> getOrderDetailsByOrderId(@Param("orderId") int orderId);

    @Query(value = "SELECT * FROM chinhtc.orderdetais where orderId = ?1", nativeQuery = true)
    List<OrderDetails> findDetailsByOrderId(int id);

}
