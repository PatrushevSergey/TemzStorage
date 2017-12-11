package temz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import temz.model.ToolEntity;
import temz.model.ToolOffEntity;
import temz.service.ToolOffService;
import temz.service.ToolService;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by Сергей on 29.11.2017.
 * Контроллер, ответственный за работу с расходом инструмента
 */
@Controller
public class ToolOffController extends MainController{
    @Autowired
    private ToolService toolService;
    @Autowired
    private ToolOffService toolOffService;

    //метод создает страничку с формой для создания нового расхода инструмента
    @RequestMapping(value = "/createOut", method = RequestMethod.POST)
    public String createOut(Model model) {
        model.addAttribute("toolList", toolService.findAll());
        model.addAttribute("outList", toolOffService.findByDate(new Date()));
        model.addAttribute("StringList", getManufacturers());
        return "/viewOut";
    }

    //метод добавляет новый расход в БД
    @RequestMapping(value = "/addedToolOff", method = RequestMethod.GET)
    public String toolOffCreated(ToolEntity tool, Model model) {
        model.addAttribute("toolList", toolService.findAll());
        model.addAttribute("StringList", getManufacturers());
        try {
            if (tool.getToolAmount()<0) throw new Exception();
            model.addAttribute("isError", false);
            ToolOffEntity toolOff = new ToolOffEntity();
            toolOff.setDate(new Date());
            toolOff.setUserLogin(getCurrentUsername());
            toolOff.setToolAmount(tool.getToolAmount());
            toolOff.setToolId(toolService.findByLabel(tool.getLabel()).getId());
            toolOffService.create(toolOff);
            ToolEntity updatedTool = toolService.findByLabel(tool.getLabel());
            updatedTool.setToolAmount(updatedTool.getToolAmount()- tool.getToolAmount());
            toolService.update(updatedTool);
            model.addAttribute("outList", toolOffService.findByDate(new Date()));
        }
        catch (Exception e) {
            model.addAttribute("isError", true);
            model.addAttribute("outList", toolOffService.findByDate(new Date()));
            return"/viewOut";
        }
        return "/viewOut";
    }

    //метод выводит на страницу расход по конкретной дате
    @RequestMapping(value = "/outByDate", method = RequestMethod.POST)
    public String sortOutByDate(@RequestAttribute("month")String month, String year, Model model) {
        List<ToolOffEntity> toolOffByDate = new ArrayList<>();
        for (ToolOffEntity toolOff: toolOffService.findAll()) {
            if (toolOff.getDate().getMonth() == Integer.parseInt(month) && toolOff.getDate().getYear() == (Integer.parseInt(year)-1900))
            {
                toolOffByDate.add(toolOff);
            }
        }
        if (toolOffByDate.size()>0) {
            model.addAttribute("outList", toolOffByDate);
        }
        model.addAttribute("toolList", toolService.findAll());
        model.addAttribute("StringList", getManufacturers());
        return "/viewOut";
    }

    //метод выводит на страницу расход по конкретному инструменту
    @RequestMapping(value = "/outByLabel", method = RequestMethod.POST)
    public String sortOutByLabel(String label, Model model) throws UnsupportedEncodingException {
        List<ToolOffEntity> toolOffByLabel = new ArrayList<>();
        for (ToolOffEntity toolOff: toolOffService.findAll()) {
            if (toolOff.getToolId() == toolService.findByLabel(decoder(label)).getId())
            {
                toolOffByLabel.add(toolOff);
            }
        }
        if (toolOffByLabel.size()>0) {
            model.addAttribute("outList", toolOffByLabel);
        }
        model.addAttribute("toolList", toolService.findAll());
        model.addAttribute("StringList", getManufacturers());
        return "/viewOut";
    }


}
