package com.foxit.ofd.gsdk;

/**
* @brief OfdDocument
*/
public class OfdDocument
{
	/**文档作者*/
	public final static String OFD_DOCUMENT_METADATA_AUTHOR = "Author";
	/**创建文档的应用程序*/
	public final static String OFD_DOCUMENT_METADATA_CREATOR = "Creator";
	/**创建文档的应用程序的版本信息*/
	public final static String OFD_DOCUMENT_METADATA_CREATORVERSION = "CreatorVersion";
	/**文档分类*/
	public final static String OFD_DOCUMENT_METADATA_DOCUSAGE = "DocUsage";
	/**文档标题*/
	public final static String OFD_DOCUMENT_METADATA_TITLE = "Title";
	/**文档主题*/
	public final static String OFD_DOCUMENT_METADATA_SUBJECT = "Subject";
	/**文档摘要与注释*/
	public final static String OFD_DOCUMENT_METADATA_ABSTRACT = "Abstract";
	/**文档创建日期*/
	public final static String OFD_DOCUMENT_METADATA_CREATEDATE = "CreationDate";
	/**文档最近修改日期*/
	public final static String OFD_DOCUMENT_METADATA_MODDATE = "ModDate";
	/**文档封面*/
	public final static String OFD_DOCUMENT_METADATA_COVER = "Cover";

	/**OFD文件加密类型1*/
	public final static int OFD_ENCRYP_NONE = 0;

	/**OFD文件加密类型2*/
	public final static int OFD_ENCRYP_RC4 = 1;

	/**OFD文件加密类型3*/
	public final static int OFD_ENCRYP_AES128 = 2;

	/**OFD文件加密类型4*/
	public final static int OFD_ENCRYP_AES256 = 4;

	/**OFD文件加密类型5*/
	public final static int OFD_ENCRYP_SM4 = 5;

	/**
	 * @brief 关闭文档，并释放对应内存。
	 *
	 * @param[in]	document		文档对象。
	 * @return 无。
	 *
	 */
	public static native void		close(long document);

	/**
	 * @brief 获取文档页数。
	 *
	 * @param[in]	document		文档对象。	
	 * @return 成功返回页个数，失败返回-1。
	 *				
	 */
	public static native int		countPage(long document);
	
	/**
	 * @brief 加载文档一页。
	 *
	 * @param[in]	document		文档对象。	
	 * @param[in]	index			页序号（由0开始编号）。
	 * @return 返回页对象。
	 *				
	 */
	public static native long		loadPage(long document, int index);

	/**
	 * @brief 加载文档模板一页。
	 *
	 * @param[in]	document		文档对象。	
	 * @param[in]	index			模板页序号（由0开始编号）。
	 * @return 返回页对象。
	 *				
	 */
	public static native long		loadTemplatePage(long document, int index);

	/**
	 * @brief 新建一页，并追加至文档中。
	 *
	 * @param[in]	document		文档对象。	
	 * @return 返回页对象。
	 *				
	 */
	public static native long		addPage(long document);

	/**
	 * @brief 删除页。
	 *
	 * @param[in]	document		文档对象。	
	 * @param[in]	index			页索引号。	
	 * @return 成功返回1,失败返回0。
	 *				
	 */
	public static native int		deletePage(long document, int index);

	/**
	 * @brief 移动文档中的一页。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in]	iSrcIndex		移动前页序号（由0开始编号）。
	 * @param[in]	iDstIndex		移动后页序号（由0开始编号）。
	 * @return 无。
	 *
	 */
	public static native void		movePage(long document, int iSrcIndex, int iDstIndex);

	/**
	 * @brief 拆分文档中的一页。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in]	index			页序号（由0开始编号）。
	 * @return 无。
	 *
	 */
	public static native void		splitPage(long document, int index);

	/**
	 * @brief 将源文档合并到目标文档中。
	 *
	 * @param[in]	dst				目标文档对象。
	 * @param[in]	src				源文档对象。	
	 * @param[in]	insertTo		插入位置。	
	 * @return 无。
	 *				
	 */
	public static native void		mergeDoc(long dst, long src, int insertTo);

