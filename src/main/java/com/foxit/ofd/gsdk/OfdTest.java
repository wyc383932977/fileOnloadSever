package com.foxit.ofd.gsdk;

import java.awt.Rectangle;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ByteArrayOutputStream; 
import java.io.RandomAccessFile; 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
* @brief eisdk应用示例
*/
public class OfdTest
{
	/** @brief 序列号 */
	private static String _serial = "FSGCZ-L3017-289FF-GJQGJ-F656D";
	
	/** @brief 验证码 */
	private static String _validCode = "../testcase";
	
	/** @brief 测试文件路径 */
	/** @brief 创建发票模板 */
	private String _fp_create = "../testcase/fp_create.ofd";
	/** @brief 已存在发票模板 */
	private String _fp_template = "../testcase/fp_template.ofd";
	/** @brief 保存发票数据后的文件 */
	private String _fp_template_setdata = "../testcase/fp_template_setdata.ofd";
	/** @brief 测试需要的图片*/
	private String _fileImage = "../testcase/stamp.png";
	/** @brief 页面图片*/
	private String _pageImage = "../testcase/page_0";

	private String _getData = "../testcase/1.ofd";
	private String _setFormData = "../testcase/2.ofd";
	private String _removeTemplatePageSrc = "../testcase/tempSrc.ofd";
	private String _removeTemplatePageDst = "../testcase/tempDst.ofd";
	
	private String SEALPATH_x86 = "../seal/Foxit/x86";
	private String SEALPATH_x64 = "../seal/Foxit/x64";

	/** 1pt等于0.35mm*/
	private float PT = 0.35f;

	/** @brief TextObject坐标 */ 
	private float SETCOORDINATE_TICKET_FP_DM_X = 169.83f;
	private float SETCOORDINATE_TICKET_FP_DM_Y = 4.49f;
	private float SETCOORDINATE_TICKET_FP_DM_W = 37.9f;
	private float SETCOORDINATE_TICKET_FP_DM_H = 3.81f;

	private float SETCOORDINATE_TICKET_FP_HM_X = 169.83f;
	private float SETCOORDINATE_TICKET_FP_HM_Y = 10.59f;
	private float SETCOORDINATE_TICKET_FP_HM_W = 37.9f;;
	private float SETCOORDINATE_TICKET_FP_HM_H = 3.81f;

	private float SETCOORDINATE_TICKET_FP_RQ_X = 169.83f;
	private float SETCOORDINATE_TICKET_FP_RQ_Y = 16.59f;
	private float SETCOORDINATE_TICKET_FP_RQ_W = 43.9f;;
	private float SETCOORDINATE_TICKET_FP_RQ_H = 3.81f;

	private float SETCOORDINATE_TICKET_FP_JYM_X = 169.83f;
	private float SETCOORDINATE_TICKET_FP_JYM_Y = 22.59f;
	private float SETCOORDINATE_TICKET_FP_JYM_W = 42.9f;
	private float SETCOORDINATE_TICKET_FP_JYM_H = 3.81f;

	private float SETCOORDINATE_TICKET_FP_JQBH_X = 26.00f;
	private float SETCOORDINATE_TICKET_FP_JQBH_Y = 22.48f;
	private float SETCOORDINATE_TICKET_FP_JQBH_W = 37.9f;
	private float SETCOORDINATE_TICKET_FP_JQBH_H = 3.81f;

	private float SETCOORDINATE_TICKET_BUYER_MC_X = 38.89f;
	private float SETCOORDINATE_TICKET_BUYER_MC_Y = 29.54f;
	private float SETCOORDINATE_TICKET_BUYER_MC_W = 77.0f;
	private float SETCOORDINATE_TICKET_BUYER_MC_H = 3.81f;

	private float SETCOORDINATE_TICKET_BUYER_NSRSBH_X = 38.89f;
	private float SETCOORDINATE_TICKET_BUYER_NSRSBH_Y = 35.11f;
	private float SETCOORDINATE_TICKET_BUYER_NSRSBH_W = 77.0f;
	private float SETCOORDINATE_TICKET_BUYER_NSRSBH_H = 5;

	private float SETCOORDINATE_TICKET_BUYER_DZDH_X = 38.89f;
	private float SETCOORDINATE_TICKET_BUYER_DZDH_Y = 41.21f;
	private float SETCOORDINATE_TICKET_BUYER_DZDH_W = 77.01f;
	private float SETCOORDINATE_TICKET_BUYER_DZDH_H = 3.81f;

	private float SETCOORDINATE_TICKET_BUYER_KHHJZH_X = 38.89f;
	private float SETCOORDINATE_TICKET_BUYER_KHHJZH_Y = 46.54f;
	private float SETCOORDINATE_TICKET_BUYER_KHHJZH_W = 77.0f;
	private float SETCOORDINATE_TICKET_BUYER_KHHJZH_H = 3.81f;

	private float SETCOORDINATE_TICKET_BUYER_MMQ_X = 128.89f;
	private float SETCOORDINATE_TICKET_BUYER_MMQ_Y = 30.54f;
	private float SETCOORDINATE_TICKET_BUYER_MMQ_W = 79.0f;
	private float SETCOORDINATE_TICKET_BUYER_MMQ_H = 20;

	private float SETCOORDINATE_TICKET_HWFW_MC_X = 8.00f;
	private float SETCOORDINATE_TICKET_HWFW_MC_Y = 55.39f;
	private float SETCOORDINATE_TICKET_HWFW_MC_W = 52.0f;
	private float SETCOORDINATE_TICKET_HWFW_MC_H = 3.81f;

	private float SETCOORDINATE_TICKET_HWFW_GGX_X = 62.00f;
	private float SETCOORDINATE_TICKET_HWFW_GGX_Y = 55.39f;
	private float SETCOORDINATE_TICKET_HWFW_GGX_W = 26.0f;
	private float SETCOORDINATE_TICKET_HWFW_GGX_H = 3.81f;

	private float SETCOORDINATE_TICKET_HWFW_DW_X = 77.70f;
	private float SETCOORDINATE_TICKET_HWFW_DW_Y = 55.39f;
	private float SETCOORDINATE_TICKET_HWFW_DW_W = 10.0f;
	private float SETCOORDINATE_TICKET_HWFW_DW_H = 3.81f;

	private float SETCOORDINATE_TICKET_HWFW_SL_X = 92.20f;
	private float SETCOORDINATE_TICKET_HWFW_SL_Y = 55.39f;
	private float SETCOORDINATE_TICKET_HWFW_SL_W = 20.0f;
	private float SETCOORDINATE_TICKET_HWFW_SL_H = 3.81f;

	private float SETCOORDINATE_TICKET_HWFW_DJ_X = 117.50f;
	private float SETCOORDINATE_TICKET_HWFW_DJ_Y = 55.39f;
	private float SETCOORDINATE_TICKET_HWFW_DJ_W = 20.0f;
	private float SETCOORDINATE_TICKET_HWFW_DJ_H = 3.81f;

	private float SETCOORDINATE_TICKET_HWFW_JE_X = 138.54f;
	private float SETCOORDINATE_TICKET_HWFW_JE_Y = 55.39f;
	private float SETCOORDINATE_TICKET_HWFW_JE_W = 30.0f;
	private float SETCOORDINATE_TICKET_HWFW_JE_H = 3.81f;

	private float SETCOORDINATE_TICKET_HWFW_SLV_X = 167.70f;
	private float SETCOORDINATE_TICKET_HWFW_SLV_Y = 55.39f;
	private float SETCOORDINATE_TICKET_HWFW_SLV_W = 9.0f;
	private float SETCOORDINATE_TICKET_HWFW_SLV_H = 3.81f;

	private float SETCOORDINATE_TICKET_HWFW_SE_X = 177.70f;
	private float SETCOORDINATE_TICKET_HWFW_SE_Y = 55.39f;
	private float SETCOORDINATE_TICKET_HWFW_SE_W = 30.0f;
	private float SETCOORDINATE_TICKET_HWFW_SE_H = 3.81f;

	private float SETCOORDINATE_TICKET_HWFW_HJJE_X = 137.70f;
	private float SETCOORDINATE_TICKET_HWFW_HJJE_Y = 89.30f;
	private float SETCOORDINATE_TICKET_HWFW_HJJE_W = 30.0f;
	private float SETCOORDINATE_TICKET_HWFW_HJJE_H = 5f;

	private float SETCOORDINATE_TICKET_HWFW_HJSE_X = 177.70f;
	private float SETCOORDINATE_TICKET_HWFW_HJSE_Y = 89.30f;
	private float SETCOORDINATE_TICKET_HWFW_HJSE_W = 30.0f;
	private float SETCOORDINATE_TICKET_HWFW_HJSE_H = 5f;

	private float SETCOORDINATE_TICKET_JSHJ_DX_X = 66.86f;
	private float SETCOORDINATE_TICKET_JSHJ_DX_Y = 97.34f;
	private float SETCOORDINATE_TICKET_JSHJ_DX_W = 70.66f;
	private float SETCOORDINATE_TICKET_JSHJ_DX_H = 3.81f;

	private float SETCOORDINATE_TICKET_JSHJ_XX_X = 160.70f;
	private float SETCOORDINATE_TICKET_JSHJ_XX_Y = 97.34f;
	private float SETCOORDINATE_TICKET_JSHJ_XX_W = 45.0f;
	private float SETCOORDINATE_TICKET_JSHJ_XX_H = 5f;

	private float SETCOORDINATE_TICKET_SALE_MC_X = 38.89f;
	private float SETCOORDINATE_TICKET_SALE_MC_Y = 103.54f;
	private float SETCOORDINATE_TICKET_SALE_MC_W = 77.0f;
	private float SETCOORDINATE_TICKET_SALE_MC_H = 3.81f;

