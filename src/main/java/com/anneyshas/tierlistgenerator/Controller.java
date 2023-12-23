package com.anneyshas.tierlistgenerator;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.FileNotFoundException;

public class HelloController {

    @FXML private TextField theme;
    @FXML private TextArea sClass;
    @FXML private TextArea aClass;
    @FXML private TextArea bClass;
    @FXML private TextArea cClass;
    @FXML private TextArea dClass;
    @FXML private TextArea eClass;

    @FXML
    void showMessage(ActionEvent event){
        String themeTier = theme.getText();
        String s = sClass.getText();
        String a = aClass.getText();
        String b = bClass.getText();
        String c = cClass.getText();
        String d = dClass.getText();
        String e = eClass.getText();
        createPdf(themeTier, s, a, b, c, d, e);
        System.out.println(themeTier + "\n" + s + "\n" + a + "\n" + b + "\n" + c + "\n" + d + "\n" + e);
    }

    private void createPdf(String themeTier, String s, String a, String b, String c, String d, String e){
        try {
            PdfWriter writer = new PdfWriter("output.pdf");
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            Style heading = new Style().setFontSize(30);
            Style text = new Style().setFontSize(14);
            Table table = new Table(UnitValue.createPercentArray(new float[] {10, 90}));

            table.setMarginTop(5);
            table.addCell("S").setBackgroundColor(ColorConstants.RED);
            table.addCell(s);
            table.addCell("A").setBackgroundColor(ColorConstants.ORANGE);
            table.addCell(a);
            table.addCell("B").setBackgroundColor(ColorConstants.YELLOW);
            table.addCell(b);
            table.addCell("C").setBackgroundColor(ColorConstants.GREEN);
            table.addCell(c);
            table.addCell("D").setBackgroundColor(ColorConstants.CYAN);
            table.addCell(d);
            table.addCell("E").setBackgroundColor(ColorConstants.BLUE);
            table.addCell(e);

            Paragraph title = new Paragraph().add(new Text(themeTier).addStyle(heading));
            title.setTextAlignment(TextAlignment.CENTER);
            table.setHorizontalAlignment(HorizontalAlignment.CENTER);

            document.add(title);
            document.add(table);
            document.close();
            System.out.println("PDF created successfully.");
        } catch (FileNotFoundException error){
            error.printStackTrace();
        }
    }
}