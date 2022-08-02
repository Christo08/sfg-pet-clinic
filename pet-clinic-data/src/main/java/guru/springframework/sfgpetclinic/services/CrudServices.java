package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;

import java.util.Set;

public interface CrudServices<T, ID> {
    public Set<T> findAll();

    public T findById(ID id);

    public T save(T object);

    public void delete(T object);

    public void deleteById(ID id);
}
