package com.kashdeya.tinyprogressions.blocks.bushes;

import java.util.Random;

import com.kashdeya.tinyprogressions.main.TinyProgressions;

import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockBerryBush extends BlockBush implements net.minecraftforge.common.IPlantable {
	
	public BlockBerryBush()
    {
        super(Material.PLANTS);
        this.setCreativeTab(TinyProgressions.tabTP);
        this.setHardness(0.0F);
        this.setSoundType(SoundType.PLANT);
    }
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return BUSH_AABB;
    }
	
	public MapColor getMapColor(IBlockState state)
    {
        return MapColor.GREEN;
    }

	@Override
    protected boolean canSustainBush(IBlockState state)
    {
        return state.getBlock() == Blocks.GRASS || state.getBlock() == Blocks.DIRT;
    }

	@Override
    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos)
    {
        return true;
    }

	@Override
	public int quantityDropped(Random random)
    {
        return 1 + random.nextInt(4);
    }
	
}