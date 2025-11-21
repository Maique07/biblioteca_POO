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
        String sql = "INSERT INTO usuarios (NOME_USUARIO, EMAIL_USUARIO) VALUES (?, ?)";
        try (Connection c = CONEXAO_JAVA_MYSQL.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.executeUpdate();
        }
    }

    public List<CADASTRO_USUARIO> listar() throws SQLException {
        List<CADASTRO_USUARIO> lista = new ArrayList<>();
        String sql = "SELECT ID_USUARIO, NOME_USUARIO, EMAIL_USUARIO FROM usuarios ORDER BY ID_USUARIO";
        try (Connection c = CONEXAO_JAVA_MYSQL.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new CADASTRO_USUARIO(rs.getInt("ID_USUARIO"), rs.getString("NOME_USUARIO"), rs.getString("EMAIL_USUARIO")));
            }
        }
        return lista;
    }

    public CADASTRO_USUARIO buscarPorId(int id) throws SQLException {
        String sql = "SELECT ID_USUARIO, NOME_USUARIO, EMAIL_USUARIO FROM usuarios WHERE ID_USUARIO = ?";
        try (Connection c = CONEXAO_JAVA_MYSQL.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new CADASTRO_USUARIO(rs.getInt("ID_USUARIO"), rs.getString("NOME_USUARIO"), rs.getString("EMAIL_USUARIO"));
                }
            }
        }
        return null;
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE ID_USUARIO = ?";
        try (Connection c = CONEXAO_JAVA_MYSQL.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
