package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepositories;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("SDJpa")
public class PetTypeServiceSDJpa implements PetTypeService {

    private final PetTypeRepositories petTypeRepositories;

    public PetTypeServiceSDJpa(PetTypeRepositories petTypeRepositories) {
        this.petTypeRepositories = petTypeRepositories;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();

        petTypeRepositories.findAll().forEach(petTypes::add);

        return petTypes;
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepositories.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeRepositories.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        petTypeRepositories.delete(petType);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepositories.deleteById(id);
    }
}
