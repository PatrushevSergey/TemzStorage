package temz.service;

import temz.model.OrderEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by Сергей on 08.09.2017.
 */
public interface OrderService {
    List<OrderEntity> findAll();
    List<OrderEntity> findByDate(Date date);
    void create(OrderEntity order);
}
