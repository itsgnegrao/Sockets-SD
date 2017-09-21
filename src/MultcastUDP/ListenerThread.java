/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultcastUDP;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Thread para receber mensagens multicast e exibir na GUI
 * @author itsgnegrao
 */
public class ListenerThread extends Thread{
    private final MulticastSocket mcSocket;
    private final ChatMulticastGUI chatGUI;
    
 
    public ListenerThread(ChatMulticastGUI chatGUI, MulticastSocket mcSocket) {
        this.mcSocket = mcSocket;
        this.chatGUI = chatGUI;
    }
    
    @Override
    public void run(){
        while (true) {
            try {
                byte[] buffer = new byte[1024];
	
                DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
                mcSocket.receive(messageIn);
                chatGUI.exibeMsg(new String(messageIn.getData()));
                       
            } catch (IOException ex) {
                Logger.getLogger(ListenerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
