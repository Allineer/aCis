/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.l2j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import net.sf.l2j.commons.config.ExProperties;
import net.sf.l2j.gameserver.util.FloodProtectorConfig;
import net.sf.l2j.util.StringUtil;

/**
 * This class contains global server configuration.<br>
 * It has static final fields initialized from configuration files.<br>
 * @author mkizub
 */
public final class Config
{
	protected static final Logger _log = Logger.getLogger(Config.class.getName());
	
	public static final String BANNED_IP_XML = "./config/banned.xml";
	public static final String CLANS_FILE = "./config/clans.properties";
	public static final String EVENTS_FILE = "./config/events.properties";
	public static final String FLOOD_PROTECTOR_FILE = "./config/floodprotector.properties";
	public static final String HEXID_FILE = "./config/hexid.txt";
	public static final String LOGIN_CONFIGURATION_FILE = "./config/loginserver.properties";
	public static final String NPCS_FILE = "./config/npcs.properties";
	public static final String PLAYERS_FILE = "./config/players.properties";
	public static final String SERVER_FILE = "./config/server.properties";
	public static final String SIEGE_FILE = "./config/siege.properties";
	
	// --------------------------------------------------
	// Clans settings
	// --------------------------------------------------
	
	/** Clans */
	public static int ALT_CLAN_JOIN_DAYS;
	public static int ALT_CLAN_CREATE_DAYS;
	public static int ALT_CLAN_DISSOLVE_DAYS;
	public static int ALT_ALLY_JOIN_DAYS_WHEN_LEAVED;
	public static int ALT_ALLY_JOIN_DAYS_WHEN_DISMISSED;
	public static int ALT_ACCEPT_CLAN_DAYS_WHEN_DISMISSED;
	public static int ALT_CREATE_ALLY_DAYS_WHEN_DISSOLVED;
	public static int ALT_MAX_NUM_OF_CLANS_IN_ALLY;
	public static int ALT_CLAN_MEMBERS_FOR_WAR;
	public static int ALT_CLAN_WAR_PENALTY_WHEN_ENDED;
	public static boolean ALT_MEMBERS_CAN_WITHDRAW_FROM_CLANWH;
	public static boolean REMOVE_CASTLE_CIRCLETS;
	
	/** Manor */
	public static int ALT_MANOR_REFRESH_TIME;
	public static int ALT_MANOR_REFRESH_MIN;
	public static int ALT_MANOR_APPROVE_TIME;
	public static int ALT_MANOR_APPROVE_MIN;
	public static int ALT_MANOR_MAINTENANCE_PERIOD;
	public static boolean ALT_MANOR_SAVE_ALL_ACTIONS;
	public static int ALT_MANOR_SAVE_PERIOD_RATE;
	
	/** Clan Hall function */
	public static long CH_TELE_FEE_RATIO;
	public static int CH_TELE1_FEE;
	public static int CH_TELE2_FEE;
	public static long CH_ITEM_FEE_RATIO;
	public static int CH_ITEM1_FEE;
	public static int CH_ITEM2_FEE;
	public static int CH_ITEM3_FEE;
	public static long CH_MPREG_FEE_RATIO;
	public static int CH_MPREG1_FEE;
	public static int CH_MPREG2_FEE;
	public static int CH_MPREG3_FEE;
	public static int CH_MPREG4_FEE;
	public static int CH_MPREG5_FEE;
	public static long CH_HPREG_FEE_RATIO;
	public static int CH_HPREG1_FEE;
	public static int CH_HPREG2_FEE;
	public static int CH_HPREG3_FEE;
	public static int CH_HPREG4_FEE;
	public static int CH_HPREG5_FEE;
	public static int CH_HPREG6_FEE;
	public static int CH_HPREG7_FEE;
	public static int CH_HPREG8_FEE;
	public static int CH_HPREG9_FEE;
	public static int CH_HPREG10_FEE;
	public static int CH_HPREG11_FEE;
	public static int CH_HPREG12_FEE;
	public static int CH_HPREG13_FEE;
	public static long CH_EXPREG_FEE_RATIO;
	public static int CH_EXPREG1_FEE;
	public static int CH_EXPREG2_FEE;
	public static int CH_EXPREG3_FEE;
	public static int CH_EXPREG4_FEE;
	public static int CH_EXPREG5_FEE;
	public static int CH_EXPREG6_FEE;
	public static int CH_EXPREG7_FEE;
	public static long CH_SUPPORT_FEE_RATIO;
	public static int CH_SUPPORT1_FEE;
	public static int CH_SUPPORT2_FEE;
	public static int CH_SUPPORT3_FEE;
	public static int CH_SUPPORT4_FEE;
	public static int CH_SUPPORT5_FEE;
	public static int CH_SUPPORT6_FEE;
	public static int CH_SUPPORT7_FEE;
	public static int CH_SUPPORT8_FEE;
	public static long CH_CURTAIN_FEE_RATIO;
	public static int CH_CURTAIN1_FEE;
	public static int CH_CURTAIN2_FEE;
	public static long CH_FRONT_FEE_RATIO;
	public static int CH_FRONT1_FEE;
	public static int CH_FRONT2_FEE;
	
	// --------------------------------------------------
	// Events settings
	// --------------------------------------------------
	
	/** Olympiad */
	public static int ALT_OLY_START_TIME;
	public static int ALT_OLY_MIN;
	public static long ALT_OLY_CPERIOD;
	public static long ALT_OLY_BATTLE;
	public static long ALT_OLY_WPERIOD;
	public static long ALT_OLY_VPERIOD;
	public static int ALT_OLY_WAIT_TIME;
	public static int ALT_OLY_WAIT_BATTLE;
	public static int ALT_OLY_WAIT_END;
	public static int ALT_OLY_START_POINTS;
	public static int ALT_OLY_WEEKLY_POINTS;
	public static int ALT_OLY_MIN_MATCHES;
	public static int ALT_OLY_CLASSED;
	public static int ALT_OLY_NONCLASSED;
	public static int[][] ALT_OLY_CLASSED_REWARD;
	public static int[][] ALT_OLY_NONCLASSED_REWARD;
	public static int ALT_OLY_COMP_RITEM;
	public static int ALT_OLY_GP_PER_POINT;
	public static int ALT_OLY_HERO_POINTS;
	public static int ALT_OLY_RANK1_POINTS;
	public static int ALT_OLY_RANK2_POINTS;
	public static int ALT_OLY_RANK3_POINTS;
	public static int ALT_OLY_RANK4_POINTS;
	public static int ALT_OLY_RANK5_POINTS;
	public static int ALT_OLY_MAX_POINTS;
	public static int ALT_OLY_DIVIDER_CLASSED;
	public static int ALT_OLY_DIVIDER_NON_CLASSED;
	public static boolean ALT_OLY_ANNOUNCE_GAMES;
	
	/** SevenSigns Festival */
	public static boolean ALT_GAME_REQUIRE_CLAN_CASTLE;
	public static boolean ALT_GAME_CASTLE_DAWN;
	public static boolean ALT_GAME_CASTLE_DUSK;
	public static int ALT_FESTIVAL_MIN_PLAYER;
	public static int ALT_MAXIMUM_PLAYER_CONTRIB;
	public static long ALT_FESTIVAL_MANAGER_START;
	public static long ALT_FESTIVAL_LENGTH;
	public static long ALT_FESTIVAL_CYCLE_LENGTH;
	public static long ALT_FESTIVAL_FIRST_SPAWN;
	public static long ALT_FESTIVAL_FIRST_SWARM;
	public static long ALT_FESTIVAL_SECOND_SPAWN;
	public static long ALT_FESTIVAL_SECOND_SWARM;
	public static long ALT_FESTIVAL_CHEST_SPAWN;
	public static boolean ALT_SEVENSIGNS_LAZY_UPDATE;
	
	/** Four Sepulchers */
	public static int FS_TIME_ATTACK;
	public static int FS_TIME_COOLDOWN;
	public static int FS_TIME_ENTRY;
	public static int FS_TIME_WARMUP;
	public static int FS_PARTY_MEMBER_COUNT;
	
	/** dimensional rift */
	public static int RIFT_MIN_PARTY_SIZE;
	public static int RIFT_SPAWN_DELAY;
	public static int RIFT_MAX_JUMPS;
	public static int RIFT_AUTO_JUMPS_TIME_MIN;
	public static int RIFT_AUTO_JUMPS_TIME_MAX;
	public static int RIFT_ENTER_COST_RECRUIT;
	public static int RIFT_ENTER_COST_SOLDIER;
	public static int RIFT_ENTER_COST_OFFICER;
	public static int RIFT_ENTER_COST_CAPTAIN;
	public static int RIFT_ENTER_COST_COMMANDER;
	public static int RIFT_ENTER_COST_HERO;
	public static double RIFT_BOSS_ROOM_TIME_MUTIPLY;
	
	/** Wedding system */
	public static boolean ALLOW_WEDDING;
	public static int WEDDING_PRICE;
	public static boolean WEDDING_SAMESEX;
	public static boolean WEDDING_FORMALWEAR;
	
	/** Lottery */
	public static int ALT_LOTTERY_PRIZE;
	public static int ALT_LOTTERY_TICKET_PRICE;
	public static double ALT_LOTTERY_5_NUMBER_RATE;
	public static double ALT_LOTTERY_4_NUMBER_RATE;
	public static double ALT_LOTTERY_3_NUMBER_RATE;
	public static int ALT_LOTTERY_2_AND_1_NUMBER_PRIZE;
	
	/** Fishing tournament */
	public static boolean ALT_FISH_CHAMPIONSHIP_ENABLED;
	public static int ALT_FISH_CHAMPIONSHIP_REWARD_ITEM;
	public static int ALT_FISH_CHAMPIONSHIP_REWARD_1;
	public static int ALT_FISH_CHAMPIONSHIP_REWARD_2;
	public static int ALT_FISH_CHAMPIONSHIP_REWARD_3;
	public static int ALT_FISH_CHAMPIONSHIP_REWARD_4;
	public static int ALT_FISH_CHAMPIONSHIP_REWARD_5;
	
	// --------------------------------------------------
	// HexID
	// --------------------------------------------------
	
	public static int SERVER_ID;
	public static byte[] HEX_ID;
	
	// --------------------------------------------------
	// FloodProtectors
	// --------------------------------------------------
	
	public static FloodProtectorConfig FLOOD_PROTECTOR_ROLL_DICE;
	public static FloodProtectorConfig FLOOD_PROTECTOR_HERO_VOICE;
	public static FloodProtectorConfig FLOOD_PROTECTOR_SUBCLASS;
	public static FloodProtectorConfig FLOOD_PROTECTOR_DROP_ITEM;
	public static FloodProtectorConfig FLOOD_PROTECTOR_SERVER_BYPASS;
	public static FloodProtectorConfig FLOOD_PROTECTOR_MULTISELL;
	public static FloodProtectorConfig FLOOD_PROTECTOR_MANUFACTURE;
	public static FloodProtectorConfig FLOOD_PROTECTOR_MANOR;
	public static FloodProtectorConfig FLOOD_PROTECTOR_SENDMAIL;
	public static FloodProtectorConfig FLOOD_PROTECTOR_CHARACTER_SELECT;
	
