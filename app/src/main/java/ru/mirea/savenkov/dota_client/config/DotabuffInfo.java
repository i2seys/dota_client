package ru.mirea.savenkov.dota_client.config;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DotabuffInfo {

    public static final int heroesCount = HEROES.values().length;
    public enum HEROES{
        @SerializedName("ABADDON")
        ABADDON,
        @SerializedName("ALCHEMIST")
        ALCHEMIST,
        @SerializedName("ANCIENT_APPARITION")
        ANCIENT_APPARITION,
        @SerializedName("ANTI_MAGE")
        ANTI_MAGE,
        @SerializedName("ARC_WARDEN")
        ARC_WARDEN,
        @SerializedName("AXE")
        AXE,
        @SerializedName("BANE")
        BANE,
        @SerializedName("BATRIDER")
        BATRIDER,
        @SerializedName("BEASTMASTER")
        BEASTMASTER,
        @SerializedName("BLOODSEEKER")
        BLOODSEEKER,
        @SerializedName("BOUNTY_HUNTER")
        BOUNTY_HUNTER,
        @SerializedName("BREWMASTER")
        BREWMASTER,
        @SerializedName("BRISTLEBACK")
        BRISTLEBACK,
        @SerializedName("BROODMOTHER")
        BROODMOTHER,
        @SerializedName("CENTAUR_WARRUNNER")
        CENTAUR_WARRUNNER,
        @SerializedName("CHAOS_KNIGHT")
        CHAOS_KNIGHT,
        @SerializedName("CHEN")
        CHEN,
        @SerializedName("CLINKZ")
        CLINKZ,
        @SerializedName("CLOCKWERK")
        CLOCKWERK,
        @SerializedName("CRYSTAL_MAIDEN")
        CRYSTAL_MAIDEN,
        @SerializedName("DARK_SEER")
        DARK_SEER,
        @SerializedName("DARK_WILLOW")
        DARK_WILLOW,
        @SerializedName("DAWNBREAKER")
        DAWNBREAKER,
        @SerializedName("DAZZLE")
        DAZZLE,
        @SerializedName("DEATH_PROPHET")
        DEATH_PROPHET,
        @SerializedName("DISRUPTOR")
        DISRUPTOR,
        @SerializedName("DOOM")
        DOOM,
        @SerializedName("DRAGON_KNIGHT")
        DRAGON_KNIGHT,
        @SerializedName("DROW_RANGER")
        DROW_RANGER,
        @SerializedName("EARTH_SPIRIT")
        EARTH_SPIRIT,
        @SerializedName("EARTHSHAKER")
        EARTHSHAKER,
        @SerializedName("ELDER_TITAN")
        ELDER_TITAN,
        @SerializedName("EMBER_SPIRIT")
        EMBER_SPIRIT,
        @SerializedName("ENCHANTRESS")
        ENCHANTRESS,
        @SerializedName("ENIGMA")
        ENIGMA,
        @SerializedName("FACELESS_VOID")
        FACELESS_VOID,
        @SerializedName("GRIMSTROKE")
        GRIMSTROKE,
        @SerializedName("GYROCOPTER")
        GYROCOPTER,
        @SerializedName("HOODWINK")
        HOODWINK,
        @SerializedName("HUSKAR")
        HUSKAR,
        @SerializedName("INVOKER")
        INVOKER,
        @SerializedName("IO")
        IO,
        @SerializedName("JAKIRO")
        JAKIRO,
        @SerializedName("JUGGERNAUT")
        JUGGERNAUT,
        @SerializedName("KEEPER_OF_THE_LIGHT")
        KEEPER_OF_THE_LIGHT,
        @SerializedName("KUNKKA")
        KUNKKA,
        @SerializedName("LEGION_COMMANDER")
        LEGION_COMMANDER,
        @SerializedName("LESHRAC")
        LESHRAC,
        @SerializedName("LICH")
        LICH,
        @SerializedName("LIFESTEALER")
        LIFESTEALER,
        @SerializedName("LINA")
        LINA,
        @SerializedName("LION")
        LION,
        @SerializedName("LONE_DRUID")
        LONE_DRUID,
        @SerializedName("LUNA")
        LUNA,
        @SerializedName("LYCAN")
        LYCAN,
        @SerializedName("MAGNUS")
        MAGNUS,
        @SerializedName("MARCI")
        MARCI,
        @SerializedName("MARS")
        MARS,
        @SerializedName("MEDUSA")
        MEDUSA,
        @SerializedName("MEEPO")
        MEEPO,
        @SerializedName("MIRANA")
        MIRANA,
        @SerializedName("MONKEY_KING")
        MONKEY_KING,
        @SerializedName("MORPHLING")
        MORPHLING,
        @SerializedName("MUERTA")
        MUERTA,
        @SerializedName("NAGA_SIREN")
        NAGA_SIREN,
        @SerializedName("NATURES_PROPHET")
        NATURES_PROPHET,
        @SerializedName("NECROPHOS")
        NECROPHOS,
        @SerializedName("NIGHT_STALKER")
        NIGHT_STALKER,
        @SerializedName("NYX_ASSASSIN")
        NYX_ASSASSIN,
        @SerializedName("OGRE_MAGI")
        OGRE_MAGI,
        @SerializedName("OMNIKNIGHT")
        OMNIKNIGHT,
        @SerializedName("ORACLE")
        ORACLE,
        @SerializedName("OUTWORLD_DESTROYER")
        OUTWORLD_DESTROYER,
        @SerializedName("PANGOLIER")
        PANGOLIER,
        @SerializedName("PHANTOM_ASSASSIN")
        PHANTOM_ASSASSIN,
        @SerializedName("PHANTOM_LANCER")
        PHANTOM_LANCER,
        @SerializedName("PHOENIX")
        PHOENIX,
        @SerializedName("PRIMAL_BEAST")
        PRIMAL_BEAST,
        @SerializedName("PUCK")
        PUCK,
        @SerializedName("PUDGE")
        PUDGE,
        @SerializedName("PUGNA")
        PUGNA,
        @SerializedName("QUEEN_OF_PAIN")
        QUEEN_OF_PAIN,
        @SerializedName("RAZOR")
        RAZOR,
        @SerializedName("RIKI")
        RIKI,
        @SerializedName("RUBICK")
        RUBICK,
        @SerializedName("SAND_KING")
        SAND_KING,
        @SerializedName("SHADOW_DEMON")
        SHADOW_DEMON,
        @SerializedName("SHADOW_FIEND")
        SHADOW_FIEND,
        @SerializedName("SHADOW_SHAMAN")
        SHADOW_SHAMAN,
        @SerializedName("SILENCER")
        SILENCER,
        @SerializedName("SKYWRATH_MAGE")
        SKYWRATH_MAGE,
        @SerializedName("SLARDAR")
        SLARDAR,
        @SerializedName("SLARK")
        SLARK,
        @SerializedName("SNAPFIRE")
        SNAPFIRE,
        @SerializedName("SNIPER")
        SNIPER,
        @SerializedName("SPECTRE")
        SPECTRE,
        @SerializedName("SPIRIT_BREAKER")
        SPIRIT_BREAKER,
        @SerializedName("STORM_SPIRIT")
        STORM_SPIRIT,
        @SerializedName("SVEN")
        SVEN,
        @SerializedName("TECHIES")
        TECHIES,
        @SerializedName("TEMPLAR_ASSASSIN")
        TEMPLAR_ASSASSIN,
        @SerializedName("TERRORBLADE")
        TERRORBLADE,
        @SerializedName("TIDEHUNTER")
        TIDEHUNTER,
        @SerializedName("TIMBERSAW")
        TIMBERSAW,
        @SerializedName("TINKER")
        TINKER,
        @SerializedName("TINY")
        TINY,
        @SerializedName("TREANT_PROTECTOR")
        TREANT_PROTECTOR,
        @SerializedName("TROLL_WARLORD")
        TROLL_WARLORD,
        @SerializedName("TUSK")
        TUSK,
        @SerializedName("UNDERLORD")
        UNDERLORD,
        @SerializedName("UNDYING")
        UNDYING,
        @SerializedName("URSA")
        URSA,
        @SerializedName("VENGEFUL_SPIRIT")
        VENGEFUL_SPIRIT,
        @SerializedName("VENOMANCER")
        VENOMANCER,
        @SerializedName("VIPER")
        VIPER,
        @SerializedName("VISAGE")
        VISAGE,
        @SerializedName("VOID_SPIRIT")
        VOID_SPIRIT,
        @SerializedName("WARLOCK")
        WARLOCK,
        @SerializedName("WEAVER")
        WEAVER,
        @SerializedName("WINDRANGER")
        WINDRANGER,
        @SerializedName("WINTER_WYVERN")
        WINTER_WYVERN,
        @SerializedName("WITCH_DOCTOR")
        WITCH_DOCTOR,
        @SerializedName("WRAITH_KING")
        WRAITH_KING,
        @SerializedName("ZEUS")
        ZEUS;
        public String getNiceHero(){
            return niceHeroesString.get(this.ordinal());
        }
    }

    public static final HashMap<String, HEROES> stringHeroToEnum = new HashMap<String, HEROES>(){{
        put("ABADDON", HEROES.ABADDON);
        put("ALCHEMIST", HEROES.ALCHEMIST);
        put("ANCIENT_APPARITION", HEROES.ANCIENT_APPARITION);
        put("ANTI_MAGE", HEROES.ANTI_MAGE);
        put("ARC_WARDEN", HEROES.ARC_WARDEN);
        put("AXE", HEROES.AXE);
        put("BANE", HEROES.BANE);
        put("BATRIDER", HEROES.BATRIDER);
        put("BEASTMASTER", HEROES.BEASTMASTER);
        put("BLOODSEEKER", HEROES.BLOODSEEKER);
        put("BOUNTY_HUNTER", HEROES.BOUNTY_HUNTER);
        put("BREWMASTER", HEROES.BREWMASTER);
        put("BRISTLEBACK", HEROES.BRISTLEBACK);
        put("BROODMOTHER", HEROES.BROODMOTHER);
        put("CENTAUR_WARRUNNER", HEROES.CENTAUR_WARRUNNER);
        put("CHAOS_KNIGHT", HEROES.CHAOS_KNIGHT);
        put("CHEN", HEROES.CHEN);
        put("CLINKZ", HEROES.CLINKZ);
        put("CLOCKWERK", HEROES.CLOCKWERK);
        put("CRYSTAL_MAIDEN", HEROES.CRYSTAL_MAIDEN);
        put("DARK_SEER", HEROES.DARK_SEER);
        put("DARK_WILLOW", HEROES.DARK_WILLOW);
        put("DAWNBREAKER", HEROES.DAWNBREAKER);
        put("DAZZLE", HEROES.DAZZLE);
        put("DEATH_PROPHET", HEROES.DEATH_PROPHET);
        put("DISRUPTOR", HEROES.DISRUPTOR);
        put("DOOM", HEROES.DOOM);
        put("DRAGON_KNIGHT", HEROES.DRAGON_KNIGHT);
        put("DROW_RANGER", HEROES.DROW_RANGER);
        put("EARTH_SPIRIT", HEROES.EARTH_SPIRIT);
        put("EARTHSHAKER", HEROES.EARTHSHAKER);
        put("ELDER_TITAN", HEROES.ELDER_TITAN);
        put("EMBER_SPIRIT", HEROES.EMBER_SPIRIT);
        put("ENCHANTRESS", HEROES.ENCHANTRESS);
        put("ENIGMA", HEROES.ENIGMA);
        put("FACELESS_VOID", HEROES.FACELESS_VOID);
        put("GRIMSTROKE", HEROES.GRIMSTROKE);
        put("GYROCOPTER", HEROES.GYROCOPTER);
        put("HOODWINK", HEROES.HOODWINK);
        put("HUSKAR", HEROES.HUSKAR);
        put("INVOKER", HEROES.INVOKER);
        put("IO", HEROES.IO);
        put("JAKIRO", HEROES.JAKIRO);
        put("JUGGERNAUT", HEROES.JUGGERNAUT);
        put("KEEPER_OF_THE_LIGHT", HEROES.KEEPER_OF_THE_LIGHT);
        put("KUNKKA", HEROES.KUNKKA);
        put("LEGION_COMMANDER", HEROES.LEGION_COMMANDER);
        put("LESHRAC", HEROES.LESHRAC);
        put("LICH", HEROES.LICH);
        put("LIFESTEALER", HEROES.LIFESTEALER);
        put("LINA", HEROES.LINA);
        put("LION", HEROES.LION);
        put("LONE_DRUID", HEROES.LONE_DRUID);
        put("LUNA", HEROES.LUNA);
        put("LYCAN", HEROES.LYCAN);
        put("MAGNUS", HEROES.MAGNUS);
        put("MARCI", HEROES.MARCI);
        put("MARS", HEROES.MARS);
        put("MEDUSA", HEROES.MEDUSA);
        put("MEEPO", HEROES.MEEPO);
        put("MIRANA", HEROES.MIRANA);
        put("MONKEY_KING", HEROES.MONKEY_KING);
        put("MORPHLING", HEROES.MORPHLING);
        put("MUERTA", HEROES.MUERTA);
        put("NAGA_SIREN", HEROES.NAGA_SIREN);
        put("NATURES_PROPHET", HEROES.NATURES_PROPHET);
        put("NECROPHOS", HEROES.NECROPHOS);
        put("NIGHT_STALKER", HEROES.NIGHT_STALKER);
        put("NYX_ASSASSIN", HEROES.NYX_ASSASSIN);
        put("OGRE_MAGI", HEROES.OGRE_MAGI);
        put("OMNIKNIGHT", HEROES.OMNIKNIGHT);
        put("ORACLE", HEROES.ORACLE);
        put("OUTWORLD_DESTROYER", HEROES.OUTWORLD_DESTROYER);
        put("PANGOLIER", HEROES.PANGOLIER);
        put("PHANTOM_ASSASSIN", HEROES.PHANTOM_ASSASSIN);
        put("PHANTOM_LANCER", HEROES.PHANTOM_LANCER);
        put("PHOENIX", HEROES.PHOENIX);
        put("PRIMAL_BEAST", HEROES.PRIMAL_BEAST);
        put("PUCK", HEROES.PUCK);
        put("PUDGE", HEROES.PUDGE);
        put("PUGNA", HEROES.PUGNA);
        put("QUEEN_OF_PAIN", HEROES.QUEEN_OF_PAIN);
        put("RAZOR", HEROES.RAZOR);
        put("RIKI", HEROES.RIKI);
        put("RUBICK", HEROES.RUBICK);
        put("SAND_KING", HEROES.SAND_KING);
        put("SHADOW_DEMON", HEROES.SHADOW_DEMON);
        put("SHADOW_FIEND", HEROES.SHADOW_FIEND);
        put("SHADOW_SHAMAN", HEROES.SHADOW_SHAMAN);
        put("SILENCER", HEROES.SILENCER);
        put("SKYWRATH_MAGE", HEROES.SKYWRATH_MAGE);
        put("SLARDAR", HEROES.SLARDAR);
        put("SLARK", HEROES.SLARK);
        put("SNAPFIRE", HEROES.SNAPFIRE);
        put("SNIPER", HEROES.SNIPER);
        put("SPECTRE", HEROES.SPECTRE);
        put("SPIRIT_BREAKER", HEROES.SPIRIT_BREAKER);
        put("STORM_SPIRIT", HEROES.STORM_SPIRIT);
        put("SVEN", HEROES.SVEN);
        put("TECHIES", HEROES.TECHIES);
        put("TEMPLAR_ASSASSIN", HEROES.TEMPLAR_ASSASSIN);
        put("TERRORBLADE", HEROES.TERRORBLADE);
        put("TIDEHUNTER", HEROES.TIDEHUNTER);
        put("TIMBERSAW", HEROES.TIMBERSAW);
        put("TINKER", HEROES.TINKER);
        put("TINY", HEROES.TINY);
        put("TREANT_PROTECTOR", HEROES.TREANT_PROTECTOR);
        put("TROLL_WARLORD", HEROES.TROLL_WARLORD);
        put("TUSK", HEROES.TUSK);
        put("UNDERLORD", HEROES.UNDERLORD);
        put("UNDYING", HEROES.UNDYING);
        put("URSA", HEROES.URSA);
        put("VENGEFUL_SPIRIT", HEROES.VENGEFUL_SPIRIT);
        put("VENOMANCER", HEROES.VENOMANCER);
        put("VIPER", HEROES.VIPER);
        put("VISAGE", HEROES.VISAGE);
        put("VOID_SPIRIT", HEROES.VOID_SPIRIT);
        put("WARLOCK", HEROES.WARLOCK);
        put("WEAVER", HEROES.WEAVER);
        put("WINDRANGER", HEROES.WINDRANGER);
        put("WINTER_WYVERN", HEROES.WINTER_WYVERN);
        put("WITCH_DOCTOR", HEROES.WITCH_DOCTOR);
        put("WRAITH_KING", HEROES.WRAITH_KING);
        put("ZEUS", HEROES.ZEUS);
    }};
    public static final String[] rawHeroesString = new String[] {
            "abaddon", "alchemist",
            "ancient-apparition", "anti-mage",
            "arc-warden", "axe",
            "bane", "batrider",
            "beastmaster", "bloodseeker",
            "bounty-hunter", "brewmaster",
            "bristleback", "broodmother",
            "centaur-warrunner", "chaos-knight",
            "chen", "clinkz",
            "clockwerk", "crystal-maiden",
            "dark-seer", "dark-willow",
            "dawnbreaker", "dazzle",
            "death-prophet", "disruptor",
            "doom", "dragon-knight",
            "drow-ranger", "earth-spirit",
            "earthshaker", "elder-titan",
            "ember-spirit", "enchantress",
            "enigma", "faceless-void",
            "grimstroke", "gyrocopter",
            "hoodwink", "huskar",
            "invoker", "io",
            "jakiro", "juggernaut",
            "keeper-of-the-light", "kunkka",
            "legion-commander", "leshrac",
            "lich", "lifestealer",
            "lina", "lion",
            "lone-druid", "luna",
            "lycan", "magnus",
            "marci", "mars",
            "medusa", "meepo",
            "mirana", "monkey-king",
            "morphling", "muerta",
            "naga-siren",
            "natures-prophet", "necrophos",
            "night-stalker", "nyx-assassin",
            "ogre-magi", "omniknight",
            "oracle", "outworld-destroyer",
            "pangolier", "phantom-assassin",
            "phantom-lancer", "phoenix",
            "primal-beast", "puck",
            "pudge", "pugna",
            "queen-of-pain", "razor",
            "riki", "rubick",
            "sand-king", "shadow-demon",
            "shadow-fiend", "shadow-shaman",
            "silencer", "skywrath-mage",
            "slardar", "slark",
            "snapfire", "sniper",
            "spectre", "spirit-breaker",
            "storm-spirit", "sven",
            "techies", "templar-assassin",
            "terrorblade", "tidehunter",
            "timbersaw", "tinker",
            "tiny", "treant-protector",
            "troll-warlord", "tusk",
            "underlord", "undying",
            "ursa", "vengeful-spirit",
            "venomancer", "viper",
            "visage", "void-spirit",
            "warlock", "weaver",
            "windranger", "winter-wyvern",
            "witch-doctor", "wraith-king",
            "zeus"
    };
    public static final Set<String> rawHeroesSet = new HashSet<>(Arrays.asList(rawHeroesString));

    public static final List<String> niceHeroesString = new ArrayList<>(Arrays.asList(
            "Abaddon", "Alchemist",
            "Ancient Apparition", "Anti-Mage",
            "Arc Warden", "Axe",
            "Bane", "Batrider",
            "Beastmaster", "Bloodseeker",
            "Bounty Hunter", "Brewmaster",
            "Bristleback", "Broodmother",
            "Centaur Warrunner", "Chaos Knight",
            "Chen", "Clinkz",
            "Clockwerk", "Crystal Maiden",
            "Dark Seer", "Dark Willow",
            "Dawnbreaker", "Dazzle",
            "Death Prophet", "Disruptor",
            "Doom", "Dragon Knight",
            "Drow Ranger", "Earth Spirit",
            "Earthshaker", "Elder Titan",
            "Ember Spirit", "Enchantress",
            "Enigma", "Faceless Void",
            "Grimstroke", "Gyrocopter",
            "Hoodwink", "Huskar",
            "Invoker", "Io",
            "Jakiro", "Juggernaut",
            "Keeper of the Light", "Kunkka",
            "Legion Commander", "Leshrac",
            "Lich", "Lifestealer",
            "Lina", "Lion",
            "Lone Druid", "Luna",
            "Lycan", "Magnus",
            "Marci", "Mars",
            "Medusa", "Meepo",
            "Mirana", "Monkey King",
            "Morphling", "Muerta",
            "Naga Siren", "Natures Prophet",
            "Necrophos", "Night Stalker",
            "Nyx Assassin", "Ogre Magi",
            "Omniknight", "Oracle",
            "Outworld Destroyer", "Pangolier",
            "Phantom Assassin", "Phantom Lancer",
            "Phoenix", "Primal Beast",
            "Puck", "Pudge",
            "Pugna", "Queen of Pain",
            "Razor", "Riki", "Rubick",
            "Sand King", "Shadow Demon",
            "Shadow Fiend", "Shadow Shaman",
            "Silencer", "Skywrath Mage",
            "Slardar", "Slark",
            "Snapfire", "Sniper",
            "Spectre", "Spirit Breaker",
            "Storm Spirit", "Sven",
            "Techies", "Templar Assassin",
            "Terrorblade", "Tidehunter",
            "Timbersaw", "Tinker",
            "Tiny", "Treant Protector",
            "Troll Warlord", "Tusk",
            "Underlord", "Undying",
            "Ursa", "Vengeful Spirit",
            "Venomancer", "Viper",
            "Visage", "Void Spirit",
            "Warlock", "Weaver",
            "Windranger", "Winter Wyvern",
            "Witch Doctor", "Wraith King",
            "Zeus"));
    public static final Set<String> niceHeroesSet = new HashSet<>(niceHeroesString);
    public static final HashMap<HEROES, Attributes> heroesAttributes = new HashMap<HEROES, Attributes>(){{
        put(HEROES.ABADDON,new Attributes(1/3.0,2/3.0,0.0,0.0,2/3.0,0.0,0.0,0.0));
        put(HEROES.ALCHEMIST,new Attributes(2/3.0,(1/3.0),(1/3.0),(1/3.0),(2/3.0),0.0,0.0,(1/3.0)));
        put(HEROES.ANCIENT_APPARITION,new Attributes(0.0,(2/3.0),(1/3.0),(1/3.0),0.0,0.0,0.0,0.0));
        put(HEROES.ANTI_MAGE,new Attributes(1.0,0.0,(1/3.0),0.0,0.0,1.0,0.0,0.0));
        put(HEROES.ARC_WARDEN,new Attributes(1.0,0.0,(1/3.0),0.0,0.0,1.0,0.0,0.0));
        put(HEROES.AXE,new Attributes((1/3.0),0.0,0.0,(2/3.0),1.0,0.0,0.0,1.0));
        put(HEROES.BANE,new Attributes(0.0,(2/3.0),(1/3.0),1.0,(1/3.0),0.0,0.0,0.0));
        put(HEROES.BATRIDER,new Attributes(0.0,0.0,0.0,(2/3.0),0.0,(1/3.0),0.0,1.0));
        put(HEROES.BEASTMASTER,new Attributes(0.0,0.0,(1/3.0),(2/3.0),(2/3.0),0.0,0.0,(2/3.0)));
        put(HEROES.BLOODSEEKER,new Attributes((1/3.0),0.0,(1/3.0),(1/3.0),0.0,0.0,0.0,(1/3.0)));
        put(HEROES.BOUNTY_HUNTER,new Attributes(0.0,0.0,(1/3.0),0.0,0.0,(2/3.0),0.0,0.0));
        put(HEROES.BREWMASTER,new Attributes((1/3.0),0.0,(1/3.0),(2/3.0),(2/3.0),0.0,0.0,1.0));
        put(HEROES.BRISTLEBACK,new Attributes((2/3.0),0.0,(1/3.0),0.0,1.0,0.0,0.0,(1/3.0)));
        put(HEROES.BROODMOTHER,new Attributes((1/3.0),0.0,(1/3.0),0.0,0.0,1.0,1.0,0.0));
        put(HEROES.CENTAUR_WARRUNNER,new Attributes(0.0,0.0,(1/3.0),(1/3.0),1.0,(1/3.0),0.0,1.0));
        put(HEROES.CHAOS_KNIGHT,new Attributes(1.0,0.0,0.0,(2/3.0),(2/3.0),0.0,(2/3.0),(1/3.0)));
        put(HEROES.CHEN,new Attributes(0.0,(2/3.0),0.0,0.0,0.0,0.0,(2/3.0),0.0));
        put(HEROES.CLINKZ,new Attributes((2/3.0),0.0,0.0,0.0,0.0,1.0,(1/3.0),0.0));
        put(HEROES.CLOCKWERK,new Attributes(0.0,0.0,(1/3.0),(2/3.0),(1/3.0),0.0,0.0,1.0));
        put(HEROES.CRYSTAL_MAIDEN,new Attributes(0.0,1.0,(2/3.0),(2/3.0),0.0,0.0,0.0,0.0));
        put(HEROES.DARK_SEER,new Attributes(0.0,0.0,0.0,(1/3.0),0.0,(1/3.0),0.0,(1/3.0)));
        put(HEROES.DARK_WILLOW,new Attributes(0.0,(2/3.0),2/3.0,2/3.0,0.0,2/3.0,0.0,0.0));
        put(HEROES.DAWNBREAKER,new Attributes((1/3.0),0.0,0.0,0.0,(2/3.0),0.0,0.0,0.0));
        put(HEROES.DAZZLE,new Attributes(0.0,1.0,(1/3.0),(1/3.0),0.0,0.0,0.0,0.0));
        put(HEROES.DEATH_PROPHET,new Attributes((1/3.0),0.0,(1/3.0),(1/3.0),0.0,0.0,1.0,0.0));
        put(HEROES.DISRUPTOR,new Attributes(0.0,(2/3.0),(1/3.0),(2/3.0),0.0,0.0,0.0,(1/3.0)));
        put(HEROES.DOOM,new Attributes((1/3.0),0.0,(1/3.0),(2/3.0),(2/3.0),0.0,0.0,(2/3.0)));
        put(HEROES.DRAGON_KNIGHT,new Attributes((2/3.0),0.0,(1/3.0),(2/3.0),(2/3.0),0.0,1.0,(1/3.0)));
        put(HEROES.DROW_RANGER,new Attributes((2/3.0),0.0,0.0,(1/3.0),0.0,0.0,(1/3.0),0.0));
        put(HEROES.EARTH_SPIRIT,new Attributes(0.0,0.0,(2/3.0),(1/3.0),(1/3.0),(2/3.0),0.0,(1/3.0)));
        put(HEROES.EARTHSHAKER,new Attributes(0.0,(1/3.0),(1/3.0),(2/3.0),0.0,0.0,0.0,1.0));
        put(HEROES.ELDER_TITAN,new Attributes(0.0,0.0,(1/3.0),(1/3.0),(1/3.0),0.0,0.0,(2/3.0)));
        put(HEROES.EMBER_SPIRIT,new Attributes((2/3.0),0.0,(1/3.0),(1/3.0),0.0,1.0,0.0,(1/3.0)));
        put(HEROES.ENCHANTRESS,new Attributes(0.0,(2/3.0),0.0,(1/3.0),(1/3.0),0.0,(2/3.0),0.0));
        put(HEROES.ENIGMA,new Attributes(0.0,0.0,0.0,(2/3.0),0.0,0.0,(2/3.0),(2/3.0)));
        put(HEROES.FACELESS_VOID,new Attributes((2/3.0),0.0,0.0,(2/3.0),(1/3.0),(1/3.0),0.0,1.0));
        put(HEROES.GRIMSTROKE,new Attributes(0.0,(2/3.0),(2/3.0),(2/3.0),0.0,(1/3.0),0.0,0.0));
        put(HEROES.GYROCOPTER,new Attributes(1.0,0.0,(1/3.0),(1/3.0),0.0,0.0,0.0,0.0));
        put(HEROES.HOODWINK,new Attributes(0.0,(2/3.0),(2/3.0),(1/3.0),0.0,(2/3.0),0.0,0.0));
        put(HEROES.HUSKAR,new Attributes((2/3.0),0.0,0.0,0.0,(2/3.0),0.0,0.0,(1/3.0)));
        put(HEROES.INVOKER,new Attributes((1/3.0),0.0,1.0,(2/3.0),0.0,(1/3.0),(1/3.0),0.0));
        put(HEROES.IO,new Attributes(0.0,1.0,(1/3.0),0.0,0.0,(2/3.0),0.0,0.0));
        put(HEROES.JAKIRO,new Attributes(0.0,(1/3.0),(2/3.0),(1/3.0),0.0,0.0,(2/3.0),0.0));
        put(HEROES.JUGGERNAUT,new Attributes((2/3.0),0.0,0.0,0.0,0.0,(1/3.0),(1/3.0),0.0));
        put(HEROES.KEEPER_OF_THE_LIGHT,new Attributes(0.0,1.0,(2/3.0),(1/3.0),0.0,0.0,0.0,0.0));
        put(HEROES.KUNKKA,new Attributes(2/3.0,(1/3.0),(1/3.0),(2/3.0),(1/3.0),0.0,0.0,(2/3.0)));
        put(HEROES.LEGION_COMMANDER,new Attributes((1/3.0),0.0,(1/3.0),(2/3.0),(1/3.0),0.0,0.0,(1/3.0)));
        put(HEROES.LESHRAC,new Attributes((1/3.0),(1/3.0),1.0,(1/3.0),0.0,0.0,1.0,0.0));
        put(HEROES.LICH,new Attributes(0.0,1.0,(2/3.0),0.0,0.0,0.0,0.0,0.0));
        put(HEROES.LIFESTEALER,new Attributes((2/3.0),0.0,0.0,(1/3.0),(2/3.0),(1/3.0),0.0,0.0));
        put(HEROES.LINA,new Attributes((1/3.0),(1/3.0),1.0,(1/3.0),0.0,0.0,0.0,0.0));
        put(HEROES.LION,new Attributes(0.0,(2/3.0),1.0,1.0,0.0,0.0,0.0,(2/3.0)));
        put(HEROES.LONE_DRUID,new Attributes((2/3.0),0.0,0.0,0.0,(1/3.0),0.0,1.0,0.0));
        put(HEROES.LUNA,new Attributes((2/3.0),0.0,(2/3.0),0.0,0.0,0.0,(1/3.0),0.0));
        put(HEROES.LYCAN,new Attributes((2/3.0),0.0,0.0,0.0,(1/3.0),(1/3.0),1.0,0.0));
        put(HEROES.MAGNUS,new Attributes(0.0,0.0,(1/3.0),(2/3.0),0.0,(1/3.0),0.0,1.0));
        put(HEROES.MARCI,new Attributes((1/3.0),(1/3.0),0.0,(1/3.0),0.0,(1/3.0),0.0,(2/3.0)));
        put(HEROES.MARS,new Attributes((1/3.0),0.0,0.0,(2/3.0),1.0,0.0,0.0,(2/3.0)));
        put(HEROES.MEDUSA,new Attributes(1.0,0.0,0.0,(1/3.0),(1/3.0),0.0,0.0,0.0));
        put(HEROES.MEEPO,new Attributes((2/3.0),0.0,(2/3.0),(1/3.0),0.0,(2/3.0),(1/3.0),(1/3.0)));
        put(HEROES.MIRANA,new Attributes((1/3.0),(1/3.0),(1/3.0),(1/3.0),0.0,(2/3.0),0.0,0.0));
        put(HEROES.MONKEY_KING,new Attributes((2/3.0),0.0,0.0,(1/3.0),0.0,(2/3.0),0.0,(1/3.0)));
        put(HEROES.MORPHLING,new Attributes(1.0,0.0,(1/3.0),(1/3.0),(2/3.0),1.0,0.0,0.0));
        put(HEROES.MUERTA,new Attributes(1.0,0.0,(2/3.0),(1/3.0),0.0,0.0,0.0,0.0));
        put(HEROES.NAGA_SIREN,new Attributes(1.0,(1/3.0),0.0,(2/3.0),0.0,(1/3.0),(2/3.0),(1/3.0)));
        put(HEROES.NATURES_PROPHET,new Attributes((1/3.0),0.0,(1/3.0),0.0,0.0,(1/3.0),1.0,0.0));
        put(HEROES.NECROPHOS,new Attributes((1/3.0),0.0,(2/3.0),(1/3.0),(1/3.0),0.0,0.0,0.0));
        put(HEROES.NIGHT_STALKER,new Attributes((1/3.0),0.0,(1/3.0),(2/3.0),(2/3.0),0.0,0.0,(2/3.0)));
        put(HEROES.NYX_ASSASSIN,new Attributes(0.0,0.0,(2/3.0),(2/3.0),0.0,(1/3.0),0.0,(2/3.0)));
        put(HEROES.OGRE_MAGI,new Attributes(0.0,(2/3.0),(2/3.0),(2/3.0),(1/3.0),0.0,0.0,(1/3.0)));
        put(HEROES.OMNIKNIGHT,new Attributes(0.0,(2/3.0),(1/3.0),0.0,(1/3.0),0.0,0.0,0.0));
        put(HEROES.ORACLE,new Attributes(0.0,1.0,1.0,(2/3.0),0.0,(1/3.0),0.0,0.0));
        put(HEROES.OUTWORLD_DESTROYER,new Attributes((2/3.0),0.0,(2/3.0),(1/3.0),0.0,0.0,0.0,0.0));
        put(HEROES.PANGOLIER,new Attributes((2/3.0),0.0,(2/3.0),(1/3.0),(1/3.0),(2/3.0),0.0,(2/3.0)));
        put(HEROES.PHANTOM_ASSASSIN,new Attributes(1.0,0.0,0.0,0.0,0.0,(1/3.0),0.0,0.0));
        put(HEROES.PHANTOM_LANCER,new Attributes((2/3.0),0.0,(1/3.0),0.0,0.0,(2/3.0),(1/3.0),0.0));
        put(HEROES.PHOENIX,new Attributes(0.0,(2/3.0),1.0,(1/3.0),0.0,(2/3.0),0.0,(2/3.0)));
        put(HEROES.PRIMAL_BEAST,new Attributes(0.0,0.0,0.0,(2/3.0),1.0,0.0,0.0,1.0));
        put(HEROES.PUCK,new Attributes(0.0,0.0,(2/3.0),1.0,0.0,1.0,0.0,1.0));
        put(HEROES.PUDGE,new Attributes(0.0,0.0,(1/3.0),(2/3.0),(2/3.0),0.0,0.0,(2/3.0)));
        put(HEROES.PUGNA,new Attributes(0.0,(1/3.0),(2/3.0),0.0,0.0,0.0,(2/3.0),0.0));
        put(HEROES.QUEEN_OF_PAIN,new Attributes((1/3.0),0.0,1.0,0.0,0.0,1.0,0.0,0.0));
        put(HEROES.RAZOR,new Attributes((2/3.0),0.0,(1/3.0),0.0,(2/3.0),0.0,(1/3.0),0.0));
        put(HEROES.RIKI,new Attributes((2/3.0),0.0,0.0,(1/3.0),0.0,(2/3.0),0.0,0.0));
        put(HEROES.RUBICK,new Attributes(0.0,(2/3.0),(1/3.0),(1/3.0),0.0,0.0,0.0,0.0));
        put(HEROES.SAND_KING,new Attributes(0.0,(1/3.0),(2/3.0),(2/3.0),0.0,(2/3.0),0.0,1.0));
        put(HEROES.SHADOW_DEMON,new Attributes(0.0,(2/3.0),(1/3.0),(2/3.0),0.0,0.0,0.0,(1/3.0)));
        put(HEROES.SHADOW_FIEND,new Attributes((2/3.0),0.0,1.0,0.0,0.0,0.0,0.0,0.0));
        put(HEROES.SHADOW_SHAMAN,new Attributes(0.0,(2/3.0),(2/3.0),1.0,0.0,0.0,1.0,(1/3.0)));
        put(HEROES.SILENCER,new Attributes((1/3.0),(1/3.0),(1/3.0),(2/3.0),0.0,0.0,0.0,(2/3.0)));
        put(HEROES.SKYWRATH_MAGE,new Attributes(0.0,(2/3.0),1.0,(1/3.0),0.0,0.0,0.0,0.0));
        put(HEROES.SLARDAR,new Attributes((2/3.0),0.0,0.0,(1/3.0),(2/3.0),(1/3.0),0.0,(2/3.0)));
        put(HEROES.SLARK,new Attributes((2/3.0),0.0,(1/3.0),(1/3.0),0.0,1.0,0.0,0.0));
        put(HEROES.SNAPFIRE,new Attributes(0.0,(1/3.0),1.0,(1/3.0),0.0,(1/3.0),0.0,0.0));
        put(HEROES.SNIPER,new Attributes(1.0,0.0,(1/3.0),0.0,0.0,0.0,0.0,0.0));
        put(HEROES.SPECTRE,new Attributes(1.0,0.0,0.0,0.0,(1/3.0),(1/3.0),0.0,0.0));
        put(HEROES.SPIRIT_BREAKER,new Attributes((1/3.0),0.0,0.0,(2/3.0),(2/3.0),(1/3.0),0.0,(2/3.0)));
        put(HEROES.STORM_SPIRIT,new Attributes((2/3.0),0.0,(2/3.0),(1/3.0),0.0,1.0,0.0,(1/3.0)));
        put(HEROES.SVEN,new Attributes((2/3.0),0.0,(1/3.0),(2/3.0),(2/3.0),0.0,0.0,(2/3.0)));
        put(HEROES.TECHIES,new Attributes(0.0,0.0,1.0,(1/3.0),0.0,0.0,0.0,0.0));
        put(HEROES.TEMPLAR_ASSASSIN,new Attributes((2/3.0),0.0,0.0,0.0,0.0,(1/3.0),0.0,0.0));
        put(HEROES.TERRORBLADE,new Attributes(1.0,0.0,(1/3.0),0.0,0.0,0.0,(2/3.0),0.0));
        put(HEROES.TIDEHUNTER,new Attributes((1/3.0),0.0,(1/3.0),(2/3.0),1.0,0.0,0.0,1.0));
        put(HEROES.TIMBERSAW,new Attributes(0.0,0.0,1.0,0.0,(2/3.0),(2/3.0),0.0,0.0));
        put(HEROES.TINKER,new Attributes((1/3.0),0.0,1.0,0.0,0.0,0.0,(2/3.0),0.0));
        put(HEROES.TINY,new Attributes(2/3.0,(1/3.0),(2/3.0),(1/3.0),(2/3.0),0.0,(2/3.0),(2/3.0)));
        put(HEROES.TREANT_PROTECTOR,new Attributes(0.0,1.0,0.0,1/3.0,1/3.0,1/3.0,0.0,(2/3.0)));
        put(HEROES.TROLL_WARLORD,new Attributes(1.0,0.0,0.0,(1/3.0),(1/3.0),0.0,(2/3.0),0.0));
        put(HEROES.TUSK,new Attributes(0.0,0.0,(1/3.0),(2/3.0),0.0,0.0,0.0,(2/3.0)));
        put(HEROES.UNDERLORD,new Attributes(0.0,(1/3.0),(1/3.0),(1/3.0),(1/3.0),(2/3.0),0.0,0.0));
        put(HEROES.UNDYING,new Attributes(0.0,(2/3.0),(1/3.0),(1/3.0),(2/3.0),0.0,0.0,0.0));
        put(HEROES.URSA,new Attributes((2/3.0),0.0,0.0,(1/3.0),(1/3.0),0.0,0.0,0.0));
        put(HEROES.VENGEFUL_SPIRIT,new Attributes(0.0,1.0,(1/3.0),(2/3.0),0.0,(1/3.0),0.0,(2/3.0)));
        put(HEROES.VENOMANCER,new Attributes(0.0,(2/3.0),(1/3.0),(1/3.0),0.0,0.0,(1/3.0),(1/3.0)));
        put(HEROES.VIPER,new Attributes((1/3.0),0.0,0.0,(1/3.0),(2/3.0),0.0,0.0,(1/3.0)));
        put(HEROES.VISAGE,new Attributes(0.0,(1/3.0),(2/3.0),(1/3.0),(1/3.0),0.0,(1/3.0),0.0));
        put(HEROES.VOID_SPIRIT,new Attributes((2/3.0),0.0,(2/3.0),(1/3.0),0.0,1.0,0.0,0.0));
        put(HEROES.WARLOCK,new Attributes(0.0,(1/3.0),0.0,(1/3.0),0.0,0.0,0.0,(2/3.0)));
        put(HEROES.WEAVER,new Attributes((2/3.0),0.0,0.0,0.0,0.0,1.0,0.0,0.0));
        put(HEROES.WINDRANGER,new Attributes((1/3.0),(1/3.0),(1/3.0),(1/3.0),0.0,(1/3.0),0.0,0.0));
        put(HEROES.WINTER_WYVERN,new Attributes(0.0,1.0,(1/3.0),(2/3.0),0.0,0.0,0.0,0.0));
        put(HEROES.WITCH_DOCTOR,new Attributes(0.0,1.0,(2/3.0),(1/3.0),0.0,0.0,0.0,0.0));
        put(HEROES.WRAITH_KING,new Attributes((2/3.0),(1/3.0),0.0,(2/3.0),1.0,0.0,0.0,(1/3.0)));
        put(HEROES.ZEUS,new Attributes((1/3.0),0.0,1.0,0.0,0.0,0.0,0.0,0.0));
    }};
    private static Double averageCarry;
    public static Double getAverageCarry(){
        if(averageCarry == null){
            averageCarry = 0.0;
            for(HEROES hero: HEROES.values()){
                averageCarry += heroesAttributes.get(hero).getCarry();
            }
            averageCarry /= heroesCount;
            averageCarry = Math.round(averageCarry * 100) / 100.0;
        }
        return averageCarry;
    }
    private static Double averageSupport;
    public static Double getAverageSupport(){
        if(averageSupport == null){
            averageSupport = 0.0;
            for(HEROES hero: HEROES.values()){
                averageSupport += heroesAttributes.get(hero).getSupport();
            }
            averageSupport /= heroesCount;
            averageSupport = Math.round(averageSupport * 100) / 100.0;
        }
        return averageSupport;
    }
    private static Double averageBurst;
    public static Double getAverageBurst(){
        if(averageBurst == null){
            averageBurst = 0.0;
            for(HEROES hero: HEROES.values()){
                averageBurst += heroesAttributes.get(hero).getBurst();
            }
            averageBurst /= heroesCount;
            averageBurst = Math.round(averageBurst * 100) / 100.0;
        }
        return averageBurst;
    }
    private static Double averageControl;
    public static Double getAverageControl(){
        if(averageControl == null){
            averageControl = 0.0;
            for(HEROES hero: HEROES.values()){
                averageControl += heroesAttributes.get(hero).getControl();
            }
            averageControl /= heroesCount;
            averageControl = Math.round(averageControl * 100) / 100.0;
        }
        return averageControl;
    }
    private static Double averageEndurance;
    public static Double getAverageEndurance(){
        if(averageEndurance == null){
            averageEndurance = 0.0;
            for(HEROES hero: HEROES.values()){
                averageEndurance += heroesAttributes.get(hero).getEndurance();
            }
            averageEndurance /= heroesCount;
            averageEndurance = Math.round(averageEndurance * 100) / 100.0;
        }
        return averageEndurance;
    }
    private static Double averageEscape;
    public static Double getAverageEscape(){
        if(averageEscape == null){
            averageEscape = 0.0;
            for(HEROES hero: HEROES.values()){
                averageEscape += heroesAttributes.get(hero).getEscape();
            }
            averageEscape /= heroesCount;
            averageEscape = Math.round(averageEscape * 100) / 100.0;
        }
        return averageEscape;
    }
    private static Double averagePush;
    public static Double getAveragePush(){
        if(averagePush == null){
            averagePush = 0.0;
            for(HEROES hero: HEROES.values()){
                averagePush += heroesAttributes.get(hero).getPush();
            }
            averagePush /= heroesCount;
            averagePush = Math.round(averagePush * 100) / 100.0;
        }
        return averagePush;
    }
    private static Double averageInitiation;
    public static Double getAverageInitiation(){
        if(averageInitiation == null){
            averageInitiation = 0.0;
            for(HEROES hero: HEROES.values()){
                averageInitiation += heroesAttributes.get(hero).getInitiation();
            }
            averageInitiation /= heroesCount;
            averageInitiation = Math.round(averageInitiation * 100) / 100.0;
        }
        return averageInitiation;
    }
    public static final HashMap<String, HEROES> niceToEnumHero = new HashMap<String, HEROES>(){{
        put("Abaddon", HEROES.ABADDON);
        put("Alchemist", HEROES.ALCHEMIST);
        put("Ancient Apparition", HEROES.ANCIENT_APPARITION);
        put("Anti-Mage", HEROES.ANTI_MAGE);
        put("Arc Warden", HEROES.ARC_WARDEN);
        put("Axe", HEROES.AXE);
        put("Bane", HEROES.BANE);
        put("Batrider", HEROES.BATRIDER);
        put("Beastmaster", HEROES.BEASTMASTER);
        put("Bloodseeker", HEROES.BLOODSEEKER);
        put("Bounty Hunter", HEROES.BOUNTY_HUNTER);
        put("Brewmaster", HEROES.BREWMASTER);
        put("Bristleback", HEROES.BRISTLEBACK);
        put("Broodmother", HEROES.BROODMOTHER);
        put("Centaur Warrunner", HEROES.CENTAUR_WARRUNNER);
        put("Chaos Knight", HEROES.CHAOS_KNIGHT);
        put("Chen", HEROES.CHEN);
        put("Clinkz", HEROES.CLINKZ);
        put("Clockwerk", HEROES.CLOCKWERK);
        put("Crystal Maiden", HEROES.CRYSTAL_MAIDEN);
        put("Dark Seer", HEROES.DARK_SEER);
        put("Dark Willow", HEROES.DARK_WILLOW);
        put("Dawnbreaker", HEROES.DAWNBREAKER);
        put("Dazzle", HEROES.DAZZLE);
        put("Death Prophet", HEROES.DEATH_PROPHET);
        put("Disruptor", HEROES.DISRUPTOR);
        put("Doom", HEROES.DOOM);
        put("Dragon Knight", HEROES.DRAGON_KNIGHT);
        put("Drow Ranger", HEROES.DROW_RANGER);
        put("Earth Spirit", HEROES.EARTH_SPIRIT);
        put("Earthshaker", HEROES.EARTHSHAKER);
        put("Elder Titan", HEROES.ELDER_TITAN);
        put("Ember Spirit", HEROES.EMBER_SPIRIT);
        put("Enchantress", HEROES.ENCHANTRESS);
        put("Enigma", HEROES.ENIGMA);
        put("Faceless Void", HEROES.FACELESS_VOID);
        put("Grimstroke", HEROES.GRIMSTROKE);
        put("Gyrocopter", HEROES.GYROCOPTER);
        put("Hoodwink", HEROES.HOODWINK);
        put("Huskar", HEROES.HUSKAR);
        put("Invoker", HEROES.INVOKER);
        put("Io", HEROES.IO);
        put("Jakiro", HEROES.JAKIRO);
        put("Juggernaut", HEROES.JUGGERNAUT);
        put("Keeper of the Light", HEROES.KEEPER_OF_THE_LIGHT);
        put("Kunkka", HEROES.KUNKKA);
        put("Legion Commander", HEROES.LEGION_COMMANDER);
        put("Leshrac", HEROES.LESHRAC);
        put("Lich", HEROES.LICH);
        put("Lifestealer", HEROES.LIFESTEALER);
        put("Lina", HEROES.LINA);
        put("Lion", HEROES.LION);
        put("Lone Druid", HEROES.LONE_DRUID);
        put("Luna", HEROES.LUNA);
        put("Lycan", HEROES.LYCAN);
        put("Magnus", HEROES.MAGNUS);
        put("Marci", HEROES.MARCI);
        put("Mars", HEROES.MARS);
        put("Medusa", HEROES.MEDUSA);
        put("Meepo", HEROES.MEEPO);
        put("Mirana", HEROES.MIRANA);
        put("Monkey King", HEROES.MONKEY_KING);
        put("Morphling", HEROES.MORPHLING);
        put("Muerta", HEROES.MUERTA);
        put("Naga Siren", HEROES.NAGA_SIREN);
        put("Natures Prophet", HEROES.NATURES_PROPHET);
        put("Necrophos", HEROES.NECROPHOS);
        put("Night Stalker", HEROES.NIGHT_STALKER);
        put("Nyx Assassin", HEROES.NYX_ASSASSIN);
        put("Ogre Magi", HEROES.OGRE_MAGI);
        put("Omniknight", HEROES.OMNIKNIGHT);
        put("Oracle", HEROES.ORACLE);
        put("Outworld Destroyer", HEROES.OUTWORLD_DESTROYER);
        put("Pangolier", HEROES.PANGOLIER);
        put("Phantom Assassin", HEROES.PHANTOM_ASSASSIN);
        put("Phantom Lancer", HEROES.PHANTOM_LANCER);
        put("Phoenix", HEROES.PHOENIX);
        put("Primal Beast", HEROES.PRIMAL_BEAST);
        put("Puck", HEROES.PUCK);
        put("Pudge", HEROES.PUDGE);
        put("Pugna", HEROES.PUGNA);
        put("Queen of Pain", HEROES.QUEEN_OF_PAIN);
        put("Razor", HEROES.RAZOR);
        put("Riki", HEROES.RIKI);
        put("Rubick", HEROES.RUBICK);
        put("Sand King", HEROES.SAND_KING);
        put("Shadow Demon", HEROES.SHADOW_DEMON);
        put("Shadow Fiend", HEROES.SHADOW_FIEND);
        put("Shadow Shaman", HEROES.SHADOW_SHAMAN);
        put("Silencer", HEROES.SILENCER);
        put("Skywrath Mage", HEROES.SKYWRATH_MAGE);
        put("Slardar", HEROES.SLARDAR);
        put("Slark", HEROES.SLARK);
        put("Snapfire", HEROES.SNAPFIRE);
        put("Sniper", HEROES.SNIPER);
        put("Spectre", HEROES.SPECTRE);
        put("Spirit Breaker", HEROES.SPIRIT_BREAKER);
        put("Storm Spirit", HEROES.STORM_SPIRIT);
        put("Sven", HEROES.SVEN);
        put("Techies", HEROES.TECHIES);
        put("Templar Assassin", HEROES.TEMPLAR_ASSASSIN);
        put("Terrorblade", HEROES.TERRORBLADE);
        put("Tidehunter", HEROES.TIDEHUNTER);
        put("Timbersaw", HEROES.TIMBERSAW);
        put("Tinker", HEROES.TINKER);
        put("Tiny", HEROES.TINY);
        put("Treant Protector", HEROES.TREANT_PROTECTOR);
        put("Troll Warlord", HEROES.TROLL_WARLORD);
        put("Tusk", HEROES.TUSK);
        put("Underlord", HEROES.UNDERLORD);
        put("Undying", HEROES.UNDYING);
        put("Ursa", HEROES.URSA);
        put("Vengeful Spirit", HEROES.VENGEFUL_SPIRIT);
        put("Venomancer", HEROES.VENOMANCER);
        put("Viper", HEROES.VIPER);
        put("Visage", HEROES.VISAGE);
        put("Void Spirit", HEROES.VOID_SPIRIT);
        put("Warlock", HEROES.WARLOCK);
        put("Weaver", HEROES.WEAVER);
        put("Windranger", HEROES.WINDRANGER);
        put("Winter Wyvern", HEROES.WINTER_WYVERN);
        put("Witch Doctor", HEROES.WITCH_DOCTOR);
        put("Wraith King", HEROES.WRAITH_KING);
        put("Zeus", HEROES.ZEUS);
    }};
}
