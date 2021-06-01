package com.company;

import java.util.Date;

public class Moto extends Vehiculo{

    public Moto(String p, String m, String c, Date i){
        super(p, m, c, 30000000, i);
    }

    public Moto(String p, String m, String c, int v, Date i){
        super(p, m, c, v, i);
        cantidad += 1;
    }

    @Override
    public String tipoVehiculo() {
        return "Moto";
    }
}
