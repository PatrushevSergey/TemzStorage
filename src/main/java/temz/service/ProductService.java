package temz.service;

import temz.model.ProductEntity;

import java.util.List;

/**
 * Created by Сергей on 27.10.2017.
 */
public interface ProductService {
    void create(ProductEntity product);
    void update(ProductEntity product);
    void delete(int id);
    List<ProductEntity> findAll();
    ProductEntity findById(int id);
    ProductEntity findByLabel(String label);
}
