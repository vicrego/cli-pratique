package Controller;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;

import Model.Evento;
import Model.ListaDeEventos;
import Model.Usuario;

public class EventoController {
    
    public static void criarEvento(String nomeEvento, String endereco, String categoria, String descricao, String horario){
        Evento evento = new Evento(nomeEvento, endereco, categoria, horario, descricao);
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
                                System.out.println("Evento repetido. Insira um número válido.");
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
                    System.out.println("Evento não existente. Insira um número válido.");
                    break;
                }
            } 
        } catch (NumberFormatException e) {
            System.out.println("Insira um número válido.");
        }
    }
    public static String formatadorData(String inputHora){
        DateTimeFormatter inputFormatador = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
        try{
            LocalDateTime localDateTime = LocalDateTime.parse(inputHora, inputFormatador);
            ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
            String horario = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(zonedDateTime);
            return horario;
        } catch(DateTimeParseException e){
            System.out.println("Insira o valor no formato correto (ex: 10/06/25 14:30): ");
            return null;
        }
    }
}
