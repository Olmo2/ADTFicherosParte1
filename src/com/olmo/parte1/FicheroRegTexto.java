package com.olmo.parte1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FicheroRegTexto extends FicheroReg {

	PrintWriter fichEscr;
	FileWriter fichEscr2;
	FileReader fichLect1;
	BufferedReader fichLect2;
	
	
	
	public FicheroRegTexto() {
		this.fichEscr=null;
		this.fichEscr2=null;
		this.fichLect1=null;
		this.fichLect2=null;
	}
	
	public FicheroRegTexto(String fich) {
		super(fich);
		this.fichEscr=null;
		this.fichEscr2=null;
		this.fichLect1=null;
		this.fichLect2=null;
	}
	

	//Abre en modo lectura el fichero indicado en la variable fichero
	//Inicializa para ello tanto fichLect1 como fichLect2
	//Devuelve true si se pudieron inicializar los dos correctamente y false en caso contrario
	@Override
	public boolean abrirFicheroR() {
		
		File fichero = new File("C/:olmo/");
		
		
		return fichero.exists();
		
		
		
	}

    //Cierra los objetos de lectura tanto fichLect1 como fichLect2
	//Antes de cerrarlos comprueba que no tienen valor null
	//Después de cerrarlos les asigna el valor null
	@Override
	public boolean cerrarFicheroR() {
		return false;
	
	}
	

	//Abre en modo escritura para añadir el fichero indicado en la variable de clase fichero
	//Devuelve true si se pudo abrir correctamente y false en caso contrario
	public boolean abrirFicheroW(boolean append){
		return append;
		

	}
		
    //Cierra los objetos de escritura tanto fichEscr1 como fichEscr2
	//Antes de cerrarlos comprueba que no tienen valor null
	//Después de cerrarlos les asigna el valor null
	@Override
	public boolean cerrarFicheroW() {
		return false;

	}
	

	@Override
	public boolean isOpenR() {
		return false;

	}


	//Este método comprueba si el fichero está abierto para escritura comprobando el valor de la variable fichEscr
	//Si tiene un valor igual a null devuelve false en caso contrario devuelve true
	@Override
	public boolean isOpenW() {
		return false;

	}
	
	
	//Este método lee tantas líneas del fichero como campos tenga nuestro registro y las va almacenando 
	//en el correspondiente campo del objeto recibido como parámetro. Tiene que realizar la conversión de tipo
	//necesaria si algún campo no es de tipo String
	//En la lectura de cada línea comprobará que la función de leer no devolvió null
	//Si alguna lectura de línea devuelve null devolveremos false en la función para indicar que no se pudo leer un registro completo
	//En caso contrario devolveremos true

	public boolean leerRegistro(Jugador jugador) {
		return false;
	
	}

	



	//Escribe cada uno de los campos del registro pasado como parámetro(objeto Jugador)
	//Devuelve true si se pudo escribir todo el registro y false en caso contrario
	@Override
	public boolean escribirRegistro(Jugador jugador) {
		return false;
	
	}



	//Este método va llamando a leerRegistro
	//En cada registro obtenido invocará al método mostrarDatos para mostrar los datos leídos
	public void mostrarRegistros() {

	}

	//Recorre el fichero de igual modo que el método anterior pero va contando el número de registros leídos y al final devuelve el número de registros leídos
	public int numeroDeRegistros() {
		return 0;

	}
	
	
}