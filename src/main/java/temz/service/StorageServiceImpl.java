package temz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import temz.DAO.StorageDAO;
import temz.model.StorageEntity;

import java.util.List;

/**
 * Created by Сергей on 05.09.2017.
 */
@Service
public class StorageServiceImpl implements StorageService {
    private final StorageDAO storageDAO;

    @Autowired
    public StorageServiceImpl(StorageDAO storageDAO) {
        this.storageDAO = storageDAO;
    }


    @Transactional
    public void create(StorageEntity storage) {
        storageDAO.create(storage);
    }

    @Transactional
    public List<StorageEntity> findAll() {
        return storageDAO.findAll();
    }
}
