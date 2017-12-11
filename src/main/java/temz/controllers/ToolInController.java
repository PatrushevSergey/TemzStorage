package temz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import temz.model.ToolEntity;
import temz.model.ToolInEntity;
import temz.service.ToolInService;
import temz.service.ToolService;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by Сергей on 29.11.2017.
 * Контроллер, ответственный за работу с приходом инструмента
 */
@Controller
public class ToolInController extends MainController{
    @Autowired
    private ToolService toolService;
    @Autowired
    private ToolInService toolInService;

    //метод создает страницу с формой для создания нового прихода товара
    @RequestMapping(value = "/createIn", method = RequestMethod.POST)
    public String createIn(Model model) {
        model.addAttribute("toolList", toolService.findAll());
        model.addAttribute("inList", toolInService.findByDate(new Date()));

        model.addAttribute("StringList", getManufacturers());
        return "/viewIn";
    }

    //метод записывает приход товара в БД
    @RequestMapping(value = "/addedToolIn", method = RequestMethod.GET)
    public String toolInCreated(ToolEntity tool, Model model) {
        model.addAttribute("toolList", toolService.findAll());
        model.addAttribute("StringList", getManufacturers());

        try {
            if (tool.getToolAmount()<0) throw new Exception();
            model.addAttribute("isError", false);
            ToolInEntity toolIn = new ToolInEntity();
            toolIn.setDate(new Date());
            toolIn.setUserLogin(getCurrentUsername());
            toolIn.setToolAmount(tool.getToolAmount());
            toolIn.setToolId(toolService.findByLabel(tool.getLabel()).getId());
            toolInService.create(toolIn);
            ToolEntity updatedTool = toolService.findByLabel(tool.getLabel());
            updatedTool.setToolAmount(updatedTool.getToolAmount()+ tool.getToolAmount());
            toolService.update(updatedTool);
            model.addAttribute("inList", toolInService.findByDate(new Date()));
        }
        catch (Exception e) {
            model.addAttribute("isError", true);
            model.addAttribute("inList", toolInService.findByDate(new Date()));
            return"/viewIn";
        }

        return "/viewIn";
    }

    //метод выводит на страницу позиции прихода по конкретной дате
    @RequestMapping(value = "/inByDate", method = RequestMethod.POST)
    public String sortInByDate(@RequestAttribute("month")String month, String year, Model model) {
        List<ToolInEntity> toolInByDate = new ArrayList<>();
        for (ToolInEntity toolIn: toolInService.findAll()) {
            if (toolIn.getDate().getMonth() == Integer.parseInt(month) && toolIn.getDate().getYear() == (Integer.parseInt(year)-1900))
            {
                toolInByDate.add(toolIn);
            }
        }
        if (toolInByDate.size()>0) {
            model.addAttribute("inList", toolInByDate);
        }
        model.addAttribute("toolList", toolService.findAll());
        model.addAttribute("StringList", getManufacturers());
        return "/viewIn";
    }

    //метод выводит на страницу список прихода по конкретному инструменту
    @RequestMapping(value = "/inByLabel", method = RequestMethod.POST)
    public String sortInByLabel(String label, Model model) throws UnsupportedEncodingException {
        List<ToolInEntity> toolInByLabel = new ArrayList<>();
        for (ToolInEntity toolIn: toolInService.findAll()) {
            if (toolIn.getToolId() == toolService.findByLabel(decoder(label)).getId())
            {
                toolInByLabel.add(toolIn);
            }
        }
        if (toolInByLabel.size()>0) {
            model.addAttribute("inList", toolInByLabel);
        }
        model.addAttribute("toolList", toolService.findAll());
        model.addAttribute("StringList", getManufacturers());
        return "/viewIn";
    }


}
