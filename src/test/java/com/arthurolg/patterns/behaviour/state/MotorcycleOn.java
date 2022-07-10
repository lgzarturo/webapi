package com.arthurolg.patterns.behaviour.state;

public class MotorcycleOn implements MotorcycleState {

    private final Motorcycle motorcycle;

    public MotorcycleOn(Motorcycle motorcycle) {
        this.motorcycle = motorcycle;
    }

    @Override
    public void startUp() {
        System.out.println("La moto ya esta encendida");
    }

    @Override
    public void brakeOff() {
        System.out.println("El freno de la moto esta libre");
        this.motorcycle.setMotorcycleState(motorcycle.getMotorcycleBrakeOff());
    }

    @Override
    public void shutDown() {
        System.out.println("La moto esta apagada");
        this.motorcycle.setMotorcycleState(motorcycle.getMotorcycleOff());
    }

    @Override
    public void brakeOn() {
        System.out.println("La moto tiene el freno puesto");
        this.motorcycle.setMotorcycleState(motorcycle.getMotorcycleBrakeOn());
    }
}
