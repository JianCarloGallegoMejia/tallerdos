package com.company;

public class Sensor {

    public static Sensor[][] sensores;
    private int estado;

    public Sensor(){
    }

    public Sensor(int e){
        this.estado = e;
    }

    public static String sensorLibre(){
        String value = "";
        for(int i = 0; i < sensores.length; i++){
            for(int j = 0; j < sensores[i].length; j++){
                if(sensores[i][j] == null){
                    value = value + "Piso: "+ (i+1) +  "-" + "Espacio: " + (j+1) + "    ";
                }
            }
            value = value + "\n";
        }
        return value;
    }

    public static String sensoresEstado(){
        String value = "";
        for(int i = 0; i < sensores.length; i++){
            for(int j = 0; j < sensores[i].length; j++){
                value = value + "Piso: "+ (i + 1) +  "-" + "Espacio: " + (j + 1) + " ";
                if(sensores[i][j] == null){
                    value = value + "Libre    ";
                }else{
                    value = value + "Ocupado    ";
                }
            }
            value = value + "\n";
        }
        return value;
    }

    @Override
    public String toString() {
        if(estado == 1){
            return "Ocupado";
        }else{
            return "Libre";
        }
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
