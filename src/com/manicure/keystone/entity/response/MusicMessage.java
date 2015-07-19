/**
 * 
 */
package com.manicure.keystone.entity.response;

/**
 * 音乐消息
 * 
 * @author Barrie
 *
 */
public class MusicMessage extends BaseMessage {
	// 音乐
	private Music Music;

	/**
	 * @return the music
	 */
	public Music getMusic() {
		return Music;
	}

	/**
	 * @param music
	 *            the music to set
	 */
	public void setMusic(Music music) {
		Music = music;
	}

}
