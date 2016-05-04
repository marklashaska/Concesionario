/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public class Coches {

    static ArrayList<Coche> coches = new ArrayList();

    public static void creaCoches() {
        coches.add(new Coche("Astra", "6175zpr", 18000));
        coches.add(new Coche("Auris", "8390gdf", 12345));
        coches.add(new Coche("Ibiza", "4085jkl", 9532));
        coches.add(new Coche("Laguna", "8361ptv", 13765));
        coches.add(new Coche("Megane", "6208fcb", 9465));
        coches.add(new Coche("Prius", "2954xlg", 10526));
    }

}
