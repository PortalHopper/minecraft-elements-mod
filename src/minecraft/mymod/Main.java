package mymod;

import java.awt.Color;

import mymod.armor.MyArmor;
import mymod.biome.MyBiome;
import mymod.biome.MyFrostyBiome;
import mymod.blocks.MyBlock;
import mymod.blocks.MyBlockGen;
import mymod.entity.creeper.MyEntityCreeper;
import mymod.entity.creeper.MyRenderCreeper;
import mymod.entity.minion.MyEntityMinion;
import mymod.entity.minion.MyModelMinion;
import mymod.entity.minion.MyRenderMinion;
import mymod.handlers.MyCraftingHandler;
import mymod.handlers.MyPickupHandler;
import mymod.items.MyFood;
import mymod.items.MyItem;
import mymod.items.MyPickaxe;
import mymod.items.MySword;
import mymod.proxies.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


/* 	MOD INFO */
	@Mod( modid = "mymod", name = "The Elements Mod", version = "1.0")
	@NetworkMod(clientSideRequired=true, serverSideRequired=false)	


public class Main {

/*	PROXY INFO */
	@SidedProxy(clientSide = "mymod.proxies.ClientProxy", serverSide = "mymod.proxies.CommonProxy")
	public static CommonProxy proxy;
		
	
/**	
 * DECLARATION SECTION 
 * *********************************************************** */
      	//  DECLARE THE RADIAION SWORD 
        public static Item MySword_1;

      //  DECLARE THE FROST SWORD 
        public static Item MySword_2;

      //  DECLARE THE MAGMA SWORD 
        public static Item MySword_3;

	//  DECLARE THE RADIATION PICKAXE 
        public static Item MyPickaxe_1;      

      //  DECLARE THE FROST PICKAXE 
        public static Item MyPickaxe_2;

      //  DECLARE THE MAGMA PICKAXE 
        public static Item MyPickaxe_3;

      //  DECLARE NEW TOOL MATERIAL
        /** Harvest Level, Max Uses, Damage (f), Efficiency (f), Enchantablity */
        public static EnumToolMaterial MyToolMaterial = EnumHelper.addToolMaterial("Radioactive Ingot", 3, 1800, 12.0F, 20.0F, 10);
 
  	//  DECLARE THE BLOCK
        public static Block MyBlock_1;    
        
       //  DECLARE THE BLOCK
        public static Block MyBlock_2; 
        
        	//  DECLARE THE ITEM
        public static Item MyItem_1;
        
      //  DECLARE THE SPACED AGED STEACK PALET
        public static Item MyFood_1;  
        
      //  DECLARE THE SPACE CHEESE
        public static Item MyFood_2;
        
      //  DECLARE THE ARMOR
        public static Item MyHelmet_1;
        public static Item MyChest_1;
        public static Item MyLeggings_1;
        public static Item MyBoots_1;
      
      	//  DECLARE THE ARMOR MATERIAL
	        /** maxDamageFactor, damageReductionAmountArray, enchantability*/
        public static EnumArmorMaterial MyArmorMaterial_1 = EnumHelper.addArmorMaterial("Lead", 156, new int[]{7, 7, 7, 7}, 80);
        
         	//  DECLARE THE Radiation Plateau BIOME
        public static  BiomeGenBase MyBiome_1;     
      
        
      //  DECLARE THE Frosty Mountains BIOME
        public static  BiomeGenBase MyFrostyBiome_1;
        
      //  DECLARE THE MOB ID
        static int MyEntityID = 300;

      //  SEARCH FOR UNIQUE ID    
        public static int getUniqueEntityId() {
            do {
                MyEntityID++;
            }
            while (EntityList.getStringFromID(MyEntityID) != null);
            return MyEntityID++;
        }

      //  DECLARE A NEW EGG
        public static void registerEntityEgg(Class <? extends Entity> entity, int primaryColor, int secondaryColor) {
            int id = getUniqueEntityId();
            EntityList.IDtoClassMapping.put(id, entity);
            EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
        }
        
      //	DECLARE THE NEW ACHIEVEMENTS	
    	public static Achievement MyAchievement_1;
        public static Achievement MyAchievement_2;
        public static Achievement MyAchievement_3;
        
