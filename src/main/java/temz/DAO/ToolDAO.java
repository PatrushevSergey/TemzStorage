package temz.DAO;

import temz.model.ToolEntity;

import java.util.List;

/**
 * Created by Сергей on 05.09.2017.
 */
public interface ToolDAO {
    void create(ToolEntity tool);
    void update(ToolEntity tool);
    void delete(int id);
    ToolEntity findById(int id);
    List<ToolEntity> findAll();
    ToolEntity findByLabel(String label);

}
