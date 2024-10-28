//Brayan Smith Matabanchoy Zambrano
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

                Laptop laptop1 = new Laptop("Juan", "Nootbook", 1000000,10, "Intel i7", 16);
                Celular celular1 = new Celular("Juan", "Note 10", 7000000, 20, 5000, 108);

                laptop1.mostrarDetalles();
                celular1.mostrarDetalles();

                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Seleccione lo que deseea comprar: ");
                    System.out.println("1. Laptop");
                    System.out.println("2. Celular");

                    int opcion = scanner.nextInt();

        switch (opcion) {
            Cliente cli1 = new Cliente("Juan", "no se");
            case 1:
               cli1.comprarpro(laptop1, 3);
               cli1.mostrarCompra();
               break;
        }
    }
}