      //  DECLARE A NEW CREATIVE TAB  
        public static CreativeTabs MyCreativeTab_1;

        
/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	


@EventHandler	
	public  void preInit( FMLPreInitializationEvent event ) 
	{
/**	
 * LOAD SECTION 
 * *********************************************************** */
 
 //  LOAD THE CREATIVE TAB
        MyCreativeTab_1 = new CreativeTabs("MyCreativeTab_1") {
            public ItemStack getIconItemStack() {
                return new ItemStack(MySword_2, 1, 0);   // Icon, Stack Size, Tab Position
            }
        };
  
  	//  LOAD THE RADIATION SWORD
	        MySword_1 = new MySword(2021, MyToolMaterial, "MySword_1").setCreativeTab(MyCreativeTab_1);
	        GameRegistry.registerItem(MySword_1, "MySword_1");
        LanguageRegistry.addName(MySword_1, "The Radiation Sword");

	//  LOAD THE RADIATION PICKAXE
	        MyPickaxe_1 = new MyPickaxe(2024, MyToolMaterial, "MyPickaxe_1").setCreativeTab(MyCreativeTab_1);
	        GameRegistry.registerItem(MyPickaxe_1, "MyPickaxe_1");
	        LanguageRegistry.addName(MyPickaxe_1, "The Radiation Pickaxe");
	
	//  LOAD RADIATION HELMET 
	        MyHelmet_1 = new MyArmor(2060, MyArmorMaterial_1, 0, 0, "myarmor").setCreativeTab(MyCreativeTab_1);
	        GameRegistry.registerItem(MyHelmet_1, "MyHelmet_1");
	        LanguageRegistry.addName(MyHelmet_1, "Radiation Helmet");      
	    
	//  LOAD RADIATION SUIT
	        MyChest_1 = new MyArmor(2061, MyArmorMaterial_1, 0, 1, "myarmor").setCreativeTab(MyCreativeTab_1);
	        GameRegistry.registerItem(MyChest_1, "MyChest_1");
	        LanguageRegistry.addName(MyChest_1, "Radiation Suit");
	
	//  LOAD RADIATION LEGGINGS    
	        MyLeggings_1 = new MyArmor(2062, MyArmorMaterial_1, 0, 2, "myarmor").setCreativeTab(MyCreativeTab_1);
	        GameRegistry.registerItem(MyLeggings_1, "MyLeggings_1");
	        LanguageRegistry.addName(MyLeggings_1, "Radiation Leggings");
	
	//  LOAD RADIATON BOOTS   
	        MyBoots_1 = new MyArmor(2063, MyArmorMaterial_1, 0, 3, "myarmor").setCreativeTab(MyCreativeTab_1);
	        GameRegistry.registerItem(MyBoots_1, "MyBoots_1");
	        LanguageRegistry.addName(MyBoots_1, "Radiation Boots");
	
	//  LOAD THE ITEM
	        MyItem_1 = new MyItem(2030, "MyItem_1").setCreativeTab(MyCreativeTab_1).setMaxStackSize(64);
	        GameRegistry.registerItem(MyItem_1, "MyItem_1");
	        LanguageRegistry.addName(MyItem_1, "Radioactive Ingot");
	
	//  LOAD THE RADIATION ORE 
	        MyBlock_1 = new MyBlock(250, Material.rock, "MyBlock_1").setLightValue(0.625F).setResistance(13.0F).setHardness(8.0F).setStepSound(Block.soundMetalFootstep).setCreativeTab(MyCreativeTab_1);
	        GameRegistry.registerBlock(MyBlock_1, "MyBlock_1");
	        LanguageRegistry.addName(MyBlock_1, "Radioactive Ore"); 
			MinecraftForge.setBlockHarvestLevel(MyBlock_1, "pickaxe", 2);
		
	//  LOAD THE RUSTED ARTIFACT 
	        MyBlock_2 = new MyBlock(251, Material.rock, "MyBlock_2").setLightValue(0.625F).setResistance(20.0F).setHardness(8.0F).setStepSound(Block.soundMetalFootstep).setCreativeTab(MyCreativeTab_1);
	        GameRegistry.registerBlock(MyBlock_2, "MyBlock_2");
	        LanguageRegistry.addName(MyBlock_2, "Rusted Artifact"); 
MinecraftForge.setBlockHarvestLevel(MyBlock_2, "pickaxe", 2);

//  LOAD THE FROST SWORD
        MySword_2 = new MySword(2022, MyToolMaterial, "MySword_2").setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MySword_2, "MySword_2");
        LanguageRegistry.addName(MySword_2, "The Frost Sword");

//  LOAD THE FROST PICKAXE
        MyPickaxe_2 = new MyPickaxe(2025, MyToolMaterial, "MyPickaxe_2").setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MyPickaxe_2, "MyPickaxe_2");
        LanguageRegistry.addName(MyPickaxe_2, "The Frost Pickaxe");

//  LOAD THE MAGMA SWORD
        MySword_3 = new MySword(2023, MyToolMaterial, "MySword_3").setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MySword_3, "MySword_3");
        LanguageRegistry.addName(MySword_3, "The Magma Sword");

