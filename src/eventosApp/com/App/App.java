package eventosApp.com.App  ;

import eventosApp.com.Classes.Usuario;

public class App {

    public static void main(String[] args) throws Exception {
        Usuario leone = new Usuario("leo", "leone123");
        

        if (leone.getSenha() == "leo" || leone.getSenha() == "leone123") {
            System.out.println("Hello, World!");
            
        }else{
            System.out.println("Teste realizado");
        }
    }
    public boolean a = true;
}
