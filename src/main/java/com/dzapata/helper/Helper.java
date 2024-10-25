package com.dzapata.helper;

import java.io.IOException;

public class Helper {
    public static void limpiarConsola() {
        try {
            String operatingSystem = System.getProperty("os.name");

            if(operatingSystem.contains("Windows")){
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        } catch (final Exception e) {
            System.err.println("Error al limpiar la consola.");
        }

        System.out.println(Constants.TITLE);
    }

    public static String getURLAPI(String valorBase, String valorTarget) {
        return Constants.BASE_URL_API + valorBase + "/" + valorTarget;
    }
}
