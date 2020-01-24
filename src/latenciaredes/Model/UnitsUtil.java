package latenciaredes.Model;

import static latenciaredes.Model.CONSTANTS.*;

public class UnitsUtil {
    public static Double metersToKilometres(Double meters){
        return meters/METERS_TO_KILOMETERS_FACTOR_CONVERSION;
    }
    
    public static Double bytesToMegabits(Double bytes){
        return bytes*0.000008;
    }
    
    public static Double gygabytesToMegabits(Double gigabytes){
        return gigabytes*8000;
    }
    
    public static Double secondsToHours(Double seconds){
        return seconds/SECONDS_TO_HOURS_FACTOR_CONVERSION;
    }
    
}
