package cat.itb.projectespring.repositori;

import cat.itb.projectespring.model.Criminal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoriCriminal extends CrudRepository<Criminal, String> {
}
