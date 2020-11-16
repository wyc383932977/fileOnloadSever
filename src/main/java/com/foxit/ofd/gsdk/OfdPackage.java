package com.foxit.ofd.gsdk;

/**
* @brief OfdPackage
*/
public class OfdPackage
{
	/**OFD格式*/
	public final static int OFD_SAVEAS_OFD = 0;
	/**PDF格式*/
	public final static int OFD_SAVEAS_PDF = 1;

	/**
	 * @brief 从文件中加载一个OFD包。
	 *
	 * @param[in]	file			指定的文件名。
	 * @param[in]	bClone			是否克隆文档 1 是， 0 否。		
	 * @return 返回包对象。
	 *				
	 */
	public static native long		open(String file, int bClone);

	/**
	 * @brief 从内存中加载一个OFD包。
	 *
	 * @param[in]	buf				指定的内存流。		
	 * @param[in]	bClone			是否克隆文档 1 是， 0 否。	
	 * @return 返回包对象。
	 *				
	 */
	public static native long		openByBuffer(byte[] buf, int bClone);

	/**
	 * @brief 创建一个空包。（保存时指定文件名或字节流）
	 *	
	 * @return 返回包对象。
	 *				
	 */
	public static native long		create0();
	
	/**
	 * @brief 创建一个空包。
	 *
	 * @param[in] file				指定的文件名。		
	 * @return 返回包对象。
	 *				
	 */
	public static native long		create(String file);
	
	/**
	 * @brief 关闭OFD包，并释放内存。
	 *
	 * @return 无。
	 *				
	 */
	public static native void 		close(long pack);

	/**
	 * @brief 设置是否嵌入字体。（保存前设置）
	 *
	 * @param[in]	pack			包对象。
	 * @param[in]	flag			标志位。0：不嵌入字体(默认)，1：嵌入字体。
	 * @return 无。
	 *				
	 */
	public static native void 		setEmbedFont(long pack, int flag);

	/**
	 * @brief 设置浮点数有效位数。（保存前设置）
	 *
	 * @param[in]	pack			包对象。
	 * @param[in]	num				浮点数有效位数，取值1~5。
	 * @return 无。
	 *				
	 */
	public static native void 		setFloatBit(long pack, int num);

	/**
	 * @brief 保存修改。
	 *
	 * @param[in]	package			包对象。	
	 * @return 无。
	 *				
	 */
	public static native void 		save(long pack);

	/**
	 * @brief 保存包至指定的文件。
	 *
	 * @param[in]	package			包对象。	
	 * @param[in]	file			文件名。	
	 * @return 无。
	 *				
	 */
	public static native void 		saveAs(long pack, String file);

	/**
	 * @brief 获得包至字节流。
	 *
	 * @param[in]	package			包对象。	
	 * @return 字节流。
	 *				
	 */
	public static native byte[] 	saveToByteArray(long pack);

	/**
	 * @brief 获得包至字节流。
	 *
	 * @param[in]	pack			包对象。	
	 * @param[in]	type			字节流类型。（0：OFD,1：PDF）	
	 * @return 字节流。
	 *				
	 */
	public static native byte[] 	saveToByteArray2(long pack, int type);

	/**
	 * @brief 获得优化后的包至字节流。（优化会删除未使用资源）
	 *
	 * @param[in]	pack			包对象。	
	 * @param[in]	type			字节流类型。（0：OFD,1：PDF）		 
	 * @return 字节流。
	 *				
	 */
	public static native byte[] 	optimizerToByteArray(long pack, int type);

	/**
	 * @brief 得到OFD包中文档的数量。
	 *			
	 * @param[in]	pack			包对象。	
	 * @return 成功返回文档的数量，失败返回-1。
	 *				
	 */
	public static native int 		countDocument(long pack);

	/**
	 * @brief 新建一个文档，并追加至包中。
	 *			
	 * @return 成功返回文档对象。
	 *				
	 */
	public static native long 	addDocument(long pack);
	
	/**
	 * @brief 加载指定文档。
	 *
	 * @param[in]	pack			包对象。	
	 * @param[in]	index			文档序号。
	 * @return 成功返回文档对象，失败返回0。
	 *				
	 */
	public static native long		loadDocument(long pack, int index);

 	 /**
	 * @brief 从包中清除指定文档内容，仅限于 load documet 的情况。
	 *
	 * @param[in]	hPackage	包句柄。	
	 * @param[in]	iIndex		文档序号（由0开始编号）。
	 * @return 无。
	 *				
	 */
	public static native long clearDocument(long pack,int index);
	
	/**
	 * @brief 加载指定文档。
	 *
	 * @param[in]	pack			包对象。		
	 * @param[in]	index			文档序号。
	 * @param[in]	pwd				密码。
	 * @return 成功返回文档对象，失败返回0。
	 *				
	 */

	public static native long		loadDocument2(long pack, int index, String pwd);

	/**
	 * @brief 指定文档是否加密。
	 *
	 * @param[in]	pack			包对象。		
	 * @param[in]	index			文档序号。
	 * @return 是否加密。
	 *				
	 */
	public static native int		isEncrypted(long pack, int index);

	/**
	 * @brief 指定文档是否使用标准加密。
	 *
	 * @param[in]	pack			包对象。		
	 * @param[in]	index			文档序号。
	 * @return 是否使用标准加密。
	 *				
	 */
	public static native int		getEncryptType(long pack, int index);

	/**
	 * @brief OFD文件规范性校验
	 *
	 * @param[in]	pack			包对象。
	 * @return 合格返回0。
	 *				
	 */
	public static native int 		verify(long pack);

	/**
	 * @brief 获取OFD文件全文
	 *
	 * @param[in]	pack			包对象。
	 * @return 文件全文。
	 *			
	 */
	public static native String		getPackageText(long pack);

	/**
	 * @brief 从包中查找指定的字符串。
	 *
	 * @param[in]	pack			包对象。	
	 * @param[in]	find			查找内容。
	 * @return 返回查找对象。
	 *				
	 */
	public static native long	searchPackage(long pack, String find);

	/**
	 * @brief 将其他包中的文档追加到此包中。
	 *
	 * @param[in]	packTo			包句柄。		
	 * @param[in]	packFrom		包句柄。		
	 * @param[in]	index			文档索引。		
	 * @return 成功返回文档句柄，失败返回NULL。
	 *				
	 */
	public static native void addOtherDocument(long packTo, long packFrom, int index);
}
