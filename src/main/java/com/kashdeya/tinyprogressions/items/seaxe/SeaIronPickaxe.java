package com.kashdeya.tinyprogressions.items.seaxe;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.kashdeya.tinyprogressions.main.TinyProgressions;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class SeaIronPickaxe extends ItemPickaxe {
	
	public SeaIronPickaxe(ToolMaterial material){
		super(material);
		this.setCreativeTab(TinyProgressions.tabTP);
		this.setMaxStackSize(1);
		this.setHarvestLevel("pickaxe", 2);
	}
	
	public Set<String> getToolClasses(ItemStack stack) {
		return ImmutableSet.of("pickaxe", "sword");
	}
	
	@Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		ItemStack mat = new ItemStack(Items.IRON_INGOT);
		return !mat.isEmpty() && OreDictionary.itemMatches(mat, repair, false) || super.getIsRepairable(toRepair, repair);
	}
	
	private static HashSet<Block> effectiveAgainst = Sets.newHashSet(Blocks.WEB);

	@Override
	public boolean canHarvestBlock(IBlockState blockIn) {
			return effectiveAgainst.contains(blockIn.getBlock()) || super.canHarvestBlock(blockIn);
	}

	@Override
	public float getDestroySpeed(ItemStack stack, IBlockState state) {
		return state.getMaterial() == Material.WEB ? this.efficiency : effectiveAgainst.contains(state.getBlock()) ? this.efficiency : super.getDestroySpeed(stack, state);
	}
}