package mod.lotl.block

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.item.BlockItemUseContext
import net.minecraft.state.EnumProperty
import net.minecraft.state.StateContainer
import net.minecraft.state.properties.BlockStateProperties
import net.minecraft.util.Direction


class ColumnBlock(properties: Properties) : Block(properties) {
    companion object {
        val AXIS: EnumProperty<Direction.Axis> = BlockStateProperties.AXIS
    }

    init {
        defaultState = stateContainer.baseState.with(AXIS, Direction.Axis.Y)
    }

    override fun fillStateContainer(builder: StateContainer.Builder<Block, BlockState>) {
        super.fillStateContainer(builder)
        builder.add(AXIS)
    }

    override fun getStateForPlacement(context: BlockItemUseContext): BlockState? {
        return defaultState.with(AXIS, context.face.axis)
    }
}