	// --------------------------------------------------
	// Loginserver
	// --------------------------------------------------
	
	public static String LOGIN_BIND_ADDRESS;
	public static int PORT_LOGIN;
	
	public static boolean ACCEPT_NEW_GAMESERVER;
	public static int REQUEST_ID;
	public static boolean ACCEPT_ALTERNATE_ID;
	
	public static int LOGIN_TRY_BEFORE_BAN;
	public static int LOGIN_BLOCK_AFTER_BAN;
	
	public static boolean LOG_LOGIN_CONTROLLER;
	
	public static boolean SHOW_LICENCE;
	public static int IP_UPDATE_TIME;
	public static boolean FORCE_GGAUTH;
	
	public static boolean AUTO_CREATE_ACCOUNTS;
	
	public static boolean FLOOD_PROTECTION;
	public static int FAST_CONNECTION_LIMIT;
	public static int NORMAL_CONNECTION_TIME;
	public static int FAST_CONNECTION_TIME;
	public static int MAX_CONNECTION_PER_IP;
	
	// --------------------------------------------------
	// NPCs / Monsters
	// --------------------------------------------------
	
	/** Champion Mod */
	public static int CHAMPION_FREQUENCY;
	public static int CHAMP_MIN_LVL;
	public static int CHAMP_MAX_LVL;
	public static int CHAMPION_HP;
	public static int CHAMPION_REWARDS;
	public static int CHAMPION_ADENAS_REWARDS;
	public static double CHAMPION_HP_REGEN;
	public static double CHAMPION_ATK;
	public static double CHAMPION_SPD_ATK;
	public static int CHAMPION_REWARD;
	public static int CHAMPION_REWARD_ID;
	public static int CHAMPION_REWARD_QTY;
	
	/** Misc */
	public static boolean ALLOW_CLASS_MASTERS;
	public static ClassMasterSettings CLASS_MASTER_SETTINGS;
	public static boolean ALLOW_ENTIRE_TREE;
	public static boolean ANNOUNCE_MAMMON_SPAWN;
	public static boolean ALT_MOB_AGRO_IN_PEACEZONE;
	public static boolean ALT_GAME_FREE_TELEPORT;
	public static boolean SHOW_NPC_LVL;
	public static boolean SHOW_NPC_CREST;
	public static boolean SHOW_SUMMON_CREST;
	
	/** Wyvern Manager */
	public static boolean WYVERN_ALLOW_UPGRADER;
	public static int WYVERN_REQUIRED_LEVEL;
	public static int WYVERN_REQUIRED_CRYSTALS;
	
	/** Raid Boss */
	public static double RAID_HP_REGEN_MULTIPLIER;
	public static double RAID_MP_REGEN_MULTIPLIER;
	public static double RAID_DEFENCE_MULTIPLIER;
	public static double RAID_MINION_RESPAWN_TIMER;
	
	public static boolean RAID_DISABLE_CURSE;
	public static int RAID_CHAOS_TIME;
	public static int GRAND_CHAOS_TIME;
	public static int MINION_CHAOS_TIME;
	
	/** Grand Boss */
	public static int SPAWN_INTERVAL_AQ;
	public static int RANDOM_SPAWN_TIME_AQ;
	
	public static int SPAWN_INTERVAL_ANTHARAS;
	public static int RANDOM_SPAWN_TIME_ANTHARAS;
	public static int WAIT_TIME_ANTHARAS;
	
	public static int SPAWN_INTERVAL_BAIUM;
	public static int RANDOM_SPAWN_TIME_BAIUM;
	
	public static int SPAWN_INTERVAL_CORE;
	public static int RANDOM_SPAWN_TIME_CORE;
	
	public static int SPAWN_INTERVAL_FRINTEZZA;
	public static int RANDOM_SPAWN_TIME_FRINTEZZA;
	
	public static int SPAWN_INTERVAL_ORFEN;
	public static int RANDOM_SPAWN_TIME_ORFEN;
	
	public static int SPAWN_INTERVAL_SAILREN;
	public static int RANDOM_SPAWN_TIME_SAILREN;
	public static int WAIT_TIME_SAILREN;
	
	public static int SPAWN_INTERVAL_VALAKAS;
	public static int RANDOM_SPAWN_TIME_VALAKAS;
	public static int WAIT_TIME_VALAKAS;
	
	public static int SPAWN_INTERVAL_ZAKEN;
	public static int RANDOM_SPAWN_TIME_ZAKEN;
	
	/** IA */
	public static boolean GUARD_ATTACK_AGGRO_MOB;
	public static int MAX_DRIFT_RANGE;
	public static long KNOWNLIST_UPDATE_INTERVAL;
	public static int MIN_NPC_ANIMATION;
	public static int MAX_NPC_ANIMATION;
	public static int MIN_MONSTER_ANIMATION;
	public static int MAX_MONSTER_ANIMATION;
	
	public static boolean GRIDS_ALWAYS_ON;
	public static int GRID_NEIGHBOR_TURNON_TIME;
	public static int GRID_NEIGHBOR_TURNOFF_TIME;
	
	// --------------------------------------------------
	// Players
	// --------------------------------------------------
	
	/** Misc */
	public static int STARTING_ADENA;
	public static boolean EFFECT_CANCELING;
	public static double HP_REGEN_MULTIPLIER;
	public static double MP_REGEN_MULTIPLIER;
	public static double CP_REGEN_MULTIPLIER;
	public static int PLAYER_SPAWN_PROTECTION;
	public static int PLAYER_FAKEDEATH_UP_PROTECTION;
	public static double RESPAWN_RESTORE_HP;
	public static int MAX_PVTSTORE_SLOTS_DWARF;
	public static int MAX_PVTSTORE_SLOTS_OTHER;
	public static boolean DEEPBLUE_DROP_RULES;
	public static boolean ALT_GAME_DELEVEL;
	public static int DEATH_PENALTY_CHANCE;
	
	/** Inventory & WH */
	public static int INVENTORY_MAXIMUM_NO_DWARF;
	public static int INVENTORY_MAXIMUM_DWARF;
	public static int INVENTORY_MAXIMUM_QUEST_ITEMS;
	public static int INVENTORY_MAXIMUM_PET;
	public static int MAX_ITEM_IN_PACKET;
	public static double ALT_WEIGHT_LIMIT;
	public static int WAREHOUSE_SLOTS_NO_DWARF;
	public static int WAREHOUSE_SLOTS_DWARF;
	public static int WAREHOUSE_SLOTS_CLAN;
	public static int FREIGHT_SLOTS;
	public static boolean ALT_GAME_FREIGHTS;
	public static int ALT_GAME_FREIGHT_PRICE;
	
	/** Enchant */
	public static double ENCHANT_CHANCE_WEAPON_MAGIC;
	public static double ENCHANT_CHANCE_WEAPON_MAGIC_15PLUS;
	public static double ENCHANT_CHANCE_WEAPON_NONMAGIC;
	public static double ENCHANT_CHANCE_WEAPON_NONMAGIC_15PLUS;
	public static double ENCHANT_CHANCE_ARMOR;
	public static int ENCHANT_MAX_WEAPON;
	public static int ENCHANT_MAX_ARMOR;
	public static int ENCHANT_SAFE_MAX;
	public static int ENCHANT_SAFE_MAX_FULL;
	
	/** Augmentations */
	public static int AUGMENTATION_NG_SKILL_CHANCE;
	public static int AUGMENTATION_NG_GLOW_CHANCE;
	public static int AUGMENTATION_MID_SKILL_CHANCE;
	public static int AUGMENTATION_MID_GLOW_CHANCE;
	public static int AUGMENTATION_HIGH_SKILL_CHANCE;
	public static int AUGMENTATION_HIGH_GLOW_CHANCE;
	public static int AUGMENTATION_TOP_SKILL_CHANCE;
	public static int AUGMENTATION_TOP_GLOW_CHANCE;
	public static int AUGMENTATION_BASESTAT_CHANCE;
	
	/** Karma & PvP */
	public static boolean KARMA_PLAYER_CAN_BE_KILLED_IN_PZ;
	public static boolean KARMA_PLAYER_CAN_SHOP;
	public static boolean KARMA_PLAYER_CAN_USE_GK;
	public static boolean KARMA_PLAYER_CAN_TELEPORT;
	public static boolean KARMA_PLAYER_CAN_TRADE;
	public static boolean KARMA_PLAYER_CAN_USE_WH;
	
	public static boolean KARMA_DROP_GM;
	public static boolean KARMA_AWARD_PK_KILL;
	public static int KARMA_PK_LIMIT;
	
	public static String KARMA_NONDROPPABLE_PET_ITEMS;
	public static String KARMA_NONDROPPABLE_ITEMS;
	public static int[] KARMA_LIST_NONDROPPABLE_PET_ITEMS;
	public static int[] KARMA_LIST_NONDROPPABLE_ITEMS;
	
	public static int PVP_NORMAL_TIME;
	public static int PVP_PVP_TIME;
	
	/** Party */
	public static String PARTY_XP_CUTOFF_METHOD;
	public static int PARTY_XP_CUTOFF_LEVEL;
	public static double PARTY_XP_CUTOFF_PERCENT;
	public static int ALT_PARTY_RANGE;
	public static int ALT_PARTY_RANGE2;
	
	/** GMs & Admin Stuff */
	public static boolean EVERYBODY_HAS_ADMIN_RIGHTS;
	public static int MASTERACCESS_LEVEL;
	public static int MASTERACCESS_NAME_COLOR;
	public static int MASTERACCESS_TITLE_COLOR;
	public static boolean GM_HERO_AURA;
	public static boolean GM_STARTUP_INVULNERABLE;
	public static boolean GM_STARTUP_INVISIBLE;
	public static boolean GM_STARTUP_SILENCE;
	public static boolean GM_STARTUP_AUTO_LIST;
	
	/** petitions */
	public static boolean PETITIONING_ALLOWED;
	public static int MAX_PETITIONS_PER_PLAYER;
	public static int MAX_PETITIONS_PENDING;
	
	/** Crafting **/
	public static boolean IS_CRAFTING_ENABLED;
	public static int DWARF_RECIPE_LIMIT;
	public static int COMMON_RECIPE_LIMIT;
	public static boolean ALT_BLACKSMITH_USE_RECIPES;
	
	/** Skills & Classes **/
	public static boolean AUTO_LEARN_SKILLS;
	public static boolean ALT_GAME_MAGICFAILURES;
	public static boolean ALT_GAME_SHIELD_BLOCKS;
	public static int ALT_PERFECT_SHLD_BLOCK;
	public static boolean LIFE_CRYSTAL_NEEDED;
	public static boolean SP_BOOK_NEEDED;
	public static boolean ES_SP_BOOK_NEEDED;
	public static boolean DIVINE_SP_BOOK_NEEDED;
	public static boolean ALT_GAME_SUBCLASS_WITHOUT_QUESTS;
	
	/** Buffs */
	public static boolean STORE_SKILL_COOLTIME;
	public static int BUFFS_MAX_AMOUNT;
	
