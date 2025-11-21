/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author Maique
 */
public class CADASTRO_USUARIO {

    private Integer ID_USUARIO;
    private String NOME_USUARIO;
    private String EMAIL_USUARIO;

    public CADASTRO_USUARIO() {
    }

    public CADASTRO_USUARIO(String nome, String email) {
        this.NOME_USUARIO = nome;
        this.EMAIL_USUARIO = email;
    }

    public CADASTRO_USUARIO(Integer id, String nome, String email) {
        this.ID_USUARIO = id;
        this.NOME_USUARIO = nome;
        this.EMAIL_USUARIO = email;
    }

    public Integer getId() {
        return ID_USUARIO;
    }

    public void setId(Integer id) {
        this.ID_USUARIO = id;
    }

    public String getNome() {
        return NOME_USUARIO;
    }

    public void setNome(String nome) {
        this.NOME_USUARIO = nome;
    }

    public String getEmail() {
        return EMAIL_USUARIO;
    }

    public void setEmail(String email) {
        this.EMAIL_USUARIO = email;
    }

    @Override
    public String toString() {
        return String.format("%d - %s (%s)", ID_USUARIO, NOME_USUARIO, EMAIL_USUARIO);
    }
}
