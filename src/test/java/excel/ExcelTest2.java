package excel;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExcelTest2 {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("C:\\Users\\dailongwen\\Desktop\\ceshi.xlsx");
        try {
            // 解析每行结果在listener中处理
            ExcelListener listener = new ExcelListener();

            ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, listener);
            excelReader.read(new Sheet(0,2, VendorEntity.class));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
