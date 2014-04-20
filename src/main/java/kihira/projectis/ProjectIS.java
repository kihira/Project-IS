package kihira.projectis;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import kihira.projectis.proxy.ProxyCommon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = "ProjectIS")
public class ProjectIS {

    public static final Logger logger = LogManager.getLogger("ProjectIS");

    @SidedProxy(clientSide = "kihira.projectis.proxy.ProxyClient", serverSide = "kihira.projectis.proxy.ProxyCommon")
    public static ProxyCommon proxy;

    public void preInit(FMLPreInitializationEvent e) {

    }
}
