package com.connection.OneToMany;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData 
{
	private Session session;
	public StoreData() 
	{
	session=Utility.getSession();
	Transaction t=session.beginTransaction();
	}
			void storeValues()throws HibernateException
			{
		
		Channels ch1=new Channels();
		ch1.setPackageName("Kmax");
		ch1.setChannelsCount(200);
		ch1.setPackageCost(300);
		
		Channels ch2=new Channels();
		ch2.setPackageName("Ktamil");
		ch2.setChannelsCount(180);
		ch2.setPackageCost(250);
		
		Channels ch3=new Channels();
		ch3.setPackageName("BasicPack2");
		ch3.setChannelsCount(140);
		ch3.setPackageCost(200);
		
		ArrayList<Channels>customer1=new ArrayList<Channels>();
		customer1.add(ch1);
		
		ArrayList<Channels>customer2=new ArrayList<Channels>();
		customer2.add(ch2);
		
		ArrayList<Channels>customer3=new ArrayList<Channels>();
		customer3.add(ch3);
		
		Customers ct1=new Customers();
		ct1.setArea("NadarSt");
		ct1.setBoxNo(10083700736L);
		ct1.setName("Murugesan");
		ct1.setPhnNo(9600304723L);
		ct1.setChannels(customer1);
		
		Customers ct2=new Customers();
		ct2.setArea("Sellur");
		ct2.setBoxNo(10083700824L);
		ct2.setName("Kaliyappan");
		ct2.setPhnNo(9320374662L);
		ct2.setChannels(customer2);
		
		Customers ct3=new Customers();
		ct3.setArea("NandukulamSt");
		ct3.setBoxNo(10083700935L);
		ct3.setName("Suresh");		
		ct3.setPhnNo(9600368317L);
		ct3.setChannels(customer3);
		
		session.save(ct1);
		session.save(ct2);
		session.save(ct3);
		session.getTransaction().commit();
		session.close();
}
			public static void main(String[] args) 
			{	
			try 
			{
			StoreData s1=new StoreData();
			s1.storeValues();
			System.out.println("Customers' purchases has been entered");
			} 
			catch (HibernateException e) 
			{
			System.out.println(e);
			}
			catch(Exception d)
			{	
			System.out.println(d);
			}		
			}
			}

