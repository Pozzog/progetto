package componenti;

import exceptions.NullException;
import exceptions.ZeroException;

/**
 * @author Donatello Plantone Matr. 635864 20/10/2017
 * 
 *         Classe rappresentante una Rilevazione
 */
public class Rilevazione {

	/**
	 * numero identificativo della Rilevazione
	 */
	private int id;

	/**
	 * Messaggio della Rilevazione del Sensore
	 */
	private String messaggio;

	/**
	 * Descrizione del Messaggio della Rilevazione
	 */
	private String descrizione;

	/**
	 * Restituisce L'ID della Rilevazione
	 * 
	 * @return id del Rilevazione
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Memorizza l'id della Rilevazione
	 * 
	 * @param ID
	 *            da memorizzare
	 * 
	 * @throws ZeroExceptio
	 *             Verificare che il numero immesso sia maggiore di zero
	 * 
	 */
	public void setId(int id) throws ZeroException {
		if (id <= 0)
			throw new ZeroException();

		this.id = id;
	}

	/**
	 * Restituisce il Messaggio correlato alla Rilevazione
	 * 
	 * @return Messaggio della rilevazione
	 */
	public String getMessaggio() {
		return this.messaggio;
	}

	/**
	 * Memorizza il Messaggio della Rilevazione
	 * 
	 * @param Messaggio
	 *            da memorizzare
	 * 
	 * @throws NullException
	 *             Verifica che la stringa inserita non sia vuota
	 * 
	 */
	public void setMessaggio(String messaggio) throws NullException {
		if ("".equals(messaggio))
			throw new NullException();
		this.messaggio = messaggio;
	}

	/**
	 * Restituisce la Descrizione del Messaggio della Rilevazione
	 * 
	 * @return Descrizione della Rilevazione
	 */
	public String getDescrizione() {
		return this.descrizione;
	}

	/**
	 * Memorizza la Descrizione del Messaggio della Rilevazione
	 * 
	 * @param Descrizione
	 *            da memorizzare
	 * 
	 * @throws NullException
	 *             Verifica che la stringa inserita non sia vuota
	 * 
	 */
	public void setDescrizione(String descrizione) throws NullException {
		if ("".equals(descrizione))
			throw new NullException();

		this.descrizione = descrizione;
	}

	/**
	 * Costruttore della classe Rilevazione
	 * 
	 * @param Messaggio
	 *            da Memorizzare della Rilevazione
	 * 
	 * @param Descrizione
	 *            della Rilevazione
	 * 
	 * @throws NullException
	 *             Verifica che la stringa inserita non sia vuota
	 * 
	 */
	public Rilevazione(String messaggio, String descrizione) throws NullException {
		if ("".equals(messaggio) || "".equals(descrizione))
			throw new NullException();

		this.id++;
		this.descrizione = descrizione;
		this.messaggio = messaggio;
	}

	public Rilevazione() {
	}

}