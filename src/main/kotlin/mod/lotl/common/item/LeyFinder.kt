package mod.lotl.common.item

import net.minecraft.advancements.CriteriaTriggers
import net.minecraft.entity.item.EnderPearlEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.ServerPlayerEntity
import net.minecraft.entity.projectile.EyeOfEnderEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class LeyFinder : Item(Properties().isImmuneToFire.maxStackSize(1).group(ItemGroup.TOOLS)) {
    override fun onItemRightClick(worldIn: World, playerIn: PlayerEntity, handIn: Hand): ActionResult<ItemStack> {
        val itemstack = playerIn.getHeldItem(handIn)
        val blockpos = BlockPos(0, 100, 0)
        if (blockpos != null) {
            val eyeofenderentity = EyeOfEnderEntity(worldIn, playerIn.posX, playerIn.getPosYHeight(0.5), playerIn.posZ)
            eyeofenderentity.func_213863_b(itemstack)
            eyeofenderentity.moveTowards(blockpos)
            worldIn.addEntity(eyeofenderentity)
            if (playerIn is ServerPlayerEntity) {
                CriteriaTriggers.USED_ENDER_EYE.trigger(playerIn as ServerPlayerEntity, blockpos)
            }
        }
        return super.onItemRightClick(worldIn, playerIn, handIn)
    }
}