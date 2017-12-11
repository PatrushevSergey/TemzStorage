package temz.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import temz.model.ToolEntity;
import temz.model.ToolInEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by Сергей on 26.09.2017.
 */
@Repository
public class ToolInDaoImpl implements ToolInDAO {

    private final HibernateTemplate template;
    @Autowired
    public ToolInDaoImpl(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public void create(ToolInEntity toolIn) {
        template.save(toolIn);
    }

    @Override
    public ToolInEntity findById(int id) {
        return (ToolInEntity) template.find("from ToolInEntity where id=?", id).get(0);
    }

    @Override
    public List<ToolInEntity> findAll() {
        return (List<ToolInEntity>) template.find("from ToolInEntity ");
    }

    @Override
    public List<ToolInEntity> findByDate(Date date) {
        return (List<ToolInEntity>)template.find("from ToolInEntity where date=?", date);
    }
}
