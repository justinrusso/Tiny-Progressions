package com.kashdeya.tinyprogressions.blocks.reinforced;

import java.util.List;
import java.util.Random;

import com.kashdeya.tinyprogressions.inits.TechBlocks;
import com.kashdeya.tinyprogressions.main.TinyProgressions;
import com.kashdeya.tinyprogressions.registry.utils.IOreDictEntry;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ReinforcedObsidian extends Block implements IOreDictEntry {
	
	public ReinforcedObsidian()
    {
        super(Material.ANVIL);
        this.setHardness(30.0F);
        this.setResistance(2000.0F);
        this.setHarvestLevel("pickaxe", 2);
        this.setSoundType(SoundType.ANVIL);
        this.setCreativeTab(TinyProgressions.tabTP);
        this.setUnlocalizedName("reinforced_obsidian");
    }
	
	@Override
	public String getOreDictName() {
		return "blockReinforcedObsidian";
	}
	
	@Override
	public boolean canEntityDestroy(IBlockState state, IBlockAccess world, BlockPos pos, Entity entity)
    {
      return !(entity instanceof EntityWither);
    }
	
	@Override
	public void onBlockExploded(World world, BlockPos pos, Explosion explosion) {}
	  
	@Override
	public boolean canDropFromExplosion(Explosion explosionIn)
	{
		return false;	
	}
	
    @Override
    public int quantityDropped(Random rand)
    {
        return 1;
    }
    
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(TechBlocks.reinforced_obsidian);
    }

	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return MapColor.BLACK;
    }
    
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced)
    {
		tooltip.add(TextFormatting.YELLOW + new TextComponentTranslation("tooltip.obsidian_1").getFormattedText());
    }

}
