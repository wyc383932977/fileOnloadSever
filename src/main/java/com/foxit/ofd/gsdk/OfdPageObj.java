package com.foxit.ofd.gsdk;
import java.awt.Rectangle;

/**
* @brief OfdPageObj
*/
public class OfdPageObj
{
	public final static int OFD_PAGEOBJECT_TYPE_IMAGE = 1;
	public final static int OFD_PAGEOBJECT_TYPE_PATH = 2;
	public final static int OFD_PAGEOBJECT_TYPE_TEXT = 3;

	/**水平居左对齐（默认）*/
	public final static int OFD_TEXT_ALIGNMENT_LEFT = 0;
	/**水平居中对齐*/
	public final static int OFD_TEXT_ALIGNMENT_CENTER = 1;
	/**水平居右对齐*/
	public final static int OFD_TEXT_ALIGNMENT_RIGHT = 2;
	/**垂直居上对齐（默认）*/
	public final static int OFD_TEXT_ALIGNMENT_TOP = 0;
	/**垂直居中对齐*/
	public final static int OFD_TEXT_ALIGNMENT_VCENTER = 1;
	/**垂直居下对齐*/
	public final static int OFD_TEXT_ALIGNMENT_BOTTOM = 2;
	/**不旋转（默认）*/
	public final static int OFD_TEXT_CLOCKWISE_ROTATE_0 = 0;
	/**顺时针旋转90度*/
	public final static int OFD_TEXT_CLOCKWISE_ROTATE_90 = 1;
	/**顺时针旋转270度*/
	public final static int OFD_TEXT_CLOCKWISE_ROTATE_270 = 2;
	/**竖排版文字排列方向：从左至右（默认）*/
	public final static int OFD_TEXT_VERTICAL_LEFTTORIGHT = 0;
	/**竖排版文字排列方向：从右至左*/
	public final static int OFD_TEXT_VERTICAL_RIGHTTOLEFT = 1;

	/**
	* 图像类型定义
	*/
	public final static int OFD_IMAGE_FORMAT_BMP = 1;  //bmp格式
	public final static int OFD_IMAGE_FORMAT_JPG = 2;  //jpg格式
	public final static int OFD_IMAGE_FORMAT_PNG = 3;  //png格式
	public final static int OFD_IMAGE_FORMAT_TIF = 4;  //tif格式
	public final static int OFD_IMAGE_FORMAT_GIF = 5;  //gif格式
	public final static int OFD_IMAGE_FORMAT_JP2 = 6;  //jp2格式

	/**
	 * @brief 获取图元对象的ID。
	 *
	 * @param[in] pageObj	图元对象。
	 * @return 图元对象ID。
	 *				
	 */
	public static native int		getID(long pageObj);

	/**
	 * @brief 获取图元对象的类型。
	 *
	 * @param[in] pageObj	图元对象。
	 * @return 图元对象类型。
	 *				
	 */
	public static native int		getType(long pageObj);

	/**
	 * @brief 获取文本对象的字体名称。
	 *
	 * @param[in] textObj	图元对象。
	 * @return 字体名称。
	 *				
	 */
	public static native String		getFontName(long textObj);

	/**
	 * @brief 获取文本对象的字体大小。
	 *
	 * @param[in] textObj	图元对象。
	 * @return 字体大小。
	 *				
	 */
	public static native float		getFontSize(long textObj);

	/**
	 * @brief 设置图元对象的名称。
	 *
	 * @param[in] pageObj		图元对象。
	 * @param[in] name			图元对象的名称。
	 * @return 无。
	 *				
	 */
	public static native void		setName(long pageObj, String name);

	/**
	 * @brief 设置图元对象可见性属性。
	 *
	 * @param[in] pageObj		图元对象（Path\Image\Text）。
	 * @param[in] visible		可见性属性值（设置为1可见，0不可见）。
	 * @return 无。
	 *				
	 */
	public static native void		setVisible(long pageObj, int visible);

	/**
	 * @brief 设置图元对象外框。
	 *
	 * @param[in] pageObj		图元对象（Path\Image\Text）。
	 * @param[in] x				外框X坐标。
	 * @param[in] y				外框Y坐标。
	 * @param[in] w				外框宽度。
 	 * @param[in] h				外框高度。
	 * @return 无。
	 *				
	 */
	public static native void		setBoundary(long pageObj, float x, float y, float w, float h);	

