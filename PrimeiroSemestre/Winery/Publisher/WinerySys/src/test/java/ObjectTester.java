import br.com.fiap.winery.WineStockServiceImplementation;
import br.com.fiap.winery.WineWarningServiceImplementation;

public class ObjectTester {
    public static void main(String[] args) {
        WineStockServiceImplementation wineStock = new WineStockServiceImplementation();
        System.out.println(wineStock.getMenu());
        System.out.println(wineStock.placeOrder("Sauvignon Blanc", 2));

        WineWarningServiceImplementation wineWarn = new WineWarningServiceImplementation();
        System.out.println(wineWarn.sendWarn());
    }
}