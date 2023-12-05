import java.sql.Date;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.ManejoMedicamentos;
import controller.busquedaModeloGanadero;
import functions.limpiarPantalla;
import model.Vaca;
import model.modeloGanadero;
import model.modeloMedicamentos;
import model.modeloVentas;

public class App {
    public static void main(String[] args) throws Exception {

        // declarando variables genericas
        Integer opc = 0;

        // Declarando Variables de usuario
        String user = "administrador";
        String password = "123456";
        int intentosMaximos = 3;
        int intentos = 0;
        boolean accesoConcedido = false;

        //
        Scanner capturar = new Scanner(System.in);
        // colecciones de elementos de manera dinámica.
        ArrayList<modeloGanadero> ganado = new ArrayList<>();
        ArrayList<modeloVentas> ventas = new ArrayList<>();
        ArrayList<modeloMedicamentos> medicamentos = new ArrayList<>();

        // Crear una instancia de Vaca
        Date fecha = new Date(System.currentTimeMillis());
        Vaca miVaca = new Vaca("Blanco", "Brahman", 123, 450.0, 500.0, fecha, "Lactosa");

        boolean usuarioAutenticado = false;

        do {

            System.out.println(
                    "\n---------------------------------\n"
                            + "\n BIENVENIDO AL SISTEMA GANADERO ORTEGA \n");

            System.out.print("Ingresar el Usuario: ");
            String inputUser = capturar.nextLine();

            System.out.print("Ingresar la contraseña: ");
            String inputPassword = capturar.nextLine();

            // limpiando la consola
            limpiarPantalla.limpiar();

            if (user.equals(inputUser) && password.equals(inputPassword)) {
                // limpiando la consola
                limpiarPantalla.limpiar();

                System.out.println("\n Inicio de sesion de manera exitosa. Bienvenido!");
                usuarioAutenticado = true;

                do {
                    System.out.println(
                            "\n---------------------------------\n"
                                    + "\n DIGITE LA OPCION A ESCOGER \n"
                                    + "\n (1) registrar cabezas de ganado \n"
                                    + "\n (2) visualizar registro del ganado \n"
                                    + "\n (3) Ventas Diarias \n"
                                    + "\n (4) Retiro de dinero\n"
                                    + "\n (5) Algoritmo de Busqueda de vaca\n"
                                    + "\n (6) registrar los medicamentos\n"
                                    + "\n (7) visualizar registro de los medicamentos \n"
                                    + "\n (8) Algoritmo de Busqueda de medicamentos\n"
                                    + "\n (9) Algoritmo de ordenamiento de medicamentos\n"
                                    + "\n (10) Salir \n");
                    System.out.print("\n Opcion: ");

                    while (!capturar.hasNextInt()) {
                        System.out.println("\n por favor, ingrese un numero valido.");
                        System.out.print("\n Opcion: ");
                        capturar.next();
                    }

                    opc = capturar.nextInt();
                    System.out.println("");

                    switch (opc) {
                        case 1:
                            // aplique una excepcion en el cual cuando agreguen valores de tipo string
                            // no quiebre el sistema y se continue ejecutando
                            try {
                                // limpiando la consola
                                limpiarPantalla.limpiar();

                                System.out.println("\n REGISTRANDO LAS CABEZAS DE GANADO \n");

                                System.out.print("Ingrese la cantidad de vacas: ");
                                Integer cantidad = capturar.nextInt();

                                for (int a = 0; a < cantidad; a++) {
                                    modeloGanadero ModeloGanadero = new modeloGanadero();

                                    System.out.println("\n vaca N" + (a + 1) + "\n");
                                    System.out.print("ingrese el color: ");
                                    ModeloGanadero.setColor(capturar.next());
                                    System.out.print("ingrese la raza: ");
                                    ModeloGanadero.setRaza(capturar.next());
                                    System.out.print("ingrese el peso animal en KG: ");
                                    ModeloGanadero.setPesoAnimal(capturar.nextDouble());

                                    ganado.add(ModeloGanadero);
                                }
                                // limpiando la consola
                                limpiarPantalla.limpiar();

                            } catch (InputMismatchException e) {
                                // limpiando la consola
                                limpiarPantalla.limpiar();
                                // el InputMismatchException espera un cierto tipo de datos y recibe una entrada
                                // que no coincide con el tipo esperado.
                                System.out
                                        .println(
                                                "\n Error: Entrada inválida. Asegúrese de ingresar los datos correctos.");
                                capturar.nextLine();
                            }
                            break;

                        case 2:
                            try {
                                // limpiando la consola
                                limpiarPantalla.limpiar();

                                System.out.println("VISUALIZAR EL REGISTRO DEL GANADO");

                                for (int a = 0; a < ganado.size(); a++) {
                                    modeloGanadero ModeloGanaderoActual = ganado.get(a);
                                    System.out.println("\n Informacion de la vaca: N" + (a + 1) + ": ");
                                    System.out.println("Color: " + ModeloGanaderoActual.getColor());
                                    System.out.println("Raza: " + ModeloGanaderoActual.getRaza());
                                    System.out.println("Peso Animal: " + ModeloGanaderoActual.getPesoAnimal());
                                    // Acceder a propiedades específicas de Vaca
                                    System.out.println("Tipo de leche: " + miVaca.getTipoLeche());
                                }
                            } catch (InputMismatchException e) {
                                // limpiando la consola
                                limpiarPantalla.limpiar();
                                System.out
                                        .println(
                                                "\n Advertencia: NO SE ENCUENTRAN DATOS CARGADOS ACTUALMENTE, INGRESE LOS DATOS.");
                                capturar.nextLine(); // Limpiar el buffer del Scanner
                            }
                            break;

                        case 3:
                            // aplique una excepcion en el cual cuando agreguen valores de tipo integer y
                            // double
                            // no quiebre el sistema y se continue ejecutando
                            try {
                                // limpiando la consola
                                limpiarPantalla.limpiar();

                                System.out.println("VENTAS DIARIAS \n");

                                modeloVentas ModeloVentas = new modeloVentas();

                                System.out.print("Ingrese el precio del litro de leche: ");
                                ModeloVentas.setPrecioLitro(capturar.nextInt());
                                System.out.print("Ingrese los litros de leche: ");
                                ModeloVentas.setLitros(capturar.nextDouble());

                                System.out.println("---------------------------------------");

                                ventas.add(ModeloVentas);

                                System.out.println("Precio por litro ingresado: " + ModeloVentas.getPrecioLitro());
                                System.out.println("Litros Ingresados: " + ModeloVentas.getLitros());

                                Double ResultadoFinal = ModeloVentas.formulaGanancia();

                                System.out.println("La ganancia neta es: " + ResultadoFinal);
                            } catch (InputMismatchException e) {
                                // limpiando la consola
                                limpiarPantalla.limpiar();
                                System.out
                                        .println(
                                                "\n Error: Entrada inválida. Asegúrese de ingresar los datos correctos.");
                                capturar.nextLine(); // Limpiar el buffer del Scanner
                            }
                            break;

                        case 4:
                            // aplique una excepcion en el cual cuando agreguen valores de tipo double
                            // no quiebre el sistema y se continue ejecutando
                            try {
                                if (!ventas.isEmpty()) {
                                    // limpiando la consola
                                    limpiarPantalla.limpiar();

                                    System.out.println("RETIRO DE DINERO");

                                    Double capturarGanancia = ventas.get(0).getGananciaNeta();

                                    System.out.println("su saldo de la ganancia es de: " + capturarGanancia + "\n");

                                    modeloVentas ModeloVentasActual = new modeloVentas();

                                    System.out.println("Ingrese la cantidad a retirar: ");
                                    Double cantidadARetirarInput = capturar.nextDouble();
                                    ModeloVentasActual.setRetirarGanancia(cantidadARetirarInput);

                                    // Si necesitas usar la cantidad retirada más adelante, puedes asignarla por
                                    // separado
                                    Double cantidadARetirar = (double) cantidadARetirarInput;

                                    double cantidadRetiradaReal = ModeloVentasActual.retirarGanancia(cantidadARetirar,
                                            capturarGanancia);

                                    if (cantidadRetiradaReal > 0.0) {
                                        System.out
                                                .println("\n Se retiraron: " + cantidadARetirar
                                                        + " unidades de ganancia.");
                                        System.out.println("La ganancia restante es: "
                                                + ModeloVentasActual.obtenerGananciaRestante());
                                    } else {
                                        System.out.println("No se pudo retirar la cantidad solicitada.");
                                    }
                                } else {
                                    // limpiando la consola
                                    limpiarPantalla.limpiar();
                                    // Otra lógica en caso de que la lista esté vacía
                                    System.out
                                            .println("La lista de ventas está vacía. No se puede obtener la ganancia.");
                                }
                            } catch (InputMismatchException e) {
                                // limpiando la consola
                                limpiarPantalla.limpiar();
                                System.out
                                        .println(
                                                "\n Error: Entrada inválida. Asegúrese de ingresar los datos correctos.");
                                capturar.nextLine(); // Limpiar el buffer del Scanner
                            }
                            break;

                        case 5:
                            // aplique una excepcion en el cual cuando agreguen valores de tipo string
                            // no quiebre el sistema y se continue ejecutando
                            try {
                                // limpiando la consola
                                limpiarPantalla.limpiar();

                                System.out.println("ALGORITMO DE BUSQUEDA");

                                System.out.println("Ingrese el color a buscar:");
                                String colorABuscar = capturar.next();

                                System.out.println("Ingrese la raza a buscar:");
                                String razaABuscar = capturar.next();

                                modeloGanadero animalEncontrado = busquedaModeloGanadero.buscarPorColorYRaza(ganado,
                                        colorABuscar, razaABuscar);

                                if (animalEncontrado != null) {

                                    Double pesoDelAnimal = animalEncontrado.getPesoAnimal();

                                    System.out.println("\n Se encontró la vaca de color " + colorABuscar + " y raza "
                                            + razaABuscar + " con un peso en KG de: " + pesoDelAnimal + ".");
                                } else {
                                    System.out.println("\n No se encontró una vaca con esas características.");
                                }
                            } catch (InputMismatchException e) {
                                // limpiando la consola
                                limpiarPantalla.limpiar();
                                System.out
                                        .println(
                                                "\n Error: Entrada inválida. Asegúrese de ingresar los datos correctos.");
                                capturar.nextLine(); // Limpiar el buffer del Scanner
                            }
                            break;
                        case 6:
                            try {
                                // limpiando la consola
                                limpiarPantalla.limpiar();

                                System.out.println("\n REGISTRAR LOS MEDICAMENTOS \n");

                                System.out.print("Ingrese la cantidad a registrar: ");
                                Integer cantidadMe = capturar.nextInt();

                                for (int i = 0; i < cantidadMe; i++) {
                                    modeloMedicamentos ModeloMedicamentos = new modeloMedicamentos();

                                    System.out.println("\n Medicamento N" + (i + 1) + "\n");

                                    System.out.print("Ingrese el Nombre: ");
                                    ModeloMedicamentos.setNombreMedicamento(capturar.next());
                                    System.out.print("Ingrese el Precio: ");
                                    ModeloMedicamentos.setPrecio(capturar.nextDouble());

                                    medicamentos.add(ModeloMedicamentos);
                                }

                            } catch (InputMismatchException e) {
                                // limpiando la consola
                                limpiarPantalla.limpiar();
                                System.out
                                        .println(
                                                "\n Error: Entrada inválida. Asegúrese de ingresar los datos correctos.");
                                capturar.nextLine(); // Limpiar el buffer del Scanner
                            }
                            break;

                        case 7:
                            // limpiando la consola
                            limpiarPantalla.limpiar();

                            System.out.println("VISUALIZAR EL REGISTRO DE LOS MEDICAMENTOS");

                            for (int i = 0; i < medicamentos.size(); i++) {
                                modeloMedicamentos modeloMedicamentosActual = medicamentos.get(i);
                                System.out.println("\n Informacion del medicamento: N" + (i + 1) + ": ");
                                System.out.println("Nombre: " + modeloMedicamentosActual.getNombreMedicamento());
                                System.out.println("Precio: " + modeloMedicamentosActual.getPrecio());
                            }

                            break;

                        case 8:
                            try {
                                // limpiando la consola
                                limpiarPantalla.limpiar();

                                System.out.println("ALGORITMO DE BUSQUEDA DE LOS MEDICAMENTOS");

                                System.out.println("Ingrese el nombre del medicamento: ");
                                String nombreMedicamentoABuscar = capturar.next();

                                modeloMedicamentos medicamentoEncontrado = ManejoMedicamentos
                                        .buscarPorNombre(medicamentos, nombreMedicamentoABuscar);

                                if (medicamentoEncontrado != null) {
                                    Double precioMedicamento = medicamentoEncontrado.getPrecio();
                                    System.out.println("\n Se encontró el medicamento con nombre : "
                                            + nombreMedicamentoABuscar + " y precio: " + precioMedicamento);
                                } else {
                                    System.out.println("\n No se encontró medicamentos con esas características.");
                                }

                            } catch (InputMismatchException e) {
                                // limpiando la consola
                                limpiarPantalla.limpiar();
                                System.out
                                        .println(
                                                "\n Error: Entrada inválida. Asegúrese de ingresar los datos correctos.");
                                capturar.nextLine(); // Limpiar el buffer del Scanner
                            }
                            break;

                        case 9:
                            try {
                                // limpiando la consola
                                limpiarPantalla.limpiar();

                                System.out.println("\n ALGORITMO DE ORDENAMIENTO DE LOS MEDICAMENTOS");

                                ManejoMedicamentos.ordenarPorPrecioAscendente(medicamentos);

                                System.out.println("\n Medicamentos ordenados por nombre de manera ascendente: \n");
                                for (int i = 0; i < medicamentos.size(); i++) {
                                    modeloMedicamentos medicamento = medicamentos.get(i);
                                    System.out.println("Nombre: " + medicamento.getNombreMedicamento() + " - Precio: "
                                            + medicamento.getPrecio());
                                }

                            } catch (InputMismatchException e) {
                                // limpiando la consola
                                limpiarPantalla.limpiar();
                                System.out
                                        .println(
                                                "\n Advertencia: NO SE ENCUENTRAN DATOS CARGADOS ACTUALMENTE, INGRESE LOS DATOS.");
                                capturar.nextLine(); // Limpiar el buffer del Scanner
                            }
                            break;

                        case 10:
                            // limpiando la consola
                            limpiarPantalla.limpiar();

                            System.out.println("\n Gracias por usar el Sistema ganadero Ortega \n");
                            break;

                        default:
                            // limpiando la consola
                            limpiarPantalla.limpiar();
                            
                            System.out.println("");
                            System.out.println("Vuelva a elegir la opcion nuevamente");
                            System.out.println("");
                            break;
                    }
                } while (opc != 10);

            } else {
                intentos++;
                if (intentos < intentosMaximos) {
                    int intentosRestantes = intentosMaximos - intentos;
                    System.out.println(
                            " \n Nombre de usuario o contraseña Incorrecta. Intentos restantes: " + intentosRestantes);
                } else {
                    System.out.println("\n Ha excedido el numero maximo de intentos. Cerrando programa. \n");
                }

            }

        } while (!usuarioAutenticado && intentos < intentosMaximos);
        capturar.close();
    }
}