	// --------------------------------------------------
	// Server
	// --------------------------------------------------
	
	public static String GAMESERVER_HOSTNAME;
	public static int PORT_GAME;
	public static String EXTERNAL_HOSTNAME;
	public static String INTERNAL_HOSTNAME;
	public static int GAME_SERVER_LOGIN_PORT;
	public static String GAME_SERVER_LOGIN_HOST;
	
	/** Access to database */
	public static String DATABASE_URL;
	public static String DATABASE_LOGIN;
	public static String DATABASE_PASSWORD;
	public static int DATABASE_MAX_CONNECTIONS;
	public static int DATABASE_MAX_IDLE_TIME;
	
	/** serverList & Test */
	public static boolean SERVER_LIST_BRACKET;
	public static boolean SERVER_LIST_CLOCK;
	public static boolean SERVER_LIST_TESTSERVER;
	public static boolean SERVER_GMONLY;
	public static boolean TEST_SERVER;
	
	/** clients related */
	public static int DELETE_DAYS;
	public static int MAXIMUM_ONLINE_USERS;
	public static int MIN_PROTOCOL_REVISION;
	public static int MAX_PROTOCOL_REVISION;
	
	/** Jail & Punishements **/
	public static boolean JAIL_IS_PVP;
	public static int DEFAULT_PUNISH;
	public static int DEFAULT_PUNISH_PARAM;
	
	/** Auto-loot */
	public static boolean AUTO_LOOT;
	public static boolean AUTO_LOOT_HERBS;
	public static boolean AUTO_LOOT_RAID;
	
	/** Items Management */
	public static boolean ALLOW_DISCARDITEM;
	public static boolean MULTIPLE_ITEM_DROP;
	public static int AUTODESTROY_ITEM_AFTER;
	public static int HERB_AUTO_DESTROY_TIME;
	public static String PROTECTED_ITEMS;
	
	public static List<Integer> LIST_PROTECTED_ITEMS;
	
	public static boolean DESTROY_DROPPED_PLAYER_ITEM;
	public static boolean DESTROY_EQUIPABLE_PLAYER_ITEM;
	public static boolean SAVE_DROPPED_ITEM;
	public static boolean EMPTY_DROPPED_ITEM_TABLE_AFTER_LOAD;
	public static int SAVE_DROPPED_ITEM_INTERVAL;
	public static boolean CLEAR_DROPPED_ITEM_TABLE;
	
	/** Rate control */
	public static double RATE_XP;
	public static double RATE_SP;
	public static double RATE_PARTY_XP;
	public static double RATE_PARTY_SP;
	public static double RATE_DROP_ADENA;
	public static double RATE_CONSUMABLE_COST;
	public static double RATE_DROP_ITEMS;
	public static double RATE_DROP_ITEMS_BY_RAID;
	public static double RATE_DROP_SPOIL;
	public static int RATE_DROP_MANOR;
	
	public static double RATE_QUEST_DROP;
	public static double RATE_QUEST_REWARD;
	public static double RATE_QUEST_REWARD_XP;
	public static double RATE_QUEST_REWARD_SP;
	public static double RATE_QUEST_REWARD_ADENA;
	
	public static double RATE_KARMA_EXP_LOST;
	public static double RATE_SIEGE_GUARDS_PRICE;
	
	public static int PLAYER_DROP_LIMIT;
	public static int PLAYER_RATE_DROP;
	public static int PLAYER_RATE_DROP_ITEM;
	public static int PLAYER_RATE_DROP_EQUIP;
	public static int PLAYER_RATE_DROP_EQUIP_WEAPON;
	
	public static int KARMA_DROP_LIMIT;
	public static int KARMA_RATE_DROP;
	public static int KARMA_RATE_DROP_ITEM;
	public static int KARMA_RATE_DROP_EQUIP;
	public static int KARMA_RATE_DROP_EQUIP_WEAPON;
	
	public static double PET_XP_RATE;
	public static int PET_FOOD_RATE;
	public static double SINEATER_XP_RATE;
	
	public static double RATE_DROP_COMMON_HERBS;
	public static double RATE_DROP_HP_HERBS;
	public static double RATE_DROP_MP_HERBS;
	public static double RATE_DROP_SPECIAL_HERBS;
	
	/** Allow types */
	public static boolean ALLOW_FREIGHT;
	public static boolean ALLOW_WAREHOUSE;
	public static boolean ALLOW_WEAR;
	public static int WEAR_DELAY;
	public static int WEAR_PRICE;
	public static boolean ALLOW_LOTTERY;
	public static boolean ALLOW_RACE;
	public static boolean ALLOW_WATER;
	public static boolean ALLOWFISHING;
	public static boolean ALLOW_BOAT;
	public static boolean ALLOW_CURSED_WEAPONS;
	public static boolean ALLOW_MANOR;
	public static boolean ENABLE_FALLING_DAMAGE;
	
	/** Debug & Dev */
	public static boolean ALT_DEV_NO_SCRIPTS;
	public static boolean ALT_DEV_NO_SPAWNS;
	public static boolean DEBUG;
	public static boolean DEVELOPER;
	public static boolean PACKET_HANDLER_DEBUG;
	
	/** Deadlock Detector */
	public static boolean DEADLOCK_DETECTOR;
	public static int DEADLOCK_CHECK_INTERVAL;
	public static boolean RESTART_ON_DEADLOCK;
	
	/** Logs */
	public static boolean LOG_CHAT;
	public static boolean LOG_ITEMS;
	public static boolean GMAUDIT;
	
	/** Community Board */
	public static boolean ENABLE_COMMUNITY_BOARD;
	public static String BBS_DEFAULT;
	
	/** Geodata */
	public static int COORD_SYNCHRONIZE;
	public static int GEODATA;
	public static boolean FORCE_GEODATA;
	
	public static boolean GEODATA_CELLFINDING;
	public static String PATHFIND_BUFFERS;
	public static double LOW_WEIGHT;
	public static double MEDIUM_WEIGHT;
	public static double HIGH_WEIGHT;
	public static boolean ADVANCED_DIAGONAL_STRATEGY;
	public static double DIAGONAL_WEIGHT;
	public static int MAX_POSTFILTER_PASSES;
	public static boolean DEBUG_PATH;
	
	/** Misc */
	public static boolean L2WALKER_PROTECTION;
	public static boolean AUTODELETE_INVALID_QUEST_DATA;
	public static boolean GAMEGUARD_ENFORCE;
	public static boolean SERVER_NEWS;
	public static int ZONE_TOWN;
	public static boolean DISABLE_TUTORIAL;
	
	// --------------------------------------------------
	// Those "hidden" settings haven't configs to avoid admins to fuck their server
	// You still can experiment changing values here. But don't say I didn't warn you.
	// --------------------------------------------------
	
	/** Threads & Packets size */
	public static int THREAD_P_EFFECTS = 6; // default 6
	public static int THREAD_P_GENERAL = 15; // default 15
	public static int GENERAL_PACKET_THREAD_CORE_SIZE = 4; // default 4
	public static int IO_PACKET_THREAD_CORE_SIZE = 2; // default 2
	public static int GENERAL_THREAD_CORE_SIZE = 4; // default 4
	public static int AI_MAX_THREAD = 10; // default 10
	
	/** Packet information */
	public static boolean COUNT_PACKETS = false; // default false
	public static boolean DUMP_PACKET_COUNTS = false; // default false
	public static int DUMP_INTERVAL_SECONDS = 60; // default 60
	
	/** IA settings */
	public static int MINIMUM_UPDATE_DISTANCE = 50; // default 50
	public static int MINIMUN_UPDATE_TIME = 500; // default 500
	public static int KNOWNLIST_FORGET_DELAY = 10000; // default 10000
	
	/** Time after which a packet is considered as lost */
	public static int PACKET_LIFETIME = 0; // default 0 (unlimited)
	
	/** Reserve Host on LoginServerThread */
	public static boolean RESERVE_HOST_ON_LOGIN = false; // default false
	
	/** MMO settings */
	public static int MMO_SELECTOR_SLEEP_TIME = 20; // default 20
	public static int MMO_MAX_SEND_PER_PASS = 12; // default 12
	public static int MMO_MAX_READ_PER_PASS = 12; // default 12
	public static int MMO_HELPER_BUFFER_COUNT = 20; // default 20
	
	/** Client Packets Queue settings */
	public static int CLIENT_PACKET_QUEUE_SIZE = 14; // default MMO_MAX_READ_PER_PASS + 2
	public static int CLIENT_PACKET_QUEUE_MAX_BURST_SIZE = 13; // default MMO_MAX_READ_PER_PASS + 1
	public static int CLIENT_PACKET_QUEUE_MAX_PACKETS_PER_SECOND = 80; // default 80
	public static int CLIENT_PACKET_QUEUE_MEASURE_INTERVAL = 5; // default 5
	public static int CLIENT_PACKET_QUEUE_MAX_AVERAGE_PACKETS_PER_SECOND = 40; // default 40
	public static int CLIENT_PACKET_QUEUE_MAX_FLOODS_PER_MIN = 2; // default 2
	public static int CLIENT_PACKET_QUEUE_MAX_OVERFLOWS_PER_MIN = 1; // default 1
	public static int CLIENT_PACKET_QUEUE_MAX_UNDERFLOWS_PER_MIN = 1; // default 1
	public static int CLIENT_PACKET_QUEUE_MAX_UNKNOWN_PER_MIN = 5; // default 5
	
	// --------------------------------------------------
	
