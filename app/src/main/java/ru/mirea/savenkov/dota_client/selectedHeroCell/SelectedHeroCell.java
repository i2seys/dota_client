package ru.mirea.savenkov.dota_client.selectedHeroCell;

import java.io.Serializable;
import java.util.Objects;

public class SelectedHeroCell implements Serializable {
    private Integer heroImage;
    private String heroName;

    public SelectedHeroCell(Integer heroImage, String heroName) {
        this.heroImage = heroImage;
        this.heroName = heroName;
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

    @Override
    public String toString() {
        return "SelectedHeroCell{" +
                "imageResource=" + heroImage +
                ", heroName='" + heroName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelectedHeroCell that = (SelectedHeroCell) o;
        return Objects.equals(heroImage, that.heroImage) && Objects.equals(heroName, that.heroName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heroImage, heroName);
    }
}
