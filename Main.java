
import java.util.Scanner;

import Controller.EventoController;
import Model.ListaDeEventos;
import Model.Usuario;

public class Main {
    public static void main(String[] args){
        try (Scanner dd = new Scanner(System.in)) {
            System.out.println("Crie um usuário. Primeiro insira um nome.");
            String nome = dd.nextLine();
            System.out.println("Insira o seu sobrenome.");
            String sobrenome = dd.nextLine();
            System.out.println("Insira o seu telefone.");
            String telefone = dd.nextLine();
            Usuario usuario = new Usuario(nome, sobrenome, telefone);
            ListaDeEventos listaDeEventos = new ListaDeEventos();
                        
            boolean repetirEventoAdd = true;
            while(repetirEventoAdd){
                
                System.out.println("Selecione uma das opções abaixo:");
                System.out.println("1. Adicionar evento.");
                System.out.println("2. Exibir todos os eventos.");
                System.out.println("3. Exibir eventos participados.");
                System.out.println("4. Sair.");                
                int escolhaDetalhesEvento = dd.nextInt();
                
                dd.nextLine();
                switch(escolhaDetalhesEvento) {
                    case 1:
                        System.out.println("Insira um nome para o evento:");
                        String nomeEvento = dd.nextLine();
                        System.out.println("Insira um endereço:");
                        String endereco = dd.nextLine();
                        System.out.println("Insira uma categoria abaixo:");
                        String categoria = "";
                        Boolean repetirCategoria = true;
                        while(repetirCategoria){
                            System.out.println("1. Festa.");
                            System.out.println("2. Evento esportivo.");
                            System.out.println("3. Show.");
                            int escolhaCategoria = dd.nextInt();
                            dd.nextLine(); 
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
                                    escolhaCategoria = dd.nextInt(); 
                                    break;
                            }
                        }
                        EventoController.criarEvento(nomeEvento, endereco, categoria);
                        System.out.println(listaDeEventos.toString());
                        break;
                    case 2:
                        System.out.println(listaDeEventos.toString());
                        Boolean repetirParticipar = true;
                        while(repetirParticipar){
                            System.out.println("Insira o número do evento para participar. Pressione 'N' para voltar ao menu principal.");
                            String numEvento = dd.nextLine();
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
                        System.out.println("\n Tem certeza que deseja sair do programa? Y or N.");
                        String continuar = dd.nextLine();
                        
                        if(continuar.equalsIgnoreCase("Y")){
                            System.out.println("Obrigado por utilizar o aplicativo. Tenha um bom dia.");
                            repetirEventoAdd = false;
                            break;
                        } else if(continuar.equalsIgnoreCase("N")){
                            repetirEventoAdd = true;
                        }
                        break;
                    default:
                    System.out.println("Insira um número válido.");
                    // code block
                }    
            }
        }
    }
}
