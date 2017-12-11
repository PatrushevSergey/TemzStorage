package temz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import temz.DAO.OrderDAO;
import temz.model.OrderEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by Сергей on 08.09.2017.
 */
@Service
public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO;

    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Transactional
    public List<OrderEntity> findAll() {
        return orderDAO.findAll();
    }

    @Transactional
    public List<OrderEntity> findByDate(Date date) {
        return orderDAO.findByDate(date);
    }

    @Transactional
    public void create(OrderEntity order) {
        orderDAO.create(order);
    }
}
