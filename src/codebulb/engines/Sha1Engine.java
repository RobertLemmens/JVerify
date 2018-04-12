package codebulb.engines;

import codebulb.interfaces.HashEngineInterface;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Robert on 18-1-2015.
 *
 * This class is in charge of creating the sha1 hashes
 */
public class Sha1Engine implements HashEngineInterface{

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
     * Start hashing process
     */
    @Override
    public void runHasher() {
        result = "";
        getSHA1Checksum();
    }

    /**
     * Return the result from hashing
     *
     * @return hashresult
     */
    @Override
    public String getChecksum() {
        return result;
    }

    /**
     * Create the sha1 checksum
     *
     * @return byte array.
     */
    private byte[] createChecksum() {

        try {
            InputStream fis = new FileInputStream(file);

            byte[] buffer = new byte[1024];
            MessageDigest complete = MessageDigest.getInstance("SHA1");
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
     * Convert the checksum to normal sh1 string
     *
     * @return
     */
    private String getSHA1Checksum() {
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
