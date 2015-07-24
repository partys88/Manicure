/**
 * 
 */
package com.manicure.keystone.entity.request.material;

/**
 * @author Barrie
 *
 */
public class MaterialListReq {
	public static String TYPE_IMAGE = "image";
	public static String TYPE_VIDEO = "video";
	public static String TYPE_VOICE = "voice";
	public static String TYPE_NEWS = "news";
	private String type;
	private int offset;
	private int count;

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the offset
	 */
	public int getOffset() {
		return offset;
	}

	/**
	 * @param offset
	 *            the offset to set
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

}
