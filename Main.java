import java.util.Scanner;

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
                System.out.println("1 - Adicionar evento.");
                System.out.println("2 - Exibir todos os eventos.");
                System.out.println("3 - Exibir eventos participados.");
                System.out.println("4 - Sair.");                
                int escolhaDetalhesEvento = dd.nextInt();
                
                dd.nextLine();
                switch(escolhaDetalhesEvento) {
                    case 1:
                        System.out.println("Insira um nome para o evento.");
                        String nomeEvento = dd.nextLine();
                        System.out.println("Insira um endereço.");
                        String endereco = dd.nextLine();
                        String categoria = "";
                        Boolean repetirCategoria = true;
                        while(repetirCategoria){
                            System.out.println("Insira uma categoria abaixo.");
                            System.out.println("1 - Festa.");
                            System.out.println("2 - Evento esportivo.");
                            System.out.println("3 - Show.");
                            
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
                        Evento evento = new Evento(nomeEvento, endereco, categoria);
                        ListaDeEventos.adicionarEventos(evento);
                        System.out.println(listaDeEventos.toString());
                        //System.out.println("\n Deseja continuar? Y or N.");
                        //String continuar = dd.nextLine();
                        /* 
                        if(continuar == "Y"){
                            repetirEventoAdd = true;
                        } else if(continuar == "N"){
                            System.out.println("Obrigado por utilizar o aplicativo. Tenha um bom dia.");
                            repetirEventoAdd = false;
                        }
                        */
                        break;
                    case 2:
                        System.out.println(listaDeEventos.toString());
                        Boolean repetirParticipar = true;
                        while(repetirParticipar){
                            System.out.println("Insira o número do evento para participar. Pressione 'N' para voltar ao menu principal.");
                            String numEvento = dd.nextLine();
                            if(!numEvento.equalsIgnoreCase("N")){
                                //Loops inside ListaDeEventos
                                for(int i = 0; i < ListaDeEventos.listaDeEventos.size(); i++){
                                    //Checks if Usuario is participating in any event
                                    if(Usuario.eventosParticipados.size() > 0 && Integer.parseInt(numEvento) <= ListaDeEventos.listaDeEventos.size()) {        
                                        //Checks if iterator is less than the number of Usuario.eventosParticipados.
                                        //If so, event will add if Usuario.numeroEvento is different than ListaDeEventos.numeroEvento.  
                                        if(i + 1 <= Usuario.eventosParticipados.size() ? (Usuario.eventosParticipados.get(i).numeroEvento != ListaDeEventos.listaDeEventos.get(i).numeroEvento) : true){
                                            //ListaDeEvento.numeroEvento that has the same value as user's choice will be added
                                            if(Integer.parseInt(numEvento) == ListaDeEventos.listaDeEventos.get(i).numeroEvento) {  
                                                Usuario.participarEvento(ListaDeEventos.listaDeEventos.get(i));
                                                System.out.println("Evento adicionado com sucesso.");                                        
                                                repetirParticipar = false;
                                                break;
                                            } else {
                                                //ListaDeEvento.numeroEvento that doesn't have the same value as User's Choice repeats process
                                                System.out.println(ListaDeEventos.listaDeEventos.get(i).numeroEvento);
                                                System.out.println("Evento não existente. Insira um número válido.");
                                                repetirParticipar = true;
                                                //testo = true;
                                            }
                                        //Usuario.numeroEvento that's equal to ListaDeEventos.numero repeats process
                                        } else if (Usuario.eventosParticipados.get(i).numeroEvento == ListaDeEventos.listaDeEventos.get(i).numeroEvento) {
                                            //User's choice that is equal to ListaDeEventos.numero will have "Repeat" message displayed
                                            if(Integer.parseInt(numEvento) == ListaDeEventos.listaDeEventos.get(i).numeroEvento) { 
                                                System.out.println("Evento repetido. Insira um número válido.");
                                            } /*else if((Integer.parseInt(numEvento)) > ListaDeEventos.listaDeEventos.size()){
                                                System.out.println("Número for do escopo.");
                                            }*/;
                                            repetirParticipar = true;                                            
                                        }
                                    } else {
                                        if(Integer.parseInt(numEvento) == ListaDeEventos.listaDeEventos.get(i).numeroEvento) {          
                                            Usuario.participarEvento(ListaDeEventos.listaDeEventos.get(i));
                                            System.out.println("Evento adicionado com sucesso.");                                            
                                            repetirParticipar = false;
                                            break;
                                        } else {
                                            System.out.println(ListaDeEventos.listaDeEventos.get(i).numeroEvento);
                                            System.out.println("Evento não existente. Insira um número válido.");
                                            repetirParticipar = true;
                                        }
                                    }   
                                } 
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
                    // code block
                }    
            }
        }
    }
}
