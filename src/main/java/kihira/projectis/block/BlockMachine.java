package kihira.projectis.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public class BlockMachine extends Block {

    private IIcon[] iconArray;
    public static final String[] machineTexture = new String[] {"mcn_EnWorkTable", "mcn_ResearchTable", "mcn_ProcessingPlant", "mcn_PlatePress", "mcn_AlloySmelter","mcn_AssemblyCPU","mcn_AssemblyPwr","mcn_Assembler","mcn_AssemblyStorage"};

    public BlockMachine() {
        super(Material.iron);
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        MathHelper.clamp_int(meta, 0, iconArray.length);
        return this.iconArray[meta];
    }

    @Override
    public int damageDropped(int par1) {
        return par1;
    }

    /*
    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        switch (metadata) {
            case 0: return new TileEntityEngineeringWorktable();
            case 1: return new TileEntityResearchTable();
            case 2: return new TileEntityProcessingPlant();
            case 3: return new TileEntityPlatePressing();
            case 4: return new TileEntityAlloySmelter();
            case 5: return new TileEntityAssemblyProcessingUnit();
            case 6: return new TileEntityAssemblyPowerInlet();
            case 7: return new TileEntityAssembler();
            case 8: return new TileEntityAssemblyStorage();
            default: return new TileEntityEngineeringWorktable();
        }
    }
    */

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        //player.openGui(ProjectIS.instance, 0, world, x, y, z);
        return true;
    }

    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
        if (!world.isRemote) {
            /*
            switch (meta) {
                case 5: {
                    TileEntityAssemblyProcessingUnit tileEntity = (TileEntityAssemblyProcessingUnit) world.getBlockTileEntity(x, y, z);
                    tileEntity.intialSetup(world, side);
                }
            }
            */
        }
        return meta;
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void getSubBlocks(Item item, CreativeTabs creativetab, List list) {
        for (int i = 0; i < 9; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.iconArray = new IIcon[machineTexture.length];

        for (int i = 0; i < this.iconArray.length; ++i) {
            this.iconArray[i] = iconRegister.registerIcon(machineTexture[i]);
        }
    }
}
