package uz.pdp.ecommersapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.pdp.ecommersapp.entity.Adress;
import uz.pdp.ecommersapp.entity.DetailType;

@RepositoryRestResource(path = "/api/detailtype",excerptProjection = DetailType.class )
public interface DeteilTypeRepository extends JpaRepository<DetailType,Integer> {
}
