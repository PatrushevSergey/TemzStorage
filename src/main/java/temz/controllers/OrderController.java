package temz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import temz.model.OrderEntity;
import temz.service.OrderService;
import temz.service.ToolService;
import temz.service.UserService;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by Сергей on 29.11.2017.
 * Контроллер, ответственный за работу с заказами
 */
@Controller
public class OrderController extends MainController{
    @Autowired
    private ToolService toolService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    //метод создает страницу с формой нового заказа
    @RequestMapping(value = "/createOrder", method = RequestMethod.GET)
    public String createOrder(Model model) {
        model.addAttribute("toolList", toolService.findAll());
        model.addAttribute("orderList", orderService.findByDate(new Date()));

        model.addAttribute("StringList", getManufacturers());
        return "createOrder";
    }

    // метод добавляет новый заказ в БД
    @RequestMapping(value = "/addedOrder", method = RequestMethod.GET)
    public String orderCreated(OrderEntity order, Model model) {

        try{
            if(order.getAmount()<=0) new Exception();
            if(toolService.findByLabel(order.getToolLabel())==null) new Exception();
            model.addAttribute("isError", false);
            String name = getCurrentUsername();
            order.setUserName(name);
            order.setDate(new java.util.Date());
            orderService.create(order);

        }
        catch (Exception e) {
            model.addAttribute("isError", true);
            return "createOrder";
        }
        model.addAttribute("toolList", toolService.findAll());
        model.addAttribute("orderList", orderService.findByDate(new Date()));
        model.addAttribute("StringList", getManufacturers());

        return "createOrder";
    }


    //метод создает страницу с обзором заказов
    @RequestMapping(value = "/viewOrder", method = RequestMethod.GET)
    public String viewOrder(Model model) {
        model.addAttribute("orderList", orderService.findAll());
        model.addAttribute("userList", userService.findAll());
        return "viewOrder";
    }

    //метод сортирует заказы по дате создания
    @RequestMapping(value = "/orderByDate", method = RequestMethod.POST)
    public String sortOrderByDate(@RequestAttribute("month")String month, String year, Model model) {
        List<OrderEntity> orderByDate = new ArrayList<>();
        for (OrderEntity order: orderService.findAll()) {
            if (order.getDate().getMonth() == Integer.parseInt(month) && order.getDate().getYear() == (Integer.parseInt(year)-1900))
            {
                orderByDate.add(order);
            }
        }
        if (orderByDate.size()>0) {
            model.addAttribute("orderList", orderByDate);
        }
        model.addAttribute("userList", userService.findAll());
        return "viewOrder";
    }

    //метод сортирует заказы по создавшему их пользователю
    @RequestMapping(value = "/orderByUser", method = RequestMethod.POST)
    public String sortOrderByUser(String login, Model model) throws UnsupportedEncodingException {

        List<OrderEntity> orderByUser = new ArrayList<>();
        for (OrderEntity order : orderService.findAll()) {
            if (order.getUserName().equals(login)) {
                orderByUser.add(order);
            }
        }
        if (orderByUser.size() > 0) {
            model.addAttribute("orderList", orderByUser);
        }
        model.addAttribute("userList", userService.findAll());
        return "viewOrder";
    }


}
