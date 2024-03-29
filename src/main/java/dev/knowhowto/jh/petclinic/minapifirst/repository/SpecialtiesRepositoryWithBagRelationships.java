package dev.knowhowto.jh.petclinic.minapifirst.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import dev.knowhowto.jh.petclinic.minapifirst.domain.Specialties;

public interface SpecialtiesRepositoryWithBagRelationships {
    Optional<Specialties> fetchBagRelationships(Optional<Specialties> specialties);

    List<Specialties> fetchBagRelationships(List<Specialties> specialties);

    Page<Specialties> fetchBagRelationships(Page<Specialties> specialties);
}
