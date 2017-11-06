package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import componenti.Ambiente;
import componenti.Rilevazione;
import componenti.Sensore;
import componenti.UserAccount;
import exceptions.NullException;
import exceptions.ZeroException;

public class DBUtils {

	public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException {
		
		String sql = "SELECT a.Nome_Utente, a.Password FROM Utente a" + " WHERE a.Nome_utente = ? AND a.Password = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();
		
		if(rs.next()) {
			
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			return user;
		}
		return null;
	}
	
	public static UserAccount findUser(Connection conn, String userName) throws SQLException {
		
		String sql = "SELECT a.Nome_utente, a.Password FROM Utente a " + " WHERE a.Nome_Utente = ? ";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1,  userName);
		
		ResultSet rs = pstm.executeQuery();
		
		if(rs.next()) {
			
			String password = rs.getString("Password");
			
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			return user;
		}
		return null;
	}
	
	public static ArrayList<Ambiente> queryAmbienti(Connection conn, String name) throws SQLException, ZeroException, NullException {
				
		String sql = "SELECT a.ID, a.Nome, a.TipologiaA, a.Ubicazione, a.numeroSensori FROM Ambiente a INNER JOIN Utente u WHERE A.id = u.AmbienteID AND Nome_Utente = '" + name + "'";
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		ResultSet rs = pstm.executeQuery();
		
		ArrayList<Ambiente> ambienti = new ArrayList<Ambiente>();
		
		while(rs.next()) {
			
			int id = rs.getInt("ID");
			String nome = rs.getString("Nome");
			String tipologia = rs.getString("TipologiaA");
			String ubicazione = rs.getString("Ubicazione");
			int n_Sens = rs.getInt("NumeroSensori");
			
			Ambiente ambiente = new Ambiente();
			
			ambiente.setId(id);
			ambiente.setNome(nome);
			ambiente.setTipo(tipologia);
			ambiente.setUbicazione(ubicazione);
			ambiente.setNumeroSensori(n_Sens);
			
			ambienti.add(ambiente);
		}
		return ambienti;
	}
	
	public static Ambiente findAmbiente(Connection conn, int Id) throws SQLException, ZeroException, NullException {
		
		String sql = "SELECT a.ID, a.Nome, a.TipologiaA, a.Ubicazione, a.numSensori WHERE a.Id = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, Id);
		
		ResultSet rs = pstm.executeQuery();
		
		while(rs.next()) {
			
			String nome = rs.getString("Nome");
			String tipologia = rs.getString("TipologiaA");
			String ubicazione = rs.getString("Ubicazione");
			int n_Sens = rs.getInt("NumSensori");
			
			Ambiente ambiente = new Ambiente(nome, tipologia, ubicazione, n_Sens);
			
			return ambiente;
		}
		return null;
	}

	public static ArrayList<Sensore> querySensori(Connection conn, String ambID) throws SQLException, ZeroException, NullException {
		
		String sql = "SELECT s.Cod, s.Modello, s.Marca, s.TipologiaS, s.Anno FROM Sensore s JOIN Ambiente a WHERE a.ID = s.Ambiente AND s.Ambiente = '" + ambID + "'";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		ResultSet rs = pstm.executeQuery();
		
		ArrayList<Sensore> sensori = new ArrayList<Sensore>();
		
		while(rs.next()) {
			
			int id = rs.getInt("ID");
			String mod = rs.getString("Modello");
			String marca = rs.getString("Marca");
			String tipologia = rs.getString("TipologiaS");
			Date anno = rs.getDate("Anno");
			
			Sensore sensore = new Sensore();
			
			sensore.setID(id);
			sensore.setModello(mod);
			sensore.setMarca(marca);
			sensore.setTipo(tipologia);
			sensore.setAnno(anno);
			
			sensori.add(sensore);
		}
		return sensori;
	}
	
	public static Sensore findSensore(Connection conn, String Id) throws SQLException, ZeroException, NullException {
		
		String sql = "SELECT s.ID, s.Modello, s.Marca, s.TipologiaS, s.Anno WHERE s.Id = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, Id);
		
		ResultSet rs = pstm.executeQuery();
		
		while(rs.next()) {
			
			String mod = rs.getString("Modello");
			String marca = rs.getString("Marca");
			String tipologia = rs.getString("TipologiaS");
			Date anno = rs.getDate("Anno");
			
			Sensore sensore = new Sensore(mod, marca, tipologia, anno);
			
			return sensore;
		}
		return null;
	}

	public static ArrayList<Rilevazione> queryRilevazioni(Connection conn, String sensID) throws SQLException, NullException, ZeroException {
		
		String sql = "SELECT r.ID, r.Messaggio. r.Descrizione FROM Rilevazioni r JOIN Sensori s WHERE s.Sensore = r.ID AND s.Sensore = '" + sensID + "'";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		ResultSet rs = pstm.executeQuery();
		
		ArrayList<Rilevazione> rilevazioni = new ArrayList<Rilevazione>();
		
		while(rs.next()) {
			
			int id = rs.getInt("ID");
			String msg = rs.getString("Messaggio");
			String descr = rs.getString("Descrizione");
			
			Rilevazione rilevazione = new Rilevazione();
			
			rilevazione.setId(id);
			rilevazione.setMessaggio(msg);
			rilevazione.setDescrizione(descr);
			
			rilevazioni.add(rilevazione);
		}
		return rilevazioni;
	}

	public static Rilevazione findRilevazione(Connection conn, String Id) throws SQLException, ZeroException, NullException {
	
		String sql = "SELECT r.ID, r.Messaggio. r.Descrizione FROM Rilevazioni WHERE r.Id = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, Id);
	
		ResultSet rs = pstm.executeQuery();
	
		while(rs.next()) {
		
			String msg = rs.getString("Messaggio");
			String descr = rs.getString("Descrizione");
		
			Rilevazione Rilevazione = new Rilevazione(msg, descr);
		
			return Rilevazione;
		}
		return null;
	}

	public static ArrayList<Rilevazione> querySintesi(Connection conn, String ambID) throws SQLException, ZeroException, NullException {

		//modificare con il join tra rilevazioni sensori e ambiente
		String sql = "SELECT r.ID, r.Messaggio. r.Descrizione FROM Rilevazioni r JOIN Sensori s WHERE s.Sensore = r.ID AND s.Sensore = '" + ambID + "'";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		ResultSet rs = pstm.executeQuery();
		
		ArrayList<Rilevazione> rilevazioni = new ArrayList<Rilevazione>();
		
		while(rs.next()) {
			
			int id = rs.getInt("ID");
			String msg = rs.getString("Messaggio");
			String descr = rs.getString("Descrizione");
			
			Rilevazione rilevazione = new Rilevazione();
			
			rilevazione.setId(id);
			rilevazione.setMessaggio(msg);
			rilevazione.setDescrizione(descr);
			
			rilevazioni.add(rilevazione);
		}
		return rilevazioni;
	}
}
