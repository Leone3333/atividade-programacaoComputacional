package eventosApp.com.Classes;

import java.io.BufferedWriter;
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

public class Evento implements Comparable<Evento> {

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
            "C:\\xampp\\htdocs\\unifacs\\progamacaoComputadores\\java\\sistema-eventos\\src\\eventosApp\\textos\\eventos\\eventos.txt");

    public Evento(String idEvento,  String nomeEvento, String categoria, String endereco, String horario, String descricao, String data) {
        
        this.idEvento = idEvento;
        this.nomeEvento = nomeEvento;
        this.endereco = endereco;
        this.horario = horario;
        this.descricao = descricao;
        this.data = data;

        switch (categoria) {
            case "TI":
                this.categoria = categoria;
                break;

            case "Engenharia":
                this.categoria = categoria;
                break;

            case "Finanças":
                this.categoria = categoria;
                break;

            case "Saúde":
                this.categoria = categoria;
                break;

            case "Pesquisa cientifica":
                this.categoria = categoria;
                break;

            case "Educação":
                this.categoria = categoria;
                break;

            default:
                System.out.println("SEM CATEGORIA");
                this.categoria = "Sem categoria";
                break;
        }
    }


    public String getIdEvento(){
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
  

    @Override
    public int compareTo(Evento outroEvento) {
        return LocalDate.parse(this.data).compareTo(LocalDate.parse(outroEvento.getData()));
    }

    public void creatEvento(Evento evento1) throws IOException {

        try (BufferedWriter inserir = Files.newBufferedWriter(caminho, StandardCharsets.UTF_8,
                StandardOpenOption.APPEND)) {
            String cabecalho = "[Data, Nome, Categoria, Endereço, Horário, Descrição]";

            if (Files.size(caminho) == 0) {
                inserir.write(cabecalho);
                inserir.newLine();
            }
            

            List<String> dadosUsuario = Arrays.stream(new Object[] {
                    evento1.getIdEvento(),
                    evento1.getNomeEvento(),
                    evento1.getCategoria(),
                    evento1.getEndereco(),
                    evento1.getHorario(),
                    evento1.getDescricao(),
                    evento1.getData(),
            })
                    .map(String::valueOf)
                    .collect(Collectors.toList());

            for (String linha : dadosUsuario) {
                inserir.write(linha);
                inserir.write(",");
            }
            dadosUsuario.sort(null);

            inserir.newLine();
            // long tamanho = Files.size(caminho);
            // System.out.println("Tamanho do arquivo "+ tamanho);

        } catch (Exception e) {
            System.out.println("Erro na criação do evento");
        }

    }

    public void lerEventos() throws IOException {
        try {
            List<String> eventos = Files.readAllLines(caminho);

            for (String evento : eventos) {
                System.out.println(evento);
            }

        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo");
        }
    }

    public void deletEvento(Integer idEvento) {
        try {
            List<String> eventos = Files.readAllLines(caminho);
            int indice = -1;

            for (int i = 0; i < eventos.size(); i++) {
                String[] partes = eventos.get(i).split(",");
                if (partes[0].equals(String.valueOf(idEvento))) {
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

    // NÃO CONSIGO FAZERrRRRRRRRRRrrRRrrrrrR
    public void lerEOrdenarEventos() throws IOException {
    }

    private static Evento converterLinhaEmEvento(String linha) {
        // Parse a linha e configure as propriedades do evento
        String[] dados = linha.split(";"); // Separador de campos
        
        if (linha.startsWith("[Data, Nome, Categoria, Endereço, Horário, Descrição]")) {
            return null;
        }
    
        String idEvento = dados[0];
        String nomeEvento = dados[1];
        String categoria = dados[2];
        String endereco = dados[3];
        String horario = dados[4];
        String descricao = dados[5];
        String data = dados[6];

        System.out.println("Arquivo convertido");
        return new Evento(idEvento, nomeEvento, categoria, endereco, horario, descricao, data);
    }

    public static void notificarEventos() throws IOException, ParseException {
      
            Date dataAtual = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            List<String> eventosStrings = Files.readAllLines(caminho);
            List<Evento> eventos = new ArrayList<>();
            

            for (String linha : eventosStrings) {
                System.out.println(eventosStrings);
                Evento evento = converterLinhaEmEvento(linha);
                eventos.add(evento);
            }

            for (Evento evento : eventos) {
                Date dataEvento = sdf.parse(evento.getData());
                if (dataEvento.equals(dataAtual)) {
                    System.out.println("Evento " + evento.getNomeEvento() + " é hoje!!");
                }else{
                    System.out.println("O evento " + evento.getNomeEvento() +  " não é hoje");
                }   
            }

        
    }

}