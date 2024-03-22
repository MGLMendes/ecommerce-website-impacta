package br.com.impactaproject.ecommerce.dto;

import br.com.impactaproject.ecommerce.entities.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String sku;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private String imageUrl;
    private Boolean active;
    private Integer unitsInStock;
    private Date dateCreated;
    private Date lastUpdated;
    private ProductCategoryDTO category;
}
