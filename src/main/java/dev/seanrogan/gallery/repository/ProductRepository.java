package dev.seanrogan.gallery.repository;

import dev.seanrogan.gallery.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
