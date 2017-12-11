package temz.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import temz.DAO.ToolDAO;
import temz.model.ToolEntity;

import java.util.List;

/**
 * Created by Сергей on 05.09.2017.
 */
@Service
public class ToolServiceImpl implements ToolService {
    private ToolDAO toolDAO;

    @Autowired
    public ToolServiceImpl(ToolDAO toolDAO) {
        this.toolDAO = toolDAO;
    }
    @Transactional
    public void create(ToolEntity tool) {
        this.toolDAO.create(tool);
    }

    @Transactional
    public void update(ToolEntity tool) {
    this.toolDAO.update(tool);
    }

    @Transactional
    public void delete(int id) {
    this.toolDAO.delete(id);
    }

    @Transactional
    public ToolEntity findById(int id) {
        return this.toolDAO.findById(id);
    }

    @Transactional
    public List<ToolEntity> findAll() {
        return this.toolDAO.findAll();
    }

    @Override
    public ToolEntity findByLabel(String label) {
        return toolDAO.findByLabel(label);
    }
}
