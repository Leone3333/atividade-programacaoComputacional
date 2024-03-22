package eventosApp.com.Classes;

import java.util.List;

public abstract class Usuarios {
    private String nome;
    private String cpf;
    private String senha;

    public Usuarios(String nome, String cpf, String senha){
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public abstract void verEventos();  
    public abstract void participarEvento();
    public abstract void cancelarParticipacao();
    public abstract void login(); //método virtual
    public abstract List<String> permissoesUsuario(); //método virtual

}
