package Repository;

import java.util.List;
import java.util.Optional;

import com.project.dio_personalapi.entities.Person;

import dto.PersonDTO;

public interface PersonRepository extends JpaRepository<Person, Long> {

	Person save(Person personToSave);

	List<Person> findAll();

	Optional<Person> findById(Long id);

	void deleteById(Long id);
}
