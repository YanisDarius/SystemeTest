# Makefile
JAVAC = javac
JAVA = java
SRC_DIR = src
BUILD_DIR = build
LIB_DIR = src/fr/iutfbleau/but2/SAE31_2023/contro
MAIN_CLASS = Main  # Remplacez par votre classe principale
# Récupérer la liste des fichiers source Java
SOURCES := $(shell find $(SRC_DIR) -name "*.java")
# Construire la liste des fichiers .class
CLASSES := $(patsubst $(SRC_DIR)/%.java, $(BUILD_DIR)/%.class, $(SOURCES))
# Répertoire contenant le fichier JAR
LIBRARY_DIR = $(LIB_DIR)
# Chemin du fichier JAR
LIBRARY_PATH = $(LIBRARY_DIR)/mariadb-java-client-1.8.0.jar
# Compilation des fichiers source Java
$(BUILD_DIR)/%.class: $(SRC_DIR)/%.java
	@mkdir -p $(@D)
	$(JAVAC) -cp $(LIBRARY_PATH) -d $(BUILD_DIR) $<
# Cible par défaut pour tout compiler
all: $(CLASSES)
# Cible pour exécuter le programme
run: all
	$(JAVA) -cp $(LIBRARY_PATH):$(BUILD_DIR) $(MAIN_CLASS)
# Nettoyer les fichiers générés
clean:
	rm -rf $(BUILD_DIR)
.PHONY: all run clean
