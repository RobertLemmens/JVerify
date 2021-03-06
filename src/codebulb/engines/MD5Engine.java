package codebulb.engines;

import codebulb.interfaces.HashEngineInterface;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Robert on 18-1-2015.
 */
public class MD5Engine implements HashEngineInterface{

    private File file;
    private String result = "";

    /**
     * Set the file to hash
     *
     * @param file file to hash
     */
    @Override
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * Run the hashing process
     */
    @Override
    public void runHasher() {
        result = ""; // reset the resultfield upon running the hasher
        getMD5Checksum();
    }

    /**
     * Return the result
     *
     * @return
     */
    @Override
    public String getChecksum() {
        return result;
    }

    /**
     * Create MD5 checksum
     * @return md5 checksum byte array
     */
    private byte[] createChecksum() {

        try {
            InputStream fis = new FileInputStream(file);

            byte[] buffer = new byte[1024];
            MessageDigest complete = MessageDigest.getInstance("MD5");
            int numRead;
            do {
                numRead = fis.read(buffer);
                if(numRead > 0) {
                    complete.update(buffer, 0, numRead);
                }
            } while(numRead != -1);
            fis.close();

            return complete.digest();

        } catch (FileNotFoundException e) {
            System.out.println("Geen inputstream kunnen maken");
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Geen MD5 algoritme kunnen laden");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Bestand niet kunnen lezen");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Create normal md5 string from checksum
     *
     * @return
     */
    private String getMD5Checksum() {
        byte[] b = new byte[0];

        try {
            b = createChecksum();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(int i = 0; i < b.length; i++) {
            result += Integer.toString( (b[i] & 0xff) + 0x100, 16).substring( 1 );
        }
        return result;
    }

}
