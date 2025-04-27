/**
 * Clase que representa un robot en la batalla
 */

public class Robot {
    private String nombre;
    private int puntosVida;
    private int ataque;
    private int defensa;

//Constructor

    public Robot(String nombre, int puntosVida, int ataque, int defensa){
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.ataque = ataque;
        this.defensa = defensa;
    }

//Metodo que permite atacar a otro robot

    public void atacarA(Robot otroRobot) {
        int danio = ataque - otroRobot.defensa;
        if (danio < 1){
            danio = 1; // daño mínimo
        }

        otroRobot.puntosVida -= danio;
        if (otroRobot.puntosVida < 0){
            otroRobot.puntosVida = 0;
        }

        System.out.println(nombre + " ataca a " + otroRobot.nombre);
        System.out.println("Daño infligido: " + danio);
        System.out.println("Vida restante de " + otroRobot.nombre + ":" + otroRobot.puntosVida +"\n");
    }

//Verifica si el robot sigue en batalla

public boolean estaVivo(){
    return puntosVida > 0;
}

//Metodo para acceder a los atributos de la clase Robot

    public String getNombre(){
        return nombre;
    }

    public int getPuntosVida(){
        return puntosVida;
    }

    public int getAtaque(){
        return ataque;
    }

    public int getDefensa(){
        return defensa;
    }
}
