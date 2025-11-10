/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import java.time.LocalDate;

/**
 *
 * @author Maique
 */
public class EMPRESTIMOS {

    private Integer ID_EMPRESTIMOS;
    private Integer id_usuario;
    private Integer id_livro;
    private LocalDate data_emprestimo;
    private LocalDate dataPrevista;   // data limite
    private LocalDate data_devolucao;  // null enquanto não devolvido
    private String status;            // EM ANDAMENTO, ATRASADO, DEVOLVIDO

    public EMPRESTIMOS() {
    }

    public EMPRESTIMOS(Integer idUsuario, Integer idLivro, LocalDate dataEmprestimo, LocalDate dataPrevista, String status) {
        this.id_usuario = idUsuario;
        this.id_livro = idLivro;
        this.data_emprestimo = dataEmprestimo;
        this.dataPrevista = dataPrevista;
        this.status = status;
    }

    public EMPRESTIMOS(Integer id, Integer idUsuario, Integer idLivro, LocalDate dataEmprestimo, LocalDate dataPrevista, LocalDate dataDevolucao, String status) {
        this(idUsuario, idLivro, dataEmprestimo, dataPrevista, status);
        this.ID_EMPRESTIMOS = id;
        this.data_devolucao = dataDevolucao;
    }

    public EMPRESTIMOS(int aInt, int aInt0, int aInt1, LocalDate toLocalDate, LocalDate toLocalDate0, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Integer getId() {
        return ID_EMPRESTIMOS;
    }

    public void setId(Integer id) {
        this.ID_EMPRESTIMOS = id;
    }

    public Integer getIdUsuario() {
        return id_usuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.id_usuario = idUsuario;
    }

    public Integer getIdLivro() {
        return id_livro;
    }

    public void setIdLivro(Integer idLivro) {
        this.id_livro = idLivro;
    }

    public LocalDate getDataEmprestimo() {
        return data_emprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.data_emprestimo = dataEmprestimo;
    }

    public LocalDate getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(LocalDate dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public LocalDate getDataDevolucao() {
        return data_devolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.data_devolucao = dataDevolucao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

