package com.dzapata.service;

import com.dzapata.helper.Constants;
import com.dzapata.helper.Helper;
import com.dzapata.ui.ConsoleInterface;

import java.util.*;

public class ConsoleService {

    private ApiService apiService = new ApiService();
    private HistorialService historialService = new HistorialService();
    private ConsoleInterface consoleInterface = new ConsoleInterface();
    private boolean isError = false;
    private String msgError;

    public void start() {
        boolean isExecution = true;
        Scanner scanner = new Scanner(System.in);

        while(isExecution) {
            consoleInterface.principal(isError, msgError);

            try {
                int selection = scanner.nextInt();

                switch (selection) {
                    case 1:
                        conversor();
                        break;
                    case 2:
                        historialService.revisar();
                        break;
                    case 3:
                        isExecution = false;
                        break;
                    default:
                        msgError = Constants.INVALID_OPTION_MESSAGE;
                        isError = true;
                        break;
                }
            } catch (InputMismatchException e) {
                msgError = Constants.INVALID_OPTION_MESSAGE;
                isError = true;
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private void conversor() {
        boolean execution = true;
        Scanner scanner = new Scanner(System.in);
        String targetDivisa;
        List<String> divisasValidas = Arrays.asList(Constants.DIVISAS);

        while (execution) {
            consoleInterface.imprimirDivisa("");

            try {
                String origenDivisa = scanner.nextLine().trim().toUpperCase();

                if (divisasValidas.contains(origenDivisa)) {
                    consoleInterface.imprimirDivisa(origenDivisa);
                    targetDivisa = scanner.nextLine().trim().toUpperCase();

                    if (divisasValidas.contains(targetDivisa)) {
                        consoleInterface.ingresoMonto(origenDivisa, targetDivisa);

                        String montoStr = scanner.nextLine().trim();
                        int monto = Integer.parseInt(montoStr);

                        double conversion = convertirDivisa(origenDivisa, targetDivisa, monto);
                        System.out.println(String.format("El valor de %d %s a %s es de %.2f", monto, origenDivisa, targetDivisa, conversion));

                        historialService.agregar(monto, origenDivisa, targetDivisa, conversion);

                        // Reiniciamos validOption para cada ciclo de opciones
                        boolean validOption = false;
                        while (!validOption) {
                            consoleInterface.continuar();
                            String opcion = scanner.nextLine().trim();

                            if (opcion.equals("1")) {
                                validOption = true;
                            } else if (opcion.equals("2")) {
                                validOption = true;
                                execution = false;
                            } else {
                                System.out.println("Opción no válida. Por favor, ingrese 1 o 2.");
                            }
                        }

                    } else {
                        System.out.println("Divisa no válida. Intente nuevamente.");
                    }

                } else if ("4".equals(origenDivisa)) {
                    execution = false;
                } else {
                    System.out.println("Divisa no válida. Intente nuevamente.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Monto inválido. Por favor ingrese un número.");
            } catch (Exception e) {
                System.out.println("Error en la entrada. Intente nuevamente.");
                scanner.nextLine(); // Limpia el buffer en caso de excepción
            }
        }
    }


    private Double convertirDivisa(String origen, String target, int monto) {
        double divisa = apiService.getValorDivisa(origen, target);

        return divisa * monto;
    }

}
