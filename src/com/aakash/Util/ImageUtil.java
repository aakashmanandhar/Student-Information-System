package com.aakash.Util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.Part;

public class ImageUtil {

	public static final String IMAGE_UPLOAD_PATH = "/home/aakashmanandhar/Pictures/ImageUpload/";

	public static String writeImageToFile(Part part, String imageUrl) {

		InputStream in = null;
		OutputStream out = null;

		try {
			in = part.getInputStream();
			out = new FileOutputStream(imageUrl);

			int len;
			byte[] bytes = new byte[1024];

			while ((len = in.read(bytes)) != -1) {
				out.write(bytes, 0, len);
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return imageUrl;

	}

	public static String getFileName(Part part) {

		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}

		return null;

	}
}
