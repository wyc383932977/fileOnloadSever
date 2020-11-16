package com.foxit.ofd.gsdk;

/**
* @brief OfdTagTree 设置票据标引
*/
public class OfdTagTree
{
	/**
	 * @brief 初始化一个票据标引。
	 *
	 * @param[in]	doc					文档句柄。	
	 * @param[in]	tagType				票据标引类型，例如电子证照“cert”。
	 * @param[in]	tagNameSpace		票据标引命名空间，例如电子证照“cert”。
	 * @param[in]	tagName				票据标引名称，例如“电子证照”。
	 * @param[in]	tagFileExt			票据标引文件扩展名，例如电子证照“Certificate”，生成的标引文件"Tag_Certificate.xml"。
	 * @param[in]	keyUnique			票据标引键值是否唯一，1：唯一，0：不唯一。
	 * @return 无。
	 *				
	 */
	public static native void		initTTNode(long doc, String tagType, String tagNameSpace, String tagName, String tagFileExt, int keyUnique);
	
	/**
	 * @brief 初始化一个电子证照标引。
	 *
	 * @param[in]	doc					文档句柄。
	 * @param[in]	keyUnique			票据标引键值是否唯一，1：唯一，0：不唯一。
	 * @return 无。
	 *				
	 */
	public static native void		initTTNode_Cert(long doc, int keyUnique);
	
	/**
	 * @brief 自定义一个票据标引。
	 *
	 * @param[in]	doc					文档句柄。	
	 * @param[in]	tagKeyPath			票据标引键值路径。
	 * @return 无。
	 *				
	 */
	public static native void		beginTTNode(long doc, String tagKeyPath);

	/**
	 * @brief 自定义一个票据元数据。
	 *
	 * @param[in]	doc					文档句柄。	
	 * @param[in]	data				元数据值。
	 * @param[in]	type				元数据类型。
	 * @return 无。
	 *				
	 */
	public static native void		insertMetaData(long doc, String data, String type);

	/**
	 * @brief 结束一个票据标引。
	 *
	 * @param[in]	doc					文档句柄。	
	 * @param[in]	tagKeyPath			票据标引键值路径。
	 * @return 无。
	 *				
	 */
	public static native void		endTTNode(long doc, String tagKeyPath);

	/**
	 * @brief 获得票据标引根节点。
	 *
	 * @param[in]	doc					文档句柄。
	 * @param[in]	tagType				票据标引类型，例如电子证照“cert”。	 
	 * @return 票据标引根节点。
	 *				
	 */
	public static native long		getRoot(long doc, String tagType);
}
