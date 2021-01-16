package mod.lotl.common.entity

import net.minecraft.entity.projectile.EyeOfEnderEntity
import net.minecraft.particles.ParticleTypes
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.MathHelper
import net.minecraft.util.math.vector.Vector3d
import net.minecraft.world.World
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

class LeyFinderEntity(worldIn: World, x: Double, y: Double, z: Double) : EyeOfEnderEntity(worldIn, x, y, z) {
    private var targetX = 0.0
    private var targetY = 0.0
    private var targetZ = 0.0
    private var despawnTimer : Int = 0

    override fun setFlag(flag: Int, set: Boolean) {

        super.setFlag(6, true)
    }

    private fun rotationCalc(p_234614_0_: Float, p_234614_1_: Float): Float {
        var previousValue = p_234614_0_
        while (p_234614_1_ - previousValue < -180.0f) {
            previousValue -= 360.0f
        }
        while (p_234614_1_ - previousValue >= 180.0f) {
            previousValue += 360.0f
        }
        return MathHelper.lerp(0.2f, previousValue, p_234614_1_)
    }

    override fun moveTowards(pos: BlockPos) {
        val d0 = pos.x.toDouble()
        val i = pos.y
        val d1 = pos.z.toDouble()
        val d2 = d0 - this.posX
        val d3 = d1 - this.posZ
        val f = MathHelper.sqrt(d2 * d2 + d3 * d3)
        if (f > 12.0f) {
            this.targetX = this.posX + d2 / f.toDouble() * 12.0
            this.targetZ = this.posZ + d3 / f.toDouble() * 12.0
            this.targetY = this.posY + 8.0
        } else {
            this.targetX = d0
            this.targetY = i.toDouble()
            this.targetZ = d1
        }
        despawnTimer = 0
    }

    override fun tick() {
        var vector3d = motion
        val d0 = this.posX + vector3d.x
        val d1 = this.posY + vector3d.y
        val d2 = this.posZ + vector3d.z
        val f = MathHelper.sqrt(horizontalMag(vector3d))
        rotationPitch = rotationCalc(
            prevRotationPitch, (MathHelper.atan2(
                vector3d.y,
                f.toDouble()
            ) * (180f / Math.PI.toFloat()).toDouble()).toFloat()
        )
        rotationYaw = rotationCalc(
            prevRotationYaw,
            (MathHelper.atan2(vector3d.x, vector3d.z) * (180f / Math.PI.toFloat()).toDouble()).toFloat()
        )
        if (!world.isRemote) {
            val d3 = targetX - d0
            val d4 = targetZ - d2
            val f1 = sqrt(d3 * d3 + d4 * d4).toFloat()
            val f2 = MathHelper.atan2(d4, d3).toFloat()
            var d5 = MathHelper.lerp(0.0025, f.toDouble(), f1.toDouble())
            var d6 = vector3d.y
            if (f1 < 1.0f) {
                d5 *= 0.8
                d6 *= 0.8
            }
            val j = if (this.posY < targetY) 1 else -1
            vector3d = Vector3d(
                cos(f2.toDouble()) * d5, d6 + (j.toDouble() - d6) * 0.015f.toDouble(), sin(
                    f2.toDouble()
                ) * d5
            )
            motion = vector3d
        }
        if (this.isInWater) {
            for (i in 0..3) {
                world.addParticle(
                    ParticleTypes.BUBBLE,
                    d0 - vector3d.x * 0.25,
                    d1 - vector3d.y * 0.25,
                    d2 - vector3d.z * 0.25,
                    vector3d.x,
                    vector3d.y,
                    vector3d.z
                )
            }
        } else {
            world.addParticle(
                ParticleTypes.PORTAL,
                d0 - vector3d.x * 0.25 + rand.nextDouble() * 0.6 - 0.3,
                d1 - vector3d.y * 0.25 - 0.5,
                d2 - vector3d.z * 0.25 + rand.nextDouble() * 0.6 - 0.3,
                vector3d.x,
                vector3d.y,
                vector3d.z
            )
        }
        if (!world.isRemote) {
            setPosition(d0, d1, d2)
            ++despawnTimer
            if (despawnTimer > 80 && !world.isRemote) {
                this.remove()
            }
        } else {
            setRawPosition(d0, d1, d2)
        }
    }

}