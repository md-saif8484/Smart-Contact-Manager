package productcrudapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

@Controller
public class MainController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String home(Model m)
	{
		List<Product> product = productDao.getProducts();
		m.addAttribute("products", product);
		return "index";
	}
	
	@RequestMapping("/add-product")
	public String addProduct(Model m)
	{
		m.addAttribute("title","Add Product");
		return "add_product";
	}
	
	@RequestMapping(value="handle-product", method=RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request)
	{
		System.out.println(product);
		productDao.createProduct(product);
		RedirectView r = new RedirectView();
		r.setUrl(request.getContextPath()+"/");
		return r;
	}
	
	@RequestMapping(value="/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request)
	{
		this.productDao.deleteProduct(productId);
		RedirectView r = new RedirectView();
		r.setUrl(request.getContextPath()+"/");
		return r;
	}
	
	@RequestMapping(value="/update/{productId}")
	public String updatehandler(@PathVariable("productId") int productId, Model m)
	{
		Product product = this.productDao.getProduct(productId);
		m.addAttribute(product);
		return "update_form";
	}
}
