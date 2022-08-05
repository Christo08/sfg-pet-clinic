package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.VetRepositories;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("SDJpa")
public class VetServiceSDJpa implements VetService {

    private final VetRepositories vetRepositories;

    public VetServiceSDJpa(VetRepositories vetRepositories) {
        this.vetRepositories = vetRepositories;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepositories.findAll().forEach(vet -> vets.add(vet));
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepositories.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepositories.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        vetRepositories.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        vetRepositories.deleteById(id);
    }
}
