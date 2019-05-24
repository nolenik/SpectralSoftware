package com.spectral.shop;


import java.util.Comparator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
     @Autowired
     private ProductService productService;
     int n = 1;
     
     @GetMapping("/")
     public String listProduct(Model model,@Nullable @RequestParam("id") Integer currentPage) {
    	 List<Product> products = productService.getProducts();
    	 products.sort(new Comparator<Product>() {
             @Override
             public int compare(Product o1, Product o2) {
                 if (o1.getPrice() == o2.getPrice()) return 0;
                 else if (o1.getPrice()> o2.getPrice()) return n;
                 else return -1*n;
             }
         });
    	 model.addAttribute("products", products);
    	 return "index";
     }
     
     @GetMapping("/sort")
     public String sort()
     {
    	 n*=-1;
    	 return "redirect:/";
     }
     
     @GetMapping("/add")
     public String addproduct(Model model) {
    	 model.addAttribute("product", new Product());
    	 return "add";
     }
     @PostMapping("/add")
     public String submitAdd(@ModelAttribute ("product") Product product) {
    	 productService.add(product);
    	 return "redirect:/";
     }
     @GetMapping("/edit/{id}") 
     public String editproduct(Model model, @PathVariable("id") String id) {
    	 try {
    	 model.addAttribute("product", productService.find(Integer.parseInt(id)));
    	 return "edit";
    	 } catch (Exception e) {return "redirect:/error";} 
     }
     @PostMapping("/edit/{id}")
     public String submitEdit(@ModelAttribute ("product") Product product, @PathVariable("id") String id) {
    	 try {
    		 productService.edit(product, Integer.parseInt(id));
    		 return "redirect:/";
    	 } catch (Exception e) {return "redirect:/error";} 
     }
     
     
     @GetMapping ("/delete/{id}")
     public String delete(@PathVariable ("id") String id)
     {
    	 try {
    		 productService.delete(Integer.parseInt(id));
    		 return "redirect:/";
    	} catch (Exception e) {return "redirect:/error";} 
     }
     @GetMapping ("/error")
     public String error()
     {
    	 return "error";
     }
}
