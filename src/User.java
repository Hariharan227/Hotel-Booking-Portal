import java.io.Serializable;

public class User implements Serializable
{
	private String name, address, username, password, mail;
	Date DOB,checkIn,checkOut;
	String hotel;
	int book_ref;
	private double amount;
	User(String name,String address,String username,String password,String mail,int day,int month,int year)
	{
		DOB=new Date(day,month,year);
		this.name=name;
		this.address=address;
		this.mail=mail;
		this.username=username;
		this.password=password;
		book_ref=0;
		hotel="";
	}
	String get_name()
	{
		return name;
	}
	String get_address()
	{
		return address;
	}
	String get_mail()
	{
		return mail;
	}
	String get_username()
	{
		return username;
	}
	String get_password()
	{
		return password;
	}
	Date get_DOB()
	{
		return DOB;
	}
}
