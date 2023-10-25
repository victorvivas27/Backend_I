package Banco;


public class Main {
	public static void main(String[] args) {
		EmpleadoBanco ejecutivoCuenta =new EjecutivoCuenta();
		EmpleadoBanco gerente = new Gerente();
		EmpleadoBanco director = new Director();

		gerente.setSigEmpleadoBanco(director);
		ejecutivoCuenta.setSigEmpleadoBanco(gerente);
		ejecutivoCuenta.procesarSolicitud(78000);

	}
}