	private float SETCOORDINATE_TICKET_SALE_NSRSBH_X = 38.89f;
	private float SETCOORDINATE_TICKET_SALE_NSRSBH_Y = 107.90f;
	private float SETCOORDINATE_TICKET_SALE_NSRSBH_W = 78.0f;
	private float SETCOORDINATE_TICKET_SALE_NSRSBH_H = 6;

	private float SETCOORDINATE_TICKET_SALE_DZDH_X = 38.89f;
	private float SETCOORDINATE_TICKET_SALE_DZDH_Y = 114.20f;
	private float SETCOORDINATE_TICKET_SALE_DZDH_W = 77.0f;
	private float SETCOORDINATE_TICKET_SALE_DZDH_H = 3.81f;

	private float SETCOORDINATE_TICKET_SALE_KHHJZH_X = 38.89f;
	private float SETCOORDINATE_TICKET_SALE_KHHJZH_Y = 119.04f;
	private float SETCOORDINATE_TICKET_SALE_KHHJZH_W = 77.0f;
	private float SETCOORDINATE_TICKET_SALE_KHHJZH_H = 3.81f;

	private float SETCOORDINATE_TICKET_SALE_BZ_X = 128.89f;
	private float SETCOORDINATE_TICKET_SALE_BZ_Y = 103.54f;
	private float SETCOORDINATE_TICKET_SALE_BZ_W = 79.0f;
	private float SETCOORDINATE_TICKET_SALE_BZ_H = 10.81f;

	private float SETCOORDINATE_TICKET_SKR_X = 22.89f;
	private float SETCOORDINATE_TICKET_SKR_Y = 125.74f;
	private float SETCOORDINATE_TICKET_SKR_W = 41.0f;
	private float SETCOORDINATE_TICKET_SKR_H = 3.81f;

	private float SETCOORDINATE_TICKET_FHR_X = 75.89f;
	private float SETCOORDINATE_TICKET_FHR_Y = 125.74f;
	private float SETCOORDINATE_TICKET_FHR_W = 31.0f;
	private float SETCOORDINATE_TICKET_FHR_H = 3.81f;

	private float SETCOORDINATE_TICKET_KPR_X = 122.39f;
	private float SETCOORDINATE_TICKET_KPR_Y = 125.74f;
	private float SETCOORDINATE_TICKET_KPR_W = 30.0f;
	private float SETCOORDINATE_TICKET_KPR_H = 3.81f;

	/** @brief PathObject坐标 */
	private  float  SETCOORDINATE_PATH_PW_X = 50;
	private  float  SETCOORDINATE_PATH_PW_Y = 50;
	private  float  SETCOORDINATE_PATH_PW_W = 100;
	private  float  SETCOORDINATE_PATH_PW_H = 2;

	private  float  SETCOORDINATE_PATH_PW_START_X = 0;
	private  float  SETCOORDINATE_PATH_PW_START_Y = 1;
	private  float  SETCOORDINATE_PATH_PW_END_X = 100;
	private  float  SETCOORDINATE_PATH_PW_END_Y = 1;
	private  float  SETCOORDINATE_PATH_PW_WIDTH = 0.2f;

	private  float  SETCOORDINATE_PATH_PH_X = 50;
	private  float  SETCOORDINATE_PATH_PH_Y = 50;
	private  float  SETCOORDINATE_PATH_PH_W = 2;
	private  float  SETCOORDINATE_PATH_PH_H = 100;

	private  float  SETCOORDINATE_PATH_PH_START_X = 0;
	private  float  SETCOORDINATE_PATH_PH_START_Y = 1;
	private  float  SETCOORDINATE_PATH_PH_END_X = 0;
	private  float  SETCOORDINATE_PATH_PH_END_Y = 100;
	private  float  SETCOORDINATE_PATH_PH_WIDTH = 0.2f;
	
