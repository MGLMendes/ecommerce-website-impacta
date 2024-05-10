package br.com.impactaproject.ecommerce.controller;

import br.com.impactaproject.ecommerce.dto.PurchaseDTO;
import br.com.impactaproject.ecommerce.dto.PurchaseResponseDTO;
import br.com.impactaproject.ecommerce.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/checkout")
@RestController
@CrossOrigin(maxAge = 20)
@RequiredArgsConstructor
public class CheckoutController {

    private final CheckoutService checkoutService;

    @PostMapping("/purchase")
    public ResponseEntity<PurchaseResponseDTO> placeOrder(
            @RequestBody PurchaseDTO purchase
            ) {
        PurchaseResponseDTO purchaseResponseDTO = checkoutService.placeOrder(purchase);

        return ResponseEntity.status(201).body(purchaseResponseDTO);
    }
}
