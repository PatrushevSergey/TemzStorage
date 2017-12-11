package temz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import temz.DAO.ProductDAO;
import temz.model.ProductEntity;

import java.util.List;

/**
 * Created by Сергей on 27.10.2017.
 */
@Service
public class ProductServiceImpl implements ProductService {
    private ProductDAO dao;

    @Autowired
    public ProductServiceImpl(ProductDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void create(ProductEntity product) {
        dao.create(product);
    }

    @Override
    @Transactional
    public void update(ProductEntity product) {
        dao.update(product);
    }

    @Override
    @Transactional
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    @Transactional
    public List<ProductEntity> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public ProductEntity findById(int id) {
        return dao.findById(id);
    }

    @Override
    @Transactional
    public ProductEntity findByLabel(String label) {
        return dao.findByLabel(label);
    }
}
