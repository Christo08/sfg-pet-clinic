package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.PetType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PetTypeServiceMapTest {

    PetTypeServiceMap petTypeServiceMap;

    private final Long petTypeId = 1L;

    @BeforeEach
    void setUp() {
        petTypeServiceMap = new PetTypeServiceMap();

        petTypeServiceMap.save(PetType.builder().id(petTypeId).build());
    }

    @Test
    void findAll(){
        Set<PetType> petTypes = petTypeServiceMap.findAll();
        assertEquals(1, petTypes.size());
    }

    @Test
    void findById(){
        PetType petType = petTypeServiceMap.findById(petTypeId);
        assertEquals(petTypeId, petType.getId());
    }

    @Test
    void saveExistentId() {
        Long id = 2L;
        PetType petType2 = PetType.builder().id(id).build();

        PetType savedPetType = petTypeServiceMap.save(petType2);

        assertEquals(id, savedPetType.getId());
    }

    @Test
    void saveNoId() {

        PetType savedPetType = petTypeServiceMap.save(PetType.builder().build());

        assertNotNull(petTypeServiceMap);
        assertNotNull(savedPetType.getId());
    }

    @Test
    void delete() {
        petTypeServiceMap.delete(petTypeServiceMap.findById(petTypeId));

        assertEquals(0, petTypeServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        petTypeServiceMap.deleteById(petTypeId);

        assertEquals(0, petTypeServiceMap.findAll().size());
    }
}