	/**
	 * @brief 设置图元对象坐标变换矩阵。
	 *
	 * @param[in] pageObj		图元对象（Path\Image\Text）。
	 * @param[in] a				矩阵a值。
	 * @param[in] b				矩阵b值。
	 * @param[in] c				矩阵c值。
	 * @param[in] d				矩阵d值。
	 * @param[in] e				矩阵e值。
	 * @param[in] f				矩阵f值。
	 * @return 无。
	 *				
	 */
	public static native void		setCTM(long pageObj, float a, float b, float c, float d, float e, float f);
	
	/**
	 * @brief 设置图元对象alpha属性。
	 *
	 * @param[in] pageObj		图元对象（Path\Text）。
	 * @param[in] alpha			alpha值（0-255）。
	 * @return 无。
	 *				
	 */
	public static native void		setAlpha(long pageObj, int alpha);

	/**
	 * @brief 设置图元对象是否填充。
	 *
	 * @param[in] pageObj		图元对象（Path\Text)。
	 * @param[in] set			设置为1填充，0不填充。
	 * @return 无。
	 *				
	 */
	public static native void		setFill(long pageObj, int set);

	/**
	 * @brief 设置图元对象填充模式（默认为非零填充）。
	 *
	 * @param[in] pageObj		图元对象（Path\Text)。
	 * @param[in] fillmode		填充模式值（0为非零填充，1为奇偶填充）。
	 * @return 无。
	 *				
	 */
	public static native void		setFillMode(long pageObj, int fillmode);

	/**
	 * @brief 设置图元对象填充颜色。
	 *
	 * @param[in] pageObj		图元对象（Path\Text）。
	 * @param[in] fillColor		颜色值。
	 * @return 无。
	 *				
	 */
	public static native void		setFillColor(long pageObj, int fillColor);

	/**
	 * @brief 设置图元对象底纹填充单元。
	 *
	 * @param[in] pageObj		图元对象（Path\Text）。
	 * @param[in] pattern		底纹填充单元。
	 * @return 无。
	 *				
	 */
	public static native void		setFillPattern(long pageObj, long pattern);

	/**
	 * @brief 设置图元对象轴向渐变填充属性。	
	 *
	 * @param[in] pageObj		图元对象（Path\Text）。
	 * @param[in] start_x		起始点坐标x(单位毫米)。
	 * @param[in] start_y		起始点坐标y(单位毫米)。
	 * @param[in] end_x			结束点坐标x(单位毫米)。
	 * @param[in] end_y			结束点坐标y(单位毫米)。
	 * @param[in] startColor	起始颜色。
	 * @param[in] endColor		结束颜色。
	 * @param[in] segs_position	颜色段，位置值。
	 * @param[in] segs_color	颜色段，颜色值。
	 * @param[in] mapType		渐变绘制的方式（取值范围: 0直接填充，1重复填充，2映射填充）。
	 * @param[in] mapUnit		当mapType值不为Direct时，表示轴线上一个渐变区间的长度(单位毫米)。
	 * @param[in] extend;		轴延伸方向是否继续绘制渐变。0：不向两侧继续绘制渐变；1：在结束点至起始点延长线方向绘制渐变；2：在起始点至结束点延长线方向绘制渐变；
	 *							3：向两侧延长线方向绘制渐变。默认值为0。
	 * @return 无。
	 *				
	 */
	public static native void		setFillAxialShd(long pageObj, float start_x, float start_y, float end_x, float end_y,
	int startColor, int endColor, float[] segs_position, int[] segs_color, int mapType, int mapUnit, int extend);

