package dev.galiev.sc.helper

import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound

object NbtHelper {
    fun setString(stack: ItemStack?, key: String, value: String){
        getTagCompound(stack)?.putString(key, value)
    }

    fun setBoolean(stack: ItemStack?, key: String, value: Boolean){
        getTagCompound(stack)?.putBoolean(key, value)
    }

    fun setInt(stack: ItemStack?, key: String, value: Int){
        getTagCompound(stack)?.putInt(key, value)
    }

    fun getString(stack: ItemStack?, key: String): String {
        return if (stack?.hasNbt() == true) getTagCompound(stack)!!.getString(key) else ""
    }

    fun getBoolean(stack: ItemStack?, key: String?): Boolean {
        return stack?.hasNbt() == true && getTagCompound(stack)!!.getBoolean(key)
    }

    fun getInt(stack: ItemStack?, key: String?): Int {
        return if (stack?.hasNbt() == true) getTagCompound(stack)!!.getInt(key) else 0
    }

    fun validateCompound(stack: ItemStack?){
        if (!stack?.hasNbt()!!){
            stack.nbt = NbtCompound()
        }
    }

    fun getTagCompound(stack: ItemStack?): NbtCompound? {
        validateCompound(stack)
        return stack?.nbt
    }
}
