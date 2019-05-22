package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Event {
	/**
	 * Atributos
	 */
	/**
	 * Nombre del evento.
	 */
	private String name;
	/**
	 * Primer participante del evento.
	 */
	private Competitor first;
	/**
	 * Ultimo participante del evento;
	 */
	private Competitor last;
	/**
	 * Espectador raiz del arbol.
	 */
	private Viewer root;
	/**
	 * Tiempo en cargar os datos.
	 */
	private Long timeLoadViewer;
	
	private int contador = 0;
	
	private Viewer root2;
	
	
	/**
	 * CONSTRUCTOR.
	 * @param name nombre del evento.
	 */
	public Event(String name) {
		this.name = name;
		this.first = null;
		this.last = null;
		this.root = null;
	}
	

		
	/**
	 *Retorna el nombre del evento.
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 *Cambia el nombre del evento.
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Agrega un espectador al arbol de espectadores.
	 */
	public void addViewer(Viewer viewer) {
		if(root == null) {
			root = viewer;
		}else {
			root.add(viewer);
		}
	}
	/**
	 * Agregar un participante a la lista.
	 */
	public void addCompetitor(Competitor competitor) {
		if(first == null) {
			first = competitor;
			last = first;
		}else {
			last.setNextCompetitor(competitor);
			competitor.setPreviusCompetitor(last);
			last = competitor;
		}
		System.out.println(last.getCountry());
		System.out.println(contador++);
		
	}
	
	
	/**
	 *Carga los datos y los agrega al arbol de espectadores.
	 *@param data la dirección en donde se encuentra los datos.
	 * @throws IOException 
	 */
	public void loadViewer(File file) throws IOException {
		long startTime = System.currentTimeMillis();
		FileReader fi = new FileReader(file);
		BufferedReader bf = new BufferedReader(fi);
		String lector = bf.readLine();
		while(lector != null) {
			String [] date = lector.split(",");
			String id = date[0];
			String first_name = date[1];
			String last_name = date[2];
			String email = date[3];
			String gender = date[4];
			String country = date[5];
			String photo = date[6];
			String birthday = date[7]; 
			// Crea un objeto de tipo Viewer.
			Viewer viewer = new Viewer(id, first_name, last_name, email, gender, country, photo, birthday);
			this.addViewer(viewer);
			
			lector = bf.readLine();
		}
		fi.close();
		bf.close();
		timeLoadViewer = System.currentTimeMillis() - startTime ;
		
		
	}
	/**
	 * Permite añadir a la lista de participantes la mitad de los Espectadores de forma aleatoria.
	 * 
	 */
	public void addToListCompetitor() {
		ArrayList<Viewer> array =inorder();
		for (int i = 0; i < array.size()/2; i++) {
			int indice = (int) Math.floor(Math.random()*(inorder().size()));
			String id = array.get(indice).getId();
			String first_name = array.get(indice).getFirst_name();
			String last_name = array.get(indice).getLast_name();
			String email = array.get(indice).getEmail();
			String gender = array.get(indice).getGender();
			String country = array.get(indice).getCountry();
			String photo = array.get(indice).getPhoto();
			String birthday = array.get(indice).getBirthday(); 
			//Crea un objeto de tipo Competitor.
			Competitor competitor = new Competitor(id, first_name, last_name, email, gender, country, photo, birthday);
			this.addCompetitor(competitor);
		}
	}
	
	
	/**
	 * Retorna una estructura contenedora con todos los elementos del arbol. 
	 * @return un arraylist de los elementos del arbol en inorden
	 */
	public ArrayList<Viewer> inorder() {
		ArrayList<Viewer> s = new ArrayList<Viewer>();
		if(root != null) {
			root.inorder(s);
		}
		return s;
	}
	
	
	/**
	 * Permite buscar a un espectador en el arbol de manera recursiva.
	 * @param id Identificación del espectador.
	 * @return el espectador si lo encuentra de lo contrario retorna null.
	 */
	public Viewer searchViewer(String id) {
		return root.search(id);
	}
	
	
	/**
	 * Permite buscar a un participante en la lista doble enlazada.
	 */
	public Competitor searchCompetitor(String id) {
		Competitor competitor = null;
		boolean found = false;
		if(first == null) {
			competitor = null;
		}else {
			Competitor current = first;
			while(current != null && !found) {
			
				if(current.getId().equalsIgnoreCase(id)) {
					competitor = current;
					found = true;
				}
					current = current.getNextCompetitor();
			}
		}
		
		return competitor;
		
	}



	/**
	 * Retorna el tiempo que se demora cargar los datos del espectadores.
	 * @return the timeLoadViewer
	 */
	public Long getTimeLoadViewer() {
		return timeLoadViewer;
	}

	/**
	 * Retorna el tamahno de la lista doblemente enlazada de participantes.
	 * @return	el tamahno de participantes.
	 */
	public int competitorSize() {
		int size = 0;
		if(first == null) {
			size = 0;
		}else {
			Competitor current = first;
			while(current != null) {
				size++;
				current.getNextCompetitor();
			}
		}
		return size;
	}

	/**
	 * Permite buscar a un participante en la lista
	 * @param name nombre de la ciudad que se desea buscar
	 * @return contenedora con las participantes con las mismas ciudades.
	 * @throws EmptyDateException
	 */
	public ArrayList<Competitor> searchCompetitorByCountry(String name) throws EmptyDateException {
		ArrayList<Competitor> competidors = new ArrayList<Competitor>();
	
		if(first == null) {
			throw new EmptyDateException("La lista se encuentra vacia.");
		}else {
			Competitor toComparate = new Competitor();
			toComparate.setCountry(name);
			Competitor current = first;
			while(current != null) {
				if(current.compareTo(toComparate) == 0) {
					competidors.add(current);
				}
				current = current.getNextCompetitor();
			}
		}
		return competidors;
	}
	
	/**
	 * Permite buscar en el arbol los nodos con el mismo pais
	 * @param name
	 * @return
	 * @throws EmptyDateException
	 */
	private ArrayList<Viewer> searchByViewerByCountry(String name) throws EmptyDateException{
		ArrayList<Viewer> inorder = inorder();
		ArrayList<Viewer> viewers = new ArrayList<Viewer>();
		
		if(root == null) {
			throw new EmptyDateException("el arbol se encuentra vacio.");
		}else {
			int i = 0;
			while (i < inorder.size()) {
				if(inorder().get(i).getCountry().compareToIgnoreCase(name) == 0) {
					viewers.add(inorder.get(i));
				}
				i++;
			}
		}
		return viewers;
	}
	
	
	/**
	 * Reconstruye el arbol pero solo con los datos que tengan el mismo pais.
	 * @throws EmptyDateException 
	 */
	public ArrayList<Viewer> addViewerFromTheSameCountry(String name) throws EmptyDateException {
		ArrayList<Viewer> viewer = searchByViewerByCountry(name);
		if(root2 == null) {
			root2 = viewer.get(0);
		}else {
			for (int i = 0; i < viewer.size(); i++) {
				root2.add(viewer.get(i));
			}
		}
			root2.preOrder(viewer);
		return viewer;
	}



	/**
	 * @return the root
	 */
	public Viewer getRoot() {
		return root;
	}
	
	
	
	
	
}
