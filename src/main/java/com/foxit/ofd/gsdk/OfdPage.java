package com.foxit.ofd.gsdk;

/**
* @brief OfdPage
*/
public class OfdPage
{
	public final static int OFD_PAGE_BOXTYPE_BLEED			= 0;	//出血框，超出物理设备限制的额外出血区域，默认为物理区域
	public final static int OFD_PAGE_BOXTYPE_PHYSICAL		= 1;	//物理区域
	public final static int OFD_PAGE_BOXTYPE_APPLICATION	= 2;	//显示区域，页面内容实际显示或打印输出区域
	public final static int OFD_PAGE_BOXTYPE_CONTENT		= 3;	//版心区域即文件正文区域

	/**图像对象*/
	public final static int OFD_PAGEOBJECT_TYPE_IMAGE = 1;
	/**图形对象*/
	public final static int OFD_PAGEOBJECT_TYPE_PATH = 2;
	/**文字对象*/
	public final static int OFD_PAGEOBJECT_TYPE_TEXT = 3;

	/**页面不旋转*/
	public final static int OFD_PAGE_ROTATE_0 = 0;
	/**顺时针旋转90度*/
	public final static int OFD_PAGE_ROTATE_90 = 90;
	/**顺时针旋转180度*/
	public final static int OFD_PAGE_ROTATE_180 = 180;
	/**顺时针旋转270度*/
	public final static int OFD_PAGE_ROTATE_270 = 270;

	/**
	 * @brief 关闭页。
	 *
	 * @param[in] page		页对象。
	 * @return 无。
	 *				
	 */
	public static native void		close(long page);

	/**
	 * @brief 获取页索引号。
	 *
	 * @param[in] page		页对象。
	 * @return 返回页索引号，失败返回-1。
	 *				
	 */
	public static native int		getIndex(long page);

	/**
	 * @brief 获取页ID。
	 *
	 * @param[in] page		页对象。
	 * @return 成功返回页ID，失败返回-1。
	 *				
	 */
	public static native int		getID(long page);

	/**
	 * @brief 设置页面大小。
	 *
	 * @param[in] page		页对象。
	 * @param[in] with		宽度。
	 * @param[in] height	高度。
	 * @param[in] pageArea	区域值OFD_PAGE_BOXTYPE_XXX,默认为A4（210*297）。
	 * @return 无。
	 *				
	 */
	public static native void		setPageSize(long page, int with, int height, int pageArea);

	/**
	 * @brief 计算图层对象个数。
	 *
	 * @param[in] page 页对象。 
	 * @return 返回图层个数。 
	 *
	 */
	public static native int countLayer(long page);

	/**
	 * @brief 计算图层对象个数。
	 *
	 * @param[in] page 页对象。 
	 * @param[in] layer 图层索引。 
	 * @return 返回图元对象个数。 
	 *
	 */
	public static native int countPageObj(long page, int layer);

	/** 
	 * @brief 插入图层对象。 
	 *
	 * @param[in] page 页对象。 
	 * @param[in] index 插入位置。 
	 * @return 返回图层索引。 
	 * 
	 */
	public static native int insertLayer(long page, int index);

	/**
	 * @brief 设置模板页。
	 *
	 * @param[in] page		页对象。
	 * @param[in] template	模板页对象。
	 * @return 无。
	 *				
	 */
	public static native void		setTemplatePage(long page, long template);

	/**
	 * @brief 设置页面的模板属性。（呈现顺序默认为背景层）
	 *
	 * @param[in] page		 页对象。
	 * @param[in] templateid 模板序列号。
	 * @return 无。
	 *				
	 */
	public static native void		setTemplatePage2(long page, int templateid);

	/**
	 * @brief 设置页面的模板属性和呈现顺序。
	 *
	 * @param[in] page		 页对象。
	 * @param[in] templateid 模板序列号。
	 * @param[in] zorder	 呈现顺序类型，0：背景层（默认） 1：正文层 2：前景层。
	 * @return 无。
	 *				
	 */
	public static native void		setTemplatePage3(long page, int templateid, int zorder);

	/**
	 * @brief 设置模板页名称。
	 *
	 * @param[in] page		模板页对象。
	 * @param[in] name		模板页名称。
	 * @return 无。
	 *				
	 */
	public static native void		setTemplatePageName(long page, String name);

	/**
	 * @brief 添加图层对象。
	 *
	 * @param[in] page		页对象。
	 * @return 返回图层索引。
	 *				
	 */
	public static native int		addLayer(long page);

	/**
	 * @brief 添加图元对象。
	 *
	 * @param[in] page		页对象。
	 * @param[in] layer		图层索引。
	 * @param[in] type		图元对象类型，1 image, 2 path, 3 text, 4 video。
	 * @return 返回图元对象。
	 *				
	 */
	public static native long		addPageObj(long page, int layer, int type);

