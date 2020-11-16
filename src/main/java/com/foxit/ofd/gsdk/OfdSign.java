package com.foxit.ofd.gsdk;


/**
* @brief OfdSign 数字签名
*/
public class OfdSign
{
	/**
	 * @brief 分步式签名开始。
	 *
	 * @param[in]	ofdData			待签名文件字节流。	
	 * @return 返回非0有效，0 错误。
	 *				
	 */
	public static native	long	sBegin(byte[] ofdData);

	/**
	 * @brief OFD文件包含页数。
	 *
	 * @param[in]	handler			sBegin函数返回值。
	 * @return -1 失败，正整数 页数
	 *				
	 */
	public static native	int		sGetPageCount(long handler);

	/**
	 * @brief 分步式签名属性信息设置。
	 *
	 * @param[in]	handler			sBegin函数返回值。
	 * @param[in]	providerName	印章提供者。
	 * @param[in]	company			印章公司。
	 * @param[in]	version			版本号。
	 * @param[in]	digestMethod	摘要方法名称。
	 * @param[in]	signMethod		签名方法名称。
	 * @return 无
	 *				
	 */
	public static native	void	sSetProviderInfo(long handler, String providerName, String company, String version, String digestMethod, String signMethod);

	/**
	 * @brief 分步式签名时间设置。
	 *
	 * @param[in]	handler			sBegin函数返回值。
	 * @param[in]	signTime		签名时间。
	 * @return 无
	 *				
	 */
	public static native	void	sSetDateTime(long handler, String signTime);

	/**
	 * @brief 分步式印章文件设置。
	 *
	 * @param[in]	handler			sBegin函数返回值。
	 * @param[in]	pSealFile		印章文件。
	 * @return 无
	 *				
	 */
	public static native	void	sSetSealFile(long handler, byte[] pSealFile);

	/**
	 * @brief 关键字查找，返回关键字数量。
	 *
	 * @param[in]	handler			sBegin函数返回值。
	 * @param[in]	sKeyWord		待搜索的关键字。
	 * @return -1 失败，正整数 数量
	 *				
	 */
	public static native	int	sSearchKeyWord(long handler, String sKeyWord);

	/**
	 * @brief 该页是否包含该关键字。
	 *
	 * @param[in]	handler			sBegin函数返回值。
	 * @param[in]	page			页面索引。
	 * @return 0 不包含，非0 包含
	 *				
	 */
	public static native	int	sIncludeKeyWord(long handler, int page);

	/**
	 * @brief 获取该页第一个关键字的位置。
	 *
	 * @param[in]	handler			sBegin函数返回值。
	 * @param[in]	type			0 x坐标， 1 y坐标。
	 * @return 坐标值
	 *				
	 */
	public static native	float	sGetFirstKeyWordPos(long handler, int type);

	/**
	 * @brief 分步式签章，添加印章图片。
	 *
	 * @param[in]	handler			sBegin函数返回值。
	 * @param[in]	page			页面索引。
	 * @param[in]	x				印章图片x坐标。
	 * @param[in]	y				印章图片y坐标。
	 * @param[in]	w				印章图片宽度。
	 * @param[in]	h				印章图片高度。
	 * @return -1 失败，0成功
	 *				
	 */
	public static native	int		sAddSealImage(long handler, int page, float x, float y, float w, float h);

	/**
	 * @brief 分步式签章，通过关键字添加印章图片。
	 *
	 * @param[in]	handler			sBegin函数返回值。
	 * @param[in]	sKeyWord		关键字。
	 * @param[in]	w				印章图片宽度。
	 * @param[in]	h				印章图片高度。
	 * @return -1 失败，0成功
	 *				
	 */
	public static native	int		sAddSealImageByKeyWord(long handler, String sKeyWord, float w, float h);

	/**
	 * @brief 分步式签章，通过关键字添加印章图片。
	 *
	 * @param[in]	handler			sBegin函数返回值。
	 * @param[in]	pageindex		包含关键字的页面索引。
	 * @param[in]	w				印章图片宽度。
	 * @param[in]	h				印章图片高度。
	 * @return -1 失败，0成功
	 *				
	 */
	public static native	int		sAddSealImageByKeyWord2(long handler, int pageindex, float w, float h);

	/**
	 * @brief 分步式签名，添加签名图片。
	 *
	 * @param[in]	handler			sBegin函数返回值。
	 * @param[in]	pPic			图片内存流。
	 * @param[in]	iImgType		图片类型。
	 * @param[in]	page			页面索引。
	 * @param[in]	x				印章图片x坐标。
	 * @param[in]	y				印章图片y坐标。
	 * @param[in]	w				印章图片宽度。
	 * @param[in]	h				印章图片高度。
	 * @param[in]	rotate			印章图片旋转角度。
	 * @return -1 失败，0成功
	 *				
	 */
	public static native	int		sAddSignImage(long handler, byte[] pPic, int iImgType, int page, float x, float y, float w, float h, int rotate);

	/**
	 * @brief 分步式签名，添加签名图片。
	 *
	 * @param[in]	handler			sBegin函数返回值。
	 * @param[in]	sKeyWord		关键字。
	 * @param[in]	pPic			图片内存流。
	 * @param[in]	iImgType		图片类型。
	 * @param[in]	w				印章图片宽度。
	 * @param[in]	h				印章图片高度。
	 * @param[in]	rotate			印章图片旋转角度。
	 * @return -1 失败，0成功
	 *				
	 */
	public static native	int		sAddSignImageByKeyWord(long handler, String sKeyWord, byte[] pPic, int iImgType, float w, float h, int rotate);

