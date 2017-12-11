package temz.service;

import temz.model.StorageEntity;

import java.util.List;

/**
 * Created by Сергей on 05.09.2017.
 */
public interface StorageService {
    List<StorageEntity> findAll();
    void create(StorageEntity storage);
}
