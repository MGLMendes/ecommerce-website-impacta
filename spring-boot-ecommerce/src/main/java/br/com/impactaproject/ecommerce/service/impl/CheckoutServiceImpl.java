package br.com.impactaproject.ecommerce.service.impl;

import br.com.impactaproject.ecommerce.dto.PurchaseDTO;
import br.com.impactaproject.ecommerce.dto.PurchaseResponseDTO;
import br.com.impactaproject.ecommerce.entities.Customer;
import br.com.impactaproject.ecommerce.entities.Order;
import br.com.impactaproject.ecommerce.entities.OrderItem;
import br.com.impactaproject.ecommerce.repositories.CustomerRepository;
import br.com.impactaproject.ecommerce.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public PurchaseResponseDTO placeOrder(PurchaseDTO purchase) {
        Order order = purchase.getOrder();
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        Set<OrderItem> orderItems = purchase.getOrderItems();

        orderItems.forEach(
                order::add
        );

        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        Customer customer = purchase.getCustomer();

        customer.addOrder(order);

        customerRepository.save(customer);

        return new PurchaseResponseDTO(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
