package com.lit;

import com.lit.util.CheckUtil;
import com.lit.util.GameMusic;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class AutoClickUtil {

    static Robot robot = null;

    static Clipboard sysClip = null ;

    static {
        try {
            robot = new Robot();
            sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void autoRemould() throws Exception {
        while (true) {
            // 移动到改造石位置
            robot.mouseMove(140,360);
            robot.delay(100);
            // 按下鼠标右键
            robot.mousePress(InputEvent.BUTTON3_MASK);
            // 松开鼠标右键
            robot.mouseRelease(InputEvent.BUTTON3_MASK);
            // 移动到装备位置
            robot.mouseMove(450,600);
            robot.delay(100);
            // 模拟鼠标按下左键
            robot.mousePress(InputEvent.BUTTON1_MASK);
            // 模拟鼠标松开左键
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            robot.delay(100);
            // 模拟复制
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(100);
            // 获取当前剪切板内容
            Transferable clipTf = sysClip.getContents(null);
            if (clipTf == null) {
                throw new Exception("未获取到获取剪切板");
            }
            // 检查内容是否是文本类型
            if (!clipTf.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                throw new Exception("剪切板内容非文字");
            }
            String copyString = (String) clipTf.getTransferData(DataFlavor.stringFlavor);
            String str = Key.key;
            String[] keyArray = str.trim().split(",");
            System.out.println(copyString);
            for (String s : keyArray) {
                if (copyString.contains(s)) {
                    System.out.println("成功");
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            GameMusic.Play();
                        }
                    });
                    thread.start();
                    return;
                }
            }
        }

    }

    public static void leftClick() {
        while (true){
            //模拟鼠标按下左键
            robot.mousePress(InputEvent.BUTTON1_MASK);
            //模拟鼠标松开左键
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
        }
    }

    public static void shiftAndLeftClick() {
        //模拟键盘按下shift
        robot.keyPress(KeyEvent.VK_SHIFT);
        //模拟鼠标按下左键
        robot.mousePress(InputEvent.BUTTON1_MASK);
        //模拟鼠标松开左键
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        //模拟键盘按下shift
        robot.keyRelease(KeyEvent.VK_SHIFT);
    }

    public static void useMark() throws Exception {
        // 使用改造的方法
        // 按下shift不放
        robot.keyPress(KeyEvent.VK_SHIFT);
        boolean exist = false;
        // 循环点击左键
        while (!exist) {
            try {
                long start1 = System.currentTimeMillis();
                //模拟鼠标按下左键
                robot.mousePress(InputEvent.BUTTON1_MASK);
                //模拟鼠标松开左键
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
                long end1 = System.currentTimeMillis();
                System.out.println("1耗时："+ (end1-start1)+"毫秒");
                Thread.sleep(1000);
                long start = System.currentTimeMillis();
//                // 扫描内容
//                BufferedImage bufferedImage = ScreenCaptureUtil.getInstance().captureScreen();
//                // 读图片
//                String read = ReadChar.read(bufferedImage);
//                // 识别文字
//                exist = StringUtil.isExist(read);
                long end = System.currentTimeMillis();
                System.out.println("2耗时："+ (end-start) +"毫秒");
                System.out.println();
                System.out.println();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.mouseMove(100,100);
    }
}
