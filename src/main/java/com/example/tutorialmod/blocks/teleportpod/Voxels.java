package com.example.tutorialmod.blocks.teleportpod;

import net.minecraft.block.Block;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

class Voxels {
    public static final VoxelShape north = VoxelShapes.combineAndSimplify(Block.makeCuboidShape(1, 1, 1, 15, 1.7999999999999998, 15), Block.makeCuboidShape(0, 0, 0, 16, 1, 16), IBooleanFunction.OR);
    public static final VoxelShape south = VoxelShapes.combineAndSimplify(Block.makeCuboidShape(1, 1, 1, 15, 1.7999999999999998, 15), Block.makeCuboidShape(0, 0, 0, 16, 1, 16), IBooleanFunction.OR);
    public static final VoxelShape east = VoxelShapes.combineAndSimplify(Block.makeCuboidShape(1, 1, 1, 15, 1.7999999999999998, 15), Block.makeCuboidShape(0, 0, 0, 16, 1, 16), IBooleanFunction.OR);
    public static final VoxelShape west = VoxelShapes.combineAndSimplify(Block.makeCuboidShape(1, 1, 1, 15, 1.7999999999999998, 15), Block.makeCuboidShape(0, 0, 0, 16, 1, 16), IBooleanFunction.OR);
}
