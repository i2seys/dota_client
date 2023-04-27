package ru.mirea.savenkov.dota_client.config;

public class Attributes {
    private final int carry;
    private final int support;
    private final int burst;
    private final int control;
    private final int endurance;
    private final int escape;
    private final int push;
    private final int initiation;

    public Attributes(int carry, int support, int burst, int control, int endurance, int escape, int push, int initiation) {
        this.carry = carry;
        this.support = support;
        this.burst = burst;
        this.control = control;
        this.endurance = endurance;
        this.escape = escape;
        this.push = push;
        this.initiation = initiation;
    }

    public int getCarry() {
        return carry;
    }

    public int getSupport() {
        return support;
    }

    public int getBurst() {
        return burst;
    }

    public int getControl() {
        return control;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getEscape() {
        return escape;
    }

    public int getPush() {
        return push;
    }

    public int getInitiation() {
        return initiation;
    }
}
