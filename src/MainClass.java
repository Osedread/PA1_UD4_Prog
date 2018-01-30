import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) {
		// Creamos una instancia de la clase Scanner
		Scanner input = new Scanner(System.in);
		// Comienza el prompt
		System.out.println("Introduzca su nombre.");
		String inputNombre = input.nextLine();
		System.out.println("Introduzca su edad.");
		int inputEdad = input.nextInt();
		System.out.println("Introduzca la inicial de su sexo,\n"
				+ "(H) para hombre, o (M) para mujer.");
		char inputSEXO = Character.toUpperCase(input.next().charAt(0));
		
		System.out.println("Introduzca su peso en kilogramos");
		int inputPeso = input.nextInt();
		System.out.println("Introduzca su altura en metros");
		double inputAltura = input.nextDouble();
		input.close();
		
		// Creamos 3 objetos Persona con los 3 constructores declarados.
		// Rellenamos con los datos introducidos por el usuario 
		// en los dos primeros casos, y manualmente en el tercero.
		
		Persona persona1 = new Persona(inputNombre, inputEdad, inputSEXO, inputPeso, inputAltura);
		Persona persona2 = new Persona(inputNombre, inputEdad, inputSEXO);
		Persona persona3 = new Persona();
		persona3.setNombre("Jose");
		persona3.setEdad(27);
		persona3.setSexo('H');
		
		persona3.setPeso(74);
		persona3.setAltura(1.78);
		
		persona1.calcularIMC();
		persona2.calcularIMC();
		persona3.calcularIMC();
		
		persona1.esMayorDeEdad();
		persona2.esMayorDeEdad();
		persona3.esMayorDeEdad();
		
		System.out.println(persona1.toString());
		System.out.println(persona2.toString());
		System.out.println(persona3.toString());
		
		// Parte del ejercicio2 en MainClass.java
		// Creamos un objeto Sith y uno Jedi
		// Asimismo, se suceden una serie de eventos
		Sith maul = new Sith();
		maul.setNombre("Maul");
		Jedi kenobi = new Jedi();
		kenobi.setNombre("ObiJuanKenobi");
		// Empiezan los eventos
		kenobi.sentirLaFuerza();
		maul.estrangularConLaFuerza();
		maul.rayoDeLaFuerza();
		kenobi.moverRoca();
		maul.cancelarHipoteca();
	}
}
