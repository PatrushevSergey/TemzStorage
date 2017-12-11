package temz.DAO;

import temz.model.ProductEntity;

import java.util.List;

/**
 * Created by Сергей on 26.10.2017.
 */
public interface ProductDAO {
    void create(ProductEntity product);
    void update(ProductEntity product);
    void delete(int id);
    List<ProductEntity> findAll();
    ProductEntity findById(int id);
    ProductEntity findByLabel(String label);
}
