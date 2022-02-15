package com.leetcode.algorithms.Custom;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auth sqy
 */
@Slf4j
public class PictureUtil {


    /**
     * 编辑图片,往指定位置添加文字
     * @param srcImgPath    :源图片路径
     * @param targetImgPath :保存图片路径
     * @param list          :文字集合
     */
    public static String writeImage(String srcImgPath, String targetImgPath, List<ImageDTO> list) {
        FileOutputStream outImgStream = null;
        String tempPath = "";
        try {
            //远程调用服务器地址
            URL url = new URL(srcImgPath);
            //请求图片源
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //读取原图片信息
            Image srcImg = ImageIO.read(connection.getInputStream());//文件转化为图片
            int srcImgWidth = srcImg.getWidth(null);//获取图片的宽
            int srcImgHeight = srcImg.getHeight(null);//获取图片的高
            //添加文字:
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            for (ImageDTO imgDTO : list) {
                g.setColor(imgDTO.getColor());                                  //根据图片的背景设置水印颜色
                g.setFont(imgDTO.getFont());                                    //设置字体
                g.drawString(imgDTO.getText(), imgDTO.getX(), imgDTO.getY());   //画出水印
            }
            g.dispose();
            // 输出图片
            tempPath = targetImgPath +"/new.png";
            System.out.println("输中=====================tempPath："+tempPath);
            outImgStream = new FileOutputStream(tempPath);
            ImageIO.write(bufImg, "png", outImgStream);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != outImgStream){

                    outImgStream.flush();
                    outImgStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return  tempPath;
    }



    /**
     *
     * @param file
     */
    public static void deleteFile(File file){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(int i=0; i<files.length; i++){
                deleteFile(files[i]);
            }
        }
        file.delete();
    }
    /**
     * 创建ImageDTO, 每一个对象,代表在该图片中要插入的一段文字内容:
     * @param text  : 文本内容;
     * @param color : 字体颜色(前三位)和透明度(第4位,值越小,越透明);
     * @param font  : 字体的样式和字体大小;
     * @param x     : 当前字体在该图片位置的横坐标;
     * @param y     : 当前字体在该图片位置的纵坐标;
     * @return
     */
    public static ImageDTO createImageDTO(String text,Color color,Font font,int x,int y){
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setText(text);
        imageDTO.setColor(color);
        imageDTO.setFont(font);
        imageDTO.setX(x);
        imageDTO.setY(y);
        System.out.println("imageDTO+"+imageDTO.toString());
        return imageDTO;
    }


    /**

     */
    public static String HandlerImg(String  srcImgPath,String tarImgPath,String name,String title,String no,String date) {
        GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
        String [] fontName=ge.getAvailableFontFamilyNames();

        //获取数据集合；
        ArrayList<ImageDTO> list = new ArrayList<>();
        list.add(PictureUtil.createImageDTO(title,new Color(0,190,134),new Font("黑体", Font.BOLD , 60), 190, 350));
        list.add(createImageDTO(name,new Color(62,62,62),new Font("黑体", Font.PLAIN , 33), 340, 587));
        list.add(createImageDTO(title,new Color(0,190,134),new Font("Microsoft YaHei", Font.PLAIN , 36), 660, 668));
        list.add(createImageDTO(no,new Color(62,62,62),new Font("Microsoft YaHei", Font.PLAIN , 22), 305, 918));
        list.add(createImageDTO(date,new Color(62,62,62),new Font("Microsoft YaHei", Font.PLAIN , 22), 308, 976));
        //操作图片:
        return   writeImage(srcImgPath, tarImgPath, list);

    }
}


/**
 * 存放文本内容的类
 */
@Setter
@Getter
class ImageDTO{
    //文字内容
    private String text;
    //字体颜色和透明度
    private Color color;
    //字体和大小
    private Font font;
    //所在图片的x坐标
    private int x;
    //所在图片的y坐标
    private int y;


}

