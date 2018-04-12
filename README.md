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
![gui1](https://raw.githubusercontent.com/RobertLemmens/JVerify/master/src/codebulb/images/tut1.png)

1. The drop area. You can drop a file in here to hash it, or click on it to open the filechooser.
2. Paste a hash here to compare it with the selected hashed file in the combobox (3).

![gui1](https://raw.githubusercontent.com/RobertLemmens/JVerify/master/src/codebulb/images/tut3.png)

This pane shows the results of all individually dropped items. You get here by clicking view -> results in the menu bar.

### Foldertracking

The main power of this tool is the ability to hash and track an entire folder. After starting the thread, everytime you add something to the folder, the application will update the MD5's or SHA's in regular intervals and add it to the resultpane.

![gui1](https://raw.githubusercontent.com/RobertLemmens/JVerify/master/src/codebulb/images/tut2.png)

1. The textarea where the results from the foldertracking roll in. Its a scrollable pane.
2. Select a folder to track and hash files in.
3. Start or stop the hashing thread.
4. Export the results to a file called results.txt in the selected folder.
