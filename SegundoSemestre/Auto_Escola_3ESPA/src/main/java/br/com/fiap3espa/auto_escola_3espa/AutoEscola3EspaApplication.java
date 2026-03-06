package br.com.fiap3espa.auto_escola_3espa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutoEscola3EspaApplication {
	public static void main(String[] args) {
		SpringApplication.run(AutoEscola3EspaApplication.class, args);
	}
}

// SQL --> create database auto_escola_3espa;

// URL --> http://localhost:8080/instrutores
// JSON
// {
//	 "nome": "Ágatha Magalhães",
//	 "email": "AM.contato@gmail.com",
//	   "telefone": "(11) 1234-1234",
//	 "cnh": "01234567890",
//	 "especialidade": "Motos",
//	 "endereco": {
//		 "logradouro": "Rua Calçada Florida",
//		 "numero": "450",
//		 "complemento": "Apto. 83C",
//		 "bairro": "Jardim Orquídeas",
//		 "cidade": "São Paulo",
//		 "uf": "SP",
//		 "cep": "53681000"
//	 }
// }
