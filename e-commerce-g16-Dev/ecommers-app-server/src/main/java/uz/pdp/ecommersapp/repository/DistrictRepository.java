package uz.pdp.ecommersapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.pdp.ecommersapp.entity.Adress;
import uz.pdp.ecommersapp.entity.District;

@RepositoryRestResource(path = "/api/district",excerptProjection = District.class )
public interface DistrictRepository  extends JpaRepository<District,Integer> {
}
