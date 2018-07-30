package com.apptesting;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class CartService {

    private ProductRepository repository;
    private List<CartItem> cartItems = new LinkedList<>();
    private BigDecimal shippingCosts = new BigDecimal("10.00");

    public CartService(ProductRepository repository) {
        this.repository = repository;
    }

    public void addProductToCart(int productId, int quantity) {
        Product product = repository.getProductById(productId);
        cartItems.add(new CartItem(product,quantity));
    }

    public BigDecimal calculateCartValue() {
        BigDecimal cartValue = BigDecimal.ZERO;
        for (CartItem cartItem : cartItems) {
            BigDecimal itemPrice = cartItem.getProduct().getPrice();
            BigDecimal itemQuantity = BigDecimal.valueOf(cartItem.getQuantity());
            cartValue = cartValue.add(itemPrice.multiply(itemQuantity));
        }
        return cartValue.add(shippingCosts);
    }

}
