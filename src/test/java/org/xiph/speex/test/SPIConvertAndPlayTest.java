package org.xiph.speex.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.xiph.speex.spi.SpeexEncoding;
import org.xiph.speex.spi.SpeexFileFormatType;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SPIConvertAndPlayTest {

    private void play(AudioInputStream pcmAis) throws LineUnavailableException, IOException {
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, pcmAis.getFormat());
        SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
        line.open(pcmAis.getFormat());
        line.start();

        byte[] buf = new byte[1024 * 4];
        while (true) {
            int r = pcmAis.read(buf, 0, buf.length);
            if (r < 0) {
                break;
            }
            line.write(buf, 0, r);
        }
        line.drain();
        line.stop();
        line.close();
    }

    @Test
    @DisplayName("wav -> spx, save file")
    public void convertWAVToSPXAndSave() throws UnsupportedAudioFileException, IOException {
        File inFile = new File("src/test/resources/fbodemo1.wav");
        System.out.println("inFile: " + inFile.getAbsolutePath());
        AudioInputStream wavAis = AudioSystem.getAudioInputStream(inFile);
        System.out.println("inStream: " + wavAis);
        AudioFormat inAudioFormat = wavAis.getFormat();
        System.out.println("inFormat: " + inAudioFormat);
        AudioInputStream spxAis = AudioSystem.getAudioInputStream(SpeexEncoding.SPEEX_Q10, wavAis);
        File outFile = new File("test.spx");
        if (!outFile.exists()) Assertions.assertTrue(outFile.createNewFile());
        System.out.println("outFile: " + outFile.getAbsolutePath());
        System.out.println("inStream: " + spxAis);
        AudioFormat outAudioFormat = spxAis.getFormat();
        System.out.println("inFormat: " + outAudioFormat);
        AudioSystem.write(spxAis, SpeexFileFormatType.SPEEX, outFile);
        spxAis.close();
    }

    @Test
    @DisplayName("spx -> pcm, play via SPI")
    public void convertSPXToPCMAndPlay() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("src/test/resources/fbodemo1.spx");
        System.out.println("inFile: " + file.getAbsolutePath());
        AudioInputStream spxAis = AudioSystem.getAudioInputStream(file);
        System.out.println("inStream: " + spxAis);
        AudioFormat inAudioFormat = spxAis.getFormat();
        System.out.println("inFormat: " + inAudioFormat);
        AudioFormat outAudioFormat = new AudioFormat(
                inAudioFormat.getSampleRate(),
                16,
                inAudioFormat.getChannels(),
                true,
                false);

        assertTrue(AudioSystem.isConversionSupported(outAudioFormat, inAudioFormat));

        AudioInputStream pcmAis = AudioSystem.getAudioInputStream(outAudioFormat, spxAis);
        System.out.println("outStream: " + pcmAis);
        System.out.println("outFormat: " + pcmAis.getFormat());

        play(pcmAis);
        pcmAis.close();
    }

    @Test
    @DisplayName("ogg -> pcm, play via SPI")
    public void convertOGGSPXToPCMAndPlay() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("src/test/resources/fbodemo1_speex.ogg");
        System.out.println("inFile: " + file.getAbsolutePath());
        AudioInputStream spxAis = AudioSystem.getAudioInputStream(file);
        System.out.println("inStream: " + spxAis);
        AudioFormat inAudioFormat = spxAis.getFormat();
        System.out.println("inFormat: " + inAudioFormat);
        AudioFormat outAudioFormat = new AudioFormat(
                inAudioFormat.getSampleRate(),
                16,
                inAudioFormat.getChannels(),
                true,
                false);

        assertTrue(AudioSystem.isConversionSupported(outAudioFormat, inAudioFormat));

        AudioInputStream pcmAis = AudioSystem.getAudioInputStream(outAudioFormat, spxAis);
        System.out.println("outStream: " + pcmAis);
        System.out.println("outFormat: " + pcmAis.getFormat());

        play(pcmAis);
        pcmAis.close();
    }

}