	/**
	 * @brief 添加目录列表。首页为封面，第二页开始为目录。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in]	catalog			目录对象。	
	 * @return 无。
	 *				
	 */
	public static native int		addCatalogs(long document, long catalog);

	/**
	 * @brief 添加大纲。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in]	catalog			目录对象。	
	 * @return 无。
	 *				
	 */
	public static native int		addOutlines(long document, long catalog);

	/**
	 * @brief 根据DocID
	 *
	 * @param[in]	document		文档对象。
	 * @return DocID字符串。
	 *
	 */
	public static native String		getDocID(long document);

	/**
	 * @brief 设置DocID。
	 *
	 * @param[in]	document		文档对象。
	 * @return 无。
	 *
	 */
	public static native void		setDocID(long document);

	/**
	 * @brief 添加附件列表。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in]	catalog			目录对象。	
	 * @return 无。
	 *				
	 */
	public static native int		addAttachments(long document, long catalog);

	/**
	 * @brief 加载一个已存在文件的页面，并追加至当前文档中。
	 *
	 * @param[in]	document		当前文档对象。
	 * @param[in]	inserto			当前文档对象追加页面位置。
	 * @param[in]	srcDocumen		已存在文件的文档对象。
	 * @param[in]	index			加载已存在文件的页面索引。
	 * @return
	 *				
	 */
	public static native void		addOtherDocPage(long document, int inserto, long srcDocument, int index);

	/**
	 * @brief 新建一个模板页，并追加至文档中。
	 *
	 * @param[in]	document		文档对象。	
	 * @return 返回页对象。
	 *				
	 */
	public static native long		addDetailPage(long document);

	/**
	 * @brief 获取文档模板页数。
	 *
	 * @param[in]	document		文档对象。	
	 * @return 成功返回页个数，失败返回-1。
	 *				
	 */
	public static native int		countTemplatePage(long document);

	/**
	 * @brief 将指定的普通页转换成模板页。
	 *
	 * @param[in]	document		文档对象。	
	 * @param[in]	srcpage			普通页的页句柄。	
	 * @return 成功返回模板页句柄，失败返回NULL。
	 *				
	 */
	public static native long		addTemplatePageFromPage(long document, long srcpage);

	/**
	 * @brief 根据名称获取指定的模板页。
	 *
	 * @param[in]	document		文档对象。	
	 * @param[in]	name			模板页名称。	
	 * @return 成功返回模板页句柄，失败返回NULL。
	 *				
	 */
	public static native long		getTemplatePageByName(long document, String name);

	/**
	 * @brief 新建一模板页，并追加至文档中。
	 *
	 * @param[in]	document		文档对象。	
	 * @return 返回模板页对象。
	 *				
	 */
	public static native long		addTemplatePage(long document);

	/**
	 * @brief 新建一个模板页，并追加至文档中。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in]	index			模板页索引。
	 * @return 返回页对象。
	 *				
	 */
	public static native long		insertTemplatePage(long document, int index);

	/**
	 * @brief 删除指定的模板页。
	 *
	 * @param[in]	document		文档对象。	
	 * @param[in]	index			模板页索引号。	
	 * @return 无。
	 *				
	 */
	public static native void		removeTemplatePage(long document, int index);

	/**
	 * @brief 删除所有模板页。
	 *
	 * @param[in]	document		文档对象。	
	 * @return 无。
	 *				
	 */
	public static native void		removeAllTemplatePage(long document);

	/**
	 * @brief 获取表单数据。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in]	index			表单页索引。
	 * @return 表单数据。
	 *				
	 */
	public static native byte[]		getFormData(long document, int index);

	/**
	 * @brief 设置表单数据。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in]	index			表单页索引。
	 * @param[in]	buf				表单数据。
	 * @return 无。
	 *				
	 */
	public static native void		setFormData(long document, int index, byte[] buf);

	/**
	 * @brief 转换内嵌字体。
	 *
	 * @param[in]	document	文档句柄。		
	 * @param[in]	fontName	字体名称。		
	 * @return 无。
	 *				
	 */
	public static native void		convert2EmbededFont(long document, String fontName);

