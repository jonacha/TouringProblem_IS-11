package es.deusto.ingenieria.is.search.touring.formulacion;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import es.deusto.ingenieria.is.search.formulation.State;
import es.deusto.ingenieria.is.search.xml.StateXMLReader;

public class EntornoXMLReader extends StateXMLReader {

	private double posX;
	private double posY;
	private String nombre;
	private int cities; 
	private Entorno entorno;

	private ArrayList<Ciudad> aCiudades;

	public EntornoXMLReader(String xmlFile) {
		super(xmlFile);
	}

	@Override
	/**
	 * Insertamos en cada ciudad una lista con las las ciudades a las que puede ir, en principio todas menos a s� misma o la inicial que 
	 * al principio ser� tambien la ciudad actual.
	 */
	public State getState() 
	{ 
		entorno.setCiudades(aCiudades);
		ArrayList<Ciudad> apoyoCiudades=new ArrayList<Ciudad>();
		Ciudad apoyoCiudad=new Ciudad();
		for(int j=0;j<aCiudades.size();j++){
			apoyoCiudad=aCiudades.get(j);
			for(int i = 0; i < aCiudades.size(); i++)
			{
				if(!aCiudades.get(i).getNombre().equals(apoyoCiudad.getNombre())){
					apoyoCiudades.add(aCiudades.get(i));
				}

			}
			apoyoCiudades.add(entorno.getFin());
			entorno.getCiudades().get(j).setCiudadesPosibles(aCiudades);
		}
		return entorno;
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {


		try {	
			if (qName.equals("is:map")) {
				aCiudades = new ArrayList<Ciudad>();
				entorno = new Entorno();
				this.setCities(Integer.parseInt(attributes.getValue("cities")));
			}  else if (qName.equals("is:start") ){ 
				this.nombre = attributes.getValue("nombre");
				this.posX = Double.parseDouble(attributes.getValue("x"));
				this.posY = Double.parseDouble(attributes.getValue("y"));
				entorno.setInicio(new Ciudad(posX,posY,nombre));
				entorno.setActual(new Ciudad(posX,posY,nombre));
			} 
			else if (qName.equals("is:end") ){ 
				this.nombre = attributes.getValue("nombre");
				this.posX = Double.parseDouble(attributes.getValue("x"));
				this.posY = Double.parseDouble(attributes.getValue("y"));
				entorno.setFin(new Ciudad(posX,posY,nombre));

			} 
			else if (qName.equals("is:ciudad")) { 
				this.nombre = attributes.getValue("nombre");
				this.posX = Double.parseDouble(attributes.getValue("x"));
				this.posY = Double.parseDouble(attributes.getValue("y"));
				aCiudades.add(new Ciudad(posX,posY,nombre));
			} 

		} catch (Exception ex) {
			System.out.println(this.getClass().getName() + ".startElement(): " + ex);
		}

	}

	public int getCities() {
		return cities;
	}

	public void setCities(int cities) {
		this.cities = cities;
	}
}