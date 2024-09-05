package dev.surya.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreDto {

    private long id;
    private String title;
    private  double price;
    private String category;
    private String description;

    private String image;
}
