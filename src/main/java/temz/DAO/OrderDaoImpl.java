package temz.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import temz.model.OrderEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by Сергей on 08.09.2017.
 */
@Repository
public class OrderDaoImpl implements OrderDAO {
    private final HibernateTemplate template;

    @Autowired
    public OrderDaoImpl(HibernateTemplate template) {
        this.template = template;
    }



    @Override
    public List<OrderEntity> findAll() {
        return (List<OrderEntity>)template.find("from OrderEntity ");
    }

    @Override
    public List<OrderEntity> findByDate(Date date) {
        return (List<OrderEntity>) template.find("from OrderEntity where date=?", date);
    }

    @Override
    public void create(OrderEntity order) {
        template.save(order);
    }
}
