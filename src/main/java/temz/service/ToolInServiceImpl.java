package temz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import temz.DAO.ToolInDAO;
import temz.model.ToolInEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by Сергей on 26.09.2017.
 */
@Service
public class ToolInServiceImpl implements ToolInService {
    private ToolInDAO dao;

    @Autowired
    public ToolInServiceImpl(ToolInDAO dao) {
        this.dao = dao;
    }
    @Override
    @Transactional
    public void create(ToolInEntity toolIn) {
        dao.create(toolIn);
    }

    @Override
    @Transactional
    public ToolInEntity findById(int id) {
        return dao.findById(id);
    }

    @Override
    @Transactional
    public List<ToolInEntity> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public List<ToolInEntity> findByDate(Date date) {
        return dao.findByDate(date);
    }
}
