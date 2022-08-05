package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepositories;
import guru.springframework.sfgpetclinic.repositories.PetRepositories;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepositories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerServiceSDJpaTest {
    public static final String smith = "Smith";
    public static final long id = 1L;
    @Mock
    OwnerRepositories ownerRepositories;
    @Mock
    PetRepositories petRepositories;
    @Mock
    PetTypeRepositories petTypeRepositories;
    @InjectMocks
    OwnerServiceSDJpa ownerServiceSDJpa;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(id).lastName(smith).build();
    }

    @Test
    void findAll() {
        Set<Owner> returnOwners = new HashSet<>();
        returnOwners.add(Owner.builder().id(2L).build());
        returnOwners.add(Owner.builder().id(3L).build());

        when(ownerRepositories.findAll()).thenReturn(returnOwners);

        Set<Owner> owners = ownerServiceSDJpa.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepositories.findById(any())).thenReturn(Optional.of(returnOwner));

        Owner owner = ownerServiceSDJpa.findById(id);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFond() {
        when(ownerRepositories.findById(any())).thenReturn(Optional.empty());

        Owner owner = ownerServiceSDJpa.findById(3L);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(id).lastName(smith).build();

        when(ownerRepositories.save(any())).thenReturn(returnOwner);

        Owner savedOwner = ownerServiceSDJpa.save(ownerToSave);

        assertNotNull(savedOwner);
        verify(ownerRepositories).save(any());
    }

    @Test
    void delete() {
        ownerServiceSDJpa.delete(returnOwner);

        verify(ownerRepositories, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerServiceSDJpa.deleteById(id);

        verify(ownerRepositories, times(1)).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        when(ownerRepositories.findByLastName(any())).thenReturn(returnOwner);

        Owner smith = ownerServiceSDJpa.findByLastName(OwnerServiceSDJpaTest.smith);

        assertEquals(OwnerServiceSDJpaTest.smith, smith.getLastName());
        verify(ownerRepositories).findByLastName(any());
    }
}