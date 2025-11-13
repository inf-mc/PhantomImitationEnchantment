package info.infinf.phantomImitationEnchantment;

import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.registry.RegistryKey;
import io.papermc.paper.registry.data.EnchantmentRegistryEntry;
import io.papermc.paper.registry.event.RegistryEvents;
import io.papermc.paper.registry.keys.EnchantmentKeys;
import io.papermc.paper.registry.set.RegistrySet;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.EquipmentSlotGroup;

public class BootStrap implements PluginBootstrap {
    @Override
    public void bootstrap(BootstrapContext context) {
        context.getLifecycleManager().registerEventHandler(RegistryEvents.ENCHANTMENT.compose().newHandler(event -> {
            event.registry().register(
                    EnchantmentKeys.create(Key.key("phantomimitation:phantomimitation")),
                    enchantmentBuilder -> enchantmentBuilder
                            .description(Component.text("幻翼拟态"))
                            .supportedItems(RegistrySet.keySet(
                                    RegistryKey.ITEM, RegistryKey.ITEM.typedKey(Key.key("minecraft:elytra"))))
                            .anvilCost(2)
                            .maxLevel(1)
                            .weight(1)
                            .minimumCost(EnchantmentRegistryEntry.EnchantmentCost.of(45, 0))
                            .maximumCost(EnchantmentRegistryEntry.EnchantmentCost.of(65, 0))
                            .activeSlots(EquipmentSlotGroup.CHEST)
            );
        }));
    }
}
