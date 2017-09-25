package Serializacao;/** * TCPClient: Cliente para conexao TCP * Descricao: Envia uma informacao ao servidor e finaliza a conexao */import java.net.*;import java.io.*;import java.util.logging.Level;import java.util.logging.Logger;public class TCPClient extends Thread{    private static ObjectInputStream in;    private static ObjectOutputStream out;    private static Thread clienteEnvia;    private static Thread clienteRecebe;    private static Socket s;        public TCPClient() {        try {            String ipServidor = "127.0.0.1";            s = null;            int serverPort = 7896;   /* especifica a porta */            s = new Socket(ipServidor, serverPort);  /* conecta com o servidor */            clienteRecebe();            clienteEnvia();            this.start();        } catch (IOException ex) {            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);        }    }                    public static void clienteRecebe() throws UnknownHostException{        clienteRecebe = (new Thread() {        @Override        public void run() {                        try{                in = new ObjectInputStream( s.getInputStream());            	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		String data = " ";				while(true){                    			data = in.readUTF();			System.out.println (data);									if(data.equals("ACKSAIR")){                            in.close();                            s.close();                            clienteRecebe.interrupt();                            this.interrupt();                            break;			}		}			    } catch (UnknownHostException e){		System.out.println("Socket:"+e.getMessage());            } catch (EOFException e){		System.out.println("EOF:"+e.getMessage());            } catch (IOException e){		System.out.println("leitura:"+e.getMessage());            } //catch        }                    });//Thread        clienteRecebe.start();    }//metodo            public static void clienteEnvia() throws UnknownHostException{        clienteEnvia = (new Thread() {        @Override        public void run() {                        try{                out = new ObjectOutputStream( s.getOutputStream());                                    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		String data = " ";				/*while(true){                                        System.out.println ("Informacao enviada.");                                        if(data.equals("SAIR")){                        out.close();                        clienteEnvia.interrupt();                        this.interrupt();                        break;                     }                        		}*/			    } catch (UnknownHostException e){		System.out.println("Socket:"+e.getMessage());            } catch (EOFException e){		System.out.println("EOF:"+e.getMessage());            } catch (IOException e){		System.out.println("leitura:"+e.getMessage());            } //catch        }                    });//Thread        clienteEnvia.start();    }//metodo    void EnviaObj(Compromisso comp) {        try {            out.writeObject(comp);            out.flush();        } catch (IOException ex) {            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);        }    }        } //class