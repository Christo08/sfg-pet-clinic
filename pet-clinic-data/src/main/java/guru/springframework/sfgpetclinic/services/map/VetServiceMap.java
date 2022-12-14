package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Specialty;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default","map"})
public class VetServiceMap extends AbstractMapService<Vet,Long>
        implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialties().size() > 0){
            object.getSpecialties().forEach(specialty -> {
                if (specialty.getId() == null) {
                    Specialty saveSpecialty = specialtyService.save(specialty);
                    specialty.setId(saveSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }

}
