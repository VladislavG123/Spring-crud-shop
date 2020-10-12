package com.step.shop.data;

import com.step.shop.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository<Product, Integer> {
}
