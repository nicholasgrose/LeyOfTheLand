package mod.lotl.block

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.item.BlockItemUseContext
import net.minecraft.state.DirectionProperty

import net.minecraft.state.EnumProperty
import net.minecraft.state.Property
import net.minecraft.state.StateContainer
import net.minecraft.state.properties.BlockStateProperties
import net.minecraft.util.Direction


class LeyBlock(properties: Properties) : Block(properties) {
    val direction = DirectionProperty.create("axis", Direction.Plane.HORIZONTAL)
    override fun fillStateContainer(builder: StateContainer.Builder<Block, BlockState>) {
        builder.add(direction)
        super.fillStateContainer(builder)
    }

    override fun getStateForPlacement(context: BlockItemUseContext): BlockState? {
        return defaultState.with(direction, context.placementHorizontalFacing)
    }
   /* init {
        defaultState = this.stateContainer.baseState.with(BlockStateProperties.AXIS,Direction.Axis.Y)
    }
    override fun getStateForPlacement(context: BlockItemUseContext): BlockState? {
        return defaultState.with(BlockStateProperties.AXIS,context.placementHorizontalFacing.axis)
    }*/
}
