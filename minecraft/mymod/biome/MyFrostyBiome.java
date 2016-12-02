package mymod.biome;

import mymod.Main;
import mymod.entity.creeper.MyEntityCreeper;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityMooshroom;    
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class MyFrostyBiome extends BiomeGenBase
{
    public MyFrostyBiome(int par1)
    {
        super(par1);
        
        this.setBiomeName("Frosty Mountains");
        
        this.topBlock = (byte)Block.grass.blockID;
        this.fillerBlock = (byte)Block.dirt.blockID;
        
        this.theBiomeDecorator.treesPerChunk = 25;
     
     
        

        this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 15, 2, 5));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityIronGolem.class, 15, 4, 8));
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySnowman.class, 15, 2, 10));
        this.spawnableCreatureList.add(new SpawnListEntry(MyEntityCreeper.class, 15, 2, 4));
               this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 15, 5, 10));

        
      
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 10, 5, 5));
        

        
        this.setMinMaxHeight(1.2F, 2.3F);
        this.setTemperatureRainfall(0.0F, 1.7F);
   
    }
}