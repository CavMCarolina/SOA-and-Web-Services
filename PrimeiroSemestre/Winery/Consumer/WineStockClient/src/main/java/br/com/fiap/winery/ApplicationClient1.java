package br.com.fiap.winery;

import br.com.fiap.winery.classes.WineStockService;

import jakarta.xml.ws.Service;

import java.net.URL;
import javax.xml.namespace.QName;

public class ApplicationClient1 {
    public static void main(String[] args) throws Exception {
        final String wsdl = "http://localhost:8085/WineStockService?wsdl";
        final String targetNameSpace = "http://winery.fiap.com.br/";
        final String localPart = "WineStockServiceImplementationService";

        // instanciando objeto url que recebe String wsdl
        URL url = new URL(wsdl);

        // instanciando objeto qName que recebe String targetNameSpace e localPart
        QName qName = new QName(targetNameSpace, localPart);

        // instanciando objeto service com metodo create, atribuindo os objetos url e qName como argumentos
        Service service = Service.create(url, qName);

        // instanciando objeto wineStockService com metodo getPort, atribuindo a classe WineStockService como argumento
        WineStockService wineStockService = service.getPort(WineStockService.class);

        // criando variável tipo String com o metodo getMenu() e imprimindo
        String menu = wineStockService.getMenu();
        System.out.println(menu);
    }
}


