package es.deusto.ingenieria.is.search.touring.formulacion;

import java.util.ArrayList;

import es.deusto.ingenieria.is.search.formulation.State;

public class Entorno extends State implements Cloneable{
	private Ciudad inicio = new Ciudad();
	private Ciudad fin = new Ciudad();
	private Ciudad actual = new Ciudad();
	private double distanciaTotal = 0;

	private  ArrayList <Ciudad>aCiudades=new ArrayList<Ciudad>();
	private ArrayList<Ciudad> aCiudadesVisitadas = new ArrayList<Ciudad>();

	public Ciudad getInicio() {
		return inicio;
	}
	public void setInicio(Ciudad inicio) {
		this.inicio = inicio;
	}
	public Ciudad getFin() {
		return fin;
	}
	public ArrayList<Ciudad> getCiudades() {
		return aCiudades;
	}
	public void setCiudades(ArrayList<Ciudad> ciudades) {
		this.aCiudades =  ciudades;
	}
	public void setFin(Ciudad fin) {
		this.fin = fin;
	}
	public Entorno(){

	}

	public Entorno(Ciudad inicio, Ciudad fin, ArrayList<Ciudad> ciudades) {
		super();
		this.inicio = inicio;
		this.fin = fin;
		aCiudades = ciudades;
	 this.actual=inicio;
	}
	public ArrayList<Ciudad> getCiudadesVisitadas() {
		return aCiudadesVisitadas;
	}
	public void setCiudadesVisitadas(ArrayList<Ciudad> aCiudadesVisitadas) {
		this.aCiudadesVisitadas = aCiudadesVisitadas;
	}
	public Ciudad getActual() {
		return actual;
	}
	public void setActual(Ciudad actual) {
		this.actual = actual;
	}

	public double getDistanciaTotal() {
		return distanciaTotal;
	}
	
	public void setDistanciaTotal(double distanciaTotal) {
		this.distanciaTotal = distanciaTotal;
	} 
	@Override
	/**
	 * @return String
	 */
	public String toString() {
		return "Entorno [inicio=" + inicio + ", fin=" + fin + ", Ciudades="
				+ aCiudades + "]";
		//posteriormente adecuaremos el estrinpara que se ordenen segun las ciudades
	}
	@Override
	/**
	 * @param Object
	 * @return boolean
	 * Primero Condicion Compara si el objeto que le pasamos no es nulo y pertenece a un entorno
	 * Segunda Condicion compara si la ciudad actual es la misma en el entorno y el ArrayList de ciudades visitadas 
	 * tiene el mismo tama�o
	 * El while es para recorrer todas las ciudades visitadas y ir comparandolas las del entorno los 2 entornos
	 * Si alguna de estas concicciones no se cumple significa que los entornos no 
	 * son iguales por lo tanto devuelve un FALSE si se cumple las tres Condiciones devuelve TRUE
	 */
	public boolean equals(Object ent) 
	{
		boolean enc = true;
		int i = 0;
		if(ent != null && ent instanceof Entorno)
		{
			Entorno e = (Entorno) ent;
			if(e.getActual().getNombre().equals(this.actual.getNombre())
					&&e.getActual().getx()==this.actual.getx()&&e.getActual().gety()==this.actual.gety() 
					&&  e.getCiudadesVisitadas().size()==this.aCiudadesVisitadas.size()){


				while(enc && i < e.getCiudadesVisitadas().size())
				{
					if(e.getCiudadesVisitadas().get(i).getNombre().equals(this.aCiudadesVisitadas.get(i).getNombre())
							&&e.getCiudadesVisitadas().get(i).getx()==this.aCiudades.get(i).getx()
							&&e.getCiudadesVisitadas().get(i).gety()==this.aCiudades.get(i).gety()
							&&e.getCiudadesVisitadas().get(i).getOrden()==this.aCiudades.get(i).getOrden())
					{
						i++;
					}
					else
					{
						enc=false;//para la condicion del array si no se cumple se combierte en false
					}

				}

			}
			else{
				enc=false;//para la condicion de tama�o de ciudad visitad,y la ciudad actual
			}
		}
		else{
			enc=false;//para comprobar si es nulo
		}
		return enc;
	}


	

