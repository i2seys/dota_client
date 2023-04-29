package ru.mirea.savenkov.dota_client.finalDisadvantageRow;

public class FinalDisadvantageRow {
    private Integer heroImage;
    private Double disadvantage;

    public FinalDisadvantageRow(Integer heroImage, Double disadvantage) {
        this.heroImage = heroImage;
        this.disadvantage = disadvantage;
    }

    public Integer getHeroImage() {
        return heroImage;
    }

    public void setHeroImage(Integer heroImage) {
        this.heroImage = heroImage;
    }

    public Double getDisadvantage() {
        return disadvantage;
    }

    public void setDisadvantage(Double disadvantage) {
        this.disadvantage = disadvantage;
    }
}
