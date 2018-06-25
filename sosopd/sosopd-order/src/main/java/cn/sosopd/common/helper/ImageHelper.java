package cn.sosopd.common.helper;


public class ImageHelper {

	
	/**
	 * REST图片访问接口路径前缀
	 */
	public static final String IMAGE_REST_ROOT_PATH = "/rest/file/image";

	/**
	 * 获得图片的Rest访问路径
	 * 
	 * @param relativeFilePath
	 * @return
	 */
	public static String getImageRestPath(String relativeFilePath) {
		// 如果图片路径中已包含REST图片访问接口路径前缀，则直接返回
		if (relativeFilePath.startsWith(IMAGE_REST_ROOT_PATH)) {
			return relativeFilePath;
		}
		// 否则给图片路径加上REST图片访问接口路径前缀
		if (!relativeFilePath.startsWith(UploadHelper.WEB_PATH_SEPARATOR)) {
			relativeFilePath = UploadHelper.WEB_PATH_SEPARATOR + relativeFilePath;
		}
		return IMAGE_REST_ROOT_PATH + relativeFilePath;
	}
}