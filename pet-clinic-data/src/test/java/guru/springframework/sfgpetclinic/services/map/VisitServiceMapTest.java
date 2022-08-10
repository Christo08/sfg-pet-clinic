package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.Visit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class VisitServiceMapTest {

    VisitServiceMap visitServiceMap;

    private final Long visitId = 1L;

    @BeforeEach
    void setUp() {
        visitServiceMap = new VisitServiceMap();

        Owner owner =Owner.builder().id(1l).lastName("aws").build();
        Pet pet = Pet.builder().id(1L).owner(owner).build();
        Visit visit = Visit.builder().id(1L).pet(pet).build();
        visitServiceMap.save(visit);
    }

    @Test
    void findAll(){
        Set<Visit> visits = visitServiceMap.findAll();
        assertEquals(1, visits.size());
    }

    @Test
    void findById(){
        Visit visit = visitServiceMap.findById(visitId);
        assertEquals(visitId, visit.getId());
    }

    @Test
    void saveExistentId() {
        Long id = 2L;

        Owner owner =Owner.builder().id(2l).lastName("aws").build();
        Pet pet = Pet.builder().id(2L).owner(owner).build();
        Visit visit2 = Visit.builder().id(id).pet(pet).build();

        Visit savedVisit = visitServiceMap.save(visit2);

        assertEquals(id, savedVisit.getId());
    }

    @Test
    void saveNoId() {
        Owner owner =Owner.builder().id(2l).lastName("aws").build();
        Pet pet = Pet.builder().id(2L).owner(owner).build();
        Visit visit = Visit.builder().pet(pet).build();

        Visit savedVisit = visitServiceMap.save(visit);

        assertNotNull(visitServiceMap);
        assertNotNull(savedVisit.getId());
    }

    @Test
    void delete() {
        visitServiceMap.delete(visitServiceMap.findById(visitId));

        assertEquals(0, visitServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        visitServiceMap.deleteById(visitId);

        assertEquals(0, visitServiceMap.findAll().size());
    }
}