	/**
	 * @brief 设置图元对象径向渐变填充属性。
	 *
	 * @param[in] pageObj		图元对象（Path\Text）。
	 * @param[in] start_x		起始点坐标x(单位毫米)。
	 * @param[in] start_y		起始点坐标y(单位毫米)。
	 * @param[in] end_x			结束点坐标x(单位毫米)。
	 * @param[in] end_y			结束点坐标y(单位毫米)。
	 * @param[in] startRadius
	 * @param[in] endRadius
	 * @param[in] eccentricity
	 * @param[in] angle
	 * @param[in] startColor	起始颜色。
	 * @param[in] endColor		结束颜色。
	 * @param[in] segs_position	颜色段，位置值。
	 * @param[in] segs_color	颜色段，颜色值。
	 * @param[in] mapType		渐变绘制的方式（取值范围OFDSDK_SHADINGMAP_DIRECT，OFDSDK_SHADINGMAP_REPEAT，OFDSDK_SHADINGMAP_REFLECT）。
	 * @param[in] mapUnit		当mapType值不为Direct时，表示轴线上一个渐变区间的长度(单位毫米)。
	 * @param[in] extend;		轴延伸方向是否继续绘制渐变。0：不向两侧继续绘制渐变；1：在结束点至起始点延长线方向绘制渐变；2：在起始点至结束点延长线方向绘制渐变；
	 *							3：向两侧延长线方向绘制渐变。默认值为0。
	 *				
	 */
	public static native void		setFillRadialShd(long pageObj, float start_x, float start_y, float end_x, float end_y,
	float startRadius, float endRadius, float eccentricity, float angle, int startColor, int endColor, float[] segs_position, int[] segs_color, int mapType, int mapUnit, int extend);

	/**
	 * @brief 设置图元对象是否勾边。
	 *
	 * @param[in] pageObj		图元对象（Path\Text)。
	 * @param[in] set			设置为1勾边，0不勾边。
	 * @return 无。
	 *				
	 */
	public static native void		setStroke(long pageObj, int set);

	/**
	 * @brief 设置图元对象勾边颜色。
	 *
	 * @param[in] pageObj		图元对象（Path\Text)。
	 * @param[in] strokeColor	颜色值。
	 * @return 无。
	 *				
	 */
	public static native void		setStrokeColor(long pageObj, int strokeColor);

	/**
	 * @brief 设置图形对象线宽。
	 *
	 * @param[in] pathObj		图形对象（Path）。
	 * @param[in] width			线宽值（单位毫米）。
	 * @return 无。
	 *				
	 */
	public static native void		setLineWidth(long pathObj, float width);

	/**
	 * @brief 设置图形对象线帽样式。
	 *
	 * @param[in] pathObj		图元对象（Path）。
	 * @param[in] linecap		线帽样式值（0 BUTT，1 ROUND，2 SQUARE）。
	 * @return 无。
	 *				
	 */
	public static native void		setLineCap(long pathObj, int linecap);

	/**
	 * @brief 设置图形对象结合点样式。
	 *
	 * @param[in] pathObj		图形对象（Path）。
	 * @param[in] linejoin		结合点样式值（0 MITER，1 ROUND，2 BEVEL）。
	 * @return 无。
	 *				
	 */
	public static native void		setLineJoin(long pathObj, int linejoin);

	/**
	 * @brief 设置图形对象斜切限制值。
	 *
	 * @param[in] pathObj		图形对象（Path）。
	 * @param[in] miterLimit	斜切限制值。
	 * @return 无。
	 *				
	 */
	public static native void		setMiterLimit(long pathObj, float miterLimit);

	/**
	 * @brief 设置图形对象虚线重复样式。
	 *
	 * @param[in] pageObj		图形对象（Path）。
	 * @param[in] dashOffset	图形对象虚线重复起始值
	 * @param[in] dashPatters	重复样式点数据。
	 * @return 无。
	 *				
	 */
	public static native void		setDashPattern(long pathObj, float dashOffset, float[] dashPatters);

	/**
	 * @brief 设置路形对象中路径元素描述序列。
	 *
	 * @param[in] pageObj		图形对象（Path）。
	 * @param[in] abbreviteData	路径元素描述序列（序列中点列坐标应为相对于boundary原点的相对坐标）。
	 * @return 无。
	 *				
	 */
	public static native void		setAbbreviteData(long pathObj, String abbreviteData);

	/**
	 * @brief 设置路径对象中路径元素描述序列。
	 *
	 * @param[in] pathObj		文字对象。
	 * @param[in] abbreviteData	路径元素描述序列（序列中点列坐标应为相对于boundary原点的相对坐标）。
	 * @param[in] colorValue	颜色值。
	 * @param[in] colorType		填充类型（0：fillColor，1：strokeColor）。
	 * @return 无。
	 *				
	 */
	public static native void		setAbbreviteData2(long pathObj,String abbreviteData,int colorValue, int colorType);

