package com.company;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static com.company.Sensor.sensores;
import static com.company.Vehiculo.vehiculos;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int pisos, espacios, decision, pisoUsuario, espacioUsuario, valorComercial, precioCarro, precioMoto;
        String placa, marca, color;

        System.out.println("Ingrese la candidad de pisos");
        pisos = sc.nextInt();

        System.out.println("Ingrese la cantidad de espacios");
        espacios = sc.nextInt();

        System.out.println(("Ingrese el precio por carro"));
        precioCarro = sc.nextInt();

        System.out.println("Ingrese el precio por moto");
        precioMoto = sc.nextInt();

        vehiculos = new Vehiculo[pisos][espacios];
        sensores = new Sensor[pisos][espacios];

        Vehiculo.tamaño = espacios * pisos;

        System.out.println("¿Qué desea hacer a continuación?");
        decision = sc.nextInt();

        while (decision != 0){
            switch (decision){
                case 0:
                    System.out.println("Saliendo");
                    break;
                case 1:
                    System.out.println(Sensor.sensorLibre());
                    break;
                case 2:
                    System.out.println("¿En qué piso desea guardar el vehículo?");
                    pisoUsuario = sc.nextInt();
                    System.out.println("¿En qué espacio desea guardar el vehículo?");
                    espacioUsuario = sc.nextInt();
                    if(vehiculos[pisoUsuario-1][espacioUsuario-1] != null){
                        System.out.println("El espacio ya está ocupado");
                    }else{
                        System.out.println("Ingrese la placa");
                        placa = sc.next();
                        System.out.println("Ingrese la marca");
                        marca = sc.next();
                        System.out.println("Ingrese el color");
                        color = sc.next();
                        String tipoVehiculo;

                        System.out.println("Ingrese el tipo de vehículo ");
                        tipoVehiculo = sc.next();

                        if(tipoVehiculo.equalsIgnoreCase("carro")){
                            Date date = new Date();
                            Carro carro = new Carro(placa, marca, color, date);
                            vehiculos[pisoUsuario-1][espacioUsuario-1] = carro;
                            Sensor sensor = new Sensor(1);
                            sensores[pisoUsuario-1][espacioUsuario-1] = sensor;
                            System.out.println(carro.toString());
                        }else{
                            Date date = new Date();
                            Moto moto = new Moto(placa, marca, color, date);
                            vehiculos[pisoUsuario-1][espacioUsuario-1] = moto;
                            Sensor sensor = new Sensor(1);
                            sensores[pisoUsuario-1][espacioUsuario-1] = sensor;
                            System.out.println(moto.toString());
                        }

                    }
                    break;
                case 3:
                    System.out.println("¿En qué piso desea guardar el vehículo?");
                    pisoUsuario = sc.nextInt();
                    System.out.println("¿En qué espacio desea guardar el vehículo?");
                    espacioUsuario = sc.nextInt();
                    if(vehiculos[pisoUsuario-1][espacioUsuario-1] != null){
                        System.out.println("El espacio ya está ocupado");
                    }else{
                        System.out.println("Ingrese la placa");
                        placa = sc.next();
                        System.out.println("Ingrese la marca");
                        marca = sc.next();
                        System.out.println("Ingrese el color");
                        color = sc.next();
                        System.out.println("Ingrese el valor");
                        valorComercial = sc.nextInt();

                        String tipoVehiculo;

                        System.out.println("Ingrese el tipo de vehículo ");
                        tipoVehiculo = sc.next();

                        if(tipoVehiculo.equalsIgnoreCase("carro")){

                            Date date = new Date();
                            Carro carro = new Carro(placa, marca, color, date);
                            vehiculos[pisoUsuario-1][espacioUsuario-1] = carro;
                            Sensor sensor = new Sensor(1);
                            sensores[pisoUsuario-1][espacioUsuario-1] = sensor;
                            System.out.println(carro.toString());

                        }else{
                            Date date = new Date();

                            Moto moto = new Moto(placa, marca, color, date);
                            vehiculos[pisoUsuario-1][espacioUsuario-1] = moto;
                            Sensor sensor = new Sensor(1);
                            sensores[pisoUsuario-1][espacioUsuario-1] = sensor;
                            System.out.println(moto.toString());

                        }

                    }
                    break;
                case 4:
                    System.out.println(Vehiculo.toStringVehiculos());
                    break;
                case 5:
                    System.out.println("Hay: "+ Vehiculo.cantidadVehículos() + " vehículos actualmente");
                    break;
                case 6:
                    System.out.println("¿En qué piso desea guardar el vehículo?");
                    pisoUsuario = sc.nextInt();
                    System.out.println("¿En qué espacio desea guardar el vehículo?");
                    espacioUsuario = sc.nextInt();
                    if(sensores[pisoUsuario-1][espacioUsuario-1] == null) {
                        System.out.println("Libre");
                    }else{
                        System.out.println("Ocupado");
                    }
                    break;
                case 7:
                    System.out.println(Sensor.sensoresEstado());
                    break;
                case 8:
                    System.out.println("Ingrese el color");
                    color = sc.next();
                    System.out.println(Vehiculo.vehiculoPorColor(color));
                    break;
                case 9:
                    Vehiculo[] array = Vehiculo.vehiculosPorValorComercial();
                    for(int i = 0; i < array.length; i++){
                        if(array[i] != null){
                            System.out.println(array[i]);
                        }
                    }
                    break;
                case 10:
                    int pisoRetiro, espacioRetiro;
                    System.out.println("¿En qué piso está el sensor a retirar?");
                    pisoRetiro = sc.nextInt();
                    System.out.println("¿En qué espacio está el sensor a retirar?");
                    espacioRetiro = sc.nextInt();

                    if(vehiculos[pisoRetiro-1][espacioRetiro-1] != null) {

                        int total = 0;

                        SimpleDateFormat sdf
                                = new SimpleDateFormat(
                                "dd-MM-yyyy HH:mm:ss");

                        try {

                            Date d1 = sdf.parse(vehiculos[pisoRetiro-1][espacioRetiro-1].getParsedDate());
                            Date d2 = sdf.parse(sdf.format(new Date()).replace("/", ""));


                            long difference_In_Time
                                    = d2.getTime() - d1.getTime();

                            long difference_In_Seconds
                                    = (difference_In_Time
                                    / 1000)
                                    % 60;

                            long difference_In_Minutes
                                    = (difference_In_Time
                                    / (1000 * 60))
                                    % 60;

                            long difference_In_Hours
                                    = (difference_In_Time
                                    / (1000 * 60 * 60))
                                    % 24;

                            long difference_In_Years
                                    = (difference_In_Time
                                    / (1000l * 60 * 60 * 24 * 365));

                            long difference_In_Days
                                    = (difference_In_Time
                                    / (1000 * 60 * 60 * 24))
                                    % 365;


                            System.out.print(
                                    "Tiempo "
                                            + "que lleva parqueado el vehículo: ");

                            System.out.println(
                                    difference_In_Years
                                            + " años, "
                                            + difference_In_Days
                                            + " dias, "
                                            + difference_In_Hours
                                            + " horas, "
                                            + difference_In_Minutes
                                            + " minutos, "
                                            + difference_In_Seconds
                                            + " segundos");
                            total = (int) difference_In_Days * 24 + (int) difference_In_Years * 8760;
                            if ((int) difference_In_Minutes >= 0 && (int) difference_In_Minutes <= 59 && (int) difference_In_Days == 0 && (int) difference_In_Years == 0) {
                                total = 1;
                            }

                        }


                        // Catch the Exception
                        catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (vehiculos[pisoRetiro - 1][espacioRetiro - 1].tipoVehiculo().equalsIgnoreCase("carro")) {
                            System.out.println("El total a cobrar es :" + total * precioCarro);

                        } else {
                            System.out.println("El total a cobrar es :" + total * precioMoto);
                        }
                        sensores[pisoRetiro - 1][espacioRetiro - 1] = null;
                        vehiculos[pisoRetiro - 1][espacioRetiro - 1] = null;
                    }else{
                        System.out.println("El sensor está vacío");
                    }

                    break;
                case 11:
                    FileWriter fw = new FileWriter("archivo.txt",true);
                    PrintWriter writer = new PrintWriter(fw);

                    writer.println(Vehiculo.toStringVehiculos());

                    writer.close();

                    System.out.println("Archivo generado");
                    break;

                default:
                    System.out.println("Comando incorrecto");
                    break;


            }
            System.out.println("¿Qué desea hacer a continuación?");
            decision = sc.nextInt();
        }

    }
}
