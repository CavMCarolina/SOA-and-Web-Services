package br.com.fiap.winery;

import br.com.fiap.winery.stock_classes.WineStockService;
import br.com.fiap.winery.warning_classes.WineWarningService;

import jakarta.xml.ws.Service;

import java.net.URL;
import javax.xml.namespace.QName;

public class ApplicationClient2 {
    public static void main(String[] args) throws Exception {
        // Wine Stock
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

        // criando variável tipo String com o metodo placeOrder() e imprimindo
        String order = wineStockService.placeOrder("Sauvignon Blanc", 2); // Nome do vinho = Sauvignon Blanc. Quantidade = 2
        System.out.println(order);

        // Wine Warning
        final String wsdl2 = "http://localhost:8086/WineWarningService?wsdl";
        final String targetNameSpace2 = "http://winery.fiap.com.br/"; // é o mesmo, mas para deixar mais organizado preferi criar o segundo
        final String localPart2 = "WineWarningServiceImplementationService";

        URL url2 = new URL(wsdl2);
        QName qName2 = new QName(targetNameSpace2, localPart2);

        Service service2 = Service.create(url2, qName2);
        WineWarningService wineWarningService = service2.getPort(WineWarningService.class);

        String warn = wineWarningService.sendWarn();
        System.out.println(warn);
    }
}


