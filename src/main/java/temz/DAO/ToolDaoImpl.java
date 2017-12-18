package temz.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import temz.model.ToolEntity;

import java.util.List;

/**
 * Created by Сергей on 05.09.2017.
 */
@Repository
public class ToolDaoImpl implements ToolDAO {
    private final HibernateTemplate template;

    @Autowired
    public ToolDaoImpl(HibernateTemplate template) {
        this.template = template;
    }

    public void create(ToolEntity tool) {
        template.save(tool);
    }

    public ToolEntity findByLabel(String label) {
        return (ToolEntity)template.find("from ToolEntity where label=?", label).get(0);
    }

    public void update(ToolEntity tool) {
        template.update(tool);
    }

    public void delete(int id) {
        template.delete(findById(id));
    }

    public ToolEntity findById(int id) {
        return (ToolEntity) template.find("from ToolEntity where id=?", id).get(0);
    }

    public List<ToolEntity> findAll() {
        return (List<ToolEntity>)template.find("from ToolEntity ");
    }
}