	/**
	 * @brief 获取文字对象结束位置相对于boundary的偏移量。（富文本排版）
	 *
	 * @param[in] textObj		文字对象。
	 * @return x、y轴偏移量。
	 *				
	 */
	public static native float[]	getTextEndOffset(long textObj);

	/**
	 * @brief 设置图形路径对象。
	 *
	 * @param[in] pageObj		图形对象（Path）。
	 * @param[in] path			图路对象。
	 * @return 无。
	 *				
	 */
	public static native void		setPath(long pageObj, long path);

	/**
	 * @brief 设置图片。
	 *
	 * @param[in] imgObj		图像对象（Image）。
	 * @param[in] filename		图片文件。
	 * @return 无。
	 *				
	 */
	public static native void		setImageFromFile(long imgObj, String filename);

	/**
	 * @brief 设置图片。
	 *
	 * @param[in] imgObj		图像对象（Image）。
	 * @param[in] filebuf		图片数据。
	 * @param[in] type			图片类型。
	 * @return 无。
	 *				
	 */
	public static native void		setImageFromBuf(long imgObj, byte[] filebuf, int type);

	/**
	 * @brief 设置线。
	 *
	 * @param[in] pathObj		路径对象。
	 * @param[in] start_x		起始点x坐标。
	 * @param[in] start_y		起始点y坐标。
	 * @param[in] end_x			终止点x坐标。
	 * @param[in] end_y			终止点y坐标。
	 * @param[in] width			线宽。
	 * @param[in] color			颜色。
	 * @return 无。
	 *				
	 */
	public static native void		setLine(long pathObj, float start_x, float start_y, float end_x, float end_y, float width, int color);

	/**
	 * @brief 添加特殊发票字符 O×。
	 *
	 * @param[in] pathObj		路径对象。
	 * @param[in] x				x坐标。
	 * @param[in] y				y坐标。
	 * @return 无。
	 *				
	 */
	public static native void		specialcharacter(long pathObj, float x, float y);

	/**
	 * @brief 设置字符串。
	 *
	 * @param[in] textObj		文字对象。
	 * @param[in] text			字符串。
	 * @param[in] x				x坐标。
	 * @param[in] y				y坐标。
	 * @param[in] label			是否比较文字内容宽度与BOUNDARY的宽度，0 是， 1 否。
	 * @return FALSE 失败，TRUE 成功。
	 *				
	 */
	public static native int		setText(long textObj, String text, float x, float y, int label);

	/**
	 * @brief 设置字符串。
	 *
	 * @param[in] textObj		文字对象。
	 * @param[in] text			字符串。
	 * @return 无。
	 *				
	 */
	public static native void		setText2(long textObj, String text);

	/**
	 * @brief 设置文字对象的字体对象。
	 *
	 * @param[in] textObj		文字对象（Text）。
	 * @param[in] fontObj		字体对象。
	 * @return 无。
	 *				
	 */
	public static native void		setFont(long textObj, long fontObj);

	/**
	 * @brief 设置文字对象的字体名称。
	 *
	 * @param[in] textObj		文字对象（Text）。
	 * @param[in] name			字体名称。
	 * @return 无。
	 *				
	 */
	public static native void		setFontName(long textObj, String name);

	/**
	 * @brief 设置文字对象的字体名称。
	 *
	 * @param[in] textObj		文字对象。
	 * @param[in] name			字体名称。
	 * @return 无。
	 *				
	 */
	public static native void		setFontName2(long textObj, String name);

	/**
	 * @brief 设置文字对象的备选字体名称。
	 *
	 * @param[in] textObj		文字对象。
	 * @param[in] name			字体名称。
	 * @return 无。
	 *				
	 */
	public static native void		setSubFontName(long textObj, String name);

	/**
	 * @brief 设置文字对象的字体大小。
	 *
	 * @param[in] textObj		文字对象（Text）。
	 * @param[in] fFontSize		字体大小值。
	 * @return 无。
	 *				
	 */
	public static native void		setFontSize(long textObj, float fFontSize);

	/**
	 * @brief 设置文字对象的字体大小。
	 *
	 * @param[in] textObj		文字对象。
	 * @param[in] fFontSize		字体大小值。
	 * @return 无。
	 *				
	 */
	public static native void		setFontSize2(long textObj, float fFontSize);

