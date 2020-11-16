package com.foxit.ofd.gsdk;

/**
* @brief OfdBase
*/
public class OfdBase
{
	/**Error Code Define*/
	public final static int OFD_ERR_SUCCESS = 0;			// sucess
	public final static int OFD_ERR_LICENSE_DIR = 1;				// The license folder does not exist
	public final static int OFD_ERR_LICENSE_WRITE = 2;				// No license folder write permission
	public final static int OFD_ERR_LICENSE_SERIAL = 3;				// The serial number is not correct
	public final static int OFD_ERR_LICENSE_NET = 4;				// Unable to connect to the license server
	public final static int OFD_ERR_LICENSE_SERIALEXPIRED = 5;		// Serial number expired
	public final static int OFD_ERR_LICENSE_EXCEED = 6;				// Exceed license  number
	public final static int OFD_ERR_LICENSE_EXPIRED = 7;			// Expiration of license
	public final static int OFD_ERR_LICENSE_FILE = 8;				// The license file was modified 
	public final static int OFD_ERR_LICENSE_HARDWARE = 9;			// Device changed
	public final static int OFD_ERR_LICENSE_VERSION = 10;			// Version is too low
	public final static int OFD_ERR_LICENSE_SERIAL_PRODUCT = 31;	// The serial number is incorrect and the product name is incorrect 
	public final static int OFD_ERR_LICENSE_SERIAL_MAJOR = 32;		// The serial number error, main version number is incorrect
	public final static int OFD_ERR_LICENSE_SERIAL_CPU = 33;		// The serial number error, cpu number is incorrect
	public final static int OFD_ERR_LICENSE_SERIAL_SERVER = 34;		// The serial number error, license service returned error

	/**
	 * @brief 初始化。
	 *
	 * @param[in]	license_id		序列号。	
	 * @param[in]	license_path	授权文件路径。
	 * @return 成功返回0，失败返回-1或如上OFD_LIC_XXX信息。
	 *				
	 */
	public static native int		init(String license_id, String license_path);

	/**
	 * @brief 释放。
	 *
	 * @return 无。	
	 *
	 */
	public static native void		destroy();

	/**
	 * @brief setLibraryPath
	 *
	 * @param[in]	work_path	DLL file path.
	 * @return Return 0 if successful.
	 *				
	 */
	public static native int		setLibraryPath(String work_path);

	/**
	 * @brief 	添加字体文件映射（注：该方法通常适用于非windows平台，
	 *			例如在安卓平台上设置安卓不自带的字体时，可以自己设置字体路径和名称（仅适用常规字体））	
	 *	
	 * @param[in]	fontName	字体名称	
	 * @param[in]	fontFile	字体文件
	 * @return	成功返回0，失败返回-1；		
	 */
	public static native int		addFontFileMap(String fontName, String fontFile);
}
