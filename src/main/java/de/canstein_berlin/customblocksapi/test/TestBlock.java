package de.canstein_berlin.customblocksapi.test;

import de.canstein_berlin.customblocksapi.api.block.CustomBlock;
import de.canstein_berlin.customblocksapi.api.block.properties.*;
import de.canstein_berlin.customblocksapi.api.block.settings.BlockSettings;
import de.canstein_berlin.customblocksapi.api.render.CMDLookupTable;
import de.canstein_berlin.customblocksapi.api.render.CMDLookupTableBuilder;
import de.canstein_berlin.customblocksapi.api.state.CustomBlockState;
import org.bukkit.Axis;
import org.bukkit.block.BlockFace;

public class TestBlock extends CustomBlock {

    public static BooleanProperty ENABLED;
    public static EnumProperty<BlockFace> FACING;
    public static IntProperty AGE0_5;

    static {
        ENABLED = Properties.ENABLED;
        FACING = Properties.FACING;
        AGE0_5 = new IntProperty("age", 0, 5);

    }

    public TestBlock(BlockSettings settings) {
        super(settings, 1);
    }


    @Override
    public void appendProperties(PropertyListBuilder propertyListBuilder) {
        propertyListBuilder.add(ENABLED, FACING, AGE0_5);
    }

    @Override
    public CustomBlockState setDefaultState(CustomBlockState defaultState) {
        return defaultState.with(ENABLED, false).with(AGE0_5, 4).with(FACING, BlockFace.SOUTH);
    }

    @Override
    public CMDLookupTable createCMDLookupTable(CMDLookupTableBuilder tableBuilder) {
        tableBuilder.with(FACING, BlockFace.NORTH).with(ENABLED, false).hasCustomModelData(2).hasRotation(Axis.Y, 180).addElement();
        tableBuilder.with(FACING, BlockFace.SOUTH).with(ENABLED, false).hasCustomModelData(2).addElement();
        tableBuilder.with(FACING, BlockFace.WEST).with(ENABLED, false).hasCustomModelData(2).hasRotation(Axis.Y, 90).addElement();
        tableBuilder.with(FACING, BlockFace.EAST).with(ENABLED, false).hasCustomModelData(2).hasRotation(Axis.Y, 270).addElement();
        tableBuilder.with(FACING, BlockFace.NORTH).with(ENABLED, true).hasCustomModelData(3).hasRotation(Axis.Y, 180).addElement();
        tableBuilder.with(FACING, BlockFace.SOUTH).with(ENABLED, true).hasCustomModelData(3).addElement();
        tableBuilder.with(FACING, BlockFace.WEST).with(ENABLED, true).hasCustomModelData(3).hasRotation(Axis.Y, 90).addElement();
        tableBuilder.with(FACING, BlockFace.EAST).with(ENABLED, true).hasCustomModelData(3).hasRotation(Axis.Y, 270).addElement();
        return tableBuilder.build();
    }

}
