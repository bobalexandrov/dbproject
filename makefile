PROJECT_DIR=/home/oracle/projects/java/dbproject
JAR_DIR=${PROJECT_DIR}/lib

CP='.:${JAR_DIR}/cbadb.jar'
dbrun:
	javac -cp ${CP} $@.java

oracon:
	javac cbadb/$@.java
netezzacon:
	javac cbadb/$@.java
cbadb:
	jar cf $@.jar cbadb/oracon.class cbadb/netezzacon.class
	cp cbadb.jar ${JAR_DIR}

clean:
	rm -rf cbadb/oracon.class
	rm -rf cbadb/netezzacon.class
	rm -rf lib/cbadb.jar
	rm -rf cbadb/cbadb.jar
	rm -rf dbrun.class
