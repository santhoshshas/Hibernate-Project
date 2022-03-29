package com.connection.OneToMany;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class FetchData {
	private Session session;
	public FetchData() 
	{
		System.out.println("creating session only 1 time...");
		session=Utility.getSession();
		System.out.println("session is created...");
	}
	void executeQuery() throws HibernateException
	{
		Query <Customers>query=session.createQuery("From Customers");
		List<Customers> c=query.getResultList();
		Iterator<Customers> itr1=c.iterator();
		while(itr1.hasNext())
		{
			Customers x=itr1.next();
			System.out.println("Customer Name: "+x.getName());
			System.out.println("Customer Area: "+x.getArea());
			List<Channels> p=x.getChannels();
			Iterator <Channels>itr2=p.iterator();
			while(itr2.hasNext())
			{
				Channels y=itr2.next();
				System.out.println("package name: "+y.getPackageName()+" "+"package cost:"+y.getPackageCost());
			}
		}
		session.close();
	}

	public static void main(String[] args) {
		{
			try 
			{
				FetchData f=new FetchData();
				f.executeQuery();
				System.out.println("Customer's channel package has been fetched..");
			}
			catch(HibernateException e) 
			{
				System.out.println(e);
			}
			catch(Exception d)
			{
				System.out.println(d);
			}
			}
		}
	}
