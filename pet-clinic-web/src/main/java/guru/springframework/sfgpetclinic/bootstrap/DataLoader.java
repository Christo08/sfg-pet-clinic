package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count ==0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType =petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType =petTypeService.save(cat);

        Owner owner1 = new Owner();
        Pet owner1Pets1 = new Pet();
        owner1Pets1.setPetType(savedDogPetType);
        owner1Pets1.setOwner(owner1);
        owner1Pets1.setBirthDate(LocalDate.now());
        owner1Pets1.setName("G-Dog");

        Pet owner1Pets2 = new Pet();
        owner1Pets2.setPetType(savedDogPetType);
        owner1Pets2.setOwner(owner1);
        owner1Pets2.setBirthDate(LocalDate.now());
        owner1Pets1.setName("H-Dog");

        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1231231234");
        owner1.getPets().add(owner1Pets1);
        owner1.getPets().add(owner1Pets2);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        Pet owner2Pets = new Pet();
        owner2Pets.setPetType(savedCatPetType);
        owner2Pets.setOwner(owner2);
        owner2Pets.setBirthDate(LocalDate.now());
        owner2Pets.setName("A-Cat");

        owner2.setFirstName("Fiona");
        owner2.setLastName("Glename");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("1231231234");
        owner2.getPets().add(owner2Pets);

        ownerService.save(owner2);

        Visit visit = new Visit();
        visit.setPet(owner2Pets);
        visit.setDate(LocalDate.now());
        visit.setDescription("Sleepy kitty");

        visitService.save(visit);

        System.out.println("Loaded Owners...");

        Specialty radiology = new Specialty();
        radiology.setDescription("radiology");
        Specialty savedRadiology =specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        Specialty savedSurgery =specialtyService.save(radiology);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");
        Specialty savedDentistry =specialtyService.save(radiology);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("John");
        vet2.setLastName("Dear");
        vet1.getSpecialties().add(savedSurgery);
        vet1.getSpecialties().add(savedDentistry);

        vetService.save(vet2);
        System.out.println("Loaded Vets...");
    }
}