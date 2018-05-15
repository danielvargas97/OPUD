package logica.publicacion.publicaciones;

import java.text.DateFormat;
import java.util.Date;

public class FechaString {
	
	public static String getFechaString(Date fecha) {
		DateFormat df = DateFormat.getInstance();
		return df.format(fecha);
	}
}
