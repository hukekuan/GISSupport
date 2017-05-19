package com.gis3c.entity;

import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageEncoder;
import com.sun.media.jai.codec.PNGEncodeParam;
import org.geotools.geometry.jts.ReferencedEnvelope;
import org.geotools.map.MapContent;
import org.geotools.renderer.GTRenderer;
import org.geotools.renderer.lite.StreamingRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class C3Map extends MapContent {
    public C3Map(){
        super();
    }

    public void ExportImg(double x1,double y1,double x2,double y2,int width,int height)
            throws IOException {
        //设置出图范围
        ReferencedEnvelope mapArea
                = new ReferencedEnvelope(x1,x2,y1,y2,this.getCoordinateReferenceSystem());

        //初始化渲染器
        StreamingRenderer sr = new StreamingRenderer();
        sr.setMapContent(this);
        //初始化输出图像
        BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        Graphics g = bi.getGraphics();
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        Rectangle rect = new Rectangle(0,0,width,height);

        //绘制地图
        sr.paint((Graphics2D) g,rect,mapArea);

        //编码图像
        PNGEncodeParam encodeParam = PNGEncodeParam.getDefaultEncodeParam(bi);
        if(encodeParam instanceof PNGEncodeParam.Palette){
            PNGEncodeParam.Palette p = (PNGEncodeParam.Palette) encodeParam;
            byte[] b = new byte[]{-127};
            p.setPaletteTransparency(b);
        }

        //输出图像
        ImageEncoder encode = ImageCodec.createImageEncoder("PNG",null,encodeParam);
        encode.encode(bi.getData(),bi.getColorModel());
    }

    public void saveImage(final String file,final int imageWidth) throws IOException {
        GTRenderer renderer = new StreamingRenderer();
        renderer.setMapContent(this);

        ReferencedEnvelope mapBounds
                = new ReferencedEnvelope(117.45335889533,121.20518244635,35.753480445714,37.557981231236,this.getCoordinateReferenceSystem());
//                = this.getMaxBounds();


        double heightToWidth = mapBounds.getSpan(1)/mapBounds.getSpan(0);
        Rectangle imageBounds
//                = new Rectangle(0,0,imageWidth, (int) Math.round(imageWidth*heightToWidth));
                = new Rectangle(0,0,256, 256);

        BufferedImage image = new BufferedImage(imageBounds.width,imageBounds.height,BufferedImage.TYPE_INT_RGB);

        Graphics2D gr = image.createGraphics();
        gr.setPaint(Color.WHITE);
        gr.fill(imageBounds);

        renderer.paint(gr,imageBounds,mapBounds);
        File fileToSave = new File(file);
        ImageIO.write(image,"jpeg",fileToSave);
    }
}
