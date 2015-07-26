package com.manicure.keystone.service.iface;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.manicure.keystone.entity.response.ImageMessage;
import com.manicure.keystone.entity.response.MusicMessage;
import com.manicure.keystone.entity.response.NewsMessage;
import com.manicure.keystone.entity.response.TextMessage;
import com.manicure.keystone.entity.response.VideoMessage;
import com.manicure.keystone.entity.response.VoiceMessage;

public interface IMessageService {
	public Map<String, String> parseXml(HttpServletRequest request) throws Exception;

	public String messageToXml(TextMessage textMessage);

	public String messageToXml(ImageMessage imageMessage);

	public String messageToXml(VoiceMessage voiceMessage);

	public String messageToXml(VideoMessage videoMessage);

	public String messageToXml(MusicMessage musicMessage);

	public String messageToXml(NewsMessage newsMessage);

}
