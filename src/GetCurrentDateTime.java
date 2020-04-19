import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

 
 
public class GetCurrentDateTime 
{
	public String getDate() 
	{			
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
	    return dateFormat.format(date); 	
	}
}