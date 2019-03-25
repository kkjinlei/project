import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class test3 {
    //pdf动态生成table方法
    public static void createPDF() throws IOException, DocumentException {

                Map<String, Object> cont = new HashMap<String, Object>();// 存储数据
                File a = new File("C:/localFile/t.txt");
                FileReader r = new FileReader(a);//定义一个fileReader对象，用来初始化BufferedReader
                BufferedReader bReader = new BufferedReader(r);//new一个BufferedReader对象，将文件内容读取到缓存
                StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
                String s = "";
                while ((s =bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
                    sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
                    System.out.println(s);
                }
                bReader.close();
                cont.put("xmh", "111");
                cont.put("hth", "222");
                cont.put("zpmc", "");
                cont.put("zpsm", "444");
                cont.put("zpzs", "555");
                cont.put("BDH", sb.toString());
                cont.put("bx", sb.toString());

                try {
                    //模板的路径
                    File fir = new File("C:/localFile//");

                    //生成文件的路径及文件名。
                    File outFile = new File("C:/localFile/委托创作合同.doc");

                    Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));

                    // 使用FileTemplateLoader
                    //指定模板路径
                    TemplateLoader templateLoader = null;
                    templateLoader = new FileTemplateLoader(fir);
                    String tempname = "快赔单.xml";

                    Configuration cfg = new Configuration();
                    cfg.setTemplateLoader(templateLoader);
                    Template t = cfg.getTemplate(tempname, "UTF-8");

                    t.process(cont, out);
                    out.flush();
                    out.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }


    }
public static void main(String[] args) throws Exception{
        createPDF();
}

}
