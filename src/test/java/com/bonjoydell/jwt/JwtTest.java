package com.bonjoydell.jwt;

import com.auth0.jwt.JWTSigner;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jon.boydell on 12/02/2015.
 */
public class JwtTest {

    @Test
    public void test() throws Exception
    {
        JWTSigner signer = new JWTSigner("password");
        Map<String, Object> object = new HashMap<String, Object>();
        object.put("clientId", "jon.boydell@akqa.com");
        System.out.println(signer.sign(object));
    }

    @Test
    public void something() throws Exception
    {
        String string = new String("VndPcnpNbDVTc1hrWkdLVjdzWHFncWJuV2RZPQ==");
        String encoded = new String(Base64.encodeBase64(string.getBytes("UTF-8")), "UTF-8");
        System.out.println(string);
        System.out.println(encoded);

        StringBuilder base64encoded = new StringBuilder(encoded);
        int i;
        while((i = base64encoded.lastIndexOf("=")) > 0)
        {
            base64encoded.deleteCharAt(i);
        }

        System.out.println(base64encoded);

        System.out.println(new String(Base64.decodeBase64(encoded)));
        System.out.println(new String(Base64.decodeBase64(base64encoded.toString())));
    }
}
