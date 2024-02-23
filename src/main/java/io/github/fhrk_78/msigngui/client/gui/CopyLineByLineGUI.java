package io.github.fhrk_78.msigngui.client.gui;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import io.github.fhrk_78.msigngui.client.MarumaSignGUIClient;
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
        root.add(l1, 0, 1, 5, 1);

        WButton b1 = new WButton(Text.translatable("text.marumasigngui.copy"));
        b1.setOnClick(() -> MarumaSignGUIClient.copyString(l1.getText()));
        root.add(b1,5, 1, 2, 1);

        WTextField l2 = new WTextField();
        l2.setText(MarumaSignGUIClient.multiSave[1]);
        l2.setMaxLength(20);
        root.add(l2, 0, 2, 5, 1);

        WButton b2 = new WButton(Text.translatable("text.marumasigngui.copy"));
        b2.setOnClick(() -> MarumaSignGUIClient.copyString(l2.getText()));
        root.add(b2,5, 2, 2, 1);

        WTextField l3 = new WTextField();
        l3.setText(MarumaSignGUIClient.multiSave[2]);
        l3.setMaxLength(20);
        root.add(l3, 0, 3, 5, 1);

        WButton b3 = new WButton(Text.translatable("text.marumasigngui.copy"));
        b3.setOnClick(() -> MarumaSignGUIClient.copyString(l3.getText()));
        root.add(b3,5, 3, 2, 1);

        WTextField l4 = new WTextField();
        l4.setText(MarumaSignGUIClient.multiSave[3]);
        l4.setMaxLength(20);
        root.add(l4, 0, 4, 5, 1);

        WButton b4 = new WButton(Text.translatable("text.marumasigngui.copy"));
        b4.setOnClick(() -> MarumaSignGUIClient.copyString(l4.getText()));
        root.add(b4,5, 4, 2, 1);

        WTextField l5 = new WTextField();
        l5.setText(MarumaSignGUIClient.multiSave[4]);
        l5.setMaxLength(20);
        root.add(l5, 8, 1, 5, 1);

        WButton b5 = new WButton(Text.translatable("text.marumasigngui.copy"));
        b5.setOnClick(() -> MarumaSignGUIClient.copyString(l5.getText()));
        root.add(b5,13, 1, 2, 1);

        WTextField l6 = new WTextField();
        l6.setText(MarumaSignGUIClient.multiSave[5]);
        l6.setMaxLength(20);
        root.add(l6, 8, 2, 5, 1);

        WButton b6 = new WButton(Text.translatable("text.marumasigngui.copy"));
        b6.setOnClick(() -> MarumaSignGUIClient.copyString(l6.getText()));
        root.add(b6,13, 2, 2, 1);

        WTextField l7 = new WTextField();
        l7.setText(MarumaSignGUIClient.multiSave[6]);
        l7.setMaxLength(20);
        root.add(l7, 8, 3, 5, 1);

        WButton b7 = new WButton(Text.translatable("text.marumasigngui.copy"));
        b7.setOnClick(() -> MarumaSignGUIClient.copyString(l7.getText()));
        root.add(b7,13, 3, 2, 1);

        WTextField l8 = new WTextField();
        l8.setText(MarumaSignGUIClient.multiSave[7]);
        l8.setMaxLength(20);
        root.add(l8, 8, 4, 5, 1);

        WButton b8 = new WButton(Text.translatable("text.marumasigngui.copy"));
        b8.setOnClick(() -> MarumaSignGUIClient.copyString(l8.getText()));
        root.add(b8,13, 4, 2, 1);

        WText dscrp = new WText(Text.translatable("text.marumasigngui.clcgd"));
        root.add(dscrp, 0, 6, 15, 1);

        root.validate(this);
    }
}
