package dev.galiev.sc.items

import dev.galiev.sc.SummerCottage.MOD_ID
import dev.galiev.sc.SummerCottage.SUMMER_COTTAGE
import dev.galiev.sc.items.clothes.fisherman.FishermanHat
import dev.galiev.sc.items.clothes.fisherman.FishermanLeggings
import dev.galiev.sc.items.clothes.fisherman.FishermanShirt
import dev.galiev.sc.items.clothes.fisherman.FlipFlops
import dev.galiev.sc.items.clothes.gardener.GardenerHat
import dev.galiev.sc.items.clothes.gardener.GardenerLeggings
import dev.galiev.sc.items.clothes.gardener.GardenerShirt
import dev.galiev.sc.items.custom.Rake
import dev.galiev.sc.items.custom.WaterCan
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier


object ItemsRegistry {

    val WATER_CAN = registerItem("water_can", WaterCan())

    val RAKE = registerItem("rake", Rake())

    val GARDENER_HAT = registerItem("gardener_hat", GardenerHat())

    val GARDENER_SHIRT = registerItem("gardener_shirt", GardenerShirt())

    val GARDENER_LEGGINGS = registerItem("gardener_leggings", GardenerLeggings())

    val FISHERMAN_HAT = registerItem("fisherman_hat", FishermanHat())

    val FISHERMAN_SHIRT = registerItem("fisherman_shirt", FishermanShirt())

    val FISHERMAN_LEGGINGS = registerItem("fisherman_leggings", FishermanLeggings())

    val FLIP_FLOPS = registerItem("flip_flops", FlipFlops())

    private fun registerItem(name: String, item: Item): Item? {
        return Registry.register(Registries.ITEM, Identifier(MOD_ID, name), item)
    }

    private fun addItemsToItemGroup() {
        addToItemGroup(WATER_CAN)
        addToItemGroup(RAKE)
        addToItemGroup(GARDENER_HAT)
        addToItemGroup(GARDENER_SHIRT)
        addToItemGroup(GARDENER_LEGGINGS)
        addToItemGroup(FISHERMAN_HAT)
        addToItemGroup(FISHERMAN_SHIRT)
        addToItemGroup(FISHERMAN_LEGGINGS)
        addToItemGroup(FLIP_FLOPS)
    }

    private fun addToItemGroup(item: Item?) {
        ItemGroupEvents.modifyEntriesEvent(SUMMER_COTTAGE).register(ItemGroupEvents.ModifyEntries { entries -> entries.add(item) })
    }

    fun registerModItems() {
        addItemsToItemGroup()
    }
}