	/**
	 * @brief 删除图层及所属图元对象。
	 *
	 * @param[in] page		页对象。
	 * @param[in] layer		图层索引。
	 * @return 无。
	 *				
	 */
	public static native void		deleteLayer(long page, int layer);

	/**
	 * @brief 根据图元对象的名称查找图元对象。
	 *
	 * @param[in] page		页对象。
	 * @param[in] layer		图层索引。
	 * @param[in] name		图元对象的名称。
	 * @return 成功返回图元对象的索引号，失败返回-1。
	 *				
	 */
	public static native int		getPageObjIndexByName(long page, int layer, String name);

	/**
	 * @brief 删除该图层上的图元对象。
	 *
	 * @param[in] page		页对象。
	 * @param[in] layer		图层索引。
	 * @param[in] pageobj	图元对象索引。
	 * @return 无。
	 *				
	 */
	public static native void		deletePageObj(long page, int layer, int pageobj);

	/**
	 * @brief 局部涂黑。
	 *
	 * @param[in] page				页对象。
	 * @param[in] x					涂黑矩形区域,X坐标。
	 * @param[in] y					涂黑矩形区域,Y坐标。
	 * @param[in] w					涂黑矩形区域,宽度。
	 * @param[in] h					涂黑矩形区域,高度。
	 * @return 无。
	 *				
	 */
	public static native void		partBlack(long page, int x, int y, int w, int h);

	/**
	 * @brief 设置页面旋转。
	 *
	 * @param[in] page				页对象。
	 * @param[in] iRotate			旋转角度。
	 * @return 无。
	 *				
	 */
	public static native void		setRotate(long page, int iRotate);

	/**
	 * @brief 信息遮蔽（不可恢复）。
	 *
	 * @param[in] page				页对象。
	 * @param[in] x					遮蔽矩形区域,X坐标。
	 * @param[in] y					遮蔽矩形区域,Y坐标。
	 * @param[in] w					遮蔽矩形区域,宽度。
	 * @param[in] h					遮蔽矩形区域,高度。
	 * @param[in] shape				0 矩形，1 圆形。
	 * @param[in] mode				0 涂黑，1 雾化，2 马赛克。
	 * @param[in] horzBlur			高斯模糊。
	 * @param[in] vertBlur			高斯迷糊。
	 * @param[in] v					马赛克向量长度。
	 * @return 无。
	 *				
	 */
	public static native void		infoCover(long page, int x, int y, int w, int h, int shape, int mode, int horzBlur, int vertBlur, int v);

	/**
	 * @brief 信息遮蔽。
	 *
	 * @param[in] page				页对象。
	 * @param[in] x					遮蔽矩形区域,X坐标。
	 * @param[in] y					遮蔽矩形区域,Y坐标。
	 * @param[in] w					遮蔽矩形区域,宽度。
	 * @param[in] h					遮蔽矩形区域,高度。
	 * @return 无。
	 *				
	 */
	public static native void		infoCover2(long page, int x, int y, int w, int h);

	/**
	 * @brief 信息遮蔽（不可恢复）。
	 *
	 * @param[in] page				页对象。
	 * @param[in] x					遮蔽矩形区域,X坐标。
	 * @param[in] y					遮蔽矩形区域,Y坐标。
	 * @param[in] w					遮蔽矩形区域,宽度。
	 * @param[in] h					遮蔽矩形区域,高度。
	 * @param[in] shape				0 矩形，1 圆形。
	 * @param[in] mode				0 涂黑，1 雾化。
	 * @return 无。
	 *				
	 */
	public static native void		infoCover3(long page, int x, int y, int w, int h, int shape, int mode);

	/**
	 * @brief 将页面渲染成图片。
	 *
	 * @param[in] page				页对象。
	 * @param[in] dpi				每英寸像素数。
	 * @param[in] imgType			图像编码格式，1 bmp, 2 jpg, 3 png。
	 * @param[in] file				图像保存文件。
	 * @return 正确，返回0。
	 *				
	 */
	public static native int		render(long page, int dpi, int imgType, String file);

	/**
	 * @brief 将页面渲染成图片。
	 *
	 * @param[in] page				页对象。
	 * @param[in] dpi				每英寸像素数。
	 * @param[in] imgType			图像编码格式，1 bmp, 2 jpg, 3 png。
	 * @return 字节流。
	 *				
	 */
	public static native byte[]		renderToByteArray(long page, int dpi, int imgType);

	/**
	 * @brief 获取图元对象。
	 *
	 * @param[in] page		页对象。
	 * @param[in] id		图元对象ID号。
	 * @return 返回图元对象。
	 *				
	 */
	public static native long		getPageObj(long page, int id);

	/**
	 * @brief 获取指定图元对象。
	 *
	 * @param[in] page		页对象。
	 * @param[in] layer		图层索引。
	 * @param[in] index		图元对象索引。
	 * @return 返回图元对象。
	 *				
	 */
	public static native long		getPageObj2(long page, int layer,int index);
}