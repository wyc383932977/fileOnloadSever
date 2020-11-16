package com.foxit.ofd.gsdk;

/**
* @brief OfdSeal 电子签章
*/
public class OfdSeal
{
	/**成功*/
	public final static int OFD_SEAL_ERR_Suc = 0;
	/**失败*/
	public final static int OFD_SEAL_ERR_Common = -1;
	/**DLL库未找到*/
	public final static int OFD_SEAL_ERR_NoFoundDLL = 501;
	/**DLL库加载失败*/
	public final static int OFD_SEAL_ERR_LoadDLL = 502;
	/**DLL库中标识符未找到*/
	public final static int OFD_SEAL_ERR_NoSymbol = 503;
	/**未找到印章*/
	public final static int OFD_SEAL_ERR_NoSuchSeal = 504;
	/**印章加载失败*/
	public final static int OFD_SEAL_ERR_LoadSealData = 505;

	/**
	 * @brief 初始化签章库。
	 *
	 * @param[in]	sOES			设置OES驱动路径。
	 * @param[in]	sPin			设置OES密码，保留位暂未启用，可以设置任意值。
	 * @return 返回 0 有效，非 0 其他错误。
	 *				
	 */
	public static native	int		init(String sOES, String sPin);

	/**
	 * @brief 释放签章库。
	 *
	 * @return 无。
	 *				
	 */
	public static native	void	destory();

	/**
	 * @brief 加载签章库中的电子印章。
	 *
	 * @param[in]	sSeal			电子印章。
	 * @param[in]	sealType		0表示印章ID，1表示印章名称。
	 * @param[in]	checkSeallist	0表示不检查SealList，1表示检查。
	 * @param[in]	sPin			密码。
	 * @param[out]	err				错误代码。	
	 * @return 返回印章对象。
	 *				
	 */
	public static native	long	loadSeal(String sSeal, int sealType, int checkSeallist, String sPin, final OfdRef err);

	/**
	 * @brief 卸载签章库中的电子印章。
	 *
	 * @param[in]	hSeal			电子印章句柄。
	 * @return 无。
	 *				
	 */
	public static native	void	unLoadSeal(long hSeal);

	/**
	 * @brief 使用电子印章签名OFD（PDF）文档。
	 *
	 * @param[in]	hSeal			电子印章对象。
	 * @param[in]	sFileName		原始文件。	
	 * @param[in]	sSignFile		签名保存文件。	
	 * @param[in]	page			签名页索引。	
	 * @param[in]	x				印章中心位置x坐标。	
	 * @param[in]	y				印章中心位置y坐标。	
	 * @param[in]	lock			是否签名锁定 1 是 0 不是。
	 * @return 返回错误代码。
	 *				
	 */
	public static native	int		sign(long hSeal, String sFileName, String sSignFile, int page, float x, float y, int lock);

	/**
	 * @brief 使用电子印章签名发票OFD（PDF）文档。
	 *
	 * @param[in]	hSeal			电子印章对象。
	 * @param[in]	sFileName		原始文件。	
	 * @param[in]	sSignFile		签名保存文件。	
	 * @param[in]	page			签名页索引。	
	 * @param[in]	x				印章中心位置x坐标。	
	 * @param[in]	y				印章中心位置y坐标。	
	 * @param[in]	posx			印章在其它页面的显示位置x坐标。
	 * @param[in]	posy			印章在其它页面的显示位置y坐标。
	 * @param[in]	lock			是否签名锁定 1 是 0 不是。
	 * @return 返回错误代码。
	 *				
	 */
	public static native	int		signfp(long hSeal, String sFileName, String sSignFile, int page, float x, float y, float posx, float posy, int lock);

	/**
	 * @brief 使用电子印章签名OFD（PDF）文档。
	 *
	 * @param[in]	hSeal			电子印章对象。
	 * @param[in]	src				原始文件字节流。	
	 * @param[in]	page			签名页索引。	
	 * @param[in]	x				印章中心位置x坐标。	
	 * @param[in]	y				印章中心位置y坐标。	
	 * @param[out]	err				错误代码。	
	 * @param[in]	lock			是否签名锁定 1 是 0 不是。
	 * @return 返回签章文件字节流。
	 *				
	 */
	public static native	byte[]	sign2(long hSeal, byte[] src, int page, float x, float y, final OfdRef err, int lock);

	/**
	 * @brief 使用电子印章签名发票OFD（PDF）文档。
	 *
	 * @param[in]	hSeal			电子印章对象。
	 * @param[in]	src				原始文件字节流。	
	 * @param[in]	page			签名页索引。	
	 * @param[in]	x				印章中心位置x坐标。	
	 * @param[in]	y				印章中心位置y坐标。	
	 * @param[out]	err				错误代码。	
	 * @param[in]	posx			印章在其它页面的显示位置x坐标。
	 * @param[in]	posy			印章在其它页面的显示位置y坐标。
	 * @param[in]	lock			是否签名锁定 1 是 0 不是。
	 * @return 返回签章文件字节流。
	 *				
	 */
	public static native	byte[]	signfp2(long hSeal, byte[] src, int page, float x, float y, final OfdRef err, float posx, float posy, int lock);

