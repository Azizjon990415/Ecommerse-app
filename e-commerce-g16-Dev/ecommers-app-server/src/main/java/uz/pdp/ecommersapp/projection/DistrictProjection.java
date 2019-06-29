package uz.pdp.ecommersapp.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.ecommersapp.entity.District;
import uz.pdp.ecommersapp.entity.Region;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Projection(name = "district" ,types = {District.class})
public interface DistrictProjection {
     Integer getId();
     String getName();
}
