package io.github.fhrk_78.msigngui.client;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WTextField;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GenGUI extends LightweightGuiDescription {
    public GenGUI() {
        // ルートパネルに新しいWGridPanelを設定
        WGridPanel root = new WGridPanel();
        setRootPanel(root);

        // ルートパネルの設定
        root.setSize(324, 216);
        root.setInsets(Insets.ROOT_PANEL);

        /// GUIへのウィジットの追加

        // ラベル：URL
        WLabel lURL = new WLabel(Text.translatable("text.marumasigngui.inurl"));
        root.add(lURL, 0, 0, 2, 1);
        // フィールド：URL
        WTextField inURL = new WTextField();
        inURL.setMaxLength(255);
        root.add(inURL, 3, 0, 15, 1);

        // ラベル：xpos
        WLabel lPX = new WLabel(Text.translatable("text.marumasigngui.inpx"));
        root.add(lPX, 0, 2, 2, 1);
        // フィールド：xpos
        WTextField inPX = new WTextField();
        root.add(inPX, 2, 2, 2, 1);
        // ラベル：ypos
        WLabel lPY = new WLabel(Text.translatable("text.marumasigngui.inpy"));
        root.add(lPY, 5, 2, 2, 1);
        // フィールド：ypos
        WTextField inPY = new WTextField();
        root.add(inPY, 7, 2, 2, 1);
        // ラベル：zpos
        WLabel lPZ = new WLabel(Text.translatable("text.marumasigngui.inpz"));
        root.add(lPZ, 10, 2, 2, 1);
        // フィールド：zpos
        WTextField inPZ = new WTextField();
        root.add(inPZ, 12, 2, 2, 1);

        // ラベル：xrot
        WLabel lRX = new WLabel(Text.translatable("text.marumasigngui.inrx"));
        root.add(lRX, 0, 4, 2, 1);
        // フィールド：xrot
        WTextField inRX = new WTextField();
        root.add(inRX, 2, 4, 2, 1);
        // ラベル：yrot
        WLabel lRY = new WLabel(Text.translatable("text.marumasigngui.inry"));
        root.add(lRY, 5, 4, 2, 1);
        // フィールド：yrot
        WTextField inRY = new WTextField();
        root.add(inRY, 7, 4, 2, 1);
        // ラベル：zrot
        WLabel lRZ = new WLabel(Text.translatable("text.marumasigngui.inrz"));
        root.add(lRZ, 10, 4, 2, 1);
        // フィールド：zrot
        WTextField inRZ = new WTextField();
        root.add(inRZ, 12, 4, 2, 1);

        // ラベル：width
        WLabel lWD = new WLabel(Text.translatable("text.marumasigngui.inwd"));
        root.add(lWD, 0, 6, 2, 1);
        // フィールド：width
        WTextField inWD = new WTextField();
        root.add(inWD, 2, 6, 2, 1);
        // ラベル：height
        WLabel lHG = new WLabel(Text.translatable("text.marumasigngui.inhg"));
        root.add(lHG, 5, 6, 2, 1);
        // フィールド：height
        WTextField inHG = new WTextField();
        root.add(inHG, 7, 6, 2, 1);

        // ボタン：copy line-by-line for multiplay
        WButton lineCopy = new WButton(Text.translatable("gui.marumasigngui.lineCopy"));
        lineCopy.setOnClick(() -> {
            List<String> tmp_a = MarumaSignGUIClient.utlGenLines(inURL.getText() + "|" + inPX.getText() + "|"
                    + inPY.getText() + "|" + inPZ.getText() + "|" + inHG.getText() + "|" + inWD.getText() + "|"
                    + inRX.getText() + "|" + inRY.getText() + "|" + inRZ.getText());
            while (tmp_a.size() < 4) {
                tmp_a.add("");
            }
            MarumaSignGUIClient.multiSave[0] = tmp_a.get(0);
            MarumaSignGUIClient.multiSave[1] = tmp_a.get(1);
            MarumaSignGUIClient.multiSave[2] = tmp_a.get(2);
            MarumaSignGUIClient.multiSave[3] = tmp_a.get(3);
            MinecraftClient.getInstance().setScreen(new CottonClientScreen(new CopyLineByLineGUI()));
        });
        root.add(lineCopy, 0, 11, 9, 1);

        // ボタン：copy command for singleplay
        WButton commandCopy = new WButton(Text.translatable("gui.marumasigngui.commandCopy"));
        commandCopy.setOnClick(() -> {
            List<String> tmp_a = MarumaSignGUIClient.utlGenLines(inURL.getText() + "|" + inPX.getText() + "|"
                    + inPY.getText() + "|" + inPZ.getText() + "|" + inHG.getText() + "|" + inWD.getText() + "|"
                    + inRX.getText() + "|" + inRY.getText() + "|" + inRZ.getText());
            while (tmp_a.size() < 8) {
                tmp_a.add("");
            }
            String tmp_s = getCommand(tmp_a);
            MinecraftClient.getInstance().setScreen(new CottonClientScreen(new GivecopyGUI(tmp_s)));
        });
        root.add(commandCopy, 10, 11, 10, 1);

        root.validate(this);
    }

    @NotNull
    private static String getCommand(List<String> tmp_a) {
        String tmp_s = "/give @p minecraft:oak_sign{BlockEntityTag:{front_text:{messages:['[\"" + tmp_a.get(0)
                + "\"]','[\"" + tmp_a.get(1) + "\"]','[\"" + tmp_a.get(2) + "\"]','[\"" + tmp_a.get(3);
        if (tmp_a.get(4).isEmpty()) {
            tmp_s += "\"]']}}}";
        } else {
            tmp_s += "\"]']},back_text:{messages:['[\"" + tmp_a.get(4) + "\"]','[\"" + tmp_a.get(5) + "\"]','[\""
                    + tmp_a.get(6) + "\"]','[\"" + tmp_a.get(7) + "\"]']}}}";
        }
        return tmp_s;
    }
}