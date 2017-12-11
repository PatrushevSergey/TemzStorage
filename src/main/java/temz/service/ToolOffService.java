package temz.service;

import temz.model.ToolOffEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by Сергей on 26.09.2017.
 */
public interface ToolOffService {
    void create(ToolOffEntity toolOff);
    ToolOffEntity findById(int id);
    List<ToolOffEntity> findAll();
    List<ToolOffEntity> findByDate(Date date);
}
