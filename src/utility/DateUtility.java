package utility;

import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * Created by Jason on 3/1/17.
 */
public class DateUtility {
    public static String getCurrentDate () {
        Date currentdate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        return simpleDateFormat.format(currentdate);
    }
}
