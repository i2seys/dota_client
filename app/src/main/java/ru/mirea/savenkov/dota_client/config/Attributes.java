package ru.mirea.savenkov.dota_client.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Attributes {
    public enum ATTRIBUTE{
        CARRY,
        SUPPORT,
        BURST,
        CONTROL,
        ENDURANCE,
        ESCAPE,
        PUSH,
        INITIATION;
        public String getNiceHero(){
            return attributes[this.ordinal()];
        }
    }
    public static final String[] attributes = {"Основа","Поддержка","Быстрый урон",
            "Контроль", "Стойкость","Побег", "Осада", "Инициация"};
    public static final HashMap<String, ATTRIBUTE> stringAttributeHashMap = new HashMap<String, ATTRIBUTE>(){{
        put(attributes[0], ATTRIBUTE.CARRY);
        put(attributes[1], ATTRIBUTE.SUPPORT);
        put(attributes[2], ATTRIBUTE.BURST);
        put(attributes[3], ATTRIBUTE.CONTROL);
        put(attributes[4], ATTRIBUTE.ENDURANCE);
        put(attributes[5], ATTRIBUTE.ESCAPE);
        put(attributes[6], ATTRIBUTE.PUSH);
        put(attributes[7], ATTRIBUTE.INITIATION);
    }};

    private Double carry;
    private Double support;
    private Double burst;
    private Double control;
    private Double endurance;
    private Double escape;
    private Double push;
    private Double initiation;

    public Attributes(Double carry, Double support, Double burst, Double control, Double endurance, Double escape, Double push, Double initiation) {
        this.carry = carry;
        this.support = support;
        this.burst = burst;
        this.control = control;
        this.endurance = endurance;
        this.escape = escape;
        this.push = push;
        this.initiation = initiation;
    }

    public Double getCarry() {
        return carry;
    }

    public void setCarry(Double carry) {
        this.carry = carry;
    }

    public Double getSupport() {
        return support;
    }

    public void setSupport(Double support) {
        this.support = support;
    }

    public Double getBurst() {
        return burst;
    }

    public void setBurst(Double burst) {
        this.burst = burst;
    }

    public Double getControl() {
        return control;
    }

    public void setControl(Double control) {
        this.control = control;
    }

    public Double getEndurance() {
        return endurance;
    }

    public void setEndurance(Double endurance) {
        this.endurance = endurance;
    }

    public Double getEscape() {
        return escape;
    }

    public void setEscape(Double escape) {
        this.escape = escape;
    }

    public Double getPush() {
        return push;
    }

    public void setPush(Double push) {
        this.push = push;
    }

    public Double getInitiation() {
        return initiation;
    }

    public void setInitiation(Double initiation) {
        this.initiation = initiation;
    }

    @Override
    public String toString() {
        return "Attributes{" +
                "carry=" + carry +
                ", support=" + support +
                ", burst=" + burst +
                ", control=" + control +
                ", endurance=" + endurance +
                ", escape=" + escape +
                ", push=" + push +
                ", initiation=" + initiation +
                '}';
    }
}

