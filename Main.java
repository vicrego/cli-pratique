
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

import Controller.EventoController;
import Model.ListaDeEventos;
import Model.Usuario;

public class Main {
    public static void main(String[] args){
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Crie um usuário. Primeiro insira um nome: ");
            String nome = scan.nextLine();
            System.out.print("Insira o seu sobrenome: ");
            String sobrenome = scan.nextLine();
            System.out.print("Insira o seu telefone: ");
            String telefone = scan.nextLine();
            Usuario usuario = new Usuario(nome, sobrenome, telefone);
            ListaDeEventos listaDeEventos = new ListaDeEventos();
                        
            boolean repetirEventoAdd = true;
            while(repetirEventoAdd){
                System.out.println("Selecione uma das opções abaixo:");
                System.out.println("1. Adicionar evento.");
                System.out.println("2. Exibir todos os eventos.");
                System.out.println("3. Exibir eventos participados.");
                System.out.println("4. Sair.");                
                int escolhaDetalhesEvento = scan.nextInt();
                scan.nextLine(); 
                switch(escolhaDetalhesEvento) {
                    case 1:
                        System.out.print("Insira um nome para o evento: ");
                        String nomeEvento = scan.nextLine();
                        System.out.print("Insira um endereço: ");
                        String endereco = scan.nextLine();
                        System.out.println("Escolha uma das categoria abaixo: ");
                        String categoria = "";
                        Boolean repetirCategoria = true;
                        while(repetirCategoria){
                            System.out.println("1. Festa.");
                            System.out.println("2. Evento esportivo.");
                            System.out.println("3. Show.");
                            int escolhaCategoria = scan.nextInt();
                            scan.nextLine(); 
                            switch(escolhaCategoria){
                                case 1:
                                    categoria = "Festa";
                                    repetirCategoria = false;
                                    break;
                                case 2:
                                    categoria = "Evento esportivo";
                                    repetirCategoria = false;
                                    break;
                                case 3:
                                    categoria = "Show";
                                    repetirCategoria = false;
                                    break;
                                default: 
                                    System.out.println("Insira a opção correta.");
                                    repetirCategoria = true;
                                    escolhaCategoria = scan.nextInt(); 
                                    break;
                            }
                        }

                        System.out.print("Insira uma descrição: ");
                        String descricao = scan.nextLine();

                        System.out.print("Insira a data e hora (ex: 10/06/25 14:30): ");
                        String horario = "";
                        Boolean repetirHoraFormatador = true; 
                        while(repetirHoraFormatador){
                            String inputHora = scan.nextLine();
                            horario = EventoController.formatadorData(inputHora);    
                            if(horario != null){
                                repetirHoraFormatador = false;
                            };   
                        };               
   
                        EventoController.criarEvento(nomeEvento, endereco, categoria, descricao, horario);
                        System.out.println(listaDeEventos.toString());
                        break;

                    case 2:
                        System.out.println(listaDeEventos.toString());
                        Boolean repetirParticipar = true;
                        while(repetirParticipar){
                            System.out.println("Insira o número do evento para participar. Pressione 'N' para voltar ao menu principal.");
                            String numEvento = scan.nextLine();
                            if(!numEvento.equalsIgnoreCase("N")){
                                EventoController.adicionarEventoUsuario(repetirParticipar, numEvento);
                            } else {
                                System.out.println("Insira um número válido.");
                                repetirParticipar = false;
                            }                        
                        }     
                        break;
                    
                    case 3:    
                        System.out.println(usuario.toString());
                        break;

                    case 4:
                        System.out.print("\n Tem certeza que deseja sair do programa? Y or N: ");
                        String continuar = scan.nextLine();
                        if(continuar.equalsIgnoreCase("Y")){
                            System.out.println("Obrigado por utilizar o aplicativo. Tenha um bom dia.");
                            repetirEventoAdd = false;
                            break;
                        } 
                        break;

                    default:
                    System.out.println("Insira um número válido.");
                }    
                
            }
        }
    }
}
