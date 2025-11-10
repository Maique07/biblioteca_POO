/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Maique
 */
import MODELO.CADASTRO_USUARIO;
import DB.CONEXAO_JAVA_MYSQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {


    public void cadastrar(CADASTRO_USUARIO u) throws SQLException {
        String sql = "INSERT INTO usuarios (nome, email) VALUES (?, ?)";
        try (Connection c = CONEXAO_JAVA_MYSQL.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.executeUpdate();
        }
    }

    public List<CADASTRO_USUARIO> listar() throws SQLException {
        List<CADASTRO_USUARIO> lista = new ArrayList<>();
        String sql = "SELECT id, nome, email FROM usuarios ORDER BY id";
        try (Connection c = CONEXAO_JAVA_MYSQL.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new CADASTRO_USUARIO(rs.getInt("id"), rs.getString("nome"), rs.getString("email")));
            }
        }
        return lista;
    }

    public CADASTRO_USUARIO buscarPorId(int id) throws SQLException {
        String sql = "SELECT id, nome, email FROM usuarios WHERE id = ?";
        try (Connection c = CONEXAO_JAVA_MYSQL.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new CADASTRO_USUARIO(rs.getInt("id"), rs.getString("nome"), rs.getString("email"));
                }
            }
        }
        return null;
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection c = CONEXAO_JAVA_MYSQL.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
