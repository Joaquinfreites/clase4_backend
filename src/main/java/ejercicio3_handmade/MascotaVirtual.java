package ejercicio3_handmade;

public class MascotaVirtual {
    // energía un número entero entre 0 y 100
    private int energia;
    // humor un valor entero entre 1 y 5
    //muy enojado, enojado, neutral, contento y chocho respectivamente desde el 1 hasta el 5.
    private int humor;
    // Para resolver el que esté o no durmiendo
    private boolean durmiendo;
    private int cant_ingestas_cons;
    private boolean viva;
    private int cant_actividades_consecutivas;

    public MascotaVirtual(){

    }

    public MascotaVirtual(int energia, int humor, boolean durmiendo,  int cant_ingestas_cons,  boolean viva, int cant_actividades_consecutivas) {
        this.energia = energia;
        this.humor = humor;
        this.durmiendo = durmiendo;
        this.cant_ingestas_cons = cant_ingestas_cons;
        this.viva = viva;
        this.cant_actividades_consecutivas = cant_actividades_consecutivas;
    }

    // DE INGESTA


public boolean comer(){
        // A partir de la 3 ingesta consecutiva el nivel de humor
        // comienza a decrementar en 1 por cada ingesta.
        this.cant_ingestas_cons++;
        this.cant_actividades_consecutivas = 0;
        if (cant_ingestas_cons >= 3){
            this.humor--;
        } else{
            this.humor++;
        }
        //  Si la mascota realiza 5 ingestas consecutivas muere de empacho.
        if (this.cant_ingestas_cons == 5){
            this.viva = false;
        }
        // incrementa la energía (que es un número entre 0 y 100 unidades)
        // en 10% de la energía que tiene la mascota y incrementa el humor en 1 nivel.
        double incremento = (double) ( this.energia * 0.1);
        this.energia += incremento;
        return true;
    }

    public boolean beber(){
        // A partir de la 3 ingesta consecutiva el nivel de humor
        // comienza a decrementar en 1 por cada ingesta.
        this.cant_ingestas_cons++;
        this.cant_actividades_consecutivas = 0;
        if (cant_ingestas_cons >= 3){
            this.humor--;
        } else{
            this.humor++;
        }
        //  Si la mascota realiza 5 ingestas consecutivas muere de empacho.
        if (this.cant_ingestas_cons == 5){
            this.viva = false;
        }

        //incrementa la energía (que es un número entre 0 y 100 unidades)
        // en 5% de la energía que tiene la mascota y incrementa el humor en 1 nivel.
        double incremento = (double) ( this.energia * 0.05);
        this.energia += incremento;
        return true;
    }

    // DE ACTIVIDADES

    public boolean correr(){
        //decrementa la energía en un 35% de la energía que tiene la mascota.
        // Y decrementa el humor en 2 niveles.
        this.cant_ingestas_cons = 0;
        if (this.cant_actividades_consecutivas == 3){
            this.durmiendo = true;
        }
        double decremento = (double) (this.energia * 0.35);
        this.energia -= decremento;
        int decremento_humor = 2;
        this.humor -= decremento_humor;
        return true;
    }

    public boolean saltar(){
        //decrementa la energía en un 15% de la energía que tiene la mascota.
        // Y decrementa el humor en 2 niveles.
        this.cant_ingestas_cons = 0;
        if (this.cant_actividades_consecutivas == 3) {
            this.durmiendo = true;
        }
        double decremento = (double) (this.energia * 0.15);
        this.energia -= decremento;
        int decremento_humor = 2;
        this.humor += decremento_humor;
        return true;
    }
    // OTROS COMPORTAMIENTOS

    public boolean dormir(){
        //la mascota pasa a estado durmiendo y no responde a ningún otro comportamiento excepto despertar.
        // Además la energía se incrementa en 25 unidades y el humor en 2 niveles.
        this.cant_ingestas_cons = 0;
        this.cant_actividades_consecutivas = 0;
        this.durmiendo = true;
        this.energia += 25;
        this.humor +=  2;
        return true;
    }

    public boolean despertar(){
        // la mascota pasa a estado despierta y comienza a responder a los demás comportamientos.
        // Además el humor se decrementa en un nivel.
        this.cant_ingestas_cons = 0;
        this.cant_actividades_consecutivas = 0;
        if (this.energia == 0){
            this.viva = false;
        }
        this.durmiendo = false;
        this.humor -= 1;
        return true;
    }
}
/*
Agregar además el comportamiento toString que devuelva una representación de cadena de la mascota incluyendo su nombre, unidades de energía, nivel de alegría, si duerme y si vive.
Notas:
1. la energía no puede superar 100 unidades, es decir si está en 100 no aumenta y si baja de cero la mascota muere y ya no responde más a ningún comportamiento.
3. cuando la mascota está en un estado que no responde a cierto comportamiento el mismo debe retornar false y si el comportamiento se pudo realizar correctamente retorna true.

 */


