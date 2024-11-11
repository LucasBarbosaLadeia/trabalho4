package projeto.techAcademy.model;

import jakarta.persistence.*;

@Entity
@Table
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_usuario")
    private Integer idUsuario;

   @Column
    private String nome;

    @Column
    private String senha;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
