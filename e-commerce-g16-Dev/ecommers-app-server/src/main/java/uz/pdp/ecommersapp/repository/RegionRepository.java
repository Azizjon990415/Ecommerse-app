package uz.pdp.ecommersapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.pdp.ecommersapp.entity.PayType;
import uz.pdp.ecommersapp.entity.Region;

@RepositoryRestResource(path = "/api/region",excerptProjection = Region.class )
public interface RegionRepository extends JpaRepository<Region,Integer> {
}
