package cn.sosopd.common.util;

import java.awt.image.BufferedImage;

import org.apache.http.Header;

import cn.sosopd.common.exception.ServiceException;

public class HttpResEntity {

	private byte[] byteData;
	private int status;
	private Header[] cookieHeaders;
	private String location;
	private String msg;
	private BufferedImage image;
	private String imageTyep;
	private String charset;
	
	public String getDefaultHtml() throws ServiceException {
		return buildString(charset);
	}
	
	public String getHtmlData() throws ServiceException{
		
		return getHtmlByUTF8();
	}

	public String getHtmlByGBK() throws ServiceException {
		return buildString("GBK");
	}

	public String getHtmlByISO() throws ServiceException {
		return buildString("ISO-8859-1");
	}

	public String getHtmlByUTF8() throws ServiceException {
		return buildString("UTF-8");
	}

	private String buildString(String charset) throws ServiceException {
		if (byteData == null) {
			return null;
		}
		try {
			return new String(byteData, charset);
		} catch (Exception e) {
			throw new ServiceException("字符集不支持！");
		}
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Header[] getCookieHeaders() {
		return cookieHeaders;
	}

	public void setCookieHeaders(Header[] cookieHeaders) {
		this.cookieHeaders = cookieHeaders;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getImageTyep() {
		return imageTyep;
	}

	public void setImageTyep(String imageTyep) {
		this.imageTyep = imageTyep;
	}

	public byte[] getByteData() {
		return byteData;
	}

	public void setByteData(byte[] byteData) {
		this.byteData = byteData;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}
	
}
