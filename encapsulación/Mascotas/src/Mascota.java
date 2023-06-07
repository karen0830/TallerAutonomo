import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Mascota {
    Procesos misP = new Procesos();
    // Attributes
    private int codigo;
    private String nombre;
    private String especie;
    private int edad;

    //Constructor sin parametros
    public Mascota() {
          nombre = "Firu";
          especie = "Default";
          edad = 0;
    }

    // Constructor con parametros
    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }
    
    //Encapsular
    //nombre 
    public void setNombre(String nombre) {
    	this.nombre = nombre;
    }
    
    public String getNombre() {
    	return nombre;
    }
   
    //Codigo
    public void setCodigo(int codigo) {
    	this.codigo = codigo;
    }
    
    public int getCodigo() {
    	return codigo;
    }
    
    //especie
    public void setEspecie(String especie) {
    	this.especie = especie;
    }
    
    public String getEspecie() {
    	return especie;
    }
    
    //edad
    public void setEdad(int edad) {
    	this.edad = edad;
    }
    
    public int getEdad() {
    	return edad;
    }
    
    // Método para mostrar información de la mascota
    public void mostrarInformacion() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Especie: " + getEspecie());
        System.out.println("Edad: " + getEdad() + " años");
        System.out.println("-----");
    }

    // Método para hacer que la mascota realice un sonido
    public void hacerSonido() {
        if (especie.equalsIgnoreCase("perro")) {
            System.out.println("¡Guau guau!");
        } else if (especie.equalsIgnoreCase("gato")) {
            System.out.println("¡Miau miau!");
        } else {
            System.out.println("La mascota no hace sonidos conocidos.");
        }
    }
    
    // Método para sacar a la mascota a caminar
    public void caminar(Procesos procesos) {
    	int cantidad = 0;
        do {
        	int llave = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID de una mascota para salir a caminar"));
            Mascota mascota = procesos.getDatos().get(llave);
            if (mascota != null) {
                System.out.println("ID: " + llave);
                System.out.println("Nombre: " + mascota.nombre);
                System.out.println("Sale a caminar");
                System.out.println("-----");
            } else {
                System.out.println("No se encontró una mascota con el ID especificado.");
                System.out.println("-----");
            }
            cantidad = misP.valido("Ingrese: \n1. Continuar con otra mascota\n2. SALIR");
        }while(cantidad == 1);	
    }
    
    //metodo para imprimir datos
    public void imprimirD(Procesos procesos) {
    	 HashMap<Integer, Mascota> mascota = procesos.getDatos();
    	Iterator iterator = mascota.keySet().iterator();
    	Mascota mascotas; Integer llave;
		while(iterator.hasNext()) {
            llave = (Integer) iterator.next();
            mascotas = procesos.getDatos().get(llave);
            System.out.println("ID: " + llave + ", Nombre: " + mascotas.nombre + ", edad: " + mascotas.edad 
                		+ " y especie " + mascotas.especie);
		}
		System.out.println("-----");
    }
    
    public void ingresarDatos(int i) {
        codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese codigo de la mascota " + i));
        nombre = JOptionPane.showInputDialog("Ingrese nombre");
        especie = JOptionPane.showInputDialog("Ingrese especie");;
        edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad de: " + nombre));
    }
}