//  LOAD THE MAGMA PICKAXE
        MyPickaxe_3 = new MyPickaxe(2026, MyToolMaterial, "MyPickaxe_3").setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MyPickaxe_3, "MyPickaxe_3");
        LanguageRegistry.addName(MyPickaxe_3, "The Magma Pickaxe");

	
//  LOAD THE SPACE AGED STEAK PALET
        /** itemID, healAmount, saturationModifier (F), isWolfsFavoriteMeat, Texture Name */
        MyFood_1 = new MyFood(2040, 20, 15.0F, true, "MyFood_1").setAlwaysEdible().setCreativeTab(MyCreativeTab_1).setMaxStackSize(64);
        GameRegistry.registerItem(MyFood_1, "MyFood_1");
        LanguageRegistry.addName(MyFood_1, "Steak Palet");
	
//  LOAD THE SPACE CHEESE
        /** itemID, healAmount, saturationModifier (F), isWolfsFavoriteMeat, Texture Name */
        MyFood_2 = new MyFood(2041, 2, 15.0F, true, "MyFood_2").setAlwaysEdible().setCreativeTab(MyCreativeTab_1).setMaxStackSize(64);
        GameRegistry.registerItem(MyFood_2, "MyFood_2");
        LanguageRegistry.addName(MyFood_2, "Cheese");
	
	
		//  LOAD RADIATION PLATEAU
	        MyBiome_1 = new MyBiome(30);
        GameRegistry.addBiome(MyBiome_1);
        
//  LOAD FROSTY MOUNTAINS
        MyFrostyBiome_1 = new MyFrostyBiome(31);
        GameRegistry.addBiome(MyFrostyBiome_1);     
	
		//  REGISTER YOUR ENTITY
	        EntityRegistry.registerGlobalEntityID(MyEntityCreeper.class, "Evolved Creeper", EntityRegistry.findGlobalUniqueEntityId());
	        EntityRegistry.addSpawn(MyEntityCreeper.class, 25, 1, 4, EnumCreatureType.monster, BiomeGenBase.desert); 
	        EntityRegistry.addSpawn(MyEntityCreeper.class, 50, 2, 10, EnumCreatureType.monster, MyBiome_1);     
	        registerEntityEgg(MyEntityCreeper.class, (new Color(77, 87, 77)).getRGB(), (new Color(19, 136, 21)).getRGB());
	        RenderingRegistry.registerEntityRenderingHandler(MyEntityCreeper.class, new MyRenderCreeper());
        ModLoader.addLocalization("entity.Evolved Creeper.name", "Evolved Creeper");
	
//  REGISTER YOUR ENTITY
        EntityRegistry.registerGlobalEntityID(MyEntityMinion.class, "Cold Traveler", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.addSpawn(MyEntityMinion.class, 50, 3, 7, EnumCreatureType.creature, BiomeGenBase.iceMountains);
        EntityRegistry.addSpawn(MyEntityMinion.class, 50, 3, 7, EnumCreatureType.creature, BiomeGenBase.icePlains);             
        EntityRegistry.addSpawn(MyEntityMinion.class, 50, 3, 7, EnumCreatureType.monster, MyFrostyBiome_1);  
        registerEntityEgg(MyEntityMinion.class, (new Color(255, 255, 255)).getRGB(), (new Color(49, 37, 37)).getRGB());
        RenderingRegistry.registerEntityRenderingHandler(MyEntityMinion.class, new MyRenderMinion(new MyModelMinion(), 0.3F));
        ModLoader.addLocalization("entity.Cold Traveler.name", "Cold Traveler");
	
//	LOAD THE ACHIEVEMENTS
		MyAchievement_1 = new Achievement(2001, "MyAchievement_1", -5, -2, MyBlock_1, AchievementList.openInventory).registerAchievement();
		MyAchievement_2 = new Achievement(2002, "MyAchievement_2", -7, -5, MyItem_1, MyAchievement_1).registerAchievement();
		MyAchievement_3 = new Achievement(2003, "MyAchievement_3", -7, -7, MyPickaxe_2, MyAchievement_2).registerAchievement();
		//	(id, "NameOfAchievement", x, y coordinates on Achievement map, icon, Required Achievement to unlock)
		// 	For no Pre-required achievement, use "(Achievement)null"
	
	
	
/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	}

