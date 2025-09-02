# 🍷 Winery Project

Este projeto Java tem como objetivo consumir dois serviços SOAP relacionados à gestão de vinhos: `WineStockService` e `WineWarningService`. Utiliza o plugin `jaxws-maven-plugin` para gerar automaticamente as classes Java a partir dos arquivos WSDL.

# 

## 🏭 Publisher > WinerySys

Parte responsável pela **criação das APIs SOAP**:

- **WineStockService**: consulta o estoque de vinhos e registra pedidos.
- **WineWarningService**: emite alertas quando o estoque está abaixo do necessário.

## 🛒 Consumers

Parte responsável pelo **consumo das APIs SOAP**:

- **WineStockClient**: consome apenas a API de estoque.
- **WineOrderClient**: consome ambas as APIs para realizar pedidos e emitir alertas quando o estoque é insuficiente.

# 

## 🚀 Como executar

1. **Publicar as APIs SOAP**  
   Execute a classe `Loader` no módulo `Publisher` para publicar os serviços:

   - [http://localhost:8085/WineStockService?wsdl](http://localhost:8085/WineStockService?wsdl)
   - [http://localhost:8086/WineWarningService?wsdl](http://localhost:8086/WineWarningService?wsdl)

2. **Consultar o estoque**  
   Execute a classe `ApplicationClient1` no módulo `WineStockClient` para exibir o estoque de vinhos disponíveis.

3. **Realizar pedido e emitir alerta**  
   Execute a classe `ApplicationClient2` no módulo `WineOrderClient` para realizar um pedido e, se necessário, emitir um alerta de estoque baixo.

#

## 👩‍💻 Autora

**Carolina Cavalli Machado - RM: 552925**  
Projeto acadêmico desenvolvido para a matéria de SOA e Web Services da FIAP, com foco em integração de sistemas via serviços SOAP.
