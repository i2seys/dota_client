package ru.mirea.savenkov.dota_client.dto;

import ru.mirea.savenkov.dota_client.config.DotabuffInfo;

public class HeroWinrate {
    private Integer id;
    private DotabuffInfo.HEROES hero;
    private Double winrate;
    public HeroWinrate(Integer id, DotabuffInfo.HEROES hero, Double winrate) {
        this.id = id;
        this.hero = hero;
        this.winrate = winrate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DotabuffInfo.HEROES getHero() {
        return hero;
    }

    public void setHero(DotabuffInfo.HEROES hero) {
        this.hero = hero;
    }

    public Double getWinrate() {
        return winrate;
    }

    public void setWinrate(Double winrate) {
        this.winrate = winrate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HeroWinrate{");
        sb.append("id=").append(id);
        sb.append(", hero=").append(hero);
        sb.append(", winrate=").append(winrate);
        sb.append('}');
        return sb.toString();
    }
}
