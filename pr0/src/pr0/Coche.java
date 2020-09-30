package pr0;

public class Coche {
	protected double miVelocidad; // Velocidad en pixels/segundo
	 protected double miDireccionActual; // Dirección en la que estoy mirando en grados (de 0 a 360)
	 protected double posX; // Posición en X (horizontal)
	 protected double posY; // Posición en Y (vertical)
	 private String piloto; // Nombre de piloto
	public double getMiVelocidad() {
		return miVelocidad;
	}
	public void setMiVelocidad(double miVelocidad) {
		this.miVelocidad = miVelocidad;
	}
	public double getMiDireccionActual() {
		return miDireccionActual;
	}
	public void setMiDireccionActual(double miDireccionActual) {
		this.miDireccionActual = miDireccionActual;
	}
	public double getPosX() {
		return posX;
	}
	public void setPosX(double posX) {
		this.posX = posX;
	}
	public double getPosY() {
		return posY;
	}
	public void setPosY(double posY) {
		this.posY = posY;
	}
	public String getPiloto() {
		return piloto;
	}
	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}
	public Coche() {
		miDireccionActual=0;
		posX=150;
		posY=200;
		miVelocidad=0;
		piloto="";
	}
	 
	public String toString() {
		return piloto + "["+ posX +";"+ posY+ "]" + "velocidad: "+ miVelocidad + "direccion:" + miDireccionActual;
	}
	
	
	public static void main(String[] args) {
		Coche c= new Coche();
		c.setPosX(150);
		c.setPosY(200);
		System.out.println(c);
	}
	
	/** Cambia la velocidad actual del coche
	 * @param aceleracion Incremento de la velocidad en pixels/segundo
	 */ 
	public void acelerar(double aceleracion) {
		System.out.println(aceleracion);
		if (miVelocidad+ aceleracion/100>=0) {
			miVelocidad=miVelocidad+ aceleracion/100;
		}else {
			System.out.println("fallo gordo");
		}
	}
	
	/** Cambia la dirección actual del coche
	 * @param giro Angulo de giro a sumar o restar de la dirección actual, en grados (-180 a +180)
	 */ 
	public void girar (double giro) {
			miDireccionActual=miDireccionActual+giro;
			
		
	}
	
	public void mueve(double tiempoDeMovimiento) {
		double movimientoX=tiempoDeMovimiento*miVelocidad*Math.cos(Math.toRadians(miDireccionActual));
		double movimientoY= tiempoDeMovimiento*miVelocidad*Math.sin(Math.toRadians(miDireccionActual));
		posX= posX + movimientoX;
		posY= posY + movimientoY;
	}
	
}
