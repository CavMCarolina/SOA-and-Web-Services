package br.com.fiap.winery;

import jakarta.xml.ws.Endpoint;

public class Loader {
    public static void main(String[] args) {
        // API1
        System.out.println("Publicando API WineStock...");

        // instanciando wineStock
        WineStockServiceImplementation wineStock = new WineStockServiceImplementation();
        Endpoint.publish("http://localhost:8085/WineStockService" , wineStock);

        System.out.println("API publicada com sucesso!");

        // API2
        System.out.println("Publicando API WineWarning...");

        //instanciando wineWarning
        WineWarningServiceImplementation wineWarning = new WineWarningServiceImplementation();
        Endpoint.publish("http://localhost:8086/WineWarningService" , wineWarning);

        System.out.println("API publicada com sucesso!");
    }
}