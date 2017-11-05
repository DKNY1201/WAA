package com.quytran.webstore.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.quytran.webstore.domain.Product;
import com.quytran.webstore.exception.NoProductsFoundUnderCategoryException;
import com.quytran.webstore.exception.ProductNotFoundException;
import com.quytran.webstore.service.ProductService;

@Controller
@RequestMapping("/market")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/products")
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	@RequestMapping("/tests")
	public String testRedirect() {
		return "forward:/market/products";
	}

	@RequestMapping("/update/stock")
	public String updateStock(Model model) {
		productService.updateAllStock();
		return "redirect:/market/products";
	}

	@RequestMapping("/products/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
		List<Product> products = productService.getProductsByCategory(productCategory);

		if (products == null || products.isEmpty()) {
			throw new NoProductsFoundUnderCategoryException();
		}

		model.addAttribute("products", products);
		return "products";
	}

	@RequestMapping("/products/filter/{params}/{specification}")
	public String getProductsByFilter(@MatrixVariable(pathVar = "params") Map<String, List<String>> filterParams,
			@MatrixVariable(pathVar = "specification") Map<String, List<String>> filterSpecification, Model model) {
		model.addAttribute("products", productService.getProductsByFilter(filterParams));
		return "products";
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String getProductById(@RequestParam("id") String productID, Model model, HttpServletRequest req) {
		model.addAttribute("product", productService.getProductById(productID));
		model.addAttribute("currentUrl", req.getRequestURL() + "?" + req.getQueryString());
		return "product";
	}

	@RequestMapping(value = "/products/{category}/{params}", method = RequestMethod.GET)
	public String filterProducts(@PathVariable String category, @RequestParam String brand,
			@MatrixVariable(pathVar = "params") Map<String, List<String>> filterParams, Model model) {
		model.addAttribute("products", productService.getProductsByMultiCriteria(category, brand, filterParams));
		return "products";
	}

	@RequestMapping(value = "/products/add", method = RequestMethod.GET)
	public String getAddNewProductForm(@ModelAttribute("newProduct") Product product) {
		return "addProduct";
	}

	@RequestMapping(value = "/products/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct, BindingResult result,
			HttpServletRequest request) {
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");

		MultipartFile productImage = newProduct.getProductImage();
		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(
						new File(rootDirectory + "/resources/images/" + newProduct.getProductId() + ".jpg"));
			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
			}
		}

		MultipartFile productManual = newProduct.getProductManual();
		if (productManual != null && !productManual.isEmpty()) {
			try {
				productManual
						.transferTo(new File(rootDirectory + "/resources/pdf/" + newProduct.getProductId() + ".pdf"));
			} catch (Exception e) {
				throw new RuntimeException("Product Manual saving failed", e);
			}
		}

		productService.addProduct(newProduct);
		return "redirect:/market/products";
	}

	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("productId", "name", "unitPrice", "description", "manufacturer", "category",
				"unitsInStock", "condition", "productImage", "productManual", "language");
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidProductId", exception.getProductId());
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL() + "?" + req.getQueryString());
		mav.setViewName("productNotFound");
		return mav;
	}
}