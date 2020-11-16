package com.foxit.ofd.gsdk;

/**
* @brief OfdCert Windows签名证书
*/
public class OfdCert
{
	/**
	 * @brief setLibraryPath
	 *
	 * @param[in]	work_path	DLL file path.
	 * @return Return 0 if successful.
	 *				
	 */
	public static native int		setLibraryPath(String work_path);

	/**
	 * @brief release resource
	 *
	 * @return
	 *				
	 */
	public static native void		release();

	/**
	 * @brief 证书签名。
	 *
	 * @param[in]	ofdFile			OFD 文件。
	 * @param[in]	ofdSignFile		OFD 签名后保存的文件。
	 * @param[in]	sPassWord		OFD 文件加密密码。
	 * @param[in]	sCertFile		证书文件。
	 * @param[in]	sCertPassWord	证书文件密码。
	 * @return 返回签章文件字节流。
	 *				
	 */
	 public static native	int	sign1(String ofdFile, String ofdSignFile, String sPassWord, String sCertFile, String sCertPassWord);

	 /**
	 * @brief 证书签名。
	 *
	 * @param[in]	ofdData			OFD 文件字节流。
	 * @param[in]	sPassWord		OFD 文件加密密码。
	 * @param[in]	sCertFile		证书文件。
	 * @param[in]	sCertPassWord	证书文件密码。
	 * @return 返回签章文件字节流。
	 *				
	 */
	 public static native	byte[]	sign2(byte[] ofdData, String sPassWord, String sCertFile, String sCertPassWord);

	/**
	 * @brief 获取签章个数。
	 *
	 * @param[in]	ofdFile			签名文件。
	 * @param[in]	sPassWord		OFD 文件加密密码。
	 * @return 返回文档签章个数。
	 *				
	 */
	public static native	int		countSign1(String ofdFile, String sPassWord);

	/**
	 * @brief 获取签章个数。
	 *
	 * @param[in]	ofdData			签名文件字节流。
	 * @param[in]	sPassWord		OFD 文件加密密码。
	 * @return 返回文档签章个数。
	 *				
	 */
	public static native	int		countSign2(byte[] ofdData, String sPassWord);

	public final static int OFD_CERT_PROPERTY_Type = 0;
	public final static int OFD_CERT_PROPERTY_ProviderName = 1;
	public final static int OFD_CERT_PROPERTY_Company = 2;
	public final static int OFD_CERT_PROPERTY_Version = 3;
	public final static int OFD_CERT_PROPERTY_SignDateTime = 4;
	public final static int OFD_CERT_PROPERTY_SignMethod = 5;
	public final static int OFD_CERT_PROPERTY_CheckMethod = 6;

	/**
    * @brief 获取签名属性。
    *
    * @param[in]   sFileName		签名文件。
    * @param[in]   index			签名索引。
    * @param[in]   propertyindex	签名属性索引。
    * @return 返回文档签名属性值。
    *
    */
    public static native    String		GetSigProperty(String sFileName, int index, int propertyindex);

	/**
    * @brief 获取签名属性。
    *
    * @param[in]   src					签名文件字节流。
    * @param[in]   index				签名索引。
    * @param[in]   propertyindex		签名属性索引。
    * @return 返回文档签名属性值。
    *
    */
    public static native    String		GetSigProperty2(byte[] src, int index, int propertyindex);

	/**
	 * @brief 验证签章。
	 *
	 * @param[in]	ofdFile			签名文件。	
	 * @param[in]	index			签名索引。	
	 * @param[in]	sPassWord		OFD 文件加密密码。	
	 * @return 返回 0 有效，非 0 其他错误。
	 *				
	 */
	public static native	int		verify1(String ofdFile, int index, String sPassWord);

	/**
	 * @brief 验证签章。
	 *
	 * @param[in]	src				签名文件字节流。	
	 * @param[in]	index			签名索引。	
	 * @param[in]	sPassWord		OFD 文件加密密码。	
	 * @return 返回 0 有效，非 0 其他错误。
	 *				
	 */
	public static native	int		verify2(byte[] src, int index, String sPassWord);

	public final static int OFD_CERT_CERTSERIALNUM = 0;
	public final static int OFD_CERT_CERTPUBLISHER = 1;
	public final static int OFD_CERT_CERTSTARTDATE = 2;
	public final static int OFD_CERT_CERTENDDATE = 3;
	public final static int OFD_CERT_CERTEMAILINFO = 4;

	/**
    * @brief 获取证书属性。
    *
    * @param[in]	ofdFile			签名文件。	
	* @param[in]	index			签名索引。	
	* @param[in]	sPassWord		OFD 文件加密密码。
    * @param[in]	propertyindex	签名属性索引。
    * @return 返回文档签名证书属性值。
    *
    */
    public static native    String		GetCertProperty(String ofdFile, int index, String sPassWord, int propertyindex);

	/**
    * @brief 获取证书属性。
    *
    * @param[in]	src				签名文件字节流。	
	* @param[in]	index			签名索引。	
	* @param[in]	sPassWord		OFD 文件加密密码。
    * @param[in]	propertyindex	签名属性索引。
    * @return 返回文档签名证书属性值。
    *
    */
    public static native    String		GetCertProperty2(byte[] src, int index, String sPassWord, int propertyindex);
}
