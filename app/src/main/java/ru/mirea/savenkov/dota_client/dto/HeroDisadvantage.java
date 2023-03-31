package ru.mirea.savenkov.dota_client.dto;

import ru.mirea.savenkov.dota_client.config.DotabuffInfo;

public class HeroDisadvantage {

    private Integer id;
    private DotabuffInfo.HEROES innerHero;
    private DotabuffInfo.HEROES outerHero;
    private Double percent;
    public HeroDisadvantage(Integer id, DotabuffInfo.HEROES innerHero, DotabuffInfo.HEROES outerHero, double percent) {
        this.id = id;
        this.innerHero = innerHero;
        this.outerHero = outerHero;
        this.percent = percent;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DotabuffInfo.HEROES getInnerHero() {
        return innerHero;
    }

    public void setInnerHero(DotabuffInfo.HEROES innerHero) {
        this.innerHero = innerHero;
    }

    public DotabuffInfo.HEROES getOuterHero() {
        return outerHero;
    }

    public void setOuterHero(DotabuffInfo.HEROES outerHero) {
        this.outerHero = outerHero;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HeroDisadvantage{");
        sb.append("id=").append(id);
        sb.append(", innerHero=").append(innerHero);
        sb.append(", outerHero=").append(outerHero);
        sb.append(", percent=").append(percent);
        sb.append('}');
        return sb.toString();
    }
}

