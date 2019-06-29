package uz.pdp.ecommersapp.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.ecommersapp.entity.Adress;
import uz.pdp.ecommersapp.entity.Detail;
import uz.pdp.ecommersapp.entity.DetailType;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

@Projection(name = "detail" ,types = {Detail.class})
public interface DetailProjection {
     Integer getId();
     String getName();
     String getValue();
    List<DetailType> getDetailTypes();
     boolean isIs_main();
}
