package br.com.fiap3espa;

import br.com.fiap3espa.stub_classes.NumberConversionSoapType;
//import br.com.fiap3espa.stubClasses.AtendeCliente;
import jakarta.xml.ws.Service;

import java.math.BigInteger;
import java.net.URL;
import javax.xml.namespace.QName;

public class Main {
    public static void main(String[] args) throws Exception {
        // Number
        final String wsdl = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso?WSDL";
        final String target = "http://www.dataaccess.com/webservicesserver/";
        final String name = "NumberConversion";

        // CEP
        //final String wsdl = "https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente?wsdl";
        //final String target = "http://cliente.bean.master.sigep.bsb.correios.com.br/";
        //final String name = "AtendeClienteService";

        URL url = new URL(wsdl);
        QName qName = new QName(target, name);

        // metodo estatico de instanciacao
        Service service = Service.create(url, qName);

        NumberConversionSoapType numberConversion = service.getPort(NumberConversionSoapType.class);

        String convertedNumber = numberConversion.numberToWords(BigInteger.valueOf(892));
        System.out.println(convertedNumber);

        //AtendeCliente serchCEP = service.getPort(NumberConversionSoapType.class);

        // Vai dar erro pq esse usuário não existe :)
        //String endereco = searchCEP.consultaCEP("03346000", "carolina", "senha"));
        //System.out.println(endereco);
    }
}