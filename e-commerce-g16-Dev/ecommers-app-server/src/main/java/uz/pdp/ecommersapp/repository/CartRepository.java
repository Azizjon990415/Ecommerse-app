package uz.pdp.ecommersapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.ecommersapp.entity.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
}
