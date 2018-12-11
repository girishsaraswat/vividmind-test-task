package com.vividmind.rest.security.token;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author Girish Sarashwat
 */
@Component
public class TokenProvider {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
    private static final String UTF = "UTF-8";
    private static byte[] key = { 0x74, 0x68, 0x69, 0x73, 0x49, 0x73, 0x41,
            0x53, 0x65, 0x63, 0x72, 0x65, 0x74, 0x4b, 0x65, 0x79 };

    public  String generateTokenByUserename(String id,String username)  {
        String encodedToken =null;
        try {
            String token = "userid~"+id+"|username~"+username+
                    "|tokenTime~"+simpleDateFormat.format(new Date());
            String encryptedToken =TokenProvider.encrypt(token);
            encodedToken = URLEncoder.encode(encryptedToken, UTF);

        } catch (Exception ex) {

        }
        return encodedToken;
    }


    static String encrypt(String strToEncrypt){
        String encryptedString =null;
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            encryptedString = Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes()));

        } catch (Exception e) {

        }
        return encryptedString;
    }
    static String decrypt(String strToDecrypt)  {
        String decryptedString=null;
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            decryptedString = new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt)));

        } catch (Exception e) {

        }
        return decryptedString;
    }
    public  Map<String, String> decryptToken(String token)
    {
        Map<String, String> map = new HashMap<String, String>();
        try {

            String decodedToken = URLDecoder.decode(token, UTF);
            String decryptedToken = decrypt(decodedToken);
            StringTokenizer sz = new StringTokenizer(decryptedToken, "|");
            while (sz.hasMoreTokens()) {
                String s = sz.nextToken();
                String[] keyVal = s.split("~");
                map.put(keyVal[0], keyVal[1]);
            }
            map.put("isTokenValid", "true");
        } catch (Exception ex) {
        }
        return map;

    }

    public  Boolean isTokenValidated(String deceptedString) {

      boolean  reFalse = true;
        try
        {
            Map<String, String> tokenMap = decryptToken(deceptedString);
            Date tokenTime =simpleDateFormat.parse(tokenMap.get("tokenTime"));
            Date currentDate = new Date();
            int tokenvalidMinutes=0;
            tokenvalidMinutes = 20;
            Date tokenValidTime= DateUtils.addMinutes(tokenTime, tokenvalidMinutes);
            if(tokenValidTime.before(currentDate))
            {
                reFalse = false;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();

            reFalse = false;
        }
        return reFalse;
    }

    public static void main(String[] args) {
        System.out.println(new TokenProvider().decryptToken("Xw8B9WUumU0Hvnpa3PEtnUg82ZoLebsvx5F2V2QoHN5%2BaBWnQwC4BGztid712mftaRu8eup5WkC%2F5LRw5L5dQQ%3D%3D"));
    }

}
