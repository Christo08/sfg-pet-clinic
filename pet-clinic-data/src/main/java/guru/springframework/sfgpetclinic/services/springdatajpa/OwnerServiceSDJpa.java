package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepositories;
import guru.springframework.sfgpetclinic.repositories.PetRepositories;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepositories;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
@Profile("SDJpa")
public class OwnerServiceSDJpa implements OwnerService {
    private final OwnerRepositories ownerRepositories;
    private final PetRepositories petRepositories;
    private final PetTypeRepositories petTypeRepositories;

    public OwnerServiceSDJpa(OwnerRepositories ownerRepositories, PetRepositories petRepositories,
                             PetTypeRepositories petTypeRepositories) {
        this.ownerRepositories = ownerRepositories;
        this.petRepositories = petRepositories;
        this.petTypeRepositories = petTypeRepositories;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();

        ownerRepositories.findAll().forEach(owner -> owners.add(owner));

        return owners;
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepositories.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepositories.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepositories.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepositories.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepositories.findByLastName(lastName);
    }
}
