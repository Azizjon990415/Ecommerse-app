package uz.pdp.ecommersapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.pdp.ecommersapp.entity.District;
import uz.pdp.ecommersapp.entity.Icon;

@RepositoryRestResource(path = "/api/icon",excerptProjection = Icon.class )
public interface IconRepository extends JpaRepository<Icon,Integer> {
}
