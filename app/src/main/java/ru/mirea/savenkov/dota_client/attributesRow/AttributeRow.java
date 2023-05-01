package ru.mirea.savenkov.dota_client.attributesRow;

public class AttributeRow {
    private String rowName;
    private Double actualValue;
    private Double maxValue;

    public AttributeRow(String rowName, Double actualValue, Double maxValue) {
        this.rowName = rowName;
        this.actualValue = actualValue;
        this.maxValue = maxValue;
    }

    public AttributeRow() {}

    public String getRowName() {
        return rowName;
    }

    public void setRowName(String rowName) {
        this.rowName = rowName;
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
