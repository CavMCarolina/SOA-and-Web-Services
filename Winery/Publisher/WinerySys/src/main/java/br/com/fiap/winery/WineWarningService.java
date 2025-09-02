package br.com.fiap.winery;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

// Acho que já importa junto com a anterior...
import jakarta.jws.soap.SOAPBinding.Style;

@WebService

// Se fosse para outras linguagens conseguirem consumir a API também, teria que ser DOCUMENT
@SOAPBinding(style = SOAPBinding.Style.RPC)

public interface WineWarningService {
    @WebMethod
    String sendWarn();
}
