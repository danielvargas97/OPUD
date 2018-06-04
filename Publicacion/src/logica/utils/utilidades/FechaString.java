package logica.utils.utilidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FechaString {
	
	public static String getFechaString(Date fecha) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");		
		return df.format(fecha);
	}
	
	public static Date parseDate(String day, String month, String year) {
		String date = year+"-"+month+"-"+day;
		Date d;
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			d = df.parse(date);
		}
		catch(Exception e){
			e.printStackTrace();
			d = new Date();
			
		}
		return d;		
		
	}
	
	
}
