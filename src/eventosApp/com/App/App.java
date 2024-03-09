package eventosApp.com.App  ;
import java.util.Scanner;

import eventosApp.com.Classes.Evento;
import eventosApp.com.Classes.Usuario;

public class App {
    
    public static void main(String[] args) throws Exception {
        
        Evento evento1 = new Evento("Evento de python", "TI", "São paulo", "16:00", "um evento bem legal");

        try {
            evento1.creatEvento(evento1);
            System.out.println(evento1.getNomeEvento() + " criado com sucesso");
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Erro ao criar evento");
            }
        }

        public static void mensagemCadastro(){
            System.out.println("Bem vindo hora de criar seu cadastro!\n");
            System.out.println("Digite seu nome:\nCPF:\nsenha: ");
        }

}
