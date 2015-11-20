package POO_AgendaDigital.Infraestrutura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import POO_AgendaDigital.Core.Compromisso;
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
			stm.executeUpdate("INSERT INTO Pessoa (Nome, DataNasc, Idade) " + "VALUES ('" + pessoa.getNome() + "', '"
					+ pessoa.getDataNascimento() + "', " + pessoa.getIdade() + ")");
			// stm.cancel();
		} catch (Exception e) {
			e.printStackTrace();
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
				auxPessoas.add(new Pessoa(rs.getInt("PessoaId"), rs.getString("Nome"), rs.getInt("Idade"),
						rs.getString("DataNasc")));
			}
			rs.close();

		} catch (Exception e) {
			// TODO: handle exception
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
					return new Pessoa(rs.getInt("PessoaId"), rs.getString("Nome"), rs.getInt("Idade"),
							rs.getString("DataNasc"));
				}
				auxIndex++;
			}
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Pessoa getPessoaByName(String Name) {
		ResultSet rs;
		try {
			stm = conn.createStatement();
			rs = stm.executeQuery("SELECT * FROM Pessoa WHERE Pessoa.Nome='" + Name + "'");
			while (rs.next()) {
				return new Pessoa(rs.getInt("PessoaId"), rs.getString("Nome"), rs.getInt("Idade"),
						rs.getString("DataNasc"));
			}
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			stm.executeUpdate(
					"INSERT INTO [Compromisso](CompromissoId, PessoaId, NomeCompromisso, Dias, HoraInicial, HoraFinal) "
							+ "VALUES (" + Compromisso.getCompromissoId() + ", " + Compromisso.getPessoaId() + ", '"
							+ Compromisso.getNomeCompromisso() + "', " + Compromisso.getDias() + ", '"
							+ Compromisso.getHoraInicial() + "', '" + Compromisso.getHoraFinal() + "')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 */

	public static void updatePessoa(int Id, Pessoa Pessoa) {
		try {
			stm = conn.createStatement();
			stm.executeUpdate("UPDATE [Pessoa] SET Nome = '" + Pessoa.getNome() + "', Idade = " + Pessoa.getIdade()
					+ ", DataNasc = '" + Pessoa.getDataNascimento() + "' WHERE Pessoa.PessoaId = " + Id + "");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static ArrayList<Compromisso> getCompromissoSegunda() {
		ArrayList<Compromisso> compromissosSeg = new ArrayList<Compromisso>();
		int cont = 0;
		ResultSet rs;
		try {
			stm = conn.createStatement();
			rs = stm.executeQuery("SELECT * FROM [Compromisso] AS c INNER JOIN Pessoa AS p ON c.PessoaId = p.PessoaId");

			while (rs.next()) {
				compromissosSeg.add(cont, new Compromisso(rs.getInt("CompromissoId"), rs.getInt("PessoaId"),
						rs.getString("NomeCompromisso"), rs.getInt("Dias"), rs.getString("HoraInicial"), rs.getString("HoraFinal")));

			}
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return compromissosSeg;
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
			// stm = conn.createStatement();
			rs = stm.executeQuery("SELECT COUNT(Pessoa.PessoaId) AS qtdePessoas FROM [Pessoa]");
			qtdePessoas = rs.getInt("qtdePessoas");

			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return qtdePessoas;
	}

	private void createTables() {
		try {
			stm = conn.createStatement();

			// Pessoa
			stm.executeUpdate("CREATE TABLE IF NOT EXISTS Pessoa (PessoaId INTEGER PRIMARY KEY"
					+ ", Nome VARCHAR(30) NOT NULL, DataNasc VARCHAR(10) NOT NULL, Idade INTEGER NOT NULL)");

			// Compromisso
			stm.executeUpdate("CREATE TABLE IF NOT EXISTS [Compromisso] (CompromissoId INTEGER PRIMARY KEY"
					+ ", PessoaId INTEGER, NomeCompromisso VARCHAR(20) NOT NULL, Dias INTEGER NOT NULL"
					+ ", HoraInicial VARCHAR(5) NOT NULL, HoraFinal VARCHAR(5) NOT NULL" + ", FOREIGN KEY ([PessoaId]) "
					+ "  REFERENCES [Pessoa] ([PessoaId]))");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
