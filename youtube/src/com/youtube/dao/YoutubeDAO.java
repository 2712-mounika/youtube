package com.youtube.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.youtube.entity.YoutubeEmployee;

public class YoutubeDAO implements YoutubeDAOInterface{
	private YoutubeDAO() {}

	@Override
	public int createProfileDAO(YoutubeEmployee ye) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			Context initCtx = new InitialContext();
			DataSource ds=(DataSource)initCtx.lookup("java:/youtube"); 
			
			Connection con=ds.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into YoutubeEmployee values(?,?,?)");
			ps.setString(1, ye.getName());
			ps.setString(2, ye.getEmail());
			ps.setString(3, ye.getPassword());
			i=ps.executeUpdate();
			System.out.println(i);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	public static YoutubeDAOInterface createDaoObject() {
		// TODO Auto-generated method stub
		return new YoutubeDAO();
	}
	}