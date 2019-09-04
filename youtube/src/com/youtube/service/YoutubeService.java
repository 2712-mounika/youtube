package com.youtube.service;

import com.youtube.dao.YoutubeDAO;
import com.youtube.dao.YoutubeDAOInterface;
import com.youtube.entity.YoutubeEmployee;

public class YoutubeService implements YoutubeServiceInterface{
	private YoutubeService() {}

	public static YoutubeServiceInterface createServiceObject() {
		// TODO Auto-generated method stub
		return new YoutubeService();
	}
		
	@Override
	public int createProfile(YoutubeEmployee ye) {
		// TODO Auto-generated method stub
		YoutubeDAOInterface yd=YoutubeDAO.createDaoObject();
		return yd.createProfileDao(ye);

	}

}
