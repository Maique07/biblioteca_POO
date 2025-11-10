/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author Maique
 */
public class LIVRO {

    private Integer ID_LIVRO;
    private String TITULO_LIVRO;
    private String AUTOR_LIVRO;
    private boolean DISPONIVEL = true;

    public LIVRO() {}

    public LIVRO(String titulo, String autor) {
        this.TITULO_LIVRO = titulo;
        this.AUTOR_LIVRO = autor;
        this.DISPONIVEL = true;
    }

    public LIVRO(Integer id, String titulo, String autor, boolean disponivel) {
        this.ID_LIVRO = id;
        this.TITULO_LIVRO = titulo;
        this.AUTOR_LIVRO = autor;
        this.DISPONIVEL = disponivel;
    }

    public Integer getId() {
        return ID_LIVRO;
    }

    public void setId(Integer id) {
        this.ID_LIVRO = id;
    }

    public String getTitulo() {
        return TITULO_LIVRO;
    }

    public void setTitulo(String titulo) {
        this.TITULO_LIVRO = titulo;
    }

    public String getAutor() {
        return AUTOR_LIVRO;
    }

    public void setAutor(String autor) {
        this.AUTOR_LIVRO = autor;
    }

    public boolean isDisponivel() {
        return DISPONIVEL;
    }

    public void setDisponivel(boolean disponivel) {
        this.DISPONIVEL = disponivel;
    }

    @Override
    public String toString() {
        return String.format("%d - %s | %s | %s", ID_LIVRO, TITULO_LIVRO, AUTOR_LIVRO, DISPONIVEL ? "DISPONÍVEL" : "EMPRESTADO");
    }
}
