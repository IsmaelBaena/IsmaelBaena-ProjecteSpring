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
public class Criminal {
    @NotNull
    private int id;
    @NotNull
    @NotEmpty
    @Id
    private String nombre;
    @NotNull
    @NotEmpty
    private String apellido;
    @NotNull
    @NotEmpty
    private String crimen;








}
