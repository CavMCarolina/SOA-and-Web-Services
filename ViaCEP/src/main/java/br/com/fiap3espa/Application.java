package br.com.fiap3espa;

import br.com.fiap3espa.client.ViaCEPClient;
import br.com.fiap3espa.model.EnderecoDTO;

import java.io.IOException; // Erro de entrada e saída
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o CEP: ");
        String cep = sc.next();

        EnderecoDTO endereco = ViaCEPClient.getEndereco(cep);

        System.out.println("CEP: " + endereco.cep());
        System.out.println("Logradouro: " + endereco.logradouro());
        System.out.println("Complemento: " + endereco.complemento());
        System.out.println("Bairro: " + endereco.bairro());
        System.out.println("Cidade: " + endereco.localidade());
        System.out.println("Estado: " + endereco.estado() + ", " + endereco.uf());
    }
}
