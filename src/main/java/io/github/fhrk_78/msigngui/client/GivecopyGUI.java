package io.github.fhrk_78.msigngui.client;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WTextField;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.minecraft.text.Text;

public class GivecopyGUI extends LightweightGuiDescription {
    public GivecopyGUI (String fstr) {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(360, 38);
        root.setInsets(Insets.ROOT_PANEL);

        WLabel label = new WLabel(Text.translatable("text.marumasigngui.ctrla"));
        root.add(label, 0, 0, 20, 1);

        WTextField gc = new WTextField();
        gc.setMaxLength(512);
        gc.setText(fstr);
        root.add(gc, 0, 1, 20, 1);

        root.validate(this);
    }
}
