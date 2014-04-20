package kihira.projectis.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMachine extends ItemBlock {

    private final String[] subNames = {"engineeringWorkTable", "researchTable", "processingPlant", "platePressingMachine", "alloySmelter", "assemblyProcessingUnit", "assemblyPowerInlet", "assembler", "assemblyStorage"};

    public ItemBlockMachine(Block block) {
        super(block);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int damageValue) {
        return damageValue;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return this.subNames[itemstack.getItemDamage()];
    }
}
