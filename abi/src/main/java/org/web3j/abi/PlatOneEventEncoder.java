package org.web3j.abi;


import org.web3j.abi.datatypes.Event;
import org.web3j.crypto.Hash;
import org.web3j.utils.Numeric;


public class PlatOneEventEncoder {

    private PlatOneEventEncoder() { }

    public static String encode(Event event) {
        String methodSignature = buildMethodSignature(event.getName());
        return buildEventSignature(methodSignature);
    }

    private static String buildMethodSignature(String methodName) {
        StringBuilder result = new StringBuilder();
        result.append(methodName);
        return result.toString();
    }

    private static String buildEventSignature(String methodSignature) {
        byte[] input = methodSignature.getBytes();
        byte[] hash = Hash.sha3(input);
        return Numeric.toHexString(hash);
    }
}

