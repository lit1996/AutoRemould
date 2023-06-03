package com.lit;

import com.lit.util.CheckUtil;
import com.lit.util.GameMusic;
import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class KeyboardListenerUtil {

    public static void initKeyboardListener() {
        // 第一步：注册热键，热键标识，组合键（shift），主要热键D
        JIntellitype.getInstance().registerHotKey(1, 0, 119); // F8

        JIntellitype.getInstance().registerHotKey(2, 0, 120); // F9

        JIntellitype.getInstance().registerHotKey(3, 0, 121); // F10

        JIntellitype.getInstance().registerHotKey(4, JIntellitype.MOD_SHIFT, (int) 'D');

//        JIntellitype.getInstance().registerHotKey(2, JIntellitype.MOD_SHIFT, (int) 'D');

        JIntellitype.getInstance().registerHotKey(5,
                JIntellitype.MOD_SHIFT + JIntellitype.MOD_CONTROL, (int) 'U');

        // 第一个参数是热键的标识，int类型，第二个参数是控制键等，如shift，ctrl等，也是int，第三个是ABCDE....等字母，第二个参数为0则表示不需要控制键。

        // 添加热键监听器
        // 第二步：添加热键监听器
        JIntellitype.getInstance().addHotKeyListener(new HotkeyListener() {
            public void onHotKey(int markCode) {
                try {
                    switch (markCode) {
                        case 1:
                            System.out.println("F8按下");
                            AutoClickUtil.autoRemould();
                            break;
                        case 2:
                            System.out.println("F9按下");
                            System.exit(1);
                            break;
                        case 3:
                            System.out.println("F10按下");
                            GameMusic.Stop();
                            break;
                    }
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        });
    }
}
