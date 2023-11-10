build:
	mkdir -p build
	javac src/fr/iutfbleau/but2/SAE31_2023/*.java -d build
	
run:
	java -cp "src/fr/iutfbleau/but2/SAE31_2023/mariadb-java-client-1.8.0.jar:build:" Main
start:
	mkdir -p build
	javac src/fr/iutfbleau/but2/SAE31_2023/*.java -d build
	java -cp "src/fr/iutfbleau/but2/SAE31_2023/mariadb-java-client-1.8.0.jar:build:" Main
clean:
	rm -f build/*class
