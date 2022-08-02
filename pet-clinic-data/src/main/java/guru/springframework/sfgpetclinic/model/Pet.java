package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

public class Pet extends  BaseEntity{
    private PetTye petTye;
    private Owner owner;
    private LocalDate birthDate;

    public PetTye getPetTye() {
        return petTye;
    }

    public void setPetTye(PetTye petTye) {
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
}