	/**
	 * @brief 分步式签名，添加签名图片。
	 *
	 * @param[in]	handler			sBegin函数返回值。
	 * @param[in]	pageindex		包含关键字的页面索引。
	 * @param[in]	pPic			图片内存流。
	 * @param[in]	iImgType		图片类型。
	 * @param[in]	w				印章图片宽度。
	 * @param[in]	h				印章图片高度。
	 * @param[in]	rotate			印章图片旋转角度。
	 * @return -1 失败，0成功
	 *				
	 */
	public static native	int		sAddSignImageByKeyWord2(long handler, int pageindex, byte[] pPic, int iImgType, float w, float h, int rotate);

	/**
	 * @brief 分步式签名，需要计算摘要源数据的数量。
	 *
	 * @param[in]	handler			sBegin函数返回值。
	 * @return 需要计算摘要的个数
	 *				
	 */
	public static native	int		sCountRefers(long handler);

	/**
	 * @brief 分步式签名，获取计算摘要源数据。
	 *
	 * @param[in]	handler			sBegin函数返回值。
	 * @param[in]	ref_index		获取需要计算摘要源数据的索引值。
	 * @return 需要计算摘要源数据的内存流
	 *				
	 */
	public static native	byte[]	sGetReferData(long handler, int ref_index);

	/**
	 * @brief 分步式签名，计算后摘要数据写入。
	 *
	 * @param[in]	handler			sBegin函数返回值。
	 * @param[in]	ref_index		计算后摘要数据写入索引值。
	 * @param[in]	buf				计算后摘要数据内存流。
	 * @return 无
	 *				
	 */
	public static native	void	sSetReferDigest(long handler, int ref_index, byte[] buf);

	/**
	 * @brief 分步式签名，获取计算签名源数据。
	 *
	 * @param[in]	handler			sBegin函数返回值。
	 * @return 需要计算签名源数据的内存流
	 *				
	 */
	public static native	byte[]	sGetSignData(long handler);

	/**
	 * @brief 分步式签名，签名计算后数据写入。
	 *
	 * @param[in]	handler			sBegin函数返回值。
	 * @param[in]	buf				签名计算后数据内存流。
	 * @return 无
	 *				
	 */
	public static native	void	sSetSignValue(long handler, byte[] buf);

	/**
	 * @brief 分步式签名，签名完毕后整个OFD文件内存流获取。
	 *
	 * @param[in]	handler			sBegin函数返回值。
	 * @return 无
	 *				
	 */
	public static native	byte[]	sGetSignFile(long handler);

	/**
	 * @brief 分步式签名结束。
	 *
	 * @param[in]	handler			sBegin函数返回值。
	 * @return 无
	 *				
	 */
	public static native	void	sEnd(long handler);

	/**
	 * @brief 分步式验证签名开始。
	 *
	 * @param[in]	ofdData			已签名文件字节流。	
	 * @return 返回非0有效，0 错误。
	 *				
	 */
	public static native	long	vBegin(byte[] ofdData);

	/**
	 * @brief 分步式签名个数。
	 *
	 * @param[in]	handler			vBegin函数返回值。
	 * @return
	 *				
	 */
	public static native	int		vCount(long handler);

	/**
	 * @brief 分步式验证签名加载。
	 *
	 * @param[in]	handler			vBegin函数返回值。
	 * @param[in]	sign_index		签名索引。
	 * @return
	 *				
	 */
	public static native	void	vLoad(long handler, int sign_index);

	/**
	 * @brief 分步式签名提供者信息。
	 *
	 * @param[in]	handler			vBegin函数返回值。
	 * @return 信息字符串
	 *				
	 */
	public static native	String	vGetProviderInfo(long handler);

	/**
	 * @brief 分步式签名时间。
	 *
	 * @param[in]	handler			vBegin函数返回值。
	 * @return 时间字符串
	 *				
	 */
	public static native	String	vGetDateTime(long handler);

	/**
	 * @brief 分步式验证签名，摘要所保护数据的数量。
	 *
	 * @param[in]	handler			vBegin函数返回值。
	 * @return 个数
	 *				
	 */
	public static native	int		vCountRefers(long handler);

	/**
	 * @brief 分步式验证签名，摘要所保护的源数据。
	 *
	 * @param[in]	handler			vBegin函数返回值。
	 * @param[in]	ref_index		摘要所保护数据的索引值。
	 * @return 源数据内存流
	 *				
	 */
	public static native	byte[]	vGetReferData(long handler, int ref_index);

	/**
	 * @brief 分步式验证签名，摘要所保护的源数据的摘要。
	 *
	 * @param[in]	handler			vBegin函数返回值。
	 * @param[in]	ref_index		摘要所保护数据的摘要的索引值。
	 * @return 摘要数据内存流
	 *				
	 */
	public static native	byte[]	vGetReferDigest(long handler, int ref_index);

	/**
	 * @brief 分步式验证签名，签名所保护的源数据。
	 *
	 * @param[in]	handler			vBegin函数返回值。
	 * @return 签名所保护源数据内存流
	 *				
	 */
	public static native	byte[]	vGetSignData(long handler);

	/**
	 * @brief 分步式验证签名，签名所保护的源数据的签名值。
	 *
	 * @param[in]	handler			vBegin函数返回值。
	 * @return 签名数据内存流
	 *				
	 */
	public static native	byte[]	vGetSignValue(long handler);

	/**
	 * @brief 分步式验证签名结束。
	 *
	 * @param[in]	handler			vBegin函数返回值。
	 * @return
	 *				
	 */
	public static native	void	vEnd(long handler);
}
