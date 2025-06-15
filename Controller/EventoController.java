package Controller;

import Model.Evento;
import Model.ListaDeEventos;
import Model.Usuario;

public class EventoController {
    
    public static void criarEvento(String nomeEvento, String endereco, String categoria){
        Evento evento = new Evento(nomeEvento, endereco, categoria);
        ListaDeEventos.adicionarEventos(evento);
    }
    public static void adicionarEventoUsuario(Boolean repetirParticipar, String numEvento){
        try{
            int numeroEvento = Integer.parseInt(numEvento);
            //Loops inside ListaDeEventos
            for(Integer i = 0; i < ListaDeEventos.listaDeEventos.size(); i++){
                //Checks if Usuario is participating in any event and if the User's choice is less than ListaDeEventos size 
                if(numeroEvento <= ListaDeEventos.listaDeEventos.size()){
                    if(numeroEvento == ListaDeEventos.listaDeEventos.get(i).numeroEvento){      
                        if(Usuario.eventosParticipados.size() > 0) {    
                            //Checks inside Usuario.eventos if the number chosen by user doesn't exist
                            //If doesn't exist, it adds event to user
                            //If exists, repeated event message is displayed
                            if(Usuario.eventosParticipados.stream().noneMatch(e -> 
                                e.numeroEvento == numeroEvento)){
                                    Usuario.adicionarEvento(i);                                   
                                    repetirParticipar = false;
                                    break;
                            } else {
                                System.out.println("Evento repetido. Insira um número válido. 1");
                                break;
                            }
                        } else {
                            Usuario.adicionarEvento(i);                                                                       
                            repetirParticipar = false;
                            break;
                        }
                    } 
                }   else {
                    System.out.println(ListaDeEventos.listaDeEventos.get(i).numeroEvento);
                    System.out.println("Evento não existente. Insira um número válido. 2");
                    break;
                }
            } 
        } catch (NumberFormatException e) {
            System.out.println("Insira um número válido.");
        }
    }
}
