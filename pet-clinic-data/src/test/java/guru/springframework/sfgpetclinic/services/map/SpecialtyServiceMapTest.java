package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Specialty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SpecialtyServiceMapTest {

    SpecialtyServiceMap specialtyServiceMap;

    private final Long specialtyId = 1L;

    @BeforeEach
    void setUp() {
        specialtyServiceMap = new SpecialtyServiceMap();

        specialtyServiceMap.save(Specialty.builder().id(specialtyId).build());
    }

    @Test
    void findAll(){
        Set<Specialty> specialties = specialtyServiceMap.findAll();
        assertEquals(1, specialties.size());
    }

    @Test
    void findById(){
        Specialty specialty = specialtyServiceMap.findById(specialtyId);
        assertEquals(specialtyId, specialty.getId());
    }

    @Test
    void saveExistentId() {
        Long id = 2L;
        Specialty specialty2 = Specialty.builder().id(id).build();

        Specialty savedSpecialty = specialtyServiceMap.save(specialty2);

        assertEquals(id, savedSpecialty.getId());
    }

    @Test
    void saveNoId() {

        Specialty savedSpecialty = specialtyServiceMap.save(Specialty.builder().build());

        assertNotNull(specialtyServiceMap);
        assertNotNull(savedSpecialty.getId());
    }

    @Test
    void delete() {
        specialtyServiceMap.delete(specialtyServiceMap.findById(specialtyId));

        assertEquals(0, specialtyServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        specialtyServiceMap.deleteById(specialtyId);

        assertEquals(0, specialtyServiceMap.findAll().size());
    }
}