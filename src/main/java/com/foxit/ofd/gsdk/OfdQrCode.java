package com.foxit.ofd.gsdk;


/**
* @brief OfdQrCode erweima
*/
public class OfdQrCode
{
	
	public static native	int	ConvertStr2Img(String srcString,String dstFile);

	public static native	byte[]	ConvertStr2ImgData(String srcString);

}
