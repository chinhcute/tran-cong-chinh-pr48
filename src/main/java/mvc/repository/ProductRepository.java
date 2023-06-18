package mvc.repository;

import mvc.entity.ProductsEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductsEntity, Integer> {
}
