package Test_Calcular_Area;

public class CalculadorAreaCirculo {
	public  static  Double calcularAreaCirculo (Double radio){
		if ( radio<=0){
			throw  new IllegalArgumentException("Elvalor del radio debe ser mayor a cero");

		}
		return  Math.PI * Math.pow(radio,2);
	}
}
