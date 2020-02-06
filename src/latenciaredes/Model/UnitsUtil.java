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
    
    public static String secondsToHoursFormat(Double seconds){
        Double h = Math.floor(seconds / 3600);
        Double m = Math.floor((seconds % 3600) / 60);
        Double s = Math.floor(seconds % 60);
        
        return String.format("%02.0f:%02.0f:%02.0f", h, m, s);
    }    
}
