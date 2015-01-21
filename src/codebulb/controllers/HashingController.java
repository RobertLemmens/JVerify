package codebulb.controllers;

import codebulb.engines.MD5Engine;
import codebulb.engines.Sha1Engine;
import codebulb.engines.Sha2Engine;
import codebulb.engines.Sha5Engine;
import codebulb.factories.HashedFilesFactory;

import java.io.File;

/**
 * Created by Robert on 18-1-2015.
 */
public class HashingController {

    private MD5Engine md5Engine;
    private Sha1Engine sha1Engine;
    private Sha2Engine sha2Engine;
    private Sha5Engine sha5Engine;

    private HashedFilesFactory hashedFilesFactory;

    public HashingController(HashedFilesFactory hashedFilesFactory) {
        this.hashedFilesFactory = hashedFilesFactory;
        md5Engine = new MD5Engine();
        sha1Engine = new Sha1Engine();
        sha2Engine = new Sha2Engine();
        sha5Engine = new Sha5Engine();
    }

    public void createMD5Checksum(File file) {
        md5Engine.setFile(file);
        md5Engine.runHasher();
        hashedFilesFactory.add(file); // add methode checkt zelf of dat het bestand al in de lijst zit of niet.Om duplicate files te voorkomen
        hashedFilesFactory.addMd5ToFile(file.getName(), md5Engine.getChecksum());
    }

    public void createSha1Checksum(File file) {
        sha1Engine.setFile(file);
        sha1Engine.runHasher();
        hashedFilesFactory.add(file);
        hashedFilesFactory.addSha1ToFile(file.getName(), sha1Engine.getChecksum());
    }

    public void createSha2Checksum(File file) {
        sha2Engine.setFile(file);
        sha2Engine.runHasher();
        hashedFilesFactory.add(file);
        hashedFilesFactory.addSha2ToFile(file.getName(), sha2Engine.getChecksum());
    }

    public void createSha5Checksum(File file) {
        sha5Engine.setFile(file);
        sha5Engine.runHasher();
        hashedFilesFactory.add(file);
        hashedFilesFactory.addSha5ToFile(file.getName(), sha5Engine.getChecksum());
    }
}
