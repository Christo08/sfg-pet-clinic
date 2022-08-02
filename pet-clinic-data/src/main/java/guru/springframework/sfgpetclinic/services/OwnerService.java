package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;

import java.util.Set;


public interface OwnerService {

    public Owner findByLastName(String lastName);

    public Owner findById(Long id);

    public Set<Owner> findAll();

    public Owner save(Owner owner);
}
