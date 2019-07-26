import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			FileInputStream f=new FileInputStream("Hotel Data");
			ObjectInputStream o=new ObjectInputStream(f);
			try
			{
				Hotel t;
				int k=3;
				Connection connect=null;
				connect=UserDatabase.dbConnector();
				String query="insert into Hotel (HotelName,Location,SingleRoomCost,SingleRoomCapacity,DoubleRoomCost,DoubleRoomCapacity,FamilyRoomCost,FamilyRoomCapacity,Amenity1,Amenity2,Amenity3,Amenity4,Amenity5,Amenity6,Rating,RaterCount) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pst=connect.prepareStatement(query);
				while(((t=(Hotel)o.readObject())!=null)&&k>0)
				{
					if(!(t.get_location().equals("New Delhi")))
						continue;
					pst.setString(1,t.get_name());
					pst.setString(2,t.get_location());
					pst.setInt(3,t.small.cost);
					pst.setInt(4,t.small.total);
					pst.setInt(5,t.medium.cost);
					pst.setInt(6,t.medium.total);
					pst.setInt(7,t.large.cost);
					pst.setInt(8,t.large.total);
					pst.setString(9,t.small.amenity1);
					pst.setString(10,t.small.amenity2);
					pst.setString(11,t.small.amenity3);
					pst.setString(12,t.small.amenity4);
					pst.setString(13,t.small.amenity5);
					pst.setString(14,t.small.amenity6);
					pst.setDouble(15,t.small.rating);
					pst.setInt(16,t.small.raters);
					pst.execute();
					System.out.println("Added");
					k--;
				}
				pst.close();
			}
			catch(Exception ae) {}
			finally
			{
				o.close();
			}
			
		}
		catch(Exception ae)
		{
			System.out.println(ae.toString());
		}
	}

}
