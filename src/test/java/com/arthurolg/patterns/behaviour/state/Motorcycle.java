package com.arthurolg.patterns.behaviour.state;

import lombok.Data;

@Data
public class Motorcycle implements MotorcycleState {

    MotorcycleState motorcycleOn;
    MotorcycleState motorcycleOff;
    MotorcycleState motorcycleBrakeOn;
    MotorcycleState motorcycleBrakeOff;
    MotorcycleState motorcycleState;

    public Motorcycle() {
        this.motorcycleOn = new MotorcycleOn(this);
        this.motorcycleOff = new MotorcycleOff(this);
        this.motorcycleBrakeOff = new MotorcycleBrakeOff(this);
        this.motorcycleBrakeOn = new MotorcycleBrakeOn(this);
        this.motorcycleState = this.motorcycleOff;
    }

    @Override
    public void startUp() {
        this.motorcycleState.startUp();
    }

    @Override
    public void brakeOff() {
        this.motorcycleState.brakeOff();
    }

    @Override
    public void shutDown() {
        this.motorcycleState.shutDown();
    }

    @Override
    public void brakeOn() {
        this.motorcycleState.brakeOn();
    }
}
