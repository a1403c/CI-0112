import java.util.Scanner;
public class SimuladorBatalla {
    private Robot[] robots;
    private int cantidadRobots;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String [] args){
        SimuladorBatalla juego = new SimuladorBatalla();
        juego.iniciar();
    }

    //Metodo que organiza el flujo del programa
    public void iniciar(){
        presentar();
        cargarRobots();
        ejecutarBatalla();
        mostrarGanador();
    }

    //Titulo del juego
    private void presentar(){
        System.out.println("*****************************");
        System.out.println("*  SIMULADOR DE BATALLA ROBOTICA *");
        System.out.println("*****************************\n");
    }

    //Crea los robots con datos ingresados por el usuario
    private void cargarRobots(){
        int cantidad;

            do{
                System.out.print("Ingrese la cantidad de robots que desea crear (2-10):");
                cantidad = scanner.nextInt();
            }while (cantidad < 2 || cantidad > 10);
            scanner.nextLine();

            cantidadRobots = cantidad;
            robots = new Robot[cantidadRobots];

            for (int i = 0; i < cantidadRobots; i++){
                System.out.println("\nRobot #" + (i+1));
                System.out.print("Ingrese el nombre del robot:");
                String nombre = scanner.nextLine();

                int puntosVida;
                do{
                    System.out.print("Ingrese los puntos de vida del robot (50-100):");
                    puntosVida = scanner.nextInt();
                }while (puntosVida < 50 || puntosVida > 100);

                int ataque;
                do{
                    System.out.print("Ingrese el ataque del robot(10-20):");
                    ataque = scanner.nextInt();
                }while (ataque < 10 || ataque > 20);

                int defensa;
                do{
                    System.out.print("Ingrese la defensa del robot (0-10):");
                    defensa = scanner.nextInt();
                }while (defensa < 0 || defensa > 10);

                scanner.nextLine(); //Limpiar buffer
                robots[i]= new Robot (nombre, puntosVida, ataque, defensa);      
            }
    }

    //Simula los turnos de ataque entre los robots hasta que quede uno vivo

    private void ejecutarBatalla(){
        System.out.println("\nComienza la batalla...\n");

            while(contarVivos() > 1){
                for (int i = 0; i < cantidadRobots; i++){
                    if(!robots[i].estaVivo()) continue;

                    int objetivo;
                    do{
                        objetivo = (int)(Math.random() * cantidadRobots);
                    } while (objetivo == i || !robots[objetivo].estaVivo());

                    robots[i].atacarA(robots[objetivo]);

                    System.out.print("Preseione Enter para continuar...");
                    scanner.nextLine(); // Espera a que el usuario presione Enter
                }
            }
    }

    //Muestra el robot ganador de la batalla
    private void mostrarGanador(){
        System.out.println("\n La batalla ha terminado!");
        for(int i = 0; i < cantidadRobots; i++){
            if(robots[i].estaVivo()){
                System.out.println("El robot ganador es:" + robots[i].getNombre() + " con " + robots[i].getPuntosVida() + " puntos de vida restantes.");
                return;
            }
        }
        System.out.println("No hay robots ganadores");
    }

    //Cuenta cuantos robots siguen vivos
    private int contarVivos(){
        int vivos = 0;
        for (int i=0; i < cantidadRobots; i++){
            if(robots[i].estaVivo()) vivos++;
        }
        return vivos;
    }
}