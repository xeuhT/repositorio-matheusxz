package Tests;

import Classes.Cliente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {

    @Test
    public void testGettersSetters() {
        Cliente cliente = new Cliente("João", "Rua A");
        assertEquals("João", cliente.getNome(), "O nome do cliente deve ser João.");
        assertEquals("Rua A", cliente.getEndereco(), "O endereço do cliente deve ser Rua A.");
        
        cliente.setNome("Maria");
        cliente.setEndereco("Rua B");
        
        assertEquals("Maria", cliente.getNome(), "O nome do cliente deve ser Maria.");
        assertEquals("Rua B", cliente.getEndereco(), "O endereço do cliente deve ser Rua B.");
    }
}
