package info.infinf.phantomImitationEnchantment;

import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import net.kyori.adventure.key.Key;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PhantomImitationEnchantment extends JavaPlugin implements Listener {
    public static final Key PHANTOM_IMITATION_KEY = Key.key("phantomimitation:phantomimitation");
    // Initialized before the class file is loaded
    public static final Enchantment PhantomImitation = RegistryAccess
            .registryAccess()
            .getRegistry(RegistryKey.ENCHANTMENT)
            .get(PHANTOM_IMITATION_KEY);;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onEntityTargetLivingEntity(EntityTargetLivingEntityEvent e) {
        if (e.getEntityType() == EntityType.PHANTOM && e.getTarget() instanceof Player pl) {
            var chest = pl.getInventory().getChestplate();
            if (chest != null && chest.containsEnchantment(PhantomImitation)) {
                e.setCancelled(true);
            }
        }
    }
}
