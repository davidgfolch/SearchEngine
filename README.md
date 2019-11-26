#Simple Search command line
##Build

Use gradle to create jar
Build include some tests

```
 gradle build jar
```

##Run

To execute:

```
java -jar build/libs/SimpleSearch.jar /media/slks/TOSHIBA_EXT/downloads/eBooks/
```

##Notes
- I couldn't get Sonarqube installed in my new Kubuntu, so I don't know how coverage percent is (neither if I could have some critical issues).
- DiacriticalHelper added at end of time (I hope nothing is broken).
 