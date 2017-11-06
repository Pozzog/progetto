package componenti;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import exceptions.NullException;
import exceptions.ZeroException;

/**
 * @author Donatello Plantone Matr. 635864 20/10/2017
 * 
 *         Classe rappresentante un Sensore
 */
public class Sensore implements Iterable<Rilevazione> {

	/**
	 * Numero identificativo del Sensore
	 */
	private int id;

	/**
	 * Tipologia del Sensore
	 */
	private String tipologia;

	/**
	 * Marca del Sensore
	 */
	private String marca;

	/**
	 * Modello del Sensore
	 */
	private String modello;

	/**
	 * Anno di Produzione
	 */
	private Date anno;

	/**
	 * Lista delle Rilevazioni del singolo Sensore
	 */
	private ArrayList<Rilevazione> listaRilevazioni;

	/**
	 * Restituisce L'ID del Sensore
	 * 
	 * @return id del Sensore
	 */
	public int getID() {
		return this.id;
	}

	/**
	 * Memorizza l'id del Sensore
	 * 
	 * @param ID
	 *            del Sensore
	 * 
	 * @throws ZeroExceptio
	 *             Verificare che il numero immesso sia maggiore di zero
	 */
	public void setID(int ID) throws ZeroException {
		if (id <= 0)
			throw new ZeroException();

		this.id = ID;
	}

	/**
	 * Restituisce la Tipologia del Sensore
	 * 
	 * @return Tipologia del Sensore
	 */
	public String getTipo() {
		return this.tipologia;
	}

	/**
	 * Memorizza la Tipologia del Sensore
	 * 
	 * @param Tipologia
	 *            da memorizzare
	 * 
	 * @throws NullException
	 *             Verifica che la stringa inserita non sia vuota
	 * 
	 */
	public void setTipo(String Tipo) throws NullException {
		if ("".equals(Tipo))
			throw new NullException();

		this.tipologia = Tipo;
	}

	/**
	 * Restituisce la Marca del Sensore
	 * 
	 * @return Marca del Sensore
	 */
	public String getMarca() {
		return this.marca;
	}

	/**
	 * Memorizza la Marca del Sensore
	 * 
	 * @param Marca
	 *            da memorizzare
	 * 
	 * @throws NullException
	 *             Verifica che la stringa inserita non sia vuota
	 * 
	 */
	public void setMarca(String Marca) throws NullException {
		if ("".equals(Marca))
			throw new NullException();

		this.marca = Marca;
	}

	/**
	 * Restituisce Modello del Sensore
	 * 
	 * @return Modello del Sensore
	 */
	public String getModello() {
		return this.modello;
	}

	/**
	 * Memorizza il Modello del Sensore
	 * 
	 * @param Modello
	 *            da memorizzare
	 * 
	 * @throws NullException
	 *             Verifica che la stringa inserita non sia vuota
	 * 
	 */
	public void setModello(String Modello) throws NullException {
		if ("".equals(Modello))
			throw new NullException();

		this.modello = Modello;
	}

	/**
	 * Restituisce l'Anno di produzione del Sensore
	 * 
	 * @return Anno della produzione del Sensore
	 */
	public Date getAnno() {
		return this.anno;
	}

	/**
	 * Memorizza l'Anno di produzione del Sensore
	 * 
	 * @param Anno
	 *            da memorizzare
	 * 
	 * @throws NullException
	 *             Verifica che la stringa inserita non sia vuota
	 * 
	 */
	public void setAnno(Date Anno) throws NullException {
		if (Anno == null)
			throw new NullException();

		this.anno = Anno;
	}

	/**
	 * Costruttore della classe Sensore
	 * 
	 * @param Tipo
	 *            del Sensore
	 * 
	 * @param Marca
	 *            del Sensore
	 * 
	 * @param Modello
	 *            del Sensore
	 * 
	 * @param Anno
	 *            di produzione del Sensore
	 * 
	 * @throws ZeroException
	 *             Verificare che il numero immesso sia maggiore di zero
	 * 
	 * @throws NullException
	 *             Verifica che la stringa inserita non sia vuota
	 */
	public Sensore(String Tipo, String Marca, String Modello, Date Anno) throws NullException {
		if ("".equals(Tipo) || "".equals(Marca) || "".equals(Modello) || Anno == null)
			throw new NullException();
		this.id++;
		this.tipologia = Tipo;
		this.marca = Marca;
		this.modello = Modello;
		this.anno = Anno;
	}

	public Sensore() {
		
	}

	/**
	 * Aggiungere la Rilevazione alla lista delle Rilevazioni
	 * 
	 * @param rilevazione
	 *            da aggiungere
	 * 
	 * @throws NullException
	 *             Verifica che la stringa inserita non sia vuota
	 */
	private void aggiungiRilevazione(Rilevazione rilevazione) throws NullException {
		if (rilevazione == null)
			throw new NullException();

		this.listaRilevazioni.add(rilevazione);
	}

	/**
	 * Restituisce un iteratore per ciclare sulla lista dei Rilevamenti appartenenti
	 * al Sensore
	 * 
	 * @return Iterator della lista
	 */
	@Override
	public Iterator<Rilevazione> iterator() {
		return this.listaRilevazioni.iterator();
	}

}