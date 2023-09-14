package com.leetcode.algorithms.Custom.utils;

/**
 * @author JoeyYoung
 * @version 1.0.0
 * @ClassName WaterMarkUtils
 * @Description TODO
 * @createTime 2022/4/19 20:34
 */
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.util.ArrayList;

/**
 * 图片添加水印
 *
 * @author
 * @since 2021/3/11 8:23
 */
public class WaterMarkUtils {
    // 水印透明度
    private static float alpha = 0.5f;
    // 水印横向位置
    private static int positionWidth = 150;
    // 水印纵向位置
    private static int positionHeight = 300;
    // 水印文字字体
    private static Font font = new Font("宋体", Font.PLAIN, 36);
    // 水印文字颜色
    private static Color color = Color.white;
    // 用来调整水印的间距
    private static final int space = 20;

    /**
     * @param srcImgFile       待添加水印的图片
     * @param outImgPath       添加完成的输出路径
     * @param markContentColor 文字颜色
     * @param waterMarkContent 水印内容, 需要换行用||连接
     */
    public static void drawCaterMark(String srcImgFile, String outImgPath, Color markContentColor, String waterMarkContent) {
        try {
            String[] waterMarkContents = waterMarkContent.split("_");
            // 读取原图片信息
            Image srcImg = ImageIO.read(new File(srcImgFile));
            int srcImgWidth = srcImg.getWidth(null);
            int srcImgHeight = srcImg.getHeight(null);
            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            // 得到画笔对象
            Graphics2D g = bufImg.createGraphics();
            // 设置起点
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            int fontSize = srcImg.getWidth(null) / 300 * 10;
            int plain = Font.PLAIN;
            Font font = new Font("PingFang SC Regular", plain, 32);
            // 设置水印颜色
            g.setColor(markContentColor);
            // 设置水印文字字体
            g.setFont(font);
            // 设置透明度
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                    alpha));
            // 抗锯齿
            g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
            java.util.List<String> waterMarkContentList = new ArrayList<>();
            // 将换行后的文字放入新的集合
            for (String markContent : waterMarkContents) {
                // 单字符长度
                int tempCharLen = 0;
                // 单行字符总长度临时计算
                int tempLineLen = 0;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < markContent.length(); i++) {
                    char tempChar = markContent.charAt(i);
                    tempCharLen = getCharLen(tempChar, g);
                    tempLineLen += tempCharLen;
                    // 文字长度大于图片宽度-2*间距-字体大小
                    if (tempLineLen > srcImgWidth - space * 2 - tempCharLen) {
                        // 长度已经满一行
                        waterMarkContentList.add(sb.toString());
                        // 清空内容,重新追加
                        sb.delete(0, sb.length());
                        tempLineLen = 0;
                    }
                    // 追加字符
                    sb.append(tempChar);
                }
                waterMarkContentList.add(sb.toString());
            }

            // 绘制水印
            int tempY = fontSize + space;
            for (int i = 0; i < waterMarkContentList.size(); i++) {
                String s = waterMarkContentList.get(i);
                //左上角
//                g.drawString(s, space, i * tempY + 2 * space);
                //右下角
                g.drawString(s, space, srcImgHeight - (waterMarkContentList.size() - i) * tempY + space);
            }
            g.dispose();

            FileOutputStream outImgStream = new FileOutputStream(outImgPath);
            ImageIO.write(bufImg, "png", outImgStream);
            outImgStream.flush();
            outImgStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getCharLen(char c, Graphics2D g) {
        return g.getFontMetrics(g.getFont()).charWidth(c);
    }

    /**
     *
     * @param alpha
     *            水印透明度
     * @param positionWidth
     *            水印横向位置
     * @param positionHeight
     *            水印纵向位置
     * @param font
     *            水印文字字体
     * @param color
     *            水印文字颜色
     */
    public static void setImageMarkOptions(float alpha, int positionWidth,
                                           int positionHeight, Font font, Color color) {
        if (alpha != 0.0f)
            WaterMarkUtils.alpha = alpha;
        if (positionWidth != 0)
            WaterMarkUtils.positionWidth = positionWidth;
        if (positionHeight != 0)
            WaterMarkUtils.positionHeight = positionHeight;
        if (font != null)
            WaterMarkUtils.font = font;
        if (color != null)
            WaterMarkUtils.color = color;
    }


    /**
     * 获取水印文字总长度
     *
     * @param waterMarkContent 水印的文字
     * @param g                绘图方法
     * @return 水印文字总长度
     */
    public static int getWatermarkLength(String waterMarkContent, Graphics2D g) {
        return g.getFontMetrics(g.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());
    }

    public static void main(String[] args) throws MalformedURLException {
        drawCaterMark("D://tmp/1.jpg", "D://tmp/2.jpg", Color.getColor("#FFFFFF"), "2021-10-23 14:15:09" + "_" + "江苏省南京市雨花台区雨花南路2号");
    }


}

