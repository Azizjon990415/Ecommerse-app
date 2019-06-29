package uz.pdp.ecommersapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.pdp.ecommersapp.entity.Adress;
import uz.pdp.ecommersapp.projection.AdressProjection;
import uz.pdp.ecommersapp.projection.RegionProjection;

import java.util.UUID;

@RepositoryRestResource(path = "adress",collectionResourceRel = "adress",excerptProjection = AdressProjection.class )
public interface AdressRepository extends JpaRepository<Adress, UUID> {
}
