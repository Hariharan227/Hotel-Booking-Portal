import java.io.Serializable;

public class Date implements Serializable
{
	int day, year,month;
	Date(int day,int month,int year)
	{
		this.day=day;
		this.month=month;
		this.year=year;
	}
}
