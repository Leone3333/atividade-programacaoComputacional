package eventosApp.com.Classes;

import java.util.Scanner;

public class Usuario 
{
    private String nome;
    private String cpf;
    private String senha;
    Scanner entrada = new Scanner(System.in);


    public Usuario(String nome, String cpf,  String senha)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }


    public String getNome() {
        
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }
}
