package model;

import java.util.ArrayList;

public class Viewer implements Comparable<Viewer>{

	
	/**
	 * Atributos
	 */
	/**
	 * Identificación del espectador. 
	 */
	private String id;
	/**
	 *Primer nombre del espectador
	 */
	private String first_name;
	/**
	 *Apellido del espectador.	 
	 */
	private String last_name;
	/**
	 * Email del espectador.
	 */
	private String email;
	/**
	 * Genero del espectador.
	 */
	private String gender;
	/**
	 * Ciudad del espectador.
	 */
	private String country;
	/**
	 * Ruta de la foto del espectador.
	 */
	private String photo;
	/**
	 * Cumpleaños del espectador.
	 */
	private String birthday;
	/**
	 * Espectador ubicado en la parte derecha, cuyo nodo inicial es este.
	 */
	private Viewer rightViewer;
	/**
	 * Espectador ubicado en la parte izquierda, cuyo nodo inicial es este.
	 */
	private Viewer leftViewer;
	
	
	
	/**
	 * @param id identificación del espectador.
	 * @param first_name primer nombre del espectador.
	 * @param last_name apellido del espectador.
	 * @param email email del espectador
	 * @param gender genero del particiante. Masculino - Femenino.
	 * @param country ciudad del espectador.
	 * @param photo dirección en donde se encuentra la foto.
	 * @param birthday cumpleaños del espectador.
	 */
	public Viewer(String id, String first_name, String last_name, String email, String gender, String country,
			String photo, String birthday) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.photo = photo;
		this.birthday = birthday;
	}
	
	/**
	 * Metodos
	 */
	
	/**
	 * Inserta un nuevo espectador al arbol que comienza en este nodo.
	 * @param viewer el el nuevo espectador que se va a insertar - viewer != null
	 */ 
	public void add(Viewer viewer) {
		if(this.compareTo(viewer) <= 0) {
			if(rightViewer == null) {
				rightViewer = viewer;
			}else {
				rightViewer.add(viewer);
			}
		}else {
			if(leftViewer == null) {
				leftViewer = viewer;
			}else {
				leftViewer.add(viewer);
			}
		}
	}
	
	/**
	 * Busca un espectador en el arbol binario de busqueda.
	 */
	public Viewer search(String id) {
		if(this.id.compareToIgnoreCase(id) == 0) {
			return this;
		}else if(this.id.compareToIgnoreCase(id) > 0){
			return leftViewer.search(id);
		}else {
			return rightViewer.search(id);
		}
	}
	
	
	/**
	 * Retorna el id del espectador.
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * Cambia el id del espectador.
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Retorna el nombre del espectador
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * Cambia el nombre del espectador
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * Retorna el apellido del espectador
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * Cambia el apellido del espectador
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	/**
	 * Retorna el email del espectador.
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Cambia el email del espectador.
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Retorna el genero del espectador.
	 * Masculino o Femenino.
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * Cambia el genero del espectador.
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * Retorna la ciudad del del espectador
	 * @return the country ciudad del espectador
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * Cambia la ciudad del espectador
	 * @param country the country to set 
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * Retorna la foto del espectador.
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}
	/**
	 * Cambia la foto del espectador.
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	/**
	 * Retorna el cumpleaños del espectador
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * Cambia el cumpleaños del espectador
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * Retorna el nodo ubicado al lad o derecho de este.
	 * @return the rightViewer
	 */
	public Viewer getRightViewer() {
		return rightViewer;
	}

	/**
	 * Cambia el nodo ubicado al lado derecho de este nodo.
	 * @param rightViewer the rightViewer to set
	 */
	public void setRightViewer(Viewer rightViewer) {
		this.rightViewer = rightViewer;
	}

	/**
	 * Retorna el nodo ubicado al lado derecho de este nodo.
	 * @return the leftViewer
	 */
	public Viewer getLeftViewer() {
		return leftViewer;
	}

	/**
	 * Cambia el nodo ubicado al lado derecho de este nodo.
	 * @param leftViewer the leftViewer to set
	 */
	public void setLeftViewer(Viewer leftViewer) {
		this.leftViewer = leftViewer;
	}

	@Override
	public int compareTo(Viewer viewer) {
		int value = -1;
		if(this.id.compareTo( viewer.id ) == 0) {
			value = 0;
		}else if(this.id.compareTo( viewer.id ) > 0 ){
			value = 1;
		}
		return value;
	}

	
	public void inorder(ArrayList<Viewer> s) {
		if(leftViewer != null) {
			leftViewer.inorder(s);
		}
		s.add(this);
		if(rightViewer != null) {
			rightViewer.inorder(s);
		}
	}

	
	public void preOrder(ArrayList<Viewer> s) {
		s.add(this);
		if(leftViewer != null) {
			leftViewer.inorder(s);
		}
		if(rightViewer != null) {
			rightViewer.inorder(s);
		}
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
	
	public void remove() {
	    if (leftViewer != null) {
	      leftViewer.remove();
	      leftViewer = null;
	    }
	    if (rightViewer!= null) {
	    	rightViewer.remove();
	    	rightViewer = null;
	    }
	}
	
	
	
}