	/** @brief imageObject坐标 */
	private  float  SETCOORDINATE_IMAGE_X = 70;
	private  float  SETCOORDINATE_IMAGE_Y = 80;
	private  float  SETCOORDINATE_IMAGE_W = 100;
	private  float  SETCOORDINATE_IMAGE_H = 100;

	
	public static byte[] getContent(String filePath) throws IOException
		{
				System.out.println("getContent beg ...");

		File file = new File(filePath);  
		long fileSize = file.length();  
		if (fileSize > Integer.MAX_VALUE) { 
			System.out.println("file too big...");  
			return null;  
		}  
		FileInputStream fi = new FileInputStream(file);  
		byte[] buffer = new byte[(int) fileSize];  
		int offset = 0;  
		int numRead = 0;  
		while (offset < buffer.length  
		&& (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {  
			offset += numRead;  
		}  
		// 
		if (offset != buffer.length) {  
		throw new IOException("Could not completely read file "  
					+ file.getName());  
		}  
		fi.close();  

		return buffer;  
	} 

	/**
	* @brief 演示如何创建发票模板，添加表格线(path)、图片(image)等
	*/
	public void FP_CreateTemplate()
	{
		/**  初始化EISDK，加载核心引擎库后只需要初始化一次*/
		

		long hPackage = OfdPackage.create0();
		long hDocument = OfdPackage.addDocument(hPackage);
		long hPage = OfdDocument.addPage(hDocument);

		OfdPage.addLayer(hPage);

		/**  示例接口*/
		Add_Text(hPage);	//添加文字
		//Add_RTFText(hPage);	//添加富文本文字
//		Add_Path(hPage);	//添加表格线
//		Add_Image(hPage);	//添加图像
		
		/**  保存数据*/
		OfdPackage.setEmbedFont(hPackage,0);
		OfdPackage.setFloatBit(hPackage,4);
		int flg = 1;
		if(flg == 0)
		{
			OfdPackage.saveAs(hPackage,_fp_create);
		}else{
			byte[] dest_buf = OfdPackage.saveToByteArray2(hPackage,0);
			String fname = "../testcase/fp_create2.ofd";
			File file1 =new File(fname);
			BufferedOutputStream bufferedOutputStream;
			try {
				bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file1));
				bufferedOutputStream.write(dest_buf);
				bufferedOutputStream.close();
				System.out.println("新建文件："+fname);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		OfdPackage.close(hPackage);

		/**  反初始化EISDK*/
	}

	/**
	* @brief 演示如何使用发票模板，添加发票数据并设置发票数据的标引
	*/
	public void FP_AddTemplateData()
	{	
		/**    初始化EISDK，加载核心引擎库后只需要初始化一次*/
		
		
		byte[] file_buf = null;
		try {
			file_buf = getContent(_fp_template);
		} catch (IOException ex) {
			Logger.getLogger(OfdTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		long hPackage = OfdPackage.openByBuffer(file_buf,1);//从内存中加载一个包
		
		//long hPackage = OfdPackage.open(_fp_template,0);
		//long hDocument = OfdPackage.loadDocument(hPackage,0);
		long hDocument = OfdPackage.clearDocument(hPackage,0);
		long hPage = OfdDocument.loadPage(hDocument,0);

		//OfdQrCode.ConvertStr2Img("http://www.163.com","../testcase/testimg.jb2");

		OfdPage.addLayer(hPage);

		/**  示例接口*/
		OfdDocument.setMetadata(hDocument,OfdDocument.OFD_DOCUMENT_METADATA_AUTHOR,"HTFoxit2017");	//添加元数据
		OfdTagTree.initTTNode(hDocument,"fp","fp","电子发票","fp",0);			//初始化发票标引
		
		Set_Value_TICKET_FP_DM(hPage,hDocument);			//设置发票代码
		Set_Value_TICKET_FP_HM(hPage,hDocument);			//设置发票号码
		Set_Value_TICKET_FP_RQ(hPage,hDocument);			//设置发票日期
		Set_Value_TICKET_FP_JYM(hPage,hDocument);			//设置校验码
		Set_Value_TICKET_FP_JQBH(hPage,hDocument);			//设置机器编号
		Set_Value_TICKET_BUYER_MC(hPage,hDocument);			//设置购买方-名称
		Set_Value_TICKET_BUYER_NSRSBH(hPage,hDocument);		//设置购买方-纳税人识别号
		Set_Value_TICKET_BUYER_DZDH(hPage,hDocument);		//设置购买方-地址电话
		Set_Value_TICKET_BUYER_KHHJZH(hPage,hDocument);		//设置购买方-开户行及帐号
		
		Set_Value_TICKET_BUYER_MMQ(hPage,hDocument);		//设置购买方-密码区
		
		Set_Value_TICKET_HWFW_MC(hPage,hDocument);			//设置货物服务名称
		Set_Value_TICKET_HWFW_GGX(hPage,hDocument);			//设置规格型
		Set_Value_TICKET_HWFW_DW(hPage,hDocument);			//设置单位
		Set_Value_TICKET_HWFW_SL(hPage,hDocument);			//设置数量
		Set_Value_TICKET_HWFW_DJ(hPage,hDocument);			//设置单价
		Set_Value_TICKET_HWFW_JE(hPage,hDocument);			//设置金额
		Set_Value_TICKET_HWFW_SLV(hPage,hDocument);			//设置税率
		Set_Value_TICKET_HWFW_SE(hPage,hDocument);			//设置税额
		Set_Value_TICKET_HWFW_HJJE(hPage,hDocument);		//设置合计金额
		Set_Value_TICKET_HWFW_HJSE(hPage,hDocument);		//设置合计税额
		Set_Value_TICKET_JSHJ_DX(hPage,hDocument);			//设置价税合计-大写
		Set_Value_TICKET_JSHJ_XX(hPage,hDocument);			//设置价税合计-小写
		Set_Value_TICKET_SALE_MC(hPage,hDocument);			//设置销售方-名称
		Set_Value_TICKET_SALE_NSRSBH(hPage,hDocument);		//设置销售方-纳税人识别号
		Set_Value_TICKET_SALE_DZDH(hPage,hDocument);		//设置销售方-地址电话
		Set_Value_TICKET_SALE_KHHJZH(hPage,hDocument);		//设置销售方-开户行及帐号
		Set_Value_TICKET_SALE_BZ(hPage,hDocument);			//设置销售方-备注
		Set_Value_TICKET_SKR(hPage,hDocument);				//设置收款人
		Set_Value_TICKET_FHR(hPage,hDocument);				//设置复核人
		Set_Value_TICKET_KPR(hPage,hDocument);				//设置开票人
		Set_Value_Path(hPage,hDocument);
		Add_Image(hPage);
		
		//OfdDocument.convert2EmbededFont(hDocument, "宋体");
		//OfdDocument.convert2EmbededFont(hDocument, "楷体");
		/**  保存数据*/
		OfdPackage.setEmbedFont(hPackage,0);
		OfdPackage.setFloatBit(hPackage,4);
		//OfdPackage.saveAs(hPackage,_fp_template_setdata);

		byte[] dest_buf = OfdPackage.saveToByteArray2(hPackage,0);
		String fname = "../testcase/adddata.ofd";
		File file1 =new File(fname);
		BufferedOutputStream bufferedOutputStream;
		try {
				bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file1));
			    bufferedOutputStream.write(dest_buf);
			    bufferedOutputStream.close();
			    System.out.println("新建文件："+fname);
		} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}

		OfdPackage.close(hPackage);

		/**  反初始化EISDK*/
	}
	
	int _level = 0;
	private void recursiveCustomTag(long customTag, long doc) {
		_level++;
		String prefix = "    ";
		for (int i=1; i<_level; ++i) {
			prefix += "    ";
		}
		
		String name = OfdTagNode.getTagKey(customTag);
		int count = OfdTagNode.countChild(customTag);
		if (count > 0) {
			System.out.println(String.format("%s tag,name=%s, len = %d, childcount=%d", prefix, name, name.length(), count));
			for (int i=0; i<count; ++i) {
				long child = OfdTagNode.getChild(customTag, i);
				recursiveCustomTag(child, doc);
			}
		} else {
			String text = OfdTagNode.getText(customTag);
			if (text != null)
				System.out.println(String.format("%s tag, name=%s len = %d, text=%s", prefix, name, name.length(), text));
		}
		_level--;
	}
	/**
	* @brief 演示如何打开发票文件，使用索引获取关联的数据
	*/
	public void FP_GetData()
	{
		long hPackage = OfdPackage.open(_getData,0);
		long hDocument = OfdPackage.loadDocument(hPackage,0);

		long hPage = OfdDocument.loadPage(hDocument,0);
		OfdDocument.addPage(hDocument);
		long root = OfdTagTree.getRoot(hDocument, "fp");
		recursiveCustomTag(root,hDocument);
	}

	// 添加文字对象
	public void Add_Text(long hPage) 
	{
		//添加一个文本对象
		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		//设置文本对对象的外框
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_FP_DM_X
								,SETCOORDINATE_TICKET_FP_DM_Y
								,SETCOORDINATE_TICKET_FP_DM_W
								,SETCOORDINATE_TICKET_FP_DM_H
								);
		//向文本对象内添加文字内容 fp_dm
		OfdPageObj.setText2(textObject,"测试开始000003521012𪚥");
		//设置文本对象内文字的字体为宋体
		OfdPageObj.setFontName2(textObject,"宋体");
		//设置文本对象内备选字体为SimSun-ExtB
		//OfdPageObj.setSubFontName(textObject,"SimSun-ExtB");
		//设置文本对象内文字的大小为9pt
		OfdPageObj.setFontSize2(textObject,9 * PT);
		//设置自动折行
		//OfdPageObj.setMultiline(textObject,1);
		//设置每行字符个数为20个
		//OfdPageObj.setLineCharNum(textObject,20);
		//设置每行字节个数为20个
		//OfdPageObj.setLineBitNum(textObject,20);
		//自适应字体大小
		//OfdPageObj.setAutoSize(textObject,1);
		//设置字体缩小步长
		//OfdPageObj.setDeflateUnit(textObject,0.1f);
		//设置文本旋转
		//OfdPageObj.setRotate(textObject,OfdPageObj.OFD_TEXT_CLOCKWISE_ROTATE_90);
		//OfdPageObj.setRotate(textObject,OfdPageObj.OFD_TEXT_CLOCKWISE_ROTATE_270);
		//设置对齐方式
		//OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_CENTER);
		//OfdPageObj.setVAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_CENTER);
		//设置两端对齐方式
		//OfdPageObj.setJustifiedX(textObject);
		//OfdPageObj.setJustifiedY(textObject);
		//设置行间距
		//OfdPageObj.setLineSpace(textObject, 2.0);
		//设置竖排排版
		//OfdPageObj.setVerticalType(textObject);
		//设置竖排排版方式，0：从左至右，1：从右至左
		//OfdPageObj.setVerticalOrder(textObject,OfdPageObj.OFD_TEXT_VERTICAL_LFETTORIGHT);
		//OfdPageObj.setVerticalOrder(textObject,OfdPageObj.OFD_TEXT_VERTICAL_RIGHTTOLEFT);
		//更新文字对象布局
		OfdPageObj.updateLayout(textObject);

	}
	// 添加富文本文字对象
	public void Add_RTFText(long hPage) 
	{
		float[] xy;
		//第一个文字对象
		{
			//添加一个文本对象
			long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
			//设置文本对对象的外框
			OfdPageObj.setBoundary(textObject
									,SETCOORDINATE_TICKET_FP_DM_X - 100.0f
									,SETCOORDINATE_TICKET_FP_DM_Y
									,SETCOORDINATE_TICKET_FP_DM_W
									,SETCOORDINATE_TICKET_FP_DM_H * 20.0f
									);
			//向文本对象内添加文字内容 fp_dm
			OfdPageObj.setText2(textObject,"第一个文字对象是宋体9号字体大小");
			//设置起始偏移量
			OfdPageObj.setTextStartOffset(textObject, 0, 0);
			//竖排版从右至左排版时起始偏移量设置
			//OfdPageObj.setTextStartOffset(textObject, SETCOORDINATE_TICKET_FP_DM_W - 18 * PT, 0);
			//设置文本对象内文字的字体为宋体
			OfdPageObj.setFontName2(textObject,"宋体");
			//设置文本对象内文字的大小为9pt
			OfdPageObj.setFontSize2(textObject,9 * PT);
			//设置富文本最大文字大小为18pt
			OfdPageObj.setRTFFontSize(textObject,18 * PT);
			//设置自动折行
			OfdPageObj.setMultiline(textObject,1);
			//设置行间距
			//OfdPageObj.setLineSpace(textObject, 2.0f);
			//设置竖排排版
			//OfdPageObj.setVerticalType(textObject);
			//设置竖排排版方式，0：从左至右，1：从右至左
			//OfdPageObj.setVerticalOrder(textObject,OfdPageObj.OFD_TEXT_VERTICAL_LFETTORIGHT);
			//OfdPageObj.setVerticalOrder(textObject,OfdPageObj.OFD_TEXT_VERTICAL_RIGHTTOLEFT);
			//更新文字对象布局
			OfdPageObj.updateLayout(textObject);
			
			//获取文字对象的结束位置，用于设置下一个文字对象的起始位置
			xy = OfdPageObj. getTextEndOffset(textObject);
			System.out.println(String.format("x=%f,y=%f", xy[0], xy[1]));

		}
		//第二个文字对象
		{
			//添加一个文本对象
			long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
			//设置文本对对象的外框
			OfdPageObj.setBoundary(textObject
									,SETCOORDINATE_TICKET_FP_DM_X - 100.0f
									,SETCOORDINATE_TICKET_FP_DM_Y
									,SETCOORDINATE_TICKET_FP_DM_W
									,SETCOORDINATE_TICKET_FP_DM_H * 20.0f
									);
			//向文本对象内添加文字内容 fp_dm
			OfdPageObj.setText2(textObject,"第二个文字对象是黑体12号字体大小");
			//设置起始偏移量
			OfdPageObj.setTextStartOffset(textObject, xy[0], xy[1]);
			//设置文本对象内文字的字体为宋体
			OfdPageObj.setFontName2(textObject,"黑体");
			//设置文本对象内文字的大小为9pt
			OfdPageObj.setFontSize2(textObject,12 * PT);
			//设置富文本最大文字大小为18pt
			OfdPageObj.setRTFFontSize(textObject,18 * PT);
			//设置自动折行
			OfdPageObj.setMultiline(textObject,1);
			//设置行间距
			//OfdPageObj.setLineSpace(textObject, 2.0f);
			//设置竖排排版
			//OfdPageObj.setVerticalType(textObject);
			//设置竖排排版方式，0：从左至右，1：从右至左
			//OfdPageObj.setVerticalOrder(textObject,OfdPageObj.OFD_TEXT_VERTICAL_LFETTORIGHT);
			//OfdPageObj.setVerticalOrder(textObject,OfdPageObj.OFD_TEXT_VERTICAL_RIGHTTOLEFT);
			//更新文字对象布局
			OfdPageObj.updateLayout(textObject);
			
			//获取文字对象的结束位置，用于设置下一个文字对象的起始位置
			xy = OfdPageObj. getTextEndOffset(textObject);
			System.out.println(String.format("x=%f,y=%f", xy[0], xy[1]));
		}
		//第三个文字对象
		{
			//添加一个文本对象
			long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
			//设置文本对对象的外框
			OfdPageObj.setBoundary(textObject
									,SETCOORDINATE_TICKET_FP_DM_X - 100.0f
									,SETCOORDINATE_TICKET_FP_DM_Y
									,SETCOORDINATE_TICKET_FP_DM_W
									,SETCOORDINATE_TICKET_FP_DM_H * 20.0f
									);
			//向文本对象内添加文字内容 fp_dm
			OfdPageObj.setText2(textObject,"第三个文字对象是宋体18号字体大小");
			//设置起始偏移量
			OfdPageObj.setTextStartOffset(textObject, xy[0], xy[1]);
			//设置文本对象内文字的字体为宋体
			OfdPageObj.setFontName2(textObject,"宋体");
			//设置文本对象内文字的大小为9pt
			OfdPageObj.setFontSize2(textObject,18 * PT);
			//设置富文本最大文字大小为18pt
			OfdPageObj.setRTFFontSize(textObject,18 * PT);
			//设置自动折行
			OfdPageObj.setMultiline(textObject,1);
			//设置行间距
			//OfdPageObj.setLineSpace(textObject, 2.0f);
			//设置竖排排版
			//OfdPageObj.setVerticalType(textObject);
			//设置竖排排版方式，0：从左至右，1：从右至左
			//OfdPageObj.setVerticalOrder(textObject,OfdPageObj.OFD_TEXT_VERTICAL_LFETTORIGHT);
			//OfdPageObj.setVerticalOrder(textObject,OfdPageObj.OFD_TEXT_VERTICAL_RIGHTTOLEFT);
			//更新文字对象布局
			OfdPageObj.updateLayout(textObject);
			
			//获取文字对象的结束位置，用于设置下一个文字对象的起始位置
			xy = OfdPageObj. getTextEndOffset(textObject);
			System.out.println(String.format("x=%f,y=%f", xy[0], xy[1]));
		}
		//第四个文字对象
		{
			//添加一个文本对象
			long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
			//设置文本对对象的外框
			OfdPageObj.setBoundary(textObject
									,SETCOORDINATE_TICKET_FP_DM_X - 100.0f
									,SETCOORDINATE_TICKET_FP_DM_Y
									,SETCOORDINATE_TICKET_FP_DM_W
									,SETCOORDINATE_TICKET_FP_DM_H * 20.0f
									);
			//向文本对象内添加文字内容 fp_dm
			OfdPageObj.setText2(textObject,"第四个文字对象是宋体5号字体大小");
			//设置起始偏移量
			OfdPageObj.setTextStartOffset(textObject, xy[0], xy[1]);
			//设置文本对象内文字的字体为宋体
			OfdPageObj.setFontName2(textObject,"宋体");
			//设置文本对象内文字的大小为9pt
			OfdPageObj.setFontSize2(textObject,5 * PT);
			//设置富文本最大文字大小为18pt
			OfdPageObj.setRTFFontSize(textObject,18 * PT);
			//设置自动折行
			OfdPageObj.setMultiline(textObject,1);
			//设置行间距
			//OfdPageObj.setLineSpace(textObject, 2.0f);
			//设置竖排排版
			//OfdPageObj.setVerticalType(textObject);
			//设置竖排排版方式，0：从左至右，1：从右至左
			//OfdPageObj.setVerticalOrder(textObject,OfdPageObj.OFD_TEXT_VERTICAL_LFETTORIGHT);
			//OfdPageObj.setVerticalOrder(textObject,OfdPageObj.OFD_TEXT_VERTICAL_RIGHTTOLEFT);
			//更新文字对象布局
			OfdPageObj.updateLayout(textObject);
			
			//获取文字对象的结束位置，用于设置下一个文字对象的起始位置
			xy = OfdPageObj. getTextEndOffset(textObject);
			System.out.println(String.format("x=%f,y=%f", xy[0], xy[1]));
		}

	}
	// 添加表格线
	public void Add_Path(long hPage) 
	{
	//横线

		//添加线段对象
		long pathObject1 = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_PATH);
		//设置线段外框
		OfdPageObj.setBoundary(pathObject1
								,SETCOORDINATE_PATH_PW_X
								,SETCOORDINATE_PATH_PW_Y
								,SETCOORDINATE_PATH_PW_W
								,SETCOORDINATE_PATH_PW_H
								);
		//设置线段框内的起始位置，结束位置，设置其他属性属性（线宽，线段颜色）
		OfdPageObj.setLine(pathObject1,SETCOORDINATE_PATH_PW_START_X
									,SETCOORDINATE_PATH_PW_START_Y
									,SETCOORDINATE_PATH_PW_END_X
									,SETCOORDINATE_PATH_PW_END_Y
									,SETCOORDINATE_PATH_PW_WIDTH
									,255
							);

