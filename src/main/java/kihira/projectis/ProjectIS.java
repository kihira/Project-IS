package kihira.projectis;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import kihira.projectis.block.BlockMachine;
import kihira.projectis.item.ItemBlockMachine;
import kihira.projectis.proxy.ProxyCommon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = "ProjectIS")
public class ProjectIS {

    public static final Logger logger = LogManager.getLogger("ProjectIS");

    public static final BlockMachine blockMachine = new BlockMachine();

    @SidedProxy(clientSide = "kihira.projectis.proxy.ProxyClient", serverSide = "kihira.projectis.proxy.ProxyCommon")
    public static ProxyCommon proxy;

    @Mod.Instance(value = "ProjectIS")
    public static ProjectIS instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        GameRegistry.registerBlock(blockMachine, ItemBlockMachine.class, "blockMachine");
    }
}
