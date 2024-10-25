package com.dzapata.ui;

import com.dzapata.helper.Constants;
import com.dzapata.helper.Helper;

import java.util.List;

public class ConsoleInterface {

    public void principal(boolean isError, String msgError) {
        Helper.limpiarConsola();

        if (isError) {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("                    "+msgError);
            System.out.println("----------------------------------------------------------------------\n");
        }

        System.out.println("**********************************************************************");
        System.out.println("                   Ingrese una opcion:\n");
        System.out.println("                       1.- Convertidor monedas.");
        System.out.println("                       2.- Historial conversiones.");
        System.out.println("                       3.- Salir");
        System.out.println("**********************************************************************\n");
        System.out.print(Constants.WRITE_OPTION_MESSAGE);
    }

    public void continuar() {
        System.out.println("\n¿Qué desea hacer?");
        System.out.println("1.- Realizar otra conversión.");
        System.out.println("2.- Volver al menú principal.");
        System.out.print(Constants.WRITE_OPTION_MESSAGE);
    }

    public void imprimirDivisa(String divisa) {
        Helper.limpiarConsola();
        if (!divisa.equals("USD")) {
            System.out.println("                    USD  |  Dolar gringo.");
        }
        if (!divisa.equals("EUR")) {
            System.out.println("                    EUR  |  Euro.");
        }
        if (!divisa.equals("KRW")) {
            System.out.println("                    KRW  |  Won coreano.");
        }
        if (!divisa.equals("CLP")) {
            System.out.println("                    CLP  |  Peso chileno.");
        }
        if (!divisa.equals("ARS")) {
            System.out.println("                    ARS  |  Peso argentino.");
        }
        if (!divisa.equals("PEN")) {
            System.out.println("                    PEN  |  Sol peruano.");
        }
        if (!divisa.equals("BRL")) {
            System.out.println("                    BRL  |  Real brasileño.");
        }
            System.out.println("                    4.-  |  Volver al menu principal.");

        System.out.println("**********************************************************************\n");
        if (divisa.isEmpty()) {
            System.out.print("Seleccione la divisa: ");
        } else {
            System.out.print("Seleccione la divisa a que desea convertir: ");
        }
    }

    public void ingresoMonto(String origen, String target) {
        System.out.print(String.format("Ingrese cuántos %s desea convertir a %s: ", origen, target));
    }

    public void historial(List<String> historial) {
        System.out.println("**********************************************************************");
        if (historial.isEmpty()) {
            System.out.println("                No hay conversiones registradas");
        } else {
            for (String registro: historial) {
                System.out.println(registro);
            }
        }
        System.out.println("**********************************************************************");
        System.out.print("Presione Enter para continuar: ");
    }

}
