package eventosApp.com.Classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.nio.file.Path;

public class Evento {

    /**
     * implementar método de ver eventos -- COMPLETO
     * implementar método de deleter eventos -- COMPLETO
     * implmentar método de ordenar eventos por horario
     * implementar método de notificar eventos
     */

    private String idEvento;
    private String nomeEvento;
    private String categoria;
    private String endereco;
    private String horario;
    private String descricao;
    private String data;
    /**
     * MUDE AQUI O CAMINHO, COLOQUE O CAMINHO QUE ESTA O SEU ARQUIVO TXT DESDE A
     * RAIZ
     * OBS: o nome do arquivo já é eventos.txt você deve escrever o arquivo e a
     * extensão txt
     */
    private static Path caminho = Paths.get(
            "C:\\laragon\\www\\unifacs\\progamacaoComputadores\\java\\sistema-eventos\\src\\eventosApp\\textos\\eventos\\eventos.txt");

    public Evento(String idEvento, String nomeEvento, String categoria, String endereco, String horario,
            String descricao, String data) {

        this.idEvento = idEvento;
        this.nomeEvento = nomeEvento;
        this.endereco = endereco;
        this.horario = horario;
        this.descricao = descricao;
        this.data = data;

        switch (categoria) {
            case "TI":
            case "Engenharia":
            case "Finanças":
            case "Saúde":
            case "Pesquisa cientifica":
            case "Educação":
                this.categoria = categoria;
                break;

            default:
                this.categoria = "Sem categoria";
                break;

        }
        try {
            // Chama o método creatEvento passando o próprio objeto evento
            creatEvento(this);
        } catch (IOException e) {
            System.out.println("Erro na criação do evento");
        }

    }

    public String getIdEvento() {
        return idEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getHorario() {
        return horario;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData() {
        return data;
    }

    public static void creatEvento(Evento evento) throws IOException {

        try (BufferedWriter inserir = Files.newBufferedWriter(caminho, StandardCharsets.UTF_8,
                StandardOpenOption.APPEND)) {
            String cabecalho = "[Data, Nome, Categoria, Endereço, Horário, Descrição]";

            if (Files.size(caminho) == 0) {
                inserir.write(cabecalho);
                inserir.newLine();
            }

            List<String> dadosUsuario = Arrays.stream(new Object[] {
                    evento.getIdEvento(),
                    evento.getNomeEvento(),
                    evento.getCategoria(),
                    evento.getEndereco(),
                    evento.getHorario(),
                    evento.getDescricao(),
                    evento.getData(),
            })
                    .map(String::valueOf)
                    .collect(Collectors.toList());

            for (String linha : dadosUsuario) {
                inserir.write(linha);
                inserir.write(", ");
            }

            System.out.println("Evento criado com sucesso!");
            inserir.newLine();
            // long tamanho = Files.size(caminho);
            // System.out.println("Tamanho do arquivo "+ tamanho);

        } catch (Exception e) {
            System.out.println("Erro na criação do evento");
        }

    }

    public static void lerTodosEventos() throws IOException {
        try {
            List<String> eventos = Files.readAllLines(caminho);

            for (String evento : eventos) {
                System.out.println(evento);
            }

        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo");
        }
    }

    public static void deletEvento(String idEvento) {
        try {
            List<String> eventos = Files.readAllLines(caminho);
            int indice = -1;

            for (int i = 1; i < eventos.size(); i++) {
                String[] partes = eventos.get(i).split(",");
                if (partes[0].equals(idEvento)) {
                    indice = i;
                    break;
                }
            }

            if (indice != -1) {
                eventos.remove(indice);
                try (BufferedWriter escritor = Files.newBufferedWriter(caminho)) {
                    for (String evento : eventos) {
                        escritor.write(evento + System.lineSeparator());
                    }
                }
                System.out.println("Evento " + idEvento + " deletado com sucesso!");
            } else {
                System.out.println("Evento " + idEvento + " não encontrado!");
            }

        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo");
        }

    }

    public static void updateEvento(String idEvento, String nomeEvento, String categoria, String endereco,
            String horario,
            String descricao, String data) {
        try {
            List<String> eventos = Files.readAllLines(caminho);
            String eventoUpdate = "";
            int indice = -1;
            for (int i = 0; i < eventos.size(); i++) {
                String[] partes = eventos.get(i).split(",");
                if (partes[0].equals(idEvento)) {
                    indice = i;
                    break;
                }
            }

            if (indice != -1) {
                eventos.set(indice, idEvento + ", " + nomeEvento + ", " + categoria + ", " + endereco + ", " + horario + ", " + descricao + ", " + data);
                try (BufferedWriter escritor = Files.newBufferedWriter(caminho)) {
                    for (String evento : eventos) {
                        escritor.write(evento + System.lineSeparator());
                    }
                }
                System.out.println("Evento " + idEvento + " deletado com sucesso!");
            } else {
                System.out.println("Evento " + idEvento + " não encontrado!");
            }

        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo");
        }
    }

    public static void limparArquivo() {
        try (BufferedWriter limpar = Files.newBufferedWriter(caminho)) {
            limpar.write("");
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo");
        }
        System.out.println("Arquivo limpo com sucesso");

    }

}