package br.com.fiap3espa.service;

import jakarta.jws.WebService;

// Serviço conectado com a interface
@WebService(endpointInterface = "br.com.fiap3espa.service.Operations")
public class Mult implements Operations { // implementar interface --> precisa de todos os métodos
    @Override
    public String showName() {
        return "~~~ Multiplicação ~~~";
    }

    @Override
    public String showSymbol() {
        return "x";
    }

    @Override
    public double calculate(double x, double y) {
        return x * y;
    }

    @Override
    public String showMessage(double x, double y) {
        return showName() + "\nO resultado da soma de " + x + " " + showSymbol() + " " + y + " é igual a " + calculate(x, y);
    }
}