	/**
	 * @brief 设置文字对象的水平缩放属性。
	 *
	 * @param[in] textObj		文字对象（Text）。
	 * @param[in] hScale		设定的水平缩放值。
	 * @return 无。
	 *				
	 */
	public static native void		setHScale(long textObj, float hScale);

	/**
	 * @brief 设置文字对象的阅读方向属性。
	 *
	 * @param[in] textObj		文字对象（Text）。
	 * @param[in] readDirection	设定的阅读方向值（0 默认值，从左往右阅读，90 从上往下阅读，180 从右往左阅读，270 从下往上阅读）。
	 * @return 无。
	 *				
	 */
	public static native void		setReadDirection(long textObj, int readDirection);

	/**
	 * @brief 设置文字对象的字符方向属性。
	 *
	 * @param[in] textObj		文字对象（Text）。
	 * @param[in] charDirection	设定的字符方向值（0 默认值,，90 文字顺时针旋转90度，180 文字顺时针旋转180度，270 文字顺时针旋转270度）。
	 * @return 无。
	 *				
	 */
	public static native void		setCharDirection(long textObj, int charDirection);

	/**
	 * @brief 设置文字对象的粗细度属性。
	 *
	 * @param[in] textObj		文字对象（Text）。
	 * @param[in] weight		设定的粗细度值(可选取值为100,200,300,400,500,600,700,800,900,默认值为400,取值为其它值时按照默认值处理)。
	 * @return 无。
	 *				
	 */
	public static native void		setWeight(long textObj, int weight);

	/**
	 * @brief 设置文字对象的粗细度属性。
	 *
	 * @param[in] textObj		文字对象。
	 * @param[in] weight		设定的粗细度值(可选取值为100,200,300,400,500,600,700,800,900,默认值为400,取值为其它值时按照默认值处理)。
	 * @return 无。
	 *				
	 */
	public static native void		setWeight2(long textObj, int weight);

	/**
	 * @brief 设置文字对象的斜体属性。
	 *
	 * @param[in] textObj		文字对象（Text）。
	 * @param[in] bItalic		设置为1为斜体，0为非斜体。
	 * @return 无。
	 *				
	 */
	public static native void		setItalic(long textObj, int bItalic);

	/**
	 * @brief 设置文字对象的斜体属性。
	 *
	 * @param[in] textObj		文字对象。
	 * @param[in] bItalic		设置为TRUE为斜体，FALSE为非斜体。
	 * @return 无。
	 *				
	 */
	public static native void		setItalic2(long textObj, int bItalic);

	/**
	 * @brief 设置文字对象的最大字体大小。（富文本排版）
	 *
	 * @param[in] textObj		文字对象。
	 * @param[in] fFontSize		字体大小值。
	 * @return 无。
	 *				
	 */
	public static native void		setRTFFontSize(long textObj, float fFontSize);

	/**
	 * @brief 设置文字对象文本行对齐方式。
	 *
	 * @param[in] textObj		文字对象。
	 * @param[in] hAlign		文本行对齐方式。
	 * @return 无。
	 *				
	 */
	public static native void		setHAlignment(long textObj, int hAlign);

	/**
	 * @brief 设置文字对象文本纵向对齐方式。
	 *
	 * @param[in] textObj		文字对象。
	 * @param[in] vAlign		文本纵向对齐方式。
	 * @return 无。
	 *				
	 */
	public static native void		setVAlignment(long textObj, int vAlign);

	/**
	 * @brief 设置文字对象文本横向两端对齐方式。
	 *
	 * @param[in] textObj		文字对象。
	 * @return 无。
	 *				
	 */
	public static native void		setJustifiedX(long textObj);

	/**
	 * @brief 设置文字对象文本纵向两端对齐方式。
	 *
	 * @param[in] textObj		文字对象。
	 * @return 无。
	 *				
	 */
	public static native void		setJustifiedY(long textObj);

	/**
	 * @brief 设置文字对象文本行自动折行。
	 *
	 * @param[in] textObj		文字对象。
	 * @param[in] bSet			是否自动折行。
	 * @return 无。
	 *				
	 */
	public static native void		setMultiline(long textObj, int bSet);

