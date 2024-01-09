package br.com.impactaproject.ecommerce.assemble;

import br.com.impactaproject.ecommerce.dto.ProductDTO;
import br.com.impactaproject.ecommerce.entities.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductAssemble {

    private final ModelMapper modelMapper;


    public ProductDTO toModel(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    public List<ProductDTO> toCollectionModel(List<Product> products) {
        return products.stream().map(
                this::toModel
        ).collect(Collectors.toList());
    }
}
