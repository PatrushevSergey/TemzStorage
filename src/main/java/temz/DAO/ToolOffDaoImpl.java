package temz.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import temz.model.ToolOffEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by Сергей on 26.09.2017.
 */
@Repository
public class ToolOffDaoImpl implements ToolOffDAO {
    private final HibernateTemplate template;
    @Autowired
    public ToolOffDaoImpl(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public void create(ToolOffEntity toolOff) {
        template.save(toolOff);
    }

    @Override
    public ToolOffEntity findById(int id) {
        return (ToolOffEntity) template.find("from ToolOffEntity where id=?", id).get(0);
    }

    @Override
    public List<ToolOffEntity> findAll() {
        return (List<ToolOffEntity>)template.find("from ToolOffEntity ");
    }

    @Override
    public List<ToolOffEntity> findByDate(Date date) {
        return (List<ToolOffEntity>)template.find("from ToolOffEntity where date=?", date);
    }
}
