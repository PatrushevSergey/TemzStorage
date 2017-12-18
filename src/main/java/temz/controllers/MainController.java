package temz.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import temz.model.ToolEntity;
import temz.service.*;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Сергей on 05.09.2017.
 * Контроллер, ответственный за служебные действия
 */
@Controller
public class MainController {

    @Autowired
    private ToolService toolService;


    //без этого почему то не работало...
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexer(){
        return "redirect:/main";
    }





    //Метод для перекодировки строк, приходящих со страничек, иначе получаются иероглифы(
    public String decoder(String s) throws UnsupportedEncodingException {
        return new String(s.getBytes("ISO-8859-1"),"UTF8");
    }

    //метод создает список производителей инструмента для скрипта
    public Set<String> getManufacturers() {
        Set<String> manufacturers = new HashSet<>();
        for (ToolEntity x: toolService.findAll()) {
            manufacturers.add(x.getManufacturer());
        }
        return manufacturers;
    }

    //метод передает имя текущего пользователя
    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
}
