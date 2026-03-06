# 🍷 Winery Project

Este projeto Java tem como objetivo consumir dois serviços SOAP relacionados à gestão de vinhos: `WineStockService` e `WineWarningService`. Utiliza o plugin `jaxws-maven-plugin` para gerar automaticamente as classes Java a partir dos arquivos WSDL.

## 🏭 Publisher > WinerySys

Parte responsável pela **criação das APIs SOAP**:

- **WineStockService**: consulta o estoque de vinhos e registra pedidos.
- **WineWarningService**: emite alertas quando o estoque está abaixo do necessário.

## 🛒 Consumers

Parte responsável pelo **consumo das APIs SOAP**:

- **WineStockClient**: consome apenas a API de estoque.
- **WineOrderClient**: consome ambas as APIs para realizar pedidos e emitir alertas quando o estoque é insuficiente.


## 🧪 Tecnologias utilizadas

- Java 21  
- Maven  
- JAX-WS (SOAP)  
- IntelliJ IDEA  

## 🚀 Como executar
> ⚠️ **Importante:** Cada módulo foi criado como um projeto Maven separado, conforme solicitado pelo professor.  
> Por isso, não é possível rodar o projeto diretamente pela pasta raiz `Winery`.  
> Para executar corretamente, abra cada pasta individualmente na IDE (ex: IntelliJ):
> - `WinerySys` → publica os serviços SOAP  
> - `WineStockClient` → consulta o estoque  
> - `WineOrderClient` → realiza pedidos e emite alertas  


1. **Publicar as APIs SOAP**  
   Execute a classe `Loader` no módulo `WinerySys` para publicar os serviços:

   - http://localhost:8085/WineStockService?wsdl -- `WineStockService`
   - http://localhost:8086/WineWarningService?wsdl -- `WineWarningService`

2. **Consultar o estoque**  
   Execute a classe `ApplicationClient1` no módulo `WineStockClient` para exibir o estoque de vinhos disponíveis.

3. **Realizar pedido e emitir alerta**  
   Execute a classe `ApplicationClient2` no módulo `WineOrderClient` para realizar um pedido e emitir um alerta de estoque baixo.

#

## 👩‍💻 Autora

**Carolina Cavalli Machado - RM: 552925**  
Projeto acadêmico desenvolvido para a matéria de SOA e Web Services da FIAP, com foco em integração de sistemas via serviços SOAP.
