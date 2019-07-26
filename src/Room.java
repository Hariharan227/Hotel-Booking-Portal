import java.io.Serializable;
import java.util.*;

public class Room implements Serializable
{
	String amenity1,amenity2,amenity3,amenity4,amenity5,amenity6;
	int capacity,cost,total,raters;
	double rating;
	Vector<Date> available;
	Room(int cost,int total,String amenity1,String amenity2,String amenity3,String amenity4,String amenity5,String amenity6,double rating,int raters)
	{
		this.cost=cost;
		this.total=total;
		this.amenity1=amenity1;
		this.amenity2=amenity2;
		this.amenity3=amenity3;
		this.amenity4=amenity4;
		this.amenity5=amenity5;
		this.amenity6=amenity6;
		this.rating=rating;
		this.raters=raters;
		available=new Vector<Date>();
	}
	Room()
	{}
}
