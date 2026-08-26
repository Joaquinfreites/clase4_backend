package ejercicio3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MascotaTest {

    private Mascota mascota;

    @BeforeEach
    public void setUp() {
        mascota = new Mascota("Firulais", 50, 3, true, false);
    }

    @Test
    @DisplayName("Comer aumenta la energía en 10% y humor en 1")
    public void testComer() {
        assertTrue(mascota.comer());
        assertEquals(55, mascota.getEnergia()); // 50 + 10% = 55
        assertEquals(4, mascota.getHumor()); // 3 + 1 = 4
    }

    @Test
    @DisplayName("Beber aumenta la energía en 5% y humor en 1")
    public void testBeber() {
        assertTrue(mascota.beber());
        assertEquals(52, mascota.getEnergia()); // 50 + 5% = 52 (int casting 50 * 0.05 = 2.5 -> 2)
        assertEquals(4, mascota.getHumor()); // 3 + 1 = 4
    }

    @Test
    @DisplayName("Correr disminuye la energía en 35% y humor en 2")
    public void testCorrer() {
        assertTrue(mascota.correr());
        assertEquals(33, mascota.getEnergia()); // 50 - (50 * 0.35 = 17.5 -> 17) = 33
        assertEquals(1, mascota.getHumor()); // 3 - 2 = 1
    }

    @Test
    @DisplayName("Saltar disminuye la energía en 15% y humor en 2")
    public void testSaltar() {
        assertTrue(mascota.saltar());
        assertEquals(43, mascota.getEnergia()); // 50 - (50 * 0.15 = 7.5 -> 7) = 43
        assertEquals(1, mascota.getHumor()); // 3 - 2 = 1
    }

    @Test
    @DisplayName("Regla 1: A partir de la 3era ingesta consecutiva decrementa el humor")
    public void testTerceraIngestaConsecutiva() {
        mascota.comer(); // 1er ingesta: humor 4
        mascota.comer(); // 2da ingesta: humor 5
        mascota.comer(); // 3ra ingesta: humor decrece en 1 -> 4
        assertEquals(4, mascota.getHumor());

        mascota.comer(); // 4ta ingesta: humor decrece en 1 -> 3
        assertEquals(3, mascota.getHumor());
    }

    @Test
    @DisplayName("Regla 3: 5 ingestas consecutivas causan la muerte por empacho")
    public void testMuertePorEmpacho() {
        mascota.comer(); // 1
        mascota.comer(); // 2
        mascota.comer(); // 3
        mascota.comer(); // 4
        assertTrue(mascota.isViva());
        mascota.comer(); // 5
        assertFalse(mascota.isViva()); // muere por empacho

        // Pet is dead, commands should return false
        assertFalse(mascota.comer());
        assertFalse(mascota.correr());
    }

    @Test
    @DisplayName("Regla 4: 3 actividades consecutivas causan que se empaque y duerma")
    public void testTresActividadesConsecutivas() {
        Mascota pet = new Mascota("Rocco", 100, 5, true, false);
        pet.saltar(); // 1era actividad
        assertFalse(pet.isDurmiendo());
        pet.saltar(); // 2da actividad
        assertFalse(pet.isDurmiendo());
        pet.saltar(); // 3era actividad -> se duerme
        assertTrue(pet.isDurmiendo());

        // Al estar durmiendo, no responde a actividades
        assertFalse(pet.saltar());
    }

    @Test
    @DisplayName("Regla 2: Si energía llega a 0 la mascota muere de cansada")
    public void testMuertePorCansancio() {
        Mascota pet = new Mascota("Debil", 10, 3, true, false);
        pet.setEnergia(0);
        assertEquals(0, pet.getEnergia());
        assertFalse(pet.isViva());
        assertFalse(pet.correr());
    }

    @Test
    @DisplayName("Dormir y Despertar")
    public void testDormirYDespertar() {
        Mascota pet = new Mascota("Sleeper", 50, 2, true, false);
        assertTrue(pet.dormir());
        assertTrue(pet.isDurmiendo());
        assertEquals(75, pet.getEnergia()); // 50 + 25
        assertEquals(4, pet.getHumor()); // 2 + 2

        // No responde a comer mientras duerme
        assertFalse(pet.comer());

        // Despertar
        assertTrue(pet.despertar());
        assertFalse(pet.isDurmiendo());
        assertEquals(3, pet.getHumor()); // 4 - 1
    }

    @Test
    @DisplayName("Nota 2: Si el humor llega a 0 o menos, la mascota se va a dormir")
    public void testAutoDormirPorHumor() {
        Mascota pet = new Mascota("Enojado", 80, 1, true, false);
        pet.correr(); // humor 1 - 2 = -1 -> pasa a dormir
        assertTrue(pet.isDurmiendo());
        assertEquals(1, pet.getHumor());
    }

    @Test
    @DisplayName("toString incluye nombre, energia, humor, durmiendo y viva")
    public void testToString() {
        String str = mascota.toString();
        assertTrue(str.contains("Firulais"));
        assertTrue(str.contains("energia"));
        assertTrue(str.contains("humor"));
        assertTrue(str.contains("durmiendo"));
        assertTrue(str.contains("viva"));
    }
}
