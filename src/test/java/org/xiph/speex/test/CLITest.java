package org.xiph.speex.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.xiph.speex.cli.JSpeexEnc;

import java.io.IOException;

public class CLITest {

    @Test
    @DisplayName("wav -> spx")
    public void encode() throws IOException {
        JSpeexEnc.main(new String[] {"--stereo", "--quality", "10", "src/test/resources/fbodemo1.wav", "fbodemo1.spx" });
    }

}
