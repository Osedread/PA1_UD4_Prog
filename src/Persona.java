import java.util.Random;

/*
Creamos la clase persona  con los atributos:
nombre, edad, DNI, sexo, peso y altura.
Todos ellos tendran valores por defecto salvo DNI y sexo.
*/

public class Persona {
	
	// Atributos
	/*
	Puesto que el data type Byte abarca de -128 a +128,
	no es necesario usar 'int' en la variable edad.
	*/
	private String nombre;
	private byte edad;
	private String DNI;
	private char sexo = 'H';
	private int peso;
	private double altura;
	
	
	// Constructores
	
	public Persona() {}
	
	public Persona(String nombre, byte edad, char sexo) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
	}
	
	public Persona(String nombre, byte edad, String DNI, char sexo, int peso, int altura) {
		this.nombre = nombre;
		this.edad = edad;
		this.DNI = DNI;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}
	
	
	// Metodos
	
	public int calcularIMC(int peso, double altura) {
		int result = peso / (int) (Math.pow(altura, 2));
		// Tomado de "https://www.webmd.com/a-to-z-guides/body-mass-index-bmi-for-adults"
		// A BMI below 18.5 is considered underweight
		// A BMI of 18.5 to 24.9 is considered healthy
		// A BMI of 25 or above is considered overweight
		if (result < 18.5) {
			return -1;
		} else if (result >= 25) {
			return 1;
		} else {
			return 0;
		}	
	}
	
	public boolean esMayorDeEdad(byte edad) {
		// Usando un operador ternario
		return ( edad >= 18 ) ? true : false;
	}
	
	public String toString() {
		return "PERSONA"
				+ "\nNombre: " + nombre
				+ "\nEdad: " + edad
				+ "\nDNI: " + DNI
				+ "\nSexo: " + sexo
				+ "\nPeso: " + peso
				+ "\nAltura: " + altura
				+ "\n";
	}
	
	private String generarDNI() {
		// Creamos primero una instancia de clase Random
		// Previamente hemos importado dicha Libreria
		Random rand = new Random();
		// Generamos un numero aleatorio de 8 digitos asi como una letra
		int numeroAleatorio = rand.nextInt(99999999) + 10000000;
		char letraAleatoria = (char)(rand.nextInt(26) + 'a');
		// Transformaremos dicha letra a mayuscula
		char letra = Character.toUpperCase(letraAleatoria);
		// Ahora procederemos a construir la String con el DNI completo
		// Primero creamos una instancia de clase de StringBuilder
		StringBuilder str = new StringBuilder();
		// Unimos ambas variables numeroAleatorio y letra en str
		str.append(numeroAleatorio).append(letra);
		// Puesto que str es del tipo StringBuilder, la transformamos en String
		String finalstr = str.toString();
		return finalstr;
	}
}
