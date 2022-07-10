package com.arthurolg.patterns.behaviour.state;

public class MotorcycleBrakeOn implements MotorcycleState {
    private final Motorcycle motorcycle;

    public MotorcycleBrakeOn(Motorcycle motorcycle) {
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
        System.out.println("La moto sera apagada");
        this.motorcycle.setMotorcycleState(this.motorcycle.getMotorcycleOff());
    }

    @Override
    public void brakeOn() {
        System.out.println("Ya se ha quitado el freno");
    }
}
