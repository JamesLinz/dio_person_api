package Repository;

import com.project.dio_personalapi.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	Person save(Person person);
}
