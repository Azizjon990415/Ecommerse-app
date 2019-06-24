package uz.pdp.ecommersapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.ecommersapp.entity.Detail;

@RepositoryRestResource(path = "/api/detail",excerptProjection = Detail.class )
public interface DetailRepository extends JpaRepository<Detail,Integer> {
}
