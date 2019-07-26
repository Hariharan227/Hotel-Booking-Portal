import java.io.Serializable;

public class SingleRoom extends Room implements Serializable
{
	SingleRoom(int cost,int total,String amenity1,String amenity2,String amenity3,String amenity4,String amenity5,String amenity6,double rating,int raters)
	{	super(cost,total,amenity1,amenity2,amenity3,amenity4,amenity5,amenity6,rating,raters);
		capacity=1;
	}
	SingleRoom()
	{}
}