	/**
	 * @brief 设置文字行字符个数。
	 *
	 * @param[in] textObj		文字对象。
	 * @param[in] num			行字符个数。
	 * @return 无。
	 *				
	 */
	public static native void		setLineCharNum(long textObj, int num);

	/**
	 * @brief 设置文字行字节个数。
	 *
	 * @param[in] textObj		文字对象。
	 * @param[in] bitNum		行字符个数。
	 * @return 无。
	 *				
	 */
	public static native void		setLineBitNum(long textObj, int bitNum);

	/**
	 * @brief 设置文字行间距。
	 *
	 * @param[in] textObj		文字对象。
	 * @param[in] lineSpace		行间距大小。
	 * @return 无。
	 *				
	 */
	public static native void		setLineSpace(long textObj, float lineSpace);

	/**
	 * @brief 设置文字行断行字符。
	 *
	 * @param[in] textObj		文字对象。
	 * @param[in] lineBreak		断行字符。
	 * @return 无。
	 *				
	 */
	public static native void		setLineBreak(long textObj, String lineBreak);

	/**
	 * @brief 设置文字旋转角度。
	 *
	 * @param[in] textObj		文字对象。
	 * @param[in] iRotate		旋转角度（0不旋转，1顺时针旋转90度，2顺时针旋转270度）。
	 * @return 无。
	 *				
	 */
	public static native void		setRotate(long textObj, int iRotate);

	/**
	 * @brief 设置文字对象文本行自适应字体大小。
	 *
	 * @param[in] textObj		文字对象。
	 * @param[in] bSet			是否自适应字体大小。
	 * @return 无。
	 *				
	 */
	public static native void		setAutoSize(long textObj, int bSet);

	/**
	 * @brief 设置文字竖排版。
	 *
	 * @param[in] textObj		文字对象。
	 * @return 无。
	 *				
	 */
	public static native void		setVerticalType(long textObj);

	/**
	 * @brief 设置竖排版文字方向。
	 *
	 * @param[in] textObj		文字对象。
	 * @param[in] order			竖排版时文字排列方向。0：从左至右（默认），1：从右至左
	 * @return 无。
	 *				
	 */
	public static native void		setVerticalOrder(long textObj, int order);

	/**
	 * @brief 设置字体缩小步长。
	 *
	 * @param[in] textObj		文字对象。
	 * @param[in] deflateunit	缩小步长，默认值为0.35f。
	 * @return 无。
	 *				
	 */
	public static native void		setDeflateUnit(long textObj, float deflateunit);

	/**
	 * @brief 计算单行文本排版大小。
	 *
	 * @param[in]	text			排版内容。	
	 * @param[in]	fontName		字体名称。	
	 * @param[in]	fontSize		字体大小。
	 * @param[out]	rect			返回RECT值
	 * @return 成功返回查找矩形，失败返回矩形值为0。
	 *				
	 */
	public static native void		calcTextBox(String text, String fontName, float fontSize, Rectangle rect);

	/**
	 * @brief 计算多行文本排版大小。
	 *
	 * @param[in]	text			排版内容。	
	 * @param[in]	fontName		字体名称。	
	 * @param[in]	fontSize		字体大小。
	 * @param[in]	lineWidth		行宽。
	 * @param[out]	rect			返回RECT值
	 * @return 成功返回查找矩形，失败返回矩形值为0。
	 *				
	 */
	public static native void		calcTextBoxByWidth(String text, String fontName, float fontSize, float lineWidth, Rectangle rect);

	/**
	 * @brief 更新文字对象布局。
	 *
	 * @param[in] textObj		文字对象。
	 * @return 无。
	 *				
	 */
	public static native void		updateLayout(long textObj);

	/**
	 * @brief 设置文字对象的字符信息。
	 *
	 * @param[in] textObj		文字对象（Text）。
	 * @param[in] charcode		文字的UNICODE编码值。
	 * @param[in] origin_x		文字位置（左下点）：相对于图元对象boundary起始点的x坐标，单位mm。
	 * @param[in] origin_y		文字位置（左下点）：相对于图元对象boundary起始点的y坐标，单位mm。
	 * @return 无。
	 *				
	 */
	public static native void		setCharInfos(long textObj, int[] charcode, float[] origin_x, float[] origin_y);

