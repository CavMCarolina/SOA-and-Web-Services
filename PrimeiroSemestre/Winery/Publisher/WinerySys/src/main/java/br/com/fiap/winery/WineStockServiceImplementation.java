package br.com.fiap.winery;

import jakarta.jws.WebService;

// Serviço conectado com a interface
@WebService(endpointInterface = "br.com.fiap.winery.WineStockService")

public class WineStockServiceImplementation implements WineStockService {
    // Lista de Vinhos
    @Override
    public String getMenu() {
        String menu = "\n~~~ Menu de Vinhos ~~~\n";

        menu += "\n~ Tintos ~\n";
        menu += "1. Cabernet Sauvignon\n";
        menu += "2. Merlot\n";
        menu += "3. Pinot Noir\n";
        menu += "4. Tempranillo\n";

        menu += "\n~ Brancos ~\n";
        menu += "5. Chardonnay\n";
        menu += "6. Sauvignon Blanc\n";
        menu += "7. Riesling\n";

        menu += "\n~ Rosés ~\n";
        menu += "8. Aurora Rosada\n";
        menu += "9. Pétala de Verão\n";
        menu += "10. Brisa Coral";

        return menu;
    }

    // Pedido confirmado --> nome e quantidade
    @Override
    public String placeOrder(String name, int quantity) {
        return "\n~~~ Pedido Confirmado! ~~~\nVocê solicitou " + quantity + " " + name;
    }
}

