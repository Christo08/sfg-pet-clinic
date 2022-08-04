package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

public class Pet extends  BaseEntity{
    private PetType petTye;
    private Owner owner;
    private LocalDate birthDate;
    private String name;

    public PetType getPetTye() {
        return petTye;
    }

    public void setPetTye(PetType petTye) {
        this.petTye = petTye;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
