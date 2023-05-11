# Java Implementation of Speex
This is a fork of [JSpeex](https://github.com/SourceUtils/jspeex).

This library is a Java port of the Speex speech codec (Open Source/Free Software patent-free audio compression format designed for speech). It provides both the decoder and the encoder in pure Java, as well as a JavaSound SPI. The current version of this library is based on the code from Speex 1.0.5.

## Add the library to your project (gradle)
1. Add the Maven Central repository (if not exist) to your build file:
```groovy
repositories {
    ...
    mavenCentral()
}
```

2. Add the dependency:
```groovy
dependencies {
    ...
    implementation 'com.tianscar.javasound:javasound-speex:0.9.8'
}
```

## Usage
[Tests and Examples](/src/test/java/org/xiph/speex/test)  
[Command-line interfaces](/src/test/java/org/xiph/speex/cli)

Note you need to download test audios [here](https://github.com/Tianscar/fbodemo1) and put them to /src/test/resources to run the test code properly!

## License
[BSD 3-Clause](/LICENSE)