	/**
	 * @brief 设置文字对象的字符信息(文字块)。
	 *
	 * @param[in] textObj		文字对象（Text）。
	 * @param[in] pieceInfo		文字块信息指针。
	 * @return 无。
	 *				
	 */
	public static native void		setTextPieceInfo(long textObj, long pieceInfo);

	/**
	 * @brief 设置文字对象起始位置相对于boundary的偏移量。（富文本排版）
	 *
	 * @param[in] textObj		文字对象。
	 * @param[in] x				x轴偏移量。
	 * @param[in] y				y轴偏移量。
	 * @return 无。
	 *				
	 */
	public static native void		setTextStartOffset(long textObj, float x, float y);

	/**
	 * @brief 设置文字对象颜色
	 *
	 * @param[in]	textObj		文字对象。
	 * @param[in]	color		颜色值。
	 * @return 无
	 *				
	 */
	public static native void		setColor(long textObj, int color);

	/**
	 * @brief 通过文件设置Video对象中的图像。
	 *
	 * @param[in] videoObj		Video对象句柄。
	 * @param[in] filename		指定的Video文件名称。
	 * @return 无。
	 *				
	 */
	public static native void		setVideoFromFile(long videoObj, String filename);

	/**
	 * @brief 获取Video资源ID。
	 *
	 * @param[in] videoObj		Video对象句柄。
	 * @return 返回video资源ID。
	 *				
	 */
	public static native int		GetVideoObjResID(long videoObj);

	/**
	 * @brief 设置Video对象类型。
	 *
	 * @param[in] videoObj		Video对象句柄。
	 * @param[in] type			指定Video的类型。
	 * @return 无。
	 *				
	 */
	public static native void		setVideoType(long videoObj, String type);

	/**
	 * @brief 设置Video对象格式。
	 *
	 * @param[in] videoObj		Video对象句柄。
	 * @param[in] format		指定Video的格式。
	 * @return 无。
	 *				
	 */
	public static native void		setVideoFormat(long videoObj, String format);

	/**
	 * @brief 设置Video对象标题。
	 *
	 * @param[in] videoObj		Video对象句柄。
	 * @param[in] title			指定Video的标题。
	 * @return 无。
	 *				
	 */
	public static native void		setVideoTitle(long videoObj, String title);

	/**
	 * @brief 创建Video对象边框。
	 *
	 * @param[in] videoObj		Video对象句柄。
	 * @return 无。
	 *				
	 */
	public static native void		createVideoBorder(long videoObj);

	/**
	 * @brief 设置Video边框线宽。
	 *
	 * @param[in] videoObj		Video对象句柄。
	 * @param[in] width			指定边框线宽。
	 * @return 无。
	 *				
	 */
	public static native void		setVideoLineWidth(long videoObj, float width);

	/**
	 * @brief 设置Video边框虚线重复样式。
	 *
	 * @param[in] videoObj		Video对象句柄。
	 * @param[in] dashOffset	图形对象虚线重复起始值
	 * @param[in] dashPatters	重复样式点数据。
	 * @return 无。
	 *				
	 */
	public static native void		setVideoDashPattern(long videoObj, float dashOffset, float[] dashPatters);

	/**
	 * @brief 设置Video边框角落半径。
	 *
	 * @param[in] videoObj		Video对象句柄。
	 * @param[in] HCRadius		指定边框横向圆角半径。
	 * @param[in] VCRadius		指定边框纵向圆角半径。
	 * @return 无。
	 *				
	 */
	public static native void		setVideoCornerRadius(long videoObj, float HCRadius, float VCRadius);

	/**
	 * @brief 设置Video边框颜色。
	 *
	 * @param[in] videoObj		Video对象句柄。
	 * @param[in] color			颜色值。
	 * @return 无。
	 *				
	 */
	public static native void		setVideoStrokeColor(long videoObj, int color);

	/**
	 * @brief 添加裁剪区句柄。
	 *
	 * @param[in] pageObj		页面对象。
	 * @return 返回裁剪区句柄。
	 *				
	 */
	public static native long		createClipRegion(long pageObj);

	/**
	 * @brief 设置页面对象动作数组句柄。
	 *
	 * @param[in] pageObj		页面对象。
	 * @return 返回页面对象动作数组句柄。
	 *				
	 */
	public static native long		createActions(long pageObj);
}
