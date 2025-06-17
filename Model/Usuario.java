package Model;
import java.util.ArrayList;
import java.util.List;


public class Usuario{
    String nome;
    String sobrenome;
    String telefone;
    public static List<Evento> eventosParticipados = new ArrayList<Evento>();   

    public Usuario(String nome, String sobrenome, String telefone){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }
    public static void participarEvento(Evento evento){
        eventosParticipados.add(evento);
    };

    public static void adicionarEvento(Integer i){
        Usuario.participarEvento(ListaDeEventos.listaDeEventos.get(i));
        System.out.println("Evento adicionado com sucesso.");   
    };

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(eventosParticipados.size() > 0){
            for(int i = 0; i < eventosParticipados.size(); i++){
                sb.append(
                    "Nome: " + eventosParticipados.get(i).nome + '\n' +
                    "Endereço: " + eventosParticipados.get(i).endereco + '\n' +
                    "Descrição: " + eventosParticipados.get(i).descricao + '\n' +
                    "Data: " + eventosParticipados.get(i).horario + '\n'
                );
            };
        } else {
            System.out.println("Ainda não há eventos participados. Por favor, registre-se em um.");
        }
        return sb.toString();
    }
}