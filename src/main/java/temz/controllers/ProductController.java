package temz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import temz.model.ProductEntity;
import temz.service.ProductService;
import temz.service.ToolService;
import java.io.UnsupportedEncodingException;

/**
 * Created by Сергей on 29.11.2017.
 * Контроллер, ответственный за операции с деталями
 */
@Controller
public class ProductController extends MainController{
    @Autowired
    private ToolService toolService;
    @Autowired
    private ProductService productService;


    //метод создает страницу для обзора изготавливаемых деталей
    @RequestMapping(value = "/viewProduct", method = RequestMethod.GET)
    public String showAllProduct( Model model) {
        model.addAttribute("productList", productService.findAll());
        return "/allProducts";
    }

    //метод показывает список деталей, изготавливаемых конкретным инструментом
    @RequestMapping(value = "/showProduct", method = RequestMethod.POST)
    public String showProduct(String label, Model model) throws UnsupportedEncodingException {
        model.addAttribute("productList", toolService.findByLabel(decoder(label)).getProducts());
        model.addAttribute("StringList", getManufacturers());
        return "/productByTool";
    }

    //метод показывает инструмент, требуемый для изготовления выбранной детали
    @RequestMapping(value = "/showTool", method = RequestMethod.POST)
    public String showTool(String proLabel, Model model) throws UnsupportedEncodingException {
        model.addAttribute("toolList", productService.findByLabel(decoder(proLabel)).getTools());
        model.addAttribute("StringList", getManufacturers());
        return "/toolByProduct";
    }

    //создает страницу с формой создания новой детали
    @RequestMapping(value = "/createProduct", method = RequestMethod.GET)
    public String createProduct() {
        return "/createProduct";
    }

    //метод сохраняет новую деталь в БД
    @RequestMapping(value = "/createdProduct", method = RequestMethod.POST)
    public String createdProduct(ProductEntity product, Model model) throws UnsupportedEncodingException {
        product.setOfLabel(decoder(product.getOfLabel()));
        product.setProLabel(decoder(product.getProLabel()));
        productService.create(product);
        model.addAttribute("productList", productService.findAll());
        return "/allProducts";
    }


}
