package io.github.fhrk_78.msigngui.client;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WText;
import io.github.cottonmc.cotton.gui.widget.WTextField;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.minecraft.text.Text;

public class CopyLineByLineGUI extends LightweightGuiDescription {
    public CopyLineByLineGUI () {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(288, 100);
        root.setInsets(Insets.ROOT_PANEL);

        WLabel label = new WLabel(Text.translatable("text.marumasigngui.ctrla"));
        root.add(label, 0, 0, 15, 1);

        WTextField l1 = new WTextField();
        l1.setText(MarumaSignGUIClient.multiSave[0]);
        l1.setMaxLength(20);
        root.add(l1, 0, 1, 15, 1);

        WTextField l2 = new WTextField();
        l2.setText(MarumaSignGUIClient.multiSave[1]);
        l2.setMaxLength(20);
        root.add(l2, 0, 2, 15, 1);

        WTextField l3 = new WTextField();
        l3.setText(MarumaSignGUIClient.multiSave[2]);
        l3.setMaxLength(20);
        root.add(l3, 0, 3, 15, 1);

        WTextField l4 = new WTextField();
        l4.setText(MarumaSignGUIClient.multiSave[3]);
        l4.setMaxLength(20);
        root.add(l4, 0, 4, 15, 1);

        WText dscrp = new WText(Text.translatable("text.marumasigngui.clcgd"));
        root.add(dscrp, 0, 6, 15, 1);

        root.validate(this);
    }
}
