package com.leetcode.algorithms.Custom;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Random;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCodeUtils {
    private static final String CHARSET = "utf-8";
    private static final String FORMAT_NAME = "JPG";
    // 二维码尺寸
    private static final int QRCODE_SIZE = 300;
    // LOGO宽度
    private static final int WIDTH = 60;
    // LOGO高度
    private static final int HEIGHT = 60;

    private static BufferedImage createImage(String content, boolean needCompress) throws Exception {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
        hints.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE, hints);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000
                        : 0xFFFFFFFF);
            }
        }
        return image;
    }



    /**
     * 生成二维码
     *
     * @param content
     *            内容
     * @param destPath
     *            存放目录
     * @param needCompress
     *            是否压缩LOGO
     * @throws Exception
     */
    public static String encode(String content, String destPath,
                                boolean needCompress) throws Exception {
        BufferedImage image = QRCodeUtils.createImage(content, needCompress);
        mkdirs(destPath);
        String file = new Random().nextInt(99999999)+".jpg";
        ImageIO.write(image, FORMAT_NAME, new File(destPath+"/"+file));
        return file;
    }

    /**
     * 当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)
     * @date 2013-12-11 上午10:16:36
     * @param destPath 存放目录
     */
    public static void mkdirs(String destPath) {
        File file =new File(destPath);
        //当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }
    }

    /**
     * 生成二维码(内嵌LOGO)
     *
     * @param content
     *            内容
     * @param output
     *            输出流
     * @param needCompress
     *            是否压缩LOGO
     * @throws Exception
     */
    public static void encode(String content, OutputStream output, boolean needCompress) throws Exception {
        BufferedImage image = QRCodeUtils.createImage(content, needCompress);
        ImageIO.write(image, FORMAT_NAME, output);
    }

    /**
     * 生成二维码
     *
     * @param content
     *            内容
     * @param output
     *            输出流
     * @throws Exception
     */
    public static void encode(String content, OutputStream output)
            throws Exception {
        QRCodeUtils.encode(content, output, false);
    }

    /**
     * 生成二维码 base64
     *
     * @param content
     *            内容
     * @throws Exception
     */
    public static String encode(String content)
            throws Exception {
        BufferedImage image = QRCodeUtils.createImage(content, false);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", stream);
        return Base64Util.encode(stream.toByteArray());
    }

    /**
     * 解析二维码
     *
     * @param file
     *            二维码图片
     * @return
     * @throws Exception
     */
    public static String decode(File file) throws Exception {
        BufferedImage image;
        image = ImageIO.read(file);
        if (image == null) {
            return null;
        }
        BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(
                image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result;
        Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();
        hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
        result = new MultiFormatReader().decode(bitmap, hints);
        String resultStr = result.getText();
        return resultStr;
    }

    /**
     * 解析二维码
     *
     * @param path
     *            二维码图片地址
     * @return
     * @throws Exception
     */
    public static String decode(String path) throws Exception {
        return QRCodeUtils.decode(new File(path));
    }


    public static void main(String[] args) throws Exception {
        String text = "https://blog.csdn.net/weixin_43122090/article/details/103524097";  //这里设置自定义网站url
        String destPath = "D:\\tmp";
        String file = QRCodeUtils.encode(text, destPath, true);
        System.out.println(file);
        System.out.println(decode("D:\\tmp\\" + file));
    }
}

