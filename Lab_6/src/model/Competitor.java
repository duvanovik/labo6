package model;

public class Competitor implements Comparable<Competitor>{
	/**
	 * Atributos
	 */
	/**
	 * Identificación de un participante. 
	 */
	private String id;
	/**
	 *Primer nombre del participante
	 */
	private String first_name;
	/**
	 *Apellido de un participante.	 
	 */
	private String last_name;
	/**
	 * Email del participante.
	 */
	private String email;
	/**
	 * Genero del participante.
	 */
	private String gender;
	/**
	 * Ciudad del participante.
	 */
	private String country;
	/**
	 * Ruta de la foto del participante.
	 */
	private String photo;
	/**
	 * Cumpleaños del participante.
	 */
	private String birthday;
	/**
	 * Siguiente participante.
	 */
	private Competitor nextCompetitor;
	/**
	 * Anterior participante.
	 */
	private Competitor previusCompetitor;
	
	
	
	
	
	/**
	 * @param id identificación del participante.
	 * @param first_name primer nombre del participante.
	 * @param last_name apellido del participante.
	 * @param email email del participante
	 * @param gender genero del particiante. Masculino - Femenino.
	 * @param country ciudad del participante.
	 * @param photo dirección en donde se encuentra la foto.
	 * @param birthday cumpleaños del participante.
	 */
	public Competitor(String id, String first_name, String last_name, String email, String gender, String country,
			String photo, String birthday) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.photo = photo;
		this.birthday = birthday;
		this.previusCompetitor = null;
		this.nextCompetitor = null;
	}
	
	public Competitor() {
	}

	/**
	 * Metodos
	 */
	/**
	 * Retorna el id del participante.
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * Cambia el id del participante.
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Retorna el nombre del participante
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * Cambia el nombre del participante
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * Retorna el apellido del participante
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * Cambia el apellido del participante
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	/**
	 * Retorna el email del participante.
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Cambia el email del participante.
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Retorna el genero del participante.
	 * Masculino o Femenino.
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * Cambia el genero del participante.
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * Retorna la ciudad del del participante
	 * @return the country ciudad del participante
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * Cambia la ciudad del participante
	 * @param country the country to set 
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * Retorna la foto del participante.
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}
	/**
	 * Cambia la foto del participante.
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	/**
	 * Retorna el cumpleaños del participante
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * Cambia el cumpleaños del participante
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * Retorna el competidor siguiente de este competidor.
	 * @return the nextCompetitor
	 */
	public Competitor getNextCompetitor() {
		return nextCompetitor;
	}

	/**
	 * Cambia al competidor siguiente, competidor actual estes this != null
	 * @param nextCompetitor the nextCompetitor to set
	 */
	public void setNextCompetitor(Competitor nextCompetitor) {
		this.nextCompetitor = nextCompetitor;
	}

	/**
	 * Retorna el jugador anterior de este competidor.
	 * @return the previusCompetitor
	 */
	public Competitor getPreviusCompetitor() {
		return previusCompetitor;
	}

	/**
	 * Cambia el jugador anterior de este competidor.
	 * @param previusCompetitor the previusCompetitor to set
	 */
	public void setPreviusCompetitor(Competitor previusCompetitor) {
		this.previusCompetitor = previusCompetitor;
	}
	
	
	@Override
	public String toString() {
		return "id=" + id + "\n"
				+ "first_name=" + first_name +"\n"
				+"last_name=" + last_name +"\n"
				+"email=" + email +"\n"
				+"gender=" + gender +"\n"
				+"country=" + country +"\n"
				+"birthday=" + birthday +"\n"
				;
	}
	
	
	@Override
	public int compareTo(Competitor o) {
		return this.country.compareToIgnoreCase(o.country);
	}
	
	
	
	
	
	
	
	
	
	
	
}
