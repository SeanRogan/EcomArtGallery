package dev.seanrogan.gallery.repository;

import dev.seanrogan.gallery.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

}
