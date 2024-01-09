package br.com.impactaproject.ecommerce.assemble;

import br.com.impactaproject.ecommerce.dto.ProductCategoryDTO;
import br.com.impactaproject.ecommerce.entities.ProductCategory;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProductCategoryAssemble {

    private final ModelMapper modelMapper;


    public ProductCategoryDTO toModel(ProductCategory productCategory) {
        return modelMapper.map(productCategory, ProductCategoryDTO.class);
    }


    public List<ProductCategoryDTO> toCollectionModel(List<ProductCategory> productCategoryList) {
        return productCategoryList.stream().map(
                this::toModel
        ).collect(Collectors.toList());
    }
}
