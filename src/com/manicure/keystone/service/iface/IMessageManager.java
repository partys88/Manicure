package com.manicure.keystone.service.iface;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.manicure.keystone.entity.response.MusicMessage;
import com.manicure.keystone.entity.response.NewsMessage;
import com.manicure.keystone.entity.response.TextMessage;

public interface IMessageManager {
	public Map<String, String> parseXml(HttpServletRequest request)
			throws Exception;

	public String textMessageToXml(TextMessage textMessage);

	public String musicMessageToXml(MusicMessage musicMessage);

	public String newsMessageToXml(NewsMessage newsMessage);

}
