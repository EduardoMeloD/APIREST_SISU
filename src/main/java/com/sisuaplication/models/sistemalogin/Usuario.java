package com.sisuaplication.models.sistemalogin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = Usuario.TABLE_NAME)
public class Usuario {
    
    public static final String TABLE_NAME = "usuario";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", unique = true)

    private Long id;
    
    @Column(name = "login", length = 80, nullable = false, unique = true)
    @NotNull(groups = UsuariosCadastro.class)
    @NotEmpty(groups = UsuariosCadastro.class)
    private String login;

    @Column(name = "senha", length = 80, nullable = false)
    @NotNull(groups = UsuariosCadastro.class)
    @NotEmpty(groups = UsuariosCadastro.class)
    private String senha;

    @Column(name = "nome", length = 100, nullable = false)
    @NotNull(groups = UsuariosCadastro.class)
    @NotEmpty(groups = UsuariosCadastro.class)
    private String nome;

    @Column(name = "idade", length = 3, nullable = false)
    @NotNull(groups = UsuariosCadastro.class)
    @NotEmpty(groups = UsuariosCadastro.class)
    private String idade;

    @Column(name = "telefone", length = 20, nullable = false, unique = false)
    @NotNull(groups = UsuariosCadastro.class)
    @NotEmpty(groups = UsuariosCadastro.class)
    private String telefone;

    @Column(name = "endereco", length = 100, nullable = false)
    @NotNull(groups = UsuariosCadastro.class)
    @NotEmpty(groups = UsuariosCadastro.class)
    private String endereco;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    @NotNull(groups = UsuariosCadastro.class)
    @NotEmpty(groups = UsuariosCadastro.class)
    private String email;

    @Column(name = "genero", length = 1, nullable = false)
    @NotNull(groups = UsuariosCadastro.class)
    @NotEmpty(groups = UsuariosCadastro.class)
    private String genero;
     
    @Column(name = "cpf", length = 15, nullable = false, unique = true)
    @NotNull(groups = UsuariosCadastro.class)
    @NotEmpty(groups = UsuariosCadastro.class)
    private String cpf;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;

    }

    public Usuario() {}

    public void informacoesDoUsuario() {
        System.out.println("Informações do Usuário");
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getIdade() { return idade; }
    public void setIdade(String idade) { this.idade = idade; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    /*@Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(!(obj instanceof Usuario)){
            return false;
        }
        Usuario other = (Usuario) obj;
        if(this.id == null){
            if(other.id != null){
                return false;
            }
            else if(!this.id.equals(other.id)){
                return false;
            }
        }
        
        return Objects.equals(this.id, other.id) && Objects.equals(this.senha, other.senha);
        
    }*/
    
    @Override

    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result+((this.id == null)? 0 : this.id.hashCode());
        return result;
    }

}