	/**
	 * @brief 使用骑缝章签名OFD（PDF）文档。
	 *
	 * @param[in]	hSeal			电子印章对象。
	 * @param[in]	src				原始文件字节流。	
	 * @param[out]	err				错误代码。	
	 * @param[in]	lock			是否签名锁定 1 是 0 不是。
	 * @return 返回签章文件字节流。
	 *				
	 */
	public static native	byte[]	sign3(long hSeal, byte[] src, final OfdRef err, int lock);

	/**
	 * @brief 获取签章个数。
	 *
	 * @param[in]	sFileName		签名文件。
	 * @return 返回文档签章个数。
	 *				
	 */
	public static native	int		countSign(String sFileName);

	/**
	 * @brief 获取签章个数。
	 *
	 * @param[in]	src				签名文件字节流。
	 * @return 返回文档签章个数。
	 *				
	 */
	public static native	int		countSign2(byte[] src);

	public final static int OFD_SEAL_PROPERTY_Type = 0;
	public final static int OFD_SEAL_PROPERTY_ProviderName = 1;
	public final static int OFD_SEAL_PROPERTY_Company = 2;
	public final static int OFD_SEAL_PROPERTY_Version = 3;
	public final static int OFD_SEAL_PROPERTY_SignDateTime = 4;
	public final static int OFD_SEAL_PROPERTY_SignMethod = 5;
	public final static int OFD_SEAL_PROPERTY_CheckMethod = 6;

	/**
    * @brief 获取签章属性。
    *
    * @param[in]   sFileName		签名文件。
    * @param[in]   index			签名索引。
    * @param[in]   propertyindex		签名属性索引。
    * @return 返回文档签章属性值。
    *
    */
    public static native    String		GetSigProperty(String sFileName, int index, int propertyindex);

	/**
    * @brief 获取签章属性。
    *
    * @param[in]   src                     签名文件字节流。
    * @param[in]   index                   签名索引。
    * @param[in]   propertyindex           签名属性索引。
    * @return 返回文档签章属性值。
    *
    */
    public static native    String          GetSigProperty2(byte[] src, int index, int propertyindex);

	public final static int OFD_SEAL_PROPERTY_Seal_ID = 0;
	public final static int OFD_SEAL_PROPERTY_Seal_Version = 1;
	public final static int OFD_SEAL_PROPERTY_Seal_VenderId = 2;
	public final static int OFD_SEAL_PROPERTY_Seal_Type = 3;
	public final static int OFD_SEAL_PROPERTY_Seal_Name = 4;
	public final static int OFD_SEAL_PROPERTY_Seal_CertInfo = 5;
	public final static int OFD_SEAL_PROPERTY_Seal_ValidStart = 6;
	public final static int OFD_SEAL_PROPERTY_Seal_ValidEnd = 7;
	public final static int OFD_SEAL_PROPERTY_Seal_SignedDate = 8;
	public final static int OFD_SEAL_PROPERTY_Seal_SignerName = 9;
	public final static int OFD_SEAL_PROPERTY_Seal_SignMethod = 10;

	/**
    * @brief 获取印章属性初始化。
    *
    * @param[in]   sFileName		签名文件。
    * @param[in]   index			签名索引。
    * @return 返回初始化handler。
    *
    */
    public static native    long		SealPropertyInit(String sFileName, int index);

	/**
    * @brief 获取印章属性初始化。
    *
    * @param[in]   src				签名文件字节流。
    * @param[in]   index			签名索引。
    * @return 返回初始化handler。
    *
    */
    public static native    long		SealPropertyInit2(byte[] src, int index);

	/**
    * @brief 获取印章属性。
    *
    * @param[in]   handler			印章属性初始化返回handler值。
    * @param[in]   index			签名属性索引。
    * @return 返回印章属性值。
    *
    */
    public static native    String		SealPropertyGet(long handler, int index);

	/**
    * @brief 获取印章资源释放。
    *
    * @param[in]   handler			印章属性初始化返回handler值。
    * @return 无。
    *
    */
    public static native    void	SealPropertyRelease(long handler);

	/**
	 * @brief 验证签章。
	 *
	 * @param[in]	sFileName		签名文件。
	 * @param[in]	index			签章索引。	
	 * @param[in]	online			0 表示离线，1 表示在线。	
	 * @return 返回 0 有效，非 0 其他错误。
	 *				
	 */
	public static native	int		verify(String sFileName, int index, int online);

	/**
	 * @brief 验证签章。
	 *
	 * @param[in]	src				签名文件字节流。	
	 * @param[in]	index			签章索引。	
	 * @param[in]	online			0 表示离线，1 表示在线。	
	 * @return 返回 0 有效，非 0 其他错误。
	 *				
	 */
	public static native	int		verify2(byte[] src, int index, int online);
}
