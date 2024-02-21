package io.github.fhrk_78.msigngui.client;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.apache.commons.lang3.StringUtils;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarumaSignGUIClient implements ClientModInitializer {
    public static String[] multiSave = new String[4];

    public static List<String> utlGenLines(String tmp_s) {
        return splitByLength(tmp_s);
    }

    private static List<String> splitByLength(String s) {
        List<String> list = new ArrayList<>();
        if (!StringUtils.isEmpty(s)) {
            Matcher m = Pattern.compile("[\\s\\S]{1,15}").matcher(s);
            while (m.find()) {
                list.add(m.group());
            }
        }
        return list;
    }

    @Override
    public void onInitializeClient() {
        // multiSave初期化
        multiSave[0] = "";
        multiSave[1] = "";
        multiSave[2] = "";
        multiSave[3] = "";

        // キーバインドの作成
        KeyBinding nCKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.marumasigngui.newcreatekey",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_N,
                "key.category.marumasigngui.msgct"
        ));
        KeyBinding cLKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.marumasigngui.copylinekey",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_B,
                "key.category.marumasigngui.msgct"
        ));

        // クライアントティックイベントにキーバインドの処理を登録
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (nCKeyBinding.wasPressed()) {
                MinecraftClient.getInstance().setScreen(new CottonClientScreen(new GenGUI()));
            }
        });
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (cLKeyBinding.wasPressed()) {
                MinecraftClient.getInstance().setScreen(new CottonClientScreen(new CopyLineByLineGUI()));
            }
        });
    }
}
