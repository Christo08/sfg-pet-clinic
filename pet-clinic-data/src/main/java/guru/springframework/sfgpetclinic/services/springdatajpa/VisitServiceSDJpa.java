package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepositories;
import guru.springframework.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("SDJpa")
public class VisitServiceSDJpa implements VisitService {

    private final VisitRepositories visitRepositories;

    public VisitServiceSDJpa(VisitRepositories visitRepositories) {
        this.visitRepositories = visitRepositories;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepositories.findAll().forEach(visit -> visits.add(visit));
        return visits;
    }

    @Override
    public Visit findById(Long id) {
        return visitRepositories.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepositories.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        visitRepositories.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        visitRepositories.deleteById(id);
    }
}
