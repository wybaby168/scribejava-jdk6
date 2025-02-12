package com.github.scribejava.core.pkce;

import com.github.scribejava.core.java8.Base64;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public enum PKCECodeChallengeMethod {
    S256 {
        private final Base64.Encoder base64Encoder = Base64.getUrlEncoder().withoutPadding();

        @Override
        public String transform2CodeChallenge(String codeVerifier) throws NoSuchAlgorithmException {
            return base64Encoder.encodeToString(
                        MessageDigest.getInstance("SHA-256")
                                .digest(codeVerifier.getBytes(new sun.nio.cs.US_ASCII())));
        }
    },
    PLAIN {
        @Override
        public String transform2CodeChallenge(String codeVerifier) {
            return codeVerifier;
        }
    };

    public abstract String transform2CodeChallenge(String codeVerifier) throws NoSuchAlgorithmException;
}
