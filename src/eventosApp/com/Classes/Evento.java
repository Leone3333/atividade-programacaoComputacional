    package eventosApp.com.Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.nio.file.Path;

public class Evento {

        private String nomeEvento;
        private String categoria;
        private String endereco;
        private String horario;
        private String descricao;
       
        public Evento(String nomeEvento, String categoria, String endereco, String horario, String descricao)
        {
            this.nomeEvento = nomeEvento;
            this.categoria = categoria;
            this.endereco = endereco;
            this.horario = horario;
            this.descricao = descricao;
        }

        public String getNomeEvento(){
            return nomeEvento;
        }

        public String getCategoria(){
            return categoria;
        }

        public String getEndereco(){
            return endereco;
        }

        public String getHorario(){
            return horario;
        }

        public String getDescricao(){
            return descricao;
        }

        public void creatEvento(Evento evento1) throws IOException{
            
            Path caminho =  Paths.get("C:\\xampp\\htdocs\\unifacs\\progamacaoComputadores\\java\\sistema-eventos\\src\\eventosApp\\textos\\eventos\\eventos.txt");

            try (BufferedWriter inserir = Files.newBufferedWriter(caminho, StandardCharsets.UTF_8, StandardOpenOption.APPEND))
            {
                String cabecalho = "[Nome,Categoria,Endereço,Horário,Descrição]";

                if (Files.size(caminho) == 0) {
                    inserir.write(cabecalho);
                    inserir.newLine();
                }

                List<String> dadosUsuario = Arrays.asList(
                    evento1.getNomeEvento(),
                    evento1.getCategoria(),
                    evento1.getEndereco(),
                    evento1.getHorario(),
                    evento1.getDescricao()
                );
                

                for (String linha : dadosUsuario) {
                    inserir.write(linha);
                    inserir.write(",");
                }
                inserir.newLine();
                // long tamanho = Files.size(caminho);
                // System.out.println("Tamanho do arquivo "+ tamanho);

            } catch (Exception e) {
                System.out.println("Erro na criação do usuario");
            }
        }
    }
