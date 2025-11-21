/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Maique
 */
import MODELO.EMPRESTIMOS;
import DB.CONEXAO_JAVA_MYSQL;

import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class EmprestimosDAO {

    // Adiciona um novo empréstimo
    public void adicionarEmprestimo(EMPRESTIMOS emprestimo) {
        String sql = "INSERT INTO emprestimos (id_usuario, id_livro, data_emprestimo, dataPrevista, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = CONEXAO_JAVA_MYSQL.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, emprestimo.getIdUsuario());
            stmt.setInt(2, emprestimo.getIdLivro());
            java.sql.Date data1 = new java.sql.Date(emprestimo.getDataEmprestimo().getTime());
            System.out.println(data1);
            stmt.setDate(3, data1);
            java.sql.Date data2 = new java.sql.Date(emprestimo.getDataPrevista().getTime());
            System.out.println(data2);
            stmt.setDate(4, data2);
            stmt.setString(5, emprestimo.getStatus());
            stmt.executeUpdate();

            System.out.println("📚 Empréstimo registrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao registrar empréstimo: " + e.getMessage());
        }
    }

    // Registra devolução
    public void registrarDevolucao(int idEmprestimo) {
        String sql = "UPDATE emprestimos SET status = 'Devolvido' WHERE ID_EMPRESTIMOS = ?";
        try (Connection conn = CONEXAO_JAVA_MYSQL.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idEmprestimo);
            stmt.executeUpdate();

            System.out.println("✅ Devolução registrada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao registrar devolução: " + e.getMessage());
        }
    }

    // Lista todos os empréstimos
    public List<EMPRESTIMOS> listarEmprestimos() {
        List<EMPRESTIMOS> lista = new ArrayList<>();
        String sql = "SELECT * FROM emprestimos";

        try (Connection conn = CONEXAO_JAVA_MYSQL.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                EMPRESTIMOS emp = new EMPRESTIMOS(
                        rs.getInt("ID_EMPRESTIMOS"),
                        rs.getInt("id_usuario"),
                        rs.getInt("id_livro"),
                        rs.getDate("data_emprestimo"),
                        rs.getDate("dataPrevista"),
                        rs.getDate("data_devolucao"),
                        rs.getString("status")
                );
                lista.add(emp);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar empréstimos: " + e.getMessage());
        }
        return lista;
    }

    // Lista empréstimos atrasados
    public List<EMPRESTIMOS> listarAtrasados() {
        List<EMPRESTIMOS> lista = new ArrayList<>();
        String sql = "SELECT * FROM emprestimos WHERE data_devolucao < CURDATE() AND status <> 'Devolvido'";

        try (Connection conn = CONEXAO_JAVA_MYSQL.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                EMPRESTIMOS emp = new EMPRESTIMOS(
                        rs.getInt("ID_EMPRESTIMOS"),
                        rs.getInt("id_usuario"),
                        rs.getInt("id_livro"),
                        rs.getDate("data_emprestimo"),
                        rs.getDate("dataPrevista"),
                        rs.getDate("data_devolucao"),
                        rs.getString("status")
                );
                lista.add(emp);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar atrasados: " + e.getMessage());
        }
        return lista;
    }
}
