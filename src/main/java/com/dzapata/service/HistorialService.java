package com.dzapata.service;

import com.dzapata.ui.ConsoleInterface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HistorialService {

    ConsoleInterface consoleInterface = new ConsoleInterface();
    List<String> historialTmp = new ArrayList<>();

    public void agregar(int monto, String origen, String target, double conversion ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String fechaFormateada = LocalDateTime.now().format(formatter);
        String registro = String.format("Fecha: %s | Monto: %d %s | Convertido a: %.2f %s",
                fechaFormateada, monto, origen, conversion, target);
        historialTmp.add(registro);
    }

    public void revisar() {
        Scanner scanner = new Scanner(System.in);
        consoleInterface.historial(historialTmp);
        scanner.nextLine();
    }
}