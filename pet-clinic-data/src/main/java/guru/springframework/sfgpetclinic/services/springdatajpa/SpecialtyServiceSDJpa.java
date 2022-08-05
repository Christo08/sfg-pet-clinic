package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Specialty;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepositories;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("SDJpa")
public class SpecialtyServiceSDJpa implements SpecialtyService {

    private final SpecialtyRepositories specialtyRepositories;

    public SpecialtyServiceSDJpa(SpecialtyRepositories specialtyRepositories) {
        this.specialtyRepositories = specialtyRepositories;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepositories.findAll().forEach(specialty -> specialties.add(specialty));
        return specialties;
    }

    @Override
    public Specialty findById(Long id) {
        return specialtyRepositories.findById(id).orElse(null);
    }

    @Override
    public Specialty save(Specialty specialty) {
        return specialtyRepositories.save(specialty);
    }

    @Override
    public void delete(Specialty specialty) {
        specialtyRepositories.delete(specialty);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepositories.deleteById(id);
    }
}