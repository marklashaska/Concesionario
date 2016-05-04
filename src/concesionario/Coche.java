/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

/**
 *
 * @author Alumno
 */
public class Coche {

    private String modelo;
    private String matricula;
    private int precio;
    static String listaNumeros = "0123456789";
    Coches coches = new Coches();

    Coche(String modelo, String matricula, int precio) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.precio = precio;
    }

    public String toArray(int x, int y) {
        if (y == 0) {
            return Coches.coches.get(x).getModelo();
        }
        if (y == 1) {
            return Coches.coches.get(x).getMatricula().toUpperCase();
        }
        if (y == 2) {
            return Integer.toString(Coches.coches.get(x).getPrecio());
        }
        return null;
    }

    public static String matriculaNueva(String matricula1, String matricula2) {
        String matriculaNueva = null;
        int x = 4;
        int y = 0;
        char letra1 = 0;
        char letra2 = 0;
        boolean encontrado = false;
        int contador = 0;
        do {
            if (x < 7) {
                letra1 = matricula1.charAt(x);
                letra2 = matricula2.charAt(x);
            }
            if (letra1 == letra2 && contador < 3) {
                x++;
                contador++;
            } else if (letra1 > letra2 && contador < 3) {
                matriculaNueva = matricula1;
                encontrado = true;
            } else if (contador < 3) {
                matriculaNueva = matricula2;
                encontrado = false;
            }
            if (contador == 3) {
                letra1 = matricula1.charAt(y);
                letra2 = matricula2.charAt(y);
                if (letra1 == letra2) {
                    y++;
                } else if (letra1 > letra2) {
                    matriculaNueva = matricula1;
                    encontrado = true;
                } else {
                    matriculaNueva = matricula2;
                    encontrado = true;
                }
            }
        } while (encontrado == false && y != 4);
        return matriculaNueva;
    }

    public String masBarato() {
        String barato = null;
        for (int x = 0; x < Coches.coches.size(); x++) {
            if (Coches.coches.get(x + 1).precio < Coches.coches.get(x).precio) {
                barato = Coches.coches.get(x).matricula;
            }
        }
        return barato;
    }

    public static boolean compruebaMatricula(String matricula) {
        int matriCorrecta = 0;
        if (matricula.length() != 7) {
            return false;
        } else {
            for (int x = 0; x <= 3; x++) {
                for (int y = 0; y < listaNumeros.length(); y++) {
                    if (matricula.charAt(x) == listaNumeros.charAt(y)) {
                        matriCorrecta++;
                    }
                }
            }
            for (int x = 4; x < 7; x++) {
                for (int y = 0; y < Pantalla.letrasCorrectas.length(); y++) {
                    if (matricula.charAt(x) == Pantalla.letrasCorrectas.charAt(y)) {
                        matriCorrecta++;
                    }
                }
            }
        }
        if (matriCorrecta != 7) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean compruebaCoche(String modelo, String matricula, int precio) {
        boolean todoCorrecto = true;
        if (modelo.length() == 0) {
            todoCorrecto = false;
        }
        if ((matricula.length() == 0) || (Coche.compruebaMatricula(matricula.toLowerCase()) == false)) {
            todoCorrecto = false;
        }
        if (precio == 0 || precio < 0) {
            todoCorrecto = false;
        }
        if (todoCorrecto == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
