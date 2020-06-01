

Steps to execute this project with Zalenium runing on Host machine Non Docker environment.

Pre-requisite:

1. Start zalenium in host machine.
    [update path as per your username]
    docker run --rm -ti --name zalenium -p 4444:4444 -v /var/run/docker.sock:/var/run/docker.sock -v /c/Users/ajakumar25/temp/videos:/home/seluser/videos --privileged dosel/zalenium start --screenWidth 1440 --screenHeight 810 --timeZone "IST"

2. Package project to create jar files to copy class files and tests,after every change in prject code.
    goto project directory -- run    mvn clean package -DskipTests (re-compile project to create updated jars)
3. goto cmd and type,  
    # start the java command inside target folder.
    java -cp selenium-docker.jar;selenium-docker-tests.jar;libs/* -DBROWSER=firefox org.testng.TestNG ../search-module.xml  [for firefox]
    java -cp selenium-docker.jar;selenium-docker-tests.jar;libs/* -DBROWSER=chrome org.testng.TestNG ../search-module.xml  [for chrome]


4. goto http://192.168.0.104:4444/dashboard/# to view result.

***************************************************************************
To run test using Docker file/Environment with zalenium.

1. Build docker image from docker file given in project. [Make sure docker file present inside project directory where target folder exists in same directory.]
2. goto cmd type :  docker build -t   demo2/docselenium .        [can give anyname instead demo2/docselenium]
3. run docker images to verify image build successfully.    
4. Run your docker image using command below.
    goto cmd type:        docker run -it --entrypoint=/bin/sh -v C:\Users\ajakumar25\resulttestdemo:/usr/share/udemy/test-output demo2/docselenium 
5. inside docker shell run ls -al    [all jars should be appear that copied in previous step.]
6. run inside shell  java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DHUB_HOST=192.168.0.104 -DBROWSER=firefox org.testng.TestNG search-module.xml [configure IP address of hub and xml file name as per requirement]
7. verify results on Zalenium dash board. http://192.168.0.104:4444/dashboard/# 

****To run directly your docker image from host machine skip steps 4,5,6, and use below command 8.
8. docker run -e HUB_HOST=192.168.0.104 -e MODULE=search-module.xml -e BROWSER=firefox -v C:\Users\ajakumar25\resulttestdemo:/usr/share/udemy/test-output demo2/docselenium 
   
    a.) Test result available on host C:\Users\ajakumar25\resulttestdemo
    b.) verify results on Zalenium dash board. http://192.168.0.104:4444/dashboard/#
    c.) change browser parameters as chrome/firefox
    d.) change hub host ip as per your Zalenium Ip.
    e.) change Module name as per your testng.xml that u want execute.

9. executing step 8 with docker compose file.

   version: "3"
   services:

  search-module:
    image: demo2/docselenium
    environment:
      - HUB_HOST=192.168.0.104
      - BROWSER=firefox
      - MODULE=search-module.xml
    volumes:
         - ./search_result:/usr/share/udemy/test-output

