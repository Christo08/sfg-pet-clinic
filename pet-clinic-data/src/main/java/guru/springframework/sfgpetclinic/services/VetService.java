package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    public Vet findByLastName(String lastName);

    public Vet findById(Long id);

    public Set<Vet> findAll();

    public Vet save(Vet vet);
}
