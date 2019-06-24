package uz.pdp.ecommersapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.ecommersapp.entity.Categoria;
import uz.pdp.ecommersapp.entity.Product;
import uz.pdp.ecommersapp.payload.ProductCategoryReq;
import uz.pdp.ecommersapp.payload.ProductReq;
import uz.pdp.ecommersapp.payload.ProductResponse;
import uz.pdp.ecommersapp.payload.Result;
import uz.pdp.ecommersapp.repository.ProductRepository;

import java.util.*;


@Service
public class ProductServiceImp implements ProductService {


    @Autowired
    ProductRepository productRepository;

    @Override
    public ResponseEntity<Result> addProduct(ProductReq productReq) {
        Result result = new Result();
        Product newProduct = new Product();
        newProduct.setName(productReq.getName());
        newProduct.setPrice(productReq.getPrice());
        if (productReq.getCategoria() != null) {
            newProduct.setCategoria(productReq.getCategoria());
            newProduct.setAttachment(productReq.getAttachment());
            newProduct.setDetails(productReq.getDetails());
            Product savedProduct = productRepository.save(newProduct);
            if (savedProduct != null) {
                result.setMessage(savedProduct.getName() + " saved successfully");
                result.setSuccess(true);
                return ResponseEntity.ok(result);
            } else {
                result.setMessage(savedProduct.getName() + " not saved.Server Error");
                result.setSuccess(false);
                return ResponseEntity.status(500).body(result);
            }
        } else {
            result.setMessage(productReq.getName() + " not saved.Incorrect response");
            result.setSuccess(false);
            return ResponseEntity.status(400).body(result);
        }

    }

    @Override
    public ResponseEntity<Product> editProduct(Integer id, ProductReq productReq) {
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isPresent()) {
            Product baseProduct = optional.get();
            baseProduct.setName(productReq.getName());
            baseProduct.setPrice(productReq.getPrice());
            baseProduct.setDetails(productReq.getDetails());
            baseProduct.setAttachment(productReq.getAttachment());
            baseProduct.setCategoria(productReq.getCategoria());
            Product changedProduct = productRepository.save(baseProduct);
            if (changedProduct != null) {
                return ResponseEntity.ok(changedProduct);
            } else {
                return ResponseEntity.status(500).build();
            }

        } else {
            return ResponseEntity.status(400).build();
        }
    }

    @Override
    public ResponseEntity<List<ProductResponse>> takeProductByCategory(ProductCategoryReq productCategoryReq) {
        List<Product> products = productRepository.getAllByCategoria_Id(productCategoryReq.getId());
        if (products != null) {
            List<ProductResponse> productResponses = new ArrayList<>();
            products.forEach(product -> {
                ProductResponse productResponse = new ProductResponse();
                productResponse.setId(product.getId());
                productResponse.setName(product.getName());
                productResponse.setPrice(product.getPrice());
                productResponse.setCategoria(product.getCategoria());
                productResponse.setViews(product.getViews());
                productResponses.add(productResponse);
            });
            return ResponseEntity.ok(productResponses);
        } else {
            return ResponseEntity.status(500).build();
        }
    }

    @Override
    public ResponseEntity<List<ProductResponse>> takeProductTop10() {
        int count = 0;
        List<Product> products = productRepository.findAll();
        ProductComparator productComparator = new ProductComparator();
        products.sort(productComparator);
        List<ProductResponse> sendingProduct = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(products.get(i).getId());
            productResponse.setName(products.get(i).getName());
            productResponse.setPrice(products.get(i).getPrice());
            productResponse.setCategoria(products.get(i).getCategoria());
            productResponse.setViews(products.get(i).getViews());
            sendingProduct.add(productResponse);
            count++;
            if (count == 10) break;
        }
        if (sendingProduct!=null){
            return ResponseEntity.ok(sendingProduct);
        }else{
            return ResponseEntity.status(500).build();
        }
    }

    @Override
    public ResponseEntity<List<ProductResponse>> takeProductNews() {
       List<Product> products=productRepository.findBySortedDate();
       int count=0;
        List<ProductResponse> sendingProduct = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(products.get(i).getId());
            productResponse.setName(products.get(i).getName());
            productResponse.setPrice(products.get(i).getPrice());
            productResponse.setCategoria(products.get(i).getCategoria());
            productResponse.setViews(products.get(i).getViews());
            sendingProduct.add(productResponse);
            count++;
            if (count == 10) break;
        } if (sendingProduct!=null){
            return ResponseEntity.ok(sendingProduct);
        }else{
            return ResponseEntity.status(500).build();
        }

    }
}

class ProductComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getViews() > o2.getViews()) return -1;
        return 0;
    }
}