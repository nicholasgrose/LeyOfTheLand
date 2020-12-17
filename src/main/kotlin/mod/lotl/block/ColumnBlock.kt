package mod.lotl.block

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.item.BlockItemUseContext
import net.minecraft.state.EnumProperty
import net.minecraft.state.StateContainer
import net.minecraft.state.properties.BlockStateProperties
import net.minecraft.util.Direction

/**
 * A block that changes its orientation to reflect the face of the block it was placed on.
 */
class ColumnBlock(properties: Properties) : Block(properties) {
    companion object {
        /**
         * This is the block property that represents the current axis that the column exists in
         * E.g. AXIS.Y is up and down
        */
        val AXIS: EnumProperty<Direction.Axis> = BlockStateProperties.AXIS
    }

    init {
        // This acquires the base state and then sets its default axis to the y-axis
        defaultState = stateContainer.baseState.with(AXIS, Direction.Axis.Y)
    }

    /**
     * This specifies the properties contained in the block state this block uses.
     */
    override fun fillStateContainer(builder: StateContainer.Builder<Block, BlockState>) {
        // Ensuring all of the properties that were originally part of the block state continue to be in the block state
        super.fillStateContainer(builder)
        // Adding our new property, the axis, to the block state
        builder.add(AXIS)
    }

    /**
     * This specifies the state of the block state of this block when it is placed in the world.
     */
    override fun getStateForPlacement(context: BlockItemUseContext): BlockState? {
        // We are modifying the block state to reflect the axis of the face of the block on which it was placed
        return defaultState.with(AXIS, context.face.axis)
    }
}
