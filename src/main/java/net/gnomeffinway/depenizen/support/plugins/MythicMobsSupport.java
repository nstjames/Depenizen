package net.gnomeffinway.depenizen.support.plugins;

import net.aufdemrand.denizen.objects.dEntity;
import net.elseland.xikage.MythicLib.Adapters.Bukkit.BukkitAdapter;
import net.elseland.xikage.MythicMobs.Mobs.ActiveMob;
import net.elseland.xikage.MythicMobs.Mobs.ActiveMobHandler;
import net.elseland.xikage.MythicMobs.Mobs.MobManager;
import net.elseland.xikage.MythicMobs.Mobs.MythicMob;
import net.gnomeffinway.depenizen.commands.mythicmobs.MythicSpawnCommand;
import net.gnomeffinway.depenizen.events.mythicmobs.MythicMobsDeathEvent;
import net.gnomeffinway.depenizen.extensions.mythicmobs.MythicMobsEntityExtension;
import net.gnomeffinway.depenizen.objects.mythicmobs.MythicMobsMob;
import net.gnomeffinway.depenizen.support.Support;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

import java.util.UUID;

public class MythicMobsSupport extends Support {

    public MythicMobsSupport() {
        registerObjects(MythicMobsMob.class);
        registerProperty(MythicMobsEntityExtension.class, dEntity.class);
        registerScriptEvents(new MythicMobsDeathEvent());
        new MythicSpawnCommand().activate().as("mythicspawn").withOptions("See Documentation", 2);
    }

    public static boolean isMythicMob(Entity entity) {
        return ActiveMobHandler.isRegisteredMob(BukkitAdapter.adapt(entity));
    }

    public static boolean isMythicMob(UUID uuid) {
        return ActiveMobHandler.isRegisteredMob(uuid);
    }

    public static ActiveMob getActiveMob(Entity entity) {
        return ActiveMobHandler.getMythicMobInstance(entity);
    }

    public static MythicMob getMythicMob(String name) {
        return MobManager.getMythicMob(name);
    }

    public static Entity spawnMythicMob(MythicMob mythicMob, Location location, int level) {
        return mythicMob.spawn(BukkitAdapter.adapt(location), level);
    }
}
