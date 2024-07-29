package Classes;

public class EstrategiaImpostoPadrao implements EstrategiaImposto {
    @Override
    public double calcularImposto(double valor) {
        // Imposto padrão de 10%
        return valor * 0.1;
    }
}
