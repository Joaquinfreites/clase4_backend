package ejercicio3;

public class Mascota {
    private String nombre;
    private int energia;
    private int humor;
    private boolean viva;
    private boolean durmiendo;
    private int ingestasConsecutivas;
    private int actividadesConsecutivas;

    public Mascota() {
        this("Mascota", 100, 3, true, false);
    }

    public Mascota(String nombre) {
        this(nombre, 100, 3, true, false);
    }

    public Mascota(int energia, int humor, boolean viva) {
        this("Mascota", energia, humor, viva, false);
    }

    public Mascota(String nombre, int energia, int humor) {
        this(nombre, energia, humor, true, false);
    }

    public Mascota(String nombre, int energia, int humor, boolean viva, boolean durmiendo) {
        this.nombre = nombre;
        this.energia = Math.min(100, Math.max(0, energia));
        this.humor = Math.min(5, Math.max(1, humor));
        this.viva = viva;
        this.durmiendo = durmiendo;
        this.ingestasConsecutivas = 0;
        this.actividadesConsecutivas = 0;
        if (this.energia <= 0) {
            this.viva = false;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = Math.min(100, Math.max(0, energia));
        if (this.energia <= 0) {
            this.viva = false;
        }
    }

    public int getHumor() {
        return humor;
    }

    public void setHumor(int humor) {
        this.humor = Math.min(5, Math.max(1, humor));
    }

    public boolean isViva() {
        return viva;
    }

    public void setViva(boolean viva) {
        this.viva = viva;
    }

    public boolean isDurmiendo() {
        return durmiendo;
    }

    public boolean isDormida() {
        return durmiendo;
    }

    public void setDurmiendo(boolean durmiendo) {
        this.durmiendo = durmiendo;
    }

    public void setDormida(boolean dormida) {
        this.durmiendo = dormida;
    }

    // Comportamientos de ingesta
    public boolean comer() {
        if (!this.viva || this.durmiendo) {
            return false;
        }
        this.actividadesConsecutivas = 0;
        this.ingestasConsecutivas++;

        int incremento = (int) (this.energia * 0.10);
        this.energia += incremento;
        if (this.energia > 100) {
            this.energia = 100;
        }

        if (this.ingestasConsecutivas >= 3) {
            this.humor--;
        } else {
            this.humor++;
        }
        if (this.ingestasConsecutivas >= 5){
            this.viva = false;
        }

        evaluarEstado();

        if (this.ingestasConsecutivas >= 5) {
            this.viva = false;
        }

        return true;
    }

    public boolean beber() {
        if (!this.viva || this.durmiendo) {
            return false;
        }
        this.actividadesConsecutivas = 0;
        this.ingestasConsecutivas++;

        int incremento = (int) (this.energia * 0.05);
        this.energia += incremento;
        if (this.energia > 100) {
            this.energia = 100;
        }

        if (this.ingestasConsecutivas >= 3) {
            this.humor--;
        } else {
            this.humor++;
        }

        evaluarEstado();

        if (this.ingestasConsecutivas >= 5) {
            this.viva = false;
        }

        return true;
    }

    // Comportamientos de actividad
    public boolean correr() {
        if (!this.viva || this.durmiendo) {
            return false;
        }
        this.ingestasConsecutivas = 0;
        this.actividadesConsecutivas++;

        int decremento = (int) (this.energia * 0.35);
        this.energia -= decremento;
        this.humor -= 2;

        evaluarEstado();

        if (this.actividadesConsecutivas >= 3 && this.viva) {
            this.durmiendo = true;
            this.actividadesConsecutivas = 0;
        }

        return true;
    }

    public boolean saltar() {
        if (!this.viva || this.durmiendo) {
            return false;
        }
        this.ingestasConsecutivas = 0;
        this.actividadesConsecutivas++;

        int decremento = (int) (this.energia * 0.15);
        this.energia -= decremento;
        this.humor -= 2;

        evaluarEstado();

        if (this.actividadesConsecutivas >= 3 && this.viva) {
            this.durmiendo = true;
            this.actividadesConsecutivas = 0;
        }

        return true;
    }

    // Otros comportamientos
    public boolean dormir() {
        if (!this.viva || this.durmiendo) {
            return false;
        }
        this.durmiendo = true;
        this.energia += 25;
        if (this.energia > 100) {
            this.energia = 100;
        }
        this.humor += 2;
        if (this.humor > 5) {
            this.humor = 5;
        }
        this.ingestasConsecutivas = 0;
        this.actividadesConsecutivas = 0;
        return true;
    }

    public boolean despertar() {
        if (!this.viva || !this.durmiendo) {
            return false;
        }
        this.durmiendo = false;
        this.humor -= 1;
        if (this.humor < 1) {
            this.humor = 1;
        }
        this.ingestasConsecutivas = 0;
        this.actividadesConsecutivas = 0;
        return true;
    }

    private void evaluarEstado() {
        if (this.energia <= 0) {
            this.energia = 0;
            this.viva = false;
        }
        if (this.humor > 5) {
            this.humor = 5;
        }
        if (this.humor <= 0) {
            this.humor = 1;
            if (this.viva) {
                this.durmiendo = true;
            }
        }
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", energia=" + energia +
                ", humor=" + humor +
                ", durmiendo=" + durmiendo +
                ", viva=" + viva +
                '}';
    }
}

