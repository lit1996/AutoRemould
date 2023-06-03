package com.lit.util;

import javax.sound.sampled.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.io.File;

public class GameMusic {

    public static void main(String[] args) {
        Play();
    }
    static Boolean playFlag = null;
    public static void Play() {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("src/main/resources/good_day.wav"));
            AudioFormat aif = ais.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, aif);
            SourceDataLine sdl = (SourceDataLine) AudioSystem.getLine(info);
            sdl.open(aif);
            sdl.start();
            FloatControl fc=(FloatControl)sdl.getControl(FloatControl.Type.MASTER_GAIN);
            double value=0.2d;
            float dB = (float)
                    (Math.log(value==0.0?0.0001:value)/Math.log(10.0)*20.0);
            fc.setValue(dB);
            playFlag = true;
            int nByte = 0;
            int writeByte = 0;
            final int SIZE=1024*64;
            byte[] buffer = new byte[SIZE];
            while (nByte != -1 && playFlag) {
                nByte = ais.read(buffer, 0, SIZE);
                sdl.write(buffer, 0, nByte);
            }
            sdl.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void Stop() {
        playFlag = false;
    }
}
