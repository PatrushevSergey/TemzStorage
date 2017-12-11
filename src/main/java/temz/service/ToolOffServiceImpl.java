package temz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import temz.DAO.ToolOffDAO;
import temz.model.ToolOffEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by Сергей on 26.09.2017.
 */
@Service
public class ToolOffServiceImpl implements ToolOffService {
    private ToolOffDAO dao;

    @Autowired
    public ToolOffServiceImpl(ToolOffDAO dao) {
        this.dao = dao;
    }



    @Override
    @Transactional
    public void create(ToolOffEntity toolOff) {
        dao.create(toolOff);
    }

    @Override
    @Transactional
    public ToolOffEntity findById(int id) {
        return dao.findById(id);
    }

    @Override
    @Transactional
    public List<ToolOffEntity> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public List<ToolOffEntity> findByDate(Date date) {
        return dao.findByDate(date);
    }
}
