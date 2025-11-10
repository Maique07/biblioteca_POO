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
        String sql = "INSERT INTO livros (titulo, autor, disponivel) VALUES (?, ?, ?)";
        try (Connection c = CONEXAO_JAVA_MYSQL.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            ps.setBoolean(3, l.isDisponivel());
            ps.executeUpdate();
        }
    }

    public List<LIVRO> listarTodos() throws SQLException {
        List<LIVRO> lista = new ArrayList<>();
        String sql = "SELECT id, titulo, autor, disponivel FROM livros ORDER BY id";
        try (Connection c = CONEXAO_JAVA_MYSQL.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new LIVRO(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getBoolean("disponivel")
                ));
            }
        }
        return lista;
    }

    public List<LIVRO> listarDisponiveis() throws SQLException {
        List<LIVRO> lista = new ArrayList<>();
        String sql = "SELECT id, titulo, autor, disponivel FROM livros WHERE disponivel = TRUE ORDER BY id";
        try (Connection c = CONEXAO_JAVA_MYSQL.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new LIVRO(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getBoolean("disponivel")
                ));
            }
        }
        return lista;
    }
}
