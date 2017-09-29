package Parte4;/** * TCPClient: Cliente para conexao TCP * Descricao: Envia uma informacao ao servidor e finaliza a conexao *  */import java.net.*;import java.io.*;import java.util.logging.Level;import java.util.logging.Logger;import java.io.DataInputStream;public class TCPClient {    private static ChatMulticastGUI chatGUI;    private static DataOutputStream out;    private static DataInputStream in;    private static Thread clienteEnvia;    private static Thread clienteRecebe;    private static Socket s;    private static File f;    private static FileOutputStream fos = null;           public TCPClient(ChatMulticastGUI chatGUI, String ipServidor, int serverPort){        this.chatGUI = chatGUI;        try {            s = new Socket(ipServidor, serverPort);  /* conecta com o servidor */            TCPClientEnvia();            TCPClientRecebe();        } catch (IOException ex) {            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);        }    }        void EnviaMsg(String msg){                       try {             out.writeUTF(msg);            System.out.println ("Informacao enviada.");                    } catch (IOException ex) {            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);        }    }        public static void TCPClientEnvia(){        clienteEnvia = (new Thread() {            @Override            public void run() {                    try{                    /* cria objetos de leitura e escrita */                    out = new DataOutputStream( s.getOutputStream());	                } catch (UnknownHostException e){                    System.out.println("Socket: -TCPClientEnvia-"+e.getMessage());                } catch (EOFException e){                    System.out.println("EOF: -TCPClientEnvia-"+e.getMessage());                } catch (IOException e){                    System.out.println("leitura: -TCPClientEnvia-"+e.getMessage());                } //catch            }        });//Thread        clienteEnvia.start();   }//metodo        public static void TCPClientRecebe(){        clienteRecebe = (new Thread() {            @Override            public void run() {                try{                                        /* cria objetos de leitura e escrita */                    in = new DataInputStream( s.getInputStream());                    String data = null;                    while(true){                                               data = new String (in.readUTF());                                                if(data.equals("QTD-PATH")){                            int qtd_path = in.readInt();                            chatGUI.exibeMsg(""+Integer.toString(qtd_path)+" Arquivos contidos no diretório padrão do servidor:\n");                            System.out.println(""+Integer.toString(qtd_path)+" Arquivos contidos no diretório padrão do servidor:");                        }                        else if(data.equals("FILES")){                            String nomeArq = in.readUTF();                            long tamanhoTot = in.readLong();                            System.out.print("Size: "+tamanhoTot+"_________"+nomeArq+"\n");                            //chatGUI.exibeMsg("Size: "+tamanhoTot+"_________"+nomeArq+"\n");                                                                                    /*byte[] aByte = new byte[1];                            int bytesRead;                            System.out.println("BAIXANDOOOOOOOOO1");                            // cria objetos de leitura e escrita                             is = s.getInputStream();                            f = new File("teste.txt");                            ByteArrayOutputStream baos = new ByteArrayOutputStream();                            FileOutputStream fos = null;                            BufferedOutputStream bos = null;                            fos = new FileOutputStream(f);                            bos = new BufferedOutputStream(fos);                            bytesRead = is.read(aByte, 0, aByte.length);                                                         System.out.println("BAIXANDOOOOOOOOO2");                            do {                                    baos.write(aByte);                                    bytesRead = is.read(aByte);                            } while (bytesRead != -1);                            System.out.println("FIM!");                            bos.write(baos.toByteArray());                            bos.flush(); */                         }                                                  else if(data.equals("EXIT")){                            in.close();                            s.close();                            clienteRecebe.interrupt();                            this.interrupt();                            break;			}                                                 else if(data.equals("DOWN")){                            File file = new File(in.readUTF());                                                        fos = new FileOutputStream(file);                            byte[] buffer = new byte[4096];                            int filesize = 15123; // Send file size in separate msg                            int read = 0;                            int totalRead = 0;                            int remaining = filesize;                            while((read = in.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {                                    totalRead += read;                                    remaining -= read;                                    System.out.println("read " + totalRead + " bytes.");                                    fos.write(buffer, 0, read);                            }                            fos.close();                                                }                                                else{                            System.out.println("informação recebida");                            chatGUI.exibeMsg(data);                            System.out.println(data);                        }                    }                } catch (UnknownHostException e){                    System.out.println("Socket: -TCPClientRecebe-"+e.getMessage());                } catch (EOFException e){                    System.out.println("EOF:-TCPClientRecebe-"+e.getMessage());                } catch (IOException e){                    System.out.println("leitura:-TCPClientRecebe-"+e.getMessage());                } //catch            }        });//Thread        clienteRecebe.start();   }//metodo    } //class