	/**
	 * This class initializes all global variables for configuration.<br>
	 * If key doesn't appear in properties file, a default value is setting on by this class.
	 */
	public static void load()
	{
		if (Server.serverMode == Server.MODE_GAMESERVER)
		{
			_log.info("Loading flood protectors.");
			FLOOD_PROTECTOR_ROLL_DICE = new FloodProtectorConfig("RollDiceFloodProtector");
			FLOOD_PROTECTOR_HERO_VOICE = new FloodProtectorConfig("HeroVoiceFloodProtector");
			FLOOD_PROTECTOR_SUBCLASS = new FloodProtectorConfig("SubclassFloodProtector");
			FLOOD_PROTECTOR_DROP_ITEM = new FloodProtectorConfig("DropItemFloodProtector");
			FLOOD_PROTECTOR_SERVER_BYPASS = new FloodProtectorConfig("ServerBypassFloodProtector");
			FLOOD_PROTECTOR_MULTISELL = new FloodProtectorConfig("MultiSellFloodProtector");
			FLOOD_PROTECTOR_MANUFACTURE = new FloodProtectorConfig("ManufactureFloodProtector");
			FLOOD_PROTECTOR_MANOR = new FloodProtectorConfig("ManorFloodProtector");
			FLOOD_PROTECTOR_SENDMAIL = new FloodProtectorConfig("SendMailFloodProtector");
			FLOOD_PROTECTOR_CHARACTER_SELECT = new FloodProtectorConfig("CharacterSelectFloodProtector");
			
			_log.info("Loading gameserver configuration files.");
			
			// Clans settings
			ExProperties clans = load(CLANS_FILE);
			ALT_CLAN_JOIN_DAYS = clans.getProperty("DaysBeforeJoinAClan", 5);
			ALT_CLAN_CREATE_DAYS = clans.getProperty("DaysBeforeCreateAClan", 10);
			ALT_MAX_NUM_OF_CLANS_IN_ALLY = clans.getProperty("AltMaxNumOfClansInAlly", 3);
			ALT_CLAN_MEMBERS_FOR_WAR = clans.getProperty("AltClanMembersForWar", 15);
			ALT_CLAN_WAR_PENALTY_WHEN_ENDED = clans.getProperty("AltClanWarPenaltyWhenEnded", 5);
			ALT_CLAN_DISSOLVE_DAYS = clans.getProperty("DaysToPassToDissolveAClan", 7);
			ALT_ALLY_JOIN_DAYS_WHEN_LEAVED = clans.getProperty("DaysBeforeJoinAllyWhenLeaved", 1);
			ALT_ALLY_JOIN_DAYS_WHEN_DISMISSED = clans.getProperty("DaysBeforeJoinAllyWhenDismissed", 1);
			ALT_ACCEPT_CLAN_DAYS_WHEN_DISMISSED = clans.getProperty("DaysBeforeAcceptNewClanWhenDismissed", 1);
			ALT_CREATE_ALLY_DAYS_WHEN_DISSOLVED = clans.getProperty("DaysBeforeCreateNewAllyWhenDissolved", 10);
			ALT_MEMBERS_CAN_WITHDRAW_FROM_CLANWH = clans.getProperty("AltMembersCanWithdrawFromClanWH", false);
			REMOVE_CASTLE_CIRCLETS = clans.getProperty("RemoveCastleCirclets", true);
			
			ALT_MANOR_REFRESH_TIME = clans.getProperty("AltManorRefreshTime", 20);
			ALT_MANOR_REFRESH_MIN = clans.getProperty("AltManorRefreshMin", 0);
			ALT_MANOR_APPROVE_TIME = clans.getProperty("AltManorApproveTime", 6);
			ALT_MANOR_APPROVE_MIN = clans.getProperty("AltManorApproveMin", 0);
			ALT_MANOR_MAINTENANCE_PERIOD = clans.getProperty("AltManorMaintenancePeriod", 360000);
			ALT_MANOR_SAVE_ALL_ACTIONS = clans.getProperty("AltManorSaveAllActions", false);
			ALT_MANOR_SAVE_PERIOD_RATE = clans.getProperty("AltManorSavePeriodRate", 2);
			
			CH_TELE_FEE_RATIO = clans.getProperty("ClanHallTeleportFunctionFeeRatio", 86400000);
			CH_TELE1_FEE = clans.getProperty("ClanHallTeleportFunctionFeeLvl1", 7000);
			CH_TELE2_FEE = clans.getProperty("ClanHallTeleportFunctionFeeLvl2", 14000);
			CH_SUPPORT_FEE_RATIO = clans.getProperty("ClanHallSupportFunctionFeeRatio", 86400000);
			CH_SUPPORT1_FEE = clans.getProperty("ClanHallSupportFeeLvl1", 17500);
			CH_SUPPORT2_FEE = clans.getProperty("ClanHallSupportFeeLvl2", 35000);
			CH_SUPPORT3_FEE = clans.getProperty("ClanHallSupportFeeLvl3", 49000);
			CH_SUPPORT4_FEE = clans.getProperty("ClanHallSupportFeeLvl4", 77000);
			CH_SUPPORT5_FEE = clans.getProperty("ClanHallSupportFeeLvl5", 147000);
			CH_SUPPORT6_FEE = clans.getProperty("ClanHallSupportFeeLvl6", 252000);
			CH_SUPPORT7_FEE = clans.getProperty("ClanHallSupportFeeLvl7", 259000);
			CH_SUPPORT8_FEE = clans.getProperty("ClanHallSupportFeeLvl8", 364000);
			CH_MPREG_FEE_RATIO = clans.getProperty("ClanHallMpRegenerationFunctionFeeRatio", 86400000);
			CH_MPREG1_FEE = clans.getProperty("ClanHallMpRegenerationFeeLvl1", 14000);
			CH_MPREG2_FEE = clans.getProperty("ClanHallMpRegenerationFeeLvl2", 26250);
			CH_MPREG3_FEE = clans.getProperty("ClanHallMpRegenerationFeeLvl3", 45500);
			CH_MPREG4_FEE = clans.getProperty("ClanHallMpRegenerationFeeLvl4", 96250);
			CH_MPREG5_FEE = clans.getProperty("ClanHallMpRegenerationFeeLvl5", 140000);
			CH_HPREG_FEE_RATIO = clans.getProperty("ClanHallHpRegenerationFunctionFeeRatio", 86400000);
			CH_HPREG1_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl1", 4900);
			CH_HPREG2_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl2", 5600);
			CH_HPREG3_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl3", 7000);
			CH_HPREG4_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl4", 8166);
			CH_HPREG5_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl5", 10500);
			CH_HPREG6_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl6", 12250);
			CH_HPREG7_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl7", 14000);
			CH_HPREG8_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl8", 15750);
			CH_HPREG9_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl9", 17500);
			CH_HPREG10_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl10", 22750);
			CH_HPREG11_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl11", 26250);
			CH_HPREG12_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl12", 29750);
			CH_HPREG13_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl13", 36166);
			CH_EXPREG_FEE_RATIO = clans.getProperty("ClanHallExpRegenerationFunctionFeeRatio", 86400000);
			CH_EXPREG1_FEE = clans.getProperty("ClanHallExpRegenerationFeeLvl1", 21000);
			CH_EXPREG2_FEE = clans.getProperty("ClanHallExpRegenerationFeeLvl2", 42000);
			CH_EXPREG3_FEE = clans.getProperty("ClanHallExpRegenerationFeeLvl3", 63000);
			CH_EXPREG4_FEE = clans.getProperty("ClanHallExpRegenerationFeeLvl4", 105000);
			CH_EXPREG5_FEE = clans.getProperty("ClanHallExpRegenerationFeeLvl5", 147000);
			CH_EXPREG6_FEE = clans.getProperty("ClanHallExpRegenerationFeeLvl6", 163331);
			CH_EXPREG7_FEE = clans.getProperty("ClanHallExpRegenerationFeeLvl7", 210000);
			CH_ITEM_FEE_RATIO = clans.getProperty("ClanHallItemCreationFunctionFeeRatio", 86400000);
			CH_ITEM1_FEE = clans.getProperty("ClanHallItemCreationFunctionFeeLvl1", 210000);
			CH_ITEM2_FEE = clans.getProperty("ClanHallItemCreationFunctionFeeLvl2", 490000);
			CH_ITEM3_FEE = clans.getProperty("ClanHallItemCreationFunctionFeeLvl3", 980000);
			CH_CURTAIN_FEE_RATIO = clans.getProperty("ClanHallCurtainFunctionFeeRatio", 86400000);
			CH_CURTAIN1_FEE = clans.getProperty("ClanHallCurtainFunctionFeeLvl1", 2002);
			CH_CURTAIN2_FEE = clans.getProperty("ClanHallCurtainFunctionFeeLvl2", 2625);
			CH_FRONT_FEE_RATIO = clans.getProperty("ClanHallFrontPlatformFunctionFeeRatio", 86400000);
			CH_FRONT1_FEE = clans.getProperty("ClanHallFrontPlatformFunctionFeeLvl1", 3031);
			CH_FRONT2_FEE = clans.getProperty("ClanHallFrontPlatformFunctionFeeLvl2", 9331);
			
			// Events config
			ExProperties events = load(EVENTS_FILE);
			ALT_OLY_START_TIME = events.getProperty("AltOlyStartTime", 18);
			ALT_OLY_MIN = events.getProperty("AltOlyMin", 0);
			ALT_OLY_CPERIOD = events.getProperty("AltOlyCPeriod", 21600000);
			ALT_OLY_BATTLE = events.getProperty("AltOlyBattle", 180000);
			ALT_OLY_WPERIOD = events.getProperty("AltOlyWPeriod", 604800000);
			ALT_OLY_VPERIOD = events.getProperty("AltOlyVPeriod", 86400000);
			ALT_OLY_WAIT_TIME = events.getProperty("AltOlyWaitTime", 30);
			ALT_OLY_WAIT_BATTLE = events.getProperty("AltOlyWaitBattle", 60);
			ALT_OLY_WAIT_END = events.getProperty("AltOlyWaitEnd", 40);
			ALT_OLY_START_POINTS = events.getProperty("AltOlyStartPoints", 18);
			ALT_OLY_WEEKLY_POINTS = events.getProperty("AltOlyWeeklyPoints", 3);
			ALT_OLY_MIN_MATCHES = events.getProperty("AltOlyMinMatchesToBeClassed", 5);
			ALT_OLY_CLASSED = events.getProperty("AltOlyClassedParticipants", 5);
			ALT_OLY_NONCLASSED = events.getProperty("AltOlyNonClassedParticipants", 9);
			ALT_OLY_CLASSED_REWARD = parseItemsList(events.getProperty("AltOlyClassedReward", "6651,50"));
			ALT_OLY_NONCLASSED_REWARD = parseItemsList(events.getProperty("AltOlyNonClassedReward", "6651,30"));
			ALT_OLY_COMP_RITEM = events.getProperty("AltOlyCompRewItem", 6651);
			ALT_OLY_GP_PER_POINT = events.getProperty("AltOlyGPPerPoint", 1000);
			ALT_OLY_HERO_POINTS = events.getProperty("AltOlyHeroPoints", 300);
			ALT_OLY_RANK1_POINTS = events.getProperty("AltOlyRank1Points", 100);
			ALT_OLY_RANK2_POINTS = events.getProperty("AltOlyRank2Points", 75);
			ALT_OLY_RANK3_POINTS = events.getProperty("AltOlyRank3Points", 55);
			ALT_OLY_RANK4_POINTS = events.getProperty("AltOlyRank4Points", 40);
			ALT_OLY_RANK5_POINTS = events.getProperty("AltOlyRank5Points", 30);
			ALT_OLY_MAX_POINTS = events.getProperty("AltOlyMaxPoints", 10);
			ALT_OLY_DIVIDER_CLASSED = events.getProperty("AltOlyDividerClassed", 3);
			ALT_OLY_DIVIDER_NON_CLASSED = events.getProperty("AltOlyDividerNonClassed", 3);
			ALT_OLY_ANNOUNCE_GAMES = events.getProperty("AltOlyAnnounceGames", true);
			
			ALT_GAME_REQUIRE_CLAN_CASTLE = events.getProperty("AltRequireClanCastle", false);
			ALT_GAME_CASTLE_DAWN = events.getProperty("AltCastleForDawn", true);
			ALT_GAME_CASTLE_DUSK = events.getProperty("AltCastleForDusk", true);
			ALT_FESTIVAL_MIN_PLAYER = events.getProperty("AltFestivalMinPlayer", 5);
			ALT_MAXIMUM_PLAYER_CONTRIB = events.getProperty("AltMaxPlayerContrib", 1000000);
			ALT_FESTIVAL_MANAGER_START = events.getProperty("AltFestivalManagerStart", 120000);
			ALT_FESTIVAL_LENGTH = events.getProperty("AltFestivalLength", 1080000);
			ALT_FESTIVAL_CYCLE_LENGTH = events.getProperty("AltFestivalCycleLength", 2280000);
			ALT_FESTIVAL_FIRST_SPAWN = events.getProperty("AltFestivalFirstSpawn", 120000);
			ALT_FESTIVAL_FIRST_SWARM = events.getProperty("AltFestivalFirstSwarm", 300000);
			ALT_FESTIVAL_SECOND_SPAWN = events.getProperty("AltFestivalSecondSpawn", 540000);
			ALT_FESTIVAL_SECOND_SWARM = events.getProperty("AltFestivalSecondSwarm", 720000);
			ALT_FESTIVAL_CHEST_SPAWN = events.getProperty("AltFestivalChestSpawn", 900000);
			ALT_SEVENSIGNS_LAZY_UPDATE = events.getProperty("AltSevenSignsLazyUpdate", true);
			
			FS_TIME_ATTACK = events.getProperty("TimeOfAttack", 50);
			FS_TIME_COOLDOWN = events.getProperty("TimeOfCoolDown", 5);
			FS_TIME_ENTRY = events.getProperty("TimeOfEntry", 3);
			FS_TIME_WARMUP = events.getProperty("TimeOfWarmUp", 2);
			FS_PARTY_MEMBER_COUNT = events.getProperty("NumberOfNecessaryPartyMembers", 4);
			
			RIFT_MIN_PARTY_SIZE = events.getProperty("RiftMinPartySize", 2);
			RIFT_MAX_JUMPS = events.getProperty("MaxRiftJumps", 4);
			RIFT_SPAWN_DELAY = events.getProperty("RiftSpawnDelay", 10000);
			RIFT_AUTO_JUMPS_TIME_MIN = events.getProperty("AutoJumpsDelayMin", 480);
			RIFT_AUTO_JUMPS_TIME_MAX = events.getProperty("AutoJumpsDelayMax", 600);
			RIFT_ENTER_COST_RECRUIT = events.getProperty("RecruitCost", 18);
			RIFT_ENTER_COST_SOLDIER = events.getProperty("SoldierCost", 21);
			RIFT_ENTER_COST_OFFICER = events.getProperty("OfficerCost", 24);
			RIFT_ENTER_COST_CAPTAIN = events.getProperty("CaptainCost", 27);
			RIFT_ENTER_COST_COMMANDER = events.getProperty("CommanderCost", 30);
			RIFT_ENTER_COST_HERO = events.getProperty("HeroCost", 33);
			RIFT_BOSS_ROOM_TIME_MUTIPLY = events.getProperty("BossRoomTimeMultiply", 1.);
			
			ALLOW_WEDDING = events.getProperty("AllowWedding", false);
			WEDDING_PRICE = events.getProperty("WeddingPrice", 1000000);
			WEDDING_SAMESEX = events.getProperty("WeddingAllowSameSex", false);
			WEDDING_FORMALWEAR = events.getProperty("WeddingFormalWear", true);
			
			ALT_LOTTERY_PRIZE = events.getProperty("AltLotteryPrize", 50000);
			ALT_LOTTERY_TICKET_PRICE = events.getProperty("AltLotteryTicketPrice", 2000);
			ALT_LOTTERY_5_NUMBER_RATE = events.getProperty("AltLottery5NumberRate", 0.6);
			ALT_LOTTERY_4_NUMBER_RATE = events.getProperty("AltLottery4NumberRate", 0.2);
			ALT_LOTTERY_3_NUMBER_RATE = events.getProperty("AltLottery3NumberRate", 0.2);
			ALT_LOTTERY_2_AND_1_NUMBER_PRIZE = events.getProperty("AltLottery2and1NumberPrize", 200);
			
			ALT_FISH_CHAMPIONSHIP_ENABLED = events.getProperty("AltFishChampionshipEnabled", true);
			ALT_FISH_CHAMPIONSHIP_REWARD_ITEM = events.getProperty("AltFishChampionshipRewardItemId", 57);
			ALT_FISH_CHAMPIONSHIP_REWARD_1 = events.getProperty("AltFishChampionshipReward1", 800000);
			ALT_FISH_CHAMPIONSHIP_REWARD_2 = events.getProperty("AltFishChampionshipReward2", 500000);
			ALT_FISH_CHAMPIONSHIP_REWARD_3 = events.getProperty("AltFishChampionshipReward3", 300000);
			ALT_FISH_CHAMPIONSHIP_REWARD_4 = events.getProperty("AltFishChampionshipReward4", 200000);
			ALT_FISH_CHAMPIONSHIP_REWARD_5 = events.getProperty("AltFishChampionshipReward5", 100000);
			
			// FloodProtector
			ExProperties security = load(FLOOD_PROTECTOR_FILE);
			loadFloodProtectorConfig(security, FLOOD_PROTECTOR_ROLL_DICE, "RollDice", "42");
			loadFloodProtectorConfig(security, FLOOD_PROTECTOR_HERO_VOICE, "HeroVoice", "100");
			loadFloodProtectorConfig(security, FLOOD_PROTECTOR_SUBCLASS, "Subclass", "20");
			loadFloodProtectorConfig(security, FLOOD_PROTECTOR_DROP_ITEM, "DropItem", "10");
			loadFloodProtectorConfig(security, FLOOD_PROTECTOR_SERVER_BYPASS, "ServerBypass", "5");
			loadFloodProtectorConfig(security, FLOOD_PROTECTOR_MULTISELL, "MultiSell", "1");
			loadFloodProtectorConfig(security, FLOOD_PROTECTOR_MANUFACTURE, "Manufacture", "3");
			loadFloodProtectorConfig(security, FLOOD_PROTECTOR_MANOR, "Manor", "30");
			loadFloodProtectorConfig(security, FLOOD_PROTECTOR_SENDMAIL, "SendMail", "100");
			loadFloodProtectorConfig(security, FLOOD_PROTECTOR_CHARACTER_SELECT, "CharacterSelect", "30");
			
			// HexID
			ExProperties hexid = load(HEXID_FILE);
			SERVER_ID = Integer.parseInt(hexid.getProperty("ServerID"));
			HEX_ID = new BigInteger(hexid.getProperty("HexID"), 16).toByteArray();
			
			// NPCs / Monsters
			ExProperties npcs = load(NPCS_FILE);
			CHAMPION_FREQUENCY = npcs.getProperty("ChampionFrequency", 0);
			CHAMP_MIN_LVL = npcs.getProperty("ChampionMinLevel", 20);
			CHAMP_MAX_LVL = npcs.getProperty("ChampionMaxLevel", 70);
			CHAMPION_HP = npcs.getProperty("ChampionHp", 8);
			CHAMPION_HP_REGEN = npcs.getProperty("ChampionHpRegen", 1.);
			CHAMPION_REWARDS = npcs.getProperty("ChampionRewards", 8);
			CHAMPION_ADENAS_REWARDS = npcs.getProperty("ChampionAdenasRewards", 1);
			CHAMPION_ATK = npcs.getProperty("ChampionAtk", 1.);
			CHAMPION_SPD_ATK = npcs.getProperty("ChampionSpdAtk", 1.);
			CHAMPION_REWARD = npcs.getProperty("ChampionRewardItem", 0);
			CHAMPION_REWARD_ID = npcs.getProperty("ChampionRewardItemID", 6393);
			CHAMPION_REWARD_QTY = npcs.getProperty("ChampionRewardItemQty", 1);
			
			ALLOW_CLASS_MASTERS = npcs.getProperty("AllowClassMasters", false);
			ALLOW_ENTIRE_TREE = npcs.getProperty("AllowEntireTree", false);
			if (ALLOW_CLASS_MASTERS)
				CLASS_MASTER_SETTINGS = new ClassMasterSettings(npcs.getProperty("ConfigClassMaster"));
			
			ALT_GAME_FREE_TELEPORT = npcs.getProperty("AltFreeTeleporting", false);
			ANNOUNCE_MAMMON_SPAWN = npcs.getProperty("AnnounceMammonSpawn", true);
			ALT_MOB_AGRO_IN_PEACEZONE = npcs.getProperty("AltMobAgroInPeaceZone", true);
			SHOW_NPC_LVL = npcs.getProperty("ShowNpcLevel", false);
			SHOW_NPC_CREST = npcs.getProperty("ShowNpcCrest", false);
			SHOW_SUMMON_CREST = npcs.getProperty("ShowSummonCrest", false);
			
			WYVERN_ALLOW_UPGRADER = npcs.getProperty("AllowWyvernUpgrader", true);
			WYVERN_REQUIRED_LEVEL = npcs.getProperty("RequiredStriderLevel", 55);
			WYVERN_REQUIRED_CRYSTALS = npcs.getProperty("RequiredCrystalsNumber", 10);
			
			RAID_HP_REGEN_MULTIPLIER = npcs.getProperty("RaidHpRegenMultiplier", 1.);
			RAID_MP_REGEN_MULTIPLIER = npcs.getProperty("RaidMpRegenMultiplier", 1.);
			RAID_DEFENCE_MULTIPLIER = npcs.getProperty("RaidDefenceMultiplier", 1.);
			RAID_MINION_RESPAWN_TIMER = npcs.getProperty("RaidMinionRespawnTime", 300000);
			
			RAID_DISABLE_CURSE = npcs.getProperty("DisableRaidCurse", false);
			RAID_CHAOS_TIME = npcs.getProperty("RaidChaosTime", 30);
			GRAND_CHAOS_TIME = npcs.getProperty("GrandChaosTime", 30);
			MINION_CHAOS_TIME = npcs.getProperty("MinionChaosTime", 30);
			
			SPAWN_INTERVAL_AQ = npcs.getProperty("AntQueenSpawnInterval", 36);
			RANDOM_SPAWN_TIME_AQ = npcs.getProperty("AntQueenRandomSpawn", 17);
			
			SPAWN_INTERVAL_ANTHARAS = npcs.getProperty("AntharasSpawnInterval", 264);
			RANDOM_SPAWN_TIME_ANTHARAS = npcs.getProperty("AntharasRandomSpawn", 72);
			WAIT_TIME_ANTHARAS = npcs.getProperty("AntharasWaitTime", 30) * 60000;
			
			SPAWN_INTERVAL_BAIUM = npcs.getProperty("BaiumSpawnInterval", 168);
			RANDOM_SPAWN_TIME_BAIUM = npcs.getProperty("BaiumRandomSpawn", 48);
			
			SPAWN_INTERVAL_CORE = npcs.getProperty("CoreSpawnInterval", 60);
			RANDOM_SPAWN_TIME_CORE = npcs.getProperty("CoreRandomSpawn", 23);
			
			SPAWN_INTERVAL_FRINTEZZA = npcs.getProperty("FrintezzaSpawnInterval", 48);
			RANDOM_SPAWN_TIME_FRINTEZZA = npcs.getProperty("FrintezzaRandomSpawn", 8);
			
			SPAWN_INTERVAL_ORFEN = npcs.getProperty("OrfenSpawnInterval", 48);
			RANDOM_SPAWN_TIME_ORFEN = npcs.getProperty("OrfenRandomSpawn", 20);
			
			SPAWN_INTERVAL_SAILREN = npcs.getProperty("SailrenSpawnInterval", 36);
			RANDOM_SPAWN_TIME_SAILREN = npcs.getProperty("SailrenRandomSpawn", 24);
			WAIT_TIME_SAILREN = npcs.getProperty("SailrenWaitTime", 5) * 60000;
			
			SPAWN_INTERVAL_VALAKAS = npcs.getProperty("ValakasSpawnInterval", 264);
			RANDOM_SPAWN_TIME_VALAKAS = npcs.getProperty("ValakasRandomSpawn", 72);
			WAIT_TIME_VALAKAS = npcs.getProperty("ValakasWaitTime", 30) * 60000;
			
			SPAWN_INTERVAL_ZAKEN = npcs.getProperty("ZakenSpawnInterval", 60);
			RANDOM_SPAWN_TIME_ZAKEN = npcs.getProperty("ZakenRandomSpawn", 20);
			
			GUARD_ATTACK_AGGRO_MOB = npcs.getProperty("GuardAttackAggroMob", false);
			MAX_DRIFT_RANGE = npcs.getProperty("MaxDriftRange", 300);
			KNOWNLIST_UPDATE_INTERVAL = npcs.getProperty("KnownListUpdateInterval", 1250);
			MIN_NPC_ANIMATION = npcs.getProperty("MinNPCAnimation", 20);
			MAX_NPC_ANIMATION = npcs.getProperty("MaxNPCAnimation", 40);
			MIN_MONSTER_ANIMATION = npcs.getProperty("MinMonsterAnimation", 10);
			MAX_MONSTER_ANIMATION = npcs.getProperty("MaxMonsterAnimation", 40);
			
			GRIDS_ALWAYS_ON = npcs.getProperty("GridsAlwaysOn", false);
			GRID_NEIGHBOR_TURNON_TIME = npcs.getProperty("GridNeighborTurnOnTime", 1);
			GRID_NEIGHBOR_TURNOFF_TIME = npcs.getProperty("GridNeighborTurnOffTime", 90);
			
			// players
			ExProperties players = load(PLAYERS_FILE);
			STARTING_ADENA = players.getProperty("StartingAdena", 100);
			EFFECT_CANCELING = players.getProperty("CancelLesserEffect", true);
			HP_REGEN_MULTIPLIER = players.getProperty("HpRegenMultiplier", 1.);
			MP_REGEN_MULTIPLIER = players.getProperty("MpRegenMultiplier", 1.);
			CP_REGEN_MULTIPLIER = players.getProperty("CpRegenMultiplier", 1.);
			PLAYER_SPAWN_PROTECTION = players.getProperty("PlayerSpawnProtection", 0);
			PLAYER_FAKEDEATH_UP_PROTECTION = players.getProperty("PlayerFakeDeathUpProtection", 0);
			RESPAWN_RESTORE_HP = players.getProperty("RespawnRestoreHP", 0.7);
			MAX_PVTSTORE_SLOTS_DWARF = players.getProperty("MaxPvtStoreSlotsDwarf", 5);
			MAX_PVTSTORE_SLOTS_OTHER = players.getProperty("MaxPvtStoreSlotsOther", 4);
			DEEPBLUE_DROP_RULES = players.getProperty("UseDeepBlueDropRules", true);
			ALT_GAME_DELEVEL = players.getProperty("Delevel", true);
			DEATH_PENALTY_CHANCE = players.getProperty("DeathPenaltyChance", 20);
			
			INVENTORY_MAXIMUM_NO_DWARF = players.getProperty("MaximumSlotsForNoDwarf", 80);
			INVENTORY_MAXIMUM_DWARF = players.getProperty("MaximumSlotsForDwarf", 100);
			INVENTORY_MAXIMUM_QUEST_ITEMS = players.getProperty("MaximumSlotsForQuestItems", 100);
			INVENTORY_MAXIMUM_PET = players.getProperty("MaximumSlotsForPet", 12);
			MAX_ITEM_IN_PACKET = Math.max(INVENTORY_MAXIMUM_NO_DWARF, INVENTORY_MAXIMUM_DWARF);
			ALT_WEIGHT_LIMIT = players.getProperty("AltWeightLimit", 1);
			WAREHOUSE_SLOTS_NO_DWARF = players.getProperty("MaximumWarehouseSlotsForNoDwarf", 100);
			WAREHOUSE_SLOTS_DWARF = players.getProperty("MaximumWarehouseSlotsForDwarf", 120);
			WAREHOUSE_SLOTS_CLAN = players.getProperty("MaximumWarehouseSlotsForClan", 150);
			FREIGHT_SLOTS = players.getProperty("MaximumFreightSlots", 20);
			ALT_GAME_FREIGHTS = players.getProperty("AltGameFreights", false);
			ALT_GAME_FREIGHT_PRICE = players.getProperty("AltGameFreightPrice", 1000);
			
			ENCHANT_CHANCE_WEAPON_MAGIC = players.getProperty("EnchantChanceMagicWeapon", 0.4);
			ENCHANT_CHANCE_WEAPON_MAGIC_15PLUS = players.getProperty("EnchantChanceMagicWeapon15Plus", 0.2);
			ENCHANT_CHANCE_WEAPON_NONMAGIC = players.getProperty("EnchantChanceNonMagicWeapon", 0.7);
			ENCHANT_CHANCE_WEAPON_NONMAGIC_15PLUS = players.getProperty("EnchantChanceNonMagicWeapon15Plus", 0.35);
			ENCHANT_CHANCE_ARMOR = players.getProperty("EnchantChanceArmor", 0.66);
			ENCHANT_MAX_WEAPON = players.getProperty("EnchantMaxWeapon", 0);
			ENCHANT_MAX_ARMOR = players.getProperty("EnchantMaxArmor", 0);
			ENCHANT_SAFE_MAX = players.getProperty("EnchantSafeMax", 3);
			ENCHANT_SAFE_MAX_FULL = players.getProperty("EnchantSafeMaxFull", 4);
			
			AUGMENTATION_NG_SKILL_CHANCE = players.getProperty("AugmentationNGSkillChance", 15);
			AUGMENTATION_NG_GLOW_CHANCE = players.getProperty("AugmentationNGGlowChance", 0);
			AUGMENTATION_MID_SKILL_CHANCE = players.getProperty("AugmentationMidSkillChance", 30);
			AUGMENTATION_MID_GLOW_CHANCE = players.getProperty("AugmentationMidGlowChance", 40);
			AUGMENTATION_HIGH_SKILL_CHANCE = players.getProperty("AugmentationHighSkillChance", 45);
			AUGMENTATION_HIGH_GLOW_CHANCE = players.getProperty("AugmentationHighGlowChance", 70);
			AUGMENTATION_TOP_SKILL_CHANCE = players.getProperty("AugmentationTopSkillChance", 60);
			AUGMENTATION_TOP_GLOW_CHANCE = players.getProperty("AugmentationTopGlowChance", 100);
			AUGMENTATION_BASESTAT_CHANCE = players.getProperty("AugmentationBaseStatChance", 1);
			
			KARMA_PLAYER_CAN_BE_KILLED_IN_PZ = players.getProperty("KarmaPlayerCanBeKilledInPeaceZone", false);
			KARMA_PLAYER_CAN_SHOP = players.getProperty("KarmaPlayerCanShop", true);
			KARMA_PLAYER_CAN_USE_GK = players.getProperty("KarmaPlayerCanUseGK", false);
			KARMA_PLAYER_CAN_TELEPORT = players.getProperty("KarmaPlayerCanTeleport", true);
			KARMA_PLAYER_CAN_TRADE = players.getProperty("KarmaPlayerCanTrade", true);
			KARMA_PLAYER_CAN_USE_WH = players.getProperty("KarmaPlayerCanUseWareHouse", true);
			KARMA_DROP_GM = players.getProperty("CanGMDropEquipment", false);
			KARMA_AWARD_PK_KILL = players.getProperty("AwardPKKillPVPPoint", true);
			KARMA_PK_LIMIT = players.getProperty("MinimumPKRequiredToDrop", 5);
			KARMA_NONDROPPABLE_PET_ITEMS = players.getProperty("ListOfPetItems", "2375,3500,3501,3502,4422,4423,4424,4425,6648,6649,6650");
			KARMA_NONDROPPABLE_ITEMS = players.getProperty("ListOfNonDroppableItemsForPK", "1147,425,1146,461,10,2368,7,6,2370,2369");
			
			String[] array = KARMA_NONDROPPABLE_PET_ITEMS.split(",");
			KARMA_LIST_NONDROPPABLE_PET_ITEMS = new int[array.length];
			
			for (int i = 0; i < array.length; i++)
				KARMA_LIST_NONDROPPABLE_PET_ITEMS[i] = Integer.parseInt(array[i]);
			
			array = KARMA_NONDROPPABLE_ITEMS.split(",");
			KARMA_LIST_NONDROPPABLE_ITEMS = new int[array.length];
			
			for (int i = 0; i < array.length; i++)
				KARMA_LIST_NONDROPPABLE_ITEMS[i] = Integer.parseInt(array[i]);
			
			// sorting so binarySearch can be used later
			Arrays.sort(KARMA_LIST_NONDROPPABLE_PET_ITEMS);
			Arrays.sort(KARMA_LIST_NONDROPPABLE_ITEMS);
			
			PVP_NORMAL_TIME = players.getProperty("PvPVsNormalTime", 15000);
			PVP_PVP_TIME = players.getProperty("PvPVsPvPTime", 30000);
			
			PARTY_XP_CUTOFF_METHOD = players.getProperty("PartyXpCutoffMethod", "level");
			PARTY_XP_CUTOFF_PERCENT = players.getProperty("PartyXpCutoffPercent", 3.);
			PARTY_XP_CUTOFF_LEVEL = players.getProperty("PartyXpCutoffLevel", 20);
			ALT_PARTY_RANGE = players.getProperty("AltPartyRange", 1600);
			ALT_PARTY_RANGE2 = players.getProperty("AltPartyRange2", 1400);
			
			EVERYBODY_HAS_ADMIN_RIGHTS = players.getProperty("EverybodyHasAdminRights", false);
			MASTERACCESS_LEVEL = players.getProperty("MasterAccessLevel", 127);
			MASTERACCESS_NAME_COLOR = Integer.decode(StringUtil.concat("0x", players.getProperty("MasterNameColor", "00FF00")));
			MASTERACCESS_TITLE_COLOR = Integer.decode(StringUtil.concat("0x", players.getProperty("MasterTitleColor", "00FF00")));
			GM_HERO_AURA = players.getProperty("GMHeroAura", false);
			GM_STARTUP_INVULNERABLE = players.getProperty("GMStartupInvulnerable", true);
			GM_STARTUP_INVISIBLE = players.getProperty("GMStartupInvisible", true);
			GM_STARTUP_SILENCE = players.getProperty("GMStartupSilence", true);
			GM_STARTUP_AUTO_LIST = players.getProperty("GMStartupAutoList", true);
			
			PETITIONING_ALLOWED = players.getProperty("PetitioningAllowed", true);
			MAX_PETITIONS_PER_PLAYER = players.getProperty("MaxPetitionsPerPlayer", 5);
			MAX_PETITIONS_PENDING = players.getProperty("MaxPetitionsPending", 25);
			
			IS_CRAFTING_ENABLED = players.getProperty("CraftingEnabled", true);
			DWARF_RECIPE_LIMIT = players.getProperty("DwarfRecipeLimit", 50);
			COMMON_RECIPE_LIMIT = players.getProperty("CommonRecipeLimit", 50);
			ALT_BLACKSMITH_USE_RECIPES = players.getProperty("AltBlacksmithUseRecipes", true);
			
			AUTO_LEARN_SKILLS = players.getProperty("AutoLearnSkills", false);
			ALT_GAME_MAGICFAILURES = players.getProperty("MagicFailures", true);
			ALT_GAME_SHIELD_BLOCKS = players.getProperty("AltShieldBlocks", false);
			ALT_PERFECT_SHLD_BLOCK = players.getProperty("AltPerfectShieldBlockRate", 10);
			LIFE_CRYSTAL_NEEDED = players.getProperty("LifeCrystalNeeded", true);
			SP_BOOK_NEEDED = players.getProperty("SpBookNeeded", true);
			ES_SP_BOOK_NEEDED = players.getProperty("EnchantSkillSpBookNeeded", true);
			DIVINE_SP_BOOK_NEEDED = players.getProperty("DivineInspirationSpBookNeeded", true);
			ALT_GAME_SUBCLASS_WITHOUT_QUESTS = players.getProperty("AltSubClassWithoutQuests", false);
			
			BUFFS_MAX_AMOUNT = players.getProperty("MaxBuffsAmount", 20);
			STORE_SKILL_COOLTIME = players.getProperty("StoreSkillCooltime", true);
			
			// server
			ExProperties server = load(SERVER_FILE);
			
			GAMESERVER_HOSTNAME = server.getProperty("GameserverHostname");
			PORT_GAME = server.getProperty("GameserverPort", 7777);
			
			EXTERNAL_HOSTNAME = server.getProperty("ExternalHostname", "*");
			INTERNAL_HOSTNAME = server.getProperty("InternalHostname", "*");
			
			GAME_SERVER_LOGIN_PORT = server.getProperty("LoginPort", 9014);
			GAME_SERVER_LOGIN_HOST = server.getProperty("LoginHost", "127.0.0.1");
			
			REQUEST_ID = server.getProperty("RequestServerID", 0);
			ACCEPT_ALTERNATE_ID = server.getProperty("AcceptAlternateID", true);
			
			DATABASE_URL = server.getProperty("URL", "jdbc:mysql://localhost/acis");
			DATABASE_LOGIN = server.getProperty("Login", "root");
			DATABASE_PASSWORD = server.getProperty("Password", "");
			DATABASE_MAX_CONNECTIONS = server.getProperty("MaximumDbConnections", 10);
			DATABASE_MAX_IDLE_TIME = server.getProperty("MaximumDbIdleTime", 0);
			
			SERVER_LIST_BRACKET = server.getProperty("ServerListBrackets", false);
			SERVER_LIST_CLOCK = server.getProperty("ServerListClock", false);
			SERVER_GMONLY = server.getProperty("ServerGMOnly", false);
			TEST_SERVER = server.getProperty("TestServer", false);
			SERVER_LIST_TESTSERVER = server.getProperty("TestServer", false);
			
			DELETE_DAYS = server.getProperty("DeleteCharAfterDays", 7);
			MAXIMUM_ONLINE_USERS = server.getProperty("MaximumOnlineUsers", 100);
			MIN_PROTOCOL_REVISION = server.getProperty("MinProtocolRevision", 730);
			MAX_PROTOCOL_REVISION = server.getProperty("MaxProtocolRevision", 746);
			if (MIN_PROTOCOL_REVISION > MAX_PROTOCOL_REVISION)
				throw new Error("MinProtocolRevision is bigger than MaxProtocolRevision in server.properties.");
			
			JAIL_IS_PVP = server.getProperty("JailIsPvp", true);
			DEFAULT_PUNISH = server.getProperty("DefaultPunish", 2);
			DEFAULT_PUNISH_PARAM = server.getProperty("DefaultPunishParam", 0);
			
			AUTO_LOOT = server.getProperty("AutoLoot", false);
			AUTO_LOOT_HERBS = server.getProperty("AutoLootHerbs", false);
			AUTO_LOOT_RAID = server.getProperty("AutoLootRaid", false);
			
			ALLOW_DISCARDITEM = server.getProperty("AllowDiscardItem", true);
			MULTIPLE_ITEM_DROP = server.getProperty("MultipleItemDrop", true);
			AUTODESTROY_ITEM_AFTER = server.getProperty("AutoDestroyDroppedItemAfter", 0);
			HERB_AUTO_DESTROY_TIME = server.getProperty("AutoDestroyHerbTime", 15) * 1000;
			PROTECTED_ITEMS = server.getProperty("ListOfProtectedItems");
			
			LIST_PROTECTED_ITEMS = new ArrayList<>();
			for (String id : PROTECTED_ITEMS.split(","))
				LIST_PROTECTED_ITEMS.add(Integer.parseInt(id));
			
			DESTROY_DROPPED_PLAYER_ITEM = server.getProperty("DestroyPlayerDroppedItem", false);
			DESTROY_EQUIPABLE_PLAYER_ITEM = server.getProperty("DestroyEquipableItem", false);
			SAVE_DROPPED_ITEM = server.getProperty("SaveDroppedItem", false);
			EMPTY_DROPPED_ITEM_TABLE_AFTER_LOAD = server.getProperty("EmptyDroppedItemTableAfterLoad", false);
			SAVE_DROPPED_ITEM_INTERVAL = server.getProperty("SaveDroppedItemInterval", 0) * 60000;
			CLEAR_DROPPED_ITEM_TABLE = server.getProperty("ClearDroppedItemTable", false);
			
			RATE_XP = server.getProperty("RateXp", 1.);
			RATE_SP = server.getProperty("RateSp", 1.);
			RATE_PARTY_XP = server.getProperty("RatePartyXp", 1.);
			RATE_PARTY_SP = server.getProperty("RatePartySp", 1.);
			RATE_DROP_ADENA = server.getProperty("RateDropAdena", 1.);
			RATE_CONSUMABLE_COST = server.getProperty("RateConsumableCost", 1.);
			RATE_DROP_ITEMS = server.getProperty("RateDropItems", 1.);
			RATE_DROP_ITEMS_BY_RAID = server.getProperty("RateRaidDropItems", 1.);
			RATE_DROP_SPOIL = server.getProperty("RateDropSpoil", 1.);
			RATE_DROP_MANOR = server.getProperty("RateDropManor", 1);
			RATE_QUEST_DROP = server.getProperty("RateQuestDrop", 1.);
			RATE_QUEST_REWARD = server.getProperty("RateQuestReward", 1.);
			RATE_QUEST_REWARD_XP = server.getProperty("RateQuestRewardXP", 1.);
			RATE_QUEST_REWARD_SP = server.getProperty("RateQuestRewardSP", 1.);
			RATE_QUEST_REWARD_ADENA = server.getProperty("RateQuestRewardAdena", 1.);
			RATE_KARMA_EXP_LOST = server.getProperty("RateKarmaExpLost", 1.);
			RATE_SIEGE_GUARDS_PRICE = server.getProperty("RateSiegeGuardsPrice", 1.);
			RATE_DROP_COMMON_HERBS = server.getProperty("RateCommonHerbs", 1.);
			RATE_DROP_HP_HERBS = server.getProperty("RateHpHerbs", 1.);
			RATE_DROP_MP_HERBS = server.getProperty("RateMpHerbs", 1.);
			RATE_DROP_SPECIAL_HERBS = server.getProperty("RateSpecialHerbs", 1.);
			PLAYER_DROP_LIMIT = server.getProperty("PlayerDropLimit", 3);
			PLAYER_RATE_DROP = server.getProperty("PlayerRateDrop", 5);
			PLAYER_RATE_DROP_ITEM = server.getProperty("PlayerRateDropItem", 70);
			PLAYER_RATE_DROP_EQUIP = server.getProperty("PlayerRateDropEquip", 25);
			PLAYER_RATE_DROP_EQUIP_WEAPON = server.getProperty("PlayerRateDropEquipWeapon", 5);
			PET_XP_RATE = server.getProperty("PetXpRate", 1.);
			PET_FOOD_RATE = server.getProperty("PetFoodRate", 1);
			SINEATER_XP_RATE = server.getProperty("SinEaterXpRate", 1.);
			KARMA_DROP_LIMIT = server.getProperty("KarmaDropLimit", 10);
			KARMA_RATE_DROP = server.getProperty("KarmaRateDrop", 70);
			KARMA_RATE_DROP_ITEM = server.getProperty("KarmaRateDropItem", 50);
			KARMA_RATE_DROP_EQUIP = server.getProperty("KarmaRateDropEquip", 40);
			KARMA_RATE_DROP_EQUIP_WEAPON = server.getProperty("KarmaRateDropEquipWeapon", 10);
			
			ALLOW_FREIGHT = server.getProperty("AllowFreight", true);
			ALLOW_WAREHOUSE = server.getProperty("AllowWarehouse", true);
			ALLOW_WEAR = server.getProperty("AllowWear", true);
			WEAR_DELAY = server.getProperty("WearDelay", 5);
			WEAR_PRICE = server.getProperty("WearPrice", 10);
			ALLOW_LOTTERY = server.getProperty("AllowLottery", true);
			ALLOW_RACE = server.getProperty("AllowRace", true);
			ALLOW_WATER = server.getProperty("AllowWater", true);
			ALLOWFISHING = server.getProperty("AllowFishing", false);
			ALLOW_MANOR = server.getProperty("AllowManor", true);
			ALLOW_BOAT = server.getProperty("AllowBoat", true);
			ALLOW_CURSED_WEAPONS = server.getProperty("AllowCursedWeapons", true);
			
			String str = server.getProperty("EnableFallingDamage", "auto");
			ENABLE_FALLING_DAMAGE = "auto".equalsIgnoreCase(str) ? GEODATA > 0 : Boolean.parseBoolean(str);
			
			ALT_DEV_NO_SCRIPTS = server.getProperty("NoScripts", false);
			ALT_DEV_NO_SPAWNS = server.getProperty("NoSpawns", false);
			DEBUG = server.getProperty("Debug", false);
			DEVELOPER = server.getProperty("Developer", false);
			PACKET_HANDLER_DEBUG = server.getProperty("PacketHandlerDebug", false);
			
			DEADLOCK_DETECTOR = server.getProperty("DeadLockDetector", false);
			DEADLOCK_CHECK_INTERVAL = server.getProperty("DeadLockCheckInterval", 20);
			RESTART_ON_DEADLOCK = server.getProperty("RestartOnDeadlock", false);
			
			LOG_CHAT = server.getProperty("LogChat", false);
			LOG_ITEMS = server.getProperty("LogItems", false);
			GMAUDIT = server.getProperty("GMAudit", false);
			
			ENABLE_COMMUNITY_BOARD = server.getProperty("EnableCommunityBoard", false);
			BBS_DEFAULT = server.getProperty("BBSDefault", "_bbshome");
			
			COORD_SYNCHRONIZE = server.getProperty("CoordSynchronize", -1);
			GEODATA = server.getProperty("GeoData", 0);
			FORCE_GEODATA = server.getProperty("ForceGeoData", true);
			
			GEODATA_CELLFINDING = server.getProperty("CellPathFinding", false);
			PATHFIND_BUFFERS = server.getProperty("PathFindBuffers", "100x6;128x6;192x6;256x4;320x4;384x4;500x2");
			LOW_WEIGHT = server.getProperty("LowWeight", 0.5);
			MEDIUM_WEIGHT = server.getProperty("MediumWeight", 2);
			HIGH_WEIGHT = server.getProperty("HighWeight", 3);
			ADVANCED_DIAGONAL_STRATEGY = server.getProperty("AdvancedDiagonalStrategy", true);
			DIAGONAL_WEIGHT = server.getProperty("DiagonalWeight", 0.707);
			MAX_POSTFILTER_PASSES = server.getProperty("MaxPostfilterPasses", 3);
			DEBUG_PATH = server.getProperty("DebugPath", false);
			
			L2WALKER_PROTECTION = server.getProperty("L2WalkerProtection", false);
			AUTODELETE_INVALID_QUEST_DATA = server.getProperty("AutoDeleteInvalidQuestData", false);
			GAMEGUARD_ENFORCE = server.getProperty("GameGuardEnforce", false);
			ZONE_TOWN = server.getProperty("ZoneTown", 0);
			SERVER_NEWS = server.getProperty("ShowServerNews", false);
			DISABLE_TUTORIAL = server.getProperty("DisableTutorial", false);
		}
		else if (Server.serverMode == Server.MODE_LOGINSERVER)
		{
			_log.info("Loading loginserver configuration files.");
			
			ExProperties server = load(LOGIN_CONFIGURATION_FILE);
			GAME_SERVER_LOGIN_HOST = server.getProperty("LoginHostname", "*");
			GAME_SERVER_LOGIN_PORT = server.getProperty("LoginPort", 9013);
			
			LOGIN_BIND_ADDRESS = server.getProperty("LoginserverHostname", "*");
			PORT_LOGIN = server.getProperty("LoginserverPort", 2106);
			
			DEBUG = server.getProperty("Debug", false);
			DEVELOPER = server.getProperty("Developer", false);
			PACKET_HANDLER_DEBUG = server.getProperty("PacketHandlerDebug", false);
			ACCEPT_NEW_GAMESERVER = server.getProperty("AcceptNewGameServer", true);
			REQUEST_ID = server.getProperty("RequestServerID", 0);
			ACCEPT_ALTERNATE_ID = server.getProperty("AcceptAlternateID", true);
			
			LOGIN_TRY_BEFORE_BAN = server.getProperty("LoginTryBeforeBan", 10);
			LOGIN_BLOCK_AFTER_BAN = server.getProperty("LoginBlockAfterBan", 600);
			
			LOG_LOGIN_CONTROLLER = server.getProperty("LogLoginController", false);
			
			INTERNAL_HOSTNAME = server.getProperty("InternalHostname", "localhost");
			EXTERNAL_HOSTNAME = server.getProperty("ExternalHostname", "localhost");
			
			DATABASE_URL = server.getProperty("URL", "jdbc:mysql://localhost/acis");
			DATABASE_LOGIN = server.getProperty("Login", "root");
			DATABASE_PASSWORD = server.getProperty("Password", "");
			DATABASE_MAX_CONNECTIONS = server.getProperty("MaximumDbConnections", 10);
			DATABASE_MAX_IDLE_TIME = server.getProperty("MaximumDbIdleTime", 0);
			
			SHOW_LICENCE = server.getProperty("ShowLicence", true);
			IP_UPDATE_TIME = server.getProperty("IpUpdateTime", 15);
			FORCE_GGAUTH = server.getProperty("ForceGGAuth", false);
			
			AUTO_CREATE_ACCOUNTS = server.getProperty("AutoCreateAccounts", true);
			
			FLOOD_PROTECTION = server.getProperty("EnableFloodProtection", true);
			FAST_CONNECTION_LIMIT = server.getProperty("FastConnectionLimit", 15);
			NORMAL_CONNECTION_TIME = server.getProperty("NormalConnectionTime", 700);
			FAST_CONNECTION_TIME = server.getProperty("FastConnectionTime", 350);
			MAX_CONNECTION_PER_IP = server.getProperty("MaxConnectionPerIP", 50);
		}
		else
			_log.severe("Couldn't load configs: server mode wasn't set.");
	}
	
