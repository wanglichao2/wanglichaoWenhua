package com.iss.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@SuppressWarnings("restriction")
public class CompressImage {
	/**
	 * 按等比例压缩图片文件
	 * @param byte
	 * @param r_width
	 * @param r_height
	 * @return byte
	 * @throws IOException
	 */
	public static byte[] compressRatioPic(byte[] buf, int r_width, int r_height) throws IOException {
		InputStream in = new ByteArrayInputStream(buf);
		return compressRatioPic(in, r_width, r_height, 0);
	}
	
	/**
	 * 按等比例压缩图片文件
	 * @param byte
	 * @param r_width
	 * @param r_height
	 * @param quality
	 * @return byte
	 * @throws IOException
	 */
	public static byte[] compressRatioPic(byte[] buf, int r_width, int r_height, float quality) throws IOException {
		InputStream in = new ByteArrayInputStream(buf);
		return compressRatioPic(in, r_width, r_height, quality);
	}
	
	/**
	 * 按等比例压缩图片文件
	 * @param in
	 * @param r_width
	 * @param r_height
	 * @param quality
	 * @return byte
	 * @throws IOException
	 */
	public static byte[] compressRatioPic(InputStream in, int r_width, int r_height) throws IOException {
		return compressRatioPic(in, r_width, r_height, 0);
	}
	
	/**
	 * 按等比例压缩图片文件
	 * @param in
	 * @param r_width
	 * @param r_height
	 * @param quality
	 * @return byte
	 * @throws IOException
	 */
	public static byte[] compressRatioPic(InputStream in, int r_width, int r_height, float quality) throws IOException {
		if(in == null){
			return null;
		}
		//根据缩放比率大的进行缩放控制
		Image img = ImageIO.read(in);
		double _width = img.getWidth(null);
		double _height = img.getHeight(null);
		//为等比缩放计算输出的图片宽度及高度
		double rate1 = _width / (double)r_width;
		double rate2 = _height / (double)r_height;
		// 根据缩放比率大的进行缩放控制
		double rate = rate1 > rate2 ? rate1 : rate2;
		int width = (int) (_width/rate);
		int height = (int) (_height/rate);
		//宽、高设定
		BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
		tag.getGraphics().drawImage(img.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
		//JPEGImageEncoder可适用于其他图片类型的转换
		ByteArrayOutputStream out =  new ByteArrayOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		if(quality>0){
			JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
			jep.setQuality(quality, true);
			encoder.encode(tag, jep);
		}else{
			encoder.encode(tag);
		}
		byte[] b = out.toByteArray();  
		out.close();
		return b;
	}
	
	/**
	 * 按等比例压缩图片文件
	 * @param in
	 * @param r_width
	 * @param r_height
	 * @param quality
	 * @return InputStream
	 * @throws IOException
	 */
	public static InputStream compressRatioPicIS(InputStream in, int r_width, int r_height) throws IOException {
		byte[] buf = compressRatioPic(in, r_width, r_height, 0);
		return new ByteArrayInputStream(buf);
	}
	
	/**
	 * 按等比例压缩图片文件
	 * @param in
	 * @param r_width
	 * @param r_height
	 * @param quality
	 * @return InputStream
	 * @throws IOException
	 */
	public static InputStream compressRatioPicIS(InputStream in, int r_width, int r_height, float quality) throws IOException {
		byte[] buf = compressRatioPic(in, r_width, r_height, quality);
		return new ByteArrayInputStream(buf);
	}
	
	/**
	 * 按宽度高度压缩图片文件
	 * @param buf
	 * @param width
	 * @param height
	 * @return byte
	 * @throws IOException
	 */
	public static byte[] compressPic(byte[] buf, int width, int height) throws IOException {
		InputStream in = new ByteArrayInputStream(buf);
		return compressPic(in, width, height, 0);
	}
	
	/**
	 * 按宽度高度压缩图片文件
	 * @param buf
	 * @param width
	 * @param height
	 * @param quality
	 * @return byte
	 * @throws IOException
	 */
	public static byte[] compressPic(byte[] buf, int width, int height, float quality) throws IOException {
		InputStream in = new ByteArrayInputStream(buf);
		return compressPic(in, width, height, quality);
	}
	
	/**
	 * 按宽度高度压缩图片文件
	 * @param buf
	 * @param width
	 * @param height
	 * @return byte
	 * @throws IOException
	 */
	public static byte[] compressPic(InputStream in, int width, int height) throws IOException {
		return compressPic(in, width, height, 0);
	}
	
	/**
	 * 按宽度高度压缩图片文件
	 * @param in
	 * @param width
	 * @param height
	 * @return byte
	 * @throws IOException
	 */
	public static byte[] compressPic(InputStream in, int width, int height, float quality) throws IOException {
		if(in == null || width<0 || height<0){
			return null;
		}
		Image img = ImageIO.read(in);
		BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
		tag.getGraphics().drawImage(img.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
		//JPEGImageEncoder可适用于其他图片类型的转换
		ByteArrayOutputStream out =  new ByteArrayOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		if(quality>0){
			JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
			jep.setQuality(quality, true);
			encoder.encode(tag, jep);
		}else{
			encoder.encode(tag);
		}
		byte[] b = out.toByteArray();  
		out.close();
		return b;
	}
	
	/**
	 * 按宽度高度压缩图片文件
	 * @param in
	 * @param width
	 * @param height
	 * @return InputStream
	 * @throws IOException
	 */
	public static InputStream compressPicIS(InputStream in, int width, int height) throws IOException {
		byte[] buf = compressPic(in, width, height, 0);
		return new ByteArrayInputStream(buf);  
	}
	
	/**
	 * 按宽度高度压缩图片文件
	 * @param in
	 * @param width
	 * @param height
	 * @param quality
	 * @return InputStream
	 * @throws IOException
	 */
	public static InputStream compressPicIS(InputStream in, int width, int height, float quality) throws IOException {
		byte[] buf = compressPic(in, width, height, quality);
		return new ByteArrayInputStream(buf);  
	}
}