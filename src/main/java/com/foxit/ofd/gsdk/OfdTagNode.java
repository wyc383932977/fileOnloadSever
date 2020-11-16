package com.foxit.ofd.gsdk;

/**
* @brief OfdTagNode 获取票据标引
*/
public class OfdTagNode
{
	/**
	 * @brief 获取票据标引子节点个数。
	 *
	 * @param[in]	hNode	票据标引节点对象。	
	 * @return 票据标引子节点个数。
	 *				
	 */
	public static native int		countChild(long hNode);
	
	/**
	 * @brief 获取票据标引子节点。
	 *
	 * @param[in]	hNode	票据标引父节点对象。
	 * @param[in]	index	索引。
	 * @return 票据标引子节点对象。
	 *				
	 */
	public static native long		getChild(long hNode, int index);

	/**
	 * @brief 获取票据标引键。
	 *
	 * @param[in]	hNode	票据标引节点对象。
	 * @return 标引键。
	 *				
	 */
	public static native String		getTagKey(long hNode);

	/**
	 * @brief 获取票据标引关联图元对象个数。
	 *
	 * @param[in]	hNode	票据标引节点对象。
	 * @return 图元图像个数。
	 *				
	 */
	public static native int		countPageObj(long hNode);

	/**
	 * @brief 获取票据标引关联图元对象。
	 *
	 * @param[in]	hNode	票据标引节点对象。
	 * @param[in]	index	图元对象索引。
	 * @return 图元图像。
	 *				
	 */
	public static native long		getPageObj(long hNode, int index);

	/**
	 * @brief 获取票据标引关联文本。
	 *
	 * @param[in]	hNode	票据标引节点对象。
	 * @return 文本。
	 *				
	 */
	public static native String		getText(long hNode);

}
