/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serializacao;

import java.io.Serializable;

/**
 *
 * @author itsgnegrao
 */
public class Compromisso implements Serializable{
    private String id;
    private String descricao;
    private String data;
    private String hora;
        

    Compromisso(String idClientComp, String descComp, String dataComp, String horaComp) {
        this.id = idClientComp;
        this.descricao = descComp;
        this.data = dataComp;
        this.hora = horaComp;
    }

    public String getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }
    
}
