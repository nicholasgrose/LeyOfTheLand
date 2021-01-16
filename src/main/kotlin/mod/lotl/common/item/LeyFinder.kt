package mod.lotl.common.item

import mod.lotl.common.entity.LeyFinderEntity
import mod.lotl.common.worldgen.biome.ModBiomes.LEY_BIOME
import net.minecraft.advancements.CriteriaTriggers
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.ServerPlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.world.World
import net.minecraft.world.biome.Biome
import net.minecraft.world.server.ServerWorld


class LeyFinder : Item(Properties().isImmuneToFire.maxStackSize(1).group(ItemGroup.TOOLS)) {
    override fun onItemRightClick(worldIn: World, playerIn: PlayerEntity, handIn: Hand): ActionResult<ItemStack> {
        val itemstack = playerIn.getHeldItem(handIn)
        val itemsprite = ItemStack(ModItems.CRYSTAL_LEY)
        playerIn.activeHand = handIn
        playerIn.cooldownTracker.setCooldown(this, 20)
        if (worldIn is ServerWorld) {
            val blockpos =  worldIn.chunkProvider.chunkGenerator.biomeProvider
                .findBiomePosition(playerIn.position.x, playerIn.position.y, playerIn.position.z, 1500, 10,
                    { biome: Biome -> biome.registryName == LEY_BIOME.registryName }, worldIn.rand, true)
            if (blockpos != null) {
                val finderEntity = LeyFinderEntity(worldIn, playerIn.posX, playerIn.getPosYHeight(0.5), playerIn.posZ)
                finderEntity.func_213863_b(itemsprite)
                finderEntity.moveTowards(blockpos)
                worldIn.addEntity(finderEntity)
                if (playerIn is ServerPlayerEntity) {
                    CriteriaTriggers.USED_ENDER_EYE.trigger(playerIn, blockpos)
                }
            }
            return ActionResult.resultPass(itemstack)
        }
        return ActionResult.resultSuccess(itemstack)
    }
}