package uz.pdp.ecommersapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.pdp.ecommersapp.entity.Adress;

@RepositoryRestResource(path = "/api/adress",excerptProjection = Adress.class )
public interface AdressRepository extends JpaRepository<Adress,Integer> {
}
