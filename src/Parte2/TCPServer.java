package Parte2;/** * TCPServer: Servidor para conexao TCP com Threads * Descricao: Recebe uma conexao, cria uma thread, recebe uma mensagem e finaliza a conexao */import java.net.*;import java.io.*;public class TCPServer {    public static void main (String args[]) {        try{            int serverPort = 7896; // porta do servidor            /* cria um socket e mapeia a porta para aguardar conexao */            ServerSocket listenSocket = new ServerSocket(serverPort);                        while(true) {                System.out.println ("Servidor aguardando conexao ...");				/* aguarda conexoes */                Socket clientSocket = listenSocket.accept();                                System.out.println ("Cliente conectado ... Criando thread ...");                /* cria um thread para atender a conexao */                TaskThread c = new TaskThread(clientSocket);            } //while                    } catch(IOException e) {	    System.out.println("Listen socket:"+e.getMessage());	} //catch    } //main} //class/** * Classe TaskThread: Thread responsavel pela comunicacao * Descricao: Rebebe um socket, cria os objetos de leitura e escrita e aguarda msgs clientes  */class TaskThread extends Thread {    private static DataInputStream in;    private static DataOutputStream out;    private static Socket clientSocket;        public TaskThread (Socket aClientSocket) {        try {            clientSocket = aClientSocket;            in = new DataInputStream( clientSocket.getInputStream());            out =new DataOutputStream( clientSocket.getOutputStream());            this.start();  /* inicializa a thread */            TaskThreadEnvia(clientSocket);            TaskThreadRecebe(clientSocket);        } catch(IOException e) {	    System.out.println("Connection:"+e.getMessage());	} //catch    } //construtor        public static void TaskThreadRecebe(Socket s) throws UnknownHostException{        (new Thread() {        @Override        public void run() {            try{            String data = " ";            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		while(true){			                 		    data = in.readUTF();   /* aguarda o recebimento de dados */	 		    System.out.println ("Cliente disse: " + data); 		                    if(data.equals("SAIR")){                        out.writeUTF("ACKSAIR");                        in.close(); out.close(); clientSocket.close();  /* finaliza a conexao com o cliente */                        break;                    }                    if(data.equals("ACKSAIR")){                        in.close(); out.close(); clientSocket.close();  /* finaliza a conexao com o cliente */                        break;                    }		}		            } catch (EOFException e){	    System.out.println("EOF: "+e.getMessage());        } catch(IOException e) {	    System.out.println("leitura: "+e.getMessage());        } //catch                            }//run                }).start();//Thread    }//metodo        public static void TaskThreadEnvia(Socket s) throws UnknownHostException{        (new Thread() {        @Override        public void run() {            try{                            	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		String data = "";				while(true){			data = reader.readLine();			out.writeUTF(data);			System.out.println ("Informacao enviada.");					}                		            } catch (EOFException e){	    System.out.println("EOF: "+e.getMessage());        } catch(IOException e) {	    System.out.println("leitura: "+e.getMessage());        } //catch                                }//run                }).start();//Thread    }//metodo}     