package mymod.biome;

import mymod.Main;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityMooshroom;    
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class MyBiome extends BiomeGenBase
{
    public MyBiome(int par1)
    {
        super(par1);
        
        this.setBiomeName("Radiation Plateau");
        
        this.topBlock = (byte)Block.netherrack.blockID;
        this.fillerBlock = (byte)Block.stone.blockID;
        
        this.theBiomeDecorator.grassPerChunk = 50;
        this.theBiomeDecorator.clayPerChunk = 15;
        this.theBiomeDecorator.sandPerChunk = 10;
        this.theBiomeDecorator.deadBushPerChunk = 16;
        this.theBiomeDecorator.treesPerChunk = 12;

        this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 10, 2, 5));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityBat.class, 15, 4, 8));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityCreeper.class, 10, 2, 10));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityMagmaCube.class, 10, 2, 5));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPigZombie.class, 10, 7, 10));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityZombie.class, 10, 7, 10));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 10, 5, 5));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityGiantZombie.class, 5, 2, 5));

        
        this.setMinMaxHeight(0.1F, 0.10F);
        this.setTemperatureRainfall(1.5F, 0.0F);
   
    }
}