JAVAC = javac
JAVA = java
SRC_DIR = src/fr/iutfbleau/but2/SAE31_2023
BUILD_DIR = build
MAIN_CLASS = Main

LIB_DIR = src/fr/iutfbleau/but2/SAE31_2023/contro
LIBRARY_PATH = $(LIB_DIR)/mariadb-java-client-1.8.0.jar

SOURCES_CONTRO := $(wildcard $(SRC_DIR)/contro/*.java)
SOURCES_TESTEUR := $(wildcard $(SRC_DIR)/testeur/*.java)

CLASSES_CONTRO := $(patsubst $(SRC_DIR)/contro/%.java, $(BUILD_DIR)/contro/%.class, $(SOURCES_CONTRO))
CLASSES_TESTEUR := $(patsubst $(SRC_DIR)/testeur/%.java, $(BUILD_DIR)/testeur/%.class, $(SOURCES_TESTEUR))

$(BUILD_DIR)/contro/%.class: $(SRC_DIR)/contro/%.java
	@mkdir -p $(BUILD_DIR)/contro
	$(JAVAC) -cp $(LIBRARY_PATH) -d $(BUILD_DIR) $<

$(BUILD_DIR)/testeur/%.class: $(SRC_DIR)/testeur/%.java
	@mkdir -p $(BUILD_DIR)/testeur
	$(JAVAC) -cp $(LIBRARY_PATH) -d $(BUILD_DIR) $<

contro: $(CLASSES_CONTRO)
testeur: $(CLASSES_TESTEUR)

run: contro testeur
	$(JAVA) -cp $(LIBRARY_PATH):$(BUILD_DIR) $(MAIN_CLASS)

clean:
	rm -rf $(BUILD_DIR)

.PHONY: contro testeur run clean