	/**
	 * @return Object
	 * Clona toda la imformaccion del entorno actual y devueve el nuevo entorno
	 */
	@SuppressWarnings("unchecked")
	public Object clone()
	{
		Entorno clon = null;

		try {
			clon = (Entorno) super.clone();
//			clon.inicio = (Ciudad) this.inicio.clone();
			clon.actual =this. actual;
//			clon.aCiudades = (ArrayList<Ciudad>) this.aCiudades.clone();
			clon.aCiudadesVisitadas = (ArrayList<Ciudad>) this.aCiudadesVisitadas.clone();
		} catch (CloneNotSupportedException e) {
			System.err.println("% [ERROR] Entorno.clone(): " + e.getMessage());
		}

		return clon;
	}




	
	/**
	 * Main
	 * @param args
	 */
	
	public static void main(String[]args)
	{
		Ciudad s = new Ciudad(1,4,"S");
		Ciudad a = new Ciudad(3,2,"A");
		Ciudad e = new Ciudad(11,1,"E");
		Ciudad z = new Ciudad(15,5,"Z");
		/**
		 * Ya que no vamos a solucionar el problema por el momento hemos decivido no rellenar el 
		 * Array de las ciudades posibles a las que se puede ir
		 * 
		 */
		Desplazarse desp = new Desplazarse(s,a);//Creaccion de desplazarse
		ArrayList<Ciudad> aCiudades = new ArrayList<Ciudad>();
		aCiudades.add(a);
		aCiudades.add(e);
		Entorno ent = new Entorno(s, z, aCiudades); //Creaci�n de un entorno de pruebas
		System.out.println("Entorno1= "+ent);
		if(desp.isApplicable(ent)) //Comprobamos que la acci�n es aplicable
		{ 
			System.out.println(" ");
			System.out.println("Es aplicable");
			System.out.println(" ");
			ent = (Entorno) desp.effect(ent);//Realizamos el effect da error
			System.out.println();
		System.out.println("Ciudades Visitadas"+ent.getCiudadesVisitadas()+"Distancia Total: "+ent.getDistanciaTotal());
		}
		else
		{
			System.out.println("No soy aplicable");
		}

		desp.setDestino(a);
		if(desp.isApplicable(ent))//Comprobamos que la acci�n no es aplicable, su sale el interior de este if en pantalla est� mal
		{
		System.out.println("");
		System.out.println("No debo salir");
		}
		else{
		System.out.println("");
		System.out.println("Correcto");
		}
		System.out.println();
		System.out.println(ent); // mostramos el contenido del entorno de pruebas
		ent=new Entorno(s,z,aCiudades);
		Entorno entclon = new Entorno(s,z,aCiudades); // Creamos un entorno vac�o en el que vamos a clonar el entorno de pruebas
		System.out.println();
		System.out.println("Primer "+ent);
		System.out.println();
		
		entclon = (Entorno) ent.clone(); //Clonamos el entorno
		System.out.println("Segundo "+entclon);
		System.out.println(entclon.getActual());
		//System.out.println(entclon); // mostramos el contenido del entorno clon
		if(ent.equals(entclon))//Como hemos clonado el entorno sera igual
		{ 
		System.out.println();
		System.out.println("Soy igual");
		}
		ent.getCiudadesVisitadas().add(s); // a�adimos una ciudad visitadas
		if(!ent.equals(entclon))
		{
		System.out.println();
		System.out.println("Soy diferente");
		}
		TouringProblem tp=new TouringProblem();
        if(!tp.isFinalState(ent)){//Comprobamos si es estado final
        	System.out.println();
        	System.out.println("No es estado final");
        }
        else{
        	System.out.println("Es estado final");
        }
        ent.getCiudadesVisitadas().add(e);//insertamos la nueva ciudad para que haya la misma cantidad de ciudades visitadas
        if(tp.isFinalState(ent)){
        	System.out.println();
        	System.out.println("Es estado final");
        }
	}
}