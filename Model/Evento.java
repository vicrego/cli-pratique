package Model;
import java.time.LocalDateTime;
import java.util.List;


public class Evento{
    public int numeroEvento;
    String nome;
    String endereco;
    String categoria;
    LocalDateTime horario;
    String descricao;
    List<Usuario> usuarios;
    public Evento(String nome, String endereco, String categoria ){
        this.nome = nome;
        this.endereco = endereco;
        this.categoria = categoria;
    } 
    public Evento(){

    }
}