package dev.knowhowto.jh.petclinic.minapifirst.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Owners.
 */
@Entity
@Table(name = "owners")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Owners implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 32)
    @Column(name = "firstname", length = 32, nullable = false)
    private String firstname;

    @NotNull
    @Size(max = 32)
    @Column(name = "lastname", length = 32, nullable = false)
    private String lastname;

    @NotNull
    @Size(max = 255)
    @Column(name = "address", length = 255, nullable = false)
    private String address;

    @Size(max = 32)
    @Column(name = "city", length = 32)
    private String city;

    @NotNull
    @Size(max = 20)
    @Column(name = "telephone", length = 20, nullable = false)
    private String telephone;

    @OneToMany(mappedBy = "owner")
    @JsonIgnoreProperties(value = { "visits", "type", "owner" }, allowSetters = true)
    private Set<Pets> pets = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Owners id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public Owners firstname(String firstname) {
        this.setFirstname(firstname);
        return this;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public Owners lastname(String lastname) {
        this.setLastname(lastname);
        return this;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return this.address;
    }

    public Owners address(String address) {
        this.setAddress(address);
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public Owners city(String city) {
        this.setCity(city);
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public Owners telephone(String telephone) {
        this.setTelephone(telephone);
        return this;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Pets> getPets() {
        return this.pets;
    }

    public void setPets(Set<Pets> pets) {
        if (this.pets != null) {
            this.pets.forEach(i -> i.setOwner(null));
        }
        if (pets != null) {
            pets.forEach(i -> i.setOwner(this));
        }
        this.pets = pets;
    }

    public Owners pets(Set<Pets> pets) {
        this.setPets(pets);
        return this;
    }

    public Owners addPets(Pets pets) {
        this.pets.add(pets);
        pets.setOwner(this);
        return this;
    }

    public Owners removePets(Pets pets) {
        this.pets.remove(pets);
        pets.setOwner(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Owners)) {
            return false;
        }
        return id != null && id.equals(((Owners) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Owners{" +
            "id=" + getId() +
            ", firstname='" + getFirstname() + "'" +
            ", lastname='" + getLastname() + "'" +
            ", address='" + getAddress() + "'" +
            ", city='" + getCity() + "'" +
            ", telephone='" + getTelephone() + "'" +
            "}";
    }
}
