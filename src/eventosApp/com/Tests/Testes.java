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
 
         
         //  Ler eventos disponiveis
         limparConsole();
         Evento.lerTodosEventos();
         
         //  Deletar evento com id
          Evento.deletEvento("0");
          Evento.deletEvento("1");
          System.out.println("\n");
          Evento.lerTodosEventos();
          Evento.limparArquivo();
        }


        
        public static void limparConsole() {
            // Sequência ANSI para limpar o console
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

