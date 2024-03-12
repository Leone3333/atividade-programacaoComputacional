package eventosApp.com.App;

import eventosApp.com.Classes.Evento;

public class App {
    
    public static void main(String[] args) throws Exception {

        /**
         * CATEGORIAS:
         *  TI / Engenharia / Finanças / Saúde / Pesquisa cientifica / Educação
         */
        
        Evento evento1 = new Evento("Evento de contas", "TI", "São paulo", "17:00", "um evento bem legal");
        Evento evento2 = new Evento("Evento de php", "TI", "São paulo", "17:00", "um evento bem legal");
        Evento evento3 = new Evento("Evento de ruby", "TI", "São paulo", "17:00", "um evento bem legal");
        Evento evento4 = new Evento("Evento de javaScript", "TI", "São paulo", "17:00", "um evento bem legal");

        try {
            evento1.creatEvento(evento1);
            System.out.println(evento1.getNomeEvento() + " criado com sucesso");
            
            evento2.creatEvento(evento2);
            System.out.println(evento2.getNomeEvento() + " criado com sucesso");
            
            evento3.creatEvento(evento3);
            System.out.println(evento3.getNomeEvento() + " criado com sucesso");

            evento4.creatEvento(evento4);
            System.out.println(evento4.getNomeEvento() + " criado com sucesso");
            
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Erro ao criar evento");
            }
        }

        public static void mensagemCadastro(){
            System.out.println("Bem vindo hora de criar seu cadastro!\n");
            System.out.println("Digite seu nome:\nCPF:\nsenha: ");
        }

        /**
         * IDEIA PARA RESOLVER A QUESTÃO DA CLASSE ABASTRATA E MÉTODOS VIRTUAIS, CRIAR UM ADMIN QUE PODE ACESSAR CONFIGURAÇÕES ESPECIFICAS
         * E UM USUARIO COMUN QUE SÓ PODE VER OUTRAS
         * 
         */

}