	/**
	 * @brief 添加文档附件。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in]	attachmentName	文件名。
	 * @param[in]	buf				附件数据。
	 * @param[in]	bVisible		附件是否可见，0 不可见，非0 可见。
	 * @return 无。
	 *
	 */
	public static native void		addAttachment(long document, String attachmentName, byte[] buf, String name2,int bVisible);

	/**
	 * @brief 添加文档附件。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in]	attachment		指定的附件文件名。
	 * @return 无。
	 *
	 */
	public static native void		addAttachment1(long document, String attachment);

	/**
	 * @brief 添加文档附件。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in]	attachment		指定的附件字节流。
	 * @param[in]	format			指定的附件格式。
	 * @param[in]	name			指定的附件文件名。
	 * @return 无。
	 *
	 */
	public static native void		addAttachment2(long document, byte[] attachment, String format, String name);

	/**
	 * @brief 获取文档附件个数。
	 *
	 * @param[in]	document		文档对象。
	 * @return 成功返回附件个数，失败返回-1。
	 *
	 */
	public static native int		countAttachment(long document);

	/**
	 * @brief 获取文档附件。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in]	index			附件索引号。
	 * @param[in]	attachment		导出的附件文件名。
	 * @return 无。
	 *
	 */
	public static native void		getAttachment(long document, int index, String attachment);

	/**
	 * @brief 获取文档附件字节流。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in]	index			附件索引号。
	 * @return 附件字节流。
	 *
	 */
	public static native byte[]		getAttachment2(long document, int index);

	/**
	 * @brief 添加XML文件。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in]	xml				指定的XML文件名。
	 * @return 无。
	 *
	 */
	public static native void		addXMLFile(long document, String xml);

	/**
	 * @brief 文档中 XML 的数量
	 *
	 * @param[in]	document		文档对象。
	 * @return 成功返回XML文件个数，失败返回-1。
	 *
	 */
	public static native int		countXMLFile(long document);

	/**
	 * @brief 导出XML文件。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in]	xml				指定的XML文件名。
	 * @param[in]	index			索引序号（由0开始编号）。
	 * @return 无。
	 *
	 */
	public static native void		extractXMLFile(long document, String xml, int index);

	/**
	 * @brief 删除所有签名。
	 *
	 * @param[in]	document		文档对象。
	 * @return 无。
	 *
	 */
	public static native void		removeSignatures(long document);

	/**
	 * @brief 设置元数据。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in]	key				元数据名称。
	 * @param[in]	data			元数据（"Author","Creator","DocID","DocumentID","Title","Subject","Abstract","CreationDate","ModDate","Gongwenyuyi","Gongwenbiaoshi","Wenzhong"）。
	 * @return 无。
	 *
	 */
	public static native void		setMetadata(long document, String key, String data);

	/**
	 * @brief 设置KeyWord。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in]	keyWord			元数据名称。
	 * @param[in]	index			序号
	 * @return 无。
	 *
	 */
	public static native void		setKeyWord(long document, String keyWord, int index);

	/**
	 * @brief 设置自定义数据。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in]	CustomData		自定义数据名称。
	 * @param[in]	Value			自定义数据。
	 * @return 无。
	 *
	 */
	public static native void		setCustomData(long document, String CustomData, String value);

	/**
	 * @brief 设置自定义元数据。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in] key			自定义元数据类型
	 * @param[in] data			元数据内容
	 * @param[in] index			关键字索引
	 * @return 成功返回页个数，失败返回-1。
	 *				
	 */
	public static native void setCustomData2(long document, String key, String data, int index);

	/**
	 *
	 * @brief 获取文档操作权限对象。
	 * @param[in]	document		文档对象。
	 * @return 文档操作权限对象。
	 *
	 */
	public static native long		getPermissions(long document);

	/**
	 * @brief 创建文档操作权限对象。
	 *
	 * @param[in]	document		文档对象。
	 * @return 文档操作权限对象。
	 *
	 */
	public static native long		createPermissions(long document);

