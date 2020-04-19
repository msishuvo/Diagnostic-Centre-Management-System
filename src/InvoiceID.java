
public class InvoiceID 
{
	public String generateInvoiceNum() 
	{		
		String invoice="";
		invoice= invoice+(int)(1111+Math.random()*8888);
		return invoice;						
	}
}
