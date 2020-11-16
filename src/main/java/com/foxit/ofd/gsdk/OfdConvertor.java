package com.foxit.ofd.gsdk;

/**
* @brief OfdConvertor
*/
public class OfdConvertor
{
	public final static int OFD_ERR_CONVERT_LICENSEFILE = 1000;		// license file error
	public final static int OFD_ERR_CONVERT_PARAMETER = 1001;		// parameter error
	public final static int OFD_ERR_CONVERT_COMMON = 1002;			// common error

	public final static int OFD_ERR_CONVERT_OPENFILE = 1020;		// file open error
	public final static int OFD_ERR_CONVERT_CREATEFILE = 1021;		// file create error
	public final static int OFD_ERR_CONVERT_FILEEXIST = 1022;		// file not exist error
	public final static int OFD_ERR_CONVERT_FILEFORMAT = 1024;		// file format error
	public final static int OFD_ERR_CONVERT_INVALIDPATH = 1023;		// invalid file path error

	public final static int OFD_ERR_CONVERT_OFDPACKAGE = 1040;		// ofd file package error
	public final static int OFD_ERR_CONVERT_OFDPARSER = 1041;		// parser ofd error
	public final static int OFD_ERR_CONVERT_GETOFDDOC = 1042;		// get ofd document error

	public final static int OFD_ERR_CONVERT_PDFPARSER = 1060;		// parser pdf error
	public final static int OFD_ERR_CONVERT_GETPDFDOC = 1061;		// get pdf document error
	public final static int OFD_ERR_CONVERT_PDFCONVERT = 1062;		// convert pdf error

	public final static int OFD_ERR_CONVERT_EXCEPTION = 1080;		// exception error,try catch

	public final static int OFD_ERR_CONVERT_TIFMODULE = 1090;		// tif moudle decoder error
	public final static int OFD_ERR_CONVERT_LOADFRAME = 1091;		// tif load frame error
	public final static int OFD_ERR_CONVERT_TIFDECODER = 1092;		// tif file decoder error
	public final static int OFD_ERR_CONVERT_IMGDECODER = 1093;		// img file decoder error

	public final static int OFD_ERR_CONVERT_WPSCOMMAND = 1110;		// wps command execute error
	public final static int OFD_ERR_CONVERT_ETCOMMAND = 1111;		// et command execute error
	public final static int OFD_ERR_CONVERT_PDFCOMMAND = 1112;		// pdf toolkit command execute error

/**
	 * @brief Transfer from other document format to OFD, or reverse.
	 *
	 * @param[in]	fileSrc		The source file.	
	 * @param[in]	fileDst		The converted file.
	 * @param[in]	param		The convert param.
	 * @return Error code.
	 *				
	 */
	public static native int		convert(String fileSrc, String fileDst, long param);

	public final static int OFD_CONTYPE_PDF2OFD = 0;		// pdf 2 ofd convert
	public final static int OFD_CONTYPE_OFD2PDF = 1;		// ofd 2 pdf convert
	/**
	 * @brief Transfer from other document format to OFD, or reverse.
	 *
	 * @param[in]	fileSrc		The source file stream.	
	 * @param[in]	type		The convert type.
	 * @param[in]	param		The convert param.
	 * @return dst file stream.
	 *				
	 */
	public static native byte[]		convert2(byte[] fileSrc, int type, long param);

	/**
	 * @brief Transfer from other txt file to OFD file.
	 *
	 * @param[in]	dllDir		The fxofd2txt.dll file.
	 * @param[in]	txtFile		The txt file.
	 * @param[in]	ofdFile		The ofd file.
	 * @param[in]	param		The convert param.
	 * @return Error code.
	 *				
	 */
	public static native int		txt2OFD(String txtFile, String ofdFile, long param);

	/**
	 * @brief Transfer from other ofd file to txt file.
	 *
	 * @param[in]	ofdFile		The ofd file.
	 * @param[in]	txtFile		The txt file.
	 * @param[in]	param		The convert param.
	 * @return Error code.
	 *				
	 */
	public static native int		ofd2Txt(String ofdFile, String txtFile, long param);

	/**
	 * @brief Transfer from other pdf file to txt file.
	 *
	 * @param[in]	ofdFile		The pdf file.
	 * @param[in]	txtFile		The txt file.
	 * @return Error code.
	 *				
	 */
	public static native int		pdf2Txt(String pdfFile, String txtFile);

	/**
	 * @brief Start convert from image to OFD.
	 *
	 * @param[in]	fileDst		The converted OFD file.
	 * @return Image convet handle.
	 *				
	 */
	public static native long		startImage2OFD(String fileDst);

	/**
	 * @brief Add image to OFD.
	 *
	 * @param[in]	fileSrc			The image file.
	 * @param[in]	convetHandle	Image convet handle.
	 * @return.
	 *				
	 */
	public static native void		addImage2OFD(long convetHandle, String fileSrc, long param);

	/**
	 * @brief End convert from image to OFD.
	 * @param[in]	convetHandle	Image convet handle.
	 *
	 * @return Error code.
	 *				
	 */
	public static native long		endImage2OFD(long convetHandle);

	/**
	 * @brief Start convert from OFD to image.
	 *
	 * @param[in]	fileSrc		The converted OFD file.
	 * @return Image convet handle.
	 *				
	 */
	public static native long		startOFD2Image(String fileSrc, long param);

	/**
	 * @brief Start convert from OFD to image.
	 *
	 * @param[in]	src		The converted OFD file stream.
	 * @return Image convet handle.
	 *				
	 */
	public static native long		startOFD2Image2(byte[] src, long param);

	/**
	 * @brief Save OFD page to image.
	 *
	 * @param[out]	fileDst			The image file.
	 * @param[in]	convetHandle	Image convet handle.
	 * @return Error code.
	 *				
	 */
	public static native long		convertOFD2Image(long convetHandle, String fileDst, long param);

	/**
	 * @brief Save OFD page to image.
	 *
	 * @param[in]	convetHandle	Image convet handle.
	 * @return image file stream.
	 *				
	 */
	public static native byte[]		convertOFD2Image2(long convetHandle, long param);

	/**
	 * @brief End convert from OFD to image.
	 * @param[in]	convetHandle	Image convet handle.
	 *
	 * @return Error code.
	 *				
	 */
	public static native long		endOFD2Image(long convetHandle, long param);
	
	/**
	 * @brief Transfer from html file to OFD file.
	 *
	 * @param[in]	htmlFile		The html file.
	 * @param[in]	ofdFile			The ofd file.
	 * @param[in]	param			The convert param.
	 * @return Error code.
	 *				
	 */
	public static native int		html2OFD(String htmlFile, String ofdFile, long param);
	
	/**
	 * @brief Transfer from ofd file to word file.
	 *
	 * @param[in]	ofdFile			The ofd file.
	 * @param[in]	wordFile		The word file.
	 * @param[in]	param			The convert param.
	 * @return Error code.
	 *				
	 */
	public static native int		ofd2Word(String ofdFile, String wordFile, long param);

	/**
	 * @brief Transfer from ofd file to odt file.
	 *
	 * @param[in]	ofdFile			The ofd file.
	 * @param[in]	odtFile			The odt file.
	 * @param[in]	param			The convert param.
	 * @return Error code.
	 *				
	 */
	public static native int		ofd2Odt(String ofdFile, String odtFile, long param);
}
