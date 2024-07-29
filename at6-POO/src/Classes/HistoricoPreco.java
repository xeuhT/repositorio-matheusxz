package Classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoricoPreco {
    private List<RegistroPreco> registros;

    public HistoricoPreco() {
        this.registros = new ArrayList<>();
    }

    public void registrarPreco(double preco, Date data) {
        registros.add(new RegistroPreco(preco, data));
    }

    public List<RegistroPreco> getRegistros() {
        return new ArrayList<>(registros);
    }

    public double getPrecoAtual() {
        if (!registros.isEmpty()) {
            return registros.get(registros.size() - 1).getPreco();
        }
        return 0.0;
    }

    public class RegistroPreco {
        private double preco;
        private Date data;

        public RegistroPreco(double preco, Date data) {
            this.preco = preco;
            this.data = data;
        }

        public double getPreco() {
            return preco;
        }

        public Date getData() {
            return data;
        }
    }
}
