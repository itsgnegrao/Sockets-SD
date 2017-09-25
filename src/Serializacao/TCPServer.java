package Serializacao;/** * TCPServer: Servidor para conexao TCP com Threads * Descricao: Recebe uma conexao, cria uma thread, recebe uma mensagem e finaliza a conexao */import java.net.*;import java.io.*;import java.util.logging.Level;import java.util.logging.Logger;public class TCPServer {    public static void main (String args[]) {        try{            int serverPort = 7896; // porta do servidor            /* cria um socket e mapeia a porta para aguardar conexao */            ServerSocket listenSocket = new ServerSocket(serverPort);            boolean alive = true;                        while(alive) {                System.out.println ("Servidor aguardando conexao ...");				/* aguarda conexoes */                Socket clientSocket = listenSocket.accept();                                System.out.println ("Cliente conectado ... Criando thread ...");                /* cria um thread para atender a conexao */                TaskThread c = new TaskThread(clientSocket);                                if(!c.isAlive()) alive = false;                            } //while                    } catch(IOException e) {	    System.out.println("Listen socket:"+e.getMessage());	} //catch    } //main} //class/** * Classe TaskThread: Thread responsavel pela comunicacao * Descricao: Rebebe um socket, cria os objetos de leitura e escrita e aguarda msgs clientes  */class TaskThread extends Thread {    private static ObjectInputStream in;    private static ObjectOutputStream out;    private static Socket clientSocket;    private static Thread taskRecebe;    private static Thread taskEnvia;    private static volatile boolean alive = true;        public TaskThread (Socket aClientSocket) {        try {            clientSocket = aClientSocket;            in = new ObjectInputStream( clientSocket.getInputStream());            out =new ObjectOutputStream( clientSocket.getOutputStream());            alive = true;            this.start();  /* inicializa a thread */            TaskThreadRecebe();        } catch(IOException e) {	    System.out.println("Connection:"+e.getMessage());	} //catch    } //construtor            public static void TaskThreadRecebe() throws UnknownHostException{        taskRecebe = (new Thread() {        @Override        public void run() {            try{            Compromisso comp = null;            String data = " ";            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));            		while(TaskThread.alive){	                    		    comp = (Compromisso) in.readObject();   /* aguarda o recebimento de dados */	 		    System.out.println ("Cliente id:" + comp.getId()+"\nCompromisso: "+comp.getDescricao()+ "\nData: "+ comp.getData()+" Hora:"+comp.getHora());                                         if(data.equals("ACKSAIR")){                        in.close();                        clientSocket.close();                        taskRecebe.interrupt();                        this.interrupt();                        break;                    }		}		            } catch (EOFException e){	    System.out.println("EOF: "+e.getMessage());        } catch(IOException e) {	    System.out.println("leitura: "+e.getMessage());        }   catch (ClassNotFoundException ex) {                Logger.getLogger(TaskThread.class.getName()).log(Level.SEVERE, null, ex);            } //catch                            }//run                    });//Thread        taskRecebe.start();    }//metodo       void EnviaObj(Compromisso comp) {        try {            out.writeObject(comp);            out.flush();        } catch (IOException ex) {            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);        }    }}     