@EventHandler
	public static void init( FMLInitializationEvent event ) 
	{
	
/**	
 * RECIPES SECTION 
 * *********************************************************** */
	//  MARTIAN SWORD RECIPE  
	        GameRegistry.addRecipe(new ItemStack(MySword_1, 1), new Object[]
	        {
	                " X ",
	                " X ",
	                " S ",
	            'S', Item.stick,
	            'X', MyItem_1,
	         });
	        
	//  MARTIAN PICKAXE RECIPE  
	        GameRegistry.addRecipe(new ItemStack(MyPickaxe_1, 1), new Object[]
	        {
	                "XXX",
	                " S ",
	                " S ",
	            'S', Item.stick,
	            'X', MyItem_1,
	        });
	        
	        //  HELMET RECIPE   
	    GameRegistry.addRecipe(new ItemStack(MyHelmet_1, 1), new Object[]
	    {
	            "XXX",
	            "X X",
	            " X ",
	        'X', MyItem_1,
	    });         
	
	//  CHESTPLATE RECIPE   
	    GameRegistry.addRecipe(new ItemStack(MyChest_1, 1), new Object[]
	    {
	            "X X",
	            "XXX",
	            "XXX",
	        'X', MyItem_1,
	    });         
	
	//  LEGGINGS RECIPE 
	    GameRegistry.addRecipe(new ItemStack(MyLeggings_1, 1), new Object[]
	    {
	            "XXX",
	            "X X",
	            "X X",
	        'X', MyItem_1,
	    });         
	
	//  BOOTS RECIPE    
	    GameRegistry.addRecipe(new ItemStack(MyBoots_1, 1), new Object[]
	    {
	            "X X",
	            "X X",
	        'X', MyItem_1,
	    });
	
	//  artifact RECIPE         
	        GameRegistry.addRecipe(new ItemStack(MyBlock_2, 1), new Object[]
	        {
	                "GSG",
	                "SRS",
	                "GSG",
	            'S', Item.redstone,
	            'R',Item.eyeOfEnder,
	            'G',Item.gunpowder
	        });
	
	//  SMELTING RECIPE
        GameRegistry.addSmelting(MyBlock_1.blockID, (new ItemStack(MyItem_1, 3)), 18);
        
//  FROST SWORD RECIPE  
        GameRegistry.addRecipe(new ItemStack(MySword_2, 1), new Object[]
        {
                " X ",
                " X ",
                " S ",
            'S', Item.stick,
            'X', Item.bucketWater,
         });       

//  FROST PICKAXE RECIPE  
        GameRegistry.addRecipe(new ItemStack(MyPickaxe_2, 1), new Object[]
        {
                "XXX",
                " S ",
                " S ",
            'S', Item.stick,
            'X', Item.bucketWater,
        });

//  MAGMA SWORD RECIPE  
        GameRegistry.addRecipe(new ItemStack(MySword_3, 1), new Object[]
        {
                " X ",
                " X ",
                " S ",
            'S', Item.stick,
            'X', Item.bucketLava,
         });
	

	
//  MAGMA PICKAXE RECIPE  
        GameRegistry.addRecipe(new ItemStack(MyPickaxe_3, 1), new Object[]
        {
                "XXX",
                " S ",
                " S ",
            'S', Item.stick,
            'X', Item.bucketLava,
        }); 



//  FOOD RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyFood_1, 1), new Object[]
        {
                "SS",
                "SS",
               
            'S', Item.beefCooked,
        });

//  FOOD RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyFood_2, 1), new Object[]
        {
                "S",
                
               
            'S', Item.bucketMilk,
        });




/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	
/**	
 * EXTRA METHODS SECTION 
 * *********************************************************** */

//  REGISTER THE ORE GENERATION 
    GameRegistry.registerWorldGenerator(new MyBlockGen());
        
//	CHANGE THE TEXT OF THE ACHIEVEMENTS	
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_1", "en_US", "I'm Radioactive!");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_1.desc", "en_US", "Get Radioactive Ore");
LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_2", "en_US", "Seems Surdy...");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_2.desc", "en_US", "Get A Radioactive Ingot");
LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_3", "en_US", "It Came From Mars!");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_3.desc", "en_US", "Craft A Martian Pickaxe");

//  REGISTER PICKUP HANDLER
        MyPickupHandler MyPickupHandler_1 = new MyPickupHandler();
        GameRegistry.registerPickupHandler(MyPickupHandler_1);

//  REGISTER CRAFTING HANDLER
        MyCraftingHandler MyCraftingHandler_1 = new MyCraftingHandler();
        GameRegistry.registerCraftingHandler(MyCraftingHandler_1);

//  CHANGE TAB NAME
        LanguageRegistry.instance().addStringLocalization("itemGroup.MyCreativeTab_1", "en_US", "Space Exploration Awesomeness");   


/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	
	}

@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) 
	{

	}
	
}
