package ru.mirea.savenkov.dota_client.heroSelectRow;

import java.util.Objects;

public class SingleHeroSelectRow {
    private Integer heroImage;
    private String heroName;
    private Double winrate;

    public SingleHeroSelectRow(Integer heroImage, String heroName, Double winrate) {
        this.heroImage = heroImage;
        this.heroName = heroName;
        this.winrate = winrate;
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

    public Double getWinrate() {
        return winrate;
    }

    public void setWinrate(Double winrate) {
        this.winrate = winrate;
    }

    @Override
    public String toString() {
        return "HeroSelectRow{" +
                "imageResource=" + heroImage +
                ", heroName='" + heroName + '\'' +
                ", winrate=" + winrate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleHeroSelectRow that = (SingleHeroSelectRow) o;
        return Objects.equals(heroImage, that.heroImage) && Objects.equals(heroName, that.heroName) && Objects.equals(winrate, that.winrate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heroImage, heroName, winrate);
    }
}
