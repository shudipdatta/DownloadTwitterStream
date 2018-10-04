# DownloadTwitterStream

### Importing Project:
* Open “eclipse”, right click on “Package Explorer” window, click import.
* Select “Git”-> “Projects from Git” and click “next”.
* Select “clone url” and click “next”.
* Paste “https://github.com/shudipdatta/DownloadTwitterStream.git” in the “url” textbox, Change protocol to “git”, and click “next”. 
* Choose “Import existing project” and click “finish”.

### Referencing libraries:
* Right click on project and select “build path”-> “configure build path” ->”libraries”->”add external jars”.
* Go to "cloudera" -> "git" -> "DownloadTwitterStream" -> "lib" and select all jars and click ok.

### Tweets Stream:
* Run "TwitterStreamingAPI.java" and store as many tweets as you like and then stop the execution.
* All your downloaded tweets are now stored in "tweets.txt" file in JSON format
* See "sample_tweet" to understand the structure of a tweet.

### General Information (Cloudera):
* Operating System:         Mac -> Microsoft Remote Desktop, Windows -> Default Remote Desktop, Ubuntu -> Remmina
* Machine:                  cqs-cs6304-xxx.ats.mst.edu
* User:                     cloudera
* Default Password:         stu-pass
* Change Password Command:  sudo passwd cloudera

* "Firefox already running" error solve by command:     killall -SIGTERM firefox

### Install MongoDB in Cloudera:
* sudo chmod 777 '/etc/yum.repos.d/mongodb-org.repo' //to enable write permission to mongodb repository
* nano '/etc/yum.repos.d/mongodb-org.repo' //to open an editor to edit the repository file
* gpgcheck=0 //edit the line gpgcheck=0 to 1
* ctrl+O //press control + o to promt the 'save file'
* Enter //hit enter to save the file
* ctrl+X //press control + x to exit the editor
* sudo yum install -y mongodb-org //to install mongodb in your computer
* sudo /sbin/service mongod start //to start the mongodb service
* sudo /sbin/service mongod stop //to stop the mongodb service
