package ru.mirea.savenkov.dota_client.selectedHeroCell;

import java.io.Serializable;
import java.util.Objects;

public class SelectedHeroCell implements Serializable {
    private Integer heroImage;
    private String heroName;
    private Double value;

    public SelectedHeroCell(Integer heroImage, String heroName, Double value) {
        this.heroImage = heroImage;
        this.heroName = heroName;
        this.value = value;
    }

    public SelectedHeroCell() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelectedHeroCell that = (SelectedHeroCell) o;
        return Objects.equals(heroImage, that.heroImage) && Objects.equals(heroName, that.heroName) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heroImage, heroName, value);
    }

    @Override
    public String toString() {
        return "SelectedHeroCell{" +
                "heroImage=" + heroImage +
                ", heroName='" + heroName + '\'' +
                ", value=" + value +
                '}';
    }
}
