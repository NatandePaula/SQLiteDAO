/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufes.sqllitedao.model;

/**
 *
 * @author batis
 */
public class Cliente {
   private int id;
   private String nome;
   private String email;
    // Construtores, getters 
   
    public Cliente(int id,String nome , String email){
        this.nome= nome;
        this.email= email;
    };
    public Cliente(){};
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }
   
   

}
