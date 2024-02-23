package io.github.fhrk_78.msigngui.client;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import io.github.fhrk_78.msigngui.client.gui.CopyLineByLineGUI;
import io.github.fhrk_78.msigngui.client.gui.GenGUI;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.apache.commons.lang3.StringUtils;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarumaSignGUIClient implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("marumasigngui");

    @Override
    public void onInitializeClient() {
        // multiSave初期化
        multiSave[0] = "";
        multiSave[1] = "";
        multiSave[2] = "";
        multiSave[3] = "";
        multiSave[4] = "";
        multiSave[5] = "";
        multiSave[6] = "";
        multiSave[7] = "";
        LOGGER.info("Multisave Initialised");

        // キーバインドの作成
        KeyBinding nCKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.marumasigngui.newcreatekey",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_N,
                "key.category.marumasigngui.msgct"
        ));
        LOGGER.info("NewCreate KeyBind Initialised");

        KeyBinding cLKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.marumasigngui.copylinekey",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_B,
                "key.category.marumasigngui.msgct"
        ));
        LOGGER.info("MultiLineCopy KeyBind Initialised");

        // クライアントティックイベントにキーバインドの処理を登録
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (nCKeyBinding.wasPressed()) {
                MinecraftClient.getInstance().setScreen(new CottonClientScreen(new GenGUI()));
            }
        });
        LOGGER.info("NewCreate KeyBind Registered");
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (cLKeyBinding.wasPressed()) {
                MinecraftClient.getInstance().setScreen(new CottonClientScreen(new CopyLineByLineGUI()));
            }
        });
        LOGGER.info("MultiLineCopy KeyBind Registered");
    }

    public static String[] multiSave = new String[8];

    public static List<String> utlGenLines(String tmp_s) {
        return splitByLength(tmp_s);
    }

    public static List<String> splitByLength(String s) {
        List<String> list = new ArrayList<>();
        if (!StringUtils.isEmpty(s)) {
            Matcher m = Pattern.compile("[\\s\\S]{1,15}").matcher(s);
            while (m.find()) {
                list.add(m.group());
            }
        }
        return list;
    }

    public static String getShortURL(String burl) {
        String url = "https://is.gd/create.php?format=simple&url=" + URLEncoder.encode(burl, StandardCharsets.UTF_8);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        try {
            HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
            if(res.statusCode() == 200) {
                return res.body();
            }
        } catch (IOException | InterruptedException ex) {
            LOGGER.error(ex.toString());
        }
        return "!E_";
    }

    public static void copyString(String tmp_s) {
        Keyboard keyboard = new Keyboard(MinecraftClient.getInstance());
        keyboard.setClipboard(tmp_s);
    }
}