	// It has no instances
	private Config()
	{
	}
	
	public static void saveHexid(int serverId, String string)
	{
		Config.saveHexid(serverId, string, HEXID_FILE);
	}
	
	public static void saveHexid(int serverId, String hexId, String fileName)
	{
		try
		{
			Properties hexSetting = new Properties();
			File file = new File(fileName);
			file.createNewFile();
			
			OutputStream out = new FileOutputStream(file);
			hexSetting.setProperty("ServerID", String.valueOf(serverId));
			hexSetting.setProperty("HexID", hexId);
			hexSetting.store(out, "the hexID to auth into login");
			out.close();
		}
		catch (Exception e)
		{
			_log.warning("Failed to save hex id to " + fileName + " file.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Loads single flood protector configuration.
	 * @param properties L2Properties file reader
	 * @param config flood protector configuration instance
	 * @param configString flood protector configuration string that determines for which flood protector configuration should be read
	 * @param defaultInterval default flood protector interval
	 */
	private static void loadFloodProtectorConfig(final Properties properties, final FloodProtectorConfig config, final String configString, final String defaultInterval)
	{
		config.FLOOD_PROTECTION_INTERVAL = Integer.parseInt(properties.getProperty(StringUtil.concat("FloodProtector", configString, "Interval"), defaultInterval));
		config.LOG_FLOODING = Boolean.parseBoolean(properties.getProperty(StringUtil.concat("FloodProtector", configString, "LogFlooding"), "False"));
		config.PUNISHMENT_LIMIT = Integer.parseInt(properties.getProperty(StringUtil.concat("FloodProtector", configString, "PunishmentLimit"), "0"));
		config.PUNISHMENT_TYPE = properties.getProperty(StringUtil.concat("FloodProtector", configString, "PunishmentType"), "none");
		config.PUNISHMENT_TIME = Integer.parseInt(properties.getProperty(StringUtil.concat("FloodProtector", configString, "PunishmentTime"), "0"));
	}
	
	public static class ClassMasterSettings
	{
		private final Map<Integer, HashMap<Integer, Integer>> _claimItems;
		private final Map<Integer, HashMap<Integer, Integer>> _rewardItems;
		private final Map<Integer, Boolean> _allowedClassChange;
		
		public ClassMasterSettings(String configLine)
		{
			_claimItems = new HashMap<>(3);
			_rewardItems = new HashMap<>(3);
			_allowedClassChange = new HashMap<>(3);
			
			if (configLine != null)
				parseConfigLine(configLine.trim());
		}
		
		private void parseConfigLine(String configLine)
		{
			StringTokenizer st = new StringTokenizer(configLine, ";");
			
			while (st.hasMoreTokens())
			{
				// get allowed class change
				int job = Integer.parseInt(st.nextToken());
				
				_allowedClassChange.put(job, true);
				
				HashMap<Integer, Integer> _items = new HashMap<>();
				// parse items needed for class change
				if (st.hasMoreTokens())
				{
					StringTokenizer st2 = new StringTokenizer(st.nextToken(), "[],");
					
					while (st2.hasMoreTokens())
					{
						StringTokenizer st3 = new StringTokenizer(st2.nextToken(), "()");
						int _itemId = Integer.parseInt(st3.nextToken());
						int _quantity = Integer.parseInt(st3.nextToken());
						_items.put(_itemId, _quantity);
					}
				}
				
				_claimItems.put(job, _items);
				
				_items.clear();
				// parse gifts after class change
				if (st.hasMoreTokens())
				{
					StringTokenizer st2 = new StringTokenizer(st.nextToken(), "[],");
					
					while (st2.hasMoreTokens())
					{
						StringTokenizer st3 = new StringTokenizer(st2.nextToken(), "()");
						int _itemId = Integer.parseInt(st3.nextToken());
						int _quantity = Integer.parseInt(st3.nextToken());
						_items.put(_itemId, _quantity);
					}
				}
				
				_rewardItems.put(job, _items);
			}
		}
		
		public boolean isAllowed(int job)
		{
			if (_allowedClassChange == null)
				return false;
			
			if (_allowedClassChange.containsKey(job))
				return _allowedClassChange.get(job);
			
			return false;
		}
		
		public Map<Integer, Integer> getRewardItems(int job)
		{
			return _rewardItems.get(job);
		}
		
		public Map<Integer, Integer> getRequiredItems(int job)
		{
			return _claimItems.get(job);
		}
	}
	
	/**
	 * itemId1,itemNumber1;itemId2,itemNumber2... to the int[n][2] = [itemId1][itemNumber1],[itemId2][itemNumber2]...
	 * @param line
	 * @return an array consisting of parsed items.
	 */
	private static int[][] parseItemsList(String line)
	{
		final String[] propertySplit = line.split(";");
		if (propertySplit.length == 0)
			return null;
		
		int i = 0;
		String[] valueSplit;
		final int[][] result = new int[propertySplit.length][];
		for (String value : propertySplit)
		{
			valueSplit = value.split(",");
			if (valueSplit.length != 2)
			{
				_log.warning(StringUtil.concat("parseItemsList[Config.load()]: invalid entry -> \"", valueSplit[0], "\", should be itemId,itemNumber"));
				return null;
			}
			
			result[i] = new int[2];
			try
			{
				result[i][0] = Integer.parseInt(valueSplit[0]);
			}
			catch (NumberFormatException e)
			{
				_log.warning(StringUtil.concat("parseItemsList[Config.load()]: invalid itemId -> \"", valueSplit[0], "\""));
				return null;
			}
			
			try
			{
				result[i][1] = Integer.parseInt(valueSplit[1]);
			}
			catch (NumberFormatException e)
			{
				_log.warning(StringUtil.concat("parseItemsList[Config.load()]: invalid item number -> \"", valueSplit[1], "\""));
				return null;
			}
			i++;
		}
		return result;
	}
	
	public static ExProperties load(String filename)
	{
		return load(new File(filename));
	}
	
	public static ExProperties load(File file)
	{
		ExProperties result = new ExProperties();
		
		try
		{
			result.load(file);
		}
		catch (IOException e)
		{
			_log.warning("Error loading config : " + file.getName() + "!");
		}
		
		return result;
	}
}