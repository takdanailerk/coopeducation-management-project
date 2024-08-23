package itsci.mju.coopeducation_management_project.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class PdfServiceImpl implements PdfService{

	
	public  ByteArrayInputStream generatePdfReport() {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(out);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            
         // สร้าง PdfFont จากฟอนต์ที่ต้องการ
            PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
            
         // เพิ่มข้อมูลลงใน PDF พร้อมกำหนดฟอนต์
            document.add(new Paragraph("Hello, World!")
                .setFontSize(18)
                .setFont(font));
            
            // ปิดเอกสาร
            document.close();

            return new ByteArrayInputStream(out.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
