package by.bsu.fpmi.pasevina.listenit.utils;


import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;

public class CustomPasswordEncoder extends MessageDigestPasswordEncoder {

    public CustomPasswordEncoder(String algorithm) {
        super(algorithm);
    }
}
