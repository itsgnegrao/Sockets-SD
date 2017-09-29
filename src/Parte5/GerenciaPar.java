/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parte5;

import java.net.Socket;

/**
 *
 * @author itsgnegrao
 */
public class GerenciaPar extends Thread{
    
    TaskThread c1;
    TaskThread c2;
    
    
    void printMsg(String Cliente, String msg){
        synchronized(this){//synchronized block
             try{
                     c1.out.writeUTF(msg);
                     c2.out.writeUTF(msg);
                System.out.println("Gerencia ["+this.getName()+"]-"+msg);
                
                Thread.sleep(400);
             }catch(Exception e){System.out.println(e);}
        }
    }

    public void setC1(TaskThread c1) {
        this.c1 = c1;
    }
    
    public void setC2(TaskThread c2) {
        this.c2 = c2;
    }

    
    
}
