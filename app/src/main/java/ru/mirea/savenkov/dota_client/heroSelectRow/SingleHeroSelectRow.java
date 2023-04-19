package ru.mirea.savenkov.dota_client.heroSelectRow;

import java.util.Objects;

public class SingleHeroSelectRow {
    private Integer heroImage;
    private String heroName;
    private Double value;

    public SingleHeroSelectRow(Integer heroImage, String heroName, Double value) {
        this.heroImage = heroImage;
        this.heroName = heroName;
        this.value = value;
    }

    public SingleHeroSelectRow() {
    }

    public Integer getHeroImage() {
        return heroImage;
    }

    public void setHeroImage(Integer heroImage) {
        this.heroImage = heroImage;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "HeroSelectRow{" +
                "imageResource=" + heroImage +
                ", heroName='" + heroName + '\'' +
                ", winrate=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleHeroSelectRow that = (SingleHeroSelectRow) o;
        return Objects.equals(heroImage, that.heroImage) && Objects.equals(heroName, that.heroName) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heroImage, heroName, value);
    }
}
