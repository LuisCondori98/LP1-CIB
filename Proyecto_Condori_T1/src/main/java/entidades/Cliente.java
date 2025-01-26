package entidades;

public class Cliente {

	private int IdCliente, Edad;
	private String Nombres, Apellidos, Correo;
	private double Salario;
	
	public Cliente() {
		super();
	}

	public Cliente(int idCliente, int edad, String nombres, String apellidos, String correo, double salario) {
		super();
		IdCliente = idCliente;
		Edad = edad;
		Nombres = nombres;
		Apellidos = apellidos;
		Correo = correo;
		Salario = salario;
	}

	public int getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public double getSalario() {
		return Salario;
	}

	public void setSalario(double salario) {
		Salario = salario;
	}
}
