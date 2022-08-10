package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Specialty;
import guru.springframework.sfgpetclinic.model.Vet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class VetServiceMapTest {

    VetServiceMap vetServiceMap;

    private final Long vetId = 1L;

    @BeforeEach
    void setUp() {
        vetServiceMap = new VetServiceMap(new SpecialtyServiceMap());

        Vet vet =Vet.builder().id(vetId).build();
        vet.getSpecialties().add(Specialty.builder().id(1L).description("cat").build());
        vetServiceMap.save(vet);
    }

    @Test
    void findAll(){
        Set<Vet> vets = vetServiceMap.findAll();
        assertEquals(1, vets.size());
    }

    @Test
    void findById(){
        Vet vet = vetServiceMap.findById(vetId);
        assertEquals(vetId, vet.getId());
    }

    @Test
    void saveExistentId() {
        Long id = 2L;
        Vet vet2 = Vet.builder().id(id).build();

        Vet savedVet = vetServiceMap.save(vet2);

        assertEquals(id, savedVet.getId());
    }

    @Test
    void saveNoId() {

        Vet savedVet = vetServiceMap.save(Vet.builder().build());

        assertNotNull(vetServiceMap);
        assertNotNull(savedVet.getId());
    }

    @Test
    void delete() {
        vetServiceMap.delete(vetServiceMap.findById(vetId));

        assertEquals(0, vetServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        vetServiceMap.deleteById(vetId);

        assertEquals(0, vetServiceMap.findAll().size());
    }
}