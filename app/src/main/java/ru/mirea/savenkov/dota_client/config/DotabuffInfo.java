package ru.mirea.savenkov.dota_client.config;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class DotabuffInfo {
    public DotabuffInfo() {
    }

    public final int heroes_count = HEROES.values().length;
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
        ZEUS
    }

    public final Map<HEROES, String> heroesRefs = new HashMap<HEROES, String>(){{
        put(HEROES.ABADDON, "https://www.dotabuff.com/heroes/abaddon");
        put(HEROES.ALCHEMIST, "https://www.dotabuff.com/heroes/alchemist");
        put(HEROES.ANCIENT_APPARITION, "https://www.dotabuff.com/heroes/ancient-apparition");
        put(HEROES.ANTI_MAGE, "https://www.dotabuff.com/heroes/anti-mage");
        put(HEROES.ARC_WARDEN, "https://www.dotabuff.com/heroes/arc-warden");
        put(HEROES.AXE, "https://www.dotabuff.com/heroes/axe");
        put(HEROES.BANE, "https://www.dotabuff.com/heroes/bane");
        put(HEROES.BATRIDER, "https://www.dotabuff.com/heroes/batrider");
        put(HEROES.BEASTMASTER, "https://www.dotabuff.com/heroes/beastmaster");
        put(HEROES.BLOODSEEKER, "https://www.dotabuff.com/heroes/bloodseeker");
        put(HEROES.BOUNTY_HUNTER, "https://www.dotabuff.com/heroes/bounty-hunter");
        put(HEROES.BREWMASTER, "https://www.dotabuff.com/heroes/brewmaster");
        put(HEROES.BRISTLEBACK, "https://www.dotabuff.com/heroes/bristleback");
        put(HEROES.BROODMOTHER, "https://www.dotabuff.com/heroes/broodmother");
        put(HEROES.CENTAUR_WARRUNNER, "https://www.dotabuff.com/heroes/centaur-warrunner");
        put(HEROES.CHAOS_KNIGHT, "https://www.dotabuff.com/heroes/chaos-knight");
        put(HEROES.CHEN, "https://www.dotabuff.com/heroes/chen");
        put(HEROES.CLINKZ, "https://www.dotabuff.com/heroes/clinkz");
        put(HEROES.CLOCKWERK, "https://www.dotabuff.com/heroes/clockwerk");
        put(HEROES.CRYSTAL_MAIDEN, "https://www.dotabuff.com/heroes/crystal-maiden");
        put(HEROES.DARK_SEER, "https://www.dotabuff.com/heroes/dark-seer");
        put(HEROES.DARK_WILLOW, "https://www.dotabuff.com/heroes/dark-willow");
        put(HEROES.DAWNBREAKER, "https://www.dotabuff.com/heroes/dawnbreaker");
        put(HEROES.DAZZLE, "https://www.dotabuff.com/heroes/dazzle");
        put(HEROES.DEATH_PROPHET, "https://www.dotabuff.com/heroes/death-prophet");
        put(HEROES.DISRUPTOR, "https://www.dotabuff.com/heroes/disruptor");
        put(HEROES.DOOM, "https://www.dotabuff.com/heroes/doom");
        put(HEROES.DRAGON_KNIGHT, "https://www.dotabuff.com/heroes/dragon-knight");
        put(HEROES.DROW_RANGER, "https://www.dotabuff.com/heroes/drow-ranger");
        put(HEROES.EARTH_SPIRIT, "https://www.dotabuff.com/heroes/earth-spirit");
        put(HEROES.EARTHSHAKER, "https://www.dotabuff.com/heroes/earthshaker");
        put(HEROES.ELDER_TITAN, "https://www.dotabuff.com/heroes/elder-titan");
        put(HEROES.EMBER_SPIRIT, "https://www.dotabuff.com/heroes/ember-spirit");
        put(HEROES.ENCHANTRESS, "https://www.dotabuff.com/heroes/enchantress");
        put(HEROES.ENIGMA, "https://www.dotabuff.com/heroes/enigma");
        put(HEROES.FACELESS_VOID, "https://www.dotabuff.com/heroes/faceless-void");
        put(HEROES.GRIMSTROKE, "https://www.dotabuff.com/heroes/grimstroke");
        put(HEROES.GYROCOPTER, "https://www.dotabuff.com/heroes/gyrocopter");
        put(HEROES.HOODWINK, "https://www.dotabuff.com/heroes/hoodwink");
        put(HEROES.HUSKAR, "https://www.dotabuff.com/heroes/huskar");
        put(HEROES.INVOKER, "https://www.dotabuff.com/heroes/invoker");
        put(HEROES.IO, "https://www.dotabuff.com/heroes/io");
        put(HEROES.JAKIRO, "https://www.dotabuff.com/heroes/jakiro");
        put(HEROES.JUGGERNAUT, "https://www.dotabuff.com/heroes/juggernaut");
        put(HEROES.KEEPER_OF_THE_LIGHT, "https://www.dotabuff.com/heroes/keeper-of-the-light");
        put(HEROES.KUNKKA, "https://www.dotabuff.com/heroes/kunkka");
        put(HEROES.LEGION_COMMANDER, "https://www.dotabuff.com/heroes/legion-commander");
        put(HEROES.LESHRAC, "https://www.dotabuff.com/heroes/leshrac");
        put(HEROES.LICH, "https://www.dotabuff.com/heroes/lich");
        put(HEROES.LIFESTEALER, "https://www.dotabuff.com/heroes/lifestealer");
        put(HEROES.LINA, "https://www.dotabuff.com/heroes/lina");
        put(HEROES.LION, "https://www.dotabuff.com/heroes/lion");
        put(HEROES.LONE_DRUID, "https://www.dotabuff.com/heroes/lone-druid");
        put(HEROES.LUNA, "https://www.dotabuff.com/heroes/luna");
        put(HEROES.LYCAN, "https://www.dotabuff.com/heroes/lycan");
        put(HEROES.MAGNUS, "https://www.dotabuff.com/heroes/magnus");
        put(HEROES.MARCI, "https://www.dotabuff.com/heroes/marci");
        put(HEROES.MARS, "https://www.dotabuff.com/heroes/mars");
        put(HEROES.MEDUSA, "https://www.dotabuff.com/heroes/medusa");
        put(HEROES.MEEPO, "https://www.dotabuff.com/heroes/meepo");
        put(HEROES.MIRANA, "https://www.dotabuff.com/heroes/mirana");
        put(HEROES.MONKEY_KING, "https://www.dotabuff.com/heroes/monkey-king");
        put(HEROES.MORPHLING, "https://www.dotabuff.com/heroes/morphling");
        put(HEROES.MUERTA, "https://www.dotabuff.com/heroes/muerta");
        put(HEROES.NAGA_SIREN, "https://www.dotabuff.com/heroes/naga-siren");
        put(HEROES.NATURES_PROPHET, "https://www.dotabuff.com/heroes/natures-prophet");
        put(HEROES.NECROPHOS, "https://www.dotabuff.com/heroes/necrophos");
        put(HEROES.NIGHT_STALKER, "https://www.dotabuff.com/heroes/night-stalker");
        put(HEROES.NYX_ASSASSIN, "https://www.dotabuff.com/heroes/nyx-assassin");
        put(HEROES.OGRE_MAGI, "https://www.dotabuff.com/heroes/ogre-magi");
        put(HEROES.OMNIKNIGHT, "https://www.dotabuff.com/heroes/omniknight");
        put(HEROES.ORACLE, "https://www.dotabuff.com/heroes/oracle");
        put(HEROES.OUTWORLD_DESTROYER, "https://www.dotabuff.com/heroes/outworld-destroyer");
        put(HEROES.PANGOLIER, "https://www.dotabuff.com/heroes/pangolier");
        put(HEROES.PHANTOM_ASSASSIN, "https://www.dotabuff.com/heroes/phantom-assassin");
        put(HEROES.PHANTOM_LANCER, "https://www.dotabuff.com/heroes/phantom-lancer");
        put(HEROES.PHOENIX, "https://www.dotabuff.com/heroes/phoenix");
        put(HEROES.PRIMAL_BEAST, "https://www.dotabuff.com/heroes/primal-beast");
        put(HEROES.PUCK, "https://www.dotabuff.com/heroes/puck");
        put(HEROES.PUDGE, "https://www.dotabuff.com/heroes/pudge");
        put(HEROES.PUGNA, "https://www.dotabuff.com/heroes/pugna");
        put(HEROES.QUEEN_OF_PAIN, "https://www.dotabuff.com/heroes/queen-of-pain");
        put(HEROES.RAZOR, "https://www.dotabuff.com/heroes/razor");
        put(HEROES.RIKI, "https://www.dotabuff.com/heroes/riki");
        put(HEROES.RUBICK, "https://www.dotabuff.com/heroes/rubick");
        put(HEROES.SAND_KING, "https://www.dotabuff.com/heroes/sand-king");
        put(HEROES.SHADOW_DEMON, "https://www.dotabuff.com/heroes/shadow-demon");
        put(HEROES.SHADOW_FIEND, "https://www.dotabuff.com/heroes/shadow-fiend");
        put(HEROES.SHADOW_SHAMAN, "https://www.dotabuff.com/heroes/shadow-shaman");
        put(HEROES.SILENCER, "https://www.dotabuff.com/heroes/silencer");
        put(HEROES.SKYWRATH_MAGE, "https://www.dotabuff.com/heroes/skywrath-mage");
        put(HEROES.SLARDAR, "https://www.dotabuff.com/heroes/slardar");
        put(HEROES.SLARK, "https://www.dotabuff.com/heroes/slark");
        put(HEROES.SNAPFIRE, "https://www.dotabuff.com/heroes/snapfire");
        put(HEROES.SNIPER, "https://www.dotabuff.com/heroes/sniper");
        put(HEROES.SPECTRE, "https://www.dotabuff.com/heroes/spectre");
        put(HEROES.SPIRIT_BREAKER, "https://www.dotabuff.com/heroes/spirit-breaker");
        put(HEROES.STORM_SPIRIT, "https://www.dotabuff.com/heroes/storm-spirit");
        put(HEROES.SVEN, "https://www.dotabuff.com/heroes/sven");
        put(HEROES.TECHIES, "https://www.dotabuff.com/heroes/techies");
        put(HEROES.TEMPLAR_ASSASSIN, "https://www.dotabuff.com/heroes/templar-assassin");
        put(HEROES.TERRORBLADE, "https://www.dotabuff.com/heroes/terrorblade");
        put(HEROES.TIDEHUNTER, "https://www.dotabuff.com/heroes/tidehunter");
        put(HEROES.TIMBERSAW, "https://www.dotabuff.com/heroes/timbersaw");
        put(HEROES.TINKER, "https://www.dotabuff.com/heroes/tinker");
        put(HEROES.TINY, "https://www.dotabuff.com/heroes/tiny");
        put(HEROES.TREANT_PROTECTOR, "https://www.dotabuff.com/heroes/treant-protector");
        put(HEROES.TROLL_WARLORD, "https://www.dotabuff.com/heroes/troll-warlord");
        put(HEROES.TUSK, "https://www.dotabuff.com/heroes/tusk");
        put(HEROES.UNDERLORD, "https://www.dotabuff.com/heroes/underlord");
        put(HEROES.UNDYING, "https://www.dotabuff.com/heroes/undying");
        put(HEROES.URSA, "https://www.dotabuff.com/heroes/ursa");
        put(HEROES.VENGEFUL_SPIRIT, "https://www.dotabuff.com/heroes/vengeful-spirit");
        put(HEROES.VENOMANCER, "https://www.dotabuff.com/heroes/venomancer");
        put(HEROES.VIPER, "https://www.dotabuff.com/heroes/viper");
        put(HEROES.VISAGE, "https://www.dotabuff.com/heroes/visage");
        put(HEROES.VOID_SPIRIT, "https://www.dotabuff.com/heroes/void-spirit");
        put(HEROES.WARLOCK, "https://www.dotabuff.com/heroes/warlock");
        put(HEROES.WEAVER, "https://www.dotabuff.com/heroes/weaver");
        put(HEROES.WINDRANGER, "https://www.dotabuff.com/heroes/windranger");
        put(HEROES.WINTER_WYVERN, "https://www.dotabuff.com/heroes/winter-wyvern");
        put(HEROES.WITCH_DOCTOR, "https://www.dotabuff.com/heroes/witch-doctor");
        put(HEROES.WRAITH_KING, "https://www.dotabuff.com/heroes/wraith-king");
        put(HEROES.ZEUS, "https://www.dotabuff.com/heroes/zeus");
    }};
    public final Map<HEROES, String> countersRefs = new HashMap<HEROES, String>() {{
        put(HEROES.ABADDON, "https://www.dotabuff.com/heroes/abaddon/counters");
        put(HEROES.ALCHEMIST, "https://www.dotabuff.com/heroes/alchemist/counters");
        put(HEROES.ANCIENT_APPARITION, "https://www.dotabuff.com/heroes/ancient-apparition/counters");
        put(HEROES.ANTI_MAGE, "https://www.dotabuff.com/heroes/anti-mage/counters");
        put(HEROES.ARC_WARDEN, "https://www.dotabuff.com/heroes/arc-warden/counters");
        put(HEROES.AXE, "https://www.dotabuff.com/heroes/axe/counters");
        put(HEROES.BANE, "https://www.dotabuff.com/heroes/bane/counters");
        put(HEROES.BATRIDER, "https://www.dotabuff.com/heroes/batrider/counters");
        put(HEROES.BEASTMASTER, "https://www.dotabuff.com/heroes/beastmaster/counters");
        put(HEROES.BLOODSEEKER, "https://www.dotabuff.com/heroes/bloodseeker/counters");
        put(HEROES.BOUNTY_HUNTER, "https://www.dotabuff.com/heroes/bounty-hunter/counters");
        put(HEROES.BREWMASTER, "https://www.dotabuff.com/heroes/brewmaster/counters");
        put(HEROES.BRISTLEBACK, "https://www.dotabuff.com/heroes/bristleback/counters");
        put(HEROES.BROODMOTHER, "https://www.dotabuff.com/heroes/broodmother/counters");
        put(HEROES.CENTAUR_WARRUNNER, "https://www.dotabuff.com/heroes/centaur-warrunner/counters");
        put(HEROES.CHAOS_KNIGHT, "https://www.dotabuff.com/heroes/chaos-knight/counters");
        put(HEROES.CHEN, "https://www.dotabuff.com/heroes/chen/counters");
        put(HEROES.CLINKZ, "https://www.dotabuff.com/heroes/clinkz/counters");
        put(HEROES.CLOCKWERK, "https://www.dotabuff.com/heroes/clockwerk/counters");
        put(HEROES.CRYSTAL_MAIDEN, "https://www.dotabuff.com/heroes/crystal-maiden/counters");
        put(HEROES.DARK_SEER, "https://www.dotabuff.com/heroes/dark-seer/counters");
        put(HEROES.DARK_WILLOW, "https://www.dotabuff.com/heroes/dark-willow/counters");
        put(HEROES.DAWNBREAKER, "https://www.dotabuff.com/heroes/dawnbreaker/counters");
        put(HEROES.DAZZLE, "https://www.dotabuff.com/heroes/dazzle/counters");
        put(HEROES.DEATH_PROPHET, "https://www.dotabuff.com/heroes/death-prophet/counters");
        put(HEROES.DISRUPTOR, "https://www.dotabuff.com/heroes/disruptor/counters");
        put(HEROES.DOOM, "https://www.dotabuff.com/heroes/doom/counters");
        put(HEROES.DRAGON_KNIGHT, "https://www.dotabuff.com/heroes/dragon-knight/counters");
        put(HEROES.DROW_RANGER, "https://www.dotabuff.com/heroes/drow-ranger/counters");
        put(HEROES.EARTH_SPIRIT, "https://www.dotabuff.com/heroes/earth-spirit/counters");
        put(HEROES.EARTHSHAKER, "https://www.dotabuff.com/heroes/earthshaker/counters");
        put(HEROES.ELDER_TITAN, "https://www.dotabuff.com/heroes/elder-titan/counters");
        put(HEROES.EMBER_SPIRIT, "https://www.dotabuff.com/heroes/ember-spirit/counters");
        put(HEROES.ENCHANTRESS, "https://www.dotabuff.com/heroes/enchantress/counters");
        put(HEROES.ENIGMA, "https://www.dotabuff.com/heroes/enigma/counters");
        put(HEROES.FACELESS_VOID, "https://www.dotabuff.com/heroes/faceless-void/counters");
        put(HEROES.GRIMSTROKE, "https://www.dotabuff.com/heroes/grimstroke/counters");
        put(HEROES.GYROCOPTER, "https://www.dotabuff.com/heroes/gyrocopter/counters");
        put(HEROES.HOODWINK, "https://www.dotabuff.com/heroes/hoodwink/counters");
        put(HEROES.HUSKAR, "https://www.dotabuff.com/heroes/huskar/counters");
        put(HEROES.INVOKER, "https://www.dotabuff.com/heroes/invoker/counters");
        put(HEROES.IO, "https://www.dotabuff.com/heroes/io/counters");
        put(HEROES.JAKIRO, "https://www.dotabuff.com/heroes/jakiro/counters");
        put(HEROES.JUGGERNAUT, "https://www.dotabuff.com/heroes/juggernaut/counters");
        put(HEROES.KEEPER_OF_THE_LIGHT, "https://www.dotabuff.com/heroes/keeper-of-the-light/counters");
        put(HEROES.KUNKKA, "https://www.dotabuff.com/heroes/kunkka/counters");
        put(HEROES.LEGION_COMMANDER, "https://www.dotabuff.com/heroes/legion-commander/counters");
        put(HEROES.LESHRAC, "https://www.dotabuff.com/heroes/leshrac/counters");
        put(HEROES.LICH, "https://www.dotabuff.com/heroes/lich/counters");
        put(HEROES.LIFESTEALER, "https://www.dotabuff.com/heroes/lifestealer/counters");
        put(HEROES.LINA, "https://www.dotabuff.com/heroes/lina/counters");
        put(HEROES.LION, "https://www.dotabuff.com/heroes/lion/counters");
        put(HEROES.LONE_DRUID, "https://www.dotabuff.com/heroes/lone-druid/counters");
        put(HEROES.LUNA, "https://www.dotabuff.com/heroes/luna/counters");
        put(HEROES.LYCAN, "https://www.dotabuff.com/heroes/lycan/counters");
        put(HEROES.MAGNUS, "https://www.dotabuff.com/heroes/magnus/counters");
        put(HEROES.MARCI, "https://www.dotabuff.com/heroes/marci/counters");
        put(HEROES.MARS, "https://www.dotabuff.com/heroes/mars/counters");
        put(HEROES.MEDUSA, "https://www.dotabuff.com/heroes/medusa/counters");
        put(HEROES.MEEPO, "https://www.dotabuff.com/heroes/meepo/counters");
        put(HEROES.MIRANA, "https://www.dotabuff.com/heroes/mirana/counters");
        put(HEROES.MONKEY_KING, "https://www.dotabuff.com/heroes/monkey-king/counters");
        put(HEROES.MORPHLING, "https://www.dotabuff.com/heroes/morphling/counters");
        put(HEROES.MUERTA, "https://www.dotabuff.com/heroes/muerta/counters");
        put(HEROES.NAGA_SIREN, "https://www.dotabuff.com/heroes/naga-siren/counters");
        put(HEROES.NATURES_PROPHET, "https://www.dotabuff.com/heroes/natures-prophet/counters");
        put(HEROES.NECROPHOS, "https://www.dotabuff.com/heroes/necrophos/counters");
        put(HEROES.NIGHT_STALKER, "https://www.dotabuff.com/heroes/night-stalker/counters");
        put(HEROES.NYX_ASSASSIN, "https://www.dotabuff.com/heroes/nyx-assassin/counters");
        put(HEROES.OGRE_MAGI, "https://www.dotabuff.com/heroes/ogre-magi/counters");
        put(HEROES.OMNIKNIGHT, "https://www.dotabuff.com/heroes/omniknight/counters");
        put(HEROES.ORACLE, "https://www.dotabuff.com/heroes/oracle/counters");
        put(HEROES.OUTWORLD_DESTROYER, "https://www.dotabuff.com/heroes/outworld-destroyer/counters");
        put(HEROES.PANGOLIER, "https://www.dotabuff.com/heroes/pangolier/counters");
        put(HEROES.PHANTOM_ASSASSIN, "https://www.dotabuff.com/heroes/phantom-assassin/counters");
        put(HEROES.PHANTOM_LANCER, "https://www.dotabuff.com/heroes/phantom-lancer/counters");
        put(HEROES.PHOENIX, "https://www.dotabuff.com/heroes/phoenix/counters");
        put(HEROES.PRIMAL_BEAST, "https://www.dotabuff.com/heroes/primal-beast/counters");
        put(HEROES.PUCK, "https://www.dotabuff.com/heroes/puck/counters");
        put(HEROES.PUDGE, "https://www.dotabuff.com/heroes/pudge/counters");
        put(HEROES.PUGNA, "https://www.dotabuff.com/heroes/pugna/counters");
        put(HEROES.QUEEN_OF_PAIN, "https://www.dotabuff.com/heroes/queen-of-pain/counters");
        put(HEROES.RAZOR, "https://www.dotabuff.com/heroes/razor/counters");
        put(HEROES.RIKI, "https://www.dotabuff.com/heroes/riki/counters");
        put(HEROES.RUBICK, "https://www.dotabuff.com/heroes/rubick/counters");
        put(HEROES.SAND_KING, "https://www.dotabuff.com/heroes/sand-king/counters");
        put(HEROES.SHADOW_DEMON, "https://www.dotabuff.com/heroes/shadow-demon/counters");
        put(HEROES.SHADOW_FIEND, "https://www.dotabuff.com/heroes/shadow-fiend/counters");
        put(HEROES.SHADOW_SHAMAN, "https://www.dotabuff.com/heroes/shadow-shaman/counters");
        put(HEROES.SILENCER, "https://www.dotabuff.com/heroes/silencer/counters");
        put(HEROES.SKYWRATH_MAGE, "https://www.dotabuff.com/heroes/skywrath-mage/counters");
        put(HEROES.SLARDAR, "https://www.dotabuff.com/heroes/slardar/counters");
        put(HEROES.SLARK, "https://www.dotabuff.com/heroes/slark/counters");
        put(HEROES.SNAPFIRE, "https://www.dotabuff.com/heroes/snapfire/counters");
        put(HEROES.SNIPER, "https://www.dotabuff.com/heroes/sniper/counters");
        put(HEROES.SPECTRE, "https://www.dotabuff.com/heroes/spectre/counters");
        put(HEROES.SPIRIT_BREAKER, "https://www.dotabuff.com/heroes/spirit-breaker/counters");
        put(HEROES.STORM_SPIRIT, "https://www.dotabuff.com/heroes/storm-spirit/counters");
        put(HEROES.SVEN, "https://www.dotabuff.com/heroes/sven/counters");
        put(HEROES.TECHIES, "https://www.dotabuff.com/heroes/techies/counters");
        put(HEROES.TEMPLAR_ASSASSIN, "https://www.dotabuff.com/heroes/templar-assassin/counters");
        put(HEROES.TERRORBLADE, "https://www.dotabuff.com/heroes/terrorblade/counters");
        put(HEROES.TIDEHUNTER, "https://www.dotabuff.com/heroes/tidehunter/counters");
        put(HEROES.TIMBERSAW, "https://www.dotabuff.com/heroes/timbersaw/counters");
        put(HEROES.TINKER, "https://www.dotabuff.com/heroes/tinker/counters");
        put(HEROES.TINY, "https://www.dotabuff.com/heroes/tiny/counters");
        put(HEROES.TREANT_PROTECTOR, "https://www.dotabuff.com/heroes/treant-protector/counters");
        put(HEROES.TROLL_WARLORD, "https://www.dotabuff.com/heroes/troll-warlord/counters");
        put(HEROES.TUSK, "https://www.dotabuff.com/heroes/tusk/counters");
        put(HEROES.UNDERLORD, "https://www.dotabuff.com/heroes/underlord/counters");
        put(HEROES.UNDYING, "https://www.dotabuff.com/heroes/undying/counters");
        put(HEROES.URSA, "https://www.dotabuff.com/heroes/ursa/counters");
        put(HEROES.VENGEFUL_SPIRIT, "https://www.dotabuff.com/heroes/vengeful-spirit/counters");
        put(HEROES.VENOMANCER, "https://www.dotabuff.com/heroes/venomancer/counters");
        put(HEROES.VIPER, "https://www.dotabuff.com/heroes/viper/counters");
        put(HEROES.VISAGE, "https://www.dotabuff.com/heroes/visage/counters");
        put(HEROES.VOID_SPIRIT, "https://www.dotabuff.com/heroes/void-spirit/counters");
        put(HEROES.WARLOCK, "https://www.dotabuff.com/heroes/warlock/counters");
        put(HEROES.WEAVER, "https://www.dotabuff.com/heroes/weaver/counters");
        put(HEROES.WINDRANGER, "https://www.dotabuff.com/heroes/windranger/counters");
        put(HEROES.WINTER_WYVERN, "https://www.dotabuff.com/heroes/winter-wyvern/counters");
        put(HEROES.WITCH_DOCTOR, "https://www.dotabuff.com/heroes/witch-doctor/counters");
        put(HEROES.WRAITH_KING, "https://www.dotabuff.com/heroes/wraith-king/counters");
        put(HEROES.ZEUS, "https://www.dotabuff.com/heroes/zeus/counters");
    }};

    public final HashMap<String, HEROES> stringHeroToEnum = new HashMap<String, HEROES>(){{
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

    public final String[] rawHeroesString = new String[] {
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
}
