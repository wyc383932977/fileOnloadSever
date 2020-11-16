package com.foxit.ofd.gsdk;

/**
* @brief OfdErr 获取签章或签名的错误信息
*/
public class OfdErr
{
	/**DLL库未找到*/
	public final static int OFD_ERR_NoFoundDLL = 501;
	/**DLL库加载失败*/
	public final static int OFD_ERR_LoadDLL = 502;
	/**DLL库中标识符未找到*/
	public final static int OFD_ERR_NoSymbol = 503;
	/**未找到印章*/
	public final static int OFD_ERR_NoSuchSeal = 504;
	/**印章加载失败*/
	public final static int OFD_ERR_LoadSealData = 505;
	/**DLL库未加载*/
	public final static int OFD_SIGN_ERR_NoLoadDLL = 506;

	/**
	 * @brief 初始化。
	 *
	 * @return 返回错误对象。
	 *				
	 */
	public static native OfdRef		init();

	/**
	 * @brief 获取错误值。
	 *
	 * @param[in]	err				错误对象。	
	 * @return 错误值。	
	 *
	 */
	public static native int		getInt(final OfdRef err);

	/**
	 * @brief 设置错误值。
	 *
	 * @param[in]	err				错误对象。	
	 * @param[in]	val				错误值。
	 * @return 错误值。	
	 *
	 */
	public static native void		setInt(final OfdRef err, int val);
}
	