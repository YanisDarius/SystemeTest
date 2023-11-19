build:
	mkdir -p build
	javac src/fr/iutfbleau/but2/SAE31_2023/*.java -d build

run:
	java -cp "src/fr/iutfbleau/but2/SAE31_2023/mariadb-java-client-1.8.0.jar:build:" Main

clean:
	rm -f build/*class
start:
	mkdir -p build
	javac src/fr/iutfbleau/but2/SAE31_2023/*.java -d build -encoding utf-8
	java -cp "mariadb-java-client-1.8.0.jar:build:" Main

archive:
	mkdir -p build
	javac src/fr/iutfbleau/but2/SAE31_2023/*.java -d build -encoding utf-8
	jar cf Developpeur.jar -C build/ .
	
archivestart :
	java -cp "Developpeur.jar:mariadb-java-client-1.8.0.jar:" Main arg1