	//竖线

		//添加线段对象
		long pathObject2 = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_PATH);
		//设置线段外框
		OfdPageObj.setBoundary(pathObject2
								,SETCOORDINATE_PATH_PH_X
								,SETCOORDINATE_PATH_PH_Y
								,SETCOORDINATE_PATH_PH_W
								,SETCOORDINATE_PATH_PH_H
								);
		//设置线段框内的起始位置，结束位置，设置其他属性属性（线宽，线段颜色）
		OfdPageObj.setLine(pathObject2,SETCOORDINATE_PATH_PH_START_X
									,SETCOORDINATE_PATH_PH_START_Y
									,SETCOORDINATE_PATH_PH_END_X
									,SETCOORDINATE_PATH_PH_END_Y
									,SETCOORDINATE_PATH_PH_WIDTH
									,255
							);
	}

	//图片
	public void Add_Image(long hPage) 
	{
		//添加一个图片对象框
		long imageObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_IMAGE);

		//设置图片对象框的位置和大小
		OfdPageObj.setBoundary(imageObject
								,15
								,3
								,19
								,19);
		//设置图片对象框内的图片路径
		OfdPageObj.setImageFromFile(imageObject,"../testcase/Image_2638.png");
		//设置图片的大小和变换形状 param2,param5表示图片的宽和高
		OfdPageObj.setCTM(imageObject,19,0,0,19,0,0);

	}

	//发票代码
	public void Set_Value_TICKET_FP_DM(long hPage,long hDocument) 
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/HEAD/FP_DM");
		
		//添加一个文本对象
		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		//设置文本对对象的外框
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_FP_DM_X
								,SETCOORDINATE_TICKET_FP_DM_Y
								,SETCOORDINATE_TICKET_FP_DM_W
								,SETCOORDINATE_TICKET_FP_DM_H
								);
		//向文本对象内添加文字内容 fp_dm
		OfdPageObj.setText2(textObject,"000003521012");
		//设置文本对象内文字的字体为宋体
		OfdPageObj.setFontName2(textObject,"宋体");
		//设置文本对象内文字的大小为9pt
		OfdPageObj.setFontSize2(textObject,9 * PT);
		//设置自动折行
		OfdPageObj.setMultiline(textObject,1);
		//设置每行字符个数为20个
		OfdPageObj.setLineCharNum(textObject,20);
		//设置左对齐
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_LEFT);
		//更新文字对象布局
		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/HEAD/FP_DM");
	}
	//发票号码
	public void Set_Value_TICKET_FP_HM(long hPage,long hDocument) 
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/HEAD/FP_HM");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_FP_HM_X
								,SETCOORDINATE_TICKET_FP_HM_Y
								,SETCOORDINATE_TICKET_FP_HM_W
								,SETCOORDINATE_TICKET_FP_HM_H
								);
		OfdPageObj.setText2(textObject,"75601380");
		OfdPageObj.setFontName2(textObject,"宋体");
		OfdPageObj.setFontSize2(textObject,9 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,20);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_LEFT);
		
		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/HEAD/FP_HM");
	}
	//发票日期
	public void Set_Value_TICKET_FP_RQ(long hPage,long hDocument) 
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/HEAD/KPRQ");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_FP_RQ_X
								,SETCOORDINATE_TICKET_FP_RQ_Y
								,SETCOORDINATE_TICKET_FP_RQ_W
								,SETCOORDINATE_TICKET_FP_RQ_H
								);
		OfdPageObj.setText2(textObject,"2016   01   19  14:05:13");
		OfdPageObj.setFontName2(textObject,"宋体");
		OfdPageObj.setFontSize2(textObject,9 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,24);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_LEFT);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/HEAD/KPRQ");
	}
	//校验码
	public void Set_Value_TICKET_FP_JYM(long hPage,long hDocument) 
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/HEAD/JYM");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_FP_JYM_X
								,SETCOORDINATE_TICKET_FP_JYM_Y
								,SETCOORDINATE_TICKET_FP_JYM_W
								,SETCOORDINATE_TICKET_FP_JYM_H
								);
		OfdPageObj.setText2(textObject,"17679 11555 46122 09887");
		OfdPageObj.setFontName2(textObject,"宋体");
		OfdPageObj.setFontSize2(textObject,9 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,25);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_LEFT);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/HEAD/JYM");
	}
	//机器编号
	public void Set_Value_TICKET_FP_JQBH(long hPage,long hDocument) 
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/HEAD/JQBH");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_FP_JQBH_X
								,SETCOORDINATE_TICKET_FP_JQBH_Y
								,SETCOORDINATE_TICKET_FP_JQBH_W
								,SETCOORDINATE_TICKET_FP_JQBH_H
								);
		OfdPageObj.setText2(textObject,"499099992972");
		OfdPageObj.setFontName2(textObject,"宋体");
		OfdPageObj.setFontSize2(textObject,9 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,20);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_LEFT);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/HEAD/JQBH");
	}
	//购买方-名称
	public void Set_Value_TICKET_BUYER_MC(long hPage,long hDocument) 
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/BUYER/GMF/MC");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_BUYER_MC_X
								,SETCOORDINATE_TICKET_BUYER_MC_Y
								,SETCOORDINATE_TICKET_BUYER_MC_W
								,SETCOORDINATE_TICKET_BUYER_MC_H
								);
		OfdPageObj.setText2(textObject,"上海花王有限公司");
		OfdPageObj.setFontName2(textObject,"宋体");
		OfdPageObj.setFontSize2(textObject,9 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,100);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_LEFT);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/BUYER/GMF/MC");
	}
	//购买方-纳税人识别号
	public void Set_Value_TICKET_BUYER_NSRSBH(long hPage,long hDocument) 
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/BUYER/GMF/NSRSBH");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_BUYER_NSRSBH_X
								,SETCOORDINATE_TICKET_BUYER_NSRSBH_Y
								,SETCOORDINATE_TICKET_BUYER_NSRSBH_W
								,SETCOORDINATE_TICKET_BUYER_NSRSBH_H
								);
		OfdPageObj.setText2(textObject,"499099991232111");
		OfdPageObj.setFontName2(textObject,"Courier New");
		OfdPageObj.setFontSize2(textObject,12 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,20);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_LEFT);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/BUYER/GMF/NSRSBH");
	}
	//购买方-地址电话
	public void Set_Value_TICKET_BUYER_DZDH(long hPage,long hDocument) 
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/BUYER/GMF/DZDH");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_BUYER_DZDH_X
								,SETCOORDINATE_TICKET_BUYER_DZDH_Y
								,SETCOORDINATE_TICKET_BUYER_DZDH_W
								,SETCOORDINATE_TICKET_BUYER_DZDH_H
								);
		OfdPageObj.setText2(textObject,"深圳市宝安区福永街道桥头社区亿宝来工业城1栋6楼、 502 29878589");
		OfdPageObj.setFontName2(textObject,"宋体");
		OfdPageObj.setFontSize2(textObject,9 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,100);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_LEFT);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/BUYER/GMF/DZDH");
	}
	//购买方-开户行及帐号
	public void Set_Value_TICKET_BUYER_KHHJZH(long hPage,long hDocument) 
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/BUYER/GMF/YHZH");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_BUYER_KHHJZH_X
								,SETCOORDINATE_TICKET_BUYER_KHHJZH_Y
								,SETCOORDINATE_TICKET_BUYER_KHHJZH_W
								,SETCOORDINATE_TICKET_BUYER_KHHJZH_H
								);
		OfdPageObj.setText2(textObject,"农业银行深圳分行529921039495885");
		OfdPageObj.setFontName2(textObject,"宋体");
		OfdPageObj.setFontSize2(textObject,9 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,100);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_LEFT);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/BUYER/GMF/YHZH");
	}
	//购买方-密码区
	public void Set_Value_TICKET_BUYER_MMQ(long hPage,long hDocument) 
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/BUYER/GMF/MW");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_BUYER_MMQ_X
								,SETCOORDINATE_TICKET_BUYER_MMQ_Y
								,SETCOORDINATE_TICKET_BUYER_MMQ_W
								,SETCOORDINATE_TICKET_BUYER_MMQ_H
								);
		OfdPageObj.setText2(textObject,"032-2008161881/-56+-++>717*>296110>+03*02-9/>+-72>0/58+99*3+016>--1-9-8481/>>/>+8291>47>9>/591015/07194-86*3>533");
		OfdPageObj.setFontName2(textObject,"Courier New");
		OfdPageObj.setFontSize2(textObject,9 * PT);
		OfdPageObj.setMultiline(textObject,2);
		OfdPageObj.setLineCharNum(textObject,28);
		//OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_CENTER);
		OfdPageObj.setJustifiedX(textObject);
		OfdPageObj.setJustifiedY(textObject);
		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/BUYER/GMF/MW");
	}
	//货物或应税、服务名称
	public void Set_Value_TICKET_HWFW_MC(long hPage,long hDocument)  //HWFW  货物 服务
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/DETAIL/COMMOM_FPKJ_XMXX/XMMC");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_HWFW_MC_X
								,SETCOORDINATE_TICKET_HWFW_MC_Y
								,SETCOORDINATE_TICKET_HWFW_MC_W
								,SETCOORDINATE_TICKET_HWFW_MC_H
								);
		OfdPageObj.setText2(textObject,"约车服务费");
		OfdPageObj.setFontName2(textObject,"宋体");
		OfdPageObj.setFontSize2(textObject,9 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,92);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_LEFT);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/DETAIL/COMMOM_FPKJ_XMXX/XMMC");
	}
	//规格型
	public void Set_Value_TICKET_HWFW_GGX(long hPage,long hDocument)  
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/DETAIL/COMMOM_FPKJ_XMXX/GGXH");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_HWFW_GGX_X
								,SETCOORDINATE_TICKET_HWFW_GGX_Y
								,SETCOORDINATE_TICKET_HWFW_GGX_W
								,SETCOORDINATE_TICKET_HWFW_GGX_H
								);
		OfdPageObj.setText2(textObject,"小车");
		OfdPageObj.setFontName2(textObject,"宋体");
		OfdPageObj.setFontSize2(textObject,9 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,40);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_LEFT);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/COMMOM_FPKJ_XMXX/GGXH");
	}
	//单位
	public void Set_Value_TICKET_HWFW_DW(long hPage,long hDocument)  
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/COMMOM_FPKJ_XMXX/DW");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_HWFW_DW_X
								,SETCOORDINATE_TICKET_HWFW_DW_Y
								,SETCOORDINATE_TICKET_HWFW_DW_W
								,SETCOORDINATE_TICKET_HWFW_DW_H
								);
		OfdPageObj.setText2(textObject,"台次");
		OfdPageObj.setFontName2(textObject,"宋体");
		OfdPageObj.setFontSize2(textObject,9 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,22);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_CENTER);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/COMMOM_FPKJ_XMXX/DW");
	}
	//数量
	public void Set_Value_TICKET_HWFW_SL(long hPage,long hDocument)  
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/COMMOM_FPKJ_XMXX/XMSL");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_HWFW_SL_X
								,SETCOORDINATE_TICKET_HWFW_SL_Y
								,SETCOORDINATE_TICKET_HWFW_SL_W
								,SETCOORDINATE_TICKET_HWFW_SL_H
								);
		OfdPageObj.setText2(textObject,"1.000000");
		OfdPageObj.setFontName2(textObject,"宋体");
		OfdPageObj.setFontSize2(textObject,9 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,20);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_RIGHT);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/COMMOM_FPKJ_XMXX/XMSL");
	}
	//单价
	public void Set_Value_TICKET_HWFW_DJ(long hPage,long hDocument)  
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/COMMOM_FPKJ_XMXX/XMDJ");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_HWFW_DJ_X
								,SETCOORDINATE_TICKET_HWFW_DJ_Y
								,SETCOORDINATE_TICKET_HWFW_DJ_W
								,SETCOORDINATE_TICKET_HWFW_DJ_H
								);
		OfdPageObj.setText2(textObject,"59.91");
		OfdPageObj.setFontName2(textObject,"宋体");  
		OfdPageObj.setFontSize2(textObject,9 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,20);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_RIGHT);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/COMMOM_FPKJ_XMXX/XMDJ");
	}
	//金额
	public void Set_Value_TICKET_HWFW_JE(long hPage,long hDocument)  
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/COMMOM_FPKJ_XMXX/XMJE");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_HWFW_JE_X
								,SETCOORDINATE_TICKET_HWFW_JE_Y
								,SETCOORDINATE_TICKET_HWFW_JE_W
								,SETCOORDINATE_TICKET_HWFW_JE_H
								);
		OfdPageObj.setText2(textObject,"59.91");
		OfdPageObj.setFontName2(textObject,"宋体");
		OfdPageObj.setFontSize2(textObject,9 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,20);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_RIGHT);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/COMMOM_FPKJ_XMXX/XMJE");
	}
	//税率
	public void Set_Value_TICKET_HWFW_SLV(long hPage,long hDocument)   //SLV 税率
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/COMMOM_FPKJ_XMXX/SL");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_HWFW_SLV_X
								,SETCOORDINATE_TICKET_HWFW_SLV_Y
								,SETCOORDINATE_TICKET_HWFW_SLV_W
								,SETCOORDINATE_TICKET_HWFW_SLV_H
								);
		OfdPageObj.setText2(textObject,"0.06");
		OfdPageObj.setFontName2(textObject,"宋体");
		OfdPageObj.setFontSize2(textObject,9 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,20);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_RIGHT);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/COMMOM_FPKJ_XMXX/SL");
	}
	//税额
	public void Set_Value_TICKET_HWFW_SE(long hPage,long hDocument)  
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/COMMOM_FPKJ_XMXX/SE");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_HWFW_SE_X
								,SETCOORDINATE_TICKET_HWFW_SE_Y
								,SETCOORDINATE_TICKET_HWFW_SE_W
								,SETCOORDINATE_TICKET_HWFW_SE_H
								);
		OfdPageObj.setText2(textObject,"3.59");
		OfdPageObj.setFontName2(textObject,"宋体");
		OfdPageObj.setFontSize2(textObject,9 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,20);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_RIGHT);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/COMMOM_FPKJ_XMXX/SE");
	}
	//合计金额
	public void Set_Value_TICKET_HWFW_HJJE(long hPage,long hDocument)  
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/MXHJ/HJJE");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_HWFW_HJJE_X
								,SETCOORDINATE_TICKET_HWFW_HJJE_Y
								,SETCOORDINATE_TICKET_HWFW_HJJE_W
								,SETCOORDINATE_TICKET_HWFW_HJJE_H
								);
		OfdPageObj.setText2(textObject,"¥2419.82");
		OfdPageObj.setFontName2(textObject,"Courier New");
		OfdPageObj.setFontSize2(textObject,11 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,20);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_RIGHT);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/MXHJ/HJJE");
	}
	//合计税额
	public void Set_Value_TICKET_HWFW_HJSE(long hPage,long hDocument)  
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/MXHJ/HJSE");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_HWFW_HJSE_X
								,SETCOORDINATE_TICKET_HWFW_HJSE_Y
								,SETCOORDINATE_TICKET_HWFW_HJSE_W
								,SETCOORDINATE_TICKET_HWFW_HJSE_H
								);
		OfdPageObj.setText2(textObject,"121.58");
		OfdPageObj.setFontName2(textObject,"Courier New");
		OfdPageObj.setFontSize2(textObject,11 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,20);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_RIGHT);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/MXHJ/HJSE");
	}
	//价税合计-大写
	public void Set_Value_TICKET_JSHJ_DX(long hPage,long hDocument)  
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/JSHJ/JSHJ_DX");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_JSHJ_DX_X
								,SETCOORDINATE_TICKET_JSHJ_DX_Y
								,SETCOORDINATE_TICKET_JSHJ_DX_W
								,SETCOORDINATE_TICKET_JSHJ_DX_H
								);
		OfdPageObj.setText2(textObject,"贰仟伍百肆拾零元肆角整");
		OfdPageObj.setFontName2(textObject,"宋体");
		OfdPageObj.setFontSize2(textObject,9 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,20);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_LEFT);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/JSHJ/JSHJ_DX");
	}
	//价税合计-小写
	public void Set_Value_TICKET_JSHJ_XX(long hPage,long hDocument)  
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/JSHJ/JSHJ_XX");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_JSHJ_XX_X
								,SETCOORDINATE_TICKET_JSHJ_XX_Y
								,SETCOORDINATE_TICKET_JSHJ_XX_W
								,SETCOORDINATE_TICKET_JSHJ_XX_H
								);
		OfdPageObj.setText2(textObject,"¥2541.40");
		OfdPageObj.setFontName2(textObject,"Courier New");
		OfdPageObj.setFontSize2(textObject,12 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,20);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_CENTER);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/JSHJ/JSHJ_XX");
	}
	//销售方-名称
	public void Set_Value_TICKET_SALE_MC(long hPage,long hDocument)  
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/SALE/XSF/XSF_MC");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_SALE_MC_X
								,SETCOORDINATE_TICKET_SALE_MC_Y
								,SETCOORDINATE_TICKET_SALE_MC_W
								,SETCOORDINATE_TICKET_SALE_MC_H
								);
		OfdPageObj.setText2(textObject,"京东商城测试");
		OfdPageObj.setFontName2(textObject,"宋体");
		OfdPageObj.setFontSize2(textObject,9 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,100);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_LEFT);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/SALE/XSF/XSF_MC");
	}
	//销售方-纳税人识别号
	public void Set_Value_TICKET_SALE_NSRSBH(long hPage,long hDocument)  
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/SALE/XSF/XSF_NSRSBH");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_SALE_NSRSBH_X
								,SETCOORDINATE_TICKET_SALE_NSRSBH_Y
								,SETCOORDINATE_TICKET_SALE_NSRSBH_W
								,SETCOORDINATE_TICKET_SALE_NSRSBH_H
								);
		OfdPageObj.setText2(textObject,"110108112345678");
		OfdPageObj.setFontName2(textObject,"Courier New");
		OfdPageObj.setFontSize2(textObject,12 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,20);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_LEFT);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/SALE/XSF/XSF_NSRSBH");
	}
	//销售方-地址电话
	public void Set_Value_TICKET_SALE_DZDH(long hPage,long hDocument)  
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/SALE/XSF/XSF_DZDH");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_SALE_DZDH_X
								,SETCOORDINATE_TICKET_SALE_DZDH_Y
								,SETCOORDINATE_TICKET_SALE_DZDH_W
								,SETCOORDINATE_TICKET_SALE_DZDH_H
								);
		OfdPageObj.setText2(textObject,"北京东城区灵境胡同234号，63012345");
		OfdPageObj.setFontName2(textObject,"宋体");
		OfdPageObj.setFontSize2(textObject,9 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,100);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_LEFT);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/SALE/XSF/XSF_DZDH");
	}
	//销售方-开户行及帐号
	public void Set_Value_TICKET_SALE_KHHJZH(long hPage,long hDocument)  
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/SALE/XSF/XSF_YHZH");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_SALE_KHHJZH_X
								,SETCOORDINATE_TICKET_SALE_KHHJZH_Y
								,SETCOORDINATE_TICKET_SALE_KHHJZH_W
								,SETCOORDINATE_TICKET_SALE_KHHJZH_H
								);
		OfdPageObj.setText2(textObject,"工商银行北京分行2013102393847593");
		OfdPageObj.setFontName2(textObject,"宋体");
		OfdPageObj.setFontSize2(textObject,9 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,100);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_LEFT);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/SALE/XSF/XSF_YHZH");
	}
	//销售方-备注
	public void Set_Value_TICKET_SALE_BZ(long hPage,long hDocument)  
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/SALE/BZ");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_SALE_BZ_X
								,SETCOORDINATE_TICKET_SALE_BZ_Y
								,SETCOORDINATE_TICKET_SALE_BZ_W
								,SETCOORDINATE_TICKET_SALE_BZ_H
								);
		OfdPageObj.setText2(textObject,"深圳市宝安区福永街道桥头社区亿宝来工业城1 栋6楼、502 29878589 北京东城区灵境胡同234");
		OfdPageObj.setFontName2(textObject,"宋体");
		OfdPageObj.setFontSize2(textObject,9 * PT);
		OfdPageObj.setMultiline(textObject,2);
		OfdPageObj.setLineCharNum(textObject,26);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_LEFT);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/SALE/BZ");
	}
	//收款人
	public void Set_Value_TICKET_SKR(long hPage,long hDocument)  
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/TAIL/SKR");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_SKR_X
								,SETCOORDINATE_TICKET_SKR_Y
								,SETCOORDINATE_TICKET_SKR_W
								,SETCOORDINATE_TICKET_SKR_H
								);
		OfdPageObj.setText2(textObject,"陈中华");
		OfdPageObj.setFontName2(textObject,"宋体");
		OfdPageObj.setFontSize2(textObject,9 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,5);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_LEFT);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/TAIL/SKR");
	}
	//复核人
	public void Set_Value_TICKET_FHR(long hPage,long hDocument)  
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/TAIL/FHR");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_FHR_X
								,SETCOORDINATE_TICKET_FHR_Y
								,SETCOORDINATE_TICKET_FHR_W
								,SETCOORDINATE_TICKET_FHR_H
								);
		OfdPageObj.setText2(textObject,"陈中华");
		OfdPageObj.setFontName2(textObject,"宋体");
		OfdPageObj.setFontSize2(textObject,9 * PT);
		OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,8);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_LEFT);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/TAIL/FHR");
		
	}
	//开票人
	public void Set_Value_TICKET_KPR(long hPage,long hDocument)  
	{
		OfdTagTree.beginTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/TAIL/KPR");

		long textObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_TEXT);
		OfdPageObj.setBoundary(textObject
								,SETCOORDINATE_TICKET_KPR_X
								,SETCOORDINATE_TICKET_KPR_Y
								,SETCOORDINATE_TICKET_KPR_W
								,SETCOORDINATE_TICKET_KPR_H
								);
		OfdPageObj.setText2(textObject,"陈中华");
		OfdPageObj.setFontName2(textObject,"宋体");
		OfdPageObj.setFontSize2(textObject,9 * PT);
		//OfdPageObj.setMultiline(textObject,1);
		OfdPageObj.setLineCharNum(textObject,8);
		//OfdPageObj.setLineBitNum(textObject,8);
		OfdPageObj.setHAlignment(textObject,OfdPageObj.OFD_TEXT_ALIGNMENT_LEFT);
		//OfdPageObj.setJustifiedX(textObject);

		OfdPageObj.updateLayout(textObject);

		OfdTagTree.endTTNode(hDocument,"TAX_TICKET/COMMON_ZZS/TAIL/KPR");
	}
	
	public void Set_Value_Path(long hPage,long hDocument)  
	{
		long pathObject = OfdPage.addPageObj(hPage,0,OfdPage.OFD_PAGEOBJECT_TYPE_PATH);
		OfdPageObj.setBoundary(pathObject
								,0
								,0
								,200
								,200
								);
		OfdPageObj.setAbbreviteData2(pathObject,"M 10 10 L 50 10 L 50 50 L 10 50 C",0xffff0000,0);
	}

	public void removeTemplate()  
	{
		long hPackage = OfdPackage.open(_removeTemplatePageSrc,0);
		long hDocument = OfdPackage.loadDocument(hPackage,0);

		OfdDocument.removeTemplatePage(hDocument,2);

		OfdPackage.saveAs(hPackage,_removeTemplatePageDst);
	}

	public void Render_Page() {
		long pack = OfdPackage.open(_fp_template,0);
		long doc = OfdPackage.loadDocument(pack, 0);
		long page = OfdDocument.loadPage(doc, 0);
		int r = OfdPage.render(page, 96*4, 3, _pageImage);
		OfdPackage.close(pack);
	}
	
	public void FP_TemplatePage() {
		long pack = OfdPackage.open(_fp_template,0);
		long doc = OfdPackage.loadDocument(pack, 0);
		long page = OfdDocument.loadPage(doc,0);
		
		//将page转换成模板页
		long templatePage = OfdDocument.addTemplatePageFromPage(doc,page);
		OfdPage.setTemplatePageName(templatePage, "pagename");
		//获取模板页的ID号
		int templateID = OfdPage.getID(templatePage);
		//新增一页
		//long newPage = OfdDocument.addPage(doc);
		//设置该页的模板属性
		//OfdPage.setTemplatePage(newPage,templateID);
		
		OfdPackage.saveAs(pack,"../testcase/template_file.ofd");
		OfdPackage.close(pack);
	}
	
	public void FP_AddFormData() {
		long pack = OfdPackage.open(_fp_template,0);
		long doc = OfdPackage.loadDocument(pack, 0);
		
		try {
			String form = "../testcase/form.xml";
			byte[] xmlbyte = form.getBytes("UTF-8");
			//设置表单数据
			OfdDocument.setFormData(doc, 0, xmlbyte);
		} catch (Exception e) {
			e.printStackTrace();
		}

		OfdPackage.saveAs(pack,"../testcase/form_file.ofd");
		OfdPackage.close(pack);
	}
	
	public void FP_GetFormData() {
		long pack = OfdPackage.open("../testcase/form_file.ofd",0);
		long doc = OfdPackage.loadDocument(pack, 0);

		//获取form.xml数据
		byte[] xmlbyte = OfdDocument.getFormData(doc, 0);
		System.out.println(String.format("xmlbyte.length = %d", xmlbyte.length));
		//对表单数据处理

		OfdPackage.saveAs(pack,"../testcase/form_file2.ofd");
		OfdPackage.close(pack);
	}
	
	public void FP_Attachment() {
		//添加附件
		long pack = OfdPackage.open(_fp_template,0);
		long doc = OfdPackage.loadDocument(pack, 0);
		
		byte[] buf = new byte[1024 * 6];
		try{
			//FileInputStream inputStream = new FileInputStream(_fileImage);
			FileInputStream inputStream = new FileInputStream("../testcase/form.xml");
			int readsize = inputStream.read(buf);
			System.out.println(String.format("file:%s readsize=%d", _fileImage, readsize));
		}catch (IOException e) {  
            e.printStackTrace();  
        }  
		
		OfdDocument.addAttachment(doc, "att.png", buf,"name2",1);
		OfdPackage.saveAs(pack,"../testcase/att.ofd");
		OfdPackage.close(pack);
		
		//获取附件
		long pack1 = OfdPackage.open("../testcase/form_file.ofd",0);
		long doc1 = OfdPackage.loadDocument(pack1, 0);



		//int cnt = OfdDocument.getAttachmentCount(doc1);
		//System.out.println(String.format("getAttachmentCount cnt=%d", cnt));
		//OfdDocument.getAttachment(doc1, 0, "");	//不设置名称时按照附件原始名称存储
/*		int flg = 1;
		if(flg == 0)
		{
			OfdDocument.getAttachment(doc1, 0, "../testcase/att.png");
		}else{
			byte[] dest_buf = OfdDocument.getAttachmentByteArray(doc1, 0);
			String fname = "../testcase/attB.png";
			File file1 =new File(fname);
			BufferedOutputStream bufferedOutputStream;
			try {
				bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file1));
				bufferedOutputStream.write(dest_buf);
				bufferedOutputStream.close();
				System.out.println("附件文件："+fname);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
*/
		OfdPackage.close(pack1);
	}
	
	public void FP_CustomData() {
		//添加key-value
		long pack = OfdPackage.open(_fp_template,0);
		long doc = OfdPackage.loadDocument(pack, 0);
		OfdDocument.setCustomData(doc, "name1", "test1");
		OfdDocument.setCustomData(doc, "name2", "test2");
		OfdDocument.setCustomData(doc, "name3", "test3");
		OfdPackage.saveAs(pack,"../testcase/customdata.ofd");
		OfdPackage.close(pack);
		
		//获取key-value
		long pack1 = OfdPackage.open("../testcase/customdata.ofd",0);
		long doc1 = OfdPackage.loadDocument(pack1, 0);
		int cnt = OfdDocument.getCustomDataCount(doc1);
		System.out.println(String.format("getCustomDataCount cnt=%d", cnt));
		String keystr = OfdDocument.getCustomDataName(doc1, 1);
		String valuestr = OfdDocument.getCustomData(doc1, 1);
		System.out.println(String.format("index:%d keystr:%s valuestr:%s", 1, keystr, valuestr));
		OfdPackage.close(pack1);
	}

	public void FP_InfoCover()
	{
		long pack = OfdPackage.open("../testcase/form_file.ofd",0);
		long doc = OfdPackage.loadDocument(pack, 0);
		long page = OfdDocument.loadPage(doc, 0);
		OfdPage.infoCover(page, 10, 10, 100, 100, 0, 2, 3, 3, 2);
		OfdPackage.saveAs(pack,"../testcase/form_file3.ofd");
		OfdPackage.close(pack);
	}

    
    public void FP_Attachment111() {
		//添加附件
		long pack = OfdPackage.open(_fp_template,0);
		long doc = OfdPackage.loadDocument(pack, 0);
		
		byte[] buf = new byte[1024 *5];
		try{
			//FileInputStream inputStream = new FileInputStream(_fileImage);//form.xml
			FileInputStream inputStream = new FileInputStream("../testcase/form.xml");
			int readsize = inputStream.read(buf);
			System.out.println(String.format("file:%s readsize=%d", _fileImage, readsize));
		}catch (IOException e) {  
                    e.printStackTrace();  
                }  
		     
        OfdDocument.addAttachment(doc, "att.png", buf,"name11",1);
		OfdDocument.addAttachment(doc, "att.png", buf,"name22",1);
		OfdPackage.saveAs(pack,"../testcase/att.ofd");
		OfdPackage.close(pack);
		 
		//获取附件
		long pack1 = OfdPackage.open("../testcase/att.ofd",0);
		long doc1 = OfdPackage.loadDocument(pack1, 0);
                
		//int cnt = OfdDocument.getAttachmentCount(doc);//0个 返回值=-1
        //int cnt = OfdDocument.getAttachmentCount(doc1);//1
                
		//System.out.println(String.format("getAttachmentCount cnt=%d", cnt));
		//OfdDocument.getAttachment(doc1, 0, "");	//导出失败不能导出附件(默认导出名称与ofd中名称一样的附件文件)
		//OfdDocument.getAttachment(doc1, 0, "./testcase/after/get_att.png");//附件索引号存在
        //OfdDocument.getAttachment(doc1, 2, "./testcase/after/get_att.png");//附件索引号不存在,不能导出指定附件文件
		OfdPackage.close(pack1);
	} 

    public void FP_extractXMLFile() {
		//添加附件
		long pack = OfdPackage.open("../testcase/att.ofd",0);
		long doc = OfdPackage.loadDocument(pack, 0);
		
		int xml_count = OfdDocument.countXMLFile(doc);
		System.out.println("xml count======"+xml_count);		
		
		OfdDocument.extractXMLFile(doc, "../testcase/aa.xml", 0);


		OfdPackage.close(pack);
	}
