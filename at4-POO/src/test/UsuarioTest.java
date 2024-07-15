package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import model.*;

public class UsuarioTest {

    @Test
    public void testCriacaoUsuario() {
        Usuario usuario = new Usuario("João", "admin", true);
        assertEquals("João", usuario.getNome());
        assertEquals("admin", usuario.isAdmin());
    }
}
