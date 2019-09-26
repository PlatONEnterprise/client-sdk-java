# Overview
> Java SDK is a Java development kit for PlatONE chain provided by PlatONE for Java developers.

# Build
```
git clone https://github.com/PlatONEnetwork/client-sdk-java.git
cd client-sdk-java/
./gradlew clean jar            //Generate jar package
./gradlew clean distZip        //Generate code generation skeleton tool
   
``` 

# Use

* import compiled .jar file into local maven cache(~/.m2) manually
* config maven or gradle in project

```
<dependency>
    <groupId>com.platone.client</groupId>
    <artifactId>core</artifactId>
    <version>0.4.1</version>
</dependency>
```

or

```
compile "com.platone.client:core:0.4.1"
```

* use in project

```
Web3j web3 = Web3j.build(new HttpService("https://host:port"));
```

