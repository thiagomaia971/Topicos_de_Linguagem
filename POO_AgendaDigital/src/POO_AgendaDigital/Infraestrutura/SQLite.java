package POO_AgendaDigital.Infraestrutura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import POO_AgendaDigital.Core.Compromisso;
import POO_AgendaDigital.Core.Dia;
import POO_AgendaDigital.Core.Pessoa;

public class SQLite {
	private static Connection conn;
	private static Statement stm;

	public SQLite(String arquivo) {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:" + arquivo);
			stm = conn.createStatement();
		} catch (Exception e) {
			e.getMessage();
		}

		createTables();
	}

	/**
	 * Recebe como parametro uma Pessoa e insere ela no Banco de Dados.
	 * 
	 * @param pessoa
	 */
	public static void insertPessoa(Pessoa pessoa) {
		try {
			stm = conn.createStatement();
			stm.executeUpdate("INSERT INTO Pessoa (Nome, DataNasc) VALUES ('" + pessoa.getNome() + "', '"
					+ pessoa.getDataNascimento() + "')");

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Não foi possivel criar.");
		}
	}

	/**
	 * Método que recebe todas as pessoas que estão no Banco de Dados.
	 * 
	 * @return ArrayList<Pessoa>
	 */
	public static ArrayList<Pessoa> getPessoas() {

		ArrayList<Pessoa> auxPessoas = new ArrayList<Pessoa>();
		ResultSet rs;

		try {
			stm = conn.createStatement();
			rs = stm.executeQuery("SELECT * FROM Pessoa");
			while (rs.next()) {
				auxPessoas.add(new Pessoa(rs.getInt("PessoaId"), rs.getString("Nome"), rs.getString("DataNasc")));
			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return auxPessoas;
	}

	/**
	 * Método para receber uma Pessoa apartir de um Index.
	 * 
	 * @param Index
	 * @return Pessoa
	 */
	public static Pessoa getPessoaByIndex(int Index) {
		int auxIndex = 0;
		ResultSet rs;
		try {
			stm = conn.createStatement();
			rs = stm.executeQuery("SELECT * FROM Pessoa");
			while (rs.next()) {
				if (auxIndex == Index) {
					return new Pessoa(rs.getInt("PessoaId"), rs.getString("Nome"), rs.getString("DataNasc"));
				}
				auxIndex++;
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Pessoa getPessoa(Pessoa p) {
		ResultSet rs;
		try {
			stm = conn.createStatement();
			rs = stm.executeQuery("SELECT * FROM Pessoa WHERE Pessoa.Nome = '" + p.getNome()
					+ "' AND Pessoa.DataNasc = '" + p.getDataNascimento() + "'");
			while (rs.next()) {
				return new Pessoa(rs.getInt("PessoaId"), rs.getString("Nome"), rs.getString("DataNasc"));
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Método para inserir um compromisso no Banco de Dados.
	 * 
	 * @param Compromisso
	 */
	public static void insertCompromisso(Compromisso Compromisso) {

		try {
			stm = conn.createStatement();
			stm.executeUpdate("INSERT INTO [Compromisso](PessoaId, NomeCompromisso) " + "VALUES ('"
					+ Compromisso.getPessoaId() + "', '" + Compromisso.getNomeCompromisso() + "')");

			// stm.executeUpdate("INSERT INTO [Dia] ")
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Método para receber um compromisso apartir de uma Pessoa.
	 * 
	 * @param Pessoa
	 */
	public static Compromisso getCompromissoById(int Id) {

		Compromisso compromisso = new Compromisso();
		ArrayList<Dia> dias = new ArrayList<Dia>();
		ResultSet rs;

		try {
			// Pegando os Dias da semana desse compromisso
			stm = conn.createStatement();
			rs = stm.executeQuery(
					"SELECT * FROM [Dia] AS d INNER JOIN [Compromisso] AS c ON d.CompromissoId = c.CompromissoId WHERE c.Compromisso = "
							+ Id);

			while (rs.next()) {
				dias.add(new Dia(rs.getInt("DiaId"), rs.getInt("CompromissoId"), rs.getString("Dia_Semana"),
						rs.getString("HoraInicial"), rs.getString("HoraFinal")));
			}

			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			// Pegando o compromisso
			stm = conn.createStatement();
			rs = stm.executeQuery("SELECT * FROM [Compromisso] AS c WHERE c.PessoaId = " + Id);

			while (rs.next()) {
				compromisso = new Compromisso(rs.getInt("CompromissoId"), rs.getInt("PessoaId"),
						rs.getString("NomeCompromisso"), dias);
			}
			rs.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return compromisso;
	}

	/*
	 * Método para receber todos os Compromissos.
	 */
	public static ArrayList<Compromisso> getCompromissos() {

		ArrayList<Compromisso> compromissos = new ArrayList<Compromisso>();

		ResultSet _rs;

		try {
			stm = conn.createStatement();
			_rs = stm
					.executeQuery("SELECT * FROM [Compromisso] AS c INNER JOIN [Pessoa] AS p ON c.PessoaId = p.PessoaId");

			while (_rs.next()) {
				// Pegando os dias de 1 compromisso
				ResultSet rs;
				ArrayList<Dia> dias = new ArrayList<Dia>();

				try {

					stm = conn.createStatement();
					rs = stm.executeQuery(
							"SELECT * FROM [Dia] AS d INNER JOIN [Compromisso] AS c ON d.CompromissoId = c.CompromissoId WHERE c.CompromissoId = "
									+ _rs.getInt("CompromissoId"));

					while (rs.next()) {
						
						dias.add(new Dia(rs.getInt("DiasId"), rs.getInt("CompromissoId"), rs.getString("Dia_Semana"),
								rs.getString("HoraInicial"), rs.getString("HoraFinal")));
					}
					rs.close();

				} catch (Exception e) {
					// TODO: handle exception
				}

				compromissos.add(new Compromisso(_rs.getInt("CompromissoId"), +_rs.getInt("PessoaId"),
						_rs.getString("NomeCompromisso"), dias));

			}
			_rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return compromissos;
	}

	public static void insertDia(Dia Dia) {

		try {
			stm = conn.createStatement();
			stm.executeUpdate("INSERT INTO [Dia] (CompromissoId, Dia_Semana, HoraInicial, HoraFinal)" + "Values ('"
					+ Dia.getCompromissoId() + "', '" + Dia.getDia_Semana() + "', '" + Dia.getHoraInicial() + "', '"
					+ Dia.getHoraFinal() + "')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */

	public static void updatePessoa(int Id, Pessoa Pessoa) {

		try {
			stm = conn.createStatement();
			stm.executeUpdate("UPDATE Pessoa SET Nome = '" + Pessoa.getNome() + "', DataNasc = '"
					+ Pessoa.getDataNascimento() + "' WHERE Pessoa.PessoaId = 1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método para receber o número de pessoas Cadastradas.
	 * 
	 * @return int
	 */
	public static int qtdePessoasRegistradas() {
		int qtdePessoas = 0;
		ResultSet rs;

		try {
			stm = conn.createStatement();
			rs = stm.executeQuery("SELECT COUNT(Pessoa.PessoaId) AS qtdePessoas FROM [Pessoa]");
			qtdePessoas = rs.getInt("qtdePessoas");

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return qtdePessoas;
	}

	private void createTables() {
		try {
			stm = conn.createStatement();

			// Pessoa
			stm.executeUpdate("CREATE TABLE IF NOT EXISTS Pessoa (PessoaId INTEGER PRIMARY KEY"
					+ ", Nome VARCHAR(30) NOT NULL, DataNasc VARCHAR(10) NOT NULL)");

			// Compromisso
			stm.executeUpdate("CREATE TABLE IF NOT EXISTS [Compromisso] (CompromissoId INTEGER PRIMARY KEY"
					+ ", PessoaId INTEGER, NomeCompromisso VARCHAR(20) NOT NULL, FOREIGN KEY ([PessoaId]) "
					+ "  REFERENCES [Pessoa] ([PessoaId]))");
			// Dia
			stm.executeUpdate("CREATE TABLE IF NOT EXISTS [Dia] ( DiasId INTEGER PRIMARY KEY"
					+ ", CompromissoId INTEGER, Dia_Semana VARCHAR(7) NOT NULL, HoraInicial VARCHAR(5) NOT NULL"
					+ ", HoraFinal VARCHAR(5) NOT NULL, FOREIGN KEY (CompromissoId)"
					+ "  REFERENCES [Compromisso] ([CompromissoId]) )");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
