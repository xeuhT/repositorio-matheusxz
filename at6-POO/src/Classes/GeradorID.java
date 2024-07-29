package Classes;
import java.util.UUID;

public class GeradorID {
    public static String gerarIDUnico() {
        return UUID.randomUUID().toString();
    }
}
