/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import java.util.Date;

/**
 *
 * @author Maique
 */
public class EMPRESTIMOS {

    private Integer ID_EMPRESTIMOS;
    private Integer id_usuario;
    private Integer id_livro;
    private Date data_emprestimo;
    private Date dataPrevista;   // data limite
    private Date data_devolucao;  // null enquanto não devolvido
    private String status;            // EM ANDAMENTO, ATRASADO, DEVOLVIDO

    @Override
    public String toString() {
        return "EMPRESTIMOS{" + "ID_EMPRESTIMOS=" + ID_EMPRESTIMOS + ", id_usuario=" + id_usuario + ", id_livro=" + id_livro + ", data_emprestimo=" + data_emprestimo + ", dataPrevista=" + dataPrevista + ", data_devolucao=" + data_devolucao + ", status=" + status + '}';
    }

    public EMPRESTIMOS() {
    }

    public EMPRESTIMOS(Integer idUsuario, Integer idLivro, Date dataEmprestimo, Date dataPrevista, String status) {
        this.id_usuario = idUsuario;
        this.id_livro = idLivro;
        this.data_emprestimo = dataEmprestimo;
        this.dataPrevista = dataPrevista;
        this.status = status;
    }

    public EMPRESTIMOS(Integer id, Integer idUsuario, Integer idLivro, Date dataEmprestimo, Date dataPrevista, Date dataDevolucao, String status) {
        this(idUsuario, idLivro, dataEmprestimo, dataPrevista, status);
        this.ID_EMPRESTIMOS = id;
        this.data_devolucao = dataDevolucao;
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

    public Date getDataEmprestimo() {
        return data_emprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.data_emprestimo = dataEmprestimo;
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public Date getDataDevolucao() {
        return data_devolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.data_devolucao = dataDevolucao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

