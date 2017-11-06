package componenti;

import java.util.ArrayList;
import java.util.Iterator;

import exceptions.NullException;
import exceptions.ZeroException;

/**
 * @author Donatello Plantone Matr. 635864 20/10/2017
 * 
 *         Classe rappresentante un Ambiente
 */
public class Ambiente implements Iterable<Sensore> {

	/**
	 * Numero identificativo dell'Ambiente
	 */
	public int id;
	
	/**
	 * Nome da associare all'Ambiente
	 */
	public String nome;
	
	/**
	 * Tipologia dell'Ambiente
	 */
	public String tipologia;
	
	/**
	 * Luogo in cui � situato l'Ambiente
	 */
	public String ubicazione;
	
	/**
	 * Numero dei Sensori presenti nell'Ambiente
	 */
	public int numeroSensori;
	
	/**
	 * Lista contenente i Sensori presenti nell'Ambiente relativo
	 */
	public ArrayList<Sensore> listaSensori;

	/**
	 * Restituisce L'ID dell'Ambiente
	 * 
	 * @return id dell'Ambiente
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Memorizza l'id del Ambiente
	 * 
	 * @param ID
	 *            da memorizzare
	 * 
	 * @throws ZeroExceptio
	 *             Verificare che il numero immesso sia maggiore di zero
	 * 
	 */
	public void setId(int Id) throws ZeroException {
		if (Id <= 0)
			new ZeroException();

		this.id = Id;
	}

	/**
	 * Restituisce il Nome dell'Ambiente
	 * 
	 * @return Nome dell'Ambiente
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Memorizza il Nome dell'Ambiente
	 * 
	 * @param Nome
	 *            da memorizzare
	 * 
	 * @throws NullException
	 *             Verifica che la stringa inserita non sia vuota
	 */
	public void setNome(String Nome) throws NullException {
		if ("".equals(Nome))
			new NullException();

		this.nome = Nome;
	}

	/**
	 * Restituisce la tipologia dell'Ambiente
	 * 
	 * @return Tipo dell'Ambiente
	 */
	public String getTipo() {
		return this.tipologia;
	}

	/**
	 * Memorizza la Tipologia dell'Ambiente
	 * 
	 * @param Tipo
	 *            da memorizzare
	 * 
	 * @throws NullException
	 *             Verifica che la stringa inserita non sia vuota
	 */
	public void setTipo(String Tipo) throws NullException {
		if ("".equals(Tipo))
			throw new NullException();

		this.tipologia = Tipo;
	}

	/**
	 * Restituisce l'Ubicazione dell'Ambiente
	 * 
	 * @return Ubicazione dell'Ambiente
	 */
	public String getUbicazione() {
		return this.ubicazione;
	}

	/**
	 * Memorizza il luogo dov'� situato l'Ambiente
	 * 
	 * @param Ubicazione
	 *            dell'Ambiente
	 * 
	 * @throws NullException
	 *             Verifica che la stringa inserita non sia vuota
	 */
	public void setUbicazione(String Ubicazione) throws NullException {
		if ("".equals(Ubicazione))
			throw new NullException();

		this.ubicazione = Ubicazione;
	}

	/**
	 * Restituisce il Numero di sensori presenti nell'Ambiente
	 * 
	 * @return Numero di sensori presenti nell'Ambiente
	 */
	public int getNumeroSensori() {
		return this.numeroSensori;
	}

	/**
	 * Memorizza il numero dei Sensori presenti nell'Ambiente
	 * 
	 * @param numero
	 *            di sensori prensenti nel dato Ambiente
	 * 
	 * @throws ZeroException
	 *             Verificare che il numero immesso sia maggiore di zero
	 * 
	 */
	public void setNumeroSensori(int numeroSensori) throws ZeroException {
		if (numeroSensori <= 0)
			throw new ZeroException();

		this.numeroSensori = numeroSensori;
	}
	
	public Ambiente() {
		
	}

	/**
	 * Costruttore della classe Ambiente
	 * 
	 * @param nome
	 *            dell'Ambiente
	 * 
	 * @param tipologia
	 *            dell'Ambiente
	 * 
	 * @param ubicazione
	 *            dell'Ambiente
	 * 
	 * @param numeroSensori
	 *            presenti nell'Ambienti
	 * 
	 * @throws ZeroException
	 *             Verificare che il numero immesso sia maggiore di zero
	 * 
	 * @throws NullException
	 *             Verifica che la stringa inserita non sia vuota
	 */
	public Ambiente(String nome, String tipo, String ubicazione, int numeroSensori)
			throws ZeroException, NullException {
		if ("".equals(nome) || "".equals(tipo) || "".equals(ubicazione))
			throw new NullException();
		else if (numeroSensori <= 0)
			throw new ZeroException();

		this.nome = nome;
		this.tipologia = tipo;
		this.ubicazione = ubicazione;
		this.numeroSensori = numeroSensori;
	}

	/**
	 * Aggiungere un Sensore alla lista dei sensori presenti nell'Ambiente
	 * 
	 * @param sensore
	 *            da aggiungere alla lista
	 * 
	 * @throws NullException
	 *             Verifica che la stringa inserita non sia vuota
	 */
	private void aggiungiSensore(Sensore sensore) throws NullException {
		if (sensore == null)
			throw new NullException();

		this.listaSensori.add(sensore);
	}

	/**
	 * Eliminare un Sensore dalla lista dei sensori presenti nell'Ambiente
	 * 
	 * @param sensore
	 *            de rimuovere dalla lista
	 * 
	 * @throws NullException
	 *             Verifica che la stringa inserita non sia vuota
	 */
	private void rimuoviSensore(Sensore sensore) throws NullException {
		if (sensore == null)
			throw new NullException();

		this.listaSensori.remove(sensore);
	}

	/**
	 * Restituisce un iteratore per ciclare sulla lista dei sensori appartenenti
	 * all'ambiente
	 * 
	 * @return Iterator della lista
	 */
	@Override
	public Iterator<Sensore> iterator() {
		return this.listaSensori.iterator();
	}

}