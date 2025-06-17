package Model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public class Evento{
    public int numeroEvento;
    String nome;
    String endereco;
    String categoria;
    String horario;
    String descricao;
    List<Usuario> usuarios;
    public Evento(String nome, String endereco, String categoria, String horario, String descricao){
        this.nome = nome;
        this.endereco = endereco;
        this.categoria = categoria;
        this.horario = horario;
        this.descricao = descricao;
    } 
    public Evento(){

    }
}