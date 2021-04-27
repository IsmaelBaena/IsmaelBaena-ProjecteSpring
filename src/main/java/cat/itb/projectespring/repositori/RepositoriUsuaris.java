package cat.itb.projectespring.repositori;

import cat.itb.projectespring.model.Usuari;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoriUsuaris extends CrudRepository<Usuari, String> {}
