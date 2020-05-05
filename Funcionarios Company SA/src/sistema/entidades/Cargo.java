/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.entidades;

/**
 *
 * @author BRUNOSILVA
 */
public class Cargo {
    private int id;
    private String nome;

    public Cargo() {
    }
    
    

    public Cargo(int id) {
        this.id = id;
    }    
    

    public int getId() {
        return id;
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
