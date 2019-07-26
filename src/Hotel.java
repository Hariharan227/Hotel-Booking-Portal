import java.io.Serializable;

public class Hotel implements Serializable
{
	private String name,location;
	SingleRoom small;
	DoubleRoom medium;
	FamilyRoom large;
	Hotel(String name,String location,SingleRoom small,DoubleRoom medium,FamilyRoom large)
	{
		this.name=name;
		this.location=location;
		this.small=small;
		this.medium=medium;
		this.large=large;
	}
	String get_name()
	{
		return name;
	}
	String get_location()
	{
		return location;
	}
}
