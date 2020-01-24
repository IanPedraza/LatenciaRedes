package latenciaredes.Model;

import static latenciaredes.Model.CONSTANTS.*;

public class UnitsUtil {
    public static Double metersToKilometres(Double meters){
        return meters/METERS_TO_KILOMETERS_FACTOR_CONVERSION;
    }
    
    public static Double bytesToMegabits(Double bytes){
        return bytes*BYTES_TO_MEGABITS_FACTOR_CONVERSION;
    }
    
    public static Double gygabytesToBytes(Double gigabytes){
        return gigabytes*GYGABYTES_TO_BYTES_FACTOR_CONVERSION;
    }
    
    public static Double secondsToHours(Double seconds){
        return seconds/SECONDS_TO_HOURS_FACTOR_CONVERSION;
    }
    
}
