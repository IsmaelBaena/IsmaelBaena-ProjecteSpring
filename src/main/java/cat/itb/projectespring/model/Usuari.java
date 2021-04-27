package cat.itb.projectespring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuari {
    @NotNull
    @NotEmpty
    @Id
    private String username;
    @NotNull
    @NotEmpty
    private String password;
    @NotNull
    @NotEmpty
    private String matchingPassword;
    @NotNull
    @NotEmpty
    private String rol;

    public Usuari(String name, String password, String matchingPassword) {
        this.username = name;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.rol = "USER";
    }


}
