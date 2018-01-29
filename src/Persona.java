import java.util.*;

/*
Creamos la clase persona con los atributos:
nombre, edad, DNI, sexo, peso y altura.
Todos ellos tendran valores por defecto,
 salvo DNI y sexo.
*/
public class Persona {
	
	// Atributos
	protected String nombre;
	private int edad;
	private String dni;
	private int peso;
	private double altura;
	
	// Constantes
	private static char SEXO = 'H';
	
	
	// Constructores
	public Persona() {
		generarDNI();
	}
	public Persona(
			String nombre,
			int edad, 
			char sexo) {
		this.nombre = nombre;
		this.edad = edad;
		Persona.SEXO = sexo;
		generarDNI();
	}
	public Persona(
			String nombre,
			int edad,
			char sexo,
			int peso,
			double altura) {
		this.nombre = nombre;
		this.edad = edad;
		Persona.SEXO = sexo;
		this.peso = peso;
		this.altura = altura;
		generarDNI();
	}
	
	// Metodos
	public void calcularIMC() {
		int peso = getPeso();
		double altura = getAltura();
		double result = peso / (altura * altura);
		// Tomado de "https://www.webmd.com/a-to-z-guides/body-mass-index-bmi-for-adults"
		// A BMI below 18.5 is considered underweight
		final String BAJO_PESO = "El IMC de " + nombre + 
				" est\u00e1 por debajo de 18.5, deber\u00eda procurar subir de peso.";
		// A BMI of 18.5 to 24.9 is considered healthy
		final String PESO_IDEAL = "El IMC de " + nombre +
				" se encuentra en un nivel adecuado. Procure mantenerse as\u00ed.";
		// A BMI of 25 or above is considered overweight
		final String SOBREPESO = "El IMC de "+ nombre + 
				" est\u00e1 por encima de 25. Deber\u00eda procurar bajar de peso.";
		// Recogemos en una cuarta constante, un cuarto caso de valor erroneo
		final String VALOR_ERRONEO = "Es posible que haya introducido algun valor "
				+ "err\u00f3neo para  " + nombre +
				". Por favor, vuelva a intentarlo.";
		if (result < 18.5) {
			System.out.println(BAJO_PESO);
		} else if (result < 25 && result >= 18.5) {
			System.out.println(PESO_IDEAL);
		} else if (result >= 25) {
			System.out.println(SOBREPESO);
		} else {
			System.out.println(VALOR_ERRONEO);
		}
	}
	public void esMayorDeEdad() {
		int edad = getEdad();
		// Usando un operador ternario
		if (edad >=18) {
			System.out.println(nombre + " es mayor de edad.");
		} else {
			System.out.println(nombre + " no es mayor de edad.");
		}
		
	}
	protected char comprobarSexo(char sexo) {
		if (sexo != 'H' || sexo != 'M') {
			SEXO = 'H';
		} else {
			SEXO = sexo;
		}
		return sexo;
	}
	@Override
	public String toString() {
		return "\nPERSONA"
				+ "\nNombre: " + nombre
				+ "\nEdad: " + edad + " a\u00f1os"
				+ "\nDNI: " + dni
				+ "\nSexo: " + SEXO
				+ "\nPeso: " + peso + " Kg"
				+ "\nAltura: " + altura + " metros"
				+ "\n";
	}
	private void generarDNI() {
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
		dni = finalstr;
	}

	// Setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setEdad(int edad) {
		if ( edad < 0 ) Math.abs(edad);
		this.edad = edad;
	}
	public void setSexo(char sexo) {
		this.SEXO = sexo;
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	// Getters
	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	public char getSexo() {
		return SEXO;
	}
	public int getPeso() {
		return peso;
	}
	public double getAltura() {
		return altura;
	}
}

