import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import com.sun.xml.internal.txw2.DatatypeWriter;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.fit.pdfdom.PDFDomTree;
import sun.reflect.misc.FieldUtil;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test1 {

    public static void  main(String[] args) throws Exception{
        InputStream input = null;
        PdfReader reader = null;
        PdfStamper stamper = null;
        try {
            // 模板文件路径
            String templatePath = "C:/localFile/ExclusiveClaimForm.pdf";
            // 生成的文件路径
            String targetPath = "C:/localFile/form.pdf";

            input = new FileInputStream(new File(templatePath));
            reader = new PdfReader(input);
            stamper = new PdfStamper(reader, new FileOutputStream(targetPath));
            // 提取pdf中的表单
            AcroFields form = stamper.getAcroFields();
            form.addSubstitutionFont(BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED));


            form.setField("insuredStatement","\n保险标的：责任\n" +
                    "事故经过：Jinyy\n" +
                    "事故原因：外物倒塌" );//被保险人陈述
            form.setField("lossBreakdown","\n保险标的：责任\n" +
                    "事故经过：Jinyy\n" +
                    "事故原因：外物倒塌" );//损失明细
            stamper.setFormFlattening(true);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                if (stamper != null) stamper.close();
                if (reader != null) reader.close();
                if (input != null) input.close();
            } catch (Exception e) {
            }
        }
    }


    public void aaa(){
        System.out.println(this.getClass().getResource("").toString());
    }
}
