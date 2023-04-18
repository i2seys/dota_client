package ru.mirea.savenkov.dota_client.config;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
            "Spectre", "Spirit breaker",
            "Storm spirit", "Sven",
            "Techies", "Templar assassin",
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
}
