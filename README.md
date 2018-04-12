# JVerify
An application to create MD5 and SHA-1/256/512 hashes and check for file integrity.

## usage
The program comes with two a cmd mode and a gui mode. The following examples all imply that you have build a fat jar called jverify.jar

### cmd mode
If you supply the executable with arguments it will automatically run in cmd mode. In cmd mode you can only create a hash or check a hash.

Supported arguments are ```-f <filepath>```, ```-m <sha1 or md5>``` and ```-h <hash to check agains>```

Creating a hash:
```bash
jverify.jar -f /path/to/file.txt -m md5
```

Checking a hash:
```bash
jverify.jar -f /path/to/file.txt -m md5 -h <md5HashToCheck>
```

### gui mode
Launching the program without arguments will fire up the gui.


### Foldertracking

The main power of this tool is the ability to track file changes and MD5/Sha-sums inside of specified folders. Everytime you add something to the folder, the application will update the MD5's or SHA's in regular intervals and add it to a manifest. Leaving you with nothing to worry about.
