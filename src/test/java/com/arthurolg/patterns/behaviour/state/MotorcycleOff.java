package com.arthurolg.patterns.behaviour.state;

public class MotorcycleOff implements MotorcycleState {

    private final Motorcycle motorcycle;

    public MotorcycleOff(Motorcycle motorcycle) {
        this.motorcycle = motorcycle;
    }

    @Override
    public void startUp() {
        System.out.println("La moto se ha encendido");
        this.motorcycle.setMotorcycleState(this.motorcycle.getMotorcycleOn());
    }

    @Override
    public void brakeOff() {
        System.out.println("Se ha quitado el freno");
        this.motorcycle.setMotorcycleState(this.motorcycle.getMotorcycleBrakeOff());
    }

    @Override
    public void shutDown() {
        System.out.println("La moto ya esta apagada");
    }

    @Override
    public void brakeOn() {
        System.out.println("Se ha puesto el freno a la moto");
        this.motorcycle.setMotorcycleState(this.motorcycle.getMotorcycleBrakeOn());
    }
}