/*
	public void testQrcode()
	{
		OfdQrCode.ConvertStr2Img("http://www.163.com","../testcase/test2.jb2");
	}

	public void testQrcode2Data()
	{
		byte[] s = OfdQrCode.ConvertStr2ImgData("http://www.163.com");
		try{
			FileOutputStream fos = new FileOutputStream("../testcase/testqr.png");
			fos.write(s, 0, s.length);
			fos.close();
		}
		catch(IOException ex){
			return;
		}
	}

*/

	public void clearDocument(){


        long pack = OfdPackage.open("../testcase/clear.ofd",1);
		for(int i = 0; i < 10000; i++)
		{
			//System.out.println(String.format("i = %d", i));
            //long doc = OfdPackage.loadDocument2(pack, 0, "");
		
			long hOfdPackage = OfdPackage.clearDocument(pack, 0);
			//System.out.println(String.format("OfdPackage.clearDocument ret = %d ...", hOfdPackage));
		}

                OfdPackage.close(pack);

        }

	/**
	* @brief 示例程序入口
	*/
	public static void main(String[] args) {
		System.out.println("test.main begin");

		int ret = OfdBase.init(_serial, _validCode);
		if (ret != 0)
		{
			System.out.println(String.format("lic err: ret=%d", ret));
			return;
		}

		ret = OfdBase.setLibraryPath("../lib/");

		System.out.println(String.format("setLibraryPath ret = %d", ret));

		OfdTest test = new OfdTest();

		// 演示如何创建发票模板，添加表格线(path)、图片(image)等
		// test.FP_CreateTemplate();
		
		// 演示如何使用发票模板，添加发票数据并设置发票数据的标引
		//test.FP_AddTemplateData();

		// 演示如何打开发票文件，使用索引获取关联的数据
		//test.FP_GetData();

		//test.removeTemplate();

		// 演示如何将OFD页面渲染成图片文件
		//test.Render_Page();
		
		//演示普通页转模板页
		//test.FP_TemplatePage();
		
		//演示表单数据
		//test.FP_AddFormData();
		//test.FP_GetFormData();
		
		// 演示如何添加附件，获取附件
		//test.FP_Attachment();
		
		// 演示如何添加元数据key-value,获取key-value
		//test.FP_CustomData();
		//test.FP_Attachment111();
		//test.FP_extractXMLFile();

		
		//二维码图片生成
		//test.testQrcode();
		//test.testQrcode2Data();

		//cleardocument
		//签章 验章
		test.SealSign();
		//文件字节签章 验章
		//test.SealSign2();
		//SealStraddleSign 盖章后 原文件和生成的文件无盖章效果
//		test.SealStraddleSign();
		//
		/*
		 * CertSign() CertSign1()报错
		 * java: symbol lookup error:
		 * /opt/wyccs/Foxit_GSDK_Std_2.4.1_0604_r11970_FT_64_java/lib/
		 * libfofdgsdkwrapper64.so: undefined symbol: OPENSSL_add_all_algorithms_noconf
		 */
		//test.CertSign();
		// test.clearDocument();

		OfdBase.destroy();
		System.out.println("test.main end");
	}
	 
	/**
	* @brief 根据系统位数加载对应的核心引擎库
	*/
	static {
		String arch = System.getProperty("os.arch");
		System.out.println(arch);
		if (arch.contains("64")) {
			System.loadLibrary("fofdgsdkwrapper64");
		} else {
			System.loadLibrary("fofdgsdkwrapper32");
		}
	}
	
	//1.需要盖章的文件地址
	private String OFD_FILE = "../testcase/qilinChangeOut.ofd";
	//1.盖章完成后的文件地址
	private String OFD_SIGNATUREFILE = "../testcase/qilinChangeOut_sign4.ofd";
	public void SealSign()
	{
		System.out.println("SealSign beg ...");
		int ret = 0;

		String arch = System.getProperty("os.arch");
		//加载签章库
		if (arch.contains("64")) {
			System.out.println("SEALPATH_x64 ...");
			//ret = OfdSeal.init(SEALPATH_x64, "111111");	//fangzheng
			ret = OfdSeal.init(SEALPATH_x64, "");	//jinge
		} else {
			System.out.println("SEALPATH_x86 ...");
			ret = OfdSeal.init(SEALPATH_x86, "");
		}

		System.out.println(String.format("SealSign : ret = %d", ret));

		if (ret == 0)				
		{
			OfdRef hErr = OfdErr.init();
			//加载签章库中的电子印章 第一个参数:"id|索引|密码(默认12345678)"
			// OfdRef hSeal = OfdSeal.loadSeal("35010100003095|31|12345678", 0, 0, "", hErr);
			long hSeal = OfdSeal.loadSeal("35010100003331|1|12345678", 0, 0, "", hErr);
			int err_id = OfdErr.getInt(hErr);
			System.out.println(String.format("SealSign : err_id = %d", err_id));
			if (hSeal != 0 && err_id == 0)
			{
				//使用电子印章盖章文件 1.印章 2.文件地址 3.盖章后生成的文件
				//多页盖章
				//int s = OfdSeal.signfp(hSeal, OFD_FILE, OFD_SIGNATUREFILE, 0, 100, 100, 50, 50, 1);
				//单页盖章
				int s = OfdSeal.sign(hSeal, OFD_FILE, OFD_SIGNATUREFILE, 0, 100, 100, 1);
				System.out.println("OfdSeal.sign s="+s);

				if (s == 0)
					System.out.println("OfdSeal.sign 1 suc");
				else
					System.out.println("OfdSeal.sign 1 fail");
			}
			//卸载签章库中的电子印章
			OfdSeal.unLoadSeal(hSeal);
			//获取签章个数 1.文件地址
			int c = OfdSeal.countSign(OFD_SIGNATUREFILE);
			System.out.println(String.format("SealSign : c = %d", c));
			//验证签章 1.文件地址 2签名索引
			int v = OfdSeal.verify(OFD_SIGNATUREFILE, 0, 0);
			if (v == 0)
				System.out.println("OfdSeal.verify 1 suc");
			else
				System.out.println("OfdSeal.verify 1 fail");

		}

		OfdSeal.destory();
	}
	
	public void SealSign2()
	{
		System.out.println("SealSign beg ...");
		int ret = 0;

		String arch = System.getProperty("os.arch");
		//加载签章库
		if (arch.contains("64")) {
			System.out.println("SEALPATH_x64 ...");
			//ret = OfdSeal.init(SEALPATH_x64, "111111");	//fangzheng
			ret = OfdSeal.init(SEALPATH_x64, "");	//jinge
		} else {
			System.out.println("SEALPATH_x86 ...");
			ret = OfdSeal.init(SEALPATH_x86, "");
		}

		System.out.println(String.format("SealSign : ret = %d", ret));
		//文件存为缓存流
		File file = new File(OFD_FILE1);  
		long fileSize = file.length();
		System.out.println(String.format("fileSize = %d", fileSize));
		if (fileSize > Integer.MAX_VALUE) {  
			System.out.println("file too big...");  
			return;  
		}
		try
		{
			FileInputStream fi = new FileInputStream(file);

			byte[] buffer = new byte[(int) fileSize];
			int offset = 0;
			int numRead = 0;
			while (offset < buffer.length
			&& (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
				offset += numRead;
			}

			if (offset != buffer.length) {  
			throw new IOException("Could not completely read file "  
				+ file.getName());
			}  
			fi.close();  

			OfdRef hErr = OfdErr.init();
			//加载签章库中的电子印章 第一个参数:"id|索引|密码(默认12345678)"
			// OfdRef hSeal = OfdSeal.loadSeal("35010100003095|31|12345678", 0, 0, "", hErr);
			long hSeal = OfdSeal.loadSeal("35010100003331|1|12345678", 0, 0, "", hErr);
			int err_id = OfdErr.getInt(hErr);
			System.out.println(String.format("SealSign : err_id = %d", err_id));
			byte[] s=null;
			if (hSeal != 0 && err_id == 0) {
				System.out.println(String.format("sign3 331"));
				 s= OfdSeal.sign2(hSeal, buffer, 0, 100, 100,hErr, 1);
				 err_id = OfdErr.getInt(hErr);
				System.out.println(String.format("sign3 333="+err_id));
				
			}

			FileOutputStream fos = new FileOutputStream(OFD_SIGNATUREFILE2);
			fos.write(s, 0, s.length);
			fos.close();
		}
		catch(Exception e)
		{

		}
		OfdSeal.destory();
	}
	
	
	
	private String OFD_FILE1 = "../testcase/src1.ofd";
	private String OFD_SIGNATUREFILE2 = "../testcase/src2_sign.ofd";
	public void SealStraddleSign()
	{
		int ret = 0;

		String arch = System.getProperty("os.arch");
		if (arch.contains("64")) {
			ret = OfdSeal.init(SEALPATH_x64, "");
		} else {
			ret = OfdSeal.init(SEALPATH_x86, "");
		}

		if (ret == 0)				
		{
			OfdRef hErr = OfdErr.init();
//			OfdRef hSeal = OfdSeal.loadSeal("14A3DE100DBD4592BB5444B0AE814ACA", 0, 0, "", hErr);
			long hSeal = OfdSeal.loadSeal("35010100003331|1|12345678", 0, 0, "", hErr);
			int err_id = OfdErr.getInt(hErr);
			System.out.println(String.format("err_id 2 = %d", err_id));

			if (hSeal != 0 && err_id == 0)
			{
				System.out.println(String.format("sign3 112"));

				File file = new File(OFD_FILE1);  
				long fileSize = file.length();
				System.out.println(String.format("fileSize = %d", fileSize));
				if (fileSize > Integer.MAX_VALUE) {  
					System.out.println("file too big...");  
					return;  
				}

				try
				{
					FileInputStream fi = new FileInputStream(file);

					byte[] buffer = new byte[(int) fileSize];
					int offset = 0;
					int numRead = 0;
					while (offset < buffer.length
					&& (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
						offset += numRead;
					}

					if (offset != buffer.length) {  
					throw new IOException("Could not completely read file "  
						+ file.getName());
					}  
					fi.close();  

					System.out.println(String.format("sign3 331"));
					int lock = 0;
					byte[] s = OfdSeal.sign3(hSeal, buffer, hErr, lock);
					System.out.println(String.format("sign3 333"));

					FileOutputStream fos = new FileOutputStream(OFD_SIGNATUREFILE2);
					fos.write(s, 0, s.length);
					fos.close();
				}
				catch(Exception e)
				{

				}

			}
			OfdSeal.unLoadSeal(hSeal);

			int c = OfdSeal.countSign(OFD_SIGNATUREFILE2);
			System.out.println(String.format("sig count = %d", c));
			int v = OfdSeal.verify(OFD_SIGNATUREFILE2, 0, 0);
			if (v == 0)
				System.out.println("OfdSeal.verify 1 suc");
			else
				System.out.println("OfdSeal.verify 1 fail");
		}

		OfdSeal.destory();
	}
	
	private String _fileCert = "../testcase/htfoxit.pfx";
	private String _outfilesign = "../testcase/blank_signed.ofd";
	public void CertSign()
	{
		try
		{
		System.out.println("ofdSign beg ...");

		byte[] buf2 = getContent(OFD_FILE);
		if(buf2 == null)
			return;

		System.out.println(String.format("ofdSign buf2 len = %d", buf2.length));


		System.out.println("ofdSign 111 ...");
		byte[] ofdOutBuf = OfdCert.sign2(buf2, "", _fileCert, "111111");
		
		System.out.println("ofdSign 222 ...");

		if(ofdOutBuf != null)
		{
			FileOutputStream out = new FileOutputStream(_outfilesign);
			out.write(ofdOutBuf,0,ofdOutBuf.length);
 			out.flush();
 			out.close();
			System.out.println(String.format("ofdOutBuf.length =%d", ofdOutBuf.length));
			System.out.println("sign success!!!");
		}
		else
		{
			System.out.println("sign failed!!!");
		}
		int countSign = OfdCert.countSign2(ofdOutBuf,"htfoxit");
		System.out.println(String.format("count Sign =%d", countSign));

		int ret_sign = OfdCert.verify2(ofdOutBuf,0,"htfoxit");

		System.out.println(String.format("ret_sign =%d", ret_sign));
		}
		catch (IOException e)  
        {  
				System.out.println("IOException e");
        }  
		finally  
        {  
        }  
	}
	
	public void CertSign1() {
		int sign1 = OfdCert.sign1(OFD_FILE,_outfilesign,"", _fileCert,"111111");
		System.out.println("sign1="+sign1);
	}
	

}
