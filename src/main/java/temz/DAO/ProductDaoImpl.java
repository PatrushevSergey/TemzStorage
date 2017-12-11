package temz.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import temz.model.ProductEntity;

import java.util.List;

/**
 * Created by Сергей on 26.10.2017.
 */
@Repository
public class ProductDaoImpl implements ProductDAO {
    private final HibernateTemplate template;

    @Autowired
    public ProductDaoImpl(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public void create(ProductEntity product) {
        template.save(product);
    }

    @Override
    public void update(ProductEntity product) {
        template.update(product);
    }

    @Override
    public void delete(int id) {
        template.delete(findById(id));
    }

    @Override
    public List<ProductEntity> findAll() {
        return (List<ProductEntity>)template.find("from ProductEntity ");
    }

    @Override
    public ProductEntity findById(int id) {
        return (ProductEntity)template.find("from ProductEntity where id=?", id).get(0);
    }

    @Override
    public ProductEntity findByLabel(String label) {
        return (ProductEntity)template.find("from ProductEntity where proLabel=?", label).get(0);
    }
}
