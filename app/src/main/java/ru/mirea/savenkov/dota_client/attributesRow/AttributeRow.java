package ru.mirea.savenkov.dota_client.attributesRow;

import ru.mirea.savenkov.dota_client.config.Attributes;

public class AttributeRow {
    private Attributes.ATTRIBUTE attributeName;
    private Double actualValue;
    private Double maxValue;

    public AttributeRow(Attributes.ATTRIBUTE attributeName, Double actualValue, Double maxValue) {
        this.attributeName = attributeName;
        this.actualValue = actualValue;
        this.maxValue = maxValue;
    }

    public AttributeRow() {}

    public Attributes.ATTRIBUTE getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(Attributes.ATTRIBUTE attributeName) {
        this.attributeName = attributeName;
    }

    public Double getActualValue() {
        return actualValue;
    }

    public void setActualValue(Double actualValue) {
        this.actualValue = actualValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }
}
