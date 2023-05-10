/******************************************************************************
 *                                                                            *
 * Copyright (c) 1999-2004 Wimba S.A., All Rights Reserved.                   *
 *                                                                            *
 * COPYRIGHT:                                                                 *
 *      This software is the property of Wimba S.A.                           *
 *      This software is redistributed under the Xiph.org variant of          *
 *      the BSD license.                                                      *
 *      Redistribution and use in source and binary forms, with or without    *
 *      modification, are permitted provided that the following conditions    *
 *      are met:                                                              *
 *      - Redistributions of source code must retain the above copyright      *
 *      notice, this list of conditions and the following disclaimer.         *
 *      - Redistributions in binary form must reproduce the above copyright   *
 *      notice, this list of conditions and the following disclaimer in the   *
 *      documentation and/or other materials provided with the distribution.  *
 *      - Neither the name of Wimba, the Xiph.org Foundation nor the names of *
 *      its contributors may be used to endorse or promote products derived   *
 *      from this software without specific prior written permission.         *
 *                                                                            *
 * WARRANTIES:                                                                *
 *      This software is made available by the authors in the hope            *
 *      that it will be useful, but without any warranty.                     *
 *      Wimba S.A. is not liable for any consequence related to the           *
 *      use of the provided software.                                         *
 *                                                                            *
 * Class: TestJSpeexSPI.java                                                  *
 *                                                                            *
 * Author: Marc GIMPEL                                                        *
 *                                                                            *
 * Date: 25th March 2005                                                      *
 *                                                                            *
 ******************************************************************************/

/* $Id$ */

package org.xiph.speex.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.xiph.speex.spi.SpeexEncoding;
import org.xiph.speex.spi.SpeexFileFormatType;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;

import static org.xiph.speex.test.Utils.assertTrue;

/**
 * JUnit Tests for JSpeex SPI
 *
 * @author Karstian Lee (tianscar@protonmail.com)
 * @author Marc Gimpel, Wimba S.A. (mgimpel@horizonwimba.com)
 * @version $Revision$
 */
public class JSpeexSPITest {

    @Test
    @DisplayName("Whether Speex File Format supported by JavaSound")
    public void testFileSupport() {
        assertTrue("Speex File Format not supported by JavaSound",
                AudioSystem.isFileTypeSupported(SpeexFileFormatType.SPEEX));
    }

    @Test
    @DisplayName("Whether conversion to Speex supported by JavaSound")
    public void testConversionSupport() {
        assertTrue("Conversion to Speex Q0 not supported by JavaSound",
                AudioSystem.isConversionSupported(SpeexEncoding.SPEEX_Q0,
                        new AudioFormat(8000, 16, 1, true, false)));

        assertTrue("Conversion to Speex Q1 not supported by JavaSound",
                AudioSystem.isConversionSupported(SpeexEncoding.SPEEX_Q1,
                        new AudioFormat(8000, 16, 1, true, false)));
        assertTrue("Conversion to Speex Q2 not supported by JavaSound",
                AudioSystem.isConversionSupported(SpeexEncoding.SPEEX_Q2,
                        new AudioFormat(8000, 16, 1, true, false)));
        assertTrue("Conversion to Speex Q3 not supported by JavaSound",
                AudioSystem.isConversionSupported(SpeexEncoding.SPEEX_Q3,
                        new AudioFormat(8000, 16, 1, true, false)));
        assertTrue("Conversion to Speex Q4 not supported by JavaSound",
                AudioSystem.isConversionSupported(SpeexEncoding.SPEEX_Q4,
                        new AudioFormat(8000, 16, 1, true, false)));
        assertTrue("Conversion to Speex Q5 not supported by JavaSound",
                AudioSystem.isConversionSupported(SpeexEncoding.SPEEX_Q5,
                        new AudioFormat(8000, 16, 1, true, false)));
        assertTrue("Conversion to Speex Q6 not supported by JavaSound",
                AudioSystem.isConversionSupported(SpeexEncoding.SPEEX_Q6,
                        new AudioFormat(8000, 16, 1, true, false)));
        assertTrue("Conversion to Speex Q7 not supported by JavaSound",
                AudioSystem.isConversionSupported(SpeexEncoding.SPEEX_Q7,
                        new AudioFormat(8000, 16, 1, true, false)));
        assertTrue("Conversion to Speex Q8 not supported by JavaSound",
                AudioSystem.isConversionSupported(SpeexEncoding.SPEEX_Q8,
                        new AudioFormat(8000, 16, 1, true, false)));
        assertTrue("Conversion to Speex Q9 not supported by JavaSound",
                AudioSystem.isConversionSupported(SpeexEncoding.SPEEX_Q9,
                        new AudioFormat(8000, 16, 1, true, false)));
        assertTrue("Conversion to Speex Q10 not supported by JavaSound",
                AudioSystem.isConversionSupported(SpeexEncoding.SPEEX_Q10,
                        new AudioFormat(8000, 16, 1, true, false)));
        assertTrue("Conversion from Speex not supported by JavaSound",
                AudioSystem.isConversionSupported(AudioFormat.Encoding.PCM_SIGNED,
                        new AudioFormat(SpeexEncoding.SPEEX, 8000, -1, 1, -1, -1, false)));
    }

}
