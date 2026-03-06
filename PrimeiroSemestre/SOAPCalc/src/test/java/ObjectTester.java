import br.com.fiap3espa.service.Sum;
import br.com.fiap3espa.service.Sub;
import br.com.fiap3espa.service.Mult;
import br.com.fiap3espa.service.Div;

public class ObjectTester {
    public static void main(String[] args) {
        Sum soma = new Sum();
        System.out.println(soma.showMessage(9, 27));
        System.out.println(soma.showName());
        System.out.println(soma.calculate(93, 21));

        Sub subtracao = new Sub();
        System.out.println(subtracao.showMessage(27, 9));
        System.out.println(subtracao.showName());
        System.out.println(subtracao.calculate(93, 21));

        Mult multiplicacao = new Mult();
        System.out.println(multiplicacao.showMessage(2, 12));
        System.out.println(multiplicacao.showName());
        System.out.println(multiplicacao.calculate(4, 8));

        Div divisao = new Div();
        System.out.println(divisao.showMessage(90, 5));
        System.out.println(divisao.showName());
        System.out.println(divisao.calculate(24, 10));
    }
}
