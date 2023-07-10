package Utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class Utiles {
    
    public static Timestamp now(){
        java.util.Date currentDate = new java.util.Date();
        Timestamp timestamp = new Timestamp(currentDate.getTime());
        return timestamp;           
    }
    
    public static String fechaAtual() {
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        ZoneId zonaHoraria = ZoneId.of("America/La_Paz");
        ZonedDateTime fechaHoraZonaHoraria = fechaHoraActual.atZone(zonaHoraria);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        String fechaHoraFormateada = fechaHoraZonaHoraria.format(formato);
        return fechaHoraFormateada;
    }
    
    public static Date StringToDate(String date)throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd");
        format.setLenient(false);
        Date dt = new Date(format.parse(date).getTime());
        return dt;
    }
    
    public static String TimestampToString(Timestamp date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
        String timestampString = dateFormat.format(date);
        return timestampString;
    }
    
    public static String DateSQLToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = dateFormat.format(date);
        return dateString;
    }
    
    
    
}
