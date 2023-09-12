package com.example.suntestmvc.controller;

import com.example.suntestmvc.model.Product;
import com.example.suntestmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id).orElse(null);
        model.addAttribute("product", product);
        return "view";
    }

    @GetMapping("/new")
    public String createProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/new")
    public String createProduct(@ModelAttribute("product") Product product) {
        productService.addProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String editProductForm(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id).orElse(null);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("/{id}/edit")
    public String editProduct(@PathVariable Long id, @ModelAttribute("product") Product product) {
        productService.updateProduct(id, product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }

//    @GetMapping("/clubs")
//    public String listClubs(Model model){
//        List<ClubDto>  clubs = clubService.findAllClubs();
//        model.addAttribute("club",clubs);
//        return "clubs-list";
//    }
//
//    @GetMapping("/clubs/new")
//        public String createClubForm(Model model){
//            Product club = new Product();
//            model.addAttribute("club",club);
//            return "clubs-create";
//    }
//
//    @PostMapping("/clubs/new")
//    public String saveClub(@ModelAttribute("club") Product club){
//        clubService.saveClub(club);
//            return "redirect:/clubs";
//    }
//
//    @GetMapping("/club/{clubId}/edit")
//    public String editClubForm(@PathVariable Long clubId, Model model){
//        Product clubDto = clubService.findClubById(clubId);
//        model.addAttribute("club",clubDto);
//        return "clubs-edit";
//    }
//
//    @PostMapping("/clubs/{clubId}/edit")
//    public String updateClub(@PathVariable("clubId") Long clubId,
//                             @ModelAttribute("club") ClubDto club,
//                             BindingResult result, Model model) {
//        if(result.hasErrors()) {
//            model.addAttribute("club", club);
//            return "clubs-edit";
//        }
//        club.setId(clubId);
//        clubService.updateClub(club);
//        return "redirect:/clubs";
//    }

}
