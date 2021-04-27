package cat.itb.projectespring.servei;

import cat.itb.projectespring.model.Usuari;
import cat.itb.projectespring.repositori.RepositoriUsuaris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private RepositoriUsuaris repo;

    public void add(Usuari e) {
            e.setPassword(passwordEncoder(e.getPassword()));
            repo.save(e);
        }

        public List<Usuari> list() {
            List<Usuari> l = new ArrayList<>();
            repo.findAll().forEach(l::add);
            return l;
        }

        @PostConstruct
        public void init() {
            repo.save(new Usuari("Ismael", passwordEncoder("pass"), "pass"));
            repo.save(new Usuari("Mauricio", passwordEncoder("pass"), "pass"));
            repo.save(new Usuari("ADMIN", passwordEncoder("pass"), "pass","ADMIN"));
        }

        public Usuari getById(String s) {
            return  repo.findById(s).orElse(null);
        }

    public String passwordEncoder(String s) {
        return new BCryptPasswordEncoder().encode(s);
    }
}
