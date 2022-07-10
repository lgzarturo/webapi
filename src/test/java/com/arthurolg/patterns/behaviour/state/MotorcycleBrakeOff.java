package com.arthurolg.patterns.behaviour.state;

public class MotorcycleBrakeOff implements MotorcycleState {
    private final Motorcycle motorcycle;

    public MotorcycleBrakeOff(Motorcycle motorcycle) {
        this.motorcycle = motorcycle;
    }

    @Override
    public void startUp() {
        System.out.println("La moto se ha encendido");
        this.motorcycle.setMotorcycleState(this.motorcycle.getMotorcycleOn());
    }

    @Override
    public void brakeOff() {
        System.out.println("Ya se ha quitado el freno");
    }

    @Override
    public void shutDown() {
        System.out.println("La moto ha sido apagada");
        this.motorcycle.setMotorcycleState(this.motorcycle.getMotorcycleOff());
    }

    @Override
    public void brakeOn() {
        System.out.println("Se ha puesto el freno a la moto");
        this.motorcycle.setMotorcycleState(this.motorcycle.getMotorcycleBrakeOn());
    }
}
