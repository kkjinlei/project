import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class testClass {
    public  static void  main(String[] args) throws Exception{
        String str = "21.0";
        String s1 = str.substring(str.indexOf(".")+1);
        System.out.println(s1);

        Pattern pattern = Pattern.compile("[0]*");
        System.out.println(pattern.matcher(s1).matches());
    }


    public static void test1() throws Exception{
        // 模板文件路径
        String templatePath = "C:/localFile/thelastlast.pdf";
        System.out.println(templatePath);
        // 生成的文件路径
        String targetPath = "C:/localFile/222.pdf";
        // 书签名
        String fieldName = "sign";
        /* 图片路径 */
        String imagePath = "C:/localFile/image.jpg";
        // 读取模板文件
        InputStream input = new FileInputStream(new File(templatePath));
        PdfReader reader = new PdfReader(input);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(targetPath));
        // 提取pdf中的表单
        AcroFields form = stamper.getAcroFields();
        form.addSubstitutionFont(BaseFont.createFont("STSong-Light","UniGB-UCS2-H", BaseFont.NOT_EMBEDDED));
        System.out.println(form.getFields().size());
//        // 通过域名获取所在页和坐标,左下角为起点
//        int pageNo = form.getFieldPositions(fieldName).get(0).page;
//        Rectangle signRect = form.getFieldPositions(fieldName).get(0).position;
//        float x = signRect.getLeft();
//        float y = signRect.getBottom();
//        // 读图片
//        Image image = Image.getInstance(imagePath);
//        // 获取操作的页面
//        PdfContentByte under = stamper.getOverContent(pageNo);
//        // 根据域的大小缩放图片
//        image.scaleToFit(signRect.getWidth(), signRect.getHeight());
//        // 添加图片
//        image.setAbsolutePosition(x, y);
//        under.addImage(image);

        //添加文本内容
  //      File t = new File("C:/localFile/t.txt");

//        FileReader r = new FileReader(t);//定义一个fileReader对象，用来初始化BufferedReader
//        BufferedReader bReader = new BufferedReader(r);//new一个BufferedReader对象，将文件内容读取到缓存
//        StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
//        String s = "";
//        while ((s =bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
//            sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
//            System.out.println(s);
//        }
//        bReader.close();
        form.setField("accidentTime","2019-01-08");
        form.setField("user1","蒋介石");

        stamper.setFormFlattening(false);
        stamper.close();
        reader.close();
    }

    public static void test2() throws IOException {
//        FileOutputStream out = new FileOutputStream(new File("C:/localFile/test.txt"));
//        BufferedOutputStream br = new BufferedOutputStream(out);
//        br.write("sssssssssssssssssssssss".getBytes());
//        out.close();
//        br.close();
        int a = 9;
        List list =new ArrayList();
        list.add(a);
        System.out.println(list);
        a = 8;
        System.out.println(list);
    }



}
