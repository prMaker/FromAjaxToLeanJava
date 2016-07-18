import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;

/**
 * Created by Administrator on 2016/7/15.
 */
public class QrCodeTestCase {

    @Test
    public void qrCode() throws WriterException, IOException {
        String data = "MECARD:N:原始;ORG:长城科技;TEL:18205090306;" +
                "EMAIL:fankai@kaishengit.com;ADR:中国;;";
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET,"UTF-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(data,
                BarcodeFormat.QR_CODE,400,400,hints);

        MatrixToImageWriter.writeToStream(bitMatrix,"gif",
                new FileOutputStream("D:/qrcode.gif"));

    }

}
