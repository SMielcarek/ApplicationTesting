package com.apptesting;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class CartServiceTest {

    private CartService cartService;

    @Before
    public void initialize() {
        Product[] products = new Product[] {
                new Product(0,"Product 0",new BigDecimal("17.99")),
                new Product(1,"Product 1",new BigDecimal("21.49")),
                new Product(2,"Product 2",new BigDecimal("49.00")),
                new Product(3,"Product 3",new BigDecimal("35.19")),
        };
        ProductRepository mockedProductRepository = EasyMock.createMock(ProductRepository.class);
        for (int i=0; i<products.length; i++) {
            EasyMock.expect(mockedProductRepository.getProductById(i)).andReturn(products[i]);
        }
        EasyMock.replay(mockedProductRepository);
        cartService = new CartService(mockedProductRepository);
    }

    @Test
    public void calculateCartValueTest() {
        cartService.addProductToCart(1,2);
        cartService.addProductToCart(2,1);
        BigDecimal expectedValue = new BigDecimal("101.98");
        BigDecimal cartValue = cartService.calculateCartValue();
        assertThat(cartValue,equalTo(expectedValue));
    }

}
