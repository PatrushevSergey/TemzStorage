package temz.DAO;

import temz.model.ToolInEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by Сергей on 26.09.2017.
 */
public interface ToolInDAO {
    void create(ToolInEntity toolIn);
    ToolInEntity findById(int id);
    List<ToolInEntity> findAll();
    List<ToolInEntity> findByDate(Date date);
}
