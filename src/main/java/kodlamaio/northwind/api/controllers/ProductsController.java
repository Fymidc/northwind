package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;


@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController {


    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        super();
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>>getAll(){
        return this.productService.getAll();
    }

    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>>ProductWithCategoryDetails(){
        return this.productService.getProductWithCategoryDetails();
    }

    @GetMapping("/getbyproductname")
    public DataResult<Product>getByProductName( @RequestParam String productName){
        return this.productService.getByProductName(productName);
    }

    @PostMapping("/add")
    public Result add(Product product){
        return this.productService.add(product);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam String productName,@RequestParam int categoryId){
        return this.productService.getByProductNameAndCategoryId(productName,categoryId);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(String productName){
        return this.productService.getByProductNameContains(productName);

    }

    @GetMapping("/getAllByPage")
    public  DataResult<List<Product>> getAll(int pageNo,int pageSize){
        return this.productService.getAll(pageNo-1, pageSize);
    }

    @GetMapping("/getAllSort")
    public DataResult<List<Product>> getAllSorted(){
        return this.productService.getAllSorted();
    }



}
