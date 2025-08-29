package br.com.fiap3espa;

import br.com.fiap3espa.service.Sum;
import br.com.fiap3espa.service.Sub;
import br.com.fiap3espa.service.Mult;
import br.com.fiap3espa.service.Div;

import jakarta.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        System.out.println("Publicando API...");

        Endpoint.publish("http://localhost:2424/calcultatorAPI/sum", new Sum());
        Endpoint.publish("http://localhost:2424/calcultatorAPI/sub", new Sub());
        Endpoint.publish("http://localhost:2424/calcultatorAPI/mult", new Mult());
        Endpoint.publish("http://localhost:2424/calcultatorAPI/div", new Div());

        System.out.println("API publicada com sucesso. Parabéns!");
    }
}