package br.com.impactaproject.ecommerce.service;

import br.com.impactaproject.ecommerce.dto.PurchaseDTO;
import br.com.impactaproject.ecommerce.dto.PurchaseResponseDTO;

public interface CheckoutService {
    PurchaseResponseDTO placeOrder(PurchaseDTO purchase);
}
