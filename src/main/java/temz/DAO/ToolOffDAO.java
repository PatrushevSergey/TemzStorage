package temz.DAO;

import temz.model.ToolOffEntity;
import java.util.Date;
import java.util.List;

/**
 * Created by Сергей on 26.09.2017.
 */
public interface ToolOffDAO {
    void create(ToolOffEntity toolIn);
    ToolOffEntity findById(int id);
    List<ToolOffEntity> findAll();
    List<ToolOffEntity> findByDate(Date date);
}

