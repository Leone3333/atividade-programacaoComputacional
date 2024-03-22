package eventosApp.com.Tests;

import eventosApp.com.Classes.Evento;

public class Testes {
    
    public static void main(String[] args) throws Exception{
         /**
         * CATEGORIAS:
         * TI / Engenharia / Finanças / Saúde / Pesquisa cientifica / Educação
         */

         Evento evento1 = new Evento("0", "Evento de contas", "Financas", "Porto Alegre", "17:00", "um evento bem legal", "10/03/2021");
         Evento evento2 = new Evento("1", "Evento de php", "TI", "São paulo", "17:00", "um evento bem legal", "12/04/2026");
         Evento evento3 = new Evento("2", "Evento cálculo", "Engenharia", "Porto Alegre", "17:00", "um evento bem legal", "02/07/2023");
         Evento evento4 = new Evento("3", "Evento de anime", "anime", "Porto Alegre", "17:00", "um evento bem legal", "23/08/2024");
 
         // Deletar evento com id
         // evento1.deletEvento(0);
 
         // Ler eventos disponiveis
        //  evento1.lerEventos();
        
        try {
            evento1.creatEvento(evento1);
            // System.out.println(evento1.getNomeEvento() + " criado com sucesso");
            
            evento2.creatEvento(evento2);
            // System.out.println(evento2.getNomeEvento() + " criado com sucesso");
            
            evento3.creatEvento(evento3);
            // System.out.println(evento3.getNomeEvento() + " criado com sucesso");
            
            evento4.creatEvento(evento4);
            // System.out.println(evento4.getNomeEvento() + " criado com sucesso");
            
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Erro ao criar evento");
         }
         Evento.notificarEventos();
        }
        
        /**
         * IDEIA PARA RESOLVER A QUESTÃO DA CLASSE ABASTRATA E MÉTODOS VIRTUAIS, CRIAR
      * UM ADMIN QUE PODE ACESSAR CONFIGURAÇÕES ESPECIFICAS
      * E UM USUARIO COMUN QUE SÓ PODE VER OUTRAS
      * 
      */

    }

