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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmprestimosDAO {

    // Adiciona um novo empréstimo
    public void adicionarEmprestimo(EMPRESTIMOS emprestimo) {
        String sql = "INSERT INTO emprestimos (id_usuario, id_livro, data_emprestimo, data_devolucao, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = CONEXAO_JAVA_MYSQL.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, emprestimo.getIdUsuario());
            stmt.setInt(2, emprestimo.getIdLivro());
            stmt.setDate(3, Date.valueOf(emprestimo.getDataEmprestimo()));
            stmt.setDate(4, Date.valueOf(emprestimo.getDataDevolucao()));
            stmt.setString(5, emprestimo.getStatus());
            stmt.executeUpdate();

            System.out.println("📚 Empréstimo registrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao registrar empréstimo: " + e.getMessage());
        }
    }

    // Registra devolução
    public void registrarDevolucao(int idEmprestimo) {
        String sql = "UPDATE emprestimos SET status = 'Devolvido' WHERE id = ?";
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
                        rs.getDate("data_emprestimo").toLocalDate(),
                        rs.getDate("data_devolucao").toLocalDate(),
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
                        rs.getDate("data_emprestimo").toLocalDate(),
                        rs.getDate("data_devolucao").toLocalDate(),
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
