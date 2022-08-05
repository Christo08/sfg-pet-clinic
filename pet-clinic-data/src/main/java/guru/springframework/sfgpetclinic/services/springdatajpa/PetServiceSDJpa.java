package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.repositories.PetRepositories;
import guru.springframework.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("SDJpa")
public class PetServiceSDJpa implements PetService {

    private final PetRepositories petRepositories;

    public PetServiceSDJpa(PetRepositories petRepositories) {
        this.petRepositories = petRepositories;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepositories.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long id) {
        return petRepositories.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet petType) {
        return petRepositories.save(petType);
    }

    @Override
    public void delete(Pet petType) {
        petRepositories.delete(petType);
    }

    @Override
    public void deleteById(Long id) {
        petRepositories.deleteById(id);
    }
}
