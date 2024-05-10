package br.com.impactaproject.ecommerce.dto;

import br.com.impactaproject.ecommerce.entities.Address;
import br.com.impactaproject.ecommerce.entities.Customer;
import br.com.impactaproject.ecommerce.entities.Order;
import br.com.impactaproject.ecommerce.entities.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class PurchaseDTO {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
