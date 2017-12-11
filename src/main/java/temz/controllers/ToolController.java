package temz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import temz.model.ToolEntity;
import temz.service.ProductService;
import temz.service.StorageService;
import temz.service.ToolService;

import java.io.UnsupportedEncodingException;

/**
 * Created by Сергей on 10.12.2017.
 */
@Controller
public class ToolController  extends MainController{

    @Autowired
    private ToolService toolService;
    @Autowired
    private StorageService storageService;
    @Autowired
    private ProductService productService;

    //обработчик ошибки error 404
    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String error404Keeper(){
        return "/errorPage404";
    }

    //обработчик ошибки error 500
    @RequestMapping(value = "/500", method = RequestMethod.GET)
    public String error500Keeper(){
        return "errorPage500";
    }

    //обработчик ошибки error 403
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String error403Keeper(){
        return "errorPage403";
    }

    //основной экран приложения, формирует таблицу инструмента
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainer(Model model){
        model.addAttribute("toolList", toolService.findAll());
        model.addAttribute("storageList", storageService.findAll());
        return "/tableOfTool";
    }

    //создает страничку для создания инструмента
    @RequestMapping(value = "/createTool", method = RequestMethod.GET)
    public String tool(Model model) {
        model.addAttribute("productList", productService.findAll());
        return "createTool";
    }

    //добавляет новый инструмент в БД
    @RequestMapping(value = "/added", method = RequestMethod.POST)
    public String addTool(ToolEntity tool, String proLabel) throws UnsupportedEncodingException {
        tool.setComment(decoder(tool.getComment()));
        tool.setFunction(decoder(tool.getFunction()));
        tool.setLabel(decoder(tool.getLabel()));
        tool.setManufacturer(decoder(tool.getManufacturer()));
        if( !proLabel.equals("")) {
            tool.getProducts().add(productService.findByLabel(proLabel));
        }
        toolService.create(tool);
        return "redirect:/main";
    }

    //метод создает страницу редактирования и удления инструмента
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String toolUpdate(@PathVariable("id") int id, Model model) {
        ToolEntity tool = toolService.findById(id);
        model.addAttribute("id", tool.getId());
        model.addAttribute("manufacturer", tool.getManufacturer());
        model.addAttribute("label", tool.getLabel());
        model.addAttribute("function", tool.getFunction());
        model.addAttribute("amount", tool.getToolAmount());
        model.addAttribute("comment", tool.getComment());
        model.addAttribute("productList", productService.findAll());
        return "updateTool";
    }

    // метод сохраняет изменения инструмента в БД
    @RequestMapping(value = "/updated", method = RequestMethod.POST)
    public String toolUpdated(@Validated ToolEntity tool, String proLabel) throws UnsupportedEncodingException {
        proLabel = decoder(proLabel);
        tool.setComment(decoder(tool.getComment()));
        tool.setFunction(decoder(tool.getFunction()));
        tool.setLabel(decoder(tool.getLabel()));
        tool.setToolAmount(tool.getToolAmount());
        tool.setManufacturer(decoder(tool.getManufacturer()));
        tool.setProducts(toolService.findById(tool.getId()).getProducts());
        if(proLabel.equals("")) {toolService.update(tool);}
        else {
            tool.getProducts().add(productService.findByLabel(proLabel));
            toolService.update(tool);
        }
        return "redirect:/main";
    }

    // метод удаляет инструмент из БД
    @RequestMapping(value = "/deleted/{id}", method = RequestMethod.GET)
    public String deleteTool(@PathVariable("id")int id) {
        toolService.delete(id);
        return "redirect:/main";
    }
}
