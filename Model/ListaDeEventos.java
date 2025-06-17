package Model;
import java.util.ArrayList;
import java.util.List;

public class ListaDeEventos {
    public static List<Evento> listaDeEventos = new ArrayList<Evento>();
    //String numeroEvento;


    public static void adicionarEventos(Evento evento){
        evento.numeroEvento = listaDeEventos.size() + 1;
        listaDeEventos.add(evento);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(listaDeEventos.size() > 0){
            for(int i = 0; i < listaDeEventos.size(); i++){
                sb.append(
                    '\n' + "Número do Evento: " + listaDeEventos.get(i).numeroEvento + '\n' +
                    "Nome: " + listaDeEventos.get(i).nome + '\n' +
                    "Endereço: " + listaDeEventos.get(i).endereco + '\n' + 
                    "Descrição: " + listaDeEventos.get(i).descricao + '\n' +
                    "Data: " + listaDeEventos.get(i).horario + '\n'
                );
            };
        } else {
            System.out.println("Ainda não há eventos registrados. Por favor, adicione um evento.");
        }
        return sb.toString();
    }


/*
    public static List<Evento> getListaDeEventos() {
        return listaDeEventos;
    }
 */
}
