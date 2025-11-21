/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Maique
 */
import DB.CONEXAO_JAVA_MYSQL;
import MODELO.LIVRO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    public void cadastrar(LIVRO l) throws SQLException {
        String sql = "INSERT INTO livros (TITULO_LIVRO, AUTOR_LIVRO, DISPONIVEL) VALUES (?, ?, ?)";
        try (Connection c = CONEXAO_JAVA_MYSQL.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            ps.setBoolean(3, l.isDisponivel());
            ps.executeUpdate();
        }
    }

    public List<LIVRO> listarTodos() throws SQLException {
        List<LIVRO> lista = new ArrayList<>();
        String sql = "SELECT ID_LIVRO, TITULO_LIVRO, AUTOR_LIVRO, DISPONIVEL FROM livros ORDER BY ID_LIVRO";
        try (Connection c = CONEXAO_JAVA_MYSQL.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new LIVRO(
                        rs.getInt("ID_LIVRO"),
                        rs.getString("TITULO_LIVRO"),
                        rs.getString("AUTOR_LIVRO"),
                        rs.getBoolean("DISPONIVEL")
                ));
            }
        }
        return lista;
    }

    public List<LIVRO> listarDisponiveis() throws SQLException {
        List<LIVRO> lista = new ArrayList<>();
        String sql = "SELECT ID_LIVRO, TITULO_LIVRO, AUTOR_LIVRO, DISPONIVEL FROM livros WHERE disponivel = TRUE ORDER BY ID_LIVRO";
        try (Connection c = CONEXAO_JAVA_MYSQL.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new LIVRO(
                        rs.getInt("ID_LIVRO"),
                        rs.getString("TITULO_LIVRO"),
                        rs.getString("AUTOR_LIVRO"),
                        rs.getBoolean("DISPONIVEL")
                ));
            }
        }
        return lista;
    }
}
