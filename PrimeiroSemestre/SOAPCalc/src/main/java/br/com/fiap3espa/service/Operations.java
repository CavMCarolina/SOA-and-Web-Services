package br.com.fiap3espa.service;

import com.oracle.xmlns.webservices.jaxws_databinding.SoapBindingStyle;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

@WebService
// Se fosse para outras linguagens conseguirem consumir a API também, teria que ser DOCUMENT
@SOAPBinding(style = SOAPBinding.Style.RPC)

public interface Operations {
    // Só funciona para um elemento abaixo
    @WebMethod
    String showName();

    @WebMethod
    String showSymbol();

    @WebMethod
    double calculate(double x, double y);

    @WebMethod
    String showMessage(double x, double y);
}
