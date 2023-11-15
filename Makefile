build:
	mkdir -p build
	javac src/fr/iutfbleau/but2/SAE31_2023/*.java -d build
	
build dev:
	mkdir -p build
	javac src/fr/iutfbleau/but2/SAE31_2023/developpeur/*.java -d build

run dev:
	java -cp "src/fr/iutfbleau/but2/SAE31_2023/mariadb-java-client-1.8.0.jar:build:" Main

	
run:
	java -cp "src/fr/iutfbleau/but2/SAE31_2023/mariadb-java-client-1.8.0.jar:build:" Main

clean:
	rm -f build/*class
start:
	mkdir -p build
	javac src/fr/iutfbleau/but2/SAE31_2023/*.java -d build -encoding utf-8
	java -cp "src/fr/iutfbleau/but2/SAE31_2023/mariadb-java-client-1.8.0.jar:build:" Main

