package dev.surya.productservice.services;

import dev.surya.productservice.dtos.FakeStoreDto;
import dev.surya.productservice.models.Category;
import dev.surya.productservice.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProxyProductService implements ProductService {
    private RestTemplate restTemplate;
    private String getProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String createProductRequestUrl = "https://fakestoreapi.com/products";

    public FakeStoreProxyProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreDtoToProduct(FakeStoreDto dto) {
        Product product = new Product();
        product.setTitle(dto.getTitle());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setImage(dto.getImage());
        Category category = new Category();

        category.setId(dto.getId());
        category.setDescription(dto.getCategory());
        product.setCategory(category);


        return product;
    }


    @Override

    public Product getProductById(Long id) {
        FakeStoreDto fakeStoreDto = restTemplate.getForObject(getProductRequestUrl, FakeStoreDto.class);

        if (fakeStoreDto == null)
            return null;
        return convertFakeStoreDtoToProduct(fakeStoreDto);
        //   return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }


}
