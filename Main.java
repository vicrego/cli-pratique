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
                        Boolean testo = false;
                        while(repetirParticipar){
                            System.out.println("Insira o número do evento para participar. Pressione 'N' para voltar ao menu principal.");
                            String numEvento = dd.nextLine();
                            if(!numEvento.equalsIgnoreCase("N")){
                                //Loops inside ListaDeEventos
                                for(int i = 0; i < ListaDeEventos.listaDeEventos.size(); i++){
                                    //Checks if eventosParticipados has any item. 
                                    //If it has, check if usuario and listaDeEventos are different. 
                                    /*if((Usuario.eventosParticipados.size() > 0) ? ( Integer.parseInt(numEvento) != ListaDeEventos.listaDeEventos.get(i).numeroEvento) : true){
                                        //If user's input is equal to the event's number, Usuario has event added 
                                        if(Integer.parseInt(numEvento) == ListaDeEventos.listaDeEventos.get(i).numeroEvento) {  
                                            Usuario.participarEvento(ListaDeEventos.listaDeEventos.get(i));
                                            System.out.println("Evento adicionado com sucesso.");                                            
                                            repetirParticipar = false;
                                        } else {
                                            System.out.println("Evento não existente. Insira um número válido.");
                                            //System.out.println("Number from listaDeEventos and Usuario.eventoparticipados are the same.");
                                            repetirParticipar = true;
                                            //testo = true;
                                        }


                                    
                                    } else {
                                        System.out.println("Insira um número válido.");
                                        repetirParticipar = true;
                                    }*/
                                    Boolean eventAdded = false;
                                    if(Usuario.eventosParticipados.size() > 0) {                                       
                                        if(i + 1 <= Usuario.eventosParticipados.size() ? (Usuario.eventosParticipados.get(i).numeroEvento != ListaDeEventos.listaDeEventos.get(i).numeroEvento) : true){
                                            if(Integer.parseInt(numEvento) == ListaDeEventos.listaDeEventos.get(i).numeroEvento) {  
                                                
                                                Usuario.participarEvento(ListaDeEventos.listaDeEventos.get(i));
                                                System.out.println("Evento adicionado com sucesso.");
                                                eventAdded = true;                                            
                                                repetirParticipar = false;
                                                break;
                                            } else {
                                                System.out.println(ListaDeEventos.listaDeEventos.get(i).numeroEvento);
                                            
                                                System.out.println("Evento não existente. Insira um número válido.");
                                                repetirParticipar = true;
                                                //testo = true;
                                            }
                                        } else {
                                            
                                            System.out.println("Evento repetido. Insira um número válido.");
                                            repetirParticipar = true;
                                            //testo = true;
                                            //break;
                                            
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
                                            //System.out.println("Number from listaDeEventos and Usuario.eventoparticipados are the same.");
                                            repetirParticipar = true;
                                            //testo = true;
                                        }
                                    }
                                    
                                    
                                    /* 
                                    ? ( Integer.parseInt(numEvento) != ListaDeEventos.listaDeEventos.get(i).numeroEvento) : true){
                                        //If user's input is equal to the event's number, Usuario has event added 
                                        if(Integer.parseInt(numEvento) == ListaDeEventos.listaDeEventos.get(i).numeroEvento) {  
                                            Usuario.participarEvento(ListaDeEventos.listaDeEventos.get(i));
                                            System.out.println("Evento adicionado com sucesso.");                                            
                                            repetirParticipar = false;
                                        } else {
                                            System.out.println("Evento não existente. Insira um número válido.");
                                            //System.out.println("Number from listaDeEventos and Usuario.eventoparticipados are the same.");
                                            repetirParticipar = true;
                                            //testo = true;
                                        }


                                    
                                    } else {
                                        System.out.println("Insira um número válido.");
                                        repetirParticipar = true;
                                    }
                                        */
                                } 
                            } else {
                                System.out.println("Insira um número válido.");
                                repetirParticipar = false;
                            }
                            /* 
                            if(testo){
                                System.out.println("Insira um número válido 2.");
                            }*/
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
