package com.foxit.ofd.gsdk;

/**
* @brief OfdParam
*/
public class OfdParam
{
	/**
	* 图像类型定义
	*/
	public final static int OFD_IMAGE_FORMAT_BMP  =  1;  //bmp格式
	public final static int OFD_IMAGE_FORMAT_JPG  = 2;  //jpg格式
	public final static int OFD_IMAGE_FORMAT_PNG = 3;  //png格式
	
	/**
	 * @brief 创建参数对象
	 *
	 * @return 返回参数对象.
	 *				
	 */
	public static native long		init();

	/**
	 * @brief 销毁参数对象
	 *
	 * @param[in]	param	参数对象.
	 * @return 无.	
	 *
	 */
	public static native void		destroy(long param);

	/**
	 * @brief 嵌入字体（OFD2PDF）.
	 * @param[in]	param	参数对象.
	 * @param[in]	set		设置嵌入字体	0 非嵌入字体，1 嵌入字体.
	 *
	 * @return 无.
	 *				
	 */
	public static native void		setEmbedFont(long param, int set);

	/**
	 * @brief 签章对象转图片（OFD2PDF）.
	 * @param[in]	param	参数对象.
	 * @param[in]	set		设置签章对象转成图片对象.
	 *
	 * @return 无.
	 *				
	 */
	public static native void		setFlatSignature(long param, int set);

	/**
	 * @brief 设置密码（PDF2OFD）.
	 * @param[in]	param	参数对象.
	 * @param[in]	passWord	PDF文件密码.
	 *
	 * @return 无.
	 *				
	 */
	public static native void		setPassWord(long param, String passWord);

	/**
	 * @brief 设置分辨率（OFD2IMG）.
	 * @param[in]	param	参数对象.
	 * @param[in]	set		设置分辨率.
	 *
	 * @return 无.
	 *				
	 */
	public static native void		setDPI(long param, int set);

	/**
	 * @brief 设置大小（OFD2IMG\IMG2OFD）.
	 * @param[in]	param	参数对象.
	 * @param[in]	width	设置宽度.
	 * @param[in]	height	设置高度.
	 *
	 * @return 无.
	 *				
	 */
	public static native void		setSize(long param, int width, int height);

	/**
	 * @brief 设置当前文档（OFD2IMG）.
	 * @param[in]	param	参数对象.
	 * @param[in]	doc		文档索引.
	 *
	 * @return 无.
	 *				
	 */
	public static native void		setCurDoc(long param, int doc);

	/**
	 * @brief 设置当前页（OFD2IMG）.
	 * @param[in]	param	参数对象.
	 * @param[in]	page	页面索引.
	 *
	 * @return 无.
	 *				
	 */
	public static native void		setCurPage(long param, int page);

	/**
	 * @brief 设置转换图片类型（OFD2IMG）.
	 * @param[in]	param	参数对象.
	 * @param[in]	imgType	图片类型.
	 *
	 * @return 无.
	 *				
	 */
	public static native void		setImgType(long param, int imgType);

	/**
	 * @brief 设置转换页面类型（IMG2OFD）.
	 * @param[in]	param	参数对象.
	 * @param[in]	pageType	页面类型， 0 普通页， 1 模板页.
	 *
	 * @return 无.
	 *				
	 */
	public static native void		setPageType(long param, int pageType);

	/**
	 * @brief 设置模板页名称（IMG2OFD）.
	 * @param[in]	param	参数对象.
	 * @param[in]	templatePageName	模板页名称(页面类型为模板页起作用).
	 *
	 * @return 无.
	 *				
	 */
	public static native void		setTemplatePageName(long param, String templatePageName);

	/**
	 * @brief 文档数（OFD2IMG）.
	 * @param[in]	param	参数对象.
	 *
	 * @return 返回文档数.
	 *				
	 */
	public static native int		getDocCount(long param);

	/**
	 * @brief 设置当前页（OFD2IMG）.
	 * @param[in]	param	参数对象.
	 * @param[in]	doc		文档索引.
	 *
	 * @return 无.
	 *				
	 */
	public static native int		getPageCount(long param, int doc);

}
