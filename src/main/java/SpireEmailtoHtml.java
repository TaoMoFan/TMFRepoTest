import com.spire.xls.*;
/**
 * @Author taomofan
 * @Date 2021/1/25 2:09 下午
 * @Version 1.0
 */
public class SpireEmailtoHtml {
public static void main(String[] args) {
    Workbook wb = new Workbook();
    wb.loadFromFile("/Users/Code/IdeaProjects/File/exportExcel.xlsx");
    Worksheet sheet = wb.getWorksheets().get(0);
    sheet.saveToHtml("/Users/Code/IdeaProjects/File/ToHtml.html");
}
}
