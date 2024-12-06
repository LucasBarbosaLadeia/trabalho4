package projeto.techAcademy.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Eletronicos")
public class Eletronicos extends Categoria {



    @Column(name = "tipo_eletronicos")
    private String tipoEletronicos;


    public String getTipoEletronicos() {
        return tipoEletronicos;
    }

    public void setTipoEletronicos(String tipoEletronicos) {
        this.tipoEletronicos = tipoEletronicos;
    }
}
