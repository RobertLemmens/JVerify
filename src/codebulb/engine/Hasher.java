package codebulb.engine;

import sun.plugin2.message.Message;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;

/**
 * Created by Robert Lemmens on 6-10-2014.
 */
public class Hasher {

    private File file;

    public Hasher(File file) {
        this.file = file;
    }

    private byte[] createChecksum() throws
            Exception
    {
        InputStream fis =  new FileInputStream(file);

        byte[] buffer = new byte[1024];
        MessageDigest complete = MessageDigest.getInstance("MD5");
        int numRead;
        do {
            numRead = fis.read(buffer);
            if (numRead > 0) {
                complete.update(buffer, 0, numRead);
            }
        } while (numRead != -1);
        fis.close();
        return complete.digest();
    }


    // a byte array to a HEX string
    public String getMD5Checksum()  {
        byte[] b = new byte[0];
        try {
            b = createChecksum();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String result = "";
        for (int i=0; i < b.length; i++) {
            result +=
                    Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
        return result;
    }



    public void hashSHA1() {

    }

    public void hashSHA256() {

    }

    public void hashSHA512() {

    }

}