	/**
	 * @brief 加密文档。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in]	type			文档加密类型，可以是OFD_ENCRYP_NONE或OFD_ENCRYP_AES或OFD_ENCRYP_MS4。
	 * @param[in]	userPassword	使用者密码。
	 * @param[in]	ownerPassword	拥有者密码。
	 * @return 是否成功。
	 *
	 */
	public static native int		setPassword(long document, int type, String userPassword, String ownerPassword);

	/**
	 * @brief 移除标准密码。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in]	ownerPassword	拥有者密码。
	 * @return 是否成功。
	 *
	 */
	public static native int		removePassword(long document, String ownerPassword);

	/**
	 * @brief 遮蔽信息恢复。
	 *
	 * @param[in]	document		文档对象。
	 *
	 */
	public static native void		infoReCover(long document);

	/**
	 * @brief 获取自定义元数据个数。
	 *
	 * @param[in]	document		文档对象。
	 * @return 成功返回自定义元数据个数，失败返回-1。
	 *
	 */
	public static native int		getCustomDataCount(long document);

	/**
	 * @brief 获取自定义元数据名称。
	 *
	 * @param[in]	document			文档句柄。	
	 * @param[in]	index				元数据关键字索引。
	 * @return 成功返回自定义元数据名称，失败返回NULL。
	 *
	 */
	public static native String		getCustomDataName(long document, int index);

	/**
	 * @brief 获取自定义元数据值。
	 *
	 * @param[in]	document			文档句柄。	
	 * @param[in]	index				元数据关键字索引。
	 * @return 成功返回自定义元数据值，失败返回NULL。
	 *
	 */
	public static native String		getCustomData(long document, int index);

	/**
	 * @brief 创建大纲根节点对象。
	 *
	 * @param[in]	document		文档对象。
	 * @return 返回大纲根节点对象。
	 *
	 */
	public static native long		createOutline(long document);

	/**
	 * @brief 创建自定义标签数组对象。
	 *
	 * @param[in]	document		文档对象。
	 * @return 无。
	 *
	 */
	public static native long		createCustomTags(long document);

	/**
	 * @brief 创建附件数组对象。
	 *
	 * @param[in]	document		文档对象。
	 * @return 返回附件数组对象。
	 *
	 */
	public static native long		createAttachments(long document);
	
	/**
	 * @brief 创建标注数组对象。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in]	index			页索引号。
	 * @return 返回标注数组对象。
	 *
	 */
	public static native long		createPageAnnots(long document, int index);
	
	/**
	 * @brief 从XML文件中导入标注。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in]	file			导入的标注文件（XML格式）。
	 * @return 返回0 成功。
	 *
	 */
	public static native int		importAnnots(long document, String file);
	
	/**
	 * @brief 导出标注。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in]	file			导出的标注文件（XML格式）。
	 * @return 返回0 成功。
	 *
	 */
	public static native int		exportAnnots(long document, String file);
	
	/**
	 * @brief 向文档中添加图像资源。
	 *
	 * @param[in]	document		文档句柄。
	 * @param[in]	filename		指定的图像文件名称。
	 * @return 图像资源ID，失败返回-1。
	 *				
	 */
	public static native int		addImageResFromFile(long document, String filename);

	/**
	 * @brief 根据名称获取元数据。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in]	key				元数据名称。
	 * @return 元数据字符串。
	 *
	 */
	public static native String		getMetadata(long document, String key);

	/**
	 * @brief 导出公文语义。
	 *
	 * @param[in]	document		文档对象。
	 * @param[in]	fileName		自定义标签数组保存的文件。	
	 * @return 无。
	 *				
	 */
	public static native void	 	exportOfficeDoc(long document, String fileName);

	/**
	 * @brief 获得公文语义根节点。
	 *
	 * @param[in]	document		文档对象。
	 * @return 公文语义根节点。
	 *				
	 */
	public static native long		getOfficeNode(long document);

	
	/**
	 * @brief remove自定义元数据值。
	 *
	 * @param[in]	document			文档句柄。	
	 * @param[in]	index				元数据关键字索引。
	 * @return 
	 *
	 */
	public static native void 		removeCustomdata(long document,int index);

}
