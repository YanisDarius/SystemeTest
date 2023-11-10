build:
	javac src/fr/iutfbleau/but2/SAE31_2023/*.java -d build
	mkdir -p build
run:
	java -cp "src/fr/iutfbleau/but2/SAE31_2023/mariadb-java-client-1.8.0.jar:build:" Main
clean:
	rm -f build/*class
