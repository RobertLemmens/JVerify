package codebulb.controllers;

import codebulb.engines.MD5Engine;
import codebulb.engines.ShaEngine;

import java.io.File;

/**
 * Created by Robert on 18-1-2015.
 */
public class HashingController {

    private MD5Engine md5Engine;
    private ShaEngine shaEngine;

    public HashingController() {
        md5Engine = new MD5Engine();
        shaEngine = new ShaEngine();
    }

    public void createMD5Checksum(File file) {
        md5Engine.setFile(file);
        md5Engine.runHasher();
        System.out.println(md5Engine.getChecksum());
    }

    public void createShaChecksum(File file) {
        shaEngine.setFile(file);
        shaEngine.runHasher();
        System.out.println(shaEngine.getChecksum());
    }

}
