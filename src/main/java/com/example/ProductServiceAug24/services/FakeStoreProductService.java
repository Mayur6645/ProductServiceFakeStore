package com.example.ProductServiceAug24.services;

import com.example.ProductServiceAug24.dtos.FakeStoreProductDTO;
import com.example.ProductServiceAug24.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService {
    @Override
    public Product getProductById(long id) {
        /*
        Take id and call this endpoint
        https://fakestoreapi.com/products/ + id
         */
        String url = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = new RestTemplate();
        // convert data resp to DTO as it is from fakestore

        FakeStoreProductDTO fakeStoreProductDTO=restTemplate.getForObject(url, FakeStoreProductDTO.class);
        return ConvertFakeStoreDTOtoProduct(fakeStoreProductDTO);
    }
    private Product ConvertFakeStoreDTOtoProduct(FakeStoreProductDTO fakeStoreProductDTO){
        Product product=new Product();
        product.setName(fakeStoreProductDTO.getTitle());
        product.setCategory(fakeStoreProductDTO.getCategory());
        product.setDescription(fakeStoreProductDTO.getDescription());
        return product;
    }
}
