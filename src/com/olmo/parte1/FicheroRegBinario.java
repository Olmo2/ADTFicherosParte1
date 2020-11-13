﻿package com.olmo.parte1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FicheroRegBinario extends FicheroReg {

	PrintWriter fichEscr;
	FileWriter fichEscr2;
	FileReader fichLect1;
	BufferedReader fichLect2;
	File fichero = new File("C/:olmo/registro.txt");
	
	
	
	public FicheroRegBinario() {
		this.fichEscr=null;
		this.fichEscr2=null;
		this.fichLect1=null;
		this.fichLect2=null;
	}
	
	public FicheroRegBinario(String fich) {
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
		 try {
			fichLect1 = new FileReader(fichero);
			fichLect2 = new BufferedReader(fichLect1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		if(fichLect1!=null&&fichLect2!=null) {
			return true;
		}return false;
		
		
		
	}

    //Cierra los objetos de lectura tanto fichLect1 como fichLect2
	//Antes de cerrarlos comprueba que no tienen valor null
	//Después de cerrarlos les asigna el valor null
	@Override
	public boolean cerrarFicheroR() {
		try {
			fichLect1.close();
			fichLect2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fichLect1 = null;
		fichLect2 =null;
		
		
	
		return true;
	
	}
	

	//Abre en modo escritura para añadir el fichero indicado en la variable de clase fichero
	//Devuelve true si se pudo abrir correctamente y false en caso contrario
	public boolean abrirFicheroW(boolean append){
		
		try {
			fichEscr2 = new FileWriter(fichero, append);
			fichEscr = new PrintWriter(fichEscr2, append);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		 
		 
		
		
		return true;
		

	}
		
    //Cierra los objetos de escritura tanto fichEscr1 como fichEscr2
	//Antes de cerrarlos comprueba que no tienen valor null
	//Después de cerrarlos les asigna el valor null
	@Override
	public boolean cerrarFicheroW() {
		
		try {
			fichEscr.close();
			fichEscr2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;

	}
	

	@Override
	public boolean isOpenR() {
		if(fichLect1 !=null) {
			return true;
		}
		return false;

	}


	//Este método comprueba si el fichero está abierto para escritura comprobando el valor de la variable fichEscr
	//Si tiene un valor igual a null devuelve false en caso contrario devuelve true
	@Override
	public boolean isOpenW() {
		if(fichEscr!=null) {
			return true;
		}
		return false;

	}
	
	
	//Este método lee tantas líneas del fichero como campos tenga nuestro registro y las va almacenando 
	//en el correspondiente campo del objeto recibido como parámetro. Tiene que realizar la conversión de tipo
	//necesaria si algún campo no es de tipo String
	//En la lectura de cada línea comprobará que la función de leer no devolvió null
	//Si alguna lectura de línea devuelve null devolveremos false en la función para indicar que no se pudo leer un registro completo
	//En caso contrario devolveremos true

	public boolean leerRegistro(Jugador jugador) {
		abrirFicheroR();
		String nombre = null;
		String apellido = null;
		Integer dorsal = null;
		String posicion = null;
		
		try {
			nombre= jugador.nombre=fichLect2.readLine();
			apellido=jugador.apellido=fichLect2.readLine();
			dorsal=Integer.parseInt(fichLect2.readLine());
			posicion=fichLect2.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cerrarFicheroR();
		
		if((nombre.equals(null) || apellido.equals(null) || dorsal == null || posicion.equals(null))) {
			return false;
		}
		
		jugador.setNombre(nombre);
		jugador.setApellido(apellido);
		jugador.setDorsal(dorsal);
		jugador.setPosicion(posicion);
		
		
		
		return true;
	
	}

	



	//Escribe cada uno de los campos del registro pasado como parámetro(objeto Jugador)
	//Devuelve true si se pudo escribir todo el registro y false en caso contrario
	@Override
	public boolean escribirRegistro(Jugador jugador) {
		abrirFicheroW(true);
		int dorsal= jugador.getDorsal();
		try {
			fichEscr2.write(jugador.getNombre());
			fichEscr2.write(jugador.getApellido());
			fichEscr2.write(jugador.getDorsal());
			fichEscr2.write(jugador.getPosicion());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cerrarFicheroW();
		
		if(jugador.getNombre()!=null && jugador.getApellido()!=null && jugador.getDorsal()!=0 && jugador.getPosicion()!=null) {
			return false;
		}
		
		
		return true;
	
		
		
	}



	//Este método va llamando a leerRegistro
	//En cada registro obtenido invocará al método mostrarDatos para mostrar los datos leídos
	public void mostrarRegistros() {
		Scanner sc = new Scanner(fichLect2);
		abrirFicheroR();
		try {
			while(sc.hasNextLine()) {
				System.out.println(fichLect2.readLine());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//Recorre el fichero de igual modo que el método anterior pero va contando el número de registros leídos y al final devuelve el número de registros leídos
	public int numeroDeRegistros() {
		Scanner sc = new Scanner(fichLect2);
		int i=0;
		abrirFicheroR();
		try {
			while(sc.hasNextLine()) {
				i++;
				System.out.println(fichLect2.readLine());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;

	}

	
	
	
}