package temz.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import temz.model.StorageEntity;

import java.util.List;

/**
 * Created by Сергей on 05.09.2017.
 */
@Repository
public class StorageDaoImpl implements StorageDAO {
    private final HibernateTemplate template;

    @Autowired
    public StorageDaoImpl(HibernateTemplate template) {
        this.template = template;
    }
    @Override
    public List<StorageEntity> findAll() {
        return (List<StorageEntity>)template.find("from StorageEntity ");
    }

    @Override
    public void create(StorageEntity storage) {
        template.save(storage);
    }
}
