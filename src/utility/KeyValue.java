package utility;

import java.util.Random;

/**
 * Created by Jason on 2/20/17.
 */
public class KeyValue {
    public static String getKeyValue(){
        String code = "123456789qwertyuipasdfghjklzxcvbnmQWERTYUIPASDGFHJKLZXCVBNM";
        StringBuffer keyCode = new StringBuffer("");
        for (int i = 0; i <= 10; i++){
            char tempChar = code.charAt((int)(new Random().nextInt(58)));
            keyCode.append(tempChar);
        }
        return keyCode.toString();
    }
}
