package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetTypeService;

public class PetTypeServiceMap extends AbstractMapService<PetType,Long> implements PetTypeService {
    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }
}
