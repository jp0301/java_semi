public class Customer
{
	public static void main(String[] args)
	{
		try
		{
			Manager.readCoinData();
			Machine.startMenu();